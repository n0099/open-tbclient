package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidubce.services.bos.BosClientConfiguration;
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
import org.apache.http.protocol.HttpContext;
/* loaded from: classes2.dex */
public class f implements a.InterfaceC0019a {
    private static HttpClient elI;
    private static String elN;
    private static int elO;
    private static long elP;
    public static String proxyHost;
    private HttpGet elB;
    private final com.baidu.adp.lib.network.http.e elE;
    public boolean elL;
    private final Context mContext;
    private static int ejT = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
    private static volatile String elz = null;
    private static volatile boolean elA = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams elJ = new BasicHttpParams();
    private com.baidu.adp.lib.network.http.a.c elF = null;
    private boolean elG = false;
    private boolean elH = false;
    private boolean mIsGif = false;
    private boolean elK = false;
    private int elM = 0;
    private int elC = 0;
    private volatile boolean elD = false;

    static {
        HttpConnectionParams.setConnectionTimeout(elJ, 5000);
        HttpConnectionParams.setSoTimeout(elJ, 30000);
        HttpConnectionParams.setSocketBufferSize(elJ, 1024);
        HttpConnectionParams.setTcpNoDelay(elJ, true);
        HttpClientParams.setRedirecting(elJ, true);
        ConnManagerParams.setMaxConnectionsPerRoute(elJ, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(elJ, 10000L);
        ConnManagerParams.setMaxTotalConnections(elJ, 15);
        HttpProtocolParams.setUserAgent(elJ, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), Constants.SOCKET_PORT_SSL));
        elI = new DefaultHttpClient(new ThreadSafeClientConnManager(elJ, schemeRegistry), elJ);
        ((DefaultHttpClient) elI).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        elN = null;
        elO = 0;
        elP = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        bjA();
        this.elE = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void bjA() {
        synchronized (f.class) {
            if (!elA) {
                elA = true;
                bjB();
            }
        }
    }

    public static synchronized void bjB() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    elz = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void cancelNetConnect() {
        this.elD = true;
        this.elE.mt().LJ = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.elB != null) {
                this.elB.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ac(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().elx) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.isNetWorkAvailable()) {
            this.elL = false;
            try {
                if (j.isMobileNet()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (proxyHost == null) {
                            proxyHost = j.curMobileProxyHost();
                        }
                        if (proxyHost != null && proxyHost.length() > 0) {
                            this.elL = true;
                            if (Al(proxyHost) && j.isSupportWap()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(proxyHost);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.elB = e.getInstance().httpGetFactory(sb.toString(), this.elM, false);
                                    } else {
                                        this.elB = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.elB = new HttpGet(sb.toString());
                                }
                                this.elB.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.elB.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = elJ.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    elJ.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(proxyHost) || httpHost.getPort() != j.curMobileProxyPort()) {
                                        elJ.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.elB = e.getInstance().httpGetFactory(str, this.elM, false);
                                    } else {
                                        this.elB = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.elB = new HttpGet(str);
                                }
                                if (elz != null) {
                                    this.elB.setHeader(AUTH.PROXY_AUTH_RESP, elz);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.elB.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (m.CG(str)) {
                    String host = com.baidu.adp.lib.network.http.a.d.getHost(str);
                    this.elF = com.baidu.adp.lib.network.http.a.b.mC().bJ(host);
                    if (!at.isEmpty(this.elF.mG())) {
                        this.elB = ad(str, this.elF.mG(), host);
                    } else if (this.elG) {
                        this.elF = com.baidu.adp.lib.network.http.a.b.mC().x(host, null);
                        this.elB = ad(str, this.elF.mG(), host);
                    } else {
                        this.elB = new HttpGet(str);
                    }
                } else if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.isMobileNet()) {
                            if (!this.elL || this.elB == null) {
                                this.elB = e.getInstance().httpGetFactory(str, this.elM, false);
                            }
                        } else {
                            this.elB = e.getInstance().httpGetFactory(str, this.elM, true);
                        }
                    } else {
                        this.elB = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.elB = new HttpGet(str);
                }
                this.elB.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private HttpGet ad(String str, String str2, String str3) {
        if (this.elH && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://" + str.substring(8);
        }
        if (this.elF != null && !at.isEmpty(this.elF.mG())) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String str4 = url.getProtocol() + "://" + str2 + url.getPath();
                HttpGet httpGet = new HttpGet(str4);
                this.elF.bK(str4);
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return new HttpGet(str);
    }

    private boolean Al(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [609=29, 610=14, 611=14, 613=14, 614=14, 615=14, 616=14, 617=14, 618=14, 619=14, 620=14, 621=14, 622=14, 624=14, 625=14, 626=28, 627=14, 628=14, 629=14, 630=14, 631=14, 633=14, 636=14, 637=14, 641=14, 646=14, 647=14, 648=14, 649=14, 650=14, 651=28, 653=14, 654=14, 655=14, 657=14, 658=28, 659=14, 660=14, 662=14, 664=14, 668=7] */
    /* JADX WARN: Code restructure failed: missing block: B:732:0x143a, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:734:0x143e, code lost:
        r13.downloadSize = r6;
        r13.retry = r10 + 1;
        r13.Lg = java.lang.System.currentTimeMillis() - r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:735:0x1457, code lost:
        if (r9.getFirstHeader("Error-Message") == null) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:736:0x1459, code lost:
        r4 = r9.getFirstHeader("Error-Message");
     */
    /* JADX WARN: Code restructure failed: missing block: B:737:0x1460, code lost:
        if (r4 == null) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:739:0x146a, code lost:
        if (android.text.TextUtils.isEmpty(r4.getValue()) != false) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:741:0x1479, code lost:
        if (r4.getValue().equalsIgnoreCase("OK") == false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:742:0x147b, code lost:
        r27.elK = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x1480, code lost:
        if (r6 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x148e, code lost:
        if (r27.elE.mt().responseCode == 200) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x149c, code lost:
        if (r27.elE.mt().responseCode != 302) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:748:0x149e, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:750:0x14a6, code lost:
        if (r9.getFirstHeader("ginfo") == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:751:0x14a8, code lost:
        r4 = r9.getFirstHeader("ginfo").getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:752:0x14b3, code lost:
        if (r4 == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:754:0x14b9, code lost:
        if (r4.length() <= 0) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:755:0x14bb, code lost:
        Am(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:756:0x14c0, code lost:
        if (r7 != false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:758:0x14c6, code lost:
        if (com.baidu.tbadk.util.m.CG(r5) == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:760:0x14cc, code lost:
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:761:0x14ce, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:762:0x14cf, code lost:
        r27.elG = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:763:0x14d7, code lost:
        if (r27.elG == false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x14dd, code lost:
        if (r27.elF == null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:766:0x14df, code lost:
        r27.elF.ap(r27.elE.mt().mNetErrorCode);
     */
    /* JADX WARN: Code restructure failed: missing block: B:767:0x14f0, code lost:
        if (r7 != false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:769:0x14f4, code lost:
        if (r10 != (r30 - 1)) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:771:0x14fa, code lost:
        if (com.baidu.tbadk.util.m.CG(r5) == false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:772:0x14fc, code lost:
        r6 = com.baidu.tbadk.core.util.u.mN();
        r6.append("netException", r13.exception);
        r6.append("Url", r5);
        r6.append("isNetAvailable", java.lang.Boolean.valueOf(com.baidu.adp.lib.util.j.isNetWorkAvailable()));
        r6.append("netType", java.lang.Integer.valueOf(com.baidu.adp.lib.util.j.netType()));
        r6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:773:0x1547, code lost:
        if (r11 == null) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:774:0x1549, code lost:
        r4 = r11.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:775:0x154a, code lost:
        r6.append("downloadFileSize", java.lang.Integer.valueOf(r4));
        r6.append(com.baidu.live.adp.lib.stats.BdStatsConstant.StatsKey.COST, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - r14));
        r9 = new java.lang.Object[2];
        r9[0] = "isNetChanged";
     */
    /* JADX WARN: Code restructure failed: missing block: B:776:0x1589, code lost:
        if (com.baidu.adp.lib.util.j.getNetChangedTime() <= r14) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:777:0x158b, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:778:0x158c, code lost:
        r9[1] = java.lang.Boolean.valueOf(r4);
        r6.append(r9);
        r6.append("isBackground", java.lang.Boolean.valueOf(com.baidu.tbadk.core.TbadkCoreApplication.getInst().isInBackground()));
        r6.append("currentActivity", com.baidu.tbadk.core.util.UtilHelper.getTopActivityClassName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:779:0x15be, code lost:
        if (r27.elF == null) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:780:0x15c0, code lost:
        r6.append("requestUrl", r27.elF.mF());
        r6.append("dnsMessage", r27.elF.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:781:0x15dc, code lost:
        com.baidu.tbadk.core.util.u.e(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:782:0x15df, code lost:
        if (r8 == null) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x15e1, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:811:0x165f, code lost:
        r27.elK = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:815:0x1669, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:816:0x166c, code lost:
        r4 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:1074:0x1c92  */
    /* JADX WARN: Removed duplicated region for block: B:1077:0x1cd4  */
    /* JADX WARN: Removed duplicated region for block: B:1080:0x1d09  */
    /* JADX WARN: Removed duplicated region for block: B:1091:0x1d48  */
    /* JADX WARN: Removed duplicated region for block: B:1103:0x1d65  */
    /* JADX WARN: Removed duplicated region for block: B:1110:0x1d85  */
    /* JADX WARN: Removed duplicated region for block: B:1113:0x1d8c  */
    /* JADX WARN: Removed duplicated region for block: B:1192:0x1d2a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1229:0x1249 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:722:0x13ff A[Catch: SocketException -> 0x0bf4, SocketTimeoutException -> 0x165c, HttpException -> 0x1666, all -> 0x1de8, Throwable -> 0x1df9, IllegalStateException -> 0x1e00, IOException -> 0x1e0c, SSLException -> 0x1e14, TRY_ENTER, TryCatch #0 {all -> 0x1de8, blocks: (B:396:0x0bc2, B:398:0x0bcb, B:400:0x0bd4, B:402:0x0bd7, B:404:0x0beb, B:405:0x0bf3, B:408:0x0bf8, B:410:0x0bfe, B:412:0x0c1a, B:414:0x0c21, B:553:0x0fa9, B:555:0x0fb4, B:625:0x117f, B:627:0x1199, B:629:0x11a8, B:634:0x11b5, B:636:0x11de, B:637:0x11eb, B:639:0x11f4, B:641:0x120a, B:642:0x1210, B:644:0x1216, B:646:0x121a, B:648:0x1226, B:651:0x123b, B:722:0x13ff, B:724:0x1403, B:734:0x143e, B:736:0x1459, B:738:0x1462, B:740:0x146c, B:811:0x165f, B:742:0x147b, B:744:0x1482, B:746:0x1490, B:749:0x149f, B:751:0x14a8, B:753:0x14b5, B:755:0x14bb, B:913:0x17e8, B:985:0x19f8, B:341:0x09f0, B:281:0x07f2, B:221:0x0617, B:87:0x0268, B:808:0x163a, B:649:0x1234), top: B:1183:0x0bc2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(String str, String str2, int i) {
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
        boolean isWifiNet;
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
            if (!e.getInstance().elx) {
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
            if (this.elD || i3 >= i) {
                break;
            }
            this.elM = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.elE.a(dVar);
            dVar.Lj = -1;
            InputStream inputStream2 = null;
            c = this.elE.ms().c(dVar);
            try {
                dVar.Lj = -2;
                long currentTimeMillis3 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    ac(c, null, null);
                    if (z16) {
                        dVar.Lk = e.getInstance().getCachedCdnIp(this.elM);
                    }
                } else {
                    ac(c, str, str2);
                    dVar.Lk = str;
                }
                dVar.Lj = -3;
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
            if (this.elB == null) {
                throw new SocketException("network not available.");
            }
            if (this.elD) {
                this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                if (this.elG && this.elF != null) {
                    this.elF.ap(this.elE.mt().mNetErrorCode);
                }
                if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                    com.baidu.adp.lib.stats.a mN = u.mN();
                    mN.append("netException", dVar.exception);
                    mN.append("Url", c);
                    mN.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                    mN.append("netType", Integer.valueOf(j.netType()));
                    mN.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                    mN.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                    mN.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    Object[] objArr = new Object[2];
                    objArr[0] = "isNetChanged";
                    objArr[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                    mN.append(objArr);
                    mN.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                    mN.append("currentActivity", UtilHelper.getTopActivityClassName());
                    if (this.elF != null) {
                        mN.append("requestUrl", this.elF.mF());
                        mN.append("dnsMessage", this.elF.toString());
                    }
                    u.e(mN);
                }
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e7) {
                    }
                }
                closeConnection();
                this.elE.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean isWifiNet2 = j.isWifiNet();
                    if ((isWifiNet2 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        if (isWifiNet2) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                        } else if (j.is2GNet()) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                        } else {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                        }
                        e.getInstance().result(c, dVar.Lk, false, z9, isWifiNet2);
                    }
                }
            } else {
                dVar.Lj = -8;
                HttpResponse execute = elI.execute(this.elB);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.elE.mt().responseCode = execute.getStatusLine().getStatusCode();
                dVar.Li = this.elE.mt().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.Lq = headers[0].getValue();
                            dVar.Lr = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        bArr = bArr10;
                        th = th3;
                    }
                } catch (IllegalStateException e8) {
                    e = e8;
                } catch (SocketException e9) {
                    e = e9;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                } catch (SSLException e11) {
                    e = e11;
                } catch (IOException e12) {
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
                    this.elE.mt().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.elC < 1) {
                            closeConnection();
                            this.elC++;
                            this.elE.mt().responseCode = 0;
                            i3--;
                            this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                            if (this.elG && this.elF != null) {
                                this.elF.ap(this.elE.mt().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                com.baidu.adp.lib.stats.a mN2 = u.mN();
                                mN2.append("netException", dVar.exception);
                                mN2.append("Url", c);
                                mN2.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                mN2.append("netType", Integer.valueOf(j.netType()));
                                mN2.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                mN2.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                mN2.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = "isNetChanged";
                                objArr2[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                mN2.append(objArr2);
                                mN2.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                mN2.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.elF != null) {
                                    mN2.append("requestUrl", this.elF.mF());
                                    mN2.append("dnsMessage", this.elF.toString());
                                }
                                u.e(mN2);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            closeConnection();
                            this.elE.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet3 = j.isWifiNet();
                                if ((isWifiNet3 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet3) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                    } else if (j.is2GNet()) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                    } else {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                    }
                                    e.getInstance().result(c, dVar.Lk, false, z14, isWifiNet3);
                                }
                            }
                            i3++;
                            bArr10 = bArr10;
                        } else {
                            this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                            if (this.elG && this.elF != null) {
                                this.elF.ap(this.elE.mt().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                com.baidu.adp.lib.stats.a mN3 = u.mN();
                                mN3.append("netException", dVar.exception);
                                mN3.append("Url", c);
                                mN3.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                mN3.append("netType", Integer.valueOf(j.netType()));
                                mN3.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                mN3.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                mN3.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = "isNetChanged";
                                objArr3[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                mN3.append(objArr3);
                                mN3.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                mN3.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.elF != null) {
                                    mN3.append("requestUrl", this.elF.mF());
                                    mN3.append("dnsMessage", this.elF.toString());
                                }
                                u.e(mN3);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            closeConnection();
                            this.elE.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet4 = j.isWifiNet();
                                if ((isWifiNet4 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet4) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                    } else if (j.is2GNet()) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                    } else {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                    }
                                    e.getInstance().result(c, dVar.Lk, false, z13, isWifiNet4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > ejT) {
                    this.elE.mt().mNetErrorCode = -11;
                    dVar.exception = this.mContext.getResources().getString(R.string.data_too_big);
                    this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                    if (this.elG && this.elF != null) {
                        this.elF.ap(this.elE.mt().mNetErrorCode);
                    }
                    if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                        com.baidu.adp.lib.stats.a mN4 = u.mN();
                        mN4.append("netException", dVar.exception);
                        mN4.append("Url", c);
                        mN4.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                        mN4.append("netType", Integer.valueOf(j.netType()));
                        mN4.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                        mN4.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                        mN4.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = "isNetChanged";
                        objArr4[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                        mN4.append(objArr4);
                        mN4.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                        mN4.append("currentActivity", UtilHelper.getTopActivityClassName());
                        if (this.elF != null) {
                            mN4.append("requestUrl", this.elF.mF());
                            mN4.append("dnsMessage", this.elF.toString());
                        }
                        u.e(mN4);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                        }
                    }
                    closeConnection();
                    this.elE.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean isWifiNet5 = j.isWifiNet();
                        if ((isWifiNet5 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (isWifiNet5) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                            } else if (j.is2GNet()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                            }
                            e.getInstance().result(c, dVar.Lk, false, z10, isWifiNet5);
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
                        while (!this.elD && i2 < ejT && (read = inputStream.read(bArr11)) != -1) {
                            byteArrayOutputStream.write(bArr11, 0, read);
                            i2 = read + i2;
                        }
                        dVar.Lj = -9;
                        if (this.elD) {
                            if (i2 >= ejT) {
                                this.elE.mt().mNetErrorCode = -11;
                                dVar.exception = this.mContext.getResources().getString(R.string.data_too_big);
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
                                com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream2);
                                byteArray = byteArrayOutputStream2.toByteArray();
                                break;
                            } catch (SocketException e17) {
                                bArr10 = bArr9;
                                e = e17;
                                inputStream2 = inputStream;
                                try {
                                    this.elE.mt().mNetErrorCode = -12;
                                    dVar.exception = "errorCode:" + String.valueOf(this.elE.mt().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                    this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                                    if (this.elG && this.elF != null) {
                                        this.elF.ap(this.elE.mt().mNetErrorCode);
                                    }
                                    if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                        com.baidu.adp.lib.stats.a mN5 = u.mN();
                                        mN5.append("netException", dVar.exception);
                                        mN5.append("Url", c);
                                        mN5.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                        mN5.append("netType", Integer.valueOf(j.netType()));
                                        mN5.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        mN5.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                        mN5.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr5 = new Object[2];
                                        objArr5[0] = "isNetChanged";
                                        objArr5[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                        mN5.append(objArr5);
                                        mN5.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        mN5.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.elF != null) {
                                            mN5.append("requestUrl", this.elF.mF());
                                            mN5.append("dnsMessage", this.elF.toString());
                                        }
                                        u.e(mN5);
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    closeConnection();
                                    this.elE.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean isWifiNet6 = j.isWifiNet();
                                        if ((isWifiNet6 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (isWifiNet6) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                            } else if (j.is2GNet()) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                            } else {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                            }
                                            e.getInstance().result(c, dVar.Lk, false, z8, isWifiNet6);
                                        }
                                    }
                                    i3++;
                                    bArr10 = bArr10;
                                } catch (Throwable th5) {
                                    inputStream = inputStream2;
                                    bArr = bArr10;
                                    th = th5;
                                    this.elG = 0 != 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                                    if (this.elG && this.elF != null) {
                                        this.elF.ap(this.elE.mt().mNetErrorCode);
                                    }
                                    if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                        com.baidu.adp.lib.stats.a mN6 = u.mN();
                                        mN6.append("netException", dVar.exception);
                                        mN6.append("Url", c);
                                        mN6.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                        mN6.append("netType", Integer.valueOf(j.netType()));
                                        mN6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        mN6.append("downloadFileSize", Integer.valueOf(bArr != null ? bArr.length : 0));
                                        mN6.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr6 = new Object[2];
                                        objArr6[0] = "isNetChanged";
                                        objArr6[1] = Boolean.valueOf(j.getNetChangedTime() <= currentTimeMillis2);
                                        mN6.append(objArr6);
                                        mN6.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        mN6.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.elF != null) {
                                            mN6.append("requestUrl", this.elF.mF());
                                            mN6.append("dnsMessage", this.elF.toString());
                                        }
                                        u.e(mN6);
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e19) {
                                        }
                                    }
                                    closeConnection();
                                    this.elE.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        isWifiNet = j.isWifiNet();
                                        if ((isWifiNet ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!isWifiNet) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                            } else if (j.is2GNet()) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                            } else {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                            }
                                            e.getInstance().result(c, dVar.Lk, false, z7, isWifiNet);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e20) {
                                bArr10 = bArr8;
                                e = e20;
                                this.elE.mt().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.elE.mt().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                                if (this.elG && this.elF != null) {
                                    this.elF.ap(this.elE.mt().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                    com.baidu.adp.lib.stats.a mN7 = u.mN();
                                    mN7.append("netException", dVar.exception);
                                    mN7.append("Url", c);
                                    mN7.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mN7.append("netType", Integer.valueOf(j.netType()));
                                    mN7.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mN7.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mN7.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr7 = new Object[2];
                                    objArr7[0] = "isNetChanged";
                                    objArr7[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mN7.append(objArr7);
                                    mN7.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mN7.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.elF != null) {
                                        mN7.append("requestUrl", this.elF.mF());
                                        mN7.append("dnsMessage", this.elF.toString());
                                    }
                                    u.e(mN7);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                closeConnection();
                                this.elE.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet7 = j.isWifiNet();
                                    if ((isWifiNet7 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet7) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                        } else if (j.is2GNet()) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                        } else {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                        }
                                        e.getInstance().result(c, dVar.Lk, false, z6, isWifiNet7);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (IllegalStateException e22) {
                                bArr10 = bArr7;
                                e = e22;
                                this.elE.mt().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.elE.mt().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                                if (this.elG && this.elF != null) {
                                    this.elF.ap(this.elE.mt().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                    com.baidu.adp.lib.stats.a mN8 = u.mN();
                                    mN8.append("netException", dVar.exception);
                                    mN8.append("Url", c);
                                    mN8.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mN8.append("netType", Integer.valueOf(j.netType()));
                                    mN8.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mN8.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mN8.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr8 = new Object[2];
                                    objArr8[0] = "isNetChanged";
                                    objArr8[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mN8.append(objArr8);
                                    mN8.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mN8.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.elF != null) {
                                        mN8.append("requestUrl", this.elF.mF());
                                        mN8.append("dnsMessage", this.elF.toString());
                                    }
                                    u.e(mN8);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                closeConnection();
                                this.elE.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet8 = j.isWifiNet();
                                    if ((isWifiNet8 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet8) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                        } else if (j.is2GNet()) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                        } else {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                        }
                                        e.getInstance().result(c, dVar.Lk, false, z5, isWifiNet8);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SocketTimeoutException e24) {
                                bArr10 = bArr6;
                                e = e24;
                                this.elE.mt().mNetErrorCode = -13;
                                dVar.exception = "errorCode:" + String.valueOf(this.elE.mt().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                                if (this.elG && this.elF != null) {
                                    this.elF.ap(this.elE.mt().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                    com.baidu.adp.lib.stats.a mN9 = u.mN();
                                    mN9.append("netException", dVar.exception);
                                    mN9.append("Url", c);
                                    mN9.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mN9.append("netType", Integer.valueOf(j.netType()));
                                    mN9.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mN9.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mN9.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr9 = new Object[2];
                                    objArr9[0] = "isNetChanged";
                                    objArr9[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mN9.append(objArr9);
                                    mN9.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mN9.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.elF != null) {
                                        mN9.append("requestUrl", this.elF.mF());
                                        mN9.append("dnsMessage", this.elF.toString());
                                    }
                                    u.e(mN9);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                closeConnection();
                                this.elE.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet9 = j.isWifiNet();
                                    if ((isWifiNet9 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet9) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                        } else if (j.is2GNet()) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                        } else {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                        }
                                        e.getInstance().result(c, dVar.Lk, false, z4, isWifiNet9);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SSLException e26) {
                                bArr10 = bArr5;
                                e = e26;
                                this.elE.mt().mNetErrorCode = -20;
                                dVar.exception = "errorCode:" + String.valueOf(this.elE.mt().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.elH = true;
                                this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                                if (this.elG && this.elF != null) {
                                    this.elF.ap(this.elE.mt().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                    com.baidu.adp.lib.stats.a mN10 = u.mN();
                                    mN10.append("netException", dVar.exception);
                                    mN10.append("Url", c);
                                    mN10.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mN10.append("netType", Integer.valueOf(j.netType()));
                                    mN10.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mN10.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mN10.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr10 = new Object[2];
                                    objArr10[0] = "isNetChanged";
                                    objArr10[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mN10.append(objArr10);
                                    mN10.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mN10.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.elF != null) {
                                        mN10.append("requestUrl", this.elF.mF());
                                        mN10.append("dnsMessage", this.elF.toString());
                                    }
                                    u.e(mN10);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e27) {
                                    }
                                }
                                closeConnection();
                                this.elE.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet10 = j.isWifiNet();
                                    if ((isWifiNet10 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet10) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                        } else if (j.is2GNet()) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                        } else {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                        }
                                        e.getInstance().result(c, dVar.Lk, false, z3, isWifiNet10);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (HttpException e28) {
                                bArr10 = bArr4;
                                e = e28;
                                this.elE.mt().mNetErrorCode = -18;
                                dVar.exception = "errorCode:" + String.valueOf(this.elE.mt().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                                if (this.elG && this.elF != null) {
                                    this.elF.ap(this.elE.mt().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                    com.baidu.adp.lib.stats.a mN11 = u.mN();
                                    mN11.append("netException", dVar.exception);
                                    mN11.append("Url", c);
                                    mN11.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mN11.append("netType", Integer.valueOf(j.netType()));
                                    mN11.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mN11.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mN11.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr11 = new Object[2];
                                    objArr11[0] = "isNetChanged";
                                    objArr11[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mN11.append(objArr11);
                                    mN11.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mN11.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.elF != null) {
                                        mN11.append("requestUrl", this.elF.mF());
                                        mN11.append("dnsMessage", this.elF.toString());
                                    }
                                    u.e(mN11);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e29) {
                                    }
                                }
                                closeConnection();
                                this.elE.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet11 = j.isWifiNet();
                                    if ((isWifiNet11 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet11) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                        } else if (j.is2GNet()) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                        } else {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                        }
                                        e.getInstance().result(c, dVar.Lk, false, z2, isWifiNet11);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (Throwable th6) {
                                bArr10 = bArr2;
                                th = th6;
                                this.elE.mt().mNetErrorCode = -10;
                                dVar.exception = "errorCode:" + String.valueOf(this.elE.mt().mNetErrorCode) + "|" + th.getClass() + "|" + th.getMessage();
                                this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                                if (this.elG && this.elF != null) {
                                    this.elF.ap(this.elE.mt().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                    com.baidu.adp.lib.stats.a mN12 = u.mN();
                                    mN12.append("netException", dVar.exception);
                                    mN12.append("Url", c);
                                    mN12.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mN12.append("netType", Integer.valueOf(j.netType()));
                                    mN12.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mN12.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mN12.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr12 = new Object[2];
                                    objArr12[0] = "isNetChanged";
                                    objArr12[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mN12.append(objArr12);
                                    mN12.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mN12.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.elF != null) {
                                        mN12.append("requestUrl", this.elF.mF());
                                        mN12.append("dnsMessage", this.elF.toString());
                                    }
                                    u.e(mN12);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e30) {
                                    }
                                }
                                closeConnection();
                                this.elE.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet12 = j.isWifiNet();
                                    if ((isWifiNet12 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet12) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                        } else if (j.is2GNet()) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                        } else {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                        }
                                        e.getInstance().result(c, dVar.Lk, false, z, isWifiNet12);
                                    }
                                }
                                this.elC = 0;
                                this.elE.mt().retBytes = bArr10;
                            }
                        } else {
                            this.elG = 0 == 0 && m.CG(c) && j.isNetworkAvailableForImmediately();
                            if (this.elG && this.elF != null) {
                                this.elF.ap(this.elE.mt().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.CG(c)) {
                                com.baidu.adp.lib.stats.a mN13 = u.mN();
                                mN13.append("netException", dVar.exception);
                                mN13.append("Url", c);
                                mN13.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                mN13.append("netType", Integer.valueOf(j.netType()));
                                mN13.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                mN13.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                mN13.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr13 = new Object[2];
                                objArr13[0] = "isNetChanged";
                                objArr13[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                mN13.append(objArr13);
                                mN13.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                mN13.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.elF != null) {
                                    mN13.append("requestUrl", this.elF.mF());
                                    mN13.append("dnsMessage", this.elF.toString());
                                }
                                u.e(mN13);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e31) {
                                }
                            }
                            closeConnection();
                            this.elE.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet13 = j.isWifiNet();
                                if ((isWifiNet13 ? (dVar.Lk == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis16 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet13) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                                    } else if (j.is2GNet()) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                                    } else {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                                    }
                                    e.getInstance().result(c, dVar.Lk, false, z11, isWifiNet13);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.elD) {
                    byteArrayOutputStream.write(bArr11, 0, read);
                    i2 = read + i2;
                }
                dVar.Lj = -9;
                if (this.elD) {
                }
            }
        }
        closeConnection();
        this.elE.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean isWifiNet14 = j.isWifiNet();
            if ((isWifiNet14 ? dVar.Lk != null || z17 || i3 >= i + (-1) : true) && m.canUseIp(c) && z16) {
                long currentTimeMillis17 = System.currentTimeMillis() - currentTimeMillis;
                if (isWifiNet14) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dUh);
                } else if (j.is2GNet()) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dUj);
                } else {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dUi);
                }
                e.getInstance().result(c, dVar.Lk, z17, z12, isWifiNet14);
            }
        }
        this.elC = 0;
        this.elE.mt().retBytes = bArr10;
    }

    private void Am(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(elN) && (System.currentTimeMillis() - elP) - (1800000 * (elO / 3)) >= 0) {
            elO++;
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
                elN = str;
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

    public boolean bjC() {
        return this.elK;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0019a
    public void cancel() {
        cancelNetConnect();
    }
}
