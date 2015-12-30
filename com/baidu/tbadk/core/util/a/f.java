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
import com.baidu.tieba.n;
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
    private static int abr;
    public static String adF;
    private static HttpClient adG;
    private HttpGet adB;
    private final com.baidu.adp.lib.network.http.e adE;
    public boolean adJ;
    private final Context mContext;
    private static volatile String adz = null;
    private static volatile boolean adA = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams adH = new BasicHttpParams();
    private boolean rJ = false;
    private boolean adI = false;
    private int adK = 0;
    private int adC = 0;
    private volatile boolean adD = false;

    static {
        abr = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(adH, 5000);
        HttpConnectionParams.setSoTimeout(adH, 30000);
        HttpConnectionParams.setSocketBufferSize(adH, 1024);
        HttpConnectionParams.setTcpNoDelay(adH, true);
        HttpClientParams.setRedirecting(adH, true);
        ConnManagerParams.setMaxConnectionsPerRoute(adH, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(adH, 10000L);
        ConnManagerParams.setMaxTotalConnections(adH, 15);
        HttpProtocolParams.setUserAgent(adH, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        adG = new DefaultHttpClient(new ThreadSafeClientConnManager(adH, schemeRegistry), adH);
        adG.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            abr = 4194304;
        }
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        vu();
        this.adE = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void vu() {
        synchronized (f.class) {
            if (!adA) {
                adA = true;
                vv();
            }
        }
    }

    public static synchronized void vv() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    adz = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void gL() {
        this.adD = true;
        this.adE.gT().vl = true;
        vw();
    }

    private void vw() {
        try {
            if (this.adB != null) {
                this.adB.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().adx) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.iQ()) {
            this.adJ = false;
            try {
                if (com.baidu.adp.lib.util.i.iS()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (adF == null) {
                            adF = com.baidu.adp.lib.util.i.ja();
                        }
                        if (adF != null && adF.length() > 0) {
                            this.adJ = true;
                            if (dH(adF) && com.baidu.adp.lib.util.i.jc()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(adF);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.adB = e.getInstance().httpGetFactory(sb.toString(), this.adK, false);
                                    } else {
                                        this.adB = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.adB = new HttpGet(sb.toString());
                                }
                                this.adB.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.adB.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = adH.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    adH.setParameter("http.route.default-proxy", new HttpHost(adF, com.baidu.adp.lib.util.i.jb()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(adF) || httpHost.getPort() != com.baidu.adp.lib.util.i.jb()) {
                                        adH.setParameter("http.route.default-proxy", new HttpHost(adF, com.baidu.adp.lib.util.i.jb()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.adB = e.getInstance().httpGetFactory(str, this.adK, false);
                                    } else {
                                        this.adB = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.adB = new HttpGet(str);
                                }
                                if (adz != null) {
                                    this.adB.setHeader("Proxy-Authorization", adz);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.adB.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.iS()) {
                            if (!this.adJ || this.adB == null) {
                                this.adB = e.getInstance().httpGetFactory(str, this.adK, false);
                                return;
                            }
                            return;
                        }
                        this.adB = e.getInstance().httpGetFactory(str, this.adK, true);
                        return;
                    }
                    this.adB = e.getInstance().httpGetFactory(str, str2, str3);
                    return;
                }
                this.adB = new HttpGet(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dG(String str) {
        l(str, null, null);
    }

    private boolean dH(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [617=12, 618=12, 622=12, 623=12, 624=12, 625=12, 626=12, 627=12, 628=24, 630=12, 631=12, 632=12, 633=12, 636=12, 637=24, 638=12, 639=12, 640=24, 641=12, 642=12, 643=12, 644=12, 646=24, 647=12] */
    /* JADX WARN: Code restructure failed: missing block: B:463:0x094d, code lost:
        if (r12 == null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x094f, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:591:0x0b3f  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0b5d  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x0b80  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x0b1f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String c;
        InputStream inputStream;
        Throwable th;
        boolean z;
        boolean z2;
        boolean iR;
        boolean z3;
        boolean z4;
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
            if (!e.getInstance().adx) {
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
            if (this.adD || i2 >= i) {
                break;
            }
            this.adK = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.adE.a(dVar);
            dVar.vb = -1;
            InputStream inputStream2 = null;
            c = this.adE.gS().c(dVar);
            try {
                dVar.vb = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    dG(c);
                    if (z15) {
                        dVar.vc = e.getInstance().getCachedCdnIp(this.adK);
                    }
                } else {
                    l(c, str, str2);
                    dVar.vc = str;
                }
                dVar.vb = -3;
            } catch (SocketException e) {
                e = e;
            } catch (SocketTimeoutException e2) {
                e = e2;
                inputStream = null;
            } catch (HttpException e3) {
                e = e3;
                inputStream = null;
            } catch (IOException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.adB == null) {
                throw new SocketException("network not available.");
            }
            if (this.adD) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                vw();
                this.adE.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean iR2 = com.baidu.adp.lib.util.i.iR();
                    if ((iR2 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (iR2) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                        } else if (com.baidu.adp.lib.util.i.iV()) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                        } else {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Th);
                        }
                        e.getInstance().result(c, dVar.vc, z16, z7, iR2);
                    }
                }
            } else {
                dVar.vb = -8;
                HttpResponse execute = adG.execute(this.adB);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.adE.gT().responseCode = execute.getStatusLine().getStatusCode();
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
                } catch (HttpException e6) {
                    e = e6;
                } catch (SocketException e7) {
                    e = e7;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e8) {
                    e = e8;
                } catch (IOException e9) {
                    e = e9;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.adE.gT().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.adC < 1) {
                            vw();
                            this.adC++;
                            this.adE.gT().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e10) {
                                }
                            }
                            vw();
                            this.adE.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iR3 = com.baidu.adp.lib.util.i.iR();
                                if ((iR3 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iR3) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                                    } else if (com.baidu.adp.lib.util.i.iV()) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                                    } else {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Th);
                                    }
                                    e.getInstance().result(c, dVar.vc, z16, z13, iR3);
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
                            vw();
                            this.adE.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iR4 = com.baidu.adp.lib.util.i.iR();
                                if ((iR4 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iR4) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                                    } else if (com.baidu.adp.lib.util.i.iV()) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                                    } else {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Th);
                                    }
                                    e.getInstance().result(c, dVar.vc, z16, z12, iR4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > abr) {
                    this.adE.gT().responseCode = -11;
                    dVar.uZ = this.mContext.getResources().getString(n.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                        }
                    }
                    vw();
                    this.adE.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean iR5 = com.baidu.adp.lib.util.i.iR();
                        if ((iR5 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (iR5) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                            } else if (com.baidu.adp.lib.util.i.iV()) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                            } else {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Th);
                            }
                            e.getInstance().result(c, dVar.vc, z16, z8, iR5);
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
                        this.rJ = true;
                    } else {
                        this.rJ = false;
                    }
                }
                while (!this.adD && i3 < abr && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.vb = -9;
                if (this.adD) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e13) {
                        }
                    }
                    vw();
                    this.adE.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean iR6 = com.baidu.adp.lib.util.i.iR();
                        if ((iR6 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (iR6) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                            } else if (com.baidu.adp.lib.util.i.iV()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Th);
                            }
                            e.getInstance().result(c, dVar.vc, z16, z9, iR6);
                        }
                    }
                } else {
                    if (i3 < abr) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.adE.gT().responseCode = -11;
                        dVar.uZ = this.mContext.getResources().getString(n.j.data_too_big);
                    }
                    dVar.uT = i3;
                    dVar.uW = i2 + 1;
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.adI = false;
                        } else {
                            this.adI = true;
                        }
                    }
                    z10 = (i3 <= 0 || !(this.adE.gT().responseCode == 200 || this.adE.gT().responseCode == 302)) ? z16 : true;
                    try {
                        if (com.baidu.adp.b.a.ma() != null && dVar != null) {
                            com.baidu.adp.b.a.ma().b(TbConfig.TMP_PIC_DIR_NAME, dVar.uS, dVar.uT);
                            break;
                        }
                        break;
                    } catch (SocketTimeoutException e14) {
                        e = e14;
                        z16 = z10;
                        this.adE.gT().responseCode = -13;
                        dVar.uZ = String.valueOf(String.valueOf(this.adE.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                            }
                        }
                        vw();
                        this.adE.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iR7 = com.baidu.adp.lib.util.i.iR();
                            if ((iR7 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (iR7) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                                } else if (com.baidu.adp.lib.util.i.iV()) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                                } else {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Th);
                                }
                                e.getInstance().result(c, dVar.vc, z16, z6, iR7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e16) {
                        e = e16;
                        z16 = z10;
                        this.adE.gT().responseCode = -18;
                        dVar.uZ = String.valueOf(String.valueOf(this.adE.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vw();
                        this.adE.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iR8 = com.baidu.adp.lib.util.i.iR();
                            if ((iR8 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (iR8) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                                } else if (com.baidu.adp.lib.util.i.iV()) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                                } else {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Th);
                                }
                                e.getInstance().result(c, dVar.vc, z16, z5, iR8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e18) {
                        e = e18;
                        inputStream2 = inputStream;
                        z16 = z10;
                        try {
                            this.adE.gT().responseCode = -12;
                            dVar.uZ = String.valueOf(String.valueOf(this.adE.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e19) {
                                }
                            }
                            vw();
                            this.adE.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iR9 = com.baidu.adp.lib.util.i.iR();
                                if ((iR9 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iR9) {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                                    } else if (com.baidu.adp.lib.util.i.iV()) {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                                    } else {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Th);
                                    }
                                    e.getInstance().result(c, dVar.vc, z16, z4, iR9);
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
                                } catch (Exception e20) {
                                }
                            }
                            vw();
                            this.adE.b(dVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                iR = com.baidu.adp.lib.util.i.iR();
                                if ((iR ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!iR) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                                    } else if (com.baidu.adp.lib.util.i.iV()) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                                    } else {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Th);
                                    }
                                    e.getInstance().result(c, dVar.vc, z16, z3, iR);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e21) {
                        e = e21;
                        z16 = z10;
                        this.adE.gT().responseCode = -19;
                        dVar.uZ = String.valueOf(String.valueOf(this.adE.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        vw();
                        this.adE.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iR10 = com.baidu.adp.lib.util.i.iR();
                            if ((iR10 ? dVar.vc != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (iR10) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                                } else if (com.baidu.adp.lib.util.i.iV()) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                                } else {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Th);
                                }
                                e.getInstance().result(c, dVar.vc, z16, z2, iR10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z16 = z10;
                        if (inputStream != null) {
                        }
                        vw();
                        this.adE.b(dVar);
                        if (str != null) {
                        }
                        iR = com.baidu.adp.lib.util.i.iR();
                        if (iR ? dVar.vc != null || z16 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!iR) {
                            }
                            e.getInstance().result(c, dVar.vc, z16, z3, iR);
                        }
                        throw th;
                    }
                }
            }
        }
        this.adC = 0;
        this.adE.gT().vn = bArr;
        vw();
        this.adE.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean iR11 = com.baidu.adp.lib.util.i.iR();
            if ((iR11 ? dVar.vc != null || z10 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.gd(c) && z15) {
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                if (iR11) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Tg);
                } else if (com.baidu.adp.lib.util.i.iV()) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Ti);
                } else {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Th);
                }
                e.getInstance().result(c, dVar.vc, z10, z11, iR11);
            }
        }
        this.adC = 0;
        this.adE.gT().vn = bArr;
    }

    public void vx() {
        e(null, null, -1);
    }

    public boolean fF() {
        return this.rJ;
    }

    public boolean vy() {
        return this.adI;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0005a
    public void cancel() {
        gL();
    }
}
