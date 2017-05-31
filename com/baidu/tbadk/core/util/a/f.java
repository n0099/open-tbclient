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
    private static int aev;
    public static String agF;
    private static HttpClient agG;
    private static String agL;
    private static int agM;
    private static long agN;
    private HttpGet agB;
    private final com.baidu.adp.lib.network.http.f agE;
    public boolean agJ;
    private final Context mContext;
    private static volatile String agz = null;
    private static volatile boolean agA = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams agH = new BasicHttpParams();
    private boolean sb = false;
    private boolean agI = false;
    private int agK = 0;
    private int agC = 0;
    private volatile boolean agD = false;

    static {
        aev = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(agH, 5000);
        HttpConnectionParams.setSoTimeout(agH, 30000);
        HttpConnectionParams.setSocketBufferSize(agH, 1024);
        HttpConnectionParams.setTcpNoDelay(agH, true);
        HttpClientParams.setRedirecting(agH, true);
        ConnManagerParams.setMaxConnectionsPerRoute(agH, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(agH, 10000L);
        ConnManagerParams.setMaxTotalConnections(agH, 15);
        HttpProtocolParams.setUserAgent(agH, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        agG = new DefaultHttpClient(new ThreadSafeClientConnManager(agH, schemeRegistry), agH);
        agG.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            aev = 4194304;
        }
        agL = null;
        agM = 0;
        agN = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        vF();
        this.agE = fVar;
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
    }

    public static void vF() {
        synchronized (f.class) {
            if (!agA) {
                agA = true;
                vG();
            }
        }
    }

    public static synchronized void vG() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m9getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    agz = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void fs() {
        this.agD = true;
        this.agE.fC().vQ = true;
        vH();
    }

    private void vH() {
        try {
            if (this.agB != null) {
                this.agB.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().agx) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.hk()) {
            this.agJ = false;
            try {
                if (com.baidu.adp.lib.util.i.hm()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (agF == null) {
                            agF = com.baidu.adp.lib.util.i.hu();
                        }
                        if (agF != null && agF.length() > 0) {
                            this.agJ = true;
                            if (dH(agF) && com.baidu.adp.lib.util.i.hw()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(agF);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.agB = e.getInstance().httpGetFactory(sb.toString(), this.agK, false);
                                    } else {
                                        this.agB = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.agB = new HttpGet(sb.toString());
                                }
                                this.agB.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.agB.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = agH.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    agH.setParameter("http.route.default-proxy", new HttpHost(agF, com.baidu.adp.lib.util.i.hv()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(agF) || httpHost.getPort() != com.baidu.adp.lib.util.i.hv()) {
                                        agH.setParameter("http.route.default-proxy", new HttpHost(agF, com.baidu.adp.lib.util.i.hv()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.agB = e.getInstance().httpGetFactory(str, this.agK, false);
                                    } else {
                                        this.agB = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.agB = new HttpGet(str);
                                }
                                if (agz != null) {
                                    this.agB.setHeader("Proxy-Authorization", agz);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.agB.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.hm()) {
                            if (!this.agJ || this.agB == null) {
                                this.agB = e.getInstance().httpGetFactory(str, this.agK, false);
                            }
                        } else {
                            this.agB = e.getInstance().httpGetFactory(str, this.agK, true);
                        }
                    } else {
                        this.agB = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.agB = new HttpGet(str);
                }
                this.agB.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean dH(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [633=13, 634=13, 638=13, 644=13, 645=13, 646=13, 647=13, 648=13, 649=26, 651=13, 652=13, 653=13, 654=13, 657=13, 658=26, 659=13, 660=13, 661=26, 662=13, 663=13, 664=13, 665=13, 667=26, 668=13] */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x09a7, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0c75  */
    /* JADX WARN: Removed duplicated region for block: B:664:0x0c93  */
    /* JADX WARN: Removed duplicated region for block: B:672:0x0cb6  */
    /* JADX WARN: Removed duplicated region for block: B:757:0x0c55 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        boolean hl;
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
            if (!e.getInstance().agx) {
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
            if (this.agD || i2 >= i) {
                break;
            }
            this.agK = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.agE.a(eVar);
            eVar.vC = -1;
            InputStream inputStream2 = null;
            c = this.agE.fB().c(eVar);
            try {
                eVar.vC = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    l(c, null, null);
                    if (z16) {
                        eVar.vD = e.getInstance().getCachedCdnIp(this.agK);
                    }
                } else {
                    l(c, str, str2);
                    eVar.vD = str;
                }
                eVar.vC = -3;
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
            if (this.agB == null) {
                throw new SocketException("network not available.");
            }
            if (this.agD) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                vH();
                this.agE.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean hl2 = com.baidu.adp.lib.util.i.hl();
                    if ((hl2 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (hl2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().QR);
                        } else if (com.baidu.adp.lib.util.i.hp()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().QT);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().QS);
                        }
                        e.getInstance().result(c, eVar.vD, z17, z8, hl2);
                    }
                }
            } else {
                eVar.vC = -8;
                HttpResponse execute = agG.execute(this.agB);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.agE.fC().responseCode = execute.getStatusLine().getStatusCode();
                eVar.vB = this.agE.fC().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.vF = headers[0].getValue();
                            eVar.vG = headers[1].getValue();
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
                    this.agE.fC().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.agC < 1) {
                            vH();
                            this.agC++;
                            this.agE.fC().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            vH();
                            this.agE.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hl3 = com.baidu.adp.lib.util.i.hl();
                                if ((hl3 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hl3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().QR);
                                    } else if (com.baidu.adp.lib.util.i.hp()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().QT);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().QS);
                                    }
                                    e.getInstance().result(c, eVar.vD, z17, z14, hl3);
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
                            vH();
                            this.agE.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hl4 = com.baidu.adp.lib.util.i.hl();
                                if ((hl4 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hl4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().QR);
                                    } else if (com.baidu.adp.lib.util.i.hp()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().QT);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().QS);
                                    }
                                    e.getInstance().result(c, eVar.vD, z17, z13, hl4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aev) {
                    this.agE.fC().vR = -11;
                    eVar.vA = this.mContext.getResources().getString(w.l.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    vH();
                    this.agE.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hl5 = com.baidu.adp.lib.util.i.hl();
                        if ((hl5 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (hl5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().QR);
                            } else if (com.baidu.adp.lib.util.i.hp()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().QT);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().QS);
                            }
                            e.getInstance().result(c, eVar.vD, z17, z9, hl5);
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
                while (!this.agD && i3 < aev && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.vC = -9;
                if (this.agD) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    vH();
                    this.agE.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hl6 = com.baidu.adp.lib.util.i.hl();
                        if ((hl6 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (hl6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().QR);
                            } else if (com.baidu.adp.lib.util.i.hp()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().QT);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().QS);
                            }
                            e.getInstance().result(c, eVar.vD, z17, z10, hl6);
                        }
                    }
                } else {
                    if (i3 < aev) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.agE.fC().vR = -11;
                        eVar.vA = this.mContext.getResources().getString(w.l.data_too_big);
                    }
                    eVar.vv = i3;
                    eVar.vx = i2 + 1;
                    eVar.vw = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.agI = false;
                        } else {
                            this.agI = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.agE.fC().responseCode == 200 || this.agE.fC().responseCode == 302)) ? z17 : true;
                    try {
                        if (ITrafficStatsNativeManager.kn() != null && eVar != null) {
                            ITrafficStatsNativeManager.kn().a(TbConfig.TMP_PIC_DIR_NAME, eVar.vu, eVar.vv);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dI(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.agE.fC().vR = -18;
                        eVar.vA = "errorCode:" + String.valueOf(this.agE.fC().vR) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vH();
                        this.agE.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hl7 = com.baidu.adp.lib.util.i.hl();
                            if ((hl7 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (hl7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().QR);
                                } else if (com.baidu.adp.lib.util.i.hp()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().QT);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().QS);
                                }
                                e.getInstance().result(c, eVar.vD, z17, z7, hl7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.agE.fC().vR = -19;
                        eVar.vA = "errorCode:" + String.valueOf(this.agE.fC().vR) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        vH();
                        this.agE.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hl8 = com.baidu.adp.lib.util.i.hl();
                            if ((hl8 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (hl8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().QR);
                                } else if (com.baidu.adp.lib.util.i.hp()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().QT);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().QS);
                                }
                                e.getInstance().result(c, eVar.vD, z17, z6, hl8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.agE.fC().vR = -12;
                            eVar.vA = "errorCode:" + String.valueOf(this.agE.fC().vR) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            vH();
                            this.agE.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hl9 = com.baidu.adp.lib.util.i.hl();
                                if ((hl9 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hl9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().QR);
                                    } else if (com.baidu.adp.lib.util.i.hp()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().QT);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().QS);
                                    }
                                    e.getInstance().result(c, eVar.vD, z17, z5, hl9);
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
                            vH();
                            this.agE.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                hl = com.baidu.adp.lib.util.i.hl();
                                if ((hl ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hl) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().QR);
                                    } else if (com.baidu.adp.lib.util.i.hp()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().QT);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().QS);
                                    }
                                    e.getInstance().result(c, eVar.vD, z17, z4, hl);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.agE.fC().vR = -13;
                        eVar.vA = "errorCode:" + String.valueOf(this.agE.fC().vR) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        vH();
                        this.agE.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hl10 = com.baidu.adp.lib.util.i.hl();
                            if ((hl10 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (hl10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().QR);
                                } else if (com.baidu.adp.lib.util.i.hp()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().QT);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().QS);
                                }
                                e.getInstance().result(c, eVar.vD, z17, z3, hl10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.agE.fC().vR = -19;
                        eVar.vA = "errorCode:" + String.valueOf(this.agE.fC().vR) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        vH();
                        this.agE.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hl11 = com.baidu.adp.lib.util.i.hl();
                            if ((hl11 ? eVar.vD != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (hl11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().QR);
                                } else if (com.baidu.adp.lib.util.i.hp()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().QT);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().QS);
                                }
                                e.getInstance().result(c, eVar.vD, z17, z2, hl11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        vH();
                        this.agE.b(eVar);
                        if (str != null) {
                        }
                        hl = com.baidu.adp.lib.util.i.hl();
                        if (hl ? eVar.vD != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!hl) {
                            }
                            e.getInstance().result(c, eVar.vD, z17, z4, hl);
                        }
                        throw th;
                    }
                }
            }
        }
        vH();
        this.agE.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean hl12 = com.baidu.adp.lib.util.i.hl();
            if ((hl12 ? eVar.vD != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gb(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (hl12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().QR);
                } else if (com.baidu.adp.lib.util.i.hp()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().QT);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().QS);
                }
                e.getInstance().result(c, eVar.vD, z11, z12, hl12);
            }
        }
        this.agC = 0;
        this.agE.fC().vT = bArr;
    }

    private void dI(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(agL) && (System.currentTimeMillis() - agN) - (1800000 * (agM / 3)) >= 0) {
            agM++;
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
                agL = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean ef() {
        return this.sb;
    }

    public boolean vI() {
        return this.agI;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        fs();
    }
}
