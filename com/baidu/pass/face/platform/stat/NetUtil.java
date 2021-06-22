package com.baidu.pass.face.platform.stat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class NetUtil {
    public static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.baidu.pass.face.platform.stat.NetUtil.2
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
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
            return 0;
        }

        public abstract String getURL();

        public abstract void parseResponse(InputStream inputStream) throws IOException, JSONException;
    }

    public NetUtil() {
        throw new RuntimeException("This class instance can not be created.");
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static void trustAllHosts() {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.baidu.pass.face.platform.stat.NetUtil.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x008e, code lost:
        if (r6 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
        if (r6 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c9, code lost:
        if (r6 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e0, code lost:
        if (r6 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e2, code lost:
        r6.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e5, code lost:
        r1 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void uploadData(RequestAdapter<T> requestAdapter) {
        HttpsURLConnection httpsURLConnection;
        Exception e2;
        JSONException e3;
        IOException e4;
        SocketTimeoutException e5;
        int i2;
        int retryCount = requestAdapter.getRetryCount();
        HttpsURLConnection httpsURLConnection2 = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        while (true) {
            boolean z = false;
            try {
                URL url = new URL(requestAdapter.getURL());
                trustAllHosts();
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    try {
                        httpsURLConnection.setConnectTimeout(requestAdapter.getConnectTimeout());
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                        httpsURLConnection.setReadTimeout(requestAdapter.getReadTimeout());
                        httpsURLConnection.setRequestMethod(requestAdapter.getRequestMethod());
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.setHostnameVerifier(DO_NOT_VERIFY);
                        outputStream = httpsURLConnection.getOutputStream();
                        outputStream.write(requestAdapter.getRequestString().getBytes("UTF-8"));
                        outputStream.flush();
                        if (httpsURLConnection.getResponseCode() != 200) {
                            new IllegalStateException("ResponseCode: " + httpsURLConnection.getResponseCode());
                        } else {
                            inputStream = httpsURLConnection.getInputStream();
                            requestAdapter.parseResponse(inputStream);
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
                    } catch (Throwable th) {
                        th = th;
                        httpsURLConnection2 = httpsURLConnection;
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
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (SocketTimeoutException e6) {
                    e5 = e6;
                    e5.printStackTrace();
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
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    httpsURLConnection2 = httpsURLConnection;
                    z = true;
                    if (!z) {
                        return;
                    }
                    i2 = retryCount - 1;
                    if (retryCount <= 0) {
                        return;
                    }
                    retryCount = i2;
                } catch (IOException e7) {
                    e4 = e7;
                    e4.printStackTrace();
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
                } catch (JSONException e8) {
                    e3 = e8;
                    e3.printStackTrace();
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
                } catch (Exception e9) {
                    e2 = e9;
                    e2.printStackTrace();
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
            } catch (SocketTimeoutException e10) {
                httpsURLConnection = httpsURLConnection2;
                e5 = e10;
            } catch (IOException e11) {
                httpsURLConnection = httpsURLConnection2;
                e4 = e11;
            } catch (JSONException e12) {
                httpsURLConnection = httpsURLConnection2;
                e3 = e12;
            } catch (Exception e13) {
                httpsURLConnection = httpsURLConnection2;
                e2 = e13;
            } catch (Throwable th2) {
                th = th2;
            }
            retryCount = i2;
        }
    }
}
