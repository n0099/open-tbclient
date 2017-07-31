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
    private static int agU;
    public static String ajc;
    private static HttpClient ajd;
    private static String aji;
    private static int ajj;
    private static long ajk;
    private HttpGet aiY;
    private final com.baidu.adp.lib.network.http.e ajb;
    public boolean ajg;
    private final Context mContext;
    private static volatile String aiW = null;
    private static volatile boolean aiX = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams aje = new BasicHttpParams();
    private boolean tI = false;
    private boolean ajf = false;
    private int ajh = 0;
    private int aiZ = 0;
    private volatile boolean aja = false;

    static {
        agU = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(aje, 5000);
        HttpConnectionParams.setSoTimeout(aje, 30000);
        HttpConnectionParams.setSocketBufferSize(aje, 1024);
        HttpConnectionParams.setTcpNoDelay(aje, true);
        HttpClientParams.setRedirecting(aje, true);
        ConnManagerParams.setMaxConnectionsPerRoute(aje, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(aje, 10000L);
        ConnManagerParams.setMaxTotalConnections(aje, 15);
        HttpProtocolParams.setUserAgent(aje, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ajd = new DefaultHttpClient(new ThreadSafeClientConnManager(aje, schemeRegistry), aje);
        ajd.setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            agU = 4194304;
        }
        aji = null;
        ajj = 0;
        ajk = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        wm();
        this.ajb = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void wm() {
        synchronized (f.class) {
            if (!aiX) {
                aiX = true;
                wn();
            }
        }
    }

    public static synchronized void wn() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    aiW = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void fA() {
        this.aja = true;
        this.ajb.fK().xs = true;
        wo();
    }

    private void wo() {
        try {
            if (this.aiY != null) {
                this.aiY.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().aiU) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.hr()) {
            this.ajg = false;
            try {
                if (com.baidu.adp.lib.util.i.ht()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ajc == null) {
                            ajc = com.baidu.adp.lib.util.i.hB();
                        }
                        if (ajc != null && ajc.length() > 0) {
                            this.ajg = true;
                            if (el(ajc) && com.baidu.adp.lib.util.i.hD()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ajc);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aiY = e.getInstance().httpGetFactory(sb.toString(), this.ajh, false);
                                    } else {
                                        this.aiY = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aiY = new HttpGet(sb.toString());
                                }
                                this.aiY.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aiY.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = aje.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    aje.setParameter("http.route.default-proxy", new HttpHost(ajc, com.baidu.adp.lib.util.i.hC()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ajc) || httpHost.getPort() != com.baidu.adp.lib.util.i.hC()) {
                                        aje.setParameter("http.route.default-proxy", new HttpHost(ajc, com.baidu.adp.lib.util.i.hC()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aiY = e.getInstance().httpGetFactory(str, this.ajh, false);
                                    } else {
                                        this.aiY = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aiY = new HttpGet(str);
                                }
                                if (aiW != null) {
                                    this.aiY.setHeader("Proxy-Authorization", aiW);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aiY.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.ht()) {
                            if (!this.ajg || this.aiY == null) {
                                this.aiY = e.getInstance().httpGetFactory(str, this.ajh, false);
                            }
                        } else {
                            this.aiY = e.getInstance().httpGetFactory(str, this.ajh, true);
                        }
                    } else {
                        this.aiY = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.aiY = new HttpGet(str);
                }
                this.aiY.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean el(String str) {
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
        boolean hs;
        boolean z;
        boolean hs2;
        boolean z2;
        boolean hs3;
        boolean z3;
        boolean hs4;
        boolean z4;
        boolean hs5;
        boolean z5;
        boolean hs6;
        boolean z6;
        boolean hs7;
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
            if (!e.getInstance().aiU) {
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
            if (this.aja || i3 >= i) {
                break;
            }
            this.ajh = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.ajb.a(dVar);
            dVar.xe = -1;
            InputStream inputStream2 = null;
            c = this.ajb.fJ().c(dVar);
            try {
                dVar.xe = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    l(c, null, null);
                    if (z16) {
                        dVar.xf = e.getInstance().getCachedCdnIp(this.ajh);
                    }
                } else {
                    l(c, str, str2);
                    dVar.xf = str;
                }
                dVar.xe = -3;
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
            if (this.aiY == null) {
                throw new SocketException("network not available.");
            }
            if (this.aja) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                wo();
                this.ajb.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean hs8 = com.baidu.adp.lib.util.i.hs();
                    if ((hs8 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (hs8) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                        } else if (com.baidu.adp.lib.util.i.hw()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                        }
                        e.getInstance().result(c, dVar.xf, z17, z8, hs8);
                    }
                }
            } else {
                dVar.xe = -8;
                HttpResponse execute = ajd.execute(this.aiY);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ajb.fK().responseCode = execute.getStatusLine().getStatusCode();
                dVar.xd = this.ajb.fK().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.xh = headers[0].getValue();
                            dVar.xi = headers[1].getValue();
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
                    this.ajb.fK().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.aiZ < 1) {
                            wo();
                            this.aiZ++;
                            this.ajb.fK().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            wo();
                            this.ajb.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hs9 = com.baidu.adp.lib.util.i.hs();
                                if ((hs9 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hs9) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                    } else if (com.baidu.adp.lib.util.i.hw()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z14, hs9);
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
                            wo();
                            this.ajb.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hs10 = com.baidu.adp.lib.util.i.hs();
                                if ((hs10 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hs10) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                    } else if (com.baidu.adp.lib.util.i.hw()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z13, hs10);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > agU) {
                    this.ajb.fK().xt = -11;
                    dVar.xc = this.mContext.getResources().getString(d.l.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    wo();
                    this.ajb.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean hs11 = com.baidu.adp.lib.util.i.hs();
                        if ((hs11 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (hs11) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                            } else if (com.baidu.adp.lib.util.i.hw()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                            }
                            e.getInstance().result(c, dVar.xf, z17, z9, hs11);
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
                        this.tI = true;
                        i2 = i4;
                        while (!this.aja && i2 < agU && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.xe = -9;
                        if (!this.aja) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            wo();
                            this.ajb.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean hs12 = com.baidu.adp.lib.util.i.hs();
                                if ((hs12 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                    long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                                    if (hs12) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                    } else if (com.baidu.adp.lib.util.i.hw()) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                    } else {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z10, hs12);
                                }
                            }
                        } else {
                            if (i2 < agU) {
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
                                    this.ajb.fK().xt = -19;
                                    dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e17) {
                                        }
                                    }
                                    wo();
                                    this.ajb.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hs7 = com.baidu.adp.lib.util.i.hs();
                                        if ((hs7 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hs7) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                            } else if (com.baidu.adp.lib.util.i.hw()) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            } else {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            }
                                            e.getInstance().result(c, dVar.xf, z17, z7, hs7);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (SocketException e18) {
                                    bArr7 = bArr5;
                                    e = e18;
                                    inputStream2 = inputStream;
                                    try {
                                        this.ajb.fK().xt = -12;
                                        dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage();
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e19) {
                                            }
                                        }
                                        wo();
                                        this.ajb.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            hs6 = com.baidu.adp.lib.util.i.hs();
                                            if ((hs6 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!hs6) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                                } else if (com.baidu.adp.lib.util.i.hw()) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                                } else {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                                }
                                                e.getInstance().result(c, dVar.xf, z17, z6, hs6);
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
                                        wo();
                                        this.ajb.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            hs5 = com.baidu.adp.lib.util.i.hs();
                                            if ((hs5 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!hs5) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                                } else if (com.baidu.adp.lib.util.i.hw()) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                                } else {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                                }
                                                e.getInstance().result(c, dVar.xf, z17, z5, hs5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e21) {
                                    bArr7 = bArr4;
                                    e = e21;
                                    this.ajb.fK().xt = -13;
                                    dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e22) {
                                        }
                                    }
                                    wo();
                                    this.ajb.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hs2 = com.baidu.adp.lib.util.i.hs();
                                        if ((hs2 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                            long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hs2) {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                            } else if (com.baidu.adp.lib.util.i.hw()) {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            } else {
                                                z2 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            }
                                            e.getInstance().result(c, dVar.xf, z17, z2, hs2);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (HttpException e23) {
                                    bArr7 = bArr3;
                                    e = e23;
                                    this.ajb.fK().xt = -18;
                                    dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e24) {
                                        }
                                    }
                                    wo();
                                    this.ajb.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hs3 = com.baidu.adp.lib.util.i.hs();
                                        if ((hs3 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                            long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hs3) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                            } else if (com.baidu.adp.lib.util.i.hw()) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            } else {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            }
                                            e.getInstance().result(c, dVar.xf, z17, z3, hs3);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (IOException e25) {
                                    bArr7 = bArr2;
                                    e = e25;
                                    this.ajb.fK().xt = -19;
                                    dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e26) {
                                        }
                                    }
                                    wo();
                                    this.ajb.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hs4 = com.baidu.adp.lib.util.i.hs();
                                        if ((hs4 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                            long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hs4) {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                            } else if (com.baidu.adp.lib.util.i.hw()) {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            } else {
                                                z4 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            }
                                            e.getInstance().result(c, dVar.xf, z17, z4, hs4);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (Throwable th6) {
                                    bArr7 = bArr;
                                    th = th6;
                                    this.ajb.fK().xt = -10;
                                    dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + th.getClass() + "|" + th.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e27) {
                                        }
                                    }
                                    wo();
                                    this.ajb.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        hs = com.baidu.adp.lib.util.i.hs();
                                        if ((hs ? dVar.xf != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                                            long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!hs) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                                            } else if (com.baidu.adp.lib.util.i.hw()) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                                            } else {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                                            }
                                            e.getInstance().result(c, dVar.xf, z17, z, hs);
                                        }
                                    }
                                    this.aiZ = 0;
                                    this.ajb.fK().xv = bArr7;
                                }
                            } else {
                                this.ajb.fK().xt = -11;
                                dVar.xc = this.mContext.getResources().getString(d.l.data_too_big);
                            }
                            dVar.wY = i2;
                            dVar.retry = i3 + 1;
                            dVar.wZ = System.currentTimeMillis() - currentTimeMillis2;
                            if (execute.getFirstHeader("Error-Message") != null) {
                                Header firstHeader = execute.getFirstHeader("Error-Message");
                                if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                                    this.ajf = false;
                                } else {
                                    this.ajf = true;
                                }
                            }
                            z11 = (i2 <= 0 || !(this.ajb.fK().responseCode == 200 || this.ajb.fK().responseCode == 302)) ? z17 : true;
                            try {
                                if (ITrafficStatsNativeManager.ku() != null && dVar != null) {
                                    ITrafficStatsNativeManager.ku().c(TbConfig.TMP_PIC_DIR_NAME, dVar.wX, dVar.wY);
                                }
                                if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                                    em(value);
                                    break;
                                }
                                break;
                            } catch (IllegalStateException e28) {
                                e = e28;
                                z17 = z11;
                                this.ajb.fK().xt = -19;
                                dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                }
                                wo();
                                this.ajb.b(dVar);
                                if (str != null) {
                                }
                                hs7 = com.baidu.adp.lib.util.i.hs();
                                if (hs7 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis82 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hs7) {
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z7, hs7);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e29) {
                                e = e29;
                                inputStream2 = inputStream;
                                z17 = z11;
                                this.ajb.fK().xt = -12;
                                dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream2 != null) {
                                }
                                wo();
                                this.ajb.b(dVar);
                                if (str != null) {
                                }
                                hs6 = com.baidu.adp.lib.util.i.hs();
                                if (hs6 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hs6) {
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z6, hs6);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e30) {
                                e = e30;
                                z17 = z11;
                                this.ajb.fK().xt = -19;
                                dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                wo();
                                this.ajb.b(dVar);
                                if (str != null) {
                                }
                                hs4 = com.baidu.adp.lib.util.i.hs();
                                if (hs4 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis132 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hs4) {
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z4, hs4);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e31) {
                                e = e31;
                                z17 = z11;
                                this.ajb.fK().xt = -18;
                                dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                wo();
                                this.ajb.b(dVar);
                                if (str != null) {
                                }
                                hs3 = com.baidu.adp.lib.util.i.hs();
                                if (hs3 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis122 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hs3) {
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z3, hs3);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketTimeoutException e32) {
                                e = e32;
                                z17 = z11;
                                this.ajb.fK().xt = -13;
                                dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                wo();
                                this.ajb.b(dVar);
                                if (str != null) {
                                }
                                hs2 = com.baidu.adp.lib.util.i.hs();
                                if (hs2 ? dVar.xf != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hs2) {
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z2, hs2);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th7) {
                                th = th7;
                                z17 = z11;
                                this.ajb.fK().xt = -10;
                                dVar.xc = "errorCode:" + String.valueOf(this.ajb.fK().xt) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                }
                                wo();
                                this.ajb.b(dVar);
                                if (str != null) {
                                }
                                hs = com.baidu.adp.lib.util.i.hs();
                                if (hs ? dVar.xf != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis142 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!hs) {
                                    }
                                    e.getInstance().result(c, dVar.xf, z17, z, hs);
                                }
                                this.aiZ = 0;
                                this.ajb.fK().xv = bArr7;
                            }
                        }
                    } else {
                        this.tI = false;
                    }
                }
                i2 = i4;
                while (!this.aja) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.xe = -9;
                if (!this.aja) {
                }
            }
        }
        wo();
        this.ajb.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean hs13 = com.baidu.adp.lib.util.i.hs();
            if ((hs13 ? dVar.xf != null || z11 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gH(c) && z16) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (hs13) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().Sw);
                } else if (com.baidu.adp.lib.util.i.hw()) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().Sy);
                } else {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().Sx);
                }
                e.getInstance().result(c, dVar.xf, z11, z12, hs13);
            }
        }
        this.aiZ = 0;
        this.ajb.fK().xv = bArr7;
    }

    private void em(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(aji) && (System.currentTimeMillis() - ajk) - (1800000 * (ajj / 3)) >= 0) {
            ajj++;
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
                aji = str;
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
        return this.tI;
    }

    public boolean wp() {
        return this.ajf;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0006a
    public void cancel() {
        fA();
    }
}
