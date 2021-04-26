package com.baidu.android.imsdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.android.imsdk.account.request.IMGetTokenByCuidRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
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
/* loaded from: classes.dex */
public class HttpHelper {
    public static final String CONTENT_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_JSON = "application/json";
    public static final String COOKIE_KEY = "Cookie";
    public static final int ERROR_EXCEPTION = -10;
    public static final int GET = 1;
    public static final int POST = 16;
    public static final int PUT = 256;
    public static final String TAG = "HttpHelper";
    public static Context mContext;

    /* loaded from: classes.dex */
    public interface Request {
        int getConnectTimeout();

        String getContentType();

        Map<String, String> getHeaders();

        String getHost();

        String getMethod();

        int getReadTimeout();

        byte[] getRequestParameter() throws NoSuchAlgorithmException;

        boolean shouldAbort();
    }

    /* loaded from: classes.dex */
    public interface ResponseHandler {
        void onFailure(int i2, byte[] bArr, Throwable th);

        void onSuccess(int i2, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public static class ResponseResult {
        public int mErrorCode;
        public String mErrorMsg;

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public String getErrorMsg() {
            return this.mErrorMsg;
        }

        public void setErrorCode(int i2) {
            this.mErrorCode = i2;
        }

        public void setErrorMsg(String str) {
            this.mErrorMsg = str;
        }
    }

    /* loaded from: classes.dex */
    public class Result {
        public int errorCode;
        public InputStream inputStream = null;
        public OutputStream outputStream = null;
        public HttpURLConnection urlConnection = null;

        public Result() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpURLConnection createConnection(int i2, String str, byte[] bArr, Map<String, String> map, int i3, int i4) throws SocketTimeoutException, ConnectTimeoutException, MalformedURLException, IOException {
        String str2;
        HttpURLConnection httpURLConnection;
        if ((i2 & 1) != 0) {
            if (bArr != null && bArr.length > 0) {
                str2 = str + "?" + new String(bArr);
                LogUtils.d(TAG, "requestUrl:" + str2);
                httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                if (httpURLConnection == null) {
                    LogUtils.e(TAG, "HttpURLConnection is null");
                }
                setConnectionHeader(str, httpURLConnection, map);
                setConnectionParametersForRequest(httpURLConnection, i2, bArr, false, i3, i4);
                return httpURLConnection;
            }
        } else if (bArr != null && bArr.length > 0) {
            LogUtils.d(TAG, "requestparamter:" + new String(bArr, "utf-8"));
        }
        str2 = str;
        LogUtils.d(TAG, "requestUrl:" + str2);
        httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        if (httpURLConnection == null) {
        }
        setConnectionHeader(str, httpURLConnection, map);
        setConnectionParametersForRequest(httpURLConnection, i2, bArr, false, i3, i4);
        return httpURLConnection;
    }

    public static void dealResonsResult(int i2, InputStream inputStream, ResponseHandler responseHandler) {
        byte[] dealResonsResult = dealResonsResult(inputStream);
        String str = new String(dealResonsResult);
        String str2 = TAG;
        LogUtils.d(str2, "request response : " + str);
        if (dealResonsResult != null && dealResonsResult.length != 0) {
            responseHandler.onSuccess(i2, dealResonsResult);
        } else {
            responseHandler.onFailure(-10, "IOException for inputStream".getBytes(), new IOException("IOException for inputStream"));
        }
    }

    public static void executor(Context context, final Request request, final ResponseHandler responseHandler) {
        if (responseHandler == null) {
            return;
        }
        if (context != null && request != null && !TextUtils.isEmpty(request.getHost())) {
            if (Utility.getRestApiDisable() && !(request instanceof IMGetTokenByCuidRequest)) {
                responseHandler.onFailure(1011, Constants.ERROR_MSG_HTTP_RESPONSE_ERROR.getBytes(), null);
                return;
            } else if (request.shouldAbort()) {
                return;
            } else {
                if (mContext == null) {
                    mContext = context.getApplicationContext();
                }
                TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.utils.HttpHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        try {
                            if (!Request.this.getMethod().equals("GET") && !Request.this.getMethod().equals("POST") && !Request.this.getMethod().equals(HttpPut.METHOD_NAME)) {
                                responseHandler.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
                            }
                            if (Request.this.getMethod().equals("GET")) {
                                i2 = 1;
                            } else {
                                i2 = Request.this.getMethod().equals("POST") ? 16 : 256;
                            }
                            HttpExecutor.getInstance().execute(i2, Request.this.getHost(), Request.this.getRequestParameter(), Request.this.getHeaders(), Request.this.getContentType(), responseHandler);
                        } catch (Exception e2) {
                            LogUtils.e(HttpHelper.TAG, "Http Unknown exception :", e2);
                            responseHandler.onFailure(-1003, "Http Unknown exception".getBytes(), e2);
                        }
                    }
                });
                return;
            }
        }
        responseHandler.onFailure(1005, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes(), null);
    }

    public static void setConnectionHeader(String str, HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                if (entry.getKey().equalsIgnoreCase("Cookie")) {
                    CookieManager.getInstance().setCookie(str, entry.getValue());
                    httpURLConnection.setRequestProperty(entry.getKey(), CookieManager.getInstance().getCookie(str));
                } else {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, int i2, byte[] bArr, boolean z, int i3, int i4) throws IOException {
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(i3);
        if (z) {
            httpURLConnection.setRequestProperty(Headers.CONTENT_ENCODING, AsyncHttpClient.ENCODING_GZIP);
        }
        httpURLConnection.setReadTimeout(i4);
        if (i2 == 1) {
            httpURLConnection.setRequestMethod("GET");
        } else if (i2 != 16) {
            if (i2 == 256) {
                if (bArr == null || bArr.length <= 0) {
                    return;
                }
                httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                httpURLConnection.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
                return;
            }
            throw new IllegalStateException("Unknown method type.");
        } else if (bArr == null || bArr.length <= 0) {
        } else {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
            if (z) {
                LogUtils.d(TAG, "This is statistic, compress data");
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(dataOutputStream2);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return;
            }
            dataOutputStream2.write(bArr);
            dataOutputStream2.close();
        }
    }

    public static byte[] dealResonsResult(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                            return byteArray;
                        } catch (IOException e2) {
                            LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e2);
                            return byteArray;
                        }
                    }
                } catch (IOException e3) {
                    LogUtils.e(LogUtils.TAG, "HttpHelper IOException for inputStream", e3);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e4);
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    LogUtils.e(LogUtils.TAG, "HttpHelper byteArrayOutputStream close", e5);
                }
                throw th;
            }
        }
    }

    public static void executor(int i2, String str, byte[] bArr, Map<String, String> map, int i3, int i4, ResponseHandler responseHandler) throws SocketTimeoutException, ConnectTimeoutException, MalformedURLException, IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            httpURLConnection = createConnection(i2, str, bArr, map, i3, i4);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != -1) {
                    if (httpURLConnection.getResponseCode() != 200) {
                        LogUtils.d(TAG, "createConnection responsecode:" + responseCode);
                        responseHandler.onFailure(responseCode, "http response error".getBytes(), null);
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
                        return;
                    }
                    return;
                }
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
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
}
