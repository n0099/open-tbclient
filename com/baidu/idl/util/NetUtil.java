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
/* loaded from: classes3.dex */
public class NetUtil {
    private static final String TAG = "NetUtil";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [83=7, 85=6, 86=6, 91=6, 93=6, 94=6, 99=6, 100=6] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x008f A[EDGE_INSN: B:137:0x008f->B:17:0x008f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void uploadData(RequestAdapter<T> requestAdapter) {
        int i;
        Exception e;
        JSONException e2;
        IOException e3;
        SocketTimeoutException e4;
        Throwable th;
        T t;
        SocketTimeoutException socketTimeoutException;
        int i2;
        boolean z;
        HttpURLConnection httpURLConnection;
        T parseResponse;
        int retryCount = requestAdapter.getRetryCount();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        HttpURLConnection httpURLConnection2 = null;
        while (true) {
            try {
                try {
                    i = retryCount;
                    httpURLConnection = (HttpURLConnection) new URL(requestAdapter.getURL()).openConnection();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SocketTimeoutException e5) {
                e4 = e5;
            } catch (IOException e6) {
                e3 = e6;
            } catch (JSONException e7) {
                e2 = e7;
            } catch (Exception e8) {
                e = e8;
            }
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
                    i2 = 4;
                    socketTimeoutException = new IllegalStateException("ResponseCode: " + httpURLConnection.getResponseCode());
                    parseResponse = null;
                } else {
                    inputStream = httpURLConnection.getInputStream();
                    parseResponse = requestAdapter.parseResponse(inputStream);
                    socketTimeoutException = null;
                    i2 = 0;
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e9) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e10) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    httpURLConnection2 = httpURLConnection;
                    t = parseResponse;
                    z = false;
                } else {
                    httpURLConnection2 = httpURLConnection;
                    t = parseResponse;
                    z = false;
                }
            } catch (SocketTimeoutException e11) {
                e4 = e11;
                httpURLConnection2 = httpURLConnection;
                e4.printStackTrace();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e12) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e13) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    t = null;
                    socketTimeoutException = e4;
                    i2 = 1;
                    z = true;
                } else {
                    t = null;
                    socketTimeoutException = e4;
                    i2 = 1;
                    z = true;
                }
                if (!z) {
                }
                requestAdapter.onResponse(i2, t, socketTimeoutException);
            } catch (IOException e14) {
                e3 = e14;
                httpURLConnection2 = httpURLConnection;
                e3.printStackTrace();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e15) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e16) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    t = null;
                    socketTimeoutException = e3;
                    i2 = 2;
                    z = false;
                } else {
                    t = null;
                    socketTimeoutException = e3;
                    i2 = 2;
                    z = false;
                }
                if (!z) {
                }
                requestAdapter.onResponse(i2, t, socketTimeoutException);
            } catch (JSONException e17) {
                e2 = e17;
                httpURLConnection2 = httpURLConnection;
                e2.printStackTrace();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e18) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e19) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    t = null;
                    socketTimeoutException = e2;
                    i2 = 3;
                    z = false;
                } else {
                    t = null;
                    socketTimeoutException = e2;
                    i2 = 3;
                    z = false;
                }
                if (!z) {
                }
                requestAdapter.onResponse(i2, t, socketTimeoutException);
            } catch (Exception e20) {
                e = e20;
                httpURLConnection2 = httpURLConnection;
                e.printStackTrace();
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e21) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e22) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    t = null;
                    socketTimeoutException = e;
                    i2 = 5;
                    z = false;
                } else {
                    t = null;
                    socketTimeoutException = e;
                    i2 = 5;
                    z = false;
                }
                if (!z) {
                }
                requestAdapter.onResponse(i2, t, socketTimeoutException);
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection2 = httpURLConnection;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e23) {
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e24) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
            if (!z) {
                break;
            }
            retryCount = i - 1;
            if (i <= 0) {
                break;
            }
        }
        requestAdapter.onResponse(i2, t, socketTimeoutException);
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    private NetUtil() {
        throw new RuntimeException("This class instance can not be created.");
    }

    /* loaded from: classes3.dex */
    public static abstract class RequestAdapter<T> {
        private static final int CONNECT_TIMEOUT = 5000;
        private static final int READ_TIMEOUT = 5000;
        private static final String REQUEST_METHOD = "POST";
        public static final int RESPONSE_STATUS_ERROR_IO = 2;
        public static final int RESPONSE_STATUS_ERROR_PARSE_JSON = 3;
        public static final int RESPONSE_STATUS_ERROR_RESPONSE_CODE = 4;
        public static final int RESPONSE_STATUS_ERROR_TIMEOUT = 1;
        public static final int RESPONSE_STATUS_ERROR_UNKNOWN = 5;
        public static final int RESPONSE_STATUS_NORMAL = 0;
        private static final int RETRY_COUNT = 2;

        public abstract String getRequestString();

        public abstract String getURL();

        public abstract void onResponse(int i, T t, Exception exc);

        public abstract T parseResponse(InputStream inputStream) throws IOException, JSONException;

        public int getRetryCount() {
            return 2;
        }

        public int getConnectTimeout() {
            return 5000;
        }

        public int getReadTimeout() {
            return 5000;
        }

        public String getRequestMethod() {
            return "POST";
        }
    }
}
