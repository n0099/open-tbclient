package com.baidu.tbadk.core.util.httpNet;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
/* loaded from: classes.dex */
public class ImgHttpClient implements com.baidu.adp.lib.resourceLoader.b {
    public static String a;
    private static int c;
    private static HttpClient m;
    private Context g;
    private HttpGet h;
    private final com.baidu.adp.lib.network.http.e k;
    private static volatile String d = null;
    private static volatile boolean e = false;
    private static Pattern f = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams b = new BasicHttpParams();
    private boolean l = false;
    private int i = 0;
    private volatile boolean j = false;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkState[] valuesCustom() {
            NetworkState[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkState[] networkStateArr = new NetworkState[length];
            System.arraycopy(valuesCustom, 0, networkStateArr, 0, length);
            return networkStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkStateInfo[] valuesCustom() {
            NetworkStateInfo[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkStateInfo[] networkStateInfoArr = new NetworkStateInfo[length];
            System.arraycopy(valuesCustom, 0, networkStateInfoArr, 0, length);
            return networkStateInfoArr;
        }
    }

    static {
        c = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(b, 5000);
        HttpConnectionParams.setSoTimeout(b, 30000);
        HttpConnectionParams.setSocketBufferSize(b, 1024);
        HttpConnectionParams.setTcpNoDelay(b, true);
        HttpClientParams.setRedirecting(b, true);
        ConnManagerParams.setMaxConnectionsPerRoute(b, new ConnPerRouteBean(10));
        ConnManagerParams.setTimeout(b, 10000L);
        ConnManagerParams.setMaxTotalConnections(b, 10);
        HttpProtocolParams.setUserAgent(b, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        m = new DefaultHttpClient(new ThreadSafeClientConnManager(b, schemeRegistry), b);
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            c = 3145728;
        }
    }

    public ImgHttpClient(com.baidu.adp.lib.network.http.e eVar) {
        b();
        this.k = eVar;
        this.g = TbadkApplication.m252getInst().getApp();
    }

    public static void b() {
        synchronized (ImgHttpClient.class) {
            if (!e) {
                e = true;
                c();
            }
        }
    }

    public static synchronized void c() {
        synchronized (ImgHttpClient.class) {
            try {
                Cursor query = TbadkApplication.m252getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    d = "Basic " + ba.b((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static NetworkState a(Context context) {
        NetworkState networkState;
        NetworkState networkState2 = NetworkState.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkState = NetworkState.UNAVAIL;
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
                networkState = NetworkState.WIFI;
            } else {
                networkState = NetworkState.MOBILE;
            }
            return networkState;
        } catch (Exception e2) {
            return networkState2;
        }
    }

    public void d() {
        this.j = true;
        this.k.b().a = true;
        g();
    }

    private void g() {
        try {
            if (this.h != null) {
                this.h.abort();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    private void a(String str, String str2, String str3) {
        NetworkState a2 = a(this.g);
        if (a2 != NetworkState.UNAVAIL) {
            try {
                if (a2 == NetworkState.MOBILE && str2 == null) {
                    URL url = new URL(str);
                    synchronized (ImgHttpClient.class) {
                        if (a == null) {
                            a = Proxy.getDefaultHost();
                        }
                        if (a != null && a.length() > 0) {
                            if (b(a)) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(a);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                this.h = new HttpGet(sb.toString());
                                this.h.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                                    this.h.setHeader("client_user_token", TbadkApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = b.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    b.setParameter("http.route.default-proxy", new HttpHost(a, Proxy.getDefaultPort()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(a) || httpHost.getPort() != Proxy.getDefaultPort()) {
                                        b.setParameter("http.route.default-proxy", new HttpHost(a, Proxy.getDefaultPort()));
                                    }
                                }
                                this.h = new HttpGet(str);
                                if (d != null) {
                                    this.h.setHeader("Proxy-Authorization", d);
                                }
                                if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                                    this.h.setHeader("client_user_token", TbadkApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (str2 == null || str2.length() == 0) {
                    if (this.h == null) {
                        this.h = a.a().a(str);
                        return;
                    }
                    return;
                }
                this.h = a.a().a(str, str2, str3);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private void a(String str) {
        a(str, (String) null, (String) null);
    }

    private boolean b(String str) {
        if (f.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [457=10, 458=10, 462=10] */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x034d, code lost:
        r8.b = r7;
        r8.e = r3 + 1;
        r8.d = java.lang.System.currentTimeMillis() - r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x035b, code lost:
        if (r6 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x035d, code lost:
        r6.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, int i) {
        int i2;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        String value;
        int read;
        String obj;
        byte[] bArr4 = null;
        if (i <= 0) {
            i = 5;
        }
        int i3 = 0;
        while (true) {
            if (this.j || i3 >= i) {
                break;
            }
            com.baidu.adp.lib.network.http.d dVar = new com.baidu.adp.lib.network.http.d();
            this.k.a(dVar);
            dVar.j = -1;
            InputStream inputStream = null;
            String a2 = this.k.a().a(dVar);
            try {
                try {
                    dVar.j = -2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (str == null || str.length() == 0) {
                        a(a2);
                        dVar.k = a.a().d();
                    } else {
                        a(a2, str, str2);
                        dVar.k = str;
                    }
                    dVar.j = -3;
                } finally {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    g();
                }
            } catch (SocketException e3) {
                e = e3;
            } catch (SocketTimeoutException e4) {
                e = e4;
            } catch (Exception e5) {
                e = e5;
            }
            if (this.h != null) {
                if (!this.j) {
                    dVar.j = -8;
                    HttpResponse execute = m.execute(this.h);
                    if (execute != null) {
                        if (execute.getStatusLine() != null) {
                            this.k.b().b = execute.getStatusLine().getStatusCode();
                            if (execute.getEntity() != null) {
                                HttpEntity entity = execute.getEntity();
                                inputStream = entity.getContent();
                                if (entity.getContentType() != null) {
                                    String obj2 = entity.getContentType().toString();
                                    this.k.b().d = obj2;
                                    if (obj2.contains("text/vnd.wap.wml")) {
                                        if (this.i < 1) {
                                            g();
                                            this.i++;
                                            this.k.b().b = 0;
                                            i3--;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e6) {
                                                }
                                            }
                                            g();
                                            i3++;
                                        } else {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e7) {
                                                }
                                            }
                                            g();
                                        }
                                    }
                                }
                                if (((int) entity.getContentLength()) <= c) {
                                    byte[] bArr5 = new byte[1024];
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                    int i4 = 0;
                                    boolean z = false;
                                    if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                                        z = true;
                                    }
                                    if (z) {
                                        byte[] bArr6 = new byte[23];
                                        int read2 = inputStream.read(bArr6, 0, 23);
                                        if (!new String(bArr6, 0, bArr6.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                                            byteArrayOutputStream.write(bArr6, 0, read2);
                                            i4 = 0 + read2;
                                        }
                                    }
                                    if (execute.getFirstHeader("Src-Content-Type") == null) {
                                        i2 = i4;
                                    } else if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                                        this.l = true;
                                        i2 = i4;
                                    } else {
                                        this.l = false;
                                        i2 = i4;
                                    }
                                    while (!this.j && i2 < c && (read = inputStream.read(bArr5)) != -1) {
                                        byteArrayOutputStream.write(bArr5, 0, read);
                                        i2 = read + i2;
                                    }
                                    dVar.j = -9;
                                    if (!this.j) {
                                        if (i2 >= c) {
                                            this.k.b().b = -11;
                                            dVar.h = this.g.getResources().getString(x.data_too_big);
                                            break;
                                        }
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        try {
                                            byteArrayOutputStream.close();
                                            if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                                com.baidu.tbadk.c.b.b(byteArrayInputStream, byteArrayOutputStream2);
                                                bArr4 = byteArrayOutputStream2.toByteArray();
                                                break;
                                            }
                                            break;
                                        } catch (SocketException e8) {
                                            bArr4 = bArr3;
                                            e = e8;
                                            this.k.b().b = -12;
                                            dVar.h = String.valueOf(String.valueOf(this.k.b().b)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e9) {
                                                }
                                            }
                                            g();
                                            i3++;
                                        } catch (SocketTimeoutException e10) {
                                            bArr4 = bArr2;
                                            e = e10;
                                            this.k.b().b = -13;
                                            dVar.h = String.valueOf(String.valueOf(this.k.b().b)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e11) {
                                                }
                                            }
                                            g();
                                            i3++;
                                        } catch (Exception e12) {
                                            bArr4 = bArr;
                                            e = e12;
                                            this.k.b().b = -10;
                                            dVar.h = String.valueOf(String.valueOf(this.k.b().b)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e13) {
                                                }
                                            }
                                            g();
                                            this.i = 0;
                                            this.k.b().g = bArr4;
                                        }
                                    } else {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e14) {
                                            }
                                        }
                                        g();
                                    }
                                } else {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e15) {
                                        }
                                    }
                                    g();
                                    return;
                                }
                            } else {
                                throw new SocketException("httpResponse getEntity is null.");
                            }
                        } else {
                            throw new SocketException("httpResponse getStatusLine is null.");
                        }
                    } else {
                        throw new SocketException("httpResponse is null.");
                    }
                }
            } else {
                throw new SocketException("network not available.");
            }
        }
        this.i = 0;
        this.k.b().g = bArr4;
        g();
        this.i = 0;
        this.k.b().g = bArr4;
    }

    public void e() {
        a((String) null, (String) null, -1);
    }

    public boolean f() {
        return this.l;
    }

    @Override // com.baidu.adp.lib.resourceLoader.b
    public void a() {
        d();
    }
}
