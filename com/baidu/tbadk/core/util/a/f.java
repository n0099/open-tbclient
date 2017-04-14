package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.trafficStats.ITrafficStatsNativeManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
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
public class f implements a.InterfaceC0005a {
    private static int afk;
    private static String ahB;
    private static int ahC;
    private static long ahD;
    public static String ahv;
    private static HttpClient ahw;
    private HttpGet ahr;
    private final com.baidu.adp.lib.network.http.f ahu;
    public boolean ahz;
    private final Context mContext;
    private static volatile String ahp = null;
    private static volatile boolean ahq = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ahx = new BasicHttpParams();
    private boolean rV = false;
    private boolean ahy = false;
    private int ahA = 0;
    private int ahs = 0;
    private volatile boolean aht = false;

    static {
        afk = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(ahx, 5000);
        HttpConnectionParams.setSoTimeout(ahx, 30000);
        HttpConnectionParams.setSocketBufferSize(ahx, 1024);
        HttpConnectionParams.setTcpNoDelay(ahx, true);
        HttpClientParams.setRedirecting(ahx, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ahx, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ahx, 10000L);
        ConnManagerParams.setMaxTotalConnections(ahx, 15);
        HttpProtocolParams.setUserAgent(ahx, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ahw = new DefaultHttpClient(new ThreadSafeClientConnManager(ahx, schemeRegistry), ahx);
        ahw.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            afk = 4194304;
        }
        ahB = null;
        ahC = 0;
        ahD = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        wu();
        this.ahu = fVar;
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
    }

    public static void wu() {
        synchronized (f.class) {
            if (!ahq) {
                ahq = true;
                wv();
            }
        }
    }

    public static synchronized void wv() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m9getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    ahp = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void fr() {
        this.aht = true;
        this.ahu.fB().vL = true;
        ww();
    }

    private void ww() {
        try {
            if (this.ahr != null) {
                this.ahr.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().ahn) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.hj()) {
            this.ahz = false;
            try {
                if (com.baidu.adp.lib.util.i.hl()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ahv == null) {
                            ahv = com.baidu.adp.lib.util.i.ht();
                        }
                        if (ahv != null && ahv.length() > 0) {
                            this.ahz = true;
                            if (dM(ahv) && com.baidu.adp.lib.util.i.hv()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ahv);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ahr = e.getInstance().httpGetFactory(sb.toString(), this.ahA, false);
                                    } else {
                                        this.ahr = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ahr = new HttpGet(sb.toString());
                                }
                                this.ahr.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ahr.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ahx.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ahx.setParameter("http.route.default-proxy", new HttpHost(ahv, com.baidu.adp.lib.util.i.hu()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ahv) || httpHost.getPort() != com.baidu.adp.lib.util.i.hu()) {
                                        ahx.setParameter("http.route.default-proxy", new HttpHost(ahv, com.baidu.adp.lib.util.i.hu()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ahr = e.getInstance().httpGetFactory(str, this.ahA, false);
                                    } else {
                                        this.ahr = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ahr = new HttpGet(str);
                                }
                                if (ahp != null) {
                                    this.ahr.setHeader("Proxy-Authorization", ahp);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ahr.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.hl()) {
                            if (!this.ahz || this.ahr == null) {
                                this.ahr = e.getInstance().httpGetFactory(str, this.ahA, false);
                            }
                        } else {
                            this.ahr = e.getInstance().httpGetFactory(str, this.ahA, true);
                        }
                    } else {
                        this.ahr = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.ahr = new HttpGet(str);
                }
                this.ahr.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean dM(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [633=13, 634=13, 638=13, 644=13, 645=13, 646=13, 647=13, 648=13, 649=26, 651=13, 652=13, 653=13, 654=13, 657=13, 658=26, 659=13, 660=13, 661=26, 662=13, 663=13, 664=13, 665=13, 667=26, 668=13] */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x09a6, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0c74  */
    /* JADX WARN: Removed duplicated region for block: B:664:0x0c92  */
    /* JADX WARN: Removed duplicated region for block: B:672:0x0cb5  */
    /* JADX WARN: Removed duplicated region for block: B:757:0x0c54 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.e eVar;
        String c;
        InputStream inputStream;
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3;
        boolean hk;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        long currentTimeMillis2;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        String value;
        String value2;
        int read;
        String obj;
        boolean z13;
        boolean z14;
        Header[] headers;
        byte[] bArr = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().ahn) {
                e.getInstance().init();
            }
        }
        boolean z16 = z15;
        if (i <= 0) {
            i = 5;
        }
        boolean z17 = false;
        int i2 = 0;
        while (true) {
            if (this.aht || i2 >= i) {
                break;
            }
            this.ahA = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.ahu.a(eVar);
            eVar.vx = -1;
            InputStream inputStream2 = null;
            c = this.ahu.fA().c(eVar);
            try {
                eVar.vx = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    l(c, null, null);
                    if (z16) {
                        eVar.vy = e.getInstance().getCachedCdnIp(this.ahA);
                    }
                } else {
                    l(c, str, str2);
                    eVar.vy = str;
                }
                eVar.vx = -3;
            } catch (IllegalStateException e) {
                e = e;
                inputStream = null;
            } catch (SocketException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (HttpException e4) {
                e = e4;
                inputStream = null;
            } catch (SocketTimeoutException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.ahr == null) {
                throw new SocketException("network not available.");
            }
            if (this.aht) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                ww();
                this.ahu.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean hk2 = com.baidu.adp.lib.util.i.hk();
                    if ((hk2 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (hk2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RK);
                        } else if (com.baidu.adp.lib.util.i.ho()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RM);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RL);
                        }
                        e.getInstance().result(c, eVar.vy, z17, z8, hk2);
                    }
                }
            } else {
                eVar.vx = -8;
                HttpResponse execute = ahw.execute(this.ahr);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ahu.fB().responseCode = execute.getStatusLine().getStatusCode();
                eVar.vw = this.ahu.fB().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.vA = headers[0].getValue();
                            eVar.vB = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (HttpException e7) {
                    e = e7;
                } catch (SocketException e8) {
                    e = e8;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e9) {
                    e = e9;
                } catch (IOException e10) {
                    e = e10;
                } catch (IllegalStateException e11) {
                    e = e11;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.ahu.fB().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.ahs < 1) {
                            ww();
                            this.ahs++;
                            this.ahu.fB().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            ww();
                            this.ahu.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hk3 = com.baidu.adp.lib.util.i.hk();
                                if ((hk3 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hk3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RK);
                                    } else if (com.baidu.adp.lib.util.i.ho()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RL);
                                    }
                                    e.getInstance().result(c, eVar.vy, z17, z14, hk3);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e13) {
                                }
                            }
                            ww();
                            this.ahu.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hk4 = com.baidu.adp.lib.util.i.hk();
                                if ((hk4 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hk4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RK);
                                    } else if (com.baidu.adp.lib.util.i.ho()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RL);
                                    }
                                    e.getInstance().result(c, eVar.vy, z17, z13, hk4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > afk) {
                    this.ahu.fB().vM = -11;
                    eVar.vv = this.mContext.getResources().getString(w.l.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    ww();
                    this.ahu.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hk5 = com.baidu.adp.lib.util.i.hk();
                        if ((hk5 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (hk5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RK);
                            } else if (com.baidu.adp.lib.util.i.ho()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RM);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RL);
                            }
                            e.getInstance().result(c, eVar.vy, z17, z9, hk5);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i3 = 0;
                boolean z18 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z18 = true;
                }
                if (z18) {
                    byte[] bArr3 = new byte[23];
                    int read2 = inputStream.read(bArr3, 0, 23);
                    if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                        byteArrayOutputStream.write(bArr3, 0, read2);
                        i3 = 0 + read2;
                    }
                }
                if (execute.getFirstHeader("Src-Content-Type") != null) {
                    if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                        this.rV = true;
                    } else {
                        this.rV = false;
                    }
                }
                while (!this.aht && i3 < afk && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.vx = -9;
                if (this.aht) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    ww();
                    this.ahu.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hk6 = com.baidu.adp.lib.util.i.hk();
                        if ((hk6 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (hk6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RK);
                            } else if (com.baidu.adp.lib.util.i.ho()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RM);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RL);
                            }
                            e.getInstance().result(c, eVar.vy, z17, z10, hk6);
                        }
                    }
                } else {
                    if (i3 < afk) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.ahu.fB().vM = -11;
                        eVar.vv = this.mContext.getResources().getString(w.l.data_too_big);
                    }
                    eVar.vp = i3;
                    eVar.vs = i2 + 1;
                    eVar.vr = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.ahy = false;
                        } else {
                            this.ahy = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.ahu.fB().responseCode == 200 || this.ahu.fB().responseCode == 302)) ? z17 : true;
                    try {
                        if (ITrafficStatsNativeManager.kn() != null && eVar != null) {
                            ITrafficStatsNativeManager.kn().a(TbConfig.TMP_PIC_DIR_NAME, eVar.vo, eVar.vp);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dN(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.ahu.fB().vM = -18;
                        eVar.vv = "errorCode:" + String.valueOf(this.ahu.fB().vM) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        ww();
                        this.ahu.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hk7 = com.baidu.adp.lib.util.i.hk();
                            if ((hk7 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (hk7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RK);
                                } else if (com.baidu.adp.lib.util.i.ho()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RL);
                                }
                                e.getInstance().result(c, eVar.vy, z17, z7, hk7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.ahu.fB().vM = -19;
                        eVar.vv = "errorCode:" + String.valueOf(this.ahu.fB().vM) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        ww();
                        this.ahu.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hk8 = com.baidu.adp.lib.util.i.hk();
                            if ((hk8 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (hk8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RK);
                                } else if (com.baidu.adp.lib.util.i.ho()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RL);
                                }
                                e.getInstance().result(c, eVar.vy, z17, z6, hk8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.ahu.fB().vM = -12;
                            eVar.vv = "errorCode:" + String.valueOf(this.ahu.fB().vM) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            ww();
                            this.ahu.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hk9 = com.baidu.adp.lib.util.i.hk();
                                if ((hk9 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hk9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RK);
                                    } else if (com.baidu.adp.lib.util.i.ho()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RL);
                                    }
                                    e.getInstance().result(c, eVar.vy, z17, z5, hk9);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e22) {
                                }
                            }
                            ww();
                            this.ahu.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                hk = com.baidu.adp.lib.util.i.hk();
                                if ((hk ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hk) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RK);
                                    } else if (com.baidu.adp.lib.util.i.ho()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RL);
                                    }
                                    e.getInstance().result(c, eVar.vy, z17, z4, hk);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.ahu.fB().vM = -13;
                        eVar.vv = "errorCode:" + String.valueOf(this.ahu.fB().vM) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        ww();
                        this.ahu.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hk10 = com.baidu.adp.lib.util.i.hk();
                            if ((hk10 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (hk10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RK);
                                } else if (com.baidu.adp.lib.util.i.ho()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RL);
                                }
                                e.getInstance().result(c, eVar.vy, z17, z3, hk10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.ahu.fB().vM = -19;
                        eVar.vv = "errorCode:" + String.valueOf(this.ahu.fB().vM) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        ww();
                        this.ahu.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hk11 = com.baidu.adp.lib.util.i.hk();
                            if ((hk11 ? eVar.vy != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (hk11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RK);
                                } else if (com.baidu.adp.lib.util.i.ho()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RL);
                                }
                                e.getInstance().result(c, eVar.vy, z17, z2, hk11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        ww();
                        this.ahu.b(eVar);
                        if (str != null) {
                        }
                        hk = com.baidu.adp.lib.util.i.hk();
                        if (hk ? eVar.vy != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!hk) {
                            }
                            e.getInstance().result(c, eVar.vy, z17, z4, hk);
                        }
                        throw th;
                    }
                }
            }
        }
        ww();
        this.ahu.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean hk12 = com.baidu.adp.lib.util.i.hk();
            if ((hk12 ? eVar.vy != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (hk12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RK);
                } else if (com.baidu.adp.lib.util.i.ho()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RM);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RL);
                }
                e.getInstance().result(c, eVar.vy, z11, z12, hk12);
            }
        }
        this.ahs = 0;
        this.ahu.fB().vO = bArr;
    }

    private void dN(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(ahB) && (System.currentTimeMillis() - ahD) - (1800000 * (ahC / 3)) >= 0) {
            ahC++;
            try {
                char[] charArray = TbadkCoreApplication.m9getInst().getCuid().toCharArray();
                StringBuilder sb = new StringBuilder();
                sb.append("http://");
                sb.append(str);
                int i = 0;
                while (i < charArray.length && i < 32) {
                    if (Character.isLetterOrDigit(charArray[i])) {
                        sb.append(charArray[i]);
                        i++;
                    }
                }
                sb.append(".tieba.galileo.baiduyundns.com");
                URL url = new URL(sb.toString());
                ahB = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean ee() {
        return this.rV;
    }

    public boolean wx() {
        return this.ahy;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        fr();
    }
}
