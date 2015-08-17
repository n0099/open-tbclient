package com.baidu.tbadk.core.util.httpNet;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
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
public class f implements a.InterfaceC0004a {
    private static int ZT;
    public static String abT;
    private static HttpClient abU;
    private HttpGet abP;
    private final com.baidu.adp.lib.network.http.e abS;
    public boolean abX;
    private final Context mContext;
    private static volatile String abN = null;
    private static volatile boolean abO = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams abV = new BasicHttpParams();
    private boolean rI = false;
    private boolean abW = false;
    private int abY = 0;
    private int abQ = 0;
    private volatile boolean abR = false;

    static {
        ZT = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(abV, 5000);
        HttpConnectionParams.setSoTimeout(abV, 30000);
        HttpConnectionParams.setSocketBufferSize(abV, 1024);
        HttpConnectionParams.setTcpNoDelay(abV, true);
        HttpClientParams.setRedirecting(abV, true);
        ConnManagerParams.setMaxConnectionsPerRoute(abV, new ConnPerRouteBean(10));
        ConnManagerParams.setTimeout(abV, 10000L);
        ConnManagerParams.setMaxTotalConnections(abV, 10);
        HttpProtocolParams.setUserAgent(abV, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        abU = new DefaultHttpClient(new ThreadSafeClientConnManager(abV, schemeRegistry), abV);
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            ZT = 4194304;
        }
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        va();
        this.abS = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void va() {
        synchronized (f.class) {
            if (!abO) {
                abO = true;
                vb();
            }
        }
    }

    public static synchronized void vb() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    abN = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void gM() {
        this.abR = true;
        this.abS.gT().ve = true;
        vc();
    }

    private void vc() {
        try {
            if (this.abP != null) {
                this.abP.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void k(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().abL) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.iO()) {
            this.abX = false;
            try {
                if (com.baidu.adp.lib.util.i.iQ()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (abT == null) {
                            abT = com.baidu.adp.lib.util.i.iY();
                        }
                        if (abT != null && abT.length() > 0) {
                            this.abX = true;
                            if (di(abT) && com.baidu.adp.lib.util.i.ja()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(abT);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.abP = e.getInstance().httpGetFactory(sb.toString(), this.abY, false);
                                    } else {
                                        this.abP = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.abP = new HttpGet(sb.toString());
                                }
                                this.abP.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.abP.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = abV.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    abV.setParameter("http.route.default-proxy", new HttpHost(abT, com.baidu.adp.lib.util.i.iZ()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(abT) || httpHost.getPort() != com.baidu.adp.lib.util.i.iZ()) {
                                        abV.setParameter("http.route.default-proxy", new HttpHost(abT, com.baidu.adp.lib.util.i.iZ()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.abP = e.getInstance().httpGetFactory(str, this.abY, false);
                                    } else {
                                        this.abP = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.abP = new HttpGet(str);
                                }
                                if (abN != null) {
                                    this.abP.setHeader("Proxy-Authorization", abN);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.abP.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.iQ()) {
                            if (!this.abX || this.abP == null) {
                                this.abP = e.getInstance().httpGetFactory(str, this.abY, false);
                                return;
                            }
                            return;
                        }
                        this.abP = e.getInstance().httpGetFactory(str, this.abY, true);
                        return;
                    }
                    this.abP = e.getInstance().httpGetFactory(str, str2, str3);
                    return;
                }
                this.abP = new HttpGet(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dh(String str) {
        k(str, null, null);
    }

    private boolean di(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [604=12, 605=12, 609=12, 611=12, 612=12, 613=12, 614=12, 615=24, 617=12, 618=12, 619=12, 620=12, 623=12, 624=24, 625=12, 626=12, 627=24, 628=12, 629=12, 630=12, 631=12, 633=24, 634=12] */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x08d2, code lost:
        if (r12 == null) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:459:0x08d4, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:586:0x0ab2  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0ad0  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0af3  */
    /* JADX WARN: Removed duplicated region for block: B:689:0x0a9b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String b;
        InputStream inputStream;
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean iP;
        boolean z5;
        boolean z6;
        long currentTimeMillis2;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String value;
        int read;
        String obj;
        boolean z12;
        boolean z13;
        byte[] bArr = null;
        boolean z14 = false;
        if (e.getInstance() != null) {
            z14 = true;
            if (!e.getInstance().abL) {
                e.getInstance().init();
            }
        }
        boolean z15 = z14;
        if (i <= 0) {
            i = 5;
        }
        boolean z16 = false;
        int i2 = 0;
        while (true) {
            if (this.abR || i2 >= i) {
                break;
            }
            this.abY = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.abS.a(dVar);
            dVar.uV = -1;
            InputStream inputStream2 = null;
            b = this.abS.gS().b(dVar);
            try {
                dVar.uV = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    dh(b);
                    if (z15) {
                        dVar.uW = e.getInstance().getCachedCdnIp(this.abY);
                    }
                } else {
                    k(b, str, str2);
                    dVar.uW = str;
                }
                dVar.uV = -3;
            } catch (SocketException e) {
                e = e;
            } catch (SocketTimeoutException e2) {
                e = e2;
                inputStream = null;
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (HttpException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.abP == null) {
                throw new SocketException("network not available.");
            }
            if (this.abR) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                vc();
                if ((str == null || str.length() == 0) && b != null) {
                    boolean iP2 = com.baidu.adp.lib.util.i.iP();
                    if ((iP2 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (iP2) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SG);
                        } else if (com.baidu.adp.lib.util.i.iT()) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SI);
                        } else {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SH);
                        }
                        e.getInstance().result(b, dVar.uW, z16, z7, iP2);
                    }
                }
            } else {
                dVar.uV = -8;
                HttpResponse execute = abU.execute(this.abP);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.abS.gT().responseCode = execute.getStatusLine().getStatusCode();
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                } catch (IOException e8) {
                    e = e8;
                } catch (HttpException e9) {
                    e = e9;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.abS.gT().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.abQ < 1) {
                            vc();
                            this.abQ++;
                            this.abS.gT().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e10) {
                                }
                            }
                            vc();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean iP3 = com.baidu.adp.lib.util.i.iP();
                                if ((iP3 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iP3) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                    } else if (com.baidu.adp.lib.util.i.iT()) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                    } else {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                    }
                                    e.getInstance().result(b, dVar.uW, z16, z13, iP3);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e11) {
                                }
                            }
                            vc();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean iP4 = com.baidu.adp.lib.util.i.iP();
                                if ((iP4 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iP4) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                    } else if (com.baidu.adp.lib.util.i.iT()) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                    } else {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                    }
                                    e.getInstance().result(b, dVar.uW, z16, z12, iP4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > ZT) {
                    this.abS.gT().responseCode = -11;
                    dVar.uT = this.mContext.getResources().getString(i.C0057i.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                        }
                    }
                    vc();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean iP5 = com.baidu.adp.lib.util.i.iP();
                        if ((iP5 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (iP5) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SG);
                            } else if (com.baidu.adp.lib.util.i.iT()) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SI);
                            } else {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SH);
                            }
                            e.getInstance().result(b, dVar.uW, z16, z8, iP5);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i3 = 0;
                boolean z17 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z17 = true;
                }
                if (z17) {
                    byte[] bArr3 = new byte[23];
                    int read2 = inputStream.read(bArr3, 0, 23);
                    if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                        byteArrayOutputStream.write(bArr3, 0, read2);
                        i3 = 0 + read2;
                    }
                }
                if (execute.getFirstHeader("Src-Content-Type") != null) {
                    if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                        this.rI = true;
                    } else {
                        this.rI = false;
                    }
                }
                while (!this.abR && i3 < ZT && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.uV = -9;
                if (this.abR) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e13) {
                        }
                    }
                    vc();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean iP6 = com.baidu.adp.lib.util.i.iP();
                        if ((iP6 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (iP6) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SG);
                            } else if (com.baidu.adp.lib.util.i.iT()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SI);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SH);
                            }
                            e.getInstance().result(b, dVar.uW, z16, z9, iP6);
                        }
                    }
                } else {
                    if (i3 < ZT) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.abS.gT().responseCode = -11;
                        dVar.uT = this.mContext.getResources().getString(i.C0057i.data_too_big);
                    }
                    dVar.uN = i3;
                    dVar.uQ = i2 + 1;
                    dVar.uP = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.abW = false;
                        } else {
                            this.abW = true;
                        }
                    }
                    z10 = i3 > 0 ? true : z16;
                    try {
                        if (com.baidu.adp.b.a.mA() != null && dVar != null) {
                            com.baidu.adp.b.a.mA().b(TbConfig.TMP_PIC_DIR_NAME, dVar.uM, dVar.uN);
                            break;
                        }
                        break;
                    } catch (SocketException e14) {
                        e = e14;
                        inputStream2 = inputStream;
                        z16 = z10;
                        try {
                            this.abS.gT().responseCode = -12;
                            dVar.uT = String.valueOf(String.valueOf(this.abS.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e15) {
                                }
                            }
                            vc();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean iP7 = com.baidu.adp.lib.util.i.iP();
                                if ((iP7 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                                    long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iP7) {
                                        z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                    } else if (com.baidu.adp.lib.util.i.iT()) {
                                        z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                    } else {
                                        z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                    }
                                    e.getInstance().result(b, dVar.uW, z16, z6, iP7);
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
                                } catch (Exception e16) {
                                }
                            }
                            vc();
                            if ((str != null || str.length() == 0) && b != null) {
                                iP = com.baidu.adp.lib.util.i.iP();
                                if ((iP ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                                    long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!iP) {
                                        z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                    } else if (com.baidu.adp.lib.util.i.iT()) {
                                        z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                    } else {
                                        z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                    }
                                    e.getInstance().result(b, dVar.uW, z16, z5, iP);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e17) {
                        e = e17;
                        z16 = z10;
                        this.abS.gT().responseCode = -13;
                        dVar.uT = String.valueOf(String.valueOf(this.abS.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e18) {
                            }
                        }
                        vc();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean iP8 = com.baidu.adp.lib.util.i.iP();
                            if ((iP8 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                if (iP8) {
                                    z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                } else if (com.baidu.adp.lib.util.i.iT()) {
                                    z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                } else {
                                    z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                }
                                e.getInstance().result(b, dVar.uW, z16, z4, iP8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e19) {
                        e = e19;
                        z16 = z10;
                        this.abS.gT().responseCode = -19;
                        dVar.uT = String.valueOf(String.valueOf(this.abS.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e20) {
                            }
                        }
                        vc();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean iP9 = com.baidu.adp.lib.util.i.iP();
                            if ((iP9 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                                long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                if (iP9) {
                                    z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                } else if (com.baidu.adp.lib.util.i.iT()) {
                                    z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                } else {
                                    z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                }
                                e.getInstance().result(b, dVar.uW, z16, z3, iP9);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e21) {
                        e = e21;
                        z16 = z10;
                        this.abS.gT().responseCode = -18;
                        dVar.uT = String.valueOf(String.valueOf(this.abS.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        vc();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean iP10 = com.baidu.adp.lib.util.i.iP();
                            if ((iP10 ? dVar.uW != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (iP10) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                } else if (com.baidu.adp.lib.util.i.iT()) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                } else {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                }
                                e.getInstance().result(b, dVar.uW, z16, z2, iP10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z16 = z10;
                        if (inputStream != null) {
                        }
                        vc();
                        if (str != null) {
                        }
                        iP = com.baidu.adp.lib.util.i.iP();
                        if (iP ? dVar.uW != null || z16 || i2 >= i + (-1) : true) {
                            long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
                            if (!iP) {
                            }
                            e.getInstance().result(b, dVar.uW, z16, z5, iP);
                        }
                        throw th;
                    }
                }
            }
        }
        this.abQ = 0;
        this.abS.gT().vg = bArr;
        vc();
        if ((str == null || str.length() == 0) && b != null) {
            boolean iP11 = com.baidu.adp.lib.util.i.iP();
            if ((iP11 ? dVar.uW != null || z10 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fw(b) && z15) {
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                if (iP11) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SG);
                } else if (com.baidu.adp.lib.util.i.iT()) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SI);
                } else {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SH);
                }
                e.getInstance().result(b, dVar.uW, z10, z11, iP11);
            }
        }
        this.abQ = 0;
        this.abS.gT().vg = bArr;
    }

    public void vd() {
        e(null, null, -1);
    }

    public boolean fI() {
        return this.rI;
    }

    public boolean ve() {
        return this.abW;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        gM();
    }
}
