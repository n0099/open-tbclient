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
public class f implements a.InterfaceC0005a {
    private static int agp;
    private static String aiE;
    private static int aiF;
    private static long aiG;
    public static String aiy;
    private static HttpClient aiz;
    public boolean aiC;
    private HttpGet aiu;
    private final com.baidu.adp.lib.network.http.e aix;
    private final Context mContext;
    private static volatile String ais = null;
    private static volatile boolean ait = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams aiA = new BasicHttpParams();
    private boolean rw = false;
    private boolean aiB = false;
    private int aiD = 0;
    private int aiv = 0;
    private volatile boolean aiw = false;

    static {
        agp = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(aiA, 5000);
        HttpConnectionParams.setSoTimeout(aiA, 30000);
        HttpConnectionParams.setSocketBufferSize(aiA, 1024);
        HttpConnectionParams.setTcpNoDelay(aiA, true);
        HttpClientParams.setRedirecting(aiA, true);
        ConnManagerParams.setMaxConnectionsPerRoute(aiA, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(aiA, 10000L);
        ConnManagerParams.setMaxTotalConnections(aiA, 15);
        HttpProtocolParams.setUserAgent(aiA, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        aiz = new DefaultHttpClient(new ThreadSafeClientConnManager(aiA, schemeRegistry), aiA);
        aiz.setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            agp = 4194304;
        }
        aiE = null;
        aiF = 0;
        aiG = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        wk();
        this.aix = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void wk() {
        synchronized (f.class) {
            if (!ait) {
                ait = true;
                wl();
            }
        }
    }

    public static synchronized void wl() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    ais = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void fp() {
        this.aiw = true;
        this.aix.fA().vl = true;
        wm();
    }

    private void wm() {
        try {
            if (this.aiu != null) {
                this.aiu.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().aiq) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.hi()) {
            this.aiC = false;
            try {
                if (com.baidu.adp.lib.util.i.hk()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (aiy == null) {
                            aiy = com.baidu.adp.lib.util.i.hs();
                        }
                        if (aiy != null && aiy.length() > 0) {
                            this.aiC = true;
                            if (eh(aiy) && com.baidu.adp.lib.util.i.hu()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(aiy);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aiu = e.getInstance().httpGetFactory(sb.toString(), this.aiD, false);
                                    } else {
                                        this.aiu = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aiu = new HttpGet(sb.toString());
                                }
                                this.aiu.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aiu.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = aiA.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    aiA.setParameter("http.route.default-proxy", new HttpHost(aiy, com.baidu.adp.lib.util.i.ht()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(aiy) || httpHost.getPort() != com.baidu.adp.lib.util.i.ht()) {
                                        aiA.setParameter("http.route.default-proxy", new HttpHost(aiy, com.baidu.adp.lib.util.i.ht()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aiu = e.getInstance().httpGetFactory(str, this.aiD, false);
                                    } else {
                                        this.aiu = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aiu = new HttpGet(str);
                                }
                                if (ais != null) {
                                    this.aiu.setHeader("Proxy-Authorization", ais);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aiu.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.hk()) {
                            if (!this.aiC || this.aiu == null) {
                                this.aiu = e.getInstance().httpGetFactory(str, this.aiD, false);
                            }
                        } else {
                            this.aiu = e.getInstance().httpGetFactory(str, this.aiD, true);
                        }
                    } else {
                        this.aiu = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.aiu = new HttpGet(str);
                }
                this.aiu.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean eh(String str) {
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
        boolean hj;
        boolean z;
        boolean hj2;
        boolean z2;
        boolean hj3;
        boolean z3;
        boolean hj4;
        boolean z4;
        boolean hj5;
        boolean z5;
        boolean hj6;
        boolean z6;
        boolean hj7;
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
            if (!e.getInstance().aiq) {
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
            if (this.aiw || i3 >= i) {
                break;
            }
            this.aiD = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.aix.a(dVar);
            dVar.uX = -1;
            InputStream inputStream2 = null;
            c = this.aix.fz().c(dVar);
            try {
                dVar.uX = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    l(c, null, null);
                    if (z16) {
                        dVar.uY = e.getInstance().getCachedCdnIp(this.aiD);
                    }
                } else {
                    l(c, str, str2);
                    dVar.uY = str;
                }
                dVar.uX = -3;
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
            if (this.aiu == null) {
                throw new SocketException("network not available.");
            }
            if (this.aiw) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                wm();
                this.aix.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean hj8 = com.baidu.adp.lib.util.i.hj();
                    if ((hj8 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (hj8) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RA);
                        } else if (com.baidu.adp.lib.util.i.hn()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RC);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().RB);
                        }
                        e.getInstance().result(c, dVar.uY, z17, z8, hj8);
                    }
                }
            } else {
                dVar.uX = -8;
                HttpResponse execute = aiz.execute(this.aiu);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.aix.fA().responseCode = execute.getStatusLine().getStatusCode();
                dVar.uW = this.aix.fA().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.va = headers[0].getValue();
                            dVar.vb = headers[1].getValue();
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
                    this.aix.fA().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.aiv < 1) {
                            wm();
                            this.aiv++;
                            this.aix.fA().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            wm();
                            this.aix.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hj9 = com.baidu.adp.lib.util.i.hj();
                                if ((hj9 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hj9) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                    } else if (com.baidu.adp.lib.util.i.hn()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z14, hj9);
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
                            wm();
                            this.aix.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hj10 = com.baidu.adp.lib.util.i.hj();
                                if ((hj10 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hj10) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                    } else if (com.baidu.adp.lib.util.i.hn()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z13, hj10);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > agp) {
                    this.aix.fA().vm = -11;
                    dVar.uV = this.mContext.getResources().getString(d.l.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    wm();
                    this.aix.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hj11 = com.baidu.adp.lib.util.i.hj();
                        if ((hj11 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (hj11) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RA);
                            } else if (com.baidu.adp.lib.util.i.hn()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RC);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().RB);
                            }
                            e.getInstance().result(c, dVar.uY, z17, z9, hj11);
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
                        this.rw = true;
                        i2 = i4;
                        while (!this.aiw && i2 < agp && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.uX = -9;
                        if (!this.aiw) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            wm();
                            this.aix.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hj12 = com.baidu.adp.lib.util.i.hj();
                                if ((hj12 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                    long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hj12) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                    } else if (com.baidu.adp.lib.util.i.hn()) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                    } else {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z10, hj12);
                                }
                            }
                        } else {
                            if (i2 < agp) {
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
                                    this.aix.fA().vm = -19;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e17) {
                                        }
                                    }
                                    wm();
                                    this.aix.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hj7 = com.baidu.adp.lib.util.i.hj();
                                        if ((hj7 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hj7) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                            } else if (com.baidu.adp.lib.util.i.hn()) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                            } else {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z7, hj7);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (SocketException e18) {
                                    bArr7 = bArr5;
                                    e = e18;
                                    inputStream2 = inputStream;
                                    try {
                                        this.aix.fA().vm = -12;
                                        dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e19) {
                                            }
                                        }
                                        wm();
                                        this.aix.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            hj6 = com.baidu.adp.lib.util.i.hj();
                                            if ((hj6 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!hj6) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                                } else if (com.baidu.adp.lib.util.i.hn()) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                                } else {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                                }
                                                e.getInstance().result(c, dVar.uY, z17, z6, hj6);
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
                                        wm();
                                        this.aix.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            hj5 = com.baidu.adp.lib.util.i.hj();
                                            if ((hj5 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!hj5) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                                } else if (com.baidu.adp.lib.util.i.hn()) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                                } else {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                                }
                                                e.getInstance().result(c, dVar.uY, z17, z5, hj5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e21) {
                                    bArr7 = bArr4;
                                    e = e21;
                                    this.aix.fA().vm = -13;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e22) {
                                        }
                                    }
                                    wm();
                                    this.aix.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hj2 = com.baidu.adp.lib.util.i.hj();
                                        if ((hj2 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                            long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hj2) {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                            } else if (com.baidu.adp.lib.util.i.hn()) {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                            } else {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z2, hj2);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (HttpException e23) {
                                    bArr7 = bArr3;
                                    e = e23;
                                    this.aix.fA().vm = -18;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e24) {
                                        }
                                    }
                                    wm();
                                    this.aix.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hj3 = com.baidu.adp.lib.util.i.hj();
                                        if ((hj3 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                            long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hj3) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                            } else if (com.baidu.adp.lib.util.i.hn()) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                            } else {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z3, hj3);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (IOException e25) {
                                    bArr7 = bArr2;
                                    e = e25;
                                    this.aix.fA().vm = -19;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e26) {
                                        }
                                    }
                                    wm();
                                    this.aix.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hj4 = com.baidu.adp.lib.util.i.hj();
                                        if ((hj4 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                            long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hj4) {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                            } else if (com.baidu.adp.lib.util.i.hn()) {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                            } else {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z4, hj4);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (Throwable th6) {
                                    bArr7 = bArr;
                                    th = th6;
                                    this.aix.fA().vm = -10;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + th.getClass() + "|" + th.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e27) {
                                        }
                                    }
                                    wm();
                                    this.aix.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hj = com.baidu.adp.lib.util.i.hj();
                                        if ((hj ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                                            long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hj) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RA);
                                            } else if (com.baidu.adp.lib.util.i.hn()) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RC);
                                            } else {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().RB);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z, hj);
                                        }
                                    }
                                    this.aiv = 0;
                                    this.aix.fA().vo = bArr7;
                                }
                            } else {
                                this.aix.fA().vm = -11;
                                dVar.uV = this.mContext.getResources().getString(d.l.data_too_big);
                            }
                            dVar.uQ = i2;
                            dVar.uS = i3 + 1;
                            dVar.uR = System.currentTimeMillis() - currentTimeMillis2;
                            if (execute.getFirstHeader("Error-Message") != null) {
                                Header firstHeader = execute.getFirstHeader("Error-Message");
                                if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                                    this.aiB = false;
                                } else {
                                    this.aiB = true;
                                }
                            }
                            z11 = (i2 <= 0 || !(this.aix.fA().responseCode == 200 || this.aix.fA().responseCode == 302)) ? z17 : true;
                            try {
                                if (ITrafficStatsNativeManager.kl() != null && dVar != null) {
                                    ITrafficStatsNativeManager.kl().c(TbConfig.TMP_PIC_DIR_NAME, dVar.uP, dVar.uQ);
                                }
                                if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                                    ei(value);
                                    break;
                                }
                                break;
                            } catch (IllegalStateException e28) {
                                e = e28;
                                z17 = z11;
                                this.aix.fA().vm = -19;
                                dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                }
                                wm();
                                this.aix.b(dVar);
                                if (str != null) {
                                }
                                hj7 = com.baidu.adp.lib.util.i.hj();
                                if (hj7 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis82 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hj7) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z7, hj7);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e29) {
                                e = e29;
                                inputStream2 = inputStream;
                                z17 = z11;
                                this.aix.fA().vm = -12;
                                dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream2 != null) {
                                }
                                wm();
                                this.aix.b(dVar);
                                if (str != null) {
                                }
                                hj6 = com.baidu.adp.lib.util.i.hj();
                                if (hj6 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hj6) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z6, hj6);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e30) {
                                e = e30;
                                z17 = z11;
                                this.aix.fA().vm = -19;
                                dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                wm();
                                this.aix.b(dVar);
                                if (str != null) {
                                }
                                hj4 = com.baidu.adp.lib.util.i.hj();
                                if (hj4 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis132 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hj4) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z4, hj4);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e31) {
                                e = e31;
                                z17 = z11;
                                this.aix.fA().vm = -18;
                                dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                wm();
                                this.aix.b(dVar);
                                if (str != null) {
                                }
                                hj3 = com.baidu.adp.lib.util.i.hj();
                                if (hj3 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis122 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hj3) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z3, hj3);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketTimeoutException e32) {
                                e = e32;
                                z17 = z11;
                                this.aix.fA().vm = -13;
                                dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                wm();
                                this.aix.b(dVar);
                                if (str != null) {
                                }
                                hj2 = com.baidu.adp.lib.util.i.hj();
                                if (hj2 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hj2) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z2, hj2);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th7) {
                                th = th7;
                                z17 = z11;
                                this.aix.fA().vm = -10;
                                dVar.uV = "errorCode:" + String.valueOf(this.aix.fA().vm) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                }
                                wm();
                                this.aix.b(dVar);
                                if (str != null) {
                                }
                                hj = com.baidu.adp.lib.util.i.hj();
                                if (hj ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis142 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hj) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z, hj);
                                }
                                this.aiv = 0;
                                this.aix.fA().vo = bArr7;
                            }
                        }
                    } else {
                        this.rw = false;
                    }
                }
                i2 = i4;
                while (!this.aiw) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.uX = -9;
                if (!this.aiw) {
                }
            }
        }
        wm();
        this.aix.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean hj13 = com.baidu.adp.lib.util.i.hj();
            if ((hj13 ? dVar.uY != null || z11 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gG(c) && z16) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (hj13) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().RA);
                } else if (com.baidu.adp.lib.util.i.hn()) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().RC);
                } else {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().RB);
                }
                e.getInstance().result(c, dVar.uY, z11, z12, hj13);
            }
        }
        this.aiv = 0;
        this.aix.fA().vo = bArr7;
    }

    private void ei(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(aiE) && (System.currentTimeMillis() - aiG) - (1800000 * (aiF / 3)) >= 0) {
            aiF++;
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
                aiE = str;
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
        return this.rw;
    }

    public boolean wn() {
        return this.aiB;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        fp();
    }
}
