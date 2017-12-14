package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
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
    public static String aiB;
    private static HttpClient aiC;
    private static String aiH;
    private static int aiI;
    private static long aiJ;
    private final com.baidu.adp.lib.network.http.e aiA;
    public boolean aiF;
    private HttpGet aix;
    private final Context mContext;
    private static int agm = 5242880;
    private static volatile String aiv = null;
    private static volatile boolean aiw = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams aiD = new BasicHttpParams();
    private boolean mIsGif = false;
    private boolean aiE = false;
    private int aiG = 0;
    private int aiy = 0;
    private volatile boolean aiz = false;

    static {
        HttpConnectionParams.setConnectionTimeout(aiD, 5000);
        HttpConnectionParams.setSoTimeout(aiD, 30000);
        HttpConnectionParams.setSocketBufferSize(aiD, 1024);
        HttpConnectionParams.setTcpNoDelay(aiD, true);
        HttpClientParams.setRedirecting(aiD, true);
        ConnManagerParams.setMaxConnectionsPerRoute(aiD, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(aiD, 10000L);
        ConnManagerParams.setMaxTotalConnections(aiD, 15);
        HttpProtocolParams.setUserAgent(aiD, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        aiC = new DefaultHttpClient(new ThreadSafeClientConnManager(aiD, schemeRegistry), aiD);
        aiC.setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        aiH = null;
        aiI = 0;
        aiJ = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        vP();
        this.aiA = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void vP() {
        synchronized (f.class) {
            if (!aiw) {
                aiw = true;
                vQ();
            }
        }
    }

    public static synchronized void vQ() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    aiv = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void fo() {
        this.aiz = true;
        this.aiA.fz().vl = true;
        vR();
    }

    private void vR() {
        try {
            if (this.aix != null) {
                this.aix.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void m(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().ait) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.hh()) {
            this.aiF = false;
            try {
                if (j.hj()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (aiB == null) {
                            aiB = j.hr();
                        }
                        if (aiB != null && aiB.length() > 0) {
                            this.aiF = true;
                            if (eg(aiB) && j.ht()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(aiB);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aix = e.getInstance().httpGetFactory(sb.toString(), this.aiG, false);
                                    } else {
                                        this.aix = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aix = new HttpGet(sb.toString());
                                }
                                this.aix.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aix.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = aiD.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    aiD.setParameter("http.route.default-proxy", new HttpHost(aiB, j.hs()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(aiB) || httpHost.getPort() != j.hs()) {
                                        aiD.setParameter("http.route.default-proxy", new HttpHost(aiB, j.hs()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aix = e.getInstance().httpGetFactory(str, this.aiG, false);
                                    } else {
                                        this.aix = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aix = new HttpGet(str);
                                }
                                if (aiv != null) {
                                    this.aix.setHeader("Proxy-Authorization", aiv);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aix.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.hj()) {
                            if (!this.aiF || this.aix == null) {
                                this.aix = e.getInstance().httpGetFactory(str, this.aiG, false);
                            }
                        } else {
                            this.aix = e.getInstance().httpGetFactory(str, this.aiG, true);
                        }
                    } else {
                        this.aix = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.aix = new HttpGet(str);
                }
                this.aix.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean eg(String str) {
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
            if (!e.getInstance().ait) {
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
            if (this.aiz || i3 >= i) {
                break;
            }
            this.aiG = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.aiA.a(dVar);
            dVar.uX = -1;
            InputStream inputStream2 = null;
            c = this.aiA.fy().c(dVar);
            try {
                dVar.uX = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    m(c, null, null);
                    if (z16) {
                        dVar.uY = e.getInstance().getCachedCdnIp(this.aiG);
                    }
                } else {
                    m(c, str, str2);
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
            if (this.aix == null) {
                throw new SocketException("network not available.");
            }
            if (this.aiz) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                vR();
                this.aiA.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean hi8 = j.hi();
                    if ((hi8 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (hi8) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                        } else if (j.hm()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                        }
                        e.getInstance().result(c, dVar.uY, z17, z8, hi8);
                    }
                }
            } else {
                dVar.uX = -8;
                HttpResponse execute = aiC.execute(this.aix);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.aiA.fz().responseCode = execute.getStatusLine().getStatusCode();
                dVar.uW = this.aiA.fz().responseCode;
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
                    this.aiA.fz().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.aiy < 1) {
                            vR();
                            this.aiy++;
                            this.aiA.fz().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            vR();
                            this.aiA.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hi9 = j.hi();
                                if ((hi9 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hi9) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                    } else if (j.hm()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z14, hi9);
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
                            vR();
                            this.aiA.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hi10 = j.hi();
                                if ((hi10 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hi10) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                    } else if (j.hm()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z13, hi10);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > agm) {
                    this.aiA.fz().vm = -11;
                    dVar.uV = this.mContext.getResources().getString(d.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    vR();
                    this.aiA.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hi11 = j.hi();
                        if ((hi11 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (hi11) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                            } else if (j.hm()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                            }
                            e.getInstance().result(c, dVar.uY, z17, z9, hi11);
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
                        this.mIsGif = true;
                        i2 = i4;
                        while (!this.aiz && i2 < agm && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.uX = -9;
                        if (!this.aiz) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            vR();
                            this.aiA.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hi12 = j.hi();
                                if ((hi12 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                    long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hi12) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                    } else if (j.hm()) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                    } else {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z10, hi12);
                                }
                            }
                        } else {
                            if (i2 < agm) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    if (entity.getContentEncoding() != null) {
                                        String value2 = entity.getContentEncoding().getValue();
                                        if (value2 != null && value2.contains("gzip")) {
                                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream2);
                                            byteArray = byteArrayOutputStream2.toByteArray();
                                        }
                                        bArr7 = byteArray;
                                    } else {
                                        bArr7 = byteArray;
                                    }
                                } catch (IllegalStateException e16) {
                                    bArr7 = bArr6;
                                    e = e16;
                                    this.aiA.fz().vm = -19;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e17) {
                                        }
                                    }
                                    vR();
                                    this.aiA.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi7 = j.hi();
                                        if ((hi7 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi7) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            } else if (j.hm()) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                            } else {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z7, hi7);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (SocketException e18) {
                                    bArr7 = bArr5;
                                    e = e18;
                                    inputStream2 = inputStream;
                                    try {
                                        this.aiA.fz().vm = -12;
                                        dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e19) {
                                            }
                                        }
                                        vR();
                                        this.aiA.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            hi6 = j.hi();
                                            if ((hi6 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!hi6) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                                } else if (j.hm()) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                                } else {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                                }
                                                e.getInstance().result(c, dVar.uY, z17, z6, hi6);
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
                                        vR();
                                        this.aiA.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            hi5 = j.hi();
                                            if ((hi5 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!hi5) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                                } else if (j.hm()) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                                } else {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                                }
                                                e.getInstance().result(c, dVar.uY, z17, z5, hi5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e21) {
                                    bArr7 = bArr4;
                                    e = e21;
                                    this.aiA.fz().vm = -13;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e22) {
                                        }
                                    }
                                    vR();
                                    this.aiA.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi2 = j.hi();
                                        if ((hi2 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                            long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi2) {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            } else if (j.hm()) {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                            } else {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z2, hi2);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (HttpException e23) {
                                    bArr7 = bArr3;
                                    e = e23;
                                    this.aiA.fz().vm = -18;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e24) {
                                        }
                                    }
                                    vR();
                                    this.aiA.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi3 = j.hi();
                                        if ((hi3 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                            long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi3) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            } else if (j.hm()) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                            } else {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z3, hi3);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (IOException e25) {
                                    bArr7 = bArr2;
                                    e = e25;
                                    this.aiA.fz().vm = -19;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e26) {
                                        }
                                    }
                                    vR();
                                    this.aiA.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi4 = j.hi();
                                        if ((hi4 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                            long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi4) {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            } else if (j.hm()) {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                            } else {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z4, hi4);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (Throwable th6) {
                                    bArr7 = bArr;
                                    th = th6;
                                    this.aiA.fz().vm = -10;
                                    dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + th.getClass() + "|" + th.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e27) {
                                        }
                                    }
                                    vR();
                                    this.aiA.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hi = j.hi();
                                        if ((hi ? dVar.uY != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                                            long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hi) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            } else if (j.hm()) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                                            } else {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            }
                                            e.getInstance().result(c, dVar.uY, z17, z, hi);
                                        }
                                    }
                                    this.aiy = 0;
                                    this.aiA.fz().vo = bArr7;
                                }
                            } else {
                                this.aiA.fz().vm = -11;
                                dVar.uV = this.mContext.getResources().getString(d.j.data_too_big);
                            }
                            dVar.uQ = i2;
                            dVar.uS = i3 + 1;
                            dVar.uR = System.currentTimeMillis() - currentTimeMillis2;
                            if (execute.getFirstHeader("Error-Message") != null) {
                                Header firstHeader = execute.getFirstHeader("Error-Message");
                                if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                                    this.aiE = false;
                                } else {
                                    this.aiE = true;
                                }
                            }
                            z11 = (i2 <= 0 || !(this.aiA.fz().responseCode == 200 || this.aiA.fz().responseCode == 302)) ? z17 : true;
                            try {
                                if (ITrafficStatsNativeManager.kh() != null && dVar != null) {
                                    ITrafficStatsNativeManager.kh().c(TbConfig.TMP_PIC_DIR_NAME, dVar.uP, dVar.uQ);
                                }
                                if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                                    eh(value);
                                    break;
                                }
                                break;
                            } catch (IllegalStateException e28) {
                                e = e28;
                                z17 = z11;
                                this.aiA.fz().vm = -19;
                                dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                }
                                vR();
                                this.aiA.b(dVar);
                                if (str != null) {
                                }
                                hi7 = j.hi();
                                if (hi7 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis82 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi7) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z7, hi7);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e29) {
                                e = e29;
                                inputStream2 = inputStream;
                                z17 = z11;
                                this.aiA.fz().vm = -12;
                                dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream2 != null) {
                                }
                                vR();
                                this.aiA.b(dVar);
                                if (str != null) {
                                }
                                hi6 = j.hi();
                                if (hi6 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi6) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z6, hi6);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e30) {
                                e = e30;
                                z17 = z11;
                                this.aiA.fz().vm = -19;
                                dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                vR();
                                this.aiA.b(dVar);
                                if (str != null) {
                                }
                                hi4 = j.hi();
                                if (hi4 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis132 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi4) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z4, hi4);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e31) {
                                e = e31;
                                z17 = z11;
                                this.aiA.fz().vm = -18;
                                dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                vR();
                                this.aiA.b(dVar);
                                if (str != null) {
                                }
                                hi3 = j.hi();
                                if (hi3 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis122 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi3) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z3, hi3);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketTimeoutException e32) {
                                e = e32;
                                z17 = z11;
                                this.aiA.fz().vm = -13;
                                dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                vR();
                                this.aiA.b(dVar);
                                if (str != null) {
                                }
                                hi2 = j.hi();
                                if (hi2 ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi2) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z2, hi2);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th7) {
                                th = th7;
                                z17 = z11;
                                this.aiA.fz().vm = -10;
                                dVar.uV = "errorCode:" + String.valueOf(this.aiA.fz().vm) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                }
                                vR();
                                this.aiA.b(dVar);
                                if (str != null) {
                                }
                                hi = j.hi();
                                if (hi ? dVar.uY != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis142 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hi) {
                                    }
                                    e.getInstance().result(c, dVar.uY, z17, z, hi);
                                }
                                this.aiy = 0;
                                this.aiA.fz().vo = bArr7;
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.aiz) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.uX = -9;
                if (!this.aiz) {
                }
            }
        }
        vR();
        this.aiA.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean hi13 = j.hi();
            if ((hi13 ? dVar.uY != null || z11 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gM(c) && z16) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (hi13) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                } else if (j.hm()) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().Sz);
                } else {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                }
                e.getInstance().result(c, dVar.uY, z11, z12, hi13);
            }
        }
        this.aiy = 0;
        this.aiA.fz().vo = bArr7;
    }

    private void eh(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(aiH) && (System.currentTimeMillis() - aiJ) - (BdStatisticsManager.UPLOAD_TIMER_INTERVAL * (aiI / 3)) >= 0) {
            aiI++;
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
                aiH = str;
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
        return this.mIsGif;
    }

    public boolean vS() {
        return this.aiE;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        fo();
    }
}
