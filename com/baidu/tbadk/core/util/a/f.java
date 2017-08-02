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
import com.baidu.tieba.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
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
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public class f implements a.InterfaceC0006a {
    private static int afz;
    public static String ahJ;
    private static HttpClient ahK;
    private static String ahP;
    private static int ahQ;
    private static long ahR;
    private HttpGet ahF;
    private final com.baidu.adp.lib.network.http.e ahI;
    public boolean ahN;
    private final Context mContext;
    private static volatile String ahD = null;
    private static volatile boolean ahE = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ahL = new BasicHttpParams();
    private boolean sa = false;
    private boolean ahM = false;
    private int ahO = 0;
    private int ahG = 0;
    private volatile boolean ahH = false;

    static {
        afz = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(ahL, 5000);
        HttpConnectionParams.setSoTimeout(ahL, 30000);
        HttpConnectionParams.setSocketBufferSize(ahL, 1024);
        HttpConnectionParams.setTcpNoDelay(ahL, true);
        HttpClientParams.setRedirecting(ahL, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ahL, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ahL, 10000L);
        ConnManagerParams.setMaxTotalConnections(ahL, 15);
        HttpProtocolParams.setUserAgent(ahL, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ahK = new DefaultHttpClient(new ThreadSafeClientConnManager(ahL, schemeRegistry), ahL);
        ahK.setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            afz = 4194304;
        }
        ahP = null;
        ahQ = 0;
        ahR = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        wc();
        this.ahI = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void wc() {
        synchronized (f.class) {
            if (!ahE) {
                ahE = true;
                wd();
            }
        }
    }

    public static synchronized void wd() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    ahD = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void fp() {
        this.ahH = true;
        this.ahI.fz().vQ = true;
        we();
    }

    private void we() {
        try {
            if (this.ahF != null) {
                this.ahF.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().ahB) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.hh()) {
            this.ahN = false;
            try {
                if (com.baidu.adp.lib.util.i.hj()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ahJ == null) {
                            ahJ = com.baidu.adp.lib.util.i.hr();
                        }
                        if (ahJ != null && ahJ.length() > 0) {
                            this.ahN = true;
                            if (ef(ahJ) && com.baidu.adp.lib.util.i.ht()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ahJ);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ahF = e.getInstance().httpGetFactory(sb.toString(), this.ahO, false);
                                    } else {
                                        this.ahF = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ahF = new HttpGet(sb.toString());
                                }
                                this.ahF.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ahF.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ahL.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ahL.setParameter("http.route.default-proxy", new HttpHost(ahJ, com.baidu.adp.lib.util.i.hs()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ahJ) || httpHost.getPort() != com.baidu.adp.lib.util.i.hs()) {
                                        ahL.setParameter("http.route.default-proxy", new HttpHost(ahJ, com.baidu.adp.lib.util.i.hs()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ahF = e.getInstance().httpGetFactory(str, this.ahO, false);
                                    } else {
                                        this.ahF = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ahF = new HttpGet(str);
                                }
                                if (ahD != null) {
                                    this.ahF.setHeader("Proxy-Authorization", ahD);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ahF.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.hj()) {
                            if (!this.ahN || this.ahF == null) {
                                this.ahF = e.getInstance().httpGetFactory(str, this.ahO, false);
                            }
                        } else {
                            this.ahF = e.getInstance().httpGetFactory(str, this.ahO, true);
                        }
                    } else {
                        this.ahF = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.ahF = new HttpGet(str);
                }
                this.ahF.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean ef(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [633=13, 634=13, 638=13, 644=13, 645=13, 646=13, 647=13, 648=13, 649=26, 651=13, 652=13, 654=13, 657=13, 659=26, 660=13, 662=13, 665=13, 667=13, 672=6] */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x097d, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:151:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x08a3 A[Catch: SocketException -> 0x0536, SocketTimeoutException -> 0x09f5, HttpException -> 0x09ff, all -> 0x0c20, Throwable -> 0x0ce4, IllegalStateException -> 0x0cf4, IOException -> 0x0d00, TRY_ENTER, TryCatch #0 {all -> 0x0c20, blocks: (B:238:0x0500, B:240:0x050b, B:242:0x0516, B:244:0x0519, B:246:0x052d, B:247:0x0535, B:250:0x053a, B:252:0x0540, B:254:0x055c, B:256:0x0563, B:339:0x0699, B:341:0x06a2, B:383:0x074d, B:385:0x0767, B:387:0x0778, B:392:0x0785, B:394:0x07ae, B:395:0x07bb, B:397:0x07c6, B:399:0x07de, B:400:0x07e4, B:402:0x07ea, B:404:0x07ee, B:406:0x07f8, B:409:0x080b, B:452:0x08a3, B:454:0x08a7, B:455:0x08ab, B:457:0x08b4, B:459:0x08be, B:461:0x08c7, B:464:0x08de, B:466:0x08f9, B:468:0x0904, B:470:0x090e, B:520:0x09f8, B:472:0x091b, B:474:0x0922, B:476:0x0930, B:610:0x0b45, B:209:0x0446, B:175:0x036c, B:141:0x02b0, B:61:0x0149, B:517:0x09d7, B:407:0x0804), top: B:759:0x0500 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x0a3a  */
    /* JADX WARN: Removed duplicated region for block: B:554:0x0a70  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0aa6  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0adc  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0b12  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0bb3  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x0bd0  */
    /* JADX WARN: Removed duplicated region for block: B:639:0x0bf2  */
    /* JADX WARN: Removed duplicated region for block: B:662:0x0c42  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x0c5f  */
    /* JADX WARN: Removed duplicated region for block: B:682:0x0c80  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:768:0x0b95 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:770:0x049d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:772:0x03bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:774:0x0c24 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:776:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:784:0x0300 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:786:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:793:0x0816 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String c;
        InputStream inputStream;
        Throwable th;
        boolean hi;
        boolean z;
        boolean hi2;
        boolean z2;
        boolean hi3;
        boolean z3;
        boolean hi4;
        boolean z4;
        boolean hi5;
        boolean z5;
        boolean hi6;
        boolean z6;
        boolean hi7;
        boolean z7;
        long currentTimeMillis2;
        boolean z8;
        boolean z9;
        int i2;
        boolean z10;
        boolean z11;
        boolean z12;
        String value;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        int read;
        String obj;
        boolean z13;
        boolean z14;
        Header[] headers;
        byte[] bArr7 = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().ahB) {
                e.getInstance().init();
            }
        }
        boolean z16 = z15;
        if (i <= 0) {
            i = 5;
        }
        boolean z17 = false;
        int i3 = 0;
        while (true) {
            if (this.ahH || i3 >= i) {
                break;
            }
            this.ahO = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.ahI.a(dVar);
            dVar.vC = -1;
            InputStream inputStream2 = null;
            c = this.ahI.fy().c(dVar);
            try {
                dVar.vC = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    l(c, null, null);
                    if (z16) {
                        dVar.vD = e.getInstance().getCachedCdnIp(this.ahO);
                    }
                } else {
                    l(c, str, str2);
                    dVar.vD = str;
                }
                dVar.vC = -3;
            } catch (SocketException e) {
                e = e;
            } catch (SocketTimeoutException e2) {
                e = e2;
                inputStream = null;
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (IllegalStateException e4) {
                e = e4;
                inputStream = null;
            } catch (HttpException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.ahF == null) {
                throw new SocketException("network not available.");
            }
            if (this.ahH) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                we();
                this.ahI.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean hi8 = com.baidu.adp.lib.util.i.hi();
                    if ((hi8 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (hi8) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().QY);
                        } else if (com.baidu.adp.lib.util.i.hm()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                        }
                        e.getInstance().result(c, dVar.vD, z17, z8, hi8);
                    }
                }
            } else {
                dVar.vC = -8;
                HttpResponse execute = ahK.execute(this.ahF);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ahI.fz().responseCode = execute.getStatusLine().getStatusCode();
                dVar.vB = this.ahI.fz().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.vF = headers[0].getValue();
                            dVar.vG = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (SocketTimeoutException e7) {
                    e = e7;
                } catch (IOException e8) {
                    e = e8;
                } catch (HttpException e9) {
                    e = e9;
                } catch (IllegalStateException e10) {
                    e = e10;
                } catch (SocketException e11) {
                    e = e11;
                    inputStream2 = inputStream;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.ahI.fz().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.ahG < 1) {
                            we();
                            this.ahG++;
                            this.ahI.fz().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            we();
                            this.ahI.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hi9 = com.baidu.adp.lib.util.i.hi();
                                if ((hi9 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hi9) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                    } else if (com.baidu.adp.lib.util.i.hm()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z14, hi9);
                                }
                            }
                            i3++;
                            bArr7 = bArr7;
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e13) {
                                }
                            }
                            we();
                            this.ahI.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hi10 = com.baidu.adp.lib.util.i.hi();
                                if ((hi10 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hi10) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                    } else if (com.baidu.adp.lib.util.i.hm()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z13, hi10);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > afz) {
                    this.ahI.fz().vR = -11;
                    dVar.vA = this.mContext.getResources().getString(d.l.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    we();
                    this.ahI.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hi11 = com.baidu.adp.lib.util.i.hi();
                        if ((hi11 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (hi11) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().QY);
                            } else if (com.baidu.adp.lib.util.i.hm()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                            }
                            e.getInstance().result(c, dVar.vD, z17, z9, hi11);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr8 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i4 = 0;
                boolean z18 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z18 = true;
                }
                if (z18) {
                    byte[] bArr9 = new byte[23];
                    int read2 = inputStream.read(bArr9, 0, 23);
                    if (!new String(bArr9, 0, bArr9.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                        byteArrayOutputStream.write(bArr9, 0, read2);
                        i4 = 0 + read2;
                    }
                }
                if (execute.getFirstHeader("Src-Content-Type") != null) {
                    if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                        this.sa = true;
                        i2 = i4;
                        while (!this.ahH && i2 < afz && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.vC = -9;
                        if (!this.ahH) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            we();
                            this.ahI.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hi12 = com.baidu.adp.lib.util.i.hi();
                                if ((hi12 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                    long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hi12) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                    } else if (com.baidu.adp.lib.util.i.hm()) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                    } else {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z10, hi12);
                                }
                            }
                        } else {
                            if (i2 < afz) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    if (entity.getContentEncoding() != null) {
                                        String value2 = entity.getContentEncoding().getValue();
                                        if (value2 != null && value2.contains("gzip")) {
                                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                                            byteArray = byteArrayOutputStream2.toByteArray();
                                        }
                                        bArr7 = byteArray;
                                    } else {
                                        bArr7 = byteArray;
                                    }
                                } catch (IllegalStateException e16) {
                                    bArr7 = bArr6;
                                    e = e16;
                                    this.ahI.fz().vR = -19;
                                    dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e17) {
                                        }
                                    }
                                    we();
                                    this.ahI.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi7 = com.baidu.adp.lib.util.i.hi();
                                        if ((hi7 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi7) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                            } else if (com.baidu.adp.lib.util.i.hm()) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                            } else {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                            }
                                            e.getInstance().result(c, dVar.vD, z17, z7, hi7);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (SocketException e18) {
                                    bArr7 = bArr5;
                                    e = e18;
                                    inputStream2 = inputStream;
                                    try {
                                        this.ahI.fz().vR = -12;
                                        dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage();
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e19) {
                                            }
                                        }
                                        we();
                                        this.ahI.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            hi6 = com.baidu.adp.lib.util.i.hi();
                                            if ((hi6 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!hi6) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                                } else if (com.baidu.adp.lib.util.i.hm()) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                                } else {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                                }
                                                e.getInstance().result(c, dVar.vD, z17, z6, hi6);
                                            }
                                        }
                                        i3++;
                                        bArr7 = bArr7;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        inputStream = inputStream2;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e20) {
                                            }
                                        }
                                        we();
                                        this.ahI.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            hi5 = com.baidu.adp.lib.util.i.hi();
                                            if ((hi5 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!hi5) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                                } else if (com.baidu.adp.lib.util.i.hm()) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                                } else {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                                }
                                                e.getInstance().result(c, dVar.vD, z17, z5, hi5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e21) {
                                    bArr7 = bArr4;
                                    e = e21;
                                    this.ahI.fz().vR = -13;
                                    dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e22) {
                                        }
                                    }
                                    we();
                                    this.ahI.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi2 = com.baidu.adp.lib.util.i.hi();
                                        if ((hi2 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                            long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi2) {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                            } else if (com.baidu.adp.lib.util.i.hm()) {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                            } else {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                            }
                                            e.getInstance().result(c, dVar.vD, z17, z2, hi2);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (HttpException e23) {
                                    bArr7 = bArr3;
                                    e = e23;
                                    this.ahI.fz().vR = -18;
                                    dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e24) {
                                        }
                                    }
                                    we();
                                    this.ahI.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi3 = com.baidu.adp.lib.util.i.hi();
                                        if ((hi3 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                            long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi3) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                            } else if (com.baidu.adp.lib.util.i.hm()) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                            } else {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                            }
                                            e.getInstance().result(c, dVar.vD, z17, z3, hi3);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (IOException e25) {
                                    bArr7 = bArr2;
                                    e = e25;
                                    this.ahI.fz().vR = -19;
                                    dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e26) {
                                        }
                                    }
                                    we();
                                    this.ahI.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi4 = com.baidu.adp.lib.util.i.hi();
                                        if ((hi4 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                            long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi4) {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                            } else if (com.baidu.adp.lib.util.i.hm()) {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                            } else {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                            }
                                            e.getInstance().result(c, dVar.vD, z17, z4, hi4);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (Throwable th6) {
                                    bArr7 = bArr;
                                    th = th6;
                                    this.ahI.fz().vR = -10;
                                    dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + th.getClass() + "|" + th.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e27) {
                                        }
                                    }
                                    we();
                                    this.ahI.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi = com.baidu.adp.lib.util.i.hi();
                                        if ((hi ? dVar.vD != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                                            long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().QY);
                                            } else if (com.baidu.adp.lib.util.i.hm()) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                                            } else {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                                            }
                                            e.getInstance().result(c, dVar.vD, z17, z, hi);
                                        }
                                    }
                                    this.ahG = 0;
                                    this.ahI.fz().vT = bArr7;
                                }
                            } else {
                                this.ahI.fz().vR = -11;
                                dVar.vA = this.mContext.getResources().getString(d.l.data_too_big);
                            }
                            dVar.vv = i2;
                            dVar.vx = i3 + 1;
                            dVar.vw = System.currentTimeMillis() - currentTimeMillis2;
                            if (execute.getFirstHeader("Error-Message") != null) {
                                Header firstHeader = execute.getFirstHeader("Error-Message");
                                if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                                    this.ahM = false;
                                } else {
                                    this.ahM = true;
                                }
                            }
                            z11 = (i2 <= 0 || !(this.ahI.fz().responseCode == 200 || this.ahI.fz().responseCode == 302)) ? z17 : true;
                            try {
                                if (ITrafficStatsNativeManager.kk() != null && dVar != null) {
                                    ITrafficStatsNativeManager.kk().c(TbConfig.TMP_PIC_DIR_NAME, dVar.vu, dVar.vv);
                                }
                                if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                                    eg(value);
                                    break;
                                }
                                break;
                            } catch (IllegalStateException e28) {
                                e = e28;
                                z17 = z11;
                                this.ahI.fz().vR = -19;
                                dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                }
                                we();
                                this.ahI.b(dVar);
                                if (str != null) {
                                }
                                hi7 = com.baidu.adp.lib.util.i.hi();
                                if (hi7 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis82 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi7) {
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z7, hi7);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e29) {
                                e = e29;
                                inputStream2 = inputStream;
                                z17 = z11;
                                this.ahI.fz().vR = -12;
                                dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream2 != null) {
                                }
                                we();
                                this.ahI.b(dVar);
                                if (str != null) {
                                }
                                hi6 = com.baidu.adp.lib.util.i.hi();
                                if (hi6 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi6) {
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z6, hi6);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e30) {
                                e = e30;
                                z17 = z11;
                                this.ahI.fz().vR = -19;
                                dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                we();
                                this.ahI.b(dVar);
                                if (str != null) {
                                }
                                hi4 = com.baidu.adp.lib.util.i.hi();
                                if (hi4 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis132 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi4) {
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z4, hi4);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e31) {
                                e = e31;
                                z17 = z11;
                                this.ahI.fz().vR = -18;
                                dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                we();
                                this.ahI.b(dVar);
                                if (str != null) {
                                }
                                hi3 = com.baidu.adp.lib.util.i.hi();
                                if (hi3 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis122 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi3) {
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z3, hi3);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketTimeoutException e32) {
                                e = e32;
                                z17 = z11;
                                this.ahI.fz().vR = -13;
                                dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                we();
                                this.ahI.b(dVar);
                                if (str != null) {
                                }
                                hi2 = com.baidu.adp.lib.util.i.hi();
                                if (hi2 ? dVar.vD != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi2) {
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z2, hi2);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th7) {
                                th = th7;
                                z17 = z11;
                                this.ahI.fz().vR = -10;
                                dVar.vA = "errorCode:" + String.valueOf(this.ahI.fz().vR) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                }
                                we();
                                this.ahI.b(dVar);
                                if (str != null) {
                                }
                                hi = com.baidu.adp.lib.util.i.hi();
                                if (hi ? dVar.vD != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis142 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi) {
                                    }
                                    e.getInstance().result(c, dVar.vD, z17, z, hi);
                                }
                                this.ahG = 0;
                                this.ahI.fz().vT = bArr7;
                            }
                        }
                    } else {
                        this.sa = false;
                    }
                }
                i2 = i4;
                while (!this.ahH) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.vC = -9;
                if (!this.ahH) {
                }
            }
        }
        we();
        this.ahI.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean hi13 = com.baidu.adp.lib.util.i.hi();
            if ((hi13 ? dVar.vD != null || z11 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gC(c) && z16) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (hi13) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().QY);
                } else if (com.baidu.adp.lib.util.i.hm()) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().Ra);
                } else {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().QZ);
                }
                e.getInstance().result(c, dVar.vD, z11, z12, hi13);
            }
        }
        this.ahG = 0;
        this.ahI.fz().vT = bArr7;
    }

    private void eg(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(ahP) && (System.currentTimeMillis() - ahR) - (1800000 * (ahQ / 3)) >= 0) {
            ahQ++;
            try {
                char[] charArray = TbadkCoreApplication.getInst().getCuid().toCharArray();
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
                final URL url = new URL(sb.toString());
                ahP = str;
                new Thread(new Runnable() { // from class: com.baidu.tbadk.core.util.a.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            BdLog.i("testcdn" + url.getHost());
                            InetAddress.getByName(url.getHost()).getHostAddress();
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean isGif() {
        return this.sa;
    }

    public boolean wf() {
        return this.ahM;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0006a
    public void cancel() {
        fp();
    }
}
