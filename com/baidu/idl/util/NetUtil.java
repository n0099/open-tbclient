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
/* loaded from: classes20.dex */
public class NetUtil {
    private static final String TAG = "NetUtil";

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [83=7, 85=6, 86=6, 91=6, 93=6, 94=6, 99=6, 100=6] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0091 A[EDGE_INSN: B:138:0x0091->B:17:0x0091 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void uploadData(RequestAdapter<T> requestAdapter) {
        int i;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        IllegalStateException illegalStateException;
        int i2;
        T t;
        boolean z;
        HttpURLConnection httpURLConnection2;
        T parseResponse;
        IllegalStateException illegalStateException2;
        int i3;
        int retryCount = requestAdapter.getRetryCount();
        InputStream inputStream2 = null;
        OutputStream outputStream2 = null;
        HttpURLConnection httpURLConnection3 = null;
        while (true) {
            try {
                try {
                    i = retryCount;
                    httpURLConnection2 = (HttpURLConnection) new URL(requestAdapter.getURL()).openConnection();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (SocketTimeoutException e) {
                e = e;
                InputStream inputStream3 = inputStream2;
                outputStream = outputStream2;
                httpURLConnection = httpURLConnection3;
                inputStream = inputStream3;
            } catch (IOException e2) {
                e = e2;
            } catch (JSONException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
            try {
                httpURLConnection2.setConnectTimeout(requestAdapter.getConnectTimeout());
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setReadTimeout(requestAdapter.getReadTimeout());
                httpURLConnection2.setRequestMethod(requestAdapter.getRequestMethod());
                httpURLConnection2.setUseCaches(false);
                outputStream2 = httpURLConnection2.getOutputStream();
                outputStream2.write(requestAdapter.getRequestString().getBytes("UTF-8"));
                outputStream2.flush();
                if (httpURLConnection2.getResponseCode() != 200) {
                    i3 = 4;
                    illegalStateException2 = new IllegalStateException("ResponseCode: " + httpURLConnection2.getResponseCode());
                    parseResponse = null;
                } else {
                    inputStream2 = httpURLConnection2.getInputStream();
                    parseResponse = requestAdapter.parseResponse(inputStream2);
                    illegalStateException2 = null;
                    i3 = 0;
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e6) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    i2 = i3;
                    illegalStateException = illegalStateException2;
                    t = parseResponse;
                    httpURLConnection3 = httpURLConnection2;
                    z = false;
                } else {
                    i2 = i3;
                    illegalStateException = illegalStateException2;
                    t = parseResponse;
                    httpURLConnection3 = httpURLConnection2;
                    z = false;
                }
            } catch (SocketTimeoutException e7) {
                inputStream = inputStream2;
                outputStream = outputStream2;
                httpURLConnection = httpURLConnection2;
                e = e7;
                try {
                    e.printStackTrace();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e9) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        t = null;
                        illegalStateException = e;
                        i2 = 1;
                        z = true;
                        OutputStream outputStream3 = outputStream;
                        inputStream2 = inputStream;
                        httpURLConnection3 = httpURLConnection;
                        outputStream2 = outputStream3;
                    } else {
                        t = null;
                        illegalStateException = e;
                        i2 = 1;
                        z = true;
                        OutputStream outputStream4 = outputStream;
                        inputStream2 = inputStream;
                        httpURLConnection3 = httpURLConnection;
                        outputStream2 = outputStream4;
                    }
                    if (!z) {
                    }
                    requestAdapter.onResponse(i2, t, illegalStateException);
                } catch (Throwable th2) {
                    th = th2;
                    InputStream inputStream4 = inputStream;
                    httpURLConnection3 = httpURLConnection;
                    outputStream2 = outputStream;
                    inputStream2 = inputStream4;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e10) {
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e11) {
                        }
                    }
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e12) {
                httpURLConnection3 = httpURLConnection2;
                e = e12;
                e.printStackTrace();
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e13) {
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e14) {
                    }
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    illegalStateException = e;
                    i2 = 2;
                    t = null;
                    z = false;
                } else {
                    illegalStateException = e;
                    i2 = 2;
                    t = null;
                    z = false;
                }
                if (!z) {
                }
                requestAdapter.onResponse(i2, t, illegalStateException);
            } catch (JSONException e15) {
                httpURLConnection3 = httpURLConnection2;
                e = e15;
                e.printStackTrace();
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e16) {
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e17) {
                    }
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    illegalStateException = e;
                    i2 = 3;
                    t = null;
                    z = false;
                } else {
                    illegalStateException = e;
                    i2 = 3;
                    t = null;
                    z = false;
                }
                if (!z) {
                }
                requestAdapter.onResponse(i2, t, illegalStateException);
            } catch (Exception e18) {
                httpURLConnection3 = httpURLConnection2;
                e = e18;
                e.printStackTrace();
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e19) {
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e20) {
                    }
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    illegalStateException = e;
                    i2 = 5;
                    t = null;
                    z = false;
                } else {
                    illegalStateException = e;
                    i2 = 5;
                    t = null;
                    z = false;
                }
                if (!z) {
                }
                requestAdapter.onResponse(i2, t, illegalStateException);
            } catch (Throwable th3) {
                httpURLConnection3 = httpURLConnection2;
                th = th3;
                if (outputStream2 != null) {
                }
                if (inputStream2 != null) {
                }
                if (httpURLConnection3 != null) {
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
        requestAdapter.onResponse(i2, t, illegalStateException);
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

    /* loaded from: classes20.dex */
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
