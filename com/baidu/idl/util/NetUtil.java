package com.baidu.idl.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class NetUtil {
    public static final String TAG = "NetUtil";

    /* loaded from: classes2.dex */
    public static abstract class RequestAdapter<T> {
        public static final int CONNECT_TIMEOUT = 5000;
        public static final int READ_TIMEOUT = 5000;
        public static final String REQUEST_METHOD = "POST";
        public static final int RESPONSE_STATUS_ERROR_IO = 2;
        public static final int RESPONSE_STATUS_ERROR_PARSE_JSON = 3;
        public static final int RESPONSE_STATUS_ERROR_RESPONSE_CODE = 4;
        public static final int RESPONSE_STATUS_ERROR_TIMEOUT = 1;
        public static final int RESPONSE_STATUS_ERROR_UNKNOWN = 5;
        public static final int RESPONSE_STATUS_NORMAL = 0;
        public static final int RETRY_COUNT = 2;

        public int getConnectTimeout() {
            return 5000;
        }

        public int getReadTimeout() {
            return 5000;
        }

        public String getRequestMethod() {
            return "POST";
        }

        public abstract String getRequestString();

        public int getRetryCount() {
            return 2;
        }

        public abstract String getURL();

        public abstract void onResponse(int i2, T t, Exception exc);

        public abstract T parseResponse(InputStream inputStream) throws IOException, JSONException;
    }

    public NetUtil() {
        throw new RuntimeException("This class instance can not be created.");
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0090 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0092 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0094 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00b1 */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
        if (r7 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c9, code lost:
        if (r7 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e1, code lost:
        if (r7 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e3, code lost:
        r7.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e6, code lost:
        r8 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x010f A[EDGE_INSN: B:136:0x010f->B:93:0x010f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.baidu.idl.util.NetUtil$RequestAdapter<T>, com.baidu.idl.util.NetUtil$RequestAdapter] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r2v17, types: [org.json.JSONException] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r2v7, types: [org.json.JSONException] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void uploadData(RequestAdapter<T> requestAdapter) {
        int i2;
        HttpURLConnection httpURLConnection;
        IOException e2;
        SocketTimeoutException e3;
        Exception exc;
        Object obj;
        int retryCount = requestAdapter.getRetryCount();
        HttpURLConnection httpURLConnection2 = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        while (true) {
            boolean z = false;
            i2 = 1;
            try {
                httpURLConnection = (HttpURLConnection) new URL(requestAdapter.getURL()).openConnection();
                try {
                    try {
                        httpURLConnection.setConnectTimeout(requestAdapter.getConnectTimeout());
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setReadTimeout(requestAdapter.getReadTimeout());
                        httpURLConnection.setRequestMethod(requestAdapter.getRequestMethod());
                        httpURLConnection.setUseCaches(false);
                        outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(requestAdapter.getRequestString().getBytes("UTF-8"));
                        outputStream.flush();
                        if (httpURLConnection.getResponseCode() != 200) {
                            exc = new IllegalStateException("ResponseCode: " + httpURLConnection.getResponseCode());
                            obj = null;
                            i2 = 4;
                        } else {
                            inputStream = httpURLConnection.getInputStream();
                            obj = requestAdapter.parseResponse(inputStream);
                            exc = null;
                            i2 = 0;
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (SocketTimeoutException e4) {
                    e3 = e4;
                    e3.printStackTrace();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    exc = e3;
                    z = true;
                    obj = null;
                    if (z) {
                    }
                    requestAdapter.onResponse(i2, obj, exc);
                } catch (IOException e5) {
                    e2 = e5;
                    e2.printStackTrace();
                    i2 = 2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                } catch (JSONException e6) {
                    e2 = e6;
                    e2.printStackTrace();
                    i2 = 3;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused9) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused10) {
                        }
                    }
                } catch (Exception e7) {
                    e2 = e7;
                    e2.printStackTrace();
                    i2 = 5;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused11) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused12) {
                        }
                    }
                }
            } catch (SocketTimeoutException e8) {
                httpURLConnection = httpURLConnection2;
                e3 = e8;
            } catch (IOException e9) {
                httpURLConnection = httpURLConnection2;
                e2 = e9;
            } catch (JSONException e10) {
                httpURLConnection = httpURLConnection2;
                e2 = e10;
            } catch (Exception e11) {
                httpURLConnection = httpURLConnection2;
                e2 = e11;
            } catch (Throwable th2) {
                th = th2;
            }
            if (z) {
                break;
            }
            int i3 = retryCount - 1;
            if (retryCount <= 0) {
                break;
            }
            retryCount = i3;
            httpURLConnection2 = httpURLConnection;
        }
        requestAdapter.onResponse(i2, obj, exc);
    }
}
