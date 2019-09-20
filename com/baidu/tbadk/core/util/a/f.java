package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.util.k;
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
import javax.net.ssl.SSLException;
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
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public class f implements a.InterfaceC0016a {
    public static String bVF;
    private static HttpClient bVG;
    private static String bVL;
    private static int bVM;
    private static long bVN;
    private final com.baidu.adp.lib.network.http.e bVB;
    public boolean bVJ;
    private HttpGet bVy;
    private final Context mContext;
    private static int bSQ = 5242880;
    private static volatile String bVw = null;
    private static volatile boolean bVx = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams bVH = new BasicHttpParams();
    private com.baidu.tbadk.core.util.b.c bVC = null;
    private boolean bVD = false;
    private boolean bVE = false;
    private boolean mIsGif = false;
    private boolean bVI = false;
    private int bVK = 0;
    private int bVz = 0;
    private volatile boolean bVA = false;

    static {
        HttpConnectionParams.setConnectionTimeout(bVH, 5000);
        HttpConnectionParams.setSoTimeout(bVH, 30000);
        HttpConnectionParams.setSocketBufferSize(bVH, 1024);
        HttpConnectionParams.setTcpNoDelay(bVH, true);
        HttpClientParams.setRedirecting(bVH, true);
        ConnManagerParams.setMaxConnectionsPerRoute(bVH, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(bVH, 10000L);
        ConnManagerParams.setMaxTotalConnections(bVH, 15);
        HttpProtocolParams.setUserAgent(bVH, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        bVG = new DefaultHttpClient(new ThreadSafeClientConnManager(bVH, schemeRegistry), bVH);
        ((DefaultHttpClient) bVG).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        bVL = null;
        bVM = 0;
        bVN = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        ajR();
        this.bVB = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void ajR() {
        synchronized (f.class) {
            if (!bVx) {
                bVx = true;
                ajS();
            }
        }
    }

    public static synchronized void ajS() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    bVw = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void ik() {
        this.bVA = true;
        this.bVB.iv().AQ = true;
        ajT();
    }

    private void ajT() {
        try {
            if (this.bVy != null) {
                this.bVy.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void F(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().bVu) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.kc()) {
            this.bVJ = false;
            try {
                if (j.ke()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (bVF == null) {
                            bVF = j.kl();
                        }
                        if (bVF != null && bVF.length() > 0) {
                            this.bVJ = true;
                            if (ow(bVF) && j.kn()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(bVF);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.bVy = e.getInstance().httpGetFactory(sb.toString(), this.bVK, false);
                                    } else {
                                        this.bVy = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.bVy = new HttpGet(sb.toString());
                                }
                                this.bVy.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.bVy.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = bVH.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    bVH.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(bVF, j.km()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(bVF) || httpHost.getPort() != j.km()) {
                                        bVH.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(bVF, j.km()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.bVy = e.getInstance().httpGetFactory(str, this.bVK, false);
                                    } else {
                                        this.bVy = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.bVy = new HttpGet(str);
                                }
                                if (bVw != null) {
                                    this.bVy.setHeader(AUTH.PROXY_AUTH_RESP, bVw);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.bVy.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (k.rq(str)) {
                    String host = com.baidu.tbadk.core.util.b.d.getHost(str);
                    this.bVC = com.baidu.tbadk.core.util.b.b.ajZ().oB(host);
                    if (!aq.isEmpty(this.bVC.akd())) {
                        this.bVy = G(str, this.bVC.akd(), host);
                    } else if (this.bVD) {
                        this.bVC = com.baidu.tbadk.core.util.b.b.ajZ().oC(host);
                        this.bVy = G(str, this.bVC.akd(), host);
                    } else {
                        this.bVy = new HttpGet(str);
                    }
                } else if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.ke()) {
                            if (!this.bVJ || this.bVy == null) {
                                this.bVy = e.getInstance().httpGetFactory(str, this.bVK, false);
                            }
                        } else {
                            this.bVy = e.getInstance().httpGetFactory(str, this.bVK, true);
                        }
                    } else {
                        this.bVy = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.bVy = new HttpGet(str);
                }
                this.bVy.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private HttpGet G(String str, String str2, String str3) {
        if (this.bVE && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://" + str.substring(8);
        }
        if (this.bVC != null && !aq.isEmpty(this.bVC.akd())) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String str4 = url.getProtocol() + "://" + str2 + url.getPath();
                HttpGet httpGet = new HttpGet(str4);
                this.bVC.oE(str4);
                httpGet.addHeader(HTTP.TARGET_HOST, str3);
                return httpGet;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return new HttpGet(str);
    }

    private boolean ow(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [686=29, 687=14, 688=14, 690=14, 691=14, 692=14, 693=14, 694=14, 695=14, 696=14, 697=14, 698=14, 699=14, 701=14, 702=14, 703=28, 704=14, 705=14, 706=14, 707=14, 708=14, 710=14, 713=14, 714=14, 718=14, 724=14, 725=14, 726=14, 727=14, 728=14, 729=28, 731=14, 732=14, 734=14, 737=14, 739=28, 740=14, 742=14, 745=14, 747=14, 752=7] */
    /* JADX WARN: Code restructure failed: missing block: B:732:0x143b, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:734:0x143f, code lost:
        r13.Au = r6;
        r13.Aw = r10 + 1;
        r13.Av = java.lang.System.currentTimeMillis() - r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:735:0x1458, code lost:
        if (r9.getFirstHeader("Error-Message") == null) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:736:0x145a, code lost:
        r4 = r9.getFirstHeader("Error-Message");
     */
    /* JADX WARN: Code restructure failed: missing block: B:737:0x1461, code lost:
        if (r4 == null) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:739:0x146b, code lost:
        if (android.text.TextUtils.isEmpty(r4.getValue()) != false) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:741:0x147a, code lost:
        if (r4.getValue().equalsIgnoreCase("OK") == false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:742:0x147c, code lost:
        r27.bVI = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x1481, code lost:
        if (r6 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x148f, code lost:
        if (r27.bVB.iv().responseCode == 200) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x149d, code lost:
        if (r27.bVB.iv().responseCode != 302) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:748:0x149f, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:750:0x14a7, code lost:
        if (r9.getFirstHeader("ginfo") == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:751:0x14a9, code lost:
        r4 = r9.getFirstHeader("ginfo").getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:752:0x14b4, code lost:
        if (r4 == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:754:0x14ba, code lost:
        if (r4.length() <= 0) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:755:0x14bc, code lost:
        ox(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:756:0x14c1, code lost:
        if (r7 != false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:758:0x14c7, code lost:
        if (com.baidu.tbadk.util.k.rq(r5) == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:760:0x14cd, code lost:
        if (com.baidu.adp.lib.util.j.jQ() == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:761:0x14cf, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:762:0x14d0, code lost:
        r27.bVD = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:763:0x14d8, code lost:
        if (r27.bVD == false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x14de, code lost:
        if (r27.bVC == null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:766:0x14e0, code lost:
        r27.bVC.iy(r27.bVB.iv().AR);
     */
    /* JADX WARN: Code restructure failed: missing block: B:767:0x14f1, code lost:
        if (r7 != false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:769:0x14f5, code lost:
        if (r10 != (r30 - 1)) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:771:0x14fb, code lost:
        if (com.baidu.tbadk.util.k.rq(r5) == false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:772:0x14fd, code lost:
        r6 = com.baidu.tbadk.core.util.s.iF();
        r6.append("netException", r13.Az);
        r6.append("Url", r5);
        r6.c("isNetAvailable", java.lang.Boolean.valueOf(com.baidu.adp.lib.util.j.kc()));
        r6.c("netType", java.lang.Integer.valueOf(com.baidu.adp.lib.util.j.netType()));
        r6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:773:0x1548, code lost:
        if (r11 == null) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:774:0x154a, code lost:
        r4 = r11.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:775:0x154b, code lost:
        r6.c("downloadFileSize", java.lang.Integer.valueOf(r4));
        r6.c("cost", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - r14));
        r9 = new java.lang.Object[2];
        r9[0] = "isNetChanged";
     */
    /* JADX WARN: Code restructure failed: missing block: B:776:0x158a, code lost:
        if (com.baidu.adp.lib.util.j.kp() <= r14) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:777:0x158c, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:778:0x158d, code lost:
        r9[1] = java.lang.Boolean.valueOf(r4);
        r6.c(r9);
        r6.c("isBackground", java.lang.Boolean.valueOf(com.baidu.tbadk.core.TbadkCoreApplication.getInst().isInBackground()));
        r6.append("currentActivity", com.baidu.tbadk.core.util.UtilHelper.getTopActivityClassName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:779:0x15bf, code lost:
        if (r27.bVC == null) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:780:0x15c1, code lost:
        r6.append("requestUrl", r27.bVC.akc());
        r6.append("dnsMessage", r27.bVC.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:781:0x15dd, code lost:
        com.baidu.tbadk.core.util.s.d(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:782:0x15e0, code lost:
        if (r8 == null) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x15e2, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:811:0x1661, code lost:
        r27.bVI = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:815:0x166b, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:816:0x166e, code lost:
        r4 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:1074:0x1c94  */
    /* JADX WARN: Removed duplicated region for block: B:1077:0x1cd6  */
    /* JADX WARN: Removed duplicated region for block: B:1080:0x1d0b  */
    /* JADX WARN: Removed duplicated region for block: B:1091:0x1d4a  */
    /* JADX WARN: Removed duplicated region for block: B:1103:0x1d67  */
    /* JADX WARN: Removed duplicated region for block: B:1110:0x1d87  */
    /* JADX WARN: Removed duplicated region for block: B:1113:0x1d8e  */
    /* JADX WARN: Removed duplicated region for block: B:1190:0x1d2c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1229:0x124a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:722:0x1400 A[Catch: SocketException -> 0x0bf4, SocketTimeoutException -> 0x165e, HttpException -> 0x1668, all -> 0x1dea, Throwable -> 0x1dfb, IllegalStateException -> 0x1e02, IOException -> 0x1e0e, SSLException -> 0x1e16, TRY_ENTER, TryCatch #0 {all -> 0x1dea, blocks: (B:396:0x0bc2, B:398:0x0bcb, B:400:0x0bd4, B:402:0x0bd7, B:404:0x0beb, B:405:0x0bf3, B:408:0x0bf8, B:410:0x0bfe, B:412:0x0c1a, B:414:0x0c21, B:553:0x0fa9, B:555:0x0fb4, B:625:0x1180, B:627:0x119a, B:629:0x11a9, B:634:0x11b6, B:636:0x11df, B:637:0x11ec, B:639:0x11f5, B:641:0x120b, B:642:0x1211, B:644:0x1217, B:646:0x121b, B:648:0x1227, B:651:0x123c, B:722:0x1400, B:724:0x1404, B:734:0x143f, B:736:0x145a, B:738:0x1463, B:740:0x146d, B:811:0x1661, B:742:0x147c, B:744:0x1483, B:746:0x1491, B:749:0x14a0, B:751:0x14a9, B:753:0x14b6, B:755:0x14bc, B:913:0x17ea, B:985:0x19fa, B:341:0x09f0, B:281:0x07f2, B:221:0x0617, B:87:0x0268, B:808:0x163b, B:649:0x1235), top: B:1183:0x0bc2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String c;
        InputStream inputStream;
        byte[] bArr;
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean kd;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i2;
        boolean z11;
        boolean z12;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        int read;
        String obj;
        boolean z13;
        boolean z14;
        Header[] headers;
        byte[] bArr10 = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().bVu) {
                e.getInstance().init();
            }
        }
        boolean z16 = z15;
        if (i <= 0) {
            i = 5;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean z17 = false;
        int i3 = 0;
        while (true) {
            if (this.bVA || i3 >= i) {
                break;
            }
            this.bVK = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.bVB.a(dVar);
            dVar.AB = -1;
            InputStream inputStream2 = null;
            c = this.bVB.iu().c(dVar);
            try {
                dVar.AB = -2;
                long currentTimeMillis3 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    F(c, null, null);
                    if (z16) {
                        dVar.AC = e.getInstance().getCachedCdnIp(this.bVK);
                    }
                } else {
                    F(c, str, str2);
                    dVar.AC = str;
                }
                dVar.AB = -3;
            } catch (IllegalStateException e) {
                e = e;
                inputStream = null;
            } catch (SocketException e2) {
                e = e2;
            } catch (SocketTimeoutException e3) {
                e = e3;
                inputStream = null;
            } catch (SSLException e4) {
                e = e4;
                inputStream = null;
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
            } catch (HttpException e6) {
                e = e6;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.bVy == null) {
                throw new SocketException("network not available.");
            }
            if (this.bVA) {
                this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                if (this.bVD && this.bVC != null) {
                    this.bVC.iy(this.bVB.iv().AR);
                }
                if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                    com.baidu.adp.lib.stats.a iF = s.iF();
                    iF.append("netException", dVar.Az);
                    iF.append("Url", c);
                    iF.c("isNetAvailable", Boolean.valueOf(j.kc()));
                    iF.c("netType", Integer.valueOf(j.netType()));
                    iF.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                    iF.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                    iF.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    Object[] objArr = new Object[2];
                    objArr[0] = "isNetChanged";
                    objArr[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                    iF.c(objArr);
                    iF.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                    iF.append("currentActivity", UtilHelper.getTopActivityClassName());
                    if (this.bVC != null) {
                        iF.append("requestUrl", this.bVC.akc());
                        iF.append("dnsMessage", this.bVC.toString());
                    }
                    s.d(iF);
                }
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e7) {
                    }
                }
                ajT();
                this.bVB.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean kd2 = j.kd();
                    if ((kd2 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        if (kd2) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                        } else if (j.kh()) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                        } else {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                        }
                        e.getInstance().result(c, dVar.AC, false, z9, kd2);
                    }
                }
            } else {
                dVar.AB = -8;
                HttpResponse execute = bVG.execute(this.bVy);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.bVB.iv().responseCode = execute.getStatusLine().getStatusCode();
                dVar.AA = this.bVB.iv().responseCode;
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
                        bArr = bArr10;
                        th = th3;
                    }
                } catch (SocketException e8) {
                    e = e8;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e9) {
                    e = e9;
                } catch (SSLException e10) {
                    e = e10;
                } catch (IOException e11) {
                    e = e11;
                } catch (IllegalStateException e12) {
                    e = e12;
                } catch (HttpException e13) {
                    e = e13;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.bVB.iv().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.bVz < 1) {
                            ajT();
                            this.bVz++;
                            this.bVB.iv().responseCode = 0;
                            i3--;
                            this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                            if (this.bVD && this.bVC != null) {
                                this.bVC.iy(this.bVB.iv().AR);
                            }
                            if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                com.baidu.adp.lib.stats.a iF2 = s.iF();
                                iF2.append("netException", dVar.Az);
                                iF2.append("Url", c);
                                iF2.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                iF2.c("netType", Integer.valueOf(j.netType()));
                                iF2.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                iF2.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                iF2.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = "isNetChanged";
                                objArr2[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                iF2.c(objArr2);
                                iF2.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                iF2.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.bVC != null) {
                                    iF2.append("requestUrl", this.bVC.akc());
                                    iF2.append("dnsMessage", this.bVC.toString());
                                }
                                s.d(iF2);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            ajT();
                            this.bVB.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kd3 = j.kd();
                                if ((kd3 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kd3) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                    } else if (j.kh()) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                    } else {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                    }
                                    e.getInstance().result(c, dVar.AC, false, z14, kd3);
                                }
                            }
                            i3++;
                            bArr10 = bArr10;
                        } else {
                            this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                            if (this.bVD && this.bVC != null) {
                                this.bVC.iy(this.bVB.iv().AR);
                            }
                            if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                com.baidu.adp.lib.stats.a iF3 = s.iF();
                                iF3.append("netException", dVar.Az);
                                iF3.append("Url", c);
                                iF3.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                iF3.c("netType", Integer.valueOf(j.netType()));
                                iF3.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                iF3.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                iF3.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = "isNetChanged";
                                objArr3[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                iF3.c(objArr3);
                                iF3.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                iF3.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.bVC != null) {
                                    iF3.append("requestUrl", this.bVC.akc());
                                    iF3.append("dnsMessage", this.bVC.toString());
                                }
                                s.d(iF3);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            ajT();
                            this.bVB.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kd4 = j.kd();
                                if ((kd4 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kd4) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                    } else if (j.kh()) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                    } else {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                    }
                                    e.getInstance().result(c, dVar.AC, false, z13, kd4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > bSQ) {
                    this.bVB.iv().AR = -11;
                    dVar.Az = this.mContext.getResources().getString(R.string.data_too_big);
                    this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                    if (this.bVD && this.bVC != null) {
                        this.bVC.iy(this.bVB.iv().AR);
                    }
                    if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                        com.baidu.adp.lib.stats.a iF4 = s.iF();
                        iF4.append("netException", dVar.Az);
                        iF4.append("Url", c);
                        iF4.c("isNetAvailable", Boolean.valueOf(j.kc()));
                        iF4.c("netType", Integer.valueOf(j.netType()));
                        iF4.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                        iF4.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                        iF4.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = "isNetChanged";
                        objArr4[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                        iF4.c(objArr4);
                        iF4.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                        iF4.append("currentActivity", UtilHelper.getTopActivityClassName());
                        if (this.bVC != null) {
                            iF4.append("requestUrl", this.bVC.akc());
                            iF4.append("dnsMessage", this.bVC.toString());
                        }
                        s.d(iF4);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                        }
                    }
                    ajT();
                    this.bVB.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean kd5 = j.kd();
                        if ((kd5 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (kd5) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                            } else if (j.kh()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                            }
                            e.getInstance().result(c, dVar.AC, false, z10, kd5);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr11 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i4 = 0;
                boolean z18 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z18 = true;
                }
                if (z18) {
                    byte[] bArr12 = new byte[23];
                    int read2 = inputStream.read(bArr12, 0, 23);
                    if (!new String(bArr12, 0, bArr12.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                        byteArrayOutputStream.write(bArr12, 0, read2);
                        i4 = 0 + read2;
                    }
                }
                if (execute.getFirstHeader("Src-Content-Type") != null) {
                    if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                        this.mIsGif = true;
                        i2 = i4;
                        while (!this.bVA && i2 < bSQ && (read = inputStream.read(bArr11)) != -1) {
                            byteArrayOutputStream.write(bArr11, 0, read);
                            i2 = read + i2;
                        }
                        dVar.AB = -9;
                        if (this.bVA) {
                            if (i2 >= bSQ) {
                                this.bVB.iv().AR = -11;
                                dVar.Az = this.mContext.getResources().getString(R.string.data_too_big);
                                break;
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                if (entity.getContentEncoding() == null) {
                                    bArr10 = byteArray;
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
                            } catch (SocketException e17) {
                                bArr10 = bArr9;
                                e = e17;
                                inputStream2 = inputStream;
                                try {
                                    this.bVB.iv().AR = -12;
                                    dVar.Az = "errorCode:" + String.valueOf(this.bVB.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                    this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                                    if (this.bVD && this.bVC != null) {
                                        this.bVC.iy(this.bVB.iv().AR);
                                    }
                                    if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                        com.baidu.adp.lib.stats.a iF5 = s.iF();
                                        iF5.append("netException", dVar.Az);
                                        iF5.append("Url", c);
                                        iF5.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                        iF5.c("netType", Integer.valueOf(j.netType()));
                                        iF5.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        iF5.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                        iF5.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr5 = new Object[2];
                                        objArr5[0] = "isNetChanged";
                                        objArr5[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                        iF5.c(objArr5);
                                        iF5.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        iF5.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.bVC != null) {
                                            iF5.append("requestUrl", this.bVC.akc());
                                            iF5.append("dnsMessage", this.bVC.toString());
                                        }
                                        s.d(iF5);
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    ajT();
                                    this.bVB.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean kd6 = j.kd();
                                        if ((kd6 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (kd6) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                            } else if (j.kh()) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                            } else {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                            }
                                            e.getInstance().result(c, dVar.AC, false, z8, kd6);
                                        }
                                    }
                                    i3++;
                                    bArr10 = bArr10;
                                } catch (Throwable th5) {
                                    inputStream = inputStream2;
                                    bArr = bArr10;
                                    th = th5;
                                    this.bVD = 0 != 0 && k.rq(c) && j.jQ();
                                    if (this.bVD && this.bVC != null) {
                                        this.bVC.iy(this.bVB.iv().AR);
                                    }
                                    if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                        com.baidu.adp.lib.stats.a iF6 = s.iF();
                                        iF6.append("netException", dVar.Az);
                                        iF6.append("Url", c);
                                        iF6.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                        iF6.c("netType", Integer.valueOf(j.netType()));
                                        iF6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        iF6.c("downloadFileSize", Integer.valueOf(bArr != null ? bArr.length : 0));
                                        iF6.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr6 = new Object[2];
                                        objArr6[0] = "isNetChanged";
                                        objArr6[1] = Boolean.valueOf(j.kp() <= currentTimeMillis2);
                                        iF6.c(objArr6);
                                        iF6.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        iF6.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.bVC != null) {
                                            iF6.append("requestUrl", this.bVC.akc());
                                            iF6.append("dnsMessage", this.bVC.toString());
                                        }
                                        s.d(iF6);
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e19) {
                                        }
                                    }
                                    ajT();
                                    this.bVB.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        kd = j.kd();
                                        if ((kd ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!kd) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                            } else if (j.kh()) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                            } else {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                            }
                                            e.getInstance().result(c, dVar.AC, false, z7, kd);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e20) {
                                bArr10 = bArr8;
                                e = e20;
                                this.bVB.iv().AR = -19;
                                dVar.Az = "errorCode:" + String.valueOf(this.bVB.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                                if (this.bVD && this.bVC != null) {
                                    this.bVC.iy(this.bVB.iv().AR);
                                }
                                if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                    com.baidu.adp.lib.stats.a iF7 = s.iF();
                                    iF7.append("netException", dVar.Az);
                                    iF7.append("Url", c);
                                    iF7.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                    iF7.c("netType", Integer.valueOf(j.netType()));
                                    iF7.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    iF7.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    iF7.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr7 = new Object[2];
                                    objArr7[0] = "isNetChanged";
                                    objArr7[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                    iF7.c(objArr7);
                                    iF7.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    iF7.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.bVC != null) {
                                        iF7.append("requestUrl", this.bVC.akc());
                                        iF7.append("dnsMessage", this.bVC.toString());
                                    }
                                    s.d(iF7);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                ajT();
                                this.bVB.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd7 = j.kd();
                                    if ((kd7 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd7) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                        } else if (j.kh()) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                        } else {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z6, kd7);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (IllegalStateException e22) {
                                bArr10 = bArr7;
                                e = e22;
                                this.bVB.iv().AR = -19;
                                dVar.Az = "errorCode:" + String.valueOf(this.bVB.iv().AR) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                                if (this.bVD && this.bVC != null) {
                                    this.bVC.iy(this.bVB.iv().AR);
                                }
                                if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                    com.baidu.adp.lib.stats.a iF8 = s.iF();
                                    iF8.append("netException", dVar.Az);
                                    iF8.append("Url", c);
                                    iF8.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                    iF8.c("netType", Integer.valueOf(j.netType()));
                                    iF8.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    iF8.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    iF8.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr8 = new Object[2];
                                    objArr8[0] = "isNetChanged";
                                    objArr8[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                    iF8.c(objArr8);
                                    iF8.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    iF8.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.bVC != null) {
                                        iF8.append("requestUrl", this.bVC.akc());
                                        iF8.append("dnsMessage", this.bVC.toString());
                                    }
                                    s.d(iF8);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                ajT();
                                this.bVB.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd8 = j.kd();
                                    if ((kd8 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd8) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                        } else if (j.kh()) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                        } else {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z5, kd8);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SocketTimeoutException e24) {
                                bArr10 = bArr6;
                                e = e24;
                                this.bVB.iv().AR = -13;
                                dVar.Az = "errorCode:" + String.valueOf(this.bVB.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                                if (this.bVD && this.bVC != null) {
                                    this.bVC.iy(this.bVB.iv().AR);
                                }
                                if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                    com.baidu.adp.lib.stats.a iF9 = s.iF();
                                    iF9.append("netException", dVar.Az);
                                    iF9.append("Url", c);
                                    iF9.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                    iF9.c("netType", Integer.valueOf(j.netType()));
                                    iF9.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    iF9.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    iF9.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr9 = new Object[2];
                                    objArr9[0] = "isNetChanged";
                                    objArr9[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                    iF9.c(objArr9);
                                    iF9.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    iF9.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.bVC != null) {
                                        iF9.append("requestUrl", this.bVC.akc());
                                        iF9.append("dnsMessage", this.bVC.toString());
                                    }
                                    s.d(iF9);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                ajT();
                                this.bVB.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd9 = j.kd();
                                    if ((kd9 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd9) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                        } else if (j.kh()) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                        } else {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z4, kd9);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SSLException e26) {
                                bArr10 = bArr5;
                                e = e26;
                                this.bVB.iv().AR = -20;
                                dVar.Az = "errorCode:" + String.valueOf(this.bVB.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                this.bVE = true;
                                this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                                if (this.bVD && this.bVC != null) {
                                    this.bVC.iy(this.bVB.iv().AR);
                                }
                                if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                    com.baidu.adp.lib.stats.a iF10 = s.iF();
                                    iF10.append("netException", dVar.Az);
                                    iF10.append("Url", c);
                                    iF10.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                    iF10.c("netType", Integer.valueOf(j.netType()));
                                    iF10.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    iF10.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    iF10.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr10 = new Object[2];
                                    objArr10[0] = "isNetChanged";
                                    objArr10[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                    iF10.c(objArr10);
                                    iF10.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    iF10.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.bVC != null) {
                                        iF10.append("requestUrl", this.bVC.akc());
                                        iF10.append("dnsMessage", this.bVC.toString());
                                    }
                                    s.d(iF10);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e27) {
                                    }
                                }
                                ajT();
                                this.bVB.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd10 = j.kd();
                                    if ((kd10 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd10) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                        } else if (j.kh()) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                        } else {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z3, kd10);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (HttpException e28) {
                                bArr10 = bArr4;
                                e = e28;
                                this.bVB.iv().AR = -18;
                                dVar.Az = "errorCode:" + String.valueOf(this.bVB.iv().AR) + "|" + e.getClass() + "|" + e.getMessage();
                                this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                                if (this.bVD && this.bVC != null) {
                                    this.bVC.iy(this.bVB.iv().AR);
                                }
                                if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                    com.baidu.adp.lib.stats.a iF11 = s.iF();
                                    iF11.append("netException", dVar.Az);
                                    iF11.append("Url", c);
                                    iF11.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                    iF11.c("netType", Integer.valueOf(j.netType()));
                                    iF11.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    iF11.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    iF11.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr11 = new Object[2];
                                    objArr11[0] = "isNetChanged";
                                    objArr11[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                    iF11.c(objArr11);
                                    iF11.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    iF11.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.bVC != null) {
                                        iF11.append("requestUrl", this.bVC.akc());
                                        iF11.append("dnsMessage", this.bVC.toString());
                                    }
                                    s.d(iF11);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e29) {
                                    }
                                }
                                ajT();
                                this.bVB.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd11 = j.kd();
                                    if ((kd11 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                        long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd11) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                        } else if (j.kh()) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                        } else {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z2, kd11);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (Throwable th6) {
                                bArr10 = bArr2;
                                th = th6;
                                this.bVB.iv().AR = -10;
                                dVar.Az = "errorCode:" + String.valueOf(this.bVB.iv().AR) + "|" + th.getClass() + "|" + th.getMessage();
                                this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                                if (this.bVD && this.bVC != null) {
                                    this.bVC.iy(this.bVB.iv().AR);
                                }
                                if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                    com.baidu.adp.lib.stats.a iF12 = s.iF();
                                    iF12.append("netException", dVar.Az);
                                    iF12.append("Url", c);
                                    iF12.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                    iF12.c("netType", Integer.valueOf(j.netType()));
                                    iF12.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    iF12.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    iF12.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr12 = new Object[2];
                                    objArr12[0] = "isNetChanged";
                                    objArr12[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                    iF12.c(objArr12);
                                    iF12.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    iF12.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.bVC != null) {
                                        iF12.append("requestUrl", this.bVC.akc());
                                        iF12.append("dnsMessage", this.bVC.toString());
                                    }
                                    s.d(iF12);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e30) {
                                    }
                                }
                                ajT();
                                this.bVB.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean kd12 = j.kd();
                                    if ((kd12 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                        long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                                        if (kd12) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                        } else if (j.kh()) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                        } else {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                        }
                                        e.getInstance().result(c, dVar.AC, false, z, kd12);
                                    }
                                }
                                this.bVz = 0;
                                this.bVB.iv().AU = bArr10;
                            }
                        } else {
                            this.bVD = 0 == 0 && k.rq(c) && j.jQ();
                            if (this.bVD && this.bVC != null) {
                                this.bVC.iy(this.bVB.iv().AR);
                            }
                            if (0 == 0 && i3 == i - 1 && k.rq(c)) {
                                com.baidu.adp.lib.stats.a iF13 = s.iF();
                                iF13.append("netException", dVar.Az);
                                iF13.append("Url", c);
                                iF13.c("isNetAvailable", Boolean.valueOf(j.kc()));
                                iF13.c("netType", Integer.valueOf(j.netType()));
                                iF13.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                iF13.c("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                iF13.c("cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr13 = new Object[2];
                                objArr13[0] = "isNetChanged";
                                objArr13[1] = Boolean.valueOf(j.kp() > currentTimeMillis2);
                                iF13.c(objArr13);
                                iF13.c("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                iF13.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.bVC != null) {
                                    iF13.append("requestUrl", this.bVC.akc());
                                    iF13.append("dnsMessage", this.bVC.toString());
                                }
                                s.d(iF13);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e31) {
                                }
                            }
                            ajT();
                            this.bVB.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean kd13 = j.kd();
                                if ((kd13 ? (dVar.AC == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.ro(c) && z16) {
                                    long currentTimeMillis16 = System.currentTimeMillis() - currentTimeMillis;
                                    if (kd13) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                                    } else if (j.kh()) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                                    } else {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                                    }
                                    e.getInstance().result(c, dVar.AC, false, z11, kd13);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.bVA) {
                    byteArrayOutputStream.write(bArr11, 0, read);
                    i2 = read + i2;
                }
                dVar.AB = -9;
                if (this.bVA) {
                }
            }
        }
        ajT();
        this.bVB.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean kd14 = j.kd();
            if ((kd14 ? dVar.AC != null || z17 || i3 >= i + (-1) : true) && k.ro(c) && z16) {
                long currentTimeMillis17 = System.currentTimeMillis() - currentTimeMillis;
                if (kd14) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().bCZ);
                } else if (j.kh()) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().bDb);
                } else {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().bDa);
                }
                e.getInstance().result(c, dVar.AC, z17, z12, kd14);
            }
        }
        this.bVz = 0;
        this.bVB.iv().AU = bArr10;
    }

    private void ox(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(bVL) && (System.currentTimeMillis() - bVN) - (1800000 * (bVM / 3)) >= 0) {
            bVM++;
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
                bVL = str;
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

    public boolean ajU() {
        return this.bVI;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        ik();
    }
}
