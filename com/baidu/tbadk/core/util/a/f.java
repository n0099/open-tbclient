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
    private static int aaA;
    public static String acO;
    private static HttpClient acP;
    private static String acU;
    private static int acV;
    private static long acW;
    private HttpGet acK;
    private final com.baidu.adp.lib.network.http.f acN;
    public boolean acS;
    private final Context mContext;
    private static volatile String acI = null;
    private static volatile boolean acJ = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams acQ = new BasicHttpParams();
    private boolean kK = false;
    private boolean acR = false;
    private int acT = 0;
    private int acL = 0;
    private volatile boolean acM = false;

    static {
        aaA = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(acQ, 5000);
        HttpConnectionParams.setSoTimeout(acQ, 30000);
        HttpConnectionParams.setSocketBufferSize(acQ, 1024);
        HttpConnectionParams.setTcpNoDelay(acQ, true);
        HttpClientParams.setRedirecting(acQ, true);
        ConnManagerParams.setMaxConnectionsPerRoute(acQ, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(acQ, 10000L);
        ConnManagerParams.setMaxTotalConnections(acQ, 15);
        HttpProtocolParams.setUserAgent(acQ, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        acP = new DefaultHttpClient(new ThreadSafeClientConnManager(acQ, schemeRegistry), acQ);
        acP.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            aaA = 4194304;
        }
        acU = null;
        acV = 0;
        acW = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        vS();
        this.acN = fVar;
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
    }

    public static void vS() {
        synchronized (f.class) {
            if (!acJ) {
                acJ = true;
                vT();
            }
        }
    }

    public static synchronized void vT() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m9getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    acI = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void eg() {
        this.acM = true;
        this.acN.eq().oD = true;
        vU();
    }

    private void vU() {
        try {
            if (this.acK != null) {
                this.acK.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void r(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().acG) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.gm()) {
            this.acS = false;
            try {
                if (com.baidu.adp.lib.util.i.go()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (acO == null) {
                            acO = com.baidu.adp.lib.util.i.gw();
                        }
                        if (acO != null && acO.length() > 0) {
                            this.acS = true;
                            if (dO(acO) && com.baidu.adp.lib.util.i.gy()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(acO);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.acK = e.getInstance().httpGetFactory(sb.toString(), this.acT, false);
                                    } else {
                                        this.acK = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.acK = new HttpGet(sb.toString());
                                }
                                this.acK.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.acK.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = acQ.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    acQ.setParameter("http.route.default-proxy", new HttpHost(acO, com.baidu.adp.lib.util.i.gx()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(acO) || httpHost.getPort() != com.baidu.adp.lib.util.i.gx()) {
                                        acQ.setParameter("http.route.default-proxy", new HttpHost(acO, com.baidu.adp.lib.util.i.gx()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.acK = e.getInstance().httpGetFactory(str, this.acT, false);
                                    } else {
                                        this.acK = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.acK = new HttpGet(str);
                                }
                                if (acI != null) {
                                    this.acK.setHeader("Proxy-Authorization", acI);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.acK.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.go()) {
                            if (!this.acS || this.acK == null) {
                                this.acK = e.getInstance().httpGetFactory(str, this.acT, false);
                            }
                        } else {
                            this.acK = e.getInstance().httpGetFactory(str, this.acT, true);
                        }
                    } else {
                        this.acK = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.acK = new HttpGet(str);
                }
                this.acK.setHeader("needginfo", "1");
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
            if (!e.getInstance().acG) {
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
            if (this.acM || i2 >= i) {
                break;
            }
            this.acT = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.acN.a(eVar);
            eVar.om = -1;
            InputStream inputStream2 = null;
            c = this.acN.ep().c(eVar);
            try {
                eVar.om = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    r(c, null, null);
                    if (z16) {
                        eVar.oo = e.getInstance().getCachedCdnIp(this.acT);
                    }
                } else {
                    r(c, str, str2);
                    eVar.oo = str;
                }
                eVar.om = -3;
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
            if (this.acK == null) {
                throw new SocketException("network not available.");
            }
            if (this.acM) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                vU();
                this.acN.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean gn2 = com.baidu.adp.lib.util.i.gn();
                    if ((gn2 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (gn2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                        } else if (com.baidu.adp.lib.util.i.gr()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                        }
                        e.getInstance().result(c, eVar.oo, z17, z8, gn2);
                    }
                }
            } else {
                eVar.om = -8;
                HttpResponse execute = acP.execute(this.acK);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.acN.eq().responseCode = execute.getStatusLine().getStatusCode();
                eVar.ol = this.acN.eq().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.or = headers[0].getValue();
                            eVar.ot = headers[1].getValue();
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
                    this.acN.eq().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.acL < 1) {
                            vU();
                            this.acL++;
                            this.acN.eq().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            vU();
                            this.acN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gn3 = com.baidu.adp.lib.util.i.gn();
                                if ((gn3 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gn3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                    } else if (com.baidu.adp.lib.util.i.gr()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                    }
                                    e.getInstance().result(c, eVar.oo, z17, z14, gn3);
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
                            vU();
                            this.acN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gn4 = com.baidu.adp.lib.util.i.gn();
                                if ((gn4 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gn4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                    } else if (com.baidu.adp.lib.util.i.gr()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                    }
                                    e.getInstance().result(c, eVar.oo, z17, z13, gn4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aaA) {
                    this.acN.eq().oE = -11;
                    eVar.oj = this.mContext.getResources().getString(r.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    vU();
                    this.acN.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean gn5 = com.baidu.adp.lib.util.i.gn();
                        if ((gn5 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (gn5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                            } else if (com.baidu.adp.lib.util.i.gr()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                            }
                            e.getInstance().result(c, eVar.oo, z17, z9, gn5);
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
                while (!this.acM && i3 < aaA && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.om = -9;
                if (this.acM) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    vU();
                    this.acN.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean gn6 = com.baidu.adp.lib.util.i.gn();
                        if ((gn6 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (gn6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                            } else if (com.baidu.adp.lib.util.i.gr()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                            }
                            e.getInstance().result(c, eVar.oo, z17, z10, gn6);
                        }
                    }
                } else {
                    if (i3 < aaA) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.acN.eq().oE = -11;
                        eVar.oj = this.mContext.getResources().getString(r.j.data_too_big);
                    }
                    eVar.od = i3;
                    eVar.og = i2 + 1;
                    eVar.of = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.acR = false;
                        } else {
                            this.acR = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.acN.eq().responseCode == 200 || this.acN.eq().responseCode == 302)) ? z17 : true;
                    try {
                        if (com.baidu.adp.b.a.jr() != null && eVar != null) {
                            com.baidu.adp.b.a.jr().a(TbConfig.TMP_PIC_DIR_NAME, eVar.oc, eVar.od);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dP(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.acN.eq().oE = -18;
                        eVar.oj = "errorCode:" + String.valueOf(this.acN.eq().oE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vU();
                        this.acN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gn7 = com.baidu.adp.lib.util.i.gn();
                            if ((gn7 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (gn7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                } else if (com.baidu.adp.lib.util.i.gr()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                }
                                e.getInstance().result(c, eVar.oo, z17, z7, gn7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.acN.eq().oE = -19;
                        eVar.oj = "errorCode:" + String.valueOf(this.acN.eq().oE) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        vU();
                        this.acN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gn8 = com.baidu.adp.lib.util.i.gn();
                            if ((gn8 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (gn8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                } else if (com.baidu.adp.lib.util.i.gr()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                }
                                e.getInstance().result(c, eVar.oo, z17, z6, gn8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.acN.eq().oE = -12;
                            eVar.oj = "errorCode:" + String.valueOf(this.acN.eq().oE) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            vU();
                            this.acN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gn9 = com.baidu.adp.lib.util.i.gn();
                                if ((gn9 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gn9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                    } else if (com.baidu.adp.lib.util.i.gr()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                    }
                                    e.getInstance().result(c, eVar.oo, z17, z5, gn9);
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
                            vU();
                            this.acN.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                gn = com.baidu.adp.lib.util.i.gn();
                                if ((gn ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!gn) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                    } else if (com.baidu.adp.lib.util.i.gr()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                    }
                                    e.getInstance().result(c, eVar.oo, z17, z4, gn);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.acN.eq().oE = -13;
                        eVar.oj = "errorCode:" + String.valueOf(this.acN.eq().oE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        vU();
                        this.acN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gn10 = com.baidu.adp.lib.util.i.gn();
                            if ((gn10 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (gn10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                } else if (com.baidu.adp.lib.util.i.gr()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                }
                                e.getInstance().result(c, eVar.oo, z17, z3, gn10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.acN.eq().oE = -19;
                        eVar.oj = "errorCode:" + String.valueOf(this.acN.eq().oE) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        vU();
                        this.acN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean gn11 = com.baidu.adp.lib.util.i.gn();
                            if ((gn11 ? eVar.oo != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (gn11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                                } else if (com.baidu.adp.lib.util.i.gr()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                                }
                                e.getInstance().result(c, eVar.oo, z17, z2, gn11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        vU();
                        this.acN.b(eVar);
                        if (str != null) {
                        }
                        gn = com.baidu.adp.lib.util.i.gn();
                        if (gn ? eVar.oo != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!gn) {
                            }
                            e.getInstance().result(c, eVar.oo, z17, z4, gn);
                        }
                        throw th;
                    }
                }
            }
        }
        vU();
        this.acN.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean gn12 = com.baidu.adp.lib.util.i.gn();
            if ((gn12 ? eVar.oo != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gr(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (gn12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Nd);
                } else if (com.baidu.adp.lib.util.i.gr()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Nf);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Ne);
                }
                e.getInstance().result(c, eVar.oo, z11, z12, gn12);
            }
        }
        this.acL = 0;
        this.acN.eq().oG = bArr;
    }

    private void dP(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(acU) && (System.currentTimeMillis() - acW) - (1800000 * (acV / 3)) >= 0) {
            acV++;
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
                acU = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean cY() {
        return this.kK;
    }

    public boolean vV() {
        return this.acR;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        eg();
    }
}
