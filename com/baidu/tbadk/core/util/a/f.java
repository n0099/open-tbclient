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
import com.baidu.tieba.r;
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
    private static int ZG;
    public static String abR;
    private static HttpClient abS;
    private static String abX;
    private static int abY;
    private static long abZ;
    private HttpGet abN;
    private final com.baidu.adp.lib.network.http.f abQ;
    public boolean abV;
    private final Context mContext;
    private static volatile String abL = null;
    private static volatile boolean abM = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams abT = new BasicHttpParams();
    private boolean kE = false;
    private boolean abU = false;
    private int abW = 0;
    private int abO = 0;
    private volatile boolean abP = false;

    static {
        ZG = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(abT, 5000);
        HttpConnectionParams.setSoTimeout(abT, 30000);
        HttpConnectionParams.setSocketBufferSize(abT, 1024);
        HttpConnectionParams.setTcpNoDelay(abT, true);
        HttpClientParams.setRedirecting(abT, true);
        ConnManagerParams.setMaxConnectionsPerRoute(abT, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(abT, 10000L);
        ConnManagerParams.setMaxTotalConnections(abT, 15);
        HttpProtocolParams.setUserAgent(abT, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        abS = new DefaultHttpClient(new ThreadSafeClientConnManager(abT, schemeRegistry), abT);
        abS.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            ZG = 4194304;
        }
        abX = null;
        abY = 0;
        abZ = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        vA();
        this.abQ = fVar;
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
    }

    public static void vA() {
        synchronized (f.class) {
            if (!abM) {
                abM = true;
                vB();
            }
        }
    }

    public static synchronized void vB() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m9getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    abL = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void ee() {
        this.abP = true;
        this.abQ.eo().ox = true;
        vC();
    }

    private void vC() {
        try {
            if (this.abN != null) {
                this.abN.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void r(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().abJ) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.gk()) {
            this.abV = false;
            try {
                if (com.baidu.adp.lib.util.i.gm()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (abR == null) {
                            abR = com.baidu.adp.lib.util.i.gu();
                        }
                        if (abR != null && abR.length() > 0) {
                            this.abV = true;
                            if (dM(abR) && com.baidu.adp.lib.util.i.gw()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(abR);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.abN = e.getInstance().httpGetFactory(sb.toString(), this.abW, false);
                                    } else {
                                        this.abN = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.abN = new HttpGet(sb.toString());
                                }
                                this.abN.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.abN.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = abT.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    abT.setParameter("http.route.default-proxy", new HttpHost(abR, com.baidu.adp.lib.util.i.gv()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(abR) || httpHost.getPort() != com.baidu.adp.lib.util.i.gv()) {
                                        abT.setParameter("http.route.default-proxy", new HttpHost(abR, com.baidu.adp.lib.util.i.gv()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.abN = e.getInstance().httpGetFactory(str, this.abW, false);
                                    } else {
                                        this.abN = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.abN = new HttpGet(str);
                                }
                                if (abL != null) {
                                    this.abN.setHeader("Proxy-Authorization", abL);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.abN.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            if (!this.abV || this.abN == null) {
                                this.abN = e.getInstance().httpGetFactory(str, this.abW, false);
                            }
                        } else {
                            this.abN = e.getInstance().httpGetFactory(str, this.abW, true);
                        }
                    } else {
                        this.abN = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.abN = new HttpGet(str);
                }
                this.abN.setHeader("needginfo", "1");
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
        boolean gl;
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
            if (!e.getInstance().abJ) {
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
            if (this.abP || i2 >= i) {
                break;
            }
            this.abW = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.abQ.a(eVar);
            eVar.of = -1;
            InputStream inputStream2 = null;
            c = this.abQ.en().c(eVar);
            try {
                eVar.of = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    r(c, null, null);
                    if (z16) {
                        eVar.og = e.getInstance().getCachedCdnIp(this.abW);
                    }
                } else {
                    r(c, str, str2);
                    eVar.og = str;
                }
                eVar.of = -3;
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
            if (this.abN == null) {
                throw new SocketException("network not available.");
            }
            if (this.abP) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                vC();
                this.abQ.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean gl2 = com.baidu.adp.lib.util.i.gl();
                    if ((gl2 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (gl2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                        } else if (com.baidu.adp.lib.util.i.gp()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                        }
                        e.getInstance().result(c, eVar.og, z17, z8, gl2);
                    }
                }
            } else {
                eVar.of = -8;
                HttpResponse execute = abS.execute(this.abN);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.abQ.eo().responseCode = execute.getStatusLine().getStatusCode();
                eVar.oe = this.abQ.eo().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.oi = headers[0].getValue();
                            eVar.oj = headers[1].getValue();
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
                    this.abQ.eo().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.abO < 1) {
                            vC();
                            this.abO++;
                            this.abQ.eo().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            vC();
                            this.abQ.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gl3 = com.baidu.adp.lib.util.i.gl();
                                if ((gl3 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gl3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                                    } else if (com.baidu.adp.lib.util.i.gp()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                                    }
                                    e.getInstance().result(c, eVar.og, z17, z14, gl3);
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
                            vC();
                            this.abQ.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gl4 = com.baidu.adp.lib.util.i.gl();
                                if ((gl4 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gl4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                                    } else if (com.baidu.adp.lib.util.i.gp()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                                    }
                                    e.getInstance().result(c, eVar.og, z17, z13, gl4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > ZG) {
                    this.abQ.eo().oy = -11;
                    eVar.od = this.mContext.getResources().getString(r.l.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    vC();
                    this.abQ.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean gl5 = com.baidu.adp.lib.util.i.gl();
                        if ((gl5 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (gl5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                            } else if (com.baidu.adp.lib.util.i.gp()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                            }
                            e.getInstance().result(c, eVar.og, z17, z9, gl5);
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
                        this.kE = true;
                    } else {
                        this.kE = false;
                    }
                }
                while (!this.abP && i3 < ZG && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.of = -9;
                if (this.abP) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    vC();
                    this.abQ.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean gl6 = com.baidu.adp.lib.util.i.gl();
                        if ((gl6 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (gl6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                            } else if (com.baidu.adp.lib.util.i.gp()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                            }
                            e.getInstance().result(c, eVar.og, z17, z10, gl6);
                        }
                    }
                } else {
                    if (i3 < ZG) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.abQ.eo().oy = -11;
                        eVar.od = this.mContext.getResources().getString(r.l.data_too_big);
                    }
                    eVar.nX = i3;
                    eVar.oa = i2 + 1;
                    eVar.nZ = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.abU = false;
                        } else {
                            this.abU = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.abQ.eo().responseCode == 200 || this.abQ.eo().responseCode == 302)) ? z17 : true;
                    try {
                        if (ITrafficStatsNativeManager.jp() != null && eVar != null) {
                            ITrafficStatsNativeManager.jp().a(TbConfig.TMP_PIC_DIR_NAME, eVar.nW, eVar.nX);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dN(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.abQ.eo().oy = -18;
                        eVar.od = "errorCode:" + String.valueOf(this.abQ.eo().oy) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vC();
                        this.abQ.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gl7 = com.baidu.adp.lib.util.i.gl();
                            if ((gl7 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (gl7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                                } else if (com.baidu.adp.lib.util.i.gp()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                                }
                                e.getInstance().result(c, eVar.og, z17, z7, gl7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.abQ.eo().oy = -19;
                        eVar.od = "errorCode:" + String.valueOf(this.abQ.eo().oy) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        vC();
                        this.abQ.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gl8 = com.baidu.adp.lib.util.i.gl();
                            if ((gl8 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (gl8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                                } else if (com.baidu.adp.lib.util.i.gp()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                                }
                                e.getInstance().result(c, eVar.og, z17, z6, gl8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.abQ.eo().oy = -12;
                            eVar.od = "errorCode:" + String.valueOf(this.abQ.eo().oy) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            vC();
                            this.abQ.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gl9 = com.baidu.adp.lib.util.i.gl();
                                if ((gl9 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gl9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                                    } else if (com.baidu.adp.lib.util.i.gp()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                                    }
                                    e.getInstance().result(c, eVar.og, z17, z5, gl9);
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
                            vC();
                            this.abQ.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                gl = com.baidu.adp.lib.util.i.gl();
                                if ((gl ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!gl) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                                    } else if (com.baidu.adp.lib.util.i.gp()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                                    }
                                    e.getInstance().result(c, eVar.og, z17, z4, gl);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.abQ.eo().oy = -13;
                        eVar.od = "errorCode:" + String.valueOf(this.abQ.eo().oy) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        vC();
                        this.abQ.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gl10 = com.baidu.adp.lib.util.i.gl();
                            if ((gl10 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (gl10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                                } else if (com.baidu.adp.lib.util.i.gp()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                                }
                                e.getInstance().result(c, eVar.og, z17, z3, gl10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.abQ.eo().oy = -19;
                        eVar.od = "errorCode:" + String.valueOf(this.abQ.eo().oy) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        vC();
                        this.abQ.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gl11 = com.baidu.adp.lib.util.i.gl();
                            if ((gl11 ? eVar.og != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (gl11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                                } else if (com.baidu.adp.lib.util.i.gp()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                                }
                                e.getInstance().result(c, eVar.og, z17, z2, gl11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        vC();
                        this.abQ.b(eVar);
                        if (str != null) {
                        }
                        gl = com.baidu.adp.lib.util.i.gl();
                        if (gl ? eVar.og != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!gl) {
                            }
                            e.getInstance().result(c, eVar.og, z17, z4, gl);
                        }
                        throw th;
                    }
                }
            }
        }
        vC();
        this.abQ.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean gl12 = com.baidu.adp.lib.util.i.gl();
            if ((gl12 ? eVar.og != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gj(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (gl12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Mp);
                } else if (com.baidu.adp.lib.util.i.gp()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Mr);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Mq);
                }
                e.getInstance().result(c, eVar.og, z11, z12, gl12);
            }
        }
        this.abO = 0;
        this.abQ.eo().oA = bArr;
    }

    private void dN(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(abX) && (System.currentTimeMillis() - abZ) - (1800000 * (abY / 3)) >= 0) {
            abY++;
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
                abX = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean cW() {
        return this.kE;
    }

    public boolean vD() {
        return this.abU;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        ee();
    }
}
