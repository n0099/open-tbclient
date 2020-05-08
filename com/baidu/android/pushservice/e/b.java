package com.baidu.android.pushservice.e;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes8.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends SSLSocketFactory {
        private HostnameVerifier a = HttpsURLConnection.getDefaultHostnameVerifier();
        private HttpsURLConnection b;

        a(HttpsURLConnection httpsURLConnection) {
            this.b = httpsURLConnection;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket() throws IOException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            String requestProperty = this.b.getRequestProperty("Host");
            if (!TextUtils.isEmpty(requestProperty)) {
                str = requestProperty;
            }
            InetAddress inetAddress = socket.getInetAddress();
            if (z) {
                socket.close();
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            if (Build.VERSION.SDK_INT >= 17) {
                sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            } else {
                try {
                    sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
                } catch (Throwable th) {
                }
            }
            if (this.a.verify(str, sSLSocket.getSession())) {
                return sSLSocket;
            }
            throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return new String[0];
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public static com.baidu.android.pushservice.e.a a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        return a(context, str, str2, hashMap, null, null);
    }

    public static com.baidu.android.pushservice.e.a a(Context context, String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        HttpURLConnection httpURLConnection = null;
        com.baidu.android.pushservice.e.a aVar = new com.baidu.android.pushservice.e.a();
        try {
            httpURLConnection = a(str, str2, str3, str4);
            a(context, str2, hashMap, httpURLConnection);
            aVar = a(context, httpURLConnection);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        return aVar;
    }

    private static com.baidu.android.pushservice.e.a a(Context context, HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        com.baidu.android.pushservice.e.a aVar = new com.baidu.android.pushservice.e.a();
        int i = 0;
        try {
            i = httpURLConnection.getResponseCode();
            InputStream errorStream = a(i) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            try {
                inputStream = new BufferedInputStream(errorStream);
                InputStream gZIPInputStream = a(httpURLConnection) ? new GZIPInputStream(inputStream) : inputStream;
                try {
                    inputStream = new ByteArrayInputStream(a(context, gZIPInputStream));
                } catch (Exception e) {
                    inputStream = gZIPInputStream;
                }
            } catch (Exception e2) {
                inputStream = errorStream;
            }
        } catch (Exception e3) {
        }
        aVar.a(i);
        aVar.a(inputStream);
        return aVar;
    }

    private static String a(HashMap<String, String> hashMap) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return stringBuffer.toString();
            }
            Map.Entry<String, String> next = it.next();
            if (i2 != 0) {
                stringBuffer.append(ETAG.ITEM_SEPARATOR);
            }
            String key = next.getKey();
            if (!TextUtils.isEmpty(key)) {
                stringBuffer.append(key).append(ETAG.EQUAL);
                String value = next.getValue();
                if (TextUtils.isEmpty(value)) {
                    stringBuffer.append(URLEncoder.encode("", "UTF-8"));
                } else {
                    stringBuffer.append(URLEncoder.encode(value, "UTF-8"));
                }
            }
            i = i2 + 1;
        }
    }

    private static HttpURLConnection a(String str, String str2, String str3, String str4) {
        try {
            final HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            if ("POST".equals(str2) || HttpPut.METHOD_NAME.equals(str2)) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
            } else if (HttpDelete.METHOD_NAME.equals(str2)) {
                httpURLConnection.setDoOutput(true);
            } else if ("GET".equals(str2)) {
                httpURLConnection.setDoOutput(false);
            }
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip");
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.setRequestProperty("User-Agent", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                httpURLConnection.setRequestProperty("Host", str4);
            }
            if (httpURLConnection instanceof HttpsURLConnection) {
                httpURLConnection.setInstanceFollowRedirects(false);
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new a((HttpsURLConnection) httpURLConnection));
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.android.pushservice.e.b.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str5, SSLSession sSLSession) {
                        String requestProperty = httpURLConnection.getRequestProperty("Host");
                        if (!TextUtils.isEmpty(requestProperty)) {
                            str5 = requestProperty;
                        }
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str5, sSLSession);
                    }
                });
            }
            httpURLConnection.connect();
            return httpURLConnection;
        } catch (Exception e) {
            return null;
        }
    }

    private static void a(Context context, String str, HashMap<String, String> hashMap, HttpURLConnection httpURLConnection) throws IOException {
        if (("POST".equals(str) || HttpPut.METHOD_NAME.equals(str) || HttpDelete.METHOD_NAME.equals(str)) && !a(context, httpURLConnection, hashMap)) {
            throw new IOException("failed to writeRequestParams");
        }
    }

    public static void a(Context context, Closeable... closeableArr) {
        if (closeableArr != null) {
            try {
                if (closeableArr.length > 0) {
                    for (Closeable closeable : closeableArr) {
                        if (closeable != null) {
                            closeable.close();
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private static boolean a(int i) {
        int i2 = i / 100;
        return i2 == 4 || i2 == 5 || i2 == 6;
    }

    private static boolean a(Context context, HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        DataOutputStream dataOutputStream;
        OutputStream outputStream;
        DataOutputStream dataOutputStream2;
        OutputStream outputStream2 = null;
        boolean z = (hashMap == null || hashMap.isEmpty()) ? false : true;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                dataOutputStream = new DataOutputStream(outputStream);
            } catch (Exception e) {
                dataOutputStream2 = null;
                outputStream2 = outputStream;
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
            try {
                dataOutputStream.write(a(hashMap).getBytes("UTF-8"));
                dataOutputStream.flush();
                a(context, dataOutputStream, outputStream);
                return z;
            } catch (Exception e2) {
                dataOutputStream2 = dataOutputStream;
                outputStream2 = outputStream;
                a(context, dataOutputStream2, outputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                a(context, dataOutputStream, outputStream);
                throw th;
            }
        } catch (Exception e3) {
            dataOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            outputStream = null;
        }
    }

    private static boolean a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
        return !TextUtils.isEmpty(headerField) && headerField.contains("zip");
    }

    public static byte[] a(Context context, InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                a(context, byteArrayOutputStream, inputStream);
            } catch (Throwable th) {
                a(context, byteArrayOutputStream, inputStream);
                throw th;
            }
        }
        a(context, byteArrayOutputStream, inputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
