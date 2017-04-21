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
    private static int afl;
    private static String ahC;
    private static int ahD;
    private static long ahE;
    public static String ahw;
    private static HttpClient ahx;
    public boolean ahA;
    private HttpGet ahs;
    private final com.baidu.adp.lib.network.http.f ahv;
    private final Context mContext;
    private static volatile String ahq = null;
    private static volatile boolean ahr = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ahy = new BasicHttpParams();
    private boolean sa = false;
    private boolean ahz = false;
    private int ahB = 0;
    private int aht = 0;
    private volatile boolean ahu = false;

    static {
        afl = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(ahy, 5000);
        HttpConnectionParams.setSoTimeout(ahy, 30000);
        HttpConnectionParams.setSocketBufferSize(ahy, 1024);
        HttpConnectionParams.setTcpNoDelay(ahy, true);
        HttpClientParams.setRedirecting(ahy, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ahy, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ahy, 10000L);
        ConnManagerParams.setMaxTotalConnections(ahy, 15);
        HttpProtocolParams.setUserAgent(ahy, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ahx = new DefaultHttpClient(new ThreadSafeClientConnManager(ahy, schemeRegistry), ahy);
        ahx.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            afl = 4194304;
        }
        ahC = null;
        ahD = 0;
        ahE = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        wu();
        this.ahv = fVar;
        this.mContext = TbadkCoreApplication.m9getInst().getApp();
    }

    public static void wu() {
        synchronized (f.class) {
            if (!ahr) {
                ahr = true;
                wv();
            }
        }
    }

    public static synchronized void wv() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m9getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    ahq = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void fs() {
        this.ahu = true;
        this.ahv.fC().vP = true;
        ww();
    }

    private void ww() {
        try {
            if (this.ahs != null) {
                this.ahs.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().aho) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.hk()) {
            this.ahA = false;
            try {
                if (com.baidu.adp.lib.util.i.hm()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ahw == null) {
                            ahw = com.baidu.adp.lib.util.i.hu();
                        }
                        if (ahw != null && ahw.length() > 0) {
                            this.ahA = true;
                            if (dM(ahw) && com.baidu.adp.lib.util.i.hw()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ahw);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ahs = e.getInstance().httpGetFactory(sb.toString(), this.ahB, false);
                                    } else {
                                        this.ahs = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ahs = new HttpGet(sb.toString());
                                }
                                this.ahs.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ahs.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ahy.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ahy.setParameter("http.route.default-proxy", new HttpHost(ahw, com.baidu.adp.lib.util.i.hv()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ahw) || httpHost.getPort() != com.baidu.adp.lib.util.i.hv()) {
                                        ahy.setParameter("http.route.default-proxy", new HttpHost(ahw, com.baidu.adp.lib.util.i.hv()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ahs = e.getInstance().httpGetFactory(str, this.ahB, false);
                                    } else {
                                        this.ahs = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ahs = new HttpGet(str);
                                }
                                if (ahq != null) {
                                    this.ahs.setHeader("Proxy-Authorization", ahq);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ahs.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.hm()) {
                            if (!this.ahA || this.ahs == null) {
                                this.ahs = e.getInstance().httpGetFactory(str, this.ahB, false);
                            }
                        } else {
                            this.ahs = e.getInstance().httpGetFactory(str, this.ahB, true);
                        }
                    } else {
                        this.ahs = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.ahs = new HttpGet(str);
                }
                this.ahs.setHeader("needginfo", "1");
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
            if (!e.getInstance().aho) {
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
            if (this.ahu || i2 >= i) {
                break;
            }
            this.ahB = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.ahv.a(eVar);
            eVar.vB = -1;
            InputStream inputStream2 = null;
            c = this.ahv.fB().c(eVar);
            try {
                eVar.vB = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    l(c, null, null);
                    if (z16) {
                        eVar.vC = e.getInstance().getCachedCdnIp(this.ahB);
                    }
                } else {
                    l(c, str, str2);
                    eVar.vC = str;
                }
                eVar.vB = -3;
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
            if (this.ahs == null) {
                throw new SocketException("network not available.");
            }
            if (this.ahu) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                ww();
                this.ahv.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean hl2 = com.baidu.adp.lib.util.i.hl();
                    if ((hl2 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (hl2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RM);
                        } else if (com.baidu.adp.lib.util.i.hp()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RP);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RO);
                        }
                        e.getInstance().result(c, eVar.vC, z17, z8, hl2);
                    }
                }
            } else {
                eVar.vB = -8;
                HttpResponse execute = ahx.execute(this.ahs);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ahv.fC().responseCode = execute.getStatusLine().getStatusCode();
                eVar.vA = this.ahv.fC().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.vE = headers[0].getValue();
                            eVar.vF = headers[1].getValue();
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
                    this.ahv.fC().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.aht < 1) {
                            ww();
                            this.aht++;
                            this.ahv.fC().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            ww();
                            this.ahv.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hl3 = com.baidu.adp.lib.util.i.hl();
                                if ((hl3 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hl3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                    } else if (com.baidu.adp.lib.util.i.hp()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RP);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RO);
                                    }
                                    e.getInstance().result(c, eVar.vC, z17, z14, hl3);
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
                            ww();
                            this.ahv.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hl4 = com.baidu.adp.lib.util.i.hl();
                                if ((hl4 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hl4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                    } else if (com.baidu.adp.lib.util.i.hp()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RP);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RO);
                                    }
                                    e.getInstance().result(c, eVar.vC, z17, z13, hl4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > afl) {
                    this.ahv.fC().vQ = -11;
                    eVar.vz = this.mContext.getResources().getString(w.l.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    ww();
                    this.ahv.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hl5 = com.baidu.adp.lib.util.i.hl();
                        if ((hl5 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (hl5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RM);
                            } else if (com.baidu.adp.lib.util.i.hp()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RP);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RO);
                            }
                            e.getInstance().result(c, eVar.vC, z17, z9, hl5);
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
                        this.sa = true;
                    } else {
                        this.sa = false;
                    }
                }
                while (!this.ahu && i3 < afl && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.vB = -9;
                if (this.ahu) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    ww();
                    this.ahv.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hl6 = com.baidu.adp.lib.util.i.hl();
                        if ((hl6 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (hl6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RM);
                            } else if (com.baidu.adp.lib.util.i.hp()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RP);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RO);
                            }
                            e.getInstance().result(c, eVar.vC, z17, z10, hl6);
                        }
                    }
                } else {
                    if (i3 < afl) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.ahv.fC().vQ = -11;
                        eVar.vz = this.mContext.getResources().getString(w.l.data_too_big);
                    }
                    eVar.vu = i3;
                    eVar.vw = i2 + 1;
                    eVar.vv = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.ahz = false;
                        } else {
                            this.ahz = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.ahv.fC().responseCode == 200 || this.ahv.fC().responseCode == 302)) ? z17 : true;
                    try {
                        if (ITrafficStatsNativeManager.ko() != null && eVar != null) {
                            ITrafficStatsNativeManager.ko().a(TbConfig.TMP_PIC_DIR_NAME, eVar.vt, eVar.vu);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dN(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.ahv.fC().vQ = -18;
                        eVar.vz = "errorCode:" + String.valueOf(this.ahv.fC().vQ) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        ww();
                        this.ahv.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hl7 = com.baidu.adp.lib.util.i.hl();
                            if ((hl7 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (hl7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                } else if (com.baidu.adp.lib.util.i.hp()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RP);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RO);
                                }
                                e.getInstance().result(c, eVar.vC, z17, z7, hl7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.ahv.fC().vQ = -19;
                        eVar.vz = "errorCode:" + String.valueOf(this.ahv.fC().vQ) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        ww();
                        this.ahv.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hl8 = com.baidu.adp.lib.util.i.hl();
                            if ((hl8 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (hl8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                } else if (com.baidu.adp.lib.util.i.hp()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RP);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RO);
                                }
                                e.getInstance().result(c, eVar.vC, z17, z6, hl8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.ahv.fC().vQ = -12;
                            eVar.vz = "errorCode:" + String.valueOf(this.ahv.fC().vQ) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            ww();
                            this.ahv.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hl9 = com.baidu.adp.lib.util.i.hl();
                                if ((hl9 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hl9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                    } else if (com.baidu.adp.lib.util.i.hp()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RP);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RO);
                                    }
                                    e.getInstance().result(c, eVar.vC, z17, z5, hl9);
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
                            ww();
                            this.ahv.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                hl = com.baidu.adp.lib.util.i.hl();
                                if ((hl ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hl) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                    } else if (com.baidu.adp.lib.util.i.hp()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RP);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RO);
                                    }
                                    e.getInstance().result(c, eVar.vC, z17, z4, hl);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.ahv.fC().vQ = -13;
                        eVar.vz = "errorCode:" + String.valueOf(this.ahv.fC().vQ) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        ww();
                        this.ahv.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hl10 = com.baidu.adp.lib.util.i.hl();
                            if ((hl10 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (hl10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                } else if (com.baidu.adp.lib.util.i.hp()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RP);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RO);
                                }
                                e.getInstance().result(c, eVar.vC, z17, z3, hl10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.ahv.fC().vQ = -19;
                        eVar.vz = "errorCode:" + String.valueOf(this.ahv.fC().vQ) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        ww();
                        this.ahv.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean hl11 = com.baidu.adp.lib.util.i.hl();
                            if ((hl11 ? eVar.vC != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (hl11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RM);
                                } else if (com.baidu.adp.lib.util.i.hp()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RP);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RO);
                                }
                                e.getInstance().result(c, eVar.vC, z17, z2, hl11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        ww();
                        this.ahv.b(eVar);
                        if (str != null) {
                        }
                        hl = com.baidu.adp.lib.util.i.hl();
                        if (hl ? eVar.vC != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!hl) {
                            }
                            e.getInstance().result(c, eVar.vC, z17, z4, hl);
                        }
                        throw th;
                    }
                }
            }
        }
        ww();
        this.ahv.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean hl12 = com.baidu.adp.lib.util.i.hl();
            if ((hl12 ? eVar.vC != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.ge(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (hl12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RM);
                } else if (com.baidu.adp.lib.util.i.hp()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RP);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RO);
                }
                e.getInstance().result(c, eVar.vC, z11, z12, hl12);
            }
        }
        this.aht = 0;
        this.ahv.fC().vS = bArr;
    }

    private void dN(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(ahC) && (System.currentTimeMillis() - ahE) - (1800000 * (ahD / 3)) >= 0) {
            ahD++;
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
                ahC = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean ef() {
        return this.sa;
    }

    public boolean wx() {
        return this.ahz;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        fs();
    }
}
