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
public class f implements a.InterfaceC0006a {
    private static int aas;
    public static String acF;
    private static HttpClient acG;
    private static String acL;
    private static int acM;
    private static long acN;
    private HttpGet acB;
    private final com.baidu.adp.lib.network.http.f acE;
    public boolean acJ;
    private final Context mContext;
    private static volatile String acz = null;
    private static volatile boolean acA = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams acH = new BasicHttpParams();
    private boolean kK = false;
    private boolean acI = false;
    private int acK = 0;
    private int acC = 0;
    private volatile boolean acD = false;

    static {
        aas = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(acH, 5000);
        HttpConnectionParams.setSoTimeout(acH, 30000);
        HttpConnectionParams.setSocketBufferSize(acH, 1024);
        HttpConnectionParams.setTcpNoDelay(acH, true);
        HttpClientParams.setRedirecting(acH, true);
        ConnManagerParams.setMaxConnectionsPerRoute(acH, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(acH, 10000L);
        ConnManagerParams.setMaxTotalConnections(acH, 15);
        HttpProtocolParams.setUserAgent(acH, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        acG = new DefaultHttpClient(new ThreadSafeClientConnManager(acH, schemeRegistry), acH);
        acG.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            aas = 4194304;
        }
        acL = null;
        acM = 0;
        acN = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        vG();
        this.acE = fVar;
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
    }

    public static void vG() {
        synchronized (f.class) {
            if (!acA) {
                acA = true;
                vH();
            }
        }
    }

    public static synchronized void vH() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m9getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    acz = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void eg() {
        this.acD = true;
        this.acE.eq().oE = true;
        vI();
    }

    private void vI() {
        try {
            if (this.acB != null) {
                this.acB.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void r(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().acx) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.gm()) {
            this.acJ = false;
            try {
                if (com.baidu.adp.lib.util.i.go()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (acF == null) {
                            acF = com.baidu.adp.lib.util.i.gw();
                        }
                        if (acF != null && acF.length() > 0) {
                            this.acJ = true;
                            if (dO(acF) && com.baidu.adp.lib.util.i.gy()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(acF);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.acB = e.getInstance().httpGetFactory(sb.toString(), this.acK, false);
                                    } else {
                                        this.acB = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.acB = new HttpGet(sb.toString());
                                }
                                this.acB.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.acB.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = acH.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    acH.setParameter("http.route.default-proxy", new HttpHost(acF, com.baidu.adp.lib.util.i.gx()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(acF) || httpHost.getPort() != com.baidu.adp.lib.util.i.gx()) {
                                        acH.setParameter("http.route.default-proxy", new HttpHost(acF, com.baidu.adp.lib.util.i.gx()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.acB = e.getInstance().httpGetFactory(str, this.acK, false);
                                    } else {
                                        this.acB = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.acB = new HttpGet(str);
                                }
                                if (acz != null) {
                                    this.acB.setHeader("Proxy-Authorization", acz);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.acB.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.go()) {
                            if (!this.acJ || this.acB == null) {
                                this.acB = e.getInstance().httpGetFactory(str, this.acK, false);
                            }
                        } else {
                            this.acB = e.getInstance().httpGetFactory(str, this.acK, true);
                        }
                    } else {
                        this.acB = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.acB = new HttpGet(str);
                }
                this.acB.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean dO(String str) {
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
        boolean gn;
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
            if (!e.getInstance().acx) {
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
            if (this.acD || i2 >= i) {
                break;
            }
            this.acK = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.acE.a(eVar);
            eVar.oo = -1;
            InputStream inputStream2 = null;
            c = this.acE.ep().c(eVar);
            try {
                eVar.oo = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    r(c, null, null);
                    if (z16) {
                        eVar.oq = e.getInstance().getCachedCdnIp(this.acK);
                    }
                } else {
                    r(c, str, str2);
                    eVar.oq = str;
                }
                eVar.oo = -3;
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
            if (this.acB == null) {
                throw new SocketException("network not available.");
            }
            if (this.acD) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                vI();
                this.acE.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean gn2 = com.baidu.adp.lib.util.i.gn();
                    if ((gn2 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (gn2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                        } else if (com.baidu.adp.lib.util.i.gr()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                        }
                        e.getInstance().result(c, eVar.oq, z17, z8, gn2);
                    }
                }
            } else {
                eVar.oo = -8;
                HttpResponse execute = acG.execute(this.acB);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.acE.eq().responseCode = execute.getStatusLine().getStatusCode();
                eVar.om = this.acE.eq().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.ot = headers[0].getValue();
                            eVar.ou = headers[1].getValue();
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
                    this.acE.eq().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.acC < 1) {
                            vI();
                            this.acC++;
                            this.acE.eq().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            vI();
                            this.acE.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gn3 = com.baidu.adp.lib.util.i.gn();
                                if ((gn3 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gn3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                                    } else if (com.baidu.adp.lib.util.i.gr()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                    }
                                    e.getInstance().result(c, eVar.oq, z17, z14, gn3);
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
                            vI();
                            this.acE.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gn4 = com.baidu.adp.lib.util.i.gn();
                                if ((gn4 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gn4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                                    } else if (com.baidu.adp.lib.util.i.gr()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                    }
                                    e.getInstance().result(c, eVar.oq, z17, z13, gn4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aas) {
                    this.acE.eq().oF = -11;
                    eVar.ol = this.mContext.getResources().getString(r.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    vI();
                    this.acE.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean gn5 = com.baidu.adp.lib.util.i.gn();
                        if ((gn5 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (gn5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                            } else if (com.baidu.adp.lib.util.i.gr()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                            }
                            e.getInstance().result(c, eVar.oq, z17, z9, gn5);
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
                        this.kK = true;
                    } else {
                        this.kK = false;
                    }
                }
                while (!this.acD && i3 < aas && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.oo = -9;
                if (this.acD) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    vI();
                    this.acE.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean gn6 = com.baidu.adp.lib.util.i.gn();
                        if ((gn6 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (gn6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                            } else if (com.baidu.adp.lib.util.i.gr()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                            }
                            e.getInstance().result(c, eVar.oq, z17, z10, gn6);
                        }
                    }
                } else {
                    if (i3 < aas) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.acE.eq().oF = -11;
                        eVar.ol = this.mContext.getResources().getString(r.j.data_too_big);
                    }
                    eVar.oe = i3;
                    eVar.oh = i2 + 1;
                    eVar.og = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.acI = false;
                        } else {
                            this.acI = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.acE.eq().responseCode == 200 || this.acE.eq().responseCode == 302)) ? z17 : true;
                    try {
                        if (com.baidu.adp.b.a.jr() != null && eVar != null) {
                            com.baidu.adp.b.a.jr().a(TbConfig.TMP_PIC_DIR_NAME, eVar.od, eVar.oe);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dP(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.acE.eq().oF = -18;
                        eVar.ol = "errorCode:" + String.valueOf(this.acE.eq().oF) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vI();
                        this.acE.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gn7 = com.baidu.adp.lib.util.i.gn();
                            if ((gn7 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (gn7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                                } else if (com.baidu.adp.lib.util.i.gr()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                }
                                e.getInstance().result(c, eVar.oq, z17, z7, gn7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.acE.eq().oF = -19;
                        eVar.ol = "errorCode:" + String.valueOf(this.acE.eq().oF) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        vI();
                        this.acE.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gn8 = com.baidu.adp.lib.util.i.gn();
                            if ((gn8 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (gn8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                                } else if (com.baidu.adp.lib.util.i.gr()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                }
                                e.getInstance().result(c, eVar.oq, z17, z6, gn8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.acE.eq().oF = -12;
                            eVar.ol = "errorCode:" + String.valueOf(this.acE.eq().oF) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            vI();
                            this.acE.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gn9 = com.baidu.adp.lib.util.i.gn();
                                if ((gn9 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gn9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                                    } else if (com.baidu.adp.lib.util.i.gr()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                    }
                                    e.getInstance().result(c, eVar.oq, z17, z5, gn9);
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
                            vI();
                            this.acE.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                gn = com.baidu.adp.lib.util.i.gn();
                                if ((gn ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!gn) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                                    } else if (com.baidu.adp.lib.util.i.gr()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                    }
                                    e.getInstance().result(c, eVar.oq, z17, z4, gn);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.acE.eq().oF = -13;
                        eVar.ol = "errorCode:" + String.valueOf(this.acE.eq().oF) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        vI();
                        this.acE.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gn10 = com.baidu.adp.lib.util.i.gn();
                            if ((gn10 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (gn10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                                } else if (com.baidu.adp.lib.util.i.gr()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                }
                                e.getInstance().result(c, eVar.oq, z17, z3, gn10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.acE.eq().oF = -19;
                        eVar.ol = "errorCode:" + String.valueOf(this.acE.eq().oF) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        vI();
                        this.acE.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gn11 = com.baidu.adp.lib.util.i.gn();
                            if ((gn11 ? eVar.oq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (gn11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                                } else if (com.baidu.adp.lib.util.i.gr()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                }
                                e.getInstance().result(c, eVar.oq, z17, z2, gn11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        vI();
                        this.acE.b(eVar);
                        if (str != null) {
                        }
                        gn = com.baidu.adp.lib.util.i.gn();
                        if (gn ? eVar.oq != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!gn) {
                            }
                            e.getInstance().result(c, eVar.oq, z17, z4, gn);
                        }
                        throw th;
                    }
                }
            }
        }
        vI();
        this.acE.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean gn12 = com.baidu.adp.lib.util.i.gn();
            if ((gn12 ? eVar.oq != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.gm(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (gn12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Nc);
                } else if (com.baidu.adp.lib.util.i.gr()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                }
                e.getInstance().result(c, eVar.oq, z11, z12, gn12);
            }
        }
        this.acC = 0;
        this.acE.eq().oH = bArr;
    }

    private void dP(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(acL) && (System.currentTimeMillis() - acN) - (1800000 * (acM / 3)) >= 0) {
            acM++;
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
                acL = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean cY() {
        return this.kK;
    }

    public boolean vJ() {
        return this.acI;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        eg();
    }
}
