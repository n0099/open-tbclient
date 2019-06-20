package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
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
public class f implements a.InterfaceC0016a {
    public static String bTS;
    private static HttpClient bTT;
    private static String bTY;
    private static int bTZ;
    private static long bUa;
    private HttpGet bTO;
    private final com.baidu.adp.lib.network.http.e bTR;
    public boolean bTW;
    private final Context mContext;
    private static int bRj = 5242880;
    private static volatile String bTM = null;
    private static volatile boolean bTN = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams bTU = new BasicHttpParams();
    private boolean mIsGif = false;
    private boolean bTV = false;
    private int bTX = 0;
    private int bTP = 0;
    private volatile boolean bTQ = false;

    static {
        HttpConnectionParams.setConnectionTimeout(bTU, UIMsg.m_AppUI.MSG_APP_GPS);
        HttpConnectionParams.setSoTimeout(bTU, 30000);
        HttpConnectionParams.setSocketBufferSize(bTU, 1024);
        HttpConnectionParams.setTcpNoDelay(bTU, true);
        HttpClientParams.setRedirecting(bTU, true);
        ConnManagerParams.setMaxConnectionsPerRoute(bTU, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(bTU, 10000L);
        ConnManagerParams.setMaxTotalConnections(bTU, 15);
        HttpProtocolParams.setUserAgent(bTU, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        bTT = new DefaultHttpClient(new ThreadSafeClientConnManager(bTU, schemeRegistry), bTU);
        ((DefaultHttpClient) bTT).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        bTY = null;
        bTZ = 0;
        bUa = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        aiG();
        this.bTR = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void aiG() {
        synchronized (f.class) {
            if (!bTN) {
                bTN = true;
                aiH();
            }
        }
    }

    public static synchronized void aiH() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    bTM = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void ia() {
        this.bTQ = true;
        this.bTR.il().AJ = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.bTO != null) {
                this.bTO.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void F(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().bTK) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.jS()) {
            this.bTW = false;
            try {
                if (j.jU()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (bTS == null) {
                            bTS = j.kb();
                        }
                        if (bTS != null && bTS.length() > 0) {
                            this.bTW = true;
                            if (ob(bTS) && j.kd()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(bTS);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.bTO = e.getInstance().httpGetFactory(sb.toString(), this.bTX, false);
                                    } else {
                                        this.bTO = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.bTO = new HttpGet(sb.toString());
                                }
                                this.bTO.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.bTO.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = bTU.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    bTU.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(bTS, j.kc()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(bTS) || httpHost.getPort() != j.kc()) {
                                        bTU.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(bTS, j.kc()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.bTO = e.getInstance().httpGetFactory(str, this.bTX, false);
                                    } else {
                                        this.bTO = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.bTO = new HttpGet(str);
                                }
                                if (bTM != null) {
                                    this.bTO.setHeader(AUTH.PROXY_AUTH_RESP, bTM);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.bTO.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.jU()) {
                            if (!this.bTW || this.bTO == null) {
                                this.bTO = e.getInstance().httpGetFactory(str, this.bTX, false);
                            }
                        } else {
                            this.bTO = e.getInstance().httpGetFactory(str, this.bTX, true);
                        }
                    } else {
                        this.bTO = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.bTO = new HttpGet(str);
                }
                this.bTO.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean ob(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [627=13, 628=13, 632=13, 638=13, 639=13, 640=13, 641=13, 642=13, 643=26, 645=13, 646=13, 648=13, 651=13, 653=26, 654=13, 656=13, 659=13, 661=13, 666=6] */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x08e7, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x08eb, code lost:
        r13.Ao = r6;
        r13.Aq = r10 + 1;
        r13.Ap = java.lang.System.currentTimeMillis() - r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x0904, code lost:
        if (r9.getFirstHeader("Error-Message") == null) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x0906, code lost:
        r4 = r9.getFirstHeader("Error-Message");
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x090d, code lost:
        if (r4 == null) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x0917, code lost:
        if (android.text.TextUtils.isEmpty(r4.getValue()) != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x0926, code lost:
        if (r4.getValue().equalsIgnoreCase("OK") == false) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x0928, code lost:
        r25.bTV = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x092d, code lost:
        if (r6 <= 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x093b, code lost:
        if (r25.bTR.il().responseCode == 200) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0949, code lost:
        if (r25.bTR.il().responseCode != 302) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x094b, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x0953, code lost:
        if (r9.getFirstHeader("ginfo") == null) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x0955, code lost:
        r4 = r9.getFirstHeader("ginfo").getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x0960, code lost:
        if (r4 == null) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0966, code lost:
        if (r4.length() <= 0) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0968, code lost:
        oc(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x096d, code lost:
        if (r8 == null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x096f, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x09ee, code lost:
        r25.bTV = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:452:0x08ac A[Catch: SocketException -> 0x0532, SocketTimeoutException -> 0x09eb, HttpException -> 0x09f5, all -> 0x0c32, Throwable -> 0x0cf5, IllegalStateException -> 0x0d01, IOException -> 0x0d09, TRY_ENTER, TryCatch #7 {all -> 0x0c32, blocks: (B:238:0x0500, B:240:0x0509, B:242:0x0512, B:244:0x0515, B:246:0x0529, B:247:0x0531, B:250:0x0536, B:252:0x053c, B:254:0x0558, B:256:0x055f, B:339:0x069d, B:341:0x06a8, B:383:0x0751, B:385:0x076b, B:387:0x077a, B:392:0x0787, B:394:0x07b0, B:395:0x07bd, B:397:0x07c6, B:399:0x07dc, B:400:0x07e2, B:402:0x07e8, B:404:0x07ec, B:406:0x07f8, B:409:0x080d, B:452:0x08ac, B:454:0x08b0, B:455:0x08b4, B:457:0x08bd, B:459:0x08c7, B:461:0x08d2, B:464:0x08eb, B:466:0x0906, B:468:0x090f, B:470:0x0919, B:515:0x09ee, B:472:0x0928, B:474:0x092f, B:476:0x093d, B:479:0x094c, B:481:0x0955, B:483:0x0962, B:485:0x0968, B:605:0x0b53, B:209:0x0446, B:175:0x036c, B:141:0x02b0, B:61:0x0145, B:512:0x09c8, B:407:0x0806), top: B:743:0x0500 }] */
    /* JADX WARN: Removed duplicated region for block: B:657:0x0c54  */
    /* JADX WARN: Removed duplicated region for block: B:669:0x0c71  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x0c92  */
    /* JADX WARN: Removed duplicated region for block: B:748:0x0c36 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:771:0x081b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String c;
        Throwable th;
        InputStream inputStream;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean jT;
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
            if (!e.getInstance().bTK) {
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
            if (this.bTQ || i3 >= i) {
                break;
            }
            this.bTX = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.bTR.a(dVar);
            dVar.Av = -1;
            InputStream inputStream2 = null;
            c = this.bTR.ik().c(dVar);
            try {
                dVar.Av = -2;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    F(c, null, null);
                    if (z15) {
                        dVar.Aw = e.getInstance().getCachedCdnIp(this.bTX);
                    }
                } else {
                    F(c, str, str2);
                    dVar.Aw = str;
                }
                dVar.Av = -3;
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
            if (this.bTO == null) {
                throw new SocketException("network not available.");
            }
            if (this.bTQ) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                closeConnection();
                this.bTR.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean jT2 = j.jT();
                    if ((jT2 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (jT2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                        } else if (j.jX()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                        }
                        e.getInstance().result(c, dVar.Aw, false, z8, jT2);
                    }
                }
            } else {
                dVar.Av = -8;
                HttpResponse execute = bTT.execute(this.bTO);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.bTR.il().responseCode = execute.getStatusLine().getStatusCode();
                dVar.Au = this.bTR.il().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.Ay = headers[0].getValue();
                            dVar.Az = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                        }
                        closeConnection();
                        this.bTR.b(dVar);
                        if (str != null) {
                        }
                        jT = j.jT();
                        if (jT ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) {
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                            if (!jT) {
                            }
                            e.getInstance().result(c, dVar.Aw, false, z5, jT);
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                } catch (IllegalStateException e8) {
                    e = e8;
                } catch (SocketException e9) {
                    e = e9;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e10) {
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
                    this.bTR.il().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.bTP < 1) {
                            closeConnection();
                            this.bTP++;
                            this.bTR.il().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            closeConnection();
                            this.bTR.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jT3 = j.jT();
                                if ((jT3 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jT3) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                    } else if (j.jX()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                    }
                                    e.getInstance().result(c, dVar.Aw, false, z13, jT3);
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
                            this.bTR.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jT4 = j.jT();
                                if ((jT4 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jT4) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                    } else if (j.jX()) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                    } else {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                    }
                                    e.getInstance().result(c, dVar.Aw, false, z12, jT4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > bRj) {
                    this.bTR.il().AK = -11;
                    dVar.At = this.mContext.getResources().getString(R.string.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    closeConnection();
                    this.bTR.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean jT5 = j.jT();
                        if ((jT5 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (jT5) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                            } else if (j.jX()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                            }
                            e.getInstance().result(c, dVar.Aw, false, z9, jT5);
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
                        while (!this.bTQ && i2 < bRj && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.Av = -9;
                        if (this.bTQ) {
                            if (i2 >= bRj) {
                                this.bTR.il().AK = -11;
                                dVar.At = this.mContext.getResources().getString(R.string.data_too_big);
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
                                this.bTR.il().AK = -19;
                                dVar.At = "errorCode:" + String.valueOf(this.bTR.il().AK) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                closeConnection();
                                this.bTR.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jT6 = j.jT();
                                    if ((jT6 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jT6) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                        } else if (j.jX()) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                        } else {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                        }
                                        e.getInstance().result(c, dVar.Aw, false, z7, jT6);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e17) {
                                bArr7 = bArr5;
                                e = e17;
                                inputStream2 = inputStream;
                                try {
                                    this.bTR.il().AK = -12;
                                    dVar.At = "errorCode:" + String.valueOf(this.bTR.il().AK) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    closeConnection();
                                    this.bTR.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean jT7 = j.jT();
                                        if ((jT7 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (jT7) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                            } else if (j.jX()) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                            } else {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                            }
                                            e.getInstance().result(c, dVar.Aw, false, z6, jT7);
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
                                    this.bTR.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        jT = j.jT();
                                        if ((jT ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                            long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!jT) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                            } else if (j.jX()) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                            } else {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                            }
                                            e.getInstance().result(c, dVar.Aw, false, z5, jT);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (SocketTimeoutException e20) {
                                bArr7 = bArr4;
                                e = e20;
                                this.bTR.il().AK = -13;
                                dVar.At = "errorCode:" + String.valueOf(this.bTR.il().AK) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                closeConnection();
                                this.bTR.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jT8 = j.jT();
                                    if ((jT8 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jT8) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                        } else if (j.jX()) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                        } else {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                        }
                                        e.getInstance().result(c, dVar.Aw, false, z4, jT8);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e22) {
                                bArr7 = bArr3;
                                e = e22;
                                this.bTR.il().AK = -19;
                                dVar.At = "errorCode:" + String.valueOf(this.bTR.il().AK) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                closeConnection();
                                this.bTR.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jT9 = j.jT();
                                    if ((jT9 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jT9) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                        } else if (j.jX()) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                        } else {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                        }
                                        e.getInstance().result(c, dVar.Aw, false, z3, jT9);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e24) {
                                bArr7 = bArr2;
                                e = e24;
                                this.bTR.il().AK = -18;
                                dVar.At = "errorCode:" + String.valueOf(this.bTR.il().AK) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                closeConnection();
                                this.bTR.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jT10 = j.jT();
                                    if ((jT10 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jT10) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                        } else if (j.jX()) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                        } else {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                        }
                                        e.getInstance().result(c, dVar.Aw, false, z2, jT10);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th6) {
                                bArr7 = bArr;
                                th = th6;
                                this.bTR.il().AK = -10;
                                dVar.At = "errorCode:" + String.valueOf(this.bTR.il().AK) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e26) {
                                    }
                                }
                                closeConnection();
                                this.bTR.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jT11 = j.jT();
                                    if ((jT11 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jT11) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                        } else if (j.jX()) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                        } else {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                        }
                                        e.getInstance().result(c, dVar.Aw, false, z, jT11);
                                    }
                                }
                                this.bTP = 0;
                                this.bTR.il().AN = bArr7;
                            }
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e27) {
                                }
                            }
                            closeConnection();
                            this.bTR.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jT12 = j.jT();
                                if ((jT12 ? (dVar.Aw == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.qN(c) && z15) {
                                    long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jT12) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                                    } else if (j.jX()) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                                    } else {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                                    }
                                    e.getInstance().result(c, dVar.Aw, false, z10, jT12);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.bTQ) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.Av = -9;
                if (this.bTQ) {
                }
            }
        }
        closeConnection();
        this.bTR.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean jT13 = j.jT();
            if ((jT13 ? dVar.Aw != null || z16 || i3 >= i + (-1) : true) && l.qN(c) && z15) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (jT13) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bBE);
                } else if (j.jX()) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bBG);
                } else {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bBF);
                }
                e.getInstance().result(c, dVar.Aw, z16, z11, jT13);
            }
        }
        this.bTP = 0;
        this.bTR.il().AN = bArr7;
    }

    private void oc(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(bTY) && (System.currentTimeMillis() - bUa) - (1800000 * (bTZ / 3)) >= 0) {
            bTZ++;
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
                bTY = str;
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

    public boolean aiI() {
        return this.bTV;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        ia();
    }
}
