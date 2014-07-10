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
import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.y;
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
    private static HttpClient m;
    private Context g;
    private HttpGet h;
    private final com.baidu.adp.lib.network.http.e k;
    private static int c = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
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
        HttpConnectionParams.setConnectionTimeout(b, KirinConfig.READ_TIME_OUT);
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
                    d = "Basic " + bm.b((String.valueOf(string) + ":" + string2).getBytes());
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

    private void a(String str) {
        NetworkState a2 = a(this.g);
        if (a2 != NetworkState.UNAVAIL) {
            try {
                if (a2 == NetworkState.MOBILE) {
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
                                this.h = a.a().a(sb.toString());
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
                                this.h = a.a().a(str);
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
                if (this.h == null) {
                    this.h = a.a().a(str);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    private boolean b(String str) {
        if (f.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [431=10, 432=10, 436=10] */
    public void e() {
        com.baidu.adp.lib.network.http.d dVar;
        InputStream inputStream;
        long currentTimeMillis;
        int i;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        String value;
        int read;
        String obj;
        byte[] bArr4 = null;
        int i2 = 0;
        while (true) {
            if (this.j || i2 >= 5) {
                break;
            }
            dVar = new com.baidu.adp.lib.network.http.d();
            this.k.a(dVar);
            dVar.j = -1;
            inputStream = null;
            String a2 = this.k.a().a(dVar);
            try {
                try {
                    dVar.j = -2;
                    currentTimeMillis = System.currentTimeMillis();
                    a(a2);
                    dVar.k = a.a().c();
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
                                            i2--;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e6) {
                                                }
                                            }
                                            g();
                                            i2++;
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
                                    int i3 = 0;
                                    boolean z = false;
                                    if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                                        z = true;
                                    }
                                    if (z) {
                                        byte[] bArr6 = new byte[23];
                                        int read2 = inputStream.read(bArr6, 0, 23);
                                        if (!new String(bArr6, 0, bArr6.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                                            byteArrayOutputStream.write(bArr6, 0, read2);
                                            i3 = 0 + read2;
                                        }
                                    }
                                    if (execute.getFirstHeader("Src-Content-Type") == null) {
                                        i = i3;
                                    } else if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                                        this.l = true;
                                        i = i3;
                                    } else {
                                        this.l = false;
                                        i = i3;
                                    }
                                    while (!this.j && i < c && (read = inputStream.read(bArr5)) != -1) {
                                        byteArrayOutputStream.write(bArr5, 0, read);
                                        i = read + i;
                                    }
                                    dVar.j = -9;
                                    if (!this.j) {
                                        if (i >= c) {
                                            this.k.b().b = -11;
                                            dVar.h = this.g.getResources().getString(y.data_too_big);
                                            break;
                                        }
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        try {
                                            byteArrayOutputStream.close();
                                            if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                                com.baidu.tbadk.b.b.b(byteArrayInputStream, byteArrayOutputStream2);
                                                bArr4 = byteArrayOutputStream2.toByteArray();
                                                break;
                                            }
                                            break;
                                        } catch (SocketException e8) {
                                            bArr4 = bArr3;
                                            e = e8;
                                            this.k.b().b = -12;
                                            dVar.h = String.valueOf(String.valueOf(this.k.b().b)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e9) {
                                                }
                                            }
                                            g();
                                            i2++;
                                        } catch (SocketTimeoutException e10) {
                                            bArr4 = bArr2;
                                            e = e10;
                                            this.k.b().b = -13;
                                            dVar.h = String.valueOf(String.valueOf(this.k.b().b)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception e11) {
                                                }
                                            }
                                            g();
                                            i2++;
                                        } catch (Exception e12) {
                                            bArr4 = bArr;
                                            e = e12;
                                            this.k.b().b = -10;
                                            dVar.h = String.valueOf(String.valueOf(this.k.b().b)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
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
        dVar.b = i;
        dVar.e = i2 + 1;
        dVar.d = System.currentTimeMillis() - currentTimeMillis;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e16) {
            }
        }
        g();
        this.i = 0;
        this.k.b().g = bArr4;
    }

    public boolean f() {
        return this.l;
    }

    @Override // com.baidu.adp.lib.resourceLoader.b
    public void a() {
        d();
    }
}
