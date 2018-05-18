package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
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
public class f implements a.InterfaceC0007a {
    public static String ajR;
    private static HttpClient ajS;
    private static String ajX;
    private static int ajY;
    private static long ajZ;
    private HttpGet ajN;
    private final com.baidu.adp.lib.network.http.e ajQ;
    public boolean ajV;
    private final Context mContext;
    private static int ahq = 5242880;
    private static volatile String ajL = null;
    private static volatile boolean ajM = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ajT = new BasicHttpParams();
    private boolean mIsGif = false;
    private boolean ajU = false;
    private int ajW = 0;
    private int ajO = 0;
    private volatile boolean ajP = false;

    static {
        HttpConnectionParams.setConnectionTimeout(ajT, 5000);
        HttpConnectionParams.setSoTimeout(ajT, 30000);
        HttpConnectionParams.setSocketBufferSize(ajT, 1024);
        HttpConnectionParams.setTcpNoDelay(ajT, true);
        HttpClientParams.setRedirecting(ajT, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ajT, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ajT, 10000L);
        ConnManagerParams.setMaxTotalConnections(ajT, 15);
        HttpProtocolParams.setUserAgent(ajT, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ajS = new DefaultHttpClient(new ThreadSafeClientConnManager(ajT, schemeRegistry), ajT);
        ((DefaultHttpClient) ajS).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        ajX = null;
        ajY = 0;
        ajZ = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        wm();
        this.ajQ = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void wm() {
        synchronized (f.class) {
            if (!ajM) {
                ajM = true;
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
                    ajL = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void eW() {
        this.ajP = true;
        this.ajQ.ff().tV = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.ajN != null) {
                this.ajN.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void m(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().ajJ) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.gP()) {
            this.ajV = false;
            try {
                if (j.gR()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ajR == null) {
                            ajR = j.gZ();
                        }
                        if (ajR != null && ajR.length() > 0) {
                            this.ajV = true;
                            if (ev(ajR) && j.hb()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ajR);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ajN = e.getInstance().httpGetFactory(sb.toString(), this.ajW, false);
                                    } else {
                                        this.ajN = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ajN = new HttpGet(sb.toString());
                                }
                                this.ajN.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ajN.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ajT.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ajT.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(ajR, j.ha()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ajR) || httpHost.getPort() != j.ha()) {
                                        ajT.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(ajR, j.ha()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ajN = e.getInstance().httpGetFactory(str, this.ajW, false);
                                    } else {
                                        this.ajN = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ajN = new HttpGet(str);
                                }
                                if (ajL != null) {
                                    this.ajN.setHeader(AUTH.PROXY_AUTH_RESP, ajL);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ajN.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.gR()) {
                            if (!this.ajV || this.ajN == null) {
                                this.ajN = e.getInstance().httpGetFactory(str, this.ajW, false);
                            }
                        } else {
                            this.ajN = e.getInstance().httpGetFactory(str, this.ajW, true);
                        }
                    } else {
                        this.ajN = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.ajN = new HttpGet(str);
                }
                this.ajN.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean ev(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [627=13, 628=13, 632=13, 638=13, 639=13, 640=13, 641=13, 642=13, 643=26, 645=13, 646=13, 648=13, 651=13, 653=26, 654=13, 656=13, 659=13, 661=13, 666=6] */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x08e6, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x08ea, code lost:
        r13.tA = r6;
        r13.tC = r10 + 1;
        r13.tB = java.lang.System.currentTimeMillis() - r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x0903, code lost:
        if (r9.getFirstHeader("Error-Message") == null) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x0905, code lost:
        r4 = r9.getFirstHeader("Error-Message");
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x090c, code lost:
        if (r4 == null) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x0916, code lost:
        if (android.text.TextUtils.isEmpty(r4.getValue()) != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x0925, code lost:
        if (r4.getValue().equalsIgnoreCase("OK") == false) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x0927, code lost:
        r25.ajU = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x092c, code lost:
        if (r6 <= 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x093a, code lost:
        if (r25.ajQ.ff().responseCode == 200) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0948, code lost:
        if (r25.ajQ.ff().responseCode != 302) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x094a, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x0952, code lost:
        if (r9.getFirstHeader("ginfo") == null) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x0954, code lost:
        r4 = r9.getFirstHeader("ginfo").getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x095f, code lost:
        if (r4 == null) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0965, code lost:
        if (r4.length() <= 0) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0967, code lost:
        ew(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x096c, code lost:
        if (r8 == null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x096e, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x09ec, code lost:
        r25.ajU = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:452:0x08ab A[Catch: SocketException -> 0x0532, SocketTimeoutException -> 0x09e9, HttpException -> 0x09f3, all -> 0x0c30, Throwable -> 0x0cf3, IllegalStateException -> 0x0cff, IOException -> 0x0d07, TRY_ENTER, TryCatch #5 {all -> 0x0c30, blocks: (B:238:0x0500, B:240:0x0509, B:242:0x0512, B:244:0x0515, B:246:0x0529, B:247:0x0531, B:250:0x0536, B:252:0x053c, B:254:0x0558, B:256:0x055f, B:339:0x069d, B:341:0x06a8, B:383:0x0750, B:385:0x076a, B:387:0x0779, B:392:0x0786, B:394:0x07af, B:395:0x07bc, B:397:0x07c5, B:399:0x07db, B:400:0x07e1, B:402:0x07e7, B:404:0x07eb, B:406:0x07f7, B:409:0x080c, B:452:0x08ab, B:454:0x08af, B:455:0x08b3, B:457:0x08bc, B:459:0x08c6, B:461:0x08d1, B:464:0x08ea, B:466:0x0905, B:468:0x090e, B:470:0x0918, B:515:0x09ec, B:472:0x0927, B:474:0x092e, B:476:0x093c, B:479:0x094b, B:481:0x0954, B:483:0x0961, B:485:0x0967, B:605:0x0b51, B:209:0x0446, B:175:0x036c, B:141:0x02b0, B:61:0x0145, B:512:0x09c7, B:407:0x0805), top: B:743:0x0500 }] */
    /* JADX WARN: Removed duplicated region for block: B:657:0x0c52  */
    /* JADX WARN: Removed duplicated region for block: B:669:0x0c6f  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x0c90  */
    /* JADX WARN: Removed duplicated region for block: B:748:0x0c34 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:771:0x081a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String c;
        Throwable th;
        InputStream inputStream;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean gQ;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i2;
        boolean z10;
        boolean z11;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        int read;
        String obj;
        boolean z12;
        boolean z13;
        Header[] headers;
        byte[] bArr7 = null;
        boolean z14 = false;
        if (e.getInstance() != null) {
            z14 = true;
            if (!e.getInstance().ajJ) {
                e.getInstance().init();
            }
        }
        boolean z15 = z14;
        if (i <= 0) {
            i = 5;
        }
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (this.ajP || i3 >= i) {
                break;
            }
            this.ajW = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.ajQ.a(dVar);
            dVar.tH = -1;
            InputStream inputStream2 = null;
            c = this.ajQ.fe().c(dVar);
            try {
                dVar.tH = -2;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    m(c, null, null);
                    if (z15) {
                        dVar.tI = e.getInstance().getCachedCdnIp(this.ajW);
                    }
                } else {
                    m(c, str, str2);
                    dVar.tI = str;
                }
                dVar.tH = -3;
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
            if (this.ajN == null) {
                throw new SocketException("network not available.");
            }
            if (this.ajP) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                closeConnection();
                this.ajQ.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean gQ2 = j.gQ();
                    if ((gQ2 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (gQ2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().TB);
                        } else if (j.gU()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().TD);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().TC);
                        }
                        e.getInstance().result(c, dVar.tI, false, z8, gQ2);
                    }
                }
            } else {
                dVar.tH = -8;
                HttpResponse execute = ajS.execute(this.ajN);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ajQ.ff().responseCode = execute.getStatusLine().getStatusCode();
                dVar.tG = this.ajQ.ff().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.tK = headers[0].getValue();
                            dVar.tL = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                        }
                        closeConnection();
                        this.ajQ.b(dVar);
                        if (str != null) {
                        }
                        gQ = j.gQ();
                        if (gQ ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) {
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                            if (!gQ) {
                            }
                            e.getInstance().result(c, dVar.tI, false, z5, gQ);
                        }
                        throw th;
                    }
                } catch (SocketException e7) {
                    e = e7;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e8) {
                    e = e8;
                } catch (IOException e9) {
                    e = e9;
                } catch (IllegalStateException e10) {
                    e = e10;
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
                    this.ajQ.ff().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.ajO < 1) {
                            closeConnection();
                            this.ajO++;
                            this.ajQ.ff().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            closeConnection();
                            this.ajQ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gQ3 = j.gQ();
                                if ((gQ3 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gQ3) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                    } else if (j.gU()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                    }
                                    e.getInstance().result(c, dVar.tI, false, z13, gQ3);
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
                            this.ajQ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gQ4 = j.gQ();
                                if ((gQ4 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gQ4) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                    } else if (j.gU()) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                    } else {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                    }
                                    e.getInstance().result(c, dVar.tI, false, z12, gQ4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > ahq) {
                    this.ajQ.ff().tW = -11;
                    dVar.tF = this.mContext.getResources().getString(d.k.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    closeConnection();
                    this.ajQ.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean gQ5 = j.gQ();
                        if ((gQ5 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (gQ5) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().TB);
                            } else if (j.gU()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().TD);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().TC);
                            }
                            e.getInstance().result(c, dVar.tI, false, z9, gQ5);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr8 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i4 = 0;
                boolean z17 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z17 = true;
                }
                if (z17) {
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
                        while (!this.ajP && i2 < ahq && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.tH = -9;
                        if (this.ajP) {
                            if (i2 >= ahq) {
                                this.ajQ.ff().tW = -11;
                                dVar.tF = this.mContext.getResources().getString(d.k.data_too_big);
                                break;
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                if (entity.getContentEncoding() == null) {
                                    bArr7 = byteArray;
                                    break;
                                }
                                String value = entity.getContentEncoding().getValue();
                                if (value == null || !value.contains("gzip")) {
                                    break;
                                }
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream2);
                                byteArray = byteArrayOutputStream2.toByteArray();
                                break;
                            } catch (IllegalStateException e15) {
                                bArr7 = bArr6;
                                e = e15;
                                this.ajQ.ff().tW = -19;
                                dVar.tF = "errorCode:" + String.valueOf(this.ajQ.ff().tW) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                closeConnection();
                                this.ajQ.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean gQ6 = j.gQ();
                                    if ((gQ6 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                        if (gQ6) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                        } else if (j.gU()) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                        } else {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                        }
                                        e.getInstance().result(c, dVar.tI, false, z7, gQ6);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e17) {
                                bArr7 = bArr5;
                                e = e17;
                                inputStream2 = inputStream;
                                try {
                                    this.ajQ.ff().tW = -12;
                                    dVar.tF = "errorCode:" + String.valueOf(this.ajQ.ff().tW) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    closeConnection();
                                    this.ajQ.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean gQ7 = j.gQ();
                                        if ((gQ7 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (gQ7) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                            } else if (j.gU()) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                            } else {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                            }
                                            e.getInstance().result(c, dVar.tI, false, z6, gQ7);
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
                                        } catch (Exception e19) {
                                        }
                                    }
                                    closeConnection();
                                    this.ajQ.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        gQ = j.gQ();
                                        if ((gQ ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                            long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!gQ) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                            } else if (j.gU()) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                            } else {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                            }
                                            e.getInstance().result(c, dVar.tI, false, z5, gQ);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (SocketTimeoutException e20) {
                                bArr7 = bArr4;
                                e = e20;
                                this.ajQ.ff().tW = -13;
                                dVar.tF = "errorCode:" + String.valueOf(this.ajQ.ff().tW) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                closeConnection();
                                this.ajQ.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean gQ8 = j.gQ();
                                    if ((gQ8 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (gQ8) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                        } else if (j.gU()) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                        } else {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                        }
                                        e.getInstance().result(c, dVar.tI, false, z4, gQ8);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e22) {
                                bArr7 = bArr3;
                                e = e22;
                                this.ajQ.ff().tW = -19;
                                dVar.tF = "errorCode:" + String.valueOf(this.ajQ.ff().tW) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                closeConnection();
                                this.ajQ.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean gQ9 = j.gQ();
                                    if ((gQ9 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (gQ9) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                        } else if (j.gU()) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                        } else {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                        }
                                        e.getInstance().result(c, dVar.tI, false, z3, gQ9);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e24) {
                                bArr7 = bArr2;
                                e = e24;
                                this.ajQ.ff().tW = -18;
                                dVar.tF = "errorCode:" + String.valueOf(this.ajQ.ff().tW) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                closeConnection();
                                this.ajQ.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean gQ10 = j.gQ();
                                    if ((gQ10 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (gQ10) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                        } else if (j.gU()) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                        } else {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                        }
                                        e.getInstance().result(c, dVar.tI, false, z2, gQ10);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th6) {
                                bArr7 = bArr;
                                th = th6;
                                this.ajQ.ff().tW = -10;
                                dVar.tF = "errorCode:" + String.valueOf(this.ajQ.ff().tW) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e26) {
                                    }
                                }
                                closeConnection();
                                this.ajQ.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean gQ11 = j.gQ();
                                    if ((gQ11 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (gQ11) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                        } else if (j.gU()) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                        } else {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                        }
                                        e.getInstance().result(c, dVar.tI, false, z, gQ11);
                                    }
                                }
                                this.ajO = 0;
                                this.ajQ.ff().tY = bArr7;
                            }
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e27) {
                                }
                            }
                            closeConnection();
                            this.ajQ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean gQ12 = j.gQ();
                                if ((gQ12 ? (dVar.tI == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                                    long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                    if (gQ12) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().TB);
                                    } else if (j.gU()) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().TD);
                                    } else {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().TC);
                                    }
                                    e.getInstance().result(c, dVar.tI, false, z10, gQ12);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.ajP) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.tH = -9;
                if (this.ajP) {
                }
            }
        }
        closeConnection();
        this.ajQ.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean gQ13 = j.gQ();
            if ((gQ13 ? dVar.tI != null || z16 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.gZ(c) && z15) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (gQ13) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().TB);
                } else if (j.gU()) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().TD);
                } else {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().TC);
                }
                e.getInstance().result(c, dVar.tI, z16, z11, gQ13);
            }
        }
        this.ajO = 0;
        this.ajQ.ff().tY = bArr7;
    }

    private void ew(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(ajX) && (System.currentTimeMillis() - ajZ) - (1800000 * (ajY / 3)) >= 0) {
            ajY++;
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
                ajX = str;
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

    public boolean wo() {
        return this.ajU;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0007a
    public void cancel() {
        eW();
    }
}
