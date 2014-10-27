package com.baidu.tbadk.core.util.httpNet;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
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
public class ImgHttpClient implements com.baidu.adp.lib.f.b {
    private static int Ei;
    public static String Gc;
    private static HttpClient Gd;
    private HttpGet Ga;
    private final com.baidu.adp.lib.network.http.e Gb;
    private Context mContext;
    public boolean mS;
    private static volatile String Ej = null;
    private static volatile boolean Ek = false;
    private static Pattern ke = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams Ge = new BasicHttpParams();
    private boolean ee = false;
    private boolean Gf = false;
    private int Gg = 0;
    private int El = 0;
    private volatile boolean En = false;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (Gh) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Gi) with 'values()' method */
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
        Ei = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(Ge, 5000);
        HttpConnectionParams.setSoTimeout(Ge, 30000);
        HttpConnectionParams.setSocketBufferSize(Ge, 1024);
        HttpConnectionParams.setTcpNoDelay(Ge, true);
        HttpClientParams.setRedirecting(Ge, true);
        ConnManagerParams.setMaxConnectionsPerRoute(Ge, new ConnPerRouteBean(10));
        ConnManagerParams.setTimeout(Ge, 10000L);
        ConnManagerParams.setMaxTotalConnections(Ge, 10);
        HttpProtocolParams.setUserAgent(Ge, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        Gd = new DefaultHttpClient(new ThreadSafeClientConnManager(Ge, schemeRegistry), Ge);
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            Ei = 4194304;
        }
    }

    public ImgHttpClient(com.baidu.adp.lib.network.http.e eVar) {
        mj();
        this.Gb = eVar;
        this.mContext = TbadkApplication.m251getInst().getApp();
    }

    public static void mj() {
        synchronized (ImgHttpClient.class) {
            if (!Ek) {
                Ek = true;
                mk();
            }
        }
    }

    public static synchronized void mk() {
        synchronized (ImgHttpClient.class) {
            try {
                Cursor query = TbadkApplication.m251getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    Ej = "Basic " + ay.k((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public static NetworkState v(Context context) {
        NetworkState networkState;
        NetworkState networkState2 = NetworkState.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkState = NetworkState.UNAVAIL;
            } else if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                networkState = NetworkState.WIFI;
            } else {
                networkState = NetworkState.MOBILE;
            }
            return networkState;
        } catch (Exception e) {
            return networkState2;
        }
    }

    public void dM() {
        this.En = true;
        this.Gb.dR().kE = true;
        nf();
    }

    private void nf() {
        try {
            if (this.Ga != null) {
                this.Ga.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void h(String str, String str2, String str3) {
        NetworkState v = v(this.mContext);
        if (v != NetworkState.UNAVAIL) {
            this.mS = false;
            try {
                if (v == NetworkState.MOBILE && str2 == null) {
                    this.mS = true;
                    URL url = new URL(str);
                    synchronized (ImgHttpClient.class) {
                        if (Gc == null) {
                            Gc = com.baidu.adp.lib.util.j.fq();
                        }
                        if (Gc != null && Gc.length() > 0) {
                            if (bW(Gc)) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(Gc);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                this.Ga = new HttpGet(sb.toString());
                                this.Ga.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                                    this.Ga.setHeader("client_user_token", TbadkApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = Ge.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    Ge.setParameter("http.route.default-proxy", new HttpHost(Gc, com.baidu.adp.lib.util.j.fr()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(Gc) || httpHost.getPort() != com.baidu.adp.lib.util.j.fr()) {
                                        Ge.setParameter("http.route.default-proxy", new HttpHost(Gc, com.baidu.adp.lib.util.j.fr()));
                                    }
                                }
                                this.Ga = new HttpGet(str);
                                if (Ej != null) {
                                    this.Ga.setHeader("Proxy-Authorization", Ej);
                                }
                                if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                                    this.Ga.setHeader("client_user_token", TbadkApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (str2 == null || str2.length() == 0) {
                    this.Ga = a.mT().o(str, this.Gg);
                } else {
                    this.Ga = a.mT().g(str, str2, str3);
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void bV(String str) {
        h(str, null, null);
    }

    private boolean bW(String str) {
        if (ke.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [512=12, 513=12, 514=12, 515=24, 516=12, 517=12, 518=24, 519=24, 520=12, 501=12, 502=12, 506=12, 508=12, 509=12, 510=11] */
    public void a(String str, String str2, int i) {
        boolean z;
        int i2;
        boolean z2;
        boolean z3;
        byte[] bArr;
        long currentTimeMillis;
        String value;
        int read;
        String obj;
        byte[] bArr2 = null;
        boolean z4 = true;
        if (i <= 0) {
            i = 5;
        }
        boolean z5 = false;
        int i3 = 0;
        while (!this.En && z4 && i3 < i) {
            this.Gg = i3;
            long currentTimeMillis2 = System.currentTimeMillis();
            com.baidu.adp.lib.network.http.d dVar = new com.baidu.adp.lib.network.http.d();
            this.Gb.a(dVar);
            dVar.kt = -1;
            InputStream inputStream = null;
            String b = this.Gb.dQ().b(dVar);
            try {
                try {
                    try {
                        dVar.kt = -2;
                        currentTimeMillis = System.currentTimeMillis();
                        if (str == null || str.length() == 0) {
                            bV(b);
                            dVar.ku = a.mT().bD(this.Gg);
                        } else {
                            h(b, str, str2);
                            dVar.ku = str;
                        }
                        dVar.kt = -3;
                    } catch (Throwable th) {
                        byte[] bArr3 = bArr2;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                            }
                        }
                        nf();
                        if ((str == null || str.length() == 0) && b != null) {
                            if (dVar.ku != null || i3 >= i - 1) {
                                int indexOf = b.indexOf("hiphotos");
                                if (indexOf > 0 && indexOf < 20) {
                                    if (v(this.mContext) == NetworkState.WIFI) {
                                        a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                    }
                                }
                            } else {
                                int i4 = i3;
                                z2 = z5;
                                z3 = z4;
                                bArr = bArr3;
                                i2 = i4;
                            }
                        }
                        throw th;
                    }
                } catch (SocketException e2) {
                    this.Gb.dR().responseCode = -12;
                    dVar.kr = String.valueOf(String.valueOf(this.Gb.dR().responseCode)) + "|retryCount:" + i3 + "|" + e2.getClass() + "|" + e2.getMessage();
                    z = true;
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    nf();
                    if ((str == null || str.length() == 0) && b != null) {
                        if (dVar.ku != null || i3 >= i - 1) {
                            int indexOf2 = b.indexOf("hiphotos");
                            if (indexOf2 > 0 && indexOf2 < 20) {
                                if (v(this.mContext) == NetworkState.WIFI) {
                                    a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                    i2 = i3;
                                    z2 = z5;
                                    z3 = true;
                                    bArr = bArr2;
                                }
                            }
                        } else {
                            i2 = i3;
                            z2 = z5;
                            z3 = true;
                            bArr = bArr2;
                        }
                    }
                    i2 = i3;
                    z2 = z5;
                    z3 = z;
                    bArr = bArr2;
                } catch (Exception e4) {
                    this.Gb.dR().responseCode = -10;
                    dVar.kr = String.valueOf(String.valueOf(this.Gb.dR().responseCode)) + "|retryCount:" + i3 + "|" + e4.getClass() + "|" + e4.getMessage();
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    nf();
                    if ((str != null && str.length() != 0) || b == null) {
                        break;
                    } else if (dVar.ku != null || i3 >= i - 1) {
                        int indexOf3 = b.indexOf("hiphotos");
                        if (indexOf3 > 0 && indexOf3 < 20) {
                            if (v(this.mContext) == NetworkState.WIFI) {
                                a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                            }
                        }
                    } else {
                        bArr = bArr2;
                        boolean z6 = z5;
                        z3 = false;
                        i2 = i3;
                        z2 = z6;
                    }
                }
            } catch (SocketTimeoutException e6) {
                this.Gb.dR().responseCode = -13;
                dVar.kr = String.valueOf(String.valueOf(this.Gb.dR().responseCode)) + "|retryCount:" + i3 + "|" + e6.getClass() + "|" + e6.getMessage();
                z = true;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                    }
                }
                nf();
                if ((str == null || str.length() == 0) && b != null) {
                    if (dVar.ku != null || i3 >= i - 1) {
                        int indexOf4 = b.indexOf("hiphotos");
                        if (indexOf4 > 0 && indexOf4 < 20) {
                            if (v(this.mContext) == NetworkState.WIFI) {
                                a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                i2 = i3;
                                z2 = z5;
                                z3 = true;
                                bArr = bArr2;
                            }
                        }
                    } else {
                        i2 = i3;
                        z2 = z5;
                        z3 = true;
                        bArr = bArr2;
                    }
                }
                i2 = i3;
                z2 = z5;
                z3 = z;
                bArr = bArr2;
            } catch (IOException e8) {
                z = true;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                    }
                }
                nf();
                if ((str == null || str.length() == 0) && b != null) {
                    if (dVar.ku != null || i3 >= i - 1) {
                        int indexOf5 = b.indexOf("hiphotos");
                        if (indexOf5 > 0 && indexOf5 < 20) {
                            if (v(this.mContext) == NetworkState.WIFI) {
                                a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                i2 = i3;
                                z2 = z5;
                                z3 = true;
                                bArr = bArr2;
                            }
                        }
                    } else {
                        i2 = i3;
                        z2 = z5;
                        z3 = true;
                        bArr = bArr2;
                    }
                }
                i2 = i3;
                z2 = z5;
                z3 = z;
                bArr = bArr2;
            } catch (HttpException e10) {
                z = true;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e11) {
                    }
                }
                nf();
                if ((str == null || str.length() == 0) && b != null) {
                    if (dVar.ku != null || i3 >= i - 1) {
                        int indexOf6 = b.indexOf("hiphotos");
                        if (indexOf6 > 0 && indexOf6 < 20) {
                            if (v(this.mContext) == NetworkState.WIFI) {
                                a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                i2 = i3;
                                z2 = z5;
                                z3 = true;
                                bArr = bArr2;
                            }
                        }
                    } else {
                        i2 = i3;
                        z2 = z5;
                        z3 = true;
                        bArr = bArr2;
                    }
                }
                i2 = i3;
                z2 = z5;
                z3 = z;
                bArr = bArr2;
            }
            if (this.Ga == null) {
                throw new SocketException("network not available.");
            }
            if (this.En) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e12) {
                    }
                }
                nf();
                if ((str != null && str.length() != 0) || b == null) {
                    break;
                } else if (dVar.ku != null || i3 >= i - 1) {
                    int indexOf7 = b.indexOf("hiphotos");
                    if (indexOf7 > 0 && indexOf7 < 20) {
                        if (v(this.mContext) == NetworkState.WIFI) {
                            a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                        }
                    }
                } else {
                    i2 = i3;
                    z2 = z5;
                    z3 = z4;
                    bArr = bArr2;
                    bArr2 = bArr;
                    z4 = z3;
                    z5 = z2;
                    i3 = i2 + 1;
                }
            } else {
                dVar.kt = -8;
                HttpResponse execute = Gd.execute(this.Ga);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.Gb.dR().responseCode = execute.getStatusLine().getStatusCode();
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                InputStream content = entity.getContent();
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.Gb.dR().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.El >= 1) {
                            if (content != null) {
                                try {
                                    content.close();
                                } catch (Exception e13) {
                                }
                            }
                            nf();
                            if ((str != null && str.length() != 0) || b == null) {
                                break;
                            } else if (dVar.ku != null || i3 >= i - 1) {
                                int indexOf8 = b.indexOf("hiphotos");
                                if (indexOf8 > 0 && indexOf8 < 20) {
                                    if (v(this.mContext) == NetworkState.WIFI) {
                                        a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                    }
                                }
                            } else {
                                i2 = i3;
                                z2 = z5;
                                z3 = z4;
                                bArr = bArr2;
                            }
                        } else {
                            nf();
                            this.El++;
                            this.Gb.dR().responseCode = 0;
                            i2 = i3 - 1;
                            if (content != null) {
                                try {
                                    content.close();
                                } catch (Exception e14) {
                                }
                            }
                            nf();
                            if ((str == null || str.length() == 0) && b != null) {
                                if (dVar.ku != null || i2 >= i - 1) {
                                    int indexOf9 = b.indexOf("hiphotos");
                                    if (indexOf9 > 0 && indexOf9 < 20) {
                                        if (v(this.mContext) == NetworkState.WIFI) {
                                            a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                            z2 = z5;
                                            z3 = z4;
                                            bArr = bArr2;
                                        }
                                    }
                                } else {
                                    z2 = z5;
                                    z3 = z4;
                                    bArr = bArr2;
                                }
                            }
                            z2 = z5;
                            z3 = z4;
                            bArr = bArr2;
                        }
                        bArr2 = bArr;
                        z4 = z3;
                        z5 = z2;
                        i3 = i2 + 1;
                    }
                }
                if (((int) entity.getContentLength()) <= Ei) {
                    byte[] bArr4 = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    int i5 = 0;
                    boolean z7 = false;
                    if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                        z7 = true;
                    }
                    if (z7) {
                        byte[] bArr5 = new byte[23];
                        int read2 = content.read(bArr5, 0, 23);
                        if (!new String(bArr5, 0, bArr5.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            byteArrayOutputStream.write(bArr5, 0, read2);
                            i5 = 0 + read2;
                        }
                    }
                    if (execute.getFirstHeader("Src-Content-Type") != null) {
                        if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                            this.ee = true;
                        } else {
                            this.ee = false;
                        }
                    }
                    while (!this.En && i5 < Ei && (read = content.read(bArr4)) != -1) {
                        byteArrayOutputStream.write(bArr4, 0, read);
                        i5 += read;
                    }
                    dVar.kt = -9;
                    if (!this.En) {
                        if (i5 < Ei) {
                            bArr2 = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                com.baidu.tbadk.util.d.a(byteArrayInputStream, byteArrayOutputStream2);
                                bArr2 = byteArrayOutputStream2.toByteArray();
                            }
                        } else {
                            this.Gb.dR().responseCode = -11;
                            dVar.kr = this.mContext.getResources().getString(y.data_too_big);
                        }
                        dVar.kl = i5;
                        dVar.retry = i3 + 1;
                        dVar.ko = System.currentTimeMillis() - currentTimeMillis;
                        if (execute.getFirstHeader("Error-Message") != null) {
                            Header firstHeader = execute.getFirstHeader("Error-Message");
                            if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                                this.Gf = false;
                            } else {
                                this.Gf = true;
                            }
                        }
                        if (i5 > 0) {
                            z5 = true;
                        }
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e15) {
                            }
                        }
                        nf();
                        if ((str != null && str.length() != 0) || b == null) {
                            break;
                        } else if (dVar.ku != null || i3 >= i - 1) {
                            int indexOf10 = b.indexOf("hiphotos");
                            if (indexOf10 > 0 && indexOf10 < 20) {
                                if (v(this.mContext) == NetworkState.WIFI) {
                                    a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                }
                            }
                        } else {
                            i2 = i3;
                            z2 = z5;
                            z3 = z4;
                            bArr = bArr2;
                        }
                    } else {
                        if (content != null) {
                            try {
                                content.close();
                            } catch (Exception e16) {
                            }
                        }
                        nf();
                        if ((str != null && str.length() != 0) || b == null) {
                            break;
                        } else if (dVar.ku != null || i3 >= i - 1) {
                            int indexOf11 = b.indexOf("hiphotos");
                            if (indexOf11 > 0 && indexOf11 < 20) {
                                if (v(this.mContext) == NetworkState.WIFI) {
                                    a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                                }
                            }
                        } else {
                            i2 = i3;
                            z2 = z5;
                            z3 = z4;
                            bArr = bArr2;
                        }
                    }
                } else {
                    if (content != null) {
                        try {
                            content.close();
                        } catch (Exception e17) {
                        }
                    }
                    nf();
                    if ((str != null && str.length() != 0) || b == null) {
                        return;
                    }
                    if (dVar.ku != null || i3 >= i - 1) {
                        int indexOf12 = b.indexOf("hiphotos");
                        if (indexOf12 <= 0 || indexOf12 >= 20) {
                            return;
                        }
                        if (v(this.mContext) == NetworkState.WIFI) {
                            a.mT().b(b, dVar.ku, z5, System.currentTimeMillis() - currentTimeMillis2 > 3000);
                            return;
                        }
                        return;
                    }
                    i2 = i3;
                    z2 = z5;
                    z3 = z4;
                    bArr = bArr2;
                }
                bArr2 = bArr;
                z4 = z3;
                z5 = z2;
                i3 = i2 + 1;
            }
        }
        this.El = 0;
        this.Gb.dR().kG = bArr2;
    }

    public void ng() {
        a(null, null, -1);
    }

    public boolean bM() {
        return this.ee;
    }

    public boolean nh() {
        return this.Gf;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        dM();
    }
}
