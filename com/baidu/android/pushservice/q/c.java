package com.baidu.android.pushservice.q;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
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
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static class a implements HostnameVerifier {
        public final /* synthetic */ HttpURLConnection a;

        public a(HttpURLConnection httpURLConnection) {
            this.a = httpURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            String requestProperty = this.a.getRequestProperty("Host");
            if (!TextUtils.isEmpty(requestProperty)) {
                str = requestProperty;
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements HostnameVerifier {
        public final /* synthetic */ HttpURLConnection a;

        public b(HttpURLConnection httpURLConnection) {
            this.a = httpURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            String requestProperty = this.a.getRequestProperty("Host");
            if (!TextUtils.isEmpty(requestProperty)) {
                str = requestProperty;
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    /* renamed from: com.baidu.android.pushservice.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0036c extends SSLSocketFactory {
        public HostnameVerifier a = HttpsURLConnection.getDefaultHostnameVerifier();
        public HttpsURLConnection b;

        public C0036c(HttpsURLConnection httpsURLConnection) {
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
                } catch (Throwable unused) {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.android.pushservice.q.b a(Context context, String str, String str2, String str3, HashMap<String, String> hashMap, String str4) {
        try {
            return com.baidu.android.pushservice.q.a.a().a(str, str2, str3, hashMap, str4);
        } catch (Throwable th) {
            th.printStackTrace();
            HttpURLConnection httpURLConnection = null;
            com.baidu.android.pushservice.q.b bVar = new com.baidu.android.pushservice.q.b();
            try {
                httpURLConnection = a(str, str2, hashMap, str4);
                a(context, str2, str3, httpURLConnection);
                bVar = a(context, httpURLConnection);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }
    }

    public static com.baidu.android.pushservice.q.b a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        return a(context, str, str2, hashMap, (String) null, (String) null);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.android.pushservice.q.b a(Context context, String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        try {
            return com.baidu.android.pushservice.q.a.a().a(str, str2, hashMap, str3, str4);
        } catch (Throwable th) {
            th.printStackTrace();
            HttpURLConnection httpURLConnection = null;
            com.baidu.android.pushservice.q.b bVar = new com.baidu.android.pushservice.q.b();
            try {
                httpURLConnection = a(str, str2, str3, str4);
                a(context, str2, a(hashMap), httpURLConnection);
                bVar = a(context, httpURLConnection);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }
    }

    public static com.baidu.android.pushservice.q.b a(Context context, HttpURLConnection httpURLConnection) {
        int i;
        InputStream inputStream;
        com.baidu.android.pushservice.q.b bVar = new com.baidu.android.pushservice.q.b();
        GZIPInputStream gZIPInputStream = null;
        try {
            i = httpURLConnection.getResponseCode();
            try {
                inputStream = new BufferedInputStream(a(i) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream());
                try {
                    gZIPInputStream = a(httpURLConnection) ? new GZIPInputStream(inputStream) : inputStream;
                    inputStream = new ByteArrayInputStream(a(context, gZIPInputStream));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                inputStream = gZIPInputStream;
                bVar.a(i);
                bVar.a(inputStream);
                return bVar;
            }
        } catch (Exception unused3) {
            i = 0;
        }
        bVar.a(i);
        bVar.a(inputStream);
        return bVar;
    }

    public static String a(HashMap<String, String> hashMap) throws Exception {
        if (hashMap == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (i != 0) {
                stringBuffer.append("&");
            }
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                stringBuffer.append(key);
                stringBuffer.append("=");
                String value = entry.getValue();
                stringBuffer.append(!TextUtils.isEmpty(value) ? URLEncoder.encode(value, "UTF-8") : URLEncoder.encode("", "UTF-8"));
            }
            i++;
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[Catch: Exception -> 0x0092, TryCatch #0 {Exception -> 0x0092, blocks: (B:2:0x0000, B:4:0x001d, B:7:0x0026, B:9:0x002e, B:14:0x0047, B:16:0x005e, B:17:0x0063, B:19:0x0069, B:20:0x006e, B:22:0x0072, B:23:0x008e, B:10:0x0032, B:12:0x003a, B:13:0x003e), top: B:27:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[Catch: Exception -> 0x0092, TryCatch #0 {Exception -> 0x0092, blocks: (B:2:0x0000, B:4:0x001d, B:7:0x0026, B:9:0x002e, B:14:0x0047, B:16:0x005e, B:17:0x0063, B:19:0x0069, B:20:0x006e, B:22:0x0072, B:23:0x008e, B:10:0x0032, B:12:0x003a, B:13:0x003e), top: B:27:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[Catch: Exception -> 0x0092, TryCatch #0 {Exception -> 0x0092, blocks: (B:2:0x0000, B:4:0x001d, B:7:0x0026, B:9:0x002e, B:14:0x0047, B:16:0x005e, B:17:0x0063, B:19:0x0069, B:20:0x006e, B:22:0x0072, B:23:0x008e, B:10:0x0032, B:12:0x003a, B:13:0x003e), top: B:27:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpURLConnection a(String str, String str2, String str3, String str4) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            if (!"POST".equals(str2) && !HttpPut.METHOD_NAME.equals(str2)) {
                if (HttpDelete.METHOD_NAME.equals(str2)) {
                    httpURLConnection.setDoOutput(true);
                } else if ("GET".equals(str2)) {
                    httpURLConnection.setDoOutput(false);
                }
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty("User-Agent", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    httpURLConnection.setRequestProperty("Host", str4);
                }
                if (httpURLConnection instanceof HttpsURLConnection) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new C0036c((HttpsURLConnection) httpURLConnection));
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new a(httpURLConnection));
                }
                httpURLConnection.connect();
                return httpURLConnection;
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (!TextUtils.isEmpty(str3)) {
            }
            if (!TextUtils.isEmpty(str4)) {
            }
            if (httpURLConnection instanceof HttpsURLConnection) {
            }
            httpURLConnection.connect();
            return httpURLConnection;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[Catch: Exception -> 0x009e, LOOP:0: B:15:0x005e->B:17:0x0064, LOOP_END, TryCatch #0 {Exception -> 0x009e, blocks: (B:2:0x0000, B:4:0x001d, B:7:0x0026, B:9:0x002e, B:14:0x0047, B:15:0x005e, B:17:0x0064, B:18:0x007a, B:20:0x007e, B:21:0x009a, B:10:0x0032, B:12:0x003a, B:13:0x003e), top: B:25:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e A[Catch: Exception -> 0x009e, TryCatch #0 {Exception -> 0x009e, blocks: (B:2:0x0000, B:4:0x001d, B:7:0x0026, B:9:0x002e, B:14:0x0047, B:15:0x005e, B:17:0x0064, B:18:0x007a, B:20:0x007e, B:21:0x009a, B:10:0x0032, B:12:0x003a, B:13:0x003e), top: B:25:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpURLConnection a(String str, String str2, HashMap<String, String> hashMap, String str3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            if (!"POST".equals(str2) && !HttpPut.METHOD_NAME.equals(str2)) {
                if (HttpDelete.METHOD_NAME.equals(str2)) {
                    httpURLConnection.setDoOutput(true);
                } else if ("GET".equals(str2)) {
                    httpURLConnection.setDoOutput(false);
                }
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setRequestProperty("Content-type", str3);
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                if (httpURLConnection instanceof HttpsURLConnection) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new C0036c((HttpsURLConnection) httpURLConnection));
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new b(httpURLConnection));
                }
                httpURLConnection.connect();
                return httpURLConnection;
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setRequestProperty("Content-type", str3);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            while (r4.hasNext()) {
            }
            if (httpURLConnection instanceof HttpsURLConnection) {
            }
            httpURLConnection.connect();
            return httpURLConnection;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Context context, String str, String str2, HttpURLConnection httpURLConnection) throws IOException {
        if (("POST".equals(str) || HttpPut.METHOD_NAME.equals(str) || HttpDelete.METHOD_NAME.equals(str)) && !a(context, httpURLConnection, str2)) {
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
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(int i) {
        int i2 = i / 100;
        return i2 == 4 || i2 == 5 || i2 == 6;
    }

    public static boolean a(Context context, HttpURLConnection httpURLConnection, String str) {
        Throwable th;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        boolean z = !TextUtils.isEmpty(str);
        DataOutputStream dataOutputStream2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                dataOutputStream = new DataOutputStream(outputStream);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused2) {
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        try {
            dataOutputStream.write(str.getBytes("UTF-8"));
            dataOutputStream.flush();
            a(context, dataOutputStream, outputStream);
            return z;
        } catch (Exception unused3) {
            dataOutputStream2 = dataOutputStream;
            a(context, dataOutputStream2, outputStream);
            return false;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream2 = dataOutputStream;
            a(context, dataOutputStream2, outputStream);
            throw th;
        }
    }

    public static boolean a(HttpURLConnection httpURLConnection) {
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
            } catch (Exception unused) {
                a(context, byteArrayOutputStream, inputStream);
            } catch (Throwable th) {
                a(context, byteArrayOutputStream, inputStream);
                throw th;
            }
        }
        a(context, byteArrayOutputStream, inputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r1 == null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
        if (r1 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.android.pushservice.q.b b(Context context, String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        com.baidu.android.pushservice.q.b bVar = new com.baidu.android.pushservice.q.b();
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = a(str, str2, str3, str4);
            a(context, str2, a(hashMap), httpURLConnection);
            bVar = a(context, httpURLConnection);
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
