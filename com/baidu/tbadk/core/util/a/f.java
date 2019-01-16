package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
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
    public static String aEh;
    private static HttpClient aEi;
    private static String aEn;
    private static int aEo;
    private static long aEp;
    private HttpGet aEd;
    private final com.baidu.adp.lib.network.http.e aEg;
    public boolean aEl;
    private final Context mContext;
    private static int aBy = 5242880;
    private static volatile String aEb = null;
    private static volatile boolean aEc = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams aEj = new BasicHttpParams();
    private boolean mIsGif = false;
    private boolean aEk = false;
    private int aEm = 0;
    private int aEe = 0;
    private volatile boolean aEf = false;

    static {
        HttpConnectionParams.setConnectionTimeout(aEj, UIMsg.m_AppUI.MSG_APP_GPS);
        HttpConnectionParams.setSoTimeout(aEj, 30000);
        HttpConnectionParams.setSocketBufferSize(aEj, 1024);
        HttpConnectionParams.setTcpNoDelay(aEj, true);
        HttpClientParams.setRedirecting(aEj, true);
        ConnManagerParams.setMaxConnectionsPerRoute(aEj, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(aEj, ErrDef.Feature.WEIGHT);
        ConnManagerParams.setMaxTotalConnections(aEj, 15);
        HttpProtocolParams.setUserAgent(aEj, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        aEi = new DefaultHttpClient(new ThreadSafeClientConnManager(aEj, schemeRegistry), aEj);
        ((DefaultHttpClient) aEi).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        aEn = null;
        aEo = 0;
        aEp = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        Ez();
        this.aEg = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void Ez() {
        synchronized (f.class) {
            if (!aEc) {
                aEc = true;
                EA();
            }
        }
    }

    public static synchronized void EA() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    aEb = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void jg() {
        this.aEf = true;
        this.aEg.jq().Dd = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.aEd != null) {
                this.aEd.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void q(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().aDZ) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.kV()) {
            this.aEl = false;
            try {
                if (j.kX()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (aEh == null) {
                            aEh = j.le();
                        }
                        if (aEh != null && aEh.length() > 0) {
                            this.aEl = true;
                            if (gh(aEh) && j.lg()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(aEh);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aEd = e.getInstance().httpGetFactory(sb.toString(), this.aEm, false);
                                    } else {
                                        this.aEd = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aEd = new HttpGet(sb.toString());
                                }
                                this.aEd.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aEd.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = aEj.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    aEj.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(aEh, j.lf()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(aEh) || httpHost.getPort() != j.lf()) {
                                        aEj.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(aEh, j.lf()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.aEd = e.getInstance().httpGetFactory(str, this.aEm, false);
                                    } else {
                                        this.aEd = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.aEd = new HttpGet(str);
                                }
                                if (aEb != null) {
                                    this.aEd.setHeader(AUTH.PROXY_AUTH_RESP, aEb);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.aEd.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.kX()) {
                            if (!this.aEl || this.aEd == null) {
                                this.aEd = e.getInstance().httpGetFactory(str, this.aEm, false);
                            }
                        } else {
                            this.aEd = e.getInstance().httpGetFactory(str, this.aEm, true);
                        }
                    } else {
                        this.aEd = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.aEd = new HttpGet(str);
                }
                this.aEd.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean gh(String str) {
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
        r13.CG = r6;
        r13.CI = r10 + 1;
        r13.CH = java.lang.System.currentTimeMillis() - r16;
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
        r25.aEk = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x092c, code lost:
        if (r6 <= 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x093a, code lost:
        if (r25.aEg.jq().responseCode == 200) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0948, code lost:
        if (r25.aEg.jq().responseCode != 302) goto L211;
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
        gi(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x096c, code lost:
        if (r8 == null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x096e, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x09ec, code lost:
        r25.aEk = true;
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
        boolean kW;
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
            if (!e.getInstance().aDZ) {
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
            if (this.aEf || i3 >= i) {
                break;
            }
            this.aEm = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.aEg.a(dVar);
            dVar.CN = -1;
            InputStream inputStream2 = null;
            c = this.aEg.jp().c(dVar);
            try {
                dVar.CN = -2;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    q(c, null, null);
                    if (z15) {
                        dVar.CO = e.getInstance().getCachedCdnIp(this.aEm);
                    }
                } else {
                    q(c, str, str2);
                    dVar.CO = str;
                }
                dVar.CN = -3;
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
            if (this.aEd == null) {
                throw new SocketException("network not available.");
            }
            if (this.aEf) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                closeConnection();
                this.aEg.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean kW2 = j.kW();
                    if ((kW2 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (kW2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().anK);
                        } else if (j.la()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().anM);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().anL);
                        }
                        e.getInstance().result(c, dVar.CO, false, z8, kW2);
                    }
                }
            } else {
                dVar.CN = -8;
                HttpResponse execute = aEi.execute(this.aEd);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.aEg.jq().responseCode = execute.getStatusLine().getStatusCode();
                dVar.CM = this.aEg.jq().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.CQ = headers[0].getValue();
                            dVar.CT = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                        }
                        closeConnection();
                        this.aEg.b(dVar);
                        if (str != null) {
                        }
                        kW = j.kW();
                        if (kW ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) {
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                            if (!kW) {
                            }
                            e.getInstance().result(c, dVar.CO, false, z5, kW);
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
                    this.aEg.jq().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.aEe < 1) {
                            closeConnection();
                            this.aEe++;
                            this.aEg.jq().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            closeConnection();
                            this.aEg.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kW3 = j.kW();
                                if ((kW3 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kW3) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                    } else if (j.la()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                    }
                                    e.getInstance().result(c, dVar.CO, false, z13, kW3);
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
                            this.aEg.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kW4 = j.kW();
                                if ((kW4 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kW4) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                    } else if (j.la()) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                    } else {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                    }
                                    e.getInstance().result(c, dVar.CO, false, z12, kW4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aBy) {
                    this.aEg.jq().De = -11;
                    dVar.CL = this.mContext.getResources().getString(e.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    closeConnection();
                    this.aEg.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean kW5 = j.kW();
                        if ((kW5 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (kW5) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().anK);
                            } else if (j.la()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().anM);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().anL);
                            }
                            e.getInstance().result(c, dVar.CO, false, z9, kW5);
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
                        while (!this.aEf && i2 < aBy && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.CN = -9;
                        if (this.aEf) {
                            if (i2 >= aBy) {
                                this.aEg.jq().De = -11;
                                dVar.CL = this.mContext.getResources().getString(e.j.data_too_big);
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
                                this.aEg.jq().De = -19;
                                dVar.CL = "errorCode:" + String.valueOf(this.aEg.jq().De) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                closeConnection();
                                this.aEg.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kW6 = j.kW();
                                    if ((kW6 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kW6) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                        } else if (j.la()) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                        } else {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                        }
                                        e.getInstance().result(c, dVar.CO, false, z7, kW6);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e17) {
                                bArr7 = bArr5;
                                e = e17;
                                inputStream2 = inputStream;
                                try {
                                    this.aEg.jq().De = -12;
                                    dVar.CL = "errorCode:" + String.valueOf(this.aEg.jq().De) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    closeConnection();
                                    this.aEg.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean kW7 = j.kW();
                                        if ((kW7 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (kW7) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                            } else if (j.la()) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                            } else {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                            }
                                            e.getInstance().result(c, dVar.CO, false, z6, kW7);
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
                                    this.aEg.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        kW = j.kW();
                                        if ((kW ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                            long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!kW) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                            } else if (j.la()) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                            } else {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                            }
                                            e.getInstance().result(c, dVar.CO, false, z5, kW);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (SocketTimeoutException e20) {
                                bArr7 = bArr4;
                                e = e20;
                                this.aEg.jq().De = -13;
                                dVar.CL = "errorCode:" + String.valueOf(this.aEg.jq().De) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                closeConnection();
                                this.aEg.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kW8 = j.kW();
                                    if ((kW8 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kW8) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                        } else if (j.la()) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                        } else {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                        }
                                        e.getInstance().result(c, dVar.CO, false, z4, kW8);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e22) {
                                bArr7 = bArr3;
                                e = e22;
                                this.aEg.jq().De = -19;
                                dVar.CL = "errorCode:" + String.valueOf(this.aEg.jq().De) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                closeConnection();
                                this.aEg.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kW9 = j.kW();
                                    if ((kW9 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kW9) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                        } else if (j.la()) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                        } else {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                        }
                                        e.getInstance().result(c, dVar.CO, false, z3, kW9);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e24) {
                                bArr7 = bArr2;
                                e = e24;
                                this.aEg.jq().De = -18;
                                dVar.CL = "errorCode:" + String.valueOf(this.aEg.jq().De) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                closeConnection();
                                this.aEg.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kW10 = j.kW();
                                    if ((kW10 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kW10) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                        } else if (j.la()) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                        } else {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                        }
                                        e.getInstance().result(c, dVar.CO, false, z2, kW10);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th6) {
                                bArr7 = bArr;
                                th = th6;
                                this.aEg.jq().De = -10;
                                dVar.CL = "errorCode:" + String.valueOf(this.aEg.jq().De) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e26) {
                                    }
                                }
                                closeConnection();
                                this.aEg.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kW11 = j.kW();
                                    if ((kW11 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kW11) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                        } else if (j.la()) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                        } else {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                        }
                                        e.getInstance().result(c, dVar.CO, false, z, kW11);
                                    }
                                }
                                this.aEe = 0;
                                this.aEg.jq().Dg = bArr7;
                            }
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e27) {
                                }
                            }
                            closeConnection();
                            this.aEg.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kW12 = j.kW();
                                if ((kW12 ? (dVar.CO == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                                    long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kW12) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().anK);
                                    } else if (j.la()) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().anM);
                                    } else {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().anL);
                                    }
                                    e.getInstance().result(c, dVar.CO, false, z10, kW12);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.aEf) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.CN = -9;
                if (this.aEf) {
                }
            }
        }
        closeConnection();
        this.aEg.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean kW13 = j.kW();
            if ((kW13 ? dVar.CO != null || z16 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.i.iP(c) && z15) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (kW13) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().anK);
                } else if (j.la()) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().anM);
                } else {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().anL);
                }
                e.getInstance().result(c, dVar.CO, z16, z11, kW13);
            }
        }
        this.aEe = 0;
        this.aEg.jq().Dg = bArr7;
    }

    private void gi(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(aEn) && (System.currentTimeMillis() - aEp) - (1800000 * (aEo / 3)) >= 0) {
            aEo++;
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
                aEn = str;
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

    public boolean EB() {
        return this.aEk;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        jg();
    }
}
