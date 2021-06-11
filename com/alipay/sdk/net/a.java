package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1890a = "msp";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1891b = "application/octet-stream;binary/octet-stream";

    /* renamed from: c  reason: collision with root package name */
    public static final CookieManager f1892c = new CookieManager();

    /* renamed from: com.alipay.sdk.net.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0017a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1893a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f1894b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, String> f1895c;

        public C0017a(String str, Map<String, String> map, byte[] bArr) {
            this.f1893a = str;
            this.f1894b = bArr;
            this.f1895c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s requestBody=%s headers=%s>", this.f1893a, this.f1894b, this.f1895c);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<String>> f1896a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1897b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f1898c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f1896a = map;
            this.f1897b = str;
            this.f1898c = bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, C0017a c0017a) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        HttpURLConnection httpURLConnection2;
        BufferedOutputStream bufferedOutputStream2;
        if (context == null) {
            return null;
        }
        try {
            c.c(f1890a, "config : " + c0017a);
            URL url = new URL(c0017a.f1893a);
            Proxy a2 = a(context);
            c.c(f1890a, "proxy: " + a2);
            if (a2 != null) {
                httpURLConnection2 = (HttpURLConnection) url.openConnection(a2);
            } else {
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
            }
            try {
                System.setProperty("http.keepAlive", "false");
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection2;
                }
                if (f1892c.getCookieStore().getCookies().size() > 0) {
                    httpURLConnection2.setRequestProperty("Cookie", TextUtils.join(";", f1892c.getCookieStore().getCookies()));
                }
                httpURLConnection2.setConnectTimeout(20000);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setRequestProperty("User-Agent", f1890a);
                if (c0017a.f1894b != null && c0017a.f1894b.length > 0) {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty("Content-Type", f1891b);
                    httpURLConnection2.setRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection2.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                    httpURLConnection2.setRequestProperty(HTTP.CONN_KEEP_ALIVE, "timeout=180, max=100");
                } else {
                    httpURLConnection2.setRequestMethod("GET");
                }
                if (c0017a.f1895c != null) {
                    for (Map.Entry<String, String> entry : c0017a.f1895c.entrySet()) {
                        if (entry.getKey() != null) {
                            httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                httpURLConnection2.setDoInput(true);
                if ("POST".equals(httpURLConnection2.getRequestMethod())) {
                    httpURLConnection2.setDoOutput(true);
                }
                if ("POST".equals(httpURLConnection2.getRequestMethod())) {
                    bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                    try {
                        bufferedOutputStream2.write(c0017a.f1894b);
                        bufferedOutputStream2.flush();
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedInputStream = null;
                        Throwable th2 = th;
                        httpURLConnection = httpURLConnection2;
                        th = th2;
                        try {
                            c.a(th);
                            return null;
                        } finally {
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                } else {
                    bufferedOutputStream2 = null;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection2.getInputStream());
                try {
                    byte[] a3 = a(bufferedInputStream2);
                    Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                    String join = (headerFields == null || headerFields.get(null) == null) ? null : TextUtils.join(",", headerFields.get(null));
                    List<String> list = headerFields.get("Set-Cookie");
                    if (list != null) {
                        for (String str : list) {
                            List<HttpCookie> parse = HttpCookie.parse(str);
                            if (parse != null && !parse.isEmpty()) {
                                f1892c.getCookieStore().add(url.toURI(), parse.get(0));
                            }
                        }
                    }
                    b bVar = new b(headerFields, join, a3);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (Throwable unused5) {
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    return bVar;
                } catch (Throwable th3) {
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream = bufferedInputStream2;
                    c.a(th);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused7) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                bufferedOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
    }

    public static NetworkInfo b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(Context context) {
        try {
            NetworkInfo b2 = b(context);
            if (b2 != null && b2.isAvailable()) {
                return b2.getType() == 1 ? "wifi" : b2.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    public static Proxy a(Context context) {
        String c2 = c(context);
        if (c2 == null || c2.contains("wap")) {
            try {
                String property = System.getProperty("https.proxyHost");
                String property2 = System.getProperty("https.proxyPort");
                if (TextUtils.isEmpty(property)) {
                    return null;
                }
                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
