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
import com.baidu.tieba.u;
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
    private static int WQ;
    public static String Zf;
    private static HttpClient Zg;
    private static String Zl;
    private static int Zm;
    private static long Zn;
    private HttpGet Zb;
    private final com.baidu.adp.lib.network.http.f Ze;
    public boolean Zj;
    private final Context mContext;
    private static volatile String YZ = null;
    private static volatile boolean Za = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams Zh = new BasicHttpParams();
    private boolean hN = false;
    private boolean Zi = false;
    private int Zk = 0;
    private int Zc = 0;
    private volatile boolean Zd = false;

    static {
        WQ = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(Zh, 5000);
        HttpConnectionParams.setSoTimeout(Zh, 30000);
        HttpConnectionParams.setSocketBufferSize(Zh, 1024);
        HttpConnectionParams.setTcpNoDelay(Zh, true);
        HttpClientParams.setRedirecting(Zh, true);
        ConnManagerParams.setMaxConnectionsPerRoute(Zh, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(Zh, 10000L);
        ConnManagerParams.setMaxTotalConnections(Zh, 15);
        HttpProtocolParams.setUserAgent(Zh, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        Zg = new DefaultHttpClient(new ThreadSafeClientConnManager(Zh, schemeRegistry), Zh);
        Zg.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            WQ = 4194304;
        }
        Zl = null;
        Zm = 0;
        Zn = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        uz();
        this.Ze = fVar;
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
    }

    public static void uz() {
        synchronized (f.class) {
            if (!Za) {
                Za = true;
                uA();
            }
        }
    }

    public static synchronized void uA() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m9getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    YZ = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void dm() {
        this.Zd = true;
        this.Ze.dw().lD = true;
        uB();
    }

    private void uB() {
        try {
            if (this.Zb != null) {
                this.Zb.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void s(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().YX) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.fr()) {
            this.Zj = false;
            try {
                if (com.baidu.adp.lib.util.i.ft()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (Zf == null) {
                            Zf = com.baidu.adp.lib.util.i.fB();
                        }
                        if (Zf != null && Zf.length() > 0) {
                            this.Zj = true;
                            if (dK(Zf) && com.baidu.adp.lib.util.i.fD()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(Zf);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.Zb = e.getInstance().httpGetFactory(sb.toString(), this.Zk, false);
                                    } else {
                                        this.Zb = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.Zb = new HttpGet(sb.toString());
                                }
                                this.Zb.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.Zb.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = Zh.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    Zh.setParameter("http.route.default-proxy", new HttpHost(Zf, com.baidu.adp.lib.util.i.fC()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(Zf) || httpHost.getPort() != com.baidu.adp.lib.util.i.fC()) {
                                        Zh.setParameter("http.route.default-proxy", new HttpHost(Zf, com.baidu.adp.lib.util.i.fC()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.Zb = e.getInstance().httpGetFactory(str, this.Zk, false);
                                    } else {
                                        this.Zb = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.Zb = new HttpGet(str);
                                }
                                if (YZ != null) {
                                    this.Zb.setHeader("Proxy-Authorization", YZ);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.Zb.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.ft()) {
                            if (!this.Zj || this.Zb == null) {
                                this.Zb = e.getInstance().httpGetFactory(str, this.Zk, false);
                            }
                        } else {
                            this.Zb = e.getInstance().httpGetFactory(str, this.Zk, true);
                        }
                    } else {
                        this.Zb = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.Zb = new HttpGet(str);
                }
                this.Zb.setHeader("needginfo", "1");
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
        boolean fs;
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
            if (!e.getInstance().YX) {
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
            if (this.Zd || i2 >= i) {
                break;
            }
            this.Zk = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.Ze.a(eVar);
            eVar.ln = -1;
            InputStream inputStream2 = null;
            c = this.Ze.dv().c(eVar);
            try {
                eVar.ln = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    s(c, null, null);
                    if (z16) {
                        eVar.lo = e.getInstance().getCachedCdnIp(this.Zk);
                    }
                } else {
                    s(c, str, str2);
                    eVar.lo = str;
                }
                eVar.ln = -3;
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
            if (this.Zb == null) {
                throw new SocketException("network not available.");
            }
            if (this.Zd) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                uB();
                this.Ze.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean fs2 = com.baidu.adp.lib.util.i.fs();
                    if ((fs2 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (fs2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                        } else if (com.baidu.adp.lib.util.i.fw()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KS);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KR);
                        }
                        e.getInstance().result(c, eVar.lo, z17, z8, fs2);
                    }
                }
            } else {
                eVar.ln = -8;
                HttpResponse execute = Zg.execute(this.Zb);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.Ze.dw().responseCode = execute.getStatusLine().getStatusCode();
                eVar.lm = this.Ze.dw().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.lq = headers[0].getValue();
                            eVar.lr = headers[1].getValue();
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
                    this.Ze.dw().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.Zc < 1) {
                            uB();
                            this.Zc++;
                            this.Ze.dw().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            uB();
                            this.Ze.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fs3 = com.baidu.adp.lib.util.i.fs();
                                if ((fs3 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fs3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    } else if (com.baidu.adp.lib.util.i.fw()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    }
                                    e.getInstance().result(c, eVar.lo, z17, z14, fs3);
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
                            this.Ze.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fs4 = com.baidu.adp.lib.util.i.fs();
                                if ((fs4 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fs4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    } else if (com.baidu.adp.lib.util.i.fw()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    }
                                    e.getInstance().result(c, eVar.lo, z17, z13, fs4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > WQ) {
                    this.Ze.dw().lE = -11;
                    eVar.ll = this.mContext.getResources().getString(u.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    uB();
                    this.Ze.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean fs5 = com.baidu.adp.lib.util.i.fs();
                        if ((fs5 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (fs5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                            } else if (com.baidu.adp.lib.util.i.fw()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KS);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KR);
                            }
                            e.getInstance().result(c, eVar.lo, z17, z9, fs5);
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
                        this.hN = true;
                    } else {
                        this.hN = false;
                    }
                }
                while (!this.Zd && i3 < WQ && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.ln = -9;
                if (this.Zd) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    uB();
                    this.Ze.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean fs6 = com.baidu.adp.lib.util.i.fs();
                        if ((fs6 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (fs6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                            } else if (com.baidu.adp.lib.util.i.fw()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KS);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KR);
                            }
                            e.getInstance().result(c, eVar.lo, z17, z10, fs6);
                        }
                    }
                } else {
                    if (i3 < WQ) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.Ze.dw().lE = -11;
                        eVar.ll = this.mContext.getResources().getString(u.j.data_too_big);
                    }
                    eVar.lf = i3;
                    eVar.li = i2 + 1;
                    eVar.lh = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.Zi = false;
                        } else {
                            this.Zi = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.Ze.dw().responseCode == 200 || this.Ze.dw().responseCode == 302)) ? z17 : true;
                    try {
                        if (com.baidu.adp.b.a.ix() != null && eVar != null) {
                            com.baidu.adp.b.a.ix().a(TbConfig.TMP_PIC_DIR_NAME, eVar.le, eVar.lf);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dL(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.Ze.dw().lE = -18;
                        eVar.ll = "errorCode:" + String.valueOf(this.Ze.dw().lE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        uB();
                        this.Ze.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fs7 = com.baidu.adp.lib.util.i.fs();
                            if ((fs7 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (fs7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fw()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lo, z17, z7, fs7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.Ze.dw().lE = -19;
                        eVar.ll = "errorCode:" + String.valueOf(this.Ze.dw().lE) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        uB();
                        this.Ze.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fs8 = com.baidu.adp.lib.util.i.fs();
                            if ((fs8 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (fs8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fw()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lo, z17, z6, fs8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.Ze.dw().lE = -12;
                            eVar.ll = "errorCode:" + String.valueOf(this.Ze.dw().lE) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            uB();
                            this.Ze.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fs9 = com.baidu.adp.lib.util.i.fs();
                                if ((fs9 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fs9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    } else if (com.baidu.adp.lib.util.i.fw()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    }
                                    e.getInstance().result(c, eVar.lo, z17, z5, fs9);
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
                            this.Ze.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                fs = com.baidu.adp.lib.util.i.fs();
                                if ((fs ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!fs) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    } else if (com.baidu.adp.lib.util.i.fw()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    }
                                    e.getInstance().result(c, eVar.lo, z17, z4, fs);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.Ze.dw().lE = -13;
                        eVar.ll = "errorCode:" + String.valueOf(this.Ze.dw().lE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        uB();
                        this.Ze.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fs10 = com.baidu.adp.lib.util.i.fs();
                            if ((fs10 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (fs10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fw()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lo, z17, z3, fs10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.Ze.dw().lE = -19;
                        eVar.ll = "errorCode:" + String.valueOf(this.Ze.dw().lE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        uB();
                        this.Ze.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fs11 = com.baidu.adp.lib.util.i.fs();
                            if ((fs11 ? eVar.lo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (fs11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                } else if (com.baidu.adp.lib.util.i.fw()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KS);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                }
                                e.getInstance().result(c, eVar.lo, z17, z2, fs11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        uB();
                        this.Ze.b(eVar);
                        if (str != null) {
                        }
                        fs = com.baidu.adp.lib.util.i.fs();
                        if (fs ? eVar.lo != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!fs) {
                            }
                            e.getInstance().result(c, eVar.lo, z17, z4, fs);
                        }
                        throw th;
                    }
                }
            }
        }
        uB();
        this.Ze.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean fs12 = com.baidu.adp.lib.util.i.fs();
            if ((fs12 ? eVar.lo != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gm(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (fs12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                } else if (com.baidu.adp.lib.util.i.fw()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KS);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KR);
                }
                e.getInstance().result(c, eVar.lo, z11, z12, fs12);
            }
        }
        this.Zc = 0;
        this.Ze.dw().lG = bArr;
    }

    private void dL(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(Zl) && (System.currentTimeMillis() - Zn) - (1800000 * (Zm / 3)) >= 0) {
            Zm++;
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
                Zl = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean ce() {
        return this.hN;
    }

    public boolean uC() {
        return this.Zi;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        dm();
    }
}
