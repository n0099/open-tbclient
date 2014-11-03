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
import com.baidu.tbadk.core.util.az;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.regex.Pattern;
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
    private static int Ej;
    public static String Gd;
    private static HttpClient Ge;
    private HttpGet Gb;
    private final com.baidu.adp.lib.network.http.e Gc;
    private Context mContext;
    public boolean mS;
    private static volatile String Ek = null;
    private static volatile boolean El = false;
    private static Pattern ke = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams Gf = new BasicHttpParams();
    private boolean ee = false;
    private boolean Gg = false;
    private int Gh = 0;
    private int Em = 0;
    private volatile boolean Eo = false;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (Gi) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Gj) with 'values()' method */
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
        Ej = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(Gf, 5000);
        HttpConnectionParams.setSoTimeout(Gf, 30000);
        HttpConnectionParams.setSocketBufferSize(Gf, 1024);
        HttpConnectionParams.setTcpNoDelay(Gf, true);
        HttpClientParams.setRedirecting(Gf, true);
        ConnManagerParams.setMaxConnectionsPerRoute(Gf, new ConnPerRouteBean(10));
        ConnManagerParams.setTimeout(Gf, 10000L);
        ConnManagerParams.setMaxTotalConnections(Gf, 10);
        HttpProtocolParams.setUserAgent(Gf, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        Ge = new DefaultHttpClient(new ThreadSafeClientConnManager(Gf, schemeRegistry), Gf);
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            Ej = 4194304;
        }
    }

    public ImgHttpClient(com.baidu.adp.lib.network.http.e eVar) {
        mj();
        this.Gc = eVar;
        this.mContext = TbadkApplication.m251getInst().getApp();
    }

    public static void mj() {
        synchronized (ImgHttpClient.class) {
            if (!El) {
                El = true;
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
                    Ek = "Basic " + az.k((String.valueOf(string) + ":" + string2).getBytes());
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
        this.Eo = true;
        this.Gc.dR().kE = true;
        nf();
    }

    private void nf() {
        try {
            if (this.Gb != null) {
                this.Gb.abort();
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
                        if (Gd == null) {
                            Gd = com.baidu.adp.lib.util.j.fq();
                        }
                        if (Gd != null && Gd.length() > 0) {
                            if (bW(Gd)) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(Gd);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                this.Gb = new HttpGet(sb.toString());
                                this.Gb.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                                    this.Gb.setHeader("client_user_token", TbadkApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = Gf.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    Gf.setParameter("http.route.default-proxy", new HttpHost(Gd, com.baidu.adp.lib.util.j.fr()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(Gd) || httpHost.getPort() != com.baidu.adp.lib.util.j.fr()) {
                                        Gf.setParameter("http.route.default-proxy", new HttpHost(Gd, com.baidu.adp.lib.util.j.fr()));
                                    }
                                }
                                this.Gb = new HttpGet(str);
                                if (Ek != null) {
                                    this.Gb.setHeader("Proxy-Authorization", Ek);
                                }
                                if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                                    this.Gb.setHeader("client_user_token", TbadkApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (str2 == null || str2.length() == 0) {
                    this.Gb = a.mT().o(str, this.Gh);
                } else {
                    this.Gb = a.mT().g(str, str2, str3);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [512=12, 513=24, 514=12, 515=12, 516=24, 517=24, 518=12, 501=12, 502=12, 506=12, 508=12, 509=12, 510=12, 511=12] */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x048f, code lost:
        if (((int) r16.getContentLength()) <= com.baidu.tbadk.core.util.httpNet.ImgHttpClient.Ej) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0491, code lost:
        if (r6 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0493, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x04e3, code lost:
        r0 = new byte[1024];
        r18 = new java.io.ByteArrayOutputStream(1024);
        r3 = 0;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x04fa, code lost:
        if (r15.getFirstHeader("imgsrc") == null) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x04fc, code lost:
        r19 = r15.getFirstHeader("imgsrc").toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0508, code lost:
        if (r19 == null) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x050e, code lost:
        if (r19.length() <= 0) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0510, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0511, code lost:
        if (r7 == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0513, code lost:
        r7 = new byte[23];
        r19 = r6.read(r7, 0, 23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0539, code lost:
        if (new java.lang.String(r7, 0, r7.length).equalsIgnoreCase("app:tiebaclient;type:0;") != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x053b, code lost:
        r18.write(r7, 0, r19);
        r3 = 0 + r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x054e, code lost:
        if (r15.getFirstHeader("Src-Content-Type") == null) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0562, code lost:
        if ("image/gif".equalsIgnoreCase(r15.getFirstHeader("Src-Content-Type").getValue()) == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0564, code lost:
        r23.ee = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x056d, code lost:
        if (r23.Eo != false) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0571, code lost:
        if (r3 >= com.baidu.tbadk.core.util.httpNet.ImgHttpClient.Ej) goto L251;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0573, code lost:
        r7 = r6.read(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x057d, code lost:
        if (r7 != (-1)) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x057f, code lost:
        r11.kt = -9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0587, code lost:
        if (r23.Eo == false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0589, code lost:
        if (r6 == null) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x058b, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x05d6, code lost:
        r23.ee = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x062a, code lost:
        r18.write(r0, 0, r7);
        r3 = r3 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x063c, code lost:
        if (r3 >= com.baidu.tbadk.core.util.httpNet.ImgHttpClient.Ej) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x063e, code lost:
        r5 = r18.toByteArray();
        r18.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0649, code lost:
        if (r16.getContentEncoding() == null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x064b, code lost:
        r7 = r16.getContentEncoding().getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0653, code lost:
        if (r7 == null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x065d, code lost:
        if (r7.contains("gzip") == false) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x065f, code lost:
        r7 = new java.io.ByteArrayInputStream(r5);
        r16 = new java.io.ByteArrayOutputStream(1024);
        com.baidu.tbadk.util.d.a(r7, r16);
        r5 = r16.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0674, code lost:
        r11.kl = r3;
        r11.retry = r4 + 1;
        r11.ko = java.lang.System.currentTimeMillis() - r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0688, code lost:
        if (r15.getFirstHeader("Error-Message") == null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x068a, code lost:
        r7 = r15.getFirstHeader("Error-Message");
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0690, code lost:
        if (r7 == null) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x069a, code lost:
        if (android.text.TextUtils.isEmpty(r7.getValue()) != false) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x06a6, code lost:
        if (r7.getValue().equalsIgnoreCase("OK") == false) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x06a8, code lost:
        r23.Gg = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x06ad, code lost:
        if (r3 <= 0) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x06af, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x06b1, code lost:
        if (r6 == null) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x06b3, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x06fd, code lost:
        r23.Gc.dR().responseCode = -11;
        r11.kr = r23.mContext.getResources().getString(com.baidu.tieba.y.data_too_big);
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x071f, code lost:
        r23.Gg = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x0778, code lost:
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String b;
        int indexOf;
        int i2;
        int indexOf2;
        int indexOf3;
        int indexOf4;
        int indexOf5;
        int indexOf6;
        int indexOf7;
        boolean z;
        int indexOf8;
        int indexOf9;
        int indexOf10;
        int indexOf11;
        int indexOf12;
        byte[] bArr = null;
        if (i <= 0) {
            i = 5;
        }
        int i3 = 0;
        while (true) {
            if (this.Eo || i3 >= i) {
                break;
            }
            this.Gh = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.Gc.a(dVar);
            dVar.kt = -1;
            InputStream inputStream = null;
            b = this.Gc.dQ().b(dVar);
            try {
                try {
                    try {
                        dVar.kt = -2;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (str == null || str.length() == 0) {
                            bV(b);
                            dVar.ku = a.mT().bD(this.Gh);
                        } else {
                            h(b, str, str2);
                            dVar.ku = str;
                        }
                        dVar.kt = -3;
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                            }
                        }
                        nf();
                        if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf6 = b.indexOf("hiphotos")) > 0 && indexOf6 < 20)) {
                            if (v(this.mContext) == NetworkState.WIFI) {
                                a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    this.Gc.dR().responseCode = -10;
                    dVar.kr = String.valueOf(String.valueOf(this.Gc.dR().responseCode)) + "|retryCount:" + i3 + "|" + e2.getClass() + "|" + e2.getMessage();
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    nf();
                    if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf5 = b.indexOf("hiphotos")) > 0 && indexOf5 < 20)) {
                        if (v(this.mContext) == NetworkState.WIFI) {
                            a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                        }
                    }
                } catch (HttpException e4) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    nf();
                    if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf4 = b.indexOf("hiphotos")) > 0 && indexOf4 < 20)) {
                        if (v(this.mContext) == NetworkState.WIFI) {
                            a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                            i2 = i3;
                        }
                    }
                    i2 = i3;
                }
            } catch (SocketException e6) {
                this.Gc.dR().responseCode = -12;
                dVar.kr = String.valueOf(String.valueOf(this.Gc.dR().responseCode)) + "|retryCount:" + i3 + "|" + e6.getClass() + "|" + e6.getMessage();
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                    }
                }
                nf();
                if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf3 = b.indexOf("hiphotos")) > 0 && indexOf3 < 20)) {
                    if (v(this.mContext) == NetworkState.WIFI) {
                        a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                        i2 = i3;
                    }
                }
                i2 = i3;
            } catch (SocketTimeoutException e8) {
                this.Gc.dR().responseCode = -13;
                dVar.kr = String.valueOf(String.valueOf(this.Gc.dR().responseCode)) + "|retryCount:" + i3 + "|" + e8.getClass() + "|" + e8.getMessage();
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                    }
                }
                nf();
                if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf2 = b.indexOf("hiphotos")) > 0 && indexOf2 < 20)) {
                    if (v(this.mContext) == NetworkState.WIFI) {
                        a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                        i2 = i3;
                    }
                }
                i2 = i3;
            } catch (IOException e10) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e11) {
                    }
                }
                nf();
                if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf = b.indexOf("hiphotos")) > 0 && indexOf < 20)) {
                    if (v(this.mContext) == NetworkState.WIFI) {
                        a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                        i2 = i3;
                    }
                }
                i2 = i3;
            }
            if (this.Gb != null) {
                if (!this.Eo) {
                    dVar.kt = -8;
                    HttpResponse execute = Ge.execute(this.Gb);
                    if (execute != null) {
                        if (execute.getStatusLine() != null) {
                            this.Gc.dR().responseCode = execute.getStatusLine().getStatusCode();
                            if (execute.getEntity() != null) {
                                HttpEntity entity = execute.getEntity();
                                InputStream content = entity.getContent();
                                if (entity.getContentType() == null) {
                                    break;
                                }
                                String obj = entity.getContentType().toString();
                                this.Gc.dR().contentType = obj;
                                if (!obj.contains("text/vnd.wap.wml")) {
                                    break;
                                } else if (this.Em < 1) {
                                    nf();
                                    this.Em++;
                                    this.Gc.dR().responseCode = 0;
                                    i2 = i3 - 1;
                                    if (content != null) {
                                        try {
                                            content.close();
                                        } catch (Exception e12) {
                                        }
                                    }
                                    nf();
                                    if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i2 >= i - 1) && (indexOf12 = b.indexOf("hiphotos")) > 0 && indexOf12 < 20)) {
                                        if (v(this.mContext) == NetworkState.WIFI) {
                                            a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                                        }
                                    }
                                    bArr = bArr;
                                    i3 = i2 + 1;
                                } else {
                                    if (content != null) {
                                        try {
                                            content.close();
                                        } catch (Exception e13) {
                                        }
                                    }
                                    nf();
                                    if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf11 = b.indexOf("hiphotos")) > 0 && indexOf11 < 20)) {
                                        if (v(this.mContext) == NetworkState.WIFI) {
                                            a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                                        }
                                    }
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
                } else {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    nf();
                    if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf7 = b.indexOf("hiphotos")) > 0 && indexOf7 < 20)) {
                        if (v(this.mContext) == NetworkState.WIFI) {
                            a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                        }
                    }
                }
            } else {
                throw new SocketException("network not available.");
            }
        }
        nf();
        if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf9 = b.indexOf("hiphotos")) > 0 && indexOf9 < 20)) {
            if (v(this.mContext) == NetworkState.WIFI) {
                a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
            }
        }
        this.Em = 0;
        this.Gc.dR().kG = bArr;
        nf();
        if ((str == null || str.length() == 0) && b != null) {
            if ((dVar.ku != null || i3 >= i - 1) && (indexOf10 = b.indexOf("hiphotos")) > 0 && indexOf10 < 20) {
                if (v(this.mContext) == NetworkState.WIFI) {
                    a.mT().b(b, dVar.ku, false, System.currentTimeMillis() - currentTimeMillis > 3000);
                    return;
                }
                return;
            }
            return;
        }
        return;
        nf();
        if ((str == null || str.length() == 0) && b != null && ((dVar.ku != null || i3 >= i - 1) && (indexOf8 = b.indexOf("hiphotos")) > 0 && indexOf8 < 20)) {
            if (v(this.mContext) == NetworkState.WIFI) {
                a.mT().b(b, dVar.ku, z, System.currentTimeMillis() - currentTimeMillis > 3000);
            }
        }
        this.Em = 0;
        this.Gc.dR().kG = bArr;
    }

    public void ng() {
        a(null, null, -1);
    }

    public boolean bM() {
        return this.ee;
    }

    public boolean nh() {
        return this.Gg;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        dM();
    }
}
