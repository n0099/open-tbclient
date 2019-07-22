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
    public static String bUT;
    private static HttpClient bUU;
    private static String bUZ;
    private static int bVa;
    private static long bVb;
    private HttpGet bUP;
    private final com.baidu.adp.lib.network.http.e bUS;
    public boolean bUX;
    private final Context mContext;
    private static int bSj = 5242880;
    private static volatile String bUN = null;
    private static volatile boolean bUO = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams bUV = new BasicHttpParams();
    private boolean mIsGif = false;
    private boolean bUW = false;
    private int bUY = 0;
    private int bUQ = 0;
    private volatile boolean bUR = false;

    static {
        HttpConnectionParams.setConnectionTimeout(bUV, UIMsg.m_AppUI.MSG_APP_GPS);
        HttpConnectionParams.setSoTimeout(bUV, 30000);
        HttpConnectionParams.setSocketBufferSize(bUV, 1024);
        HttpConnectionParams.setTcpNoDelay(bUV, true);
        HttpClientParams.setRedirecting(bUV, true);
        ConnManagerParams.setMaxConnectionsPerRoute(bUV, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(bUV, 10000L);
        ConnManagerParams.setMaxTotalConnections(bUV, 15);
        HttpProtocolParams.setUserAgent(bUV, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        bUU = new DefaultHttpClient(new ThreadSafeClientConnManager(bUV, schemeRegistry), bUV);
        ((DefaultHttpClient) bUU).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        bUZ = null;
        bVa = 0;
        bVb = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        ajJ();
        this.bUS = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void ajJ() {
        synchronized (f.class) {
            if (!bUO) {
                bUO = true;
                ajK();
            }
        }
    }

    public static synchronized void ajK() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    bUN = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void ik() {
        this.bUR = true;
        this.bUS.iv().AQ = true;
        ajL();
    }

    private void ajL() {
        try {
            if (this.bUP != null) {
                this.bUP.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void F(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().bUL) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.kc()) {
            this.bUX = false;
            try {
                if (j.ke()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (bUT == null) {
                            bUT = j.kl();
                        }
                        if (bUT != null && bUT.length() > 0) {
                            this.bUX = true;
                            if (ou(bUT) && j.kn()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(bUT);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.bUP = e.getInstance().httpGetFactory(sb.toString(), this.bUY, false);
                                    } else {
                                        this.bUP = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.bUP = new HttpGet(sb.toString());
                                }
                                this.bUP.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.bUP.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = bUV.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    bUV.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(bUT, j.km()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(bUT) || httpHost.getPort() != j.km()) {
                                        bUV.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(bUT, j.km()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.bUP = e.getInstance().httpGetFactory(str, this.bUY, false);
                                    } else {
                                        this.bUP = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.bUP = new HttpGet(str);
                                }
                                if (bUN != null) {
                                    this.bUP.setHeader(AUTH.PROXY_AUTH_RESP, bUN);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.bUP.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.ke()) {
                            if (!this.bUX || this.bUP == null) {
                                this.bUP = e.getInstance().httpGetFactory(str, this.bUY, false);
                            }
                        } else {
                            this.bUP = e.getInstance().httpGetFactory(str, this.bUY, true);
                        }
                    } else {
                        this.bUP = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.bUP = new HttpGet(str);
                }
                this.bUP.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean ou(String str) {
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
        r13.Au = r6;
        r13.Aw = r10 + 1;
        r13.Av = java.lang.System.currentTimeMillis() - r16;
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
        r25.bUW = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x092d, code lost:
        if (r6 <= 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x093b, code lost:
        if (r25.bUS.iv().responseCode == 200) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0949, code lost:
        if (r25.bUS.iv().responseCode != 302) goto L211;
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
        ov(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x096d, code lost:
        if (r8 == null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x096f, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x09ee, code lost:
        r25.bUW = true;
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
        boolean kd;
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
            if (!e.getInstance().bUL) {
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
            if (this.bUR || i3 >= i) {
                break;
            }
            this.bUY = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.bUS.a(dVar);
            dVar.AB = -1;
            InputStream inputStream2 = null;
            c = this.bUS.iu().c(dVar);
            try {
                dVar.AB = -2;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    F(c, null, null);
                    if (z15) {
                        dVar.AC = e.getInstance().getCachedCdnIp(this.bUY);
                    }
                } else {
                    F(c, str, str2);
                    dVar.AC = str;
                }
                dVar.AB = -3;
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
            if (this.bUP == null) {
                throw new SocketException("network not available.");
            }
            if (this.bUR) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                ajL();
                this.bUS.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean kd2 = j.kd();
                    if ((kd2 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (kd2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                        } else if (j.kh()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                        }
                        e.getInstance().result(c, dVar.AC, false, z8, kd2);
                    }
                }
            } else {
                dVar.AB = -8;
                HttpResponse execute = bUU.execute(this.bUP);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.bUS.iv().responseCode = execute.getStatusLine().getStatusCode();
                dVar.AA = this.bUS.iv().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.AE = headers[0].getValue();
                            dVar.AF = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                        }
                        ajL();
                        this.bUS.b(dVar);
                        if (str != null) {
                        }
                        kd = j.kd();
                        if (kd ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) {
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                            if (!kd) {
                            }
                            e.getInstance().result(c, dVar.AC, false, z5, kd);
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
                    this.bUS.iv().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.bUQ < 1) {
                            ajL();
                            this.bUQ++;
                            this.bUS.iv().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            ajL();
                            this.bUS.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kd3 = j.kd();
                                if ((kd3 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kd3) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                    } else if (j.kh()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                    }
                                    e.getInstance().result(c, dVar.AC, false, z13, kd3);
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
                            ajL();
                            this.bUS.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kd4 = j.kd();
                                if ((kd4 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kd4) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                    } else if (j.kh()) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                    } else {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                    }
                                    e.getInstance().result(c, dVar.AC, false, z12, kd4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > bSj) {
                    this.bUS.iv().AR = -11;
                    dVar.Az = this.mContext.getResources().getString(R.string.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    ajL();
                    this.bUS.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean kd5 = j.kd();
                        if ((kd5 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (kd5) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                            } else if (j.kh()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                            }
                            e.getInstance().result(c, dVar.AC, false, z9, kd5);
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
                        while (!this.bUR && i2 < bSj && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.AB = -9;
                        if (this.bUR) {
                            if (i2 >= bSj) {
                                this.bUS.iv().AR = -11;
                                dVar.Az = this.mContext.getResources().getString(R.string.data_too_big);
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
                                this.bUS.iv().AR = -19;
                                dVar.Az = "errorCode:" + String.valueOf(this.bUS.iv().AR) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                ajL();
                                this.bUS.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd6 = j.kd();
                                    if ((kd6 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd6) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                        } else if (j.kh()) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                        } else {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z7, kd6);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e17) {
                                bArr7 = bArr5;
                                e = e17;
                                inputStream2 = inputStream;
                                try {
                                    this.bUS.iv().AR = -12;
                                    dVar.Az = "errorCode:" + String.valueOf(this.bUS.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    ajL();
                                    this.bUS.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean kd7 = j.kd();
                                        if ((kd7 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (kd7) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                            } else if (j.kh()) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                            } else {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                            }
                                            e.getInstance().result(c, dVar.AC, false, z6, kd7);
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
                                    ajL();
                                    this.bUS.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        kd = j.kd();
                                        if ((kd ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                            long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!kd) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                            } else if (j.kh()) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                            } else {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                            }
                                            e.getInstance().result(c, dVar.AC, false, z5, kd);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (SocketTimeoutException e20) {
                                bArr7 = bArr4;
                                e = e20;
                                this.bUS.iv().AR = -13;
                                dVar.Az = "errorCode:" + String.valueOf(this.bUS.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                ajL();
                                this.bUS.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd8 = j.kd();
                                    if ((kd8 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd8) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                        } else if (j.kh()) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                        } else {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z4, kd8);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e22) {
                                bArr7 = bArr3;
                                e = e22;
                                this.bUS.iv().AR = -19;
                                dVar.Az = "errorCode:" + String.valueOf(this.bUS.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                ajL();
                                this.bUS.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd9 = j.kd();
                                    if ((kd9 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd9) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                        } else if (j.kh()) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                        } else {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z3, kd9);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e24) {
                                bArr7 = bArr2;
                                e = e24;
                                this.bUS.iv().AR = -18;
                                dVar.Az = "errorCode:" + String.valueOf(this.bUS.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                ajL();
                                this.bUS.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd10 = j.kd();
                                    if ((kd10 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd10) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                        } else if (j.kh()) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                        } else {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z2, kd10);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th6) {
                                bArr7 = bArr;
                                th = th6;
                                this.bUS.iv().AR = -10;
                                dVar.Az = "errorCode:" + String.valueOf(this.bUS.iv().AR) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e26) {
                                    }
                                }
                                ajL();
                                this.bUS.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd11 = j.kd();
                                    if ((kd11 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd11) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                        } else if (j.kh()) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                        } else {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z, kd11);
                                    }
                                }
                                this.bUQ = 0;
                                this.bUS.iv().AU = bArr7;
                            }
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e27) {
                                }
                            }
                            ajL();
                            this.bUS.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kd12 = j.kd();
                                if ((kd12 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && l.re(c) && z15) {
                                    long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kd12) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                                    } else if (j.kh()) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                                    } else {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                                    }
                                    e.getInstance().result(c, dVar.AC, false, z10, kd12);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.bUR) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.AB = -9;
                if (this.bUR) {
                }
            }
        }
        ajL();
        this.bUS.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean kd13 = j.kd();
            if ((kd13 ? dVar.AC != null || z16 || i3 >= i + (-1) : true) && l.re(c) && z15) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (kd13) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bCB);
                } else if (j.kh()) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bCD);
                } else {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bCC);
                }
                e.getInstance().result(c, dVar.AC, z16, z11, kd13);
            }
        }
        this.bUQ = 0;
        this.bUS.iv().AU = bArr7;
    }

    private void ov(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(bUZ) && (System.currentTimeMillis() - bVb) - (1800000 * (bVa / 3)) >= 0) {
            bVa++;
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
                bUZ = str;
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

    public boolean ajM() {
        return this.bUW;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        ik();
    }
}
