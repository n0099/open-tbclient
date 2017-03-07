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
    private static int aeW;
    public static String ahh;
    private static HttpClient ahi;
    private static String ahn;
    private static int aho;
    private static long ahp;
    private HttpGet ahd;
    private final com.baidu.adp.lib.network.http.f ahg;
    public boolean ahl;
    private final Context mContext;
    private static volatile String ahb = null;
    private static volatile boolean ahc = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ahj = new BasicHttpParams();
    private boolean sA = false;
    private boolean ahk = false;
    private int ahm = 0;
    private int ahe = 0;
    private volatile boolean ahf = false;

    static {
        aeW = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(ahj, 5000);
        HttpConnectionParams.setSoTimeout(ahj, 30000);
        HttpConnectionParams.setSocketBufferSize(ahj, 1024);
        HttpConnectionParams.setTcpNoDelay(ahj, true);
        HttpClientParams.setRedirecting(ahj, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ahj, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ahj, 10000L);
        ConnManagerParams.setMaxTotalConnections(ahj, 15);
        HttpProtocolParams.setUserAgent(ahj, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ahi = new DefaultHttpClient(new ThreadSafeClientConnManager(ahj, schemeRegistry), ahj);
        ahi.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            aeW = 4194304;
        }
        ahn = null;
        aho = 0;
        ahp = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        vX();
        this.ahg = fVar;
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
    }

    public static void vX() {
        synchronized (f.class) {
            if (!ahc) {
                ahc = true;
                vY();
            }
        }
    }

    public static synchronized void vY() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m9getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    ahb = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void fm() {
        this.ahf = true;
        this.ahg.fw().wi = true;
        vZ();
    }

    private void vZ() {
        try {
            if (this.ahd != null) {
                this.ahd.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void q(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().agZ) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.he()) {
            this.ahl = false;
            try {
                if (com.baidu.adp.lib.util.i.hg()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ahh == null) {
                            ahh = com.baidu.adp.lib.util.i.ho();
                        }
                        if (ahh != null && ahh.length() > 0) {
                            this.ahl = true;
                            if (dG(ahh) && com.baidu.adp.lib.util.i.hq()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ahh);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ahd = e.getInstance().httpGetFactory(sb.toString(), this.ahm, false);
                                    } else {
                                        this.ahd = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ahd = new HttpGet(sb.toString());
                                }
                                this.ahd.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ahd.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ahj.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ahj.setParameter("http.route.default-proxy", new HttpHost(ahh, com.baidu.adp.lib.util.i.hp()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ahh) || httpHost.getPort() != com.baidu.adp.lib.util.i.hp()) {
                                        ahj.setParameter("http.route.default-proxy", new HttpHost(ahh, com.baidu.adp.lib.util.i.hp()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ahd = e.getInstance().httpGetFactory(str, this.ahm, false);
                                    } else {
                                        this.ahd = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ahd = new HttpGet(str);
                                }
                                if (ahb != null) {
                                    this.ahd.setHeader("Proxy-Authorization", ahb);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ahd.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.hg()) {
                            if (!this.ahl || this.ahd == null) {
                                this.ahd = e.getInstance().httpGetFactory(str, this.ahm, false);
                            }
                        } else {
                            this.ahd = e.getInstance().httpGetFactory(str, this.ahm, true);
                        }
                    } else {
                        this.ahd = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.ahd = new HttpGet(str);
                }
                this.ahd.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean dG(String str) {
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
        boolean hf;
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
            if (!e.getInstance().agZ) {
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
            if (this.ahf || i2 >= i) {
                break;
            }
            this.ahm = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.ahg.a(eVar);
            eVar.vU = -1;
            InputStream inputStream2 = null;
            c = this.ahg.fv().c(eVar);
            try {
                eVar.vU = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    q(c, null, null);
                    if (z16) {
                        eVar.vV = e.getInstance().getCachedCdnIp(this.ahm);
                    }
                } else {
                    q(c, str, str2);
                    eVar.vV = str;
                }
                eVar.vU = -3;
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
            if (this.ahd == null) {
                throw new SocketException("network not available.");
            }
            if (this.ahf) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                vZ();
                this.ahg.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean hf2 = com.baidu.adp.lib.util.i.hf();
                    if ((hf2 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (hf2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                        } else if (com.baidu.adp.lib.util.i.hj()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                        }
                        e.getInstance().result(c, eVar.vV, z17, z8, hf2);
                    }
                }
            } else {
                eVar.vU = -8;
                HttpResponse execute = ahi.execute(this.ahd);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ahg.fw().responseCode = execute.getStatusLine().getStatusCode();
                eVar.vT = this.ahg.fw().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.vX = headers[0].getValue();
                            eVar.vY = headers[1].getValue();
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
                    this.ahg.fw().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.ahe < 1) {
                            vZ();
                            this.ahe++;
                            this.ahg.fw().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            vZ();
                            this.ahg.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hf3 = com.baidu.adp.lib.util.i.hf();
                                if ((hf3 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hf3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                                    } else if (com.baidu.adp.lib.util.i.hj()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                                    }
                                    e.getInstance().result(c, eVar.vV, z17, z14, hf3);
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
                            vZ();
                            this.ahg.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hf4 = com.baidu.adp.lib.util.i.hf();
                                if ((hf4 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hf4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                                    } else if (com.baidu.adp.lib.util.i.hj()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                                    }
                                    e.getInstance().result(c, eVar.vV, z17, z13, hf4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aeW) {
                    this.ahg.fw().wj = -11;
                    eVar.vS = this.mContext.getResources().getString(w.l.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    vZ();
                    this.ahg.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hf5 = com.baidu.adp.lib.util.i.hf();
                        if ((hf5 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (hf5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                            } else if (com.baidu.adp.lib.util.i.hj()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                            }
                            e.getInstance().result(c, eVar.vV, z17, z9, hf5);
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
                        this.sA = true;
                    } else {
                        this.sA = false;
                    }
                }
                while (!this.ahf && i3 < aeW && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.vU = -9;
                if (this.ahf) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    vZ();
                    this.ahg.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hf6 = com.baidu.adp.lib.util.i.hf();
                        if ((hf6 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (hf6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                            } else if (com.baidu.adp.lib.util.i.hj()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                            }
                            e.getInstance().result(c, eVar.vV, z17, z10, hf6);
                        }
                    }
                } else {
                    if (i3 < aeW) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.ahg.fw().wj = -11;
                        eVar.vS = this.mContext.getResources().getString(w.l.data_too_big);
                    }
                    eVar.vM = i3;
                    eVar.vP = i2 + 1;
                    eVar.vO = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.ahk = false;
                        } else {
                            this.ahk = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.ahg.fw().responseCode == 200 || this.ahg.fw().responseCode == 302)) ? z17 : true;
                    try {
                        if (ITrafficStatsNativeManager.kj() != null && eVar != null) {
                            ITrafficStatsNativeManager.kj().a(TbConfig.TMP_PIC_DIR_NAME, eVar.vL, eVar.vM);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dH(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.ahg.fw().wj = -18;
                        eVar.vS = "errorCode:" + String.valueOf(this.ahg.fw().wj) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vZ();
                        this.ahg.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hf7 = com.baidu.adp.lib.util.i.hf();
                            if ((hf7 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (hf7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                                } else if (com.baidu.adp.lib.util.i.hj()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                                }
                                e.getInstance().result(c, eVar.vV, z17, z7, hf7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.ahg.fw().wj = -19;
                        eVar.vS = "errorCode:" + String.valueOf(this.ahg.fw().wj) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        vZ();
                        this.ahg.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hf8 = com.baidu.adp.lib.util.i.hf();
                            if ((hf8 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (hf8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                                } else if (com.baidu.adp.lib.util.i.hj()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                                }
                                e.getInstance().result(c, eVar.vV, z17, z6, hf8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.ahg.fw().wj = -12;
                            eVar.vS = "errorCode:" + String.valueOf(this.ahg.fw().wj) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            vZ();
                            this.ahg.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hf9 = com.baidu.adp.lib.util.i.hf();
                                if ((hf9 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hf9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                                    } else if (com.baidu.adp.lib.util.i.hj()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                                    }
                                    e.getInstance().result(c, eVar.vV, z17, z5, hf9);
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
                            vZ();
                            this.ahg.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                hf = com.baidu.adp.lib.util.i.hf();
                                if ((hf ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hf) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                                    } else if (com.baidu.adp.lib.util.i.hj()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                                    }
                                    e.getInstance().result(c, eVar.vV, z17, z4, hf);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.ahg.fw().wj = -13;
                        eVar.vS = "errorCode:" + String.valueOf(this.ahg.fw().wj) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        vZ();
                        this.ahg.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hf10 = com.baidu.adp.lib.util.i.hf();
                            if ((hf10 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (hf10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                                } else if (com.baidu.adp.lib.util.i.hj()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                                }
                                e.getInstance().result(c, eVar.vV, z17, z3, hf10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.ahg.fw().wj = -19;
                        eVar.vS = "errorCode:" + String.valueOf(this.ahg.fw().wj) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        vZ();
                        this.ahg.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hf11 = com.baidu.adp.lib.util.i.hf();
                            if ((hf11 ? eVar.vV != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (hf11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                                } else if (com.baidu.adp.lib.util.i.hj()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                                }
                                e.getInstance().result(c, eVar.vV, z17, z2, hf11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        vZ();
                        this.ahg.b(eVar);
                        if (str != null) {
                        }
                        hf = com.baidu.adp.lib.util.i.hf();
                        if (hf ? eVar.vV != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!hf) {
                            }
                            e.getInstance().result(c, eVar.vV, z17, z4, hf);
                        }
                        throw th;
                    }
                }
            }
        }
        vZ();
        this.ahg.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean hf12 = com.baidu.adp.lib.util.i.hf();
            if ((hf12 ? eVar.vV != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fY(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (hf12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Rs);
                } else if (com.baidu.adp.lib.util.i.hj()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Ru);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Rt);
                }
                e.getInstance().result(c, eVar.vV, z11, z12, hf12);
            }
        }
        this.ahe = 0;
        this.ahg.fw().wl = bArr;
    }

    private void dH(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(ahn) && (System.currentTimeMillis() - ahp) - (1800000 * (aho / 3)) >= 0) {
            aho++;
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
                ahn = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean ef() {
        return this.sA;
    }

    public boolean wa() {
        return this.ahk;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        fm();
    }
}
