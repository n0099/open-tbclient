package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.g.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
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
public class f implements a.InterfaceC0006a {
    private static int aba;
    public static String adq;
    private static HttpClient adr;
    private static String adw;
    private static int adx;
    private static long ady;
    private HttpGet adm;
    private final com.baidu.adp.lib.network.http.f adp;
    public boolean adu;
    private final Context mContext;
    private static volatile String adk = null;
    private static volatile boolean adl = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ads = new BasicHttpParams();
    private boolean sb = false;
    private boolean adt = false;
    private int adv = 0;
    private int adn = 0;
    private volatile boolean ado = false;

    static {
        aba = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(ads, 5000);
        HttpConnectionParams.setSoTimeout(ads, 30000);
        HttpConnectionParams.setSocketBufferSize(ads, 1024);
        HttpConnectionParams.setTcpNoDelay(ads, true);
        HttpClientParams.setRedirecting(ads, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ads, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ads, 10000L);
        ConnManagerParams.setMaxTotalConnections(ads, 15);
        HttpProtocolParams.setUserAgent(ads, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        adr = new DefaultHttpClient(new ThreadSafeClientConnManager(ads, schemeRegistry), ads);
        adr.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            aba = 4194304;
        }
        adw = null;
        adx = 0;
        ady = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        wT();
        this.adp = fVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void wT() {
        synchronized (f.class) {
            if (!adl) {
                adl = true;
                wU();
            }
        }
    }

    public static synchronized void wU() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    adk = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void gX() {
        this.ado = true;
        this.adp.hh().vK = true;
        wV();
    }

    private void wV() {
        try {
            if (this.adm != null) {
                this.adm.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void n(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().adi) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.jf()) {
            this.adu = false;
            try {
                if (com.baidu.adp.lib.util.i.jh()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (adq == null) {
                            adq = com.baidu.adp.lib.util.i.jp();
                        }
                        if (adq != null && adq.length() > 0) {
                            this.adu = true;
                            if (dK(adq) && com.baidu.adp.lib.util.i.jr()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(adq);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.adm = e.getInstance().httpGetFactory(sb.toString(), this.adv, false);
                                    } else {
                                        this.adm = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.adm = new HttpGet(sb.toString());
                                }
                                this.adm.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.adm.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ads.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ads.setParameter("http.route.default-proxy", new HttpHost(adq, com.baidu.adp.lib.util.i.jq()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(adq) || httpHost.getPort() != com.baidu.adp.lib.util.i.jq()) {
                                        ads.setParameter("http.route.default-proxy", new HttpHost(adq, com.baidu.adp.lib.util.i.jq()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.adm = e.getInstance().httpGetFactory(str, this.adv, false);
                                    } else {
                                        this.adm = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.adm = new HttpGet(str);
                                }
                                if (adk != null) {
                                    this.adm.setHeader("Proxy-Authorization", adk);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.adm.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.jh()) {
                            if (!this.adu || this.adm == null) {
                                this.adm = e.getInstance().httpGetFactory(str, this.adv, false);
                            }
                        } else {
                            this.adm = e.getInstance().httpGetFactory(str, this.adv, true);
                        }
                    } else {
                        this.adm = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.adm = new HttpGet(str);
                }
                this.adm.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean dK(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [623=13, 624=13, 628=13, 634=13, 635=13, 636=13, 637=13, 638=13, 639=26, 641=13, 642=13, 643=13, 644=13, 647=13, 648=26, 649=13, 650=13, 651=26, 652=13, 653=13, 654=13, 655=13, 657=26, 658=13] */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x096e, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0c3a  */
    /* JADX WARN: Removed duplicated region for block: B:657:0x0c58  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0c7b  */
    /* JADX WARN: Removed duplicated region for block: B:739:0x0c1a A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        boolean z4;
        boolean z5;
        boolean jg;
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
        byte[] bArr = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().adi) {
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
            if (this.ado || i2 >= i) {
                break;
            }
            this.adv = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.adp.a(eVar);
            eVar.vy = -1;
            InputStream inputStream2 = null;
            c = this.adp.hg().c(eVar);
            try {
                eVar.vy = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    n(c, null, null);
                    if (z16) {
                        eVar.vz = e.getInstance().getCachedCdnIp(this.adv);
                    }
                } else {
                    n(c, str, str2);
                    eVar.vz = str;
                }
                eVar.vy = -3;
            } catch (HttpException e) {
                e = e;
                inputStream = null;
            } catch (SocketException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (IllegalStateException e4) {
                e = e4;
                inputStream = null;
            } catch (SocketTimeoutException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.adm == null) {
                throw new SocketException("network not available.");
            }
            if (this.ado) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                wV();
                this.adp.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean jg2 = com.baidu.adp.lib.util.i.jg();
                    if ((jg2 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (jg2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                        } else if (com.baidu.adp.lib.util.i.jk()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                        }
                        e.getInstance().result(c, eVar.vz, z17, z8, jg2);
                    }
                }
            } else {
                eVar.vy = -8;
                HttpResponse execute = adr.execute(this.adm);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.adp.hh().responseCode = execute.getStatusLine().getStatusCode();
                eVar.vx = this.adp.hh().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                try {
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (HttpException e7) {
                    e = e7;
                } catch (IllegalStateException e8) {
                    e = e8;
                } catch (SocketException e9) {
                    e = e9;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                } catch (IOException e11) {
                    e = e11;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.adp.hh().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.adn < 1) {
                            wV();
                            this.adn++;
                            this.adp.hh().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            wV();
                            this.adp.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jg3 = com.baidu.adp.lib.util.i.jg();
                                if ((jg3 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jg3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                                    } else if (com.baidu.adp.lib.util.i.jk()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                                    }
                                    e.getInstance().result(c, eVar.vz, z17, z14, jg3);
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
                            wV();
                            this.adp.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jg4 = com.baidu.adp.lib.util.i.jg();
                                if ((jg4 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jg4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                                    } else if (com.baidu.adp.lib.util.i.jk()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                                    }
                                    e.getInstance().result(c, eVar.vz, z17, z13, jg4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aba) {
                    this.adp.hh().vL = -11;
                    eVar.vw = this.mContext.getResources().getString(t.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    wV();
                    this.adp.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean jg5 = com.baidu.adp.lib.util.i.jg();
                        if ((jg5 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (jg5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                            } else if (com.baidu.adp.lib.util.i.jk()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                            }
                            e.getInstance().result(c, eVar.vz, z17, z9, jg5);
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
                        this.sb = true;
                    } else {
                        this.sb = false;
                    }
                }
                while (!this.ado && i3 < aba && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.vy = -9;
                if (this.ado) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    wV();
                    this.adp.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean jg6 = com.baidu.adp.lib.util.i.jg();
                        if ((jg6 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (jg6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                            } else if (com.baidu.adp.lib.util.i.jk()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                            }
                            e.getInstance().result(c, eVar.vz, z17, z10, jg6);
                        }
                    }
                } else {
                    if (i3 < aba) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.adp.hh().vL = -11;
                        eVar.vw = this.mContext.getResources().getString(t.j.data_too_big);
                    }
                    eVar.vq = i3;
                    eVar.vt = i2 + 1;
                    eVar.vs = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.adt = false;
                        } else {
                            this.adt = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.adp.hh().responseCode == 200 || this.adp.hh().responseCode == 302)) ? z17 : true;
                    try {
                        if (com.baidu.adp.b.a.mg() != null && eVar != null) {
                            com.baidu.adp.b.a.mg().a(TbConfig.TMP_PIC_DIR_NAME, eVar.vp, eVar.vq);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dL(value);
                            break;
                        }
                        break;
                    } catch (SocketException e16) {
                        e = e16;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.adp.hh().vL = -12;
                            eVar.vw = "errorCode:" + String.valueOf(this.adp.hh().vL) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e17) {
                                }
                            }
                            wV();
                            this.adp.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jg7 = com.baidu.adp.lib.util.i.jg();
                                if ((jg7 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                                    long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jg7) {
                                        z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                                    } else if (com.baidu.adp.lib.util.i.jk()) {
                                        z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                                    } else {
                                        z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                                    }
                                    e.getInstance().result(c, eVar.vz, z17, z7, jg7);
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
                                } catch (Exception e18) {
                                }
                            }
                            wV();
                            this.adp.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                jg = com.baidu.adp.lib.util.i.jg();
                                if ((jg ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                                    long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!jg) {
                                        z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                                    } else if (com.baidu.adp.lib.util.i.jk()) {
                                        z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                                    } else {
                                        z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                                    }
                                    e.getInstance().result(c, eVar.vz, z17, z6, jg);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        z17 = z11;
                        this.adp.hh().vL = -13;
                        eVar.vw = "errorCode:" + String.valueOf(this.adp.hh().vL) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e20) {
                            }
                        }
                        wV();
                        this.adp.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean jg8 = com.baidu.adp.lib.util.i.jg();
                            if ((jg8 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                if (jg8) {
                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                                } else if (com.baidu.adp.lib.util.i.jk()) {
                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                                } else {
                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                                }
                                e.getInstance().result(c, eVar.vz, z17, z5, jg8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e21) {
                        e = e21;
                        z17 = z11;
                        this.adp.hh().vL = -19;
                        eVar.vw = "errorCode:" + String.valueOf(this.adp.hh().vL) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        wV();
                        this.adp.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean jg9 = com.baidu.adp.lib.util.i.jg();
                            if ((jg9 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                                long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                if (jg9) {
                                    z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                                } else if (com.baidu.adp.lib.util.i.jk()) {
                                    z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                                } else {
                                    z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                                }
                                e.getInstance().result(c, eVar.vz, z17, z4, jg9);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e23) {
                        e = e23;
                        z17 = z11;
                        this.adp.hh().vL = -19;
                        eVar.vw = "errorCode:" + String.valueOf(this.adp.hh().vL) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        wV();
                        this.adp.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean jg10 = com.baidu.adp.lib.util.i.jg();
                            if ((jg10 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (jg10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                                } else if (com.baidu.adp.lib.util.i.jk()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                                }
                                e.getInstance().result(c, eVar.vz, z17, z3, jg10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e25) {
                        e = e25;
                        z17 = z11;
                        this.adp.hh().vL = -18;
                        eVar.vw = "errorCode:" + String.valueOf(this.adp.hh().vL) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        wV();
                        this.adp.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean jg11 = com.baidu.adp.lib.util.i.jg();
                            if ((jg11 ? eVar.vz != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (jg11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                                } else if (com.baidu.adp.lib.util.i.jk()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                                }
                                e.getInstance().result(c, eVar.vz, z17, z2, jg11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        wV();
                        this.adp.b(eVar);
                        if (str != null) {
                        }
                        jg = com.baidu.adp.lib.util.i.jg();
                        if (jg ? eVar.vz != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
                            if (!jg) {
                            }
                            e.getInstance().result(c, eVar.vz, z17, z6, jg);
                        }
                        throw th;
                    }
                }
            }
        }
        this.adn = 0;
        this.adp.hh().vN = bArr;
        wV();
        this.adp.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean jg12 = com.baidu.adp.lib.util.i.jg();
            if ((jg12 ? eVar.vz != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gj(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (jg12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().PZ);
                } else if (com.baidu.adp.lib.util.i.jk()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Qb);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Qa);
                }
                e.getInstance().result(c, eVar.vz, z11, z12, jg12);
            }
        }
        this.adn = 0;
        this.adp.hh().vN = bArr;
    }

    private void dL(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(adw) && (System.currentTimeMillis() - ady) - (1800000 * (adx / 3)) >= 0) {
            adx++;
            try {
                char[] charArray = TbadkCoreApplication.m411getInst().getCuid().toCharArray();
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
                adw = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean fO() {
        return this.sb;
    }

    public boolean wW() {
        return this.adt;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        gX();
    }
}
