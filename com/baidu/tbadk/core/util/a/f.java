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
import org.apache.http.auth.AUTH;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRoutePNames;
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
public class f implements a.InterfaceC0018a {
    public static String aWM;
    private static HttpClient aWN;
    private static String aWS;
    private static int aWT;
    private static long aWU;
    private HttpGet aWI;
    private final com.baidu.adp.lib.network.http.e aWL;
    public boolean aWQ;
    private final Context mContext;
    private static int aUy = 5242880;
    private static volatile String aWG = null;
    private static volatile boolean aWH = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams aWO = new BasicHttpParams();
    private boolean mIsGif = false;
    private boolean aWP = false;
    private int aWR = 0;
    private int aWJ = 0;
    private volatile boolean aWK = false;

    static {
        HttpConnectionParams.setConnectionTimeout(aWO, 5000);
        HttpConnectionParams.setSoTimeout(aWO, 30000);
        HttpConnectionParams.setSocketBufferSize(aWO, 1024);
        HttpConnectionParams.setTcpNoDelay(aWO, true);
        HttpClientParams.setRedirecting(aWO, true);
        ConnManagerParams.setMaxConnectionsPerRoute(aWO, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(aWO, 10000L);
        ConnManagerParams.setMaxTotalConnections(aWO, 15);
        HttpProtocolParams.setUserAgent(aWO, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        aWN = new DefaultHttpClient(new ThreadSafeClientConnManager(aWO, schemeRegistry), aWO);
        ((DefaultHttpClient) aWN).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        aWS = null;
        aWT = 0;
        aWU = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        Dg();
        this.aWL = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void Dg() {
        synchronized (f.class) {
            if (!aWH) {
                aWH = true;
                Dh();
            }
        }
    }

    public static synchronized void Dh() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    aWG = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void mR() {
        this.aWK = true;
        this.aWL.nb().ajz = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.aWI != null) {
                this.aWI.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void n(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().aWE) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.oI()) {
            this.aWQ = false;
            try {
                if (j.oK()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (aWM == null) {
                            aWM = j.oS();
                        }
                        if (aWM != null && aWM.length() > 0) {
                            this.aWQ = true;
                            if (en(aWM) && j.oU()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(aWM);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aWI = e.getInstance().httpGetFactory(sb.toString(), this.aWR, false);
                                    } else {
                                        this.aWI = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aWI = new HttpGet(sb.toString());
                                }
                                this.aWI.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aWI.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = aWO.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    aWO.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(aWM, j.oT()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(aWM) || httpHost.getPort() != j.oT()) {
                                        aWO.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(aWM, j.oT()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aWI = e.getInstance().httpGetFactory(str, this.aWR, false);
                                    } else {
                                        this.aWI = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aWI = new HttpGet(str);
                                }
                                if (aWG != null) {
                                    this.aWI.setHeader(AUTH.PROXY_AUTH_RESP, aWG);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aWI.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.oK()) {
                            if (!this.aWQ || this.aWI == null) {
                                this.aWI = e.getInstance().httpGetFactory(str, this.aWR, false);
                            }
                        } else {
                            this.aWI = e.getInstance().httpGetFactory(str, this.aWR, true);
                        }
                    } else {
                        this.aWI = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.aWI = new HttpGet(str);
                }
                this.aWI.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean en(String str) {
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
        boolean oJ;
        boolean z;
        boolean oJ2;
        boolean z2;
        boolean oJ3;
        boolean z3;
        boolean oJ4;
        boolean z4;
        boolean oJ5;
        boolean z5;
        boolean oJ6;
        boolean z6;
        boolean oJ7;
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
            if (!e.getInstance().aWE) {
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
            if (this.aWK || i3 >= i) {
                break;
            }
            this.aWR = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.aWL.a(dVar);
            dVar.ajl = -1;
            InputStream inputStream2 = null;
            c = this.aWL.na().c(dVar);
            try {
                dVar.ajl = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    n(c, null, null);
                    if (z16) {
                        dVar.ajm = e.getInstance().getCachedCdnIp(this.aWR);
                    }
                } else {
                    n(c, str, str2);
                    dVar.ajm = str;
                }
                dVar.ajl = -3;
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
            if (this.aWI == null) {
                throw new SocketException("network not available.");
            }
            if (this.aWK) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                closeConnection();
                this.aWL.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean oJ8 = j.oJ();
                    if ((oJ8 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (oJ8) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                        } else if (j.oN()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                        }
                        e.getInstance().result(c, dVar.ajm, z17, z8, oJ8);
                    }
                }
            } else {
                dVar.ajl = -8;
                HttpResponse execute = aWN.execute(this.aWI);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.aWL.nb().responseCode = execute.getStatusLine().getStatusCode();
                dVar.ajk = this.aWL.nb().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.ajo = headers[0].getValue();
                            dVar.ajp = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (SocketTimeoutException e7) {
                    e = e7;
                } catch (IOException e8) {
                    e = e8;
                } catch (IllegalStateException e9) {
                    e = e9;
                } catch (SocketException e10) {
                    e = e10;
                    inputStream2 = inputStream;
                } catch (HttpException e11) {
                    e = e11;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.aWL.nb().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.aWJ < 1) {
                            closeConnection();
                            this.aWJ++;
                            this.aWL.nb().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            closeConnection();
                            this.aWL.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean oJ9 = j.oJ();
                                if ((oJ9 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (oJ9) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                    } else if (j.oN()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z14, oJ9);
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
                            closeConnection();
                            this.aWL.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean oJ10 = j.oJ();
                                if ((oJ10 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (oJ10) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                    } else if (j.oN()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z13, oJ10);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aUy) {
                    this.aWL.nb().ajA = -11;
                    dVar.ajj = this.mContext.getResources().getString(d.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    closeConnection();
                    this.aWL.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean oJ11 = j.oJ();
                        if ((oJ11 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (oJ11) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                            } else if (j.oN()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                            }
                            e.getInstance().result(c, dVar.ajm, z17, z9, oJ11);
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
                        while (!this.aWK && i2 < aUy && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.ajl = -9;
                        if (!this.aWK) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            closeConnection();
                            this.aWL.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean oJ12 = j.oJ();
                                if ((oJ12 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                    long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                                    if (oJ12) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                    } else if (j.oN()) {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                    } else {
                                        z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z10, oJ12);
                                }
                            }
                        } else {
                            if (i2 < aUy) {
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
                                    this.aWL.nb().ajA = -19;
                                    dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e17) {
                                        }
                                    }
                                    closeConnection();
                                    this.aWL.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        oJ7 = j.oJ();
                                        if ((oJ7 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!oJ7) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                            } else if (j.oN()) {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                            } else {
                                                z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                            }
                                            e.getInstance().result(c, dVar.ajm, z17, z7, oJ7);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (SocketException e18) {
                                    bArr7 = bArr5;
                                    e = e18;
                                    inputStream2 = inputStream;
                                    try {
                                        this.aWL.nb().ajA = -12;
                                        dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage();
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e19) {
                                            }
                                        }
                                        closeConnection();
                                        this.aWL.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            oJ6 = j.oJ();
                                            if ((oJ6 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!oJ6) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                                } else if (j.oN()) {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                                } else {
                                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                                }
                                                e.getInstance().result(c, dVar.ajm, z17, z6, oJ6);
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
                                        closeConnection();
                                        this.aWL.b(dVar);
                                        if ((str != null || str.length() == 0) && c != null) {
                                            oJ5 = j.oJ();
                                            if ((oJ5 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                                if (!oJ5) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                                } else if (j.oN()) {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                                } else {
                                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                                }
                                                e.getInstance().result(c, dVar.ajm, z17, z5, oJ5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (SocketTimeoutException e21) {
                                    bArr7 = bArr4;
                                    e = e21;
                                    this.aWL.nb().ajA = -13;
                                    dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e22) {
                                        }
                                    }
                                    closeConnection();
                                    this.aWL.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        oJ4 = j.oJ();
                                        if ((oJ4 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                            long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!oJ4) {
                                                z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                            } else if (j.oN()) {
                                                z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                            } else {
                                                z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                            }
                                            e.getInstance().result(c, dVar.ajm, z17, z4, oJ4);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (IOException e23) {
                                    bArr7 = bArr3;
                                    e = e23;
                                    this.aWL.nb().ajA = -19;
                                    dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e24) {
                                        }
                                    }
                                    closeConnection();
                                    this.aWL.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        oJ3 = j.oJ();
                                        if ((oJ3 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                            long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!oJ3) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                            } else if (j.oN()) {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                            } else {
                                                z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                            }
                                            e.getInstance().result(c, dVar.ajm, z17, z3, oJ3);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (HttpException e25) {
                                    bArr7 = bArr2;
                                    e = e25;
                                    this.aWL.nb().ajA = -18;
                                    dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e26) {
                                        }
                                    }
                                    closeConnection();
                                    this.aWL.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        oJ2 = j.oJ();
                                        if ((oJ2 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                            long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!oJ2) {
                                                z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                            } else if (j.oN()) {
                                                z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                            } else {
                                                z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                            }
                                            e.getInstance().result(c, dVar.ajm, z17, z2, oJ2);
                                        }
                                    }
                                    i3++;
                                    bArr7 = bArr7;
                                } catch (Throwable th6) {
                                    bArr7 = bArr;
                                    th = th6;
                                    this.aWL.nb().ajA = -10;
                                    dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + th.getClass() + "|" + th.getMessage();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e27) {
                                        }
                                    }
                                    closeConnection();
                                    this.aWL.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        oJ = j.oJ();
                                        if ((oJ ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                                            long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!oJ) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                                            } else if (j.oN()) {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                                            } else {
                                                z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                                            }
                                            e.getInstance().result(c, dVar.ajm, z17, z, oJ);
                                        }
                                    }
                                    this.aWJ = 0;
                                    this.aWL.nb().ajC = bArr7;
                                }
                            } else {
                                this.aWL.nb().ajA = -11;
                                dVar.ajj = this.mContext.getResources().getString(d.j.data_too_big);
                            }
                            dVar.aje = i2;
                            dVar.ajg = i3 + 1;
                            dVar.ajf = System.currentTimeMillis() - currentTimeMillis2;
                            if (execute.getFirstHeader("Error-Message") != null) {
                                Header firstHeader = execute.getFirstHeader("Error-Message");
                                if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                                    this.aWP = false;
                                } else {
                                    this.aWP = true;
                                }
                            }
                            z11 = (i2 <= 0 || !(this.aWL.nb().responseCode == 200 || this.aWL.nb().responseCode == 302)) ? z17 : true;
                            try {
                                if (ITrafficStatsNativeManager.rG() != null && dVar != null) {
                                    ITrafficStatsNativeManager.rG().c(TbConfig.TMP_PIC_DIR_NAME, dVar.ajd, dVar.aje);
                                }
                                if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                                    eo(value);
                                    break;
                                }
                                break;
                            } catch (IllegalStateException e28) {
                                e = e28;
                                z17 = z11;
                                this.aWL.nb().ajA = -19;
                                dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                }
                                closeConnection();
                                this.aWL.b(dVar);
                                if (str != null) {
                                }
                                oJ7 = j.oJ();
                                if (oJ7 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis82 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!oJ7) {
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z7, oJ7);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e29) {
                                e = e29;
                                inputStream2 = inputStream;
                                z17 = z11;
                                this.aWL.nb().ajA = -12;
                                dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream2 != null) {
                                }
                                closeConnection();
                                this.aWL.b(dVar);
                                if (str != null) {
                                }
                                oJ6 = j.oJ();
                                if (oJ6 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!oJ6) {
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z6, oJ6);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketTimeoutException e30) {
                                e = e30;
                                z17 = z11;
                                this.aWL.nb().ajA = -13;
                                dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                closeConnection();
                                this.aWL.b(dVar);
                                if (str != null) {
                                }
                                oJ4 = j.oJ();
                                if (oJ4 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!oJ4) {
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z4, oJ4);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e31) {
                                e = e31;
                                z17 = z11;
                                this.aWL.nb().ajA = -19;
                                dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                closeConnection();
                                this.aWL.b(dVar);
                                if (str != null) {
                                }
                                oJ3 = j.oJ();
                                if (oJ3 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis122 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!oJ3) {
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z3, oJ3);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e32) {
                                e = e32;
                                z17 = z11;
                                this.aWL.nb().ajA = -18;
                                dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                }
                                closeConnection();
                                this.aWL.b(dVar);
                                if (str != null) {
                                }
                                oJ2 = j.oJ();
                                if (oJ2 ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis132 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!oJ2) {
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z2, oJ2);
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th7) {
                                th = th7;
                                z17 = z11;
                                this.aWL.nb().ajA = -10;
                                dVar.ajj = "errorCode:" + String.valueOf(this.aWL.nb().ajA) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                }
                                closeConnection();
                                this.aWL.b(dVar);
                                if (str != null) {
                                }
                                oJ = j.oJ();
                                if (oJ ? dVar.ajm != null || z17 || i3 >= i + (-1) : true) {
                                    long currentTimeMillis142 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!oJ) {
                                    }
                                    e.getInstance().result(c, dVar.ajm, z17, z, oJ);
                                }
                                this.aWJ = 0;
                                this.aWL.nb().ajC = bArr7;
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.aWK) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.ajl = -9;
                if (!this.aWK) {
                }
            }
        }
        closeConnection();
        this.aWL.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean oJ13 = j.oJ();
            if ((oJ13 ? dVar.ajm != null || z11 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gQ(c) && z16) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (oJ13) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().aHa);
                } else if (j.oN()) {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().aHc);
                } else {
                    z12 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().aHb);
                }
                e.getInstance().result(c, dVar.ajm, z11, z12, oJ13);
            }
        }
        this.aWJ = 0;
        this.aWL.nb().ajC = bArr7;
    }

    private void eo(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(aWS) && (System.currentTimeMillis() - aWU) - (BdStatisticsManager.UPLOAD_TIMER_INTERVAL * (aWT / 3)) >= 0) {
            aWT++;
            try {
                char[] charArray = TbadkCoreApplication.getInst().getCuid().toCharArray();
                StringBuilder sb = new StringBuilder();
                sb.append("http://");
                sb.append(str);
                for (int i2 = 0; i2 < charArray.length && i < 32; i2++) {
                    if (Character.isLetterOrDigit(charArray[i2])) {
                        sb.append(charArray[i2]);
                        i++;
                    }
                }
                sb.append(".tieba.galileo.baiduyundns.com");
                final URL url = new URL(sb.toString());
                aWS = str;
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

    public boolean Di() {
        return this.aWP;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        mR();
    }
}
