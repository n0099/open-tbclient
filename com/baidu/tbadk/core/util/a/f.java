package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.f;
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
public class f implements a.InterfaceC0015a {
    public static String asg;
    private static HttpClient ash;
    private static String asm;
    private static int asn;
    private static long aso;
    private HttpGet asc;
    private final com.baidu.adp.lib.network.http.e asf;
    public boolean ask;
    private final Context mContext;
    private static int apy = 5242880;
    private static volatile String asa = null;
    private static volatile boolean asb = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams asi = new BasicHttpParams();
    private boolean mIsGif = false;
    private boolean asj = false;
    private int asl = 0;
    private int asd = 0;
    private volatile boolean ase = false;

    static {
        HttpConnectionParams.setConnectionTimeout(asi, 5000);
        HttpConnectionParams.setSoTimeout(asi, 30000);
        HttpConnectionParams.setSocketBufferSize(asi, 1024);
        HttpConnectionParams.setTcpNoDelay(asi, true);
        HttpClientParams.setRedirecting(asi, true);
        ConnManagerParams.setMaxConnectionsPerRoute(asi, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(asi, 10000L);
        ConnManagerParams.setMaxTotalConnections(asi, 15);
        HttpProtocolParams.setUserAgent(asi, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ash = new DefaultHttpClient(new ThreadSafeClientConnManager(asi, schemeRegistry), asi);
        ((DefaultHttpClient) ash).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        asm = null;
        asn = 0;
        aso = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        zP();
        this.asf = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void zP() {
        synchronized (f.class) {
            if (!asb) {
                asb = true;
                zQ();
            }
        }
    }

    public static synchronized void zQ() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    asa = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + SystemInfoUtil.COLON + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void hN() {
        this.ase = true;
        this.asf.hX().zU = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.asc != null) {
                this.asc.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void n(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().arY) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.jE()) {
            this.ask = false;
            try {
                if (j.jG()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (asg == null) {
                            asg = j.jO();
                        }
                        if (asg != null && asg.length() > 0) {
                            this.ask = true;
                            if (eV(asg) && j.jQ()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(asg);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.asc = e.getInstance().httpGetFactory(sb.toString(), this.asl, false);
                                    } else {
                                        this.asc = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.asc = new HttpGet(sb.toString());
                                }
                                this.asc.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.asc.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = asi.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    asi.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(asg, j.jP()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(asg) || httpHost.getPort() != j.jP()) {
                                        asi.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(asg, j.jP()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.asc = e.getInstance().httpGetFactory(str, this.asl, false);
                                    } else {
                                        this.asc = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.asc = new HttpGet(str);
                                }
                                if (asa != null) {
                                    this.asc.setHeader(AUTH.PROXY_AUTH_RESP, asa);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.asc.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.jG()) {
                            if (!this.ask || this.asc == null) {
                                this.asc = e.getInstance().httpGetFactory(str, this.asl, false);
                            }
                        } else {
                            this.asc = e.getInstance().httpGetFactory(str, this.asl, true);
                        }
                    } else {
                        this.asc = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.asc = new HttpGet(str);
                }
                this.asc.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean eV(String str) {
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
        r13.zz = r6;
        r13.zB = r10 + 1;
        r13.zA = java.lang.System.currentTimeMillis() - r16;
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
        r25.asj = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x092c, code lost:
        if (r6 <= 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x093a, code lost:
        if (r25.asf.hX().responseCode == 200) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x0948, code lost:
        if (r25.asf.hX().responseCode != 302) goto L211;
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
        eW(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x096c, code lost:
        if (r8 == null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x096e, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x09ec, code lost:
        r25.asj = true;
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
        boolean jF;
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
            if (!e.getInstance().arY) {
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
            if (this.ase || i3 >= i) {
                break;
            }
            this.asl = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.asf.a(dVar);
            dVar.zG = -1;
            InputStream inputStream2 = null;
            c = this.asf.hW().c(dVar);
            try {
                dVar.zG = -2;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    n(c, null, null);
                    if (z15) {
                        dVar.zH = e.getInstance().getCachedCdnIp(this.asl);
                    }
                } else {
                    n(c, str, str2);
                    dVar.zH = str;
                }
                dVar.zG = -3;
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
            if (this.asc == null) {
                throw new SocketException("network not available.");
            }
            if (this.ase) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                closeConnection();
                this.asf.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean jF2 = j.jF();
                    if ((jF2 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (jF2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().abu);
                        } else if (j.jJ()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().abw);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().abv);
                        }
                        e.getInstance().result(c, dVar.zH, false, z8, jF2);
                    }
                }
            } else {
                dVar.zG = -8;
                HttpResponse execute = ash.execute(this.asc);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.asf.hX().responseCode = execute.getStatusLine().getStatusCode();
                dVar.zF = this.asf.hX().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.zJ = headers[0].getValue();
                            dVar.zK = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                        }
                        closeConnection();
                        this.asf.b(dVar);
                        if (str != null) {
                        }
                        jF = j.jF();
                        if (jF ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) {
                            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                            if (!jF) {
                            }
                            e.getInstance().result(c, dVar.zH, false, z5, jF);
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
                    this.asf.hX().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.asd < 1) {
                            closeConnection();
                            this.asd++;
                            this.asf.hX().responseCode = 0;
                            i3--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            closeConnection();
                            this.asf.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jF3 = j.jF();
                                if ((jF3 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jF3) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                    } else if (j.jJ()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                    }
                                    e.getInstance().result(c, dVar.zH, false, z13, jF3);
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
                            this.asf.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jF4 = j.jF();
                                if ((jF4 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jF4) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                    } else if (j.jJ()) {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                    } else {
                                        z12 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                    }
                                    e.getInstance().result(c, dVar.zH, false, z12, jF4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > apy) {
                    this.asf.hX().zV = -11;
                    dVar.zE = this.mContext.getResources().getString(f.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    closeConnection();
                    this.asf.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean jF5 = j.jF();
                        if ((jF5 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (jF5) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().abu);
                            } else if (j.jJ()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().abw);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().abv);
                            }
                            e.getInstance().result(c, dVar.zH, false, z9, jF5);
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
                        while (!this.ase && i2 < apy && (read = inputStream.read(bArr8)) != -1) {
                            byteArrayOutputStream.write(bArr8, 0, read);
                            i2 = read + i2;
                        }
                        dVar.zG = -9;
                        if (this.ase) {
                            if (i2 >= apy) {
                                this.asf.hX().zV = -11;
                                dVar.zE = this.mContext.getResources().getString(f.j.data_too_big);
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
                                this.asf.hX().zV = -19;
                                dVar.zE = "errorCode:" + String.valueOf(this.asf.hX().zV) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                closeConnection();
                                this.asf.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jF6 = j.jF();
                                    if ((jF6 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jF6) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                        } else if (j.jJ()) {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                        } else {
                                            z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                        }
                                        e.getInstance().result(c, dVar.zH, false, z7, jF6);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (SocketException e17) {
                                bArr7 = bArr5;
                                e = e17;
                                inputStream2 = inputStream;
                                try {
                                    this.asf.hX().zV = -12;
                                    dVar.zE = "errorCode:" + String.valueOf(this.asf.hX().zV) + "|" + e.getClass() + "|" + e.getMessage();
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    closeConnection();
                                    this.asf.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean jF7 = j.jF();
                                        if ((jF7 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (jF7) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                            } else if (j.jJ()) {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                            } else {
                                                z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                            }
                                            e.getInstance().result(c, dVar.zH, false, z6, jF7);
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
                                    this.asf.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        jF = j.jF();
                                        if ((jF ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                            long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!jF) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                            } else if (j.jJ()) {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                            } else {
                                                z5 = currentTimeMillis42 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                            }
                                            e.getInstance().result(c, dVar.zH, false, z5, jF);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (SocketTimeoutException e20) {
                                bArr7 = bArr4;
                                e = e20;
                                this.asf.hX().zV = -13;
                                dVar.zE = "errorCode:" + String.valueOf(this.asf.hX().zV) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                closeConnection();
                                this.asf.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jF8 = j.jF();
                                    if ((jF8 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jF8) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                        } else if (j.jJ()) {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                        } else {
                                            z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                        }
                                        e.getInstance().result(c, dVar.zH, false, z4, jF8);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (IOException e22) {
                                bArr7 = bArr3;
                                e = e22;
                                this.asf.hX().zV = -19;
                                dVar.zE = "errorCode:" + String.valueOf(this.asf.hX().zV) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                closeConnection();
                                this.asf.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jF9 = j.jF();
                                    if ((jF9 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jF9) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                        } else if (j.jJ()) {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                        } else {
                                            z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                        }
                                        e.getInstance().result(c, dVar.zH, false, z3, jF9);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (HttpException e24) {
                                bArr7 = bArr2;
                                e = e24;
                                this.asf.hX().zV = -18;
                                dVar.zE = "errorCode:" + String.valueOf(this.asf.hX().zV) + "|" + e.getClass() + "|" + e.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                closeConnection();
                                this.asf.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jF10 = j.jF();
                                    if ((jF10 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jF10) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                        } else if (j.jJ()) {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                        } else {
                                            z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                        }
                                        e.getInstance().result(c, dVar.zH, false, z2, jF10);
                                    }
                                }
                                i3++;
                                bArr7 = bArr7;
                            } catch (Throwable th6) {
                                bArr7 = bArr;
                                th = th6;
                                this.asf.hX().zV = -10;
                                dVar.zE = "errorCode:" + String.valueOf(this.asf.hX().zV) + "|" + th.getClass() + "|" + th.getMessage();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e26) {
                                    }
                                }
                                closeConnection();
                                this.asf.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean jF11 = j.jF();
                                    if ((jF11 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (jF11) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                        } else if (j.jJ()) {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                        } else {
                                            z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                        }
                                        e.getInstance().result(c, dVar.zH, false, z, jF11);
                                    }
                                }
                                this.asd = 0;
                                this.asf.hX().zX = bArr7;
                            }
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e27) {
                                }
                            }
                            closeConnection();
                            this.asf.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean jF12 = j.jF();
                                if ((jF12 ? (dVar.zH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                                    long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                    if (jF12) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().abu);
                                    } else if (j.jJ()) {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().abw);
                                    } else {
                                        z10 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().abv);
                                    }
                                    e.getInstance().result(c, dVar.zH, false, z10, jF12);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.ase) {
                    byteArrayOutputStream.write(bArr8, 0, read);
                    i2 = read + i2;
                }
                dVar.zG = -9;
                if (this.ase) {
                }
            }
        }
        closeConnection();
        this.asf.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean jF13 = j.jF();
            if ((jF13 ? dVar.zH != null || z16 || i3 >= i + (-1) : true) && com.baidu.tbadk.util.h.hv(c) && z15) {
                long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                if (jF13) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().abu);
                } else if (j.jJ()) {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().abw);
                } else {
                    z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().abv);
                }
                e.getInstance().result(c, dVar.zH, z16, z11, jF13);
            }
        }
        this.asd = 0;
        this.asf.hX().zX = bArr7;
    }

    private void eW(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(asm) && (System.currentTimeMillis() - aso) - (1800000 * (asn / 3)) >= 0) {
            asn++;
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
                asm = str;
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

    public boolean zR() {
        return this.asj;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0015a
    public void cancel() {
        hN();
    }
}
