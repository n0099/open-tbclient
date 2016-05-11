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
    private static int WA;
    public static String YO;
    private static HttpClient YP;
    private static String YU;
    private static int YV;
    private static long YW;
    private HttpGet YK;
    private final com.baidu.adp.lib.network.http.f YN;
    public boolean YS;
    private final Context mContext;
    private static volatile String YI = null;
    private static volatile boolean YJ = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams YQ = new BasicHttpParams();
    private boolean hO = false;
    private boolean YR = false;
    private int YT = 0;
    private int YL = 0;
    private volatile boolean YM = false;

    static {
        WA = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(YQ, 5000);
        HttpConnectionParams.setSoTimeout(YQ, 30000);
        HttpConnectionParams.setSocketBufferSize(YQ, 1024);
        HttpConnectionParams.setTcpNoDelay(YQ, true);
        HttpClientParams.setRedirecting(YQ, true);
        ConnManagerParams.setMaxConnectionsPerRoute(YQ, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(YQ, 10000L);
        ConnManagerParams.setMaxTotalConnections(YQ, 15);
        HttpProtocolParams.setUserAgent(YQ, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        YP = new DefaultHttpClient(new ThreadSafeClientConnManager(YQ, schemeRegistry), YQ);
        YP.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            WA = 4194304;
        }
        YU = null;
        YV = 0;
        YW = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        uz();
        this.YN = fVar;
        this.mContext = TbadkCoreApplication.m11getInst().getApp();
    }

    public static void uz() {
        synchronized (f.class) {
            if (!YJ) {
                YJ = true;
                uA();
            }
        }
    }

    public static synchronized void uA() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m11getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    YI = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void dl() {
        this.YM = true;
        this.YN.dv().lD = true;
        uB();
    }

    private void uB() {
        try {
            if (this.YK != null) {
                this.YK.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void o(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().YG) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.fq()) {
            this.YS = false;
            try {
                if (com.baidu.adp.lib.util.i.fs()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (YO == null) {
                            YO = com.baidu.adp.lib.util.i.fA();
                        }
                        if (YO != null && YO.length() > 0) {
                            this.YS = true;
                            if (dH(YO) && com.baidu.adp.lib.util.i.fC()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(YO);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.YK = e.getInstance().httpGetFactory(sb.toString(), this.YT, false);
                                    } else {
                                        this.YK = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.YK = new HttpGet(sb.toString());
                                }
                                this.YK.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.YK.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = YQ.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    YQ.setParameter("http.route.default-proxy", new HttpHost(YO, com.baidu.adp.lib.util.i.fB()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(YO) || httpHost.getPort() != com.baidu.adp.lib.util.i.fB()) {
                                        YQ.setParameter("http.route.default-proxy", new HttpHost(YO, com.baidu.adp.lib.util.i.fB()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.YK = e.getInstance().httpGetFactory(str, this.YT, false);
                                    } else {
                                        this.YK = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.YK = new HttpGet(str);
                                }
                                if (YI != null) {
                                    this.YK.setHeader("Proxy-Authorization", YI);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.YK.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.fs()) {
                            if (!this.YS || this.YK == null) {
                                this.YK = e.getInstance().httpGetFactory(str, this.YT, false);
                            }
                        } else {
                            this.YK = e.getInstance().httpGetFactory(str, this.YT, true);
                        }
                    } else {
                        this.YK = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.YK = new HttpGet(str);
                }
                this.YK.setHeader("needginfo", "1");
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [623=13, 624=13, 628=13, 634=13, 635=13, 636=13, 637=13, 638=13, 639=26, 641=13, 642=13, 643=13, 644=13, 647=13, 648=26, 649=13, 650=13, 651=26, 652=13, 653=13, 654=13, 655=13, 657=26, 658=13] */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x0979, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0c47  */
    /* JADX WARN: Removed duplicated region for block: B:657:0x0c65  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0c88  */
    /* JADX WARN: Removed duplicated region for block: B:732:0x0c27 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.e eVar;
        String c;
        Throwable th;
        InputStream inputStream;
        boolean z;
        boolean z2;
        boolean z3;
        boolean fr;
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
        byte[] bArr = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().YG) {
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
            if (this.YM || i2 >= i) {
                break;
            }
            this.YT = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.YN.a(eVar);
            eVar.lp = -1;
            InputStream inputStream2 = null;
            c = this.YN.du().c(eVar);
            try {
                eVar.lp = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    o(c, null, null);
                    if (z16) {
                        eVar.lq = e.getInstance().getCachedCdnIp(this.YT);
                    }
                } else {
                    o(c, str, str2);
                    eVar.lq = str;
                }
                eVar.lp = -3;
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
            if (this.YK == null) {
                throw new SocketException("network not available.");
            }
            if (this.YM) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                uB();
                this.YN.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean fr2 = com.baidu.adp.lib.util.i.fr();
                    if ((fr2 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (fr2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                        } else if (com.baidu.adp.lib.util.i.fv()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KS);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KR);
                        }
                        e.getInstance().result(c, eVar.lq, z17, z8, fr2);
                    }
                }
            } else {
                eVar.lp = -8;
                HttpResponse execute = YP.execute(this.YK);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.YN.dv().responseCode = execute.getStatusLine().getStatusCode();
                eVar.lo = this.YN.dv().responseCode;
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
                } catch (IllegalStateException e7) {
                    e = e7;
                } catch (SocketException e8) {
                    e = e8;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e9) {
                    e = e9;
                } catch (HttpException e10) {
                    e = e10;
                } catch (IOException e11) {
                    e = e11;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.YN.dv().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.YL < 1) {
                            uB();
                            this.YL++;
                            this.YN.dv().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            uB();
                            this.YN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fr3 = com.baidu.adp.lib.util.i.fr();
                                if ((fr3 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fr3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    } else if (com.baidu.adp.lib.util.i.fv()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    }
                                    e.getInstance().result(c, eVar.lq, z17, z14, fr3);
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
                            uB();
                            this.YN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fr4 = com.baidu.adp.lib.util.i.fr();
                                if ((fr4 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fr4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    } else if (com.baidu.adp.lib.util.i.fv()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    }
                                    e.getInstance().result(c, eVar.lq, z17, z13, fr4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > WA) {
                    this.YN.dv().lE = -11;
                    eVar.ln = this.mContext.getResources().getString(t.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    uB();
                    this.YN.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean fr5 = com.baidu.adp.lib.util.i.fr();
                        if ((fr5 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (fr5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                            } else if (com.baidu.adp.lib.util.i.fv()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KS);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KR);
                            }
                            e.getInstance().result(c, eVar.lq, z17, z9, fr5);
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
                        this.hO = true;
                    } else {
                        this.hO = false;
                    }
                }
                while (!this.YM && i3 < WA && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.lp = -9;
                if (this.YM) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    uB();
                    this.YN.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean fr6 = com.baidu.adp.lib.util.i.fr();
                        if ((fr6 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (fr6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                            } else if (com.baidu.adp.lib.util.i.fv()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KS);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KR);
                            }
                            e.getInstance().result(c, eVar.lq, z17, z10, fr6);
                        }
                    }
                } else {
                    if (i3 < WA) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.YN.dv().lE = -11;
                        eVar.ln = this.mContext.getResources().getString(t.j.data_too_big);
                    }
                    eVar.lh = i3;
                    eVar.lk = i2 + 1;
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.YR = false;
                        } else {
                            this.YR = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.YN.dv().responseCode == 200 || this.YN.dv().responseCode == 302)) ? z17 : true;
                    try {
                        if (com.baidu.adp.b.a.iu() != null && eVar != null) {
                            com.baidu.adp.b.a.iu().a(TbConfig.TMP_PIC_DIR_NAME, eVar.lg, eVar.lh);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dI(value);
                            break;
                        }
                        break;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        z17 = z11;
                        this.YN.dv().lE = -13;
                        eVar.ln = "errorCode:" + String.valueOf(this.YN.dv().lE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        uB();
                        this.YN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr7 = com.baidu.adp.lib.util.i.fr();
                            if ((fr7 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lq, z17, z7, fr7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e18) {
                        e = e18;
                        z17 = z11;
                        this.YN.dv().lE = -18;
                        eVar.ln = "errorCode:" + String.valueOf(this.YN.dv().lE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        uB();
                        this.YN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr8 = com.baidu.adp.lib.util.i.fr();
                            if ((fr8 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lq, z17, z6, fr8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.YN.dv().lE = -12;
                            eVar.ln = "errorCode:" + String.valueOf(this.YN.dv().lE) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            uB();
                            this.YN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fr9 = com.baidu.adp.lib.util.i.fr();
                                if ((fr9 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fr9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    } else if (com.baidu.adp.lib.util.i.fv()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    }
                                    e.getInstance().result(c, eVar.lq, z17, z5, fr9);
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
                            uB();
                            this.YN.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                fr = com.baidu.adp.lib.util.i.fr();
                                if ((fr ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!fr) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    } else if (com.baidu.adp.lib.util.i.fv()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    }
                                    e.getInstance().result(c, eVar.lq, z17, z4, fr);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e23) {
                        e = e23;
                        z17 = z11;
                        this.YN.dv().lE = -19;
                        eVar.ln = "errorCode:" + String.valueOf(this.YN.dv().lE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        uB();
                        this.YN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr10 = com.baidu.adp.lib.util.i.fr();
                            if ((fr10 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lq, z17, z3, fr10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e25) {
                        e = e25;
                        z17 = z11;
                        this.YN.dv().lE = -19;
                        eVar.ln = "errorCode:" + String.valueOf(this.YN.dv().lE) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        uB();
                        this.YN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr11 = com.baidu.adp.lib.util.i.fr();
                            if ((fr11 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lq, z17, z2, fr11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        this.YN.dv().lE = -10;
                        eVar.ln = "errorCode:" + String.valueOf(this.YN.dv().lE) + "|" + th.getClass() + "|" + th.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e27) {
                            }
                        }
                        uB();
                        this.YN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr12 = com.baidu.adp.lib.util.i.fr();
                            if ((fr12 ? eVar.lq != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr12) {
                                    z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lq, z17, z, fr12);
                            }
                        }
                        this.YL = 0;
                        this.YN.dv().lG = bArr;
                    }
                }
            }
        }
        this.YL = 0;
        this.YN.dv().lG = bArr;
        uB();
        this.YN.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean fr13 = com.baidu.adp.lib.util.i.fr();
            if ((fr13 ? eVar.lq != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gg(c) && z16) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (fr13) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                } else if (com.baidu.adp.lib.util.i.fv()) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().KS);
                } else {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().KR);
                }
                e.getInstance().result(c, eVar.lq, z11, z12, fr13);
            }
        }
        this.YL = 0;
        this.YN.dv().lG = bArr;
    }

    private void dI(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(YU) && (System.currentTimeMillis() - YW) - (1800000 * (YV / 3)) >= 0) {
            YV++;
            try {
                char[] charArray = TbadkCoreApplication.m11getInst().getCuid().toCharArray();
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
                YU = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean cd() {
        return this.hO;
    }

    public boolean uC() {
        return this.YR;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        dl();
    }
}
