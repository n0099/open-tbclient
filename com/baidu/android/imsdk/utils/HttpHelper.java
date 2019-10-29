package com.baidu.android.imsdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.account.request.IMGetTokenByCuidRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.task.TaskManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ConnectTimeoutException;
@SuppressLint({"TrulyRandom"})
/* loaded from: classes6.dex */
public class HttpHelper {
    public static final int ERROR_EXCEPTION = -10;
    private static final int GET = 1;
    private static final int POST = 16;
    private static final int PUT = 256;
    public static final String TAG = HttpHelper.class.getSimpleName();
    private static Context mContext;

    /* loaded from: classes6.dex */
    public interface Request {
        Map<String, String> getHeaders();

        String getHost();

        String getMethod();

        byte[] getRequestParameter() throws NoSuchAlgorithmException;

        boolean shouldAbort();
    }

    /* loaded from: classes6.dex */
    public interface ResponseHandler {
        void onFailure(int i, byte[] bArr, Throwable th);

        void onSuccess(int i, byte[] bArr);
    }

    /* loaded from: classes6.dex */
    protected class Result {
        int errorCode;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        HttpURLConnection urlConnection = null;

        protected Result() {
        }
    }

    public static void executor(Context context, final Request request, final ResponseHandler responseHandler) {
        if (responseHandler != null) {
            if (context == null || request == null || TextUtils.isEmpty(request.getHost())) {
                responseHandler.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
            } else if (Utility.getRestApiDisable() && !(request instanceof IMGetTokenByCuidRequest)) {
                responseHandler.onFailure(1011, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR.getBytes(), null);
            } else if (!request.shouldAbort()) {
                if (mContext == null) {
                    mContext = context.getApplicationContext();
                }
                TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.utils.HttpHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        try {
                            if (!Request.this.getMethod().equals("GET") && !Request.this.getMethod().equals("POST") && !Request.this.getMethod().equals(HttpPut.METHOD_NAME)) {
                                responseHandler.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
                            }
                            if (Request.this.getMethod().equals("GET")) {
                                i = 1;
                            } else if (Request.this.getMethod().equals("POST")) {
                                i = 16;
                            } else {
                                i = 256;
                            }
                            HttpHelper.executor(i, Request.this.getHost(), Request.this.getRequestParameter(), Request.this.getHeaders(), responseHandler);
                        } catch (Exception e) {
                            LogUtils.d(HttpHelper.TAG, "Http Unknown exception");
                            responseHandler.onFailure(-1003, "Http Unknown exception".getBytes(), e);
                        }
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [135=4] */
    public static void executor(int i, String str, byte[] bArr, Map<String, String> map, ResponseHandler responseHandler) throws SocketTimeoutException, ConnectTimeoutException, MalformedURLException, IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            httpURLConnection = createConnection(i, str, bArr, map);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == -1) {
                    throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                }
                if (httpURLConnection.getResponseCode() != 200) {
                    LogUtils.d(TAG, "createConnection responsecode:" + responseCode);
                    responseHandler.onFailure(responseCode, "http response error".getBytes(), null);
                    if (0 != 0) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                InputStream inputStream2 = httpURLConnection.getInputStream();
                dealResonsResult(responseCode, inputStream2, responseHandler);
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    static HttpURLConnection createConnection(int i, String str, byte[] bArr, Map<String, String> map) throws SocketTimeoutException, ConnectTimeoutException, MalformedURLException, IOException {
        if ((i & 1) != 0) {
            if (bArr != null && bArr.length > 0) {
                str = str + "?" + new String(bArr);
            }
        } else if (bArr != null && bArr.length > 0) {
            LogUtils.d(TAG, "requestparamter:" + new String(bArr, "utf-8"));
        }
        LogUtils.d(TAG, "requestUrl:" + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (httpURLConnection == null) {
            LogUtils.e(TAG, "HttpURLConnection is null");
        }
        setConnectionHeader(httpURLConnection, map);
        setConnectionParametersForRequest(httpURLConnection, i, bArr, false);
        return httpURLConnection;
    }

    static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, int i, byte[] bArr, boolean z) throws IOException {
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        if (z) {
            httpURLConnection.setRequestProperty(Headers.CONTENT_ENCODING, "gzip");
        }
        httpURLConnection.setReadTimeout(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
        switch (i) {
            case 1:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 16:
                if (bArr != null && bArr.length > 0) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    if (z) {
                        LogUtils.d(TAG, "This is statistic, compress data");
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(dataOutputStream);
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.close();
                        return;
                    }
                    dataOutputStream.write(bArr);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 256:
                if (bArr != null && bArr.length > 0) {
                    httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                    httpURLConnection.setDoOutput(true);
                    DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.close();
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    public static void dealResonsResult(int i, InputStream inputStream, ResponseHandler responseHandler) {
        byte[] dealResonsResult = dealResonsResult(inputStream);
        LogUtils.d(TAG, "request response : " + new String(dealResonsResult));
        if (dealResonsResult == null || dealResonsResult.length == 0) {
            responseHandler.onFailure(-10, "IOException for inputStream".getBytes(), new IOException("IOException for inputStream"));
        } else {
            responseHandler.onSuccess(i, dealResonsResult);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, SGET, CONST_STR, INVOKE, MOVE_EXCEPTION, INVOKE, SGET, CONST_STR, INVOKE, MOVE_EXCEPTION] complete} */
    private static byte[] dealResonsResult(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        byte[] bArr2 = null;
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    LogUtils.e(LogUtils.TAG, "HttpHelper IOException for inputStream", e);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e2);
                        }
                    }
                }
            } catch (Throwable th) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e3);
                    }
                }
                throw th;
            }
        }
        bArr2 = byteArrayOutputStream.toByteArray();
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e4);
            }
        }
        return bArr2;
    }
}
