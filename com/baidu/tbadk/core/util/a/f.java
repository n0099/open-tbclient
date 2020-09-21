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
import com.baidu.tbadk.util.n;
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
/* loaded from: classes.dex */
public class f implements a.InterfaceC0020a {
    private static HttpClient eoe;
    private static String eok;
    private static int eol;
    private static long eom;
    public static String proxyHost;
    private HttpGet enX;
    private final com.baidu.adp.lib.network.http.e eoa;
    public boolean eoi;
    private final Context mContext;
    private static int emm = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
    private static volatile String enV = null;
    private static volatile boolean enW = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams eog = new BasicHttpParams();
    private com.baidu.adp.lib.network.http.a.c eob = null;
    private boolean eoc = false;
    private boolean eod = false;
    private boolean mIsGif = false;
    private boolean eoh = false;
    private int eoj = 0;
    private int enY = 0;
    private volatile boolean enZ = false;

    static {
        HttpConnectionParams.setConnectionTimeout(eog, 5000);
        HttpConnectionParams.setSoTimeout(eog, 30000);
        HttpConnectionParams.setSocketBufferSize(eog, 1024);
        HttpConnectionParams.setTcpNoDelay(eog, true);
        HttpClientParams.setRedirecting(eog, true);
        ConnManagerParams.setMaxConnectionsPerRoute(eog, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(eog, 10000L);
        ConnManagerParams.setMaxTotalConnections(eog, 15);
        HttpProtocolParams.setUserAgent(eog, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), Constants.SOCKET_PORT_SSL));
        eoe = new DefaultHttpClient(new ThreadSafeClientConnManager(eog, schemeRegistry), eog);
        ((DefaultHttpClient) eoe).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        eok = null;
        eol = 0;
        eom = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        bkv();
        this.eoa = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void bkv() {
        synchronized (f.class) {
            if (!enW) {
                enW = true;
                bkw();
            }
        }
    }

    public static synchronized void bkw() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    enV = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void cancelNetConnect() {
        this.enZ = true;
        this.eoa.mx().LX = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.enX != null) {
                this.enX.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ac(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().enT) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.isNetWorkAvailable()) {
            this.eoi = false;
            try {
                if (j.isMobileNet()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (proxyHost == null) {
                            proxyHost = j.curMobileProxyHost();
                        }
                        if (proxyHost != null && proxyHost.length() > 0) {
                            this.eoi = true;
                            if (AI(proxyHost) && j.isSupportWap()) {
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
                                        this.enX = e.getInstance().httpGetFactory(sb.toString(), this.eoj, false);
                                    } else {
                                        this.enX = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.enX = new HttpGet(sb.toString());
                                }
                                this.enX.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.enX.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = eog.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    eog.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(proxyHost) || httpHost.getPort() != j.curMobileProxyPort()) {
                                        eog.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.enX = e.getInstance().httpGetFactory(str, this.eoj, false);
                                    } else {
                                        this.enX = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.enX = new HttpGet(str);
                                }
                                if (enV != null) {
                                    this.enX.setHeader(AUTH.PROXY_AUTH_RESP, enV);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.enX.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (n.Dd(str)) {
                    String host = com.baidu.adp.lib.network.http.a.d.getHost(str);
                    this.eob = com.baidu.adp.lib.network.http.a.b.mH().bL(host);
                    if (!at.isEmpty(this.eob.mL())) {
                        this.enX = ad(str, this.eob.mL(), host);
                    } else if (this.eoc) {
                        this.eob = com.baidu.adp.lib.network.http.a.b.mH().x(host, null);
                        this.enX = ad(str, this.eob.mL(), host);
                    } else {
                        this.enX = new HttpGet(str);
                    }
                } else if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.isMobileNet()) {
                            if (!this.eoi || this.enX == null) {
                                this.enX = e.getInstance().httpGetFactory(str, this.eoj, false);
                            }
                        } else {
                            this.enX = e.getInstance().httpGetFactory(str, this.eoj, true);
                        }
                    } else {
                        this.enX = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.enX = new HttpGet(str);
                }
                this.enX.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private HttpGet ad(String str, String str2, String str3) {
        if (this.eod && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://" + str.substring(8);
        }
        if (this.eob != null && !at.isEmpty(this.eob.mL())) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String str4 = url.getProtocol() + "://" + str2 + url.getPath();
                HttpGet httpGet = new HttpGet(str4);
                this.eob.bM(str4);
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return new HttpGet(str);
    }

    private boolean AI(String str) {
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
        r13.Lq = java.lang.System.currentTimeMillis() - r18;
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
        r27.eoh = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x1480, code lost:
        if (r6 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x148e, code lost:
        if (r27.eoa.mx().responseCode == 200) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x149c, code lost:
        if (r27.eoa.mx().responseCode != 302) goto L267;
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
        AJ(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:756:0x14c0, code lost:
        if (r7 != false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:758:0x14c6, code lost:
        if (com.baidu.tbadk.util.n.Dd(r5) == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:760:0x14cc, code lost:
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:761:0x14ce, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:762:0x14cf, code lost:
        r27.eoc = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:763:0x14d7, code lost:
        if (r27.eoc == false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x14dd, code lost:
        if (r27.eob == null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:766:0x14df, code lost:
        r27.eob.as(r27.eoa.mx().mNetErrorCode);
     */
    /* JADX WARN: Code restructure failed: missing block: B:767:0x14f0, code lost:
        if (r7 != false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:769:0x14f4, code lost:
        if (r10 != (r30 - 1)) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:771:0x14fa, code lost:
        if (com.baidu.tbadk.util.n.Dd(r5) == false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:772:0x14fc, code lost:
        r6 = com.baidu.tbadk.core.util.u.mS();
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
        if (r27.eob == null) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:780:0x15c0, code lost:
        r6.append("requestUrl", r27.eob.mK());
        r6.append("dnsMessage", r27.eob.toString());
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
        r27.eoh = true;
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
            if (!e.getInstance().enT) {
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
            if (this.enZ || i3 >= i) {
                break;
            }
            this.eoj = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.eoa.a(dVar);
            dVar.Lt = -1;
            InputStream inputStream2 = null;
            c = this.eoa.mw().c(dVar);
            try {
                dVar.Lt = -2;
                long currentTimeMillis3 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    ac(c, null, null);
                    if (z16) {
                        dVar.Lu = e.getInstance().getCachedCdnIp(this.eoj);
                    }
                } else {
                    ac(c, str, str2);
                    dVar.Lu = str;
                }
                dVar.Lt = -3;
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
            if (this.enX == null) {
                throw new SocketException("network not available.");
            }
            if (this.enZ) {
                this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                if (this.eoc && this.eob != null) {
                    this.eob.as(this.eoa.mx().mNetErrorCode);
                }
                if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                    com.baidu.adp.lib.stats.a mS = u.mS();
                    mS.append("netException", dVar.exception);
                    mS.append("Url", c);
                    mS.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                    mS.append("netType", Integer.valueOf(j.netType()));
                    mS.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                    mS.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                    mS.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    Object[] objArr = new Object[2];
                    objArr[0] = "isNetChanged";
                    objArr[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                    mS.append(objArr);
                    mS.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                    mS.append("currentActivity", UtilHelper.getTopActivityClassName());
                    if (this.eob != null) {
                        mS.append("requestUrl", this.eob.mK());
                        mS.append("dnsMessage", this.eob.toString());
                    }
                    u.e(mS);
                }
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e7) {
                    }
                }
                closeConnection();
                this.eoa.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean isWifiNet2 = j.isWifiNet();
                    if ((isWifiNet2 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        if (isWifiNet2) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                        } else if (j.is2GNet()) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                        } else {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                        }
                        e.getInstance().result(c, dVar.Lu, false, z9, isWifiNet2);
                    }
                }
            } else {
                dVar.Lt = -8;
                HttpResponse execute = eoe.execute(this.enX);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.eoa.mx().responseCode = execute.getStatusLine().getStatusCode();
                dVar.Ls = this.eoa.mx().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.LA = headers[0].getValue();
                            dVar.LB = headers[1].getValue();
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
                    this.eoa.mx().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.enY < 1) {
                            closeConnection();
                            this.enY++;
                            this.eoa.mx().responseCode = 0;
                            i3--;
                            this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                            if (this.eoc && this.eob != null) {
                                this.eob.as(this.eoa.mx().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                com.baidu.adp.lib.stats.a mS2 = u.mS();
                                mS2.append("netException", dVar.exception);
                                mS2.append("Url", c);
                                mS2.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                mS2.append("netType", Integer.valueOf(j.netType()));
                                mS2.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                mS2.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                mS2.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = "isNetChanged";
                                objArr2[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                mS2.append(objArr2);
                                mS2.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                mS2.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.eob != null) {
                                    mS2.append("requestUrl", this.eob.mK());
                                    mS2.append("dnsMessage", this.eob.toString());
                                }
                                u.e(mS2);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            closeConnection();
                            this.eoa.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet3 = j.isWifiNet();
                                if ((isWifiNet3 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet3) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                    } else if (j.is2GNet()) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                    } else {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                    }
                                    e.getInstance().result(c, dVar.Lu, false, z14, isWifiNet3);
                                }
                            }
                            i3++;
                            bArr10 = bArr10;
                        } else {
                            this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                            if (this.eoc && this.eob != null) {
                                this.eob.as(this.eoa.mx().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                com.baidu.adp.lib.stats.a mS3 = u.mS();
                                mS3.append("netException", dVar.exception);
                                mS3.append("Url", c);
                                mS3.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                mS3.append("netType", Integer.valueOf(j.netType()));
                                mS3.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                mS3.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                mS3.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = "isNetChanged";
                                objArr3[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                mS3.append(objArr3);
                                mS3.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                mS3.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.eob != null) {
                                    mS3.append("requestUrl", this.eob.mK());
                                    mS3.append("dnsMessage", this.eob.toString());
                                }
                                u.e(mS3);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            closeConnection();
                            this.eoa.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet4 = j.isWifiNet();
                                if ((isWifiNet4 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet4) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                    } else if (j.is2GNet()) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                    } else {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                    }
                                    e.getInstance().result(c, dVar.Lu, false, z13, isWifiNet4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > emm) {
                    this.eoa.mx().mNetErrorCode = -11;
                    dVar.exception = this.mContext.getResources().getString(R.string.data_too_big);
                    this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                    if (this.eoc && this.eob != null) {
                        this.eob.as(this.eoa.mx().mNetErrorCode);
                    }
                    if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                        com.baidu.adp.lib.stats.a mS4 = u.mS();
                        mS4.append("netException", dVar.exception);
                        mS4.append("Url", c);
                        mS4.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                        mS4.append("netType", Integer.valueOf(j.netType()));
                        mS4.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                        mS4.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                        mS4.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = "isNetChanged";
                        objArr4[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                        mS4.append(objArr4);
                        mS4.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                        mS4.append("currentActivity", UtilHelper.getTopActivityClassName());
                        if (this.eob != null) {
                            mS4.append("requestUrl", this.eob.mK());
                            mS4.append("dnsMessage", this.eob.toString());
                        }
                        u.e(mS4);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                        }
                    }
                    closeConnection();
                    this.eoa.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean isWifiNet5 = j.isWifiNet();
                        if ((isWifiNet5 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (isWifiNet5) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                            } else if (j.is2GNet()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                            }
                            e.getInstance().result(c, dVar.Lu, false, z10, isWifiNet5);
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
                        while (!this.enZ && i2 < emm && (read = inputStream.read(bArr11)) != -1) {
                            byteArrayOutputStream.write(bArr11, 0, read);
                            i2 = read + i2;
                        }
                        dVar.Lt = -9;
                        if (this.enZ) {
                            if (i2 >= emm) {
                                this.eoa.mx().mNetErrorCode = -11;
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
                                    this.eoa.mx().mNetErrorCode = -12;
                                    dVar.exception = "errorCode:" + String.valueOf(this.eoa.mx().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                    this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                                    if (this.eoc && this.eob != null) {
                                        this.eob.as(this.eoa.mx().mNetErrorCode);
                                    }
                                    if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                        com.baidu.adp.lib.stats.a mS5 = u.mS();
                                        mS5.append("netException", dVar.exception);
                                        mS5.append("Url", c);
                                        mS5.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                        mS5.append("netType", Integer.valueOf(j.netType()));
                                        mS5.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        mS5.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                        mS5.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr5 = new Object[2];
                                        objArr5[0] = "isNetChanged";
                                        objArr5[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                        mS5.append(objArr5);
                                        mS5.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        mS5.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.eob != null) {
                                            mS5.append("requestUrl", this.eob.mK());
                                            mS5.append("dnsMessage", this.eob.toString());
                                        }
                                        u.e(mS5);
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    closeConnection();
                                    this.eoa.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean isWifiNet6 = j.isWifiNet();
                                        if ((isWifiNet6 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (isWifiNet6) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                            } else if (j.is2GNet()) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                            } else {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                            }
                                            e.getInstance().result(c, dVar.Lu, false, z8, isWifiNet6);
                                        }
                                    }
                                    i3++;
                                    bArr10 = bArr10;
                                } catch (Throwable th5) {
                                    inputStream = inputStream2;
                                    bArr = bArr10;
                                    th = th5;
                                    this.eoc = 0 != 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                                    if (this.eoc && this.eob != null) {
                                        this.eob.as(this.eoa.mx().mNetErrorCode);
                                    }
                                    if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                        com.baidu.adp.lib.stats.a mS6 = u.mS();
                                        mS6.append("netException", dVar.exception);
                                        mS6.append("Url", c);
                                        mS6.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                        mS6.append("netType", Integer.valueOf(j.netType()));
                                        mS6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        mS6.append("downloadFileSize", Integer.valueOf(bArr != null ? bArr.length : 0));
                                        mS6.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr6 = new Object[2];
                                        objArr6[0] = "isNetChanged";
                                        objArr6[1] = Boolean.valueOf(j.getNetChangedTime() <= currentTimeMillis2);
                                        mS6.append(objArr6);
                                        mS6.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        mS6.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.eob != null) {
                                            mS6.append("requestUrl", this.eob.mK());
                                            mS6.append("dnsMessage", this.eob.toString());
                                        }
                                        u.e(mS6);
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e19) {
                                        }
                                    }
                                    closeConnection();
                                    this.eoa.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        isWifiNet = j.isWifiNet();
                                        if ((isWifiNet ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!isWifiNet) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                            } else if (j.is2GNet()) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                            } else {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                            }
                                            e.getInstance().result(c, dVar.Lu, false, z7, isWifiNet);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e20) {
                                bArr10 = bArr8;
                                e = e20;
                                this.eoa.mx().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.eoa.mx().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                                if (this.eoc && this.eob != null) {
                                    this.eob.as(this.eoa.mx().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                    com.baidu.adp.lib.stats.a mS7 = u.mS();
                                    mS7.append("netException", dVar.exception);
                                    mS7.append("Url", c);
                                    mS7.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mS7.append("netType", Integer.valueOf(j.netType()));
                                    mS7.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mS7.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mS7.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr7 = new Object[2];
                                    objArr7[0] = "isNetChanged";
                                    objArr7[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mS7.append(objArr7);
                                    mS7.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mS7.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eob != null) {
                                        mS7.append("requestUrl", this.eob.mK());
                                        mS7.append("dnsMessage", this.eob.toString());
                                    }
                                    u.e(mS7);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                closeConnection();
                                this.eoa.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet7 = j.isWifiNet();
                                    if ((isWifiNet7 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet7) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                        } else if (j.is2GNet()) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                        } else {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                        }
                                        e.getInstance().result(c, dVar.Lu, false, z6, isWifiNet7);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (IllegalStateException e22) {
                                bArr10 = bArr7;
                                e = e22;
                                this.eoa.mx().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.eoa.mx().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                                if (this.eoc && this.eob != null) {
                                    this.eob.as(this.eoa.mx().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                    com.baidu.adp.lib.stats.a mS8 = u.mS();
                                    mS8.append("netException", dVar.exception);
                                    mS8.append("Url", c);
                                    mS8.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mS8.append("netType", Integer.valueOf(j.netType()));
                                    mS8.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mS8.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mS8.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr8 = new Object[2];
                                    objArr8[0] = "isNetChanged";
                                    objArr8[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mS8.append(objArr8);
                                    mS8.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mS8.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eob != null) {
                                        mS8.append("requestUrl", this.eob.mK());
                                        mS8.append("dnsMessage", this.eob.toString());
                                    }
                                    u.e(mS8);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                closeConnection();
                                this.eoa.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet8 = j.isWifiNet();
                                    if ((isWifiNet8 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet8) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                        } else if (j.is2GNet()) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                        } else {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                        }
                                        e.getInstance().result(c, dVar.Lu, false, z5, isWifiNet8);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SocketTimeoutException e24) {
                                bArr10 = bArr6;
                                e = e24;
                                this.eoa.mx().mNetErrorCode = -13;
                                dVar.exception = "errorCode:" + String.valueOf(this.eoa.mx().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                                if (this.eoc && this.eob != null) {
                                    this.eob.as(this.eoa.mx().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                    com.baidu.adp.lib.stats.a mS9 = u.mS();
                                    mS9.append("netException", dVar.exception);
                                    mS9.append("Url", c);
                                    mS9.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mS9.append("netType", Integer.valueOf(j.netType()));
                                    mS9.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mS9.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mS9.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr9 = new Object[2];
                                    objArr9[0] = "isNetChanged";
                                    objArr9[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mS9.append(objArr9);
                                    mS9.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mS9.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eob != null) {
                                        mS9.append("requestUrl", this.eob.mK());
                                        mS9.append("dnsMessage", this.eob.toString());
                                    }
                                    u.e(mS9);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                closeConnection();
                                this.eoa.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet9 = j.isWifiNet();
                                    if ((isWifiNet9 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet9) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                        } else if (j.is2GNet()) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                        } else {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                        }
                                        e.getInstance().result(c, dVar.Lu, false, z4, isWifiNet9);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SSLException e26) {
                                bArr10 = bArr5;
                                e = e26;
                                this.eoa.mx().mNetErrorCode = -20;
                                dVar.exception = "errorCode:" + String.valueOf(this.eoa.mx().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.eod = true;
                                this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                                if (this.eoc && this.eob != null) {
                                    this.eob.as(this.eoa.mx().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                    com.baidu.adp.lib.stats.a mS10 = u.mS();
                                    mS10.append("netException", dVar.exception);
                                    mS10.append("Url", c);
                                    mS10.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mS10.append("netType", Integer.valueOf(j.netType()));
                                    mS10.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mS10.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mS10.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr10 = new Object[2];
                                    objArr10[0] = "isNetChanged";
                                    objArr10[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mS10.append(objArr10);
                                    mS10.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mS10.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eob != null) {
                                        mS10.append("requestUrl", this.eob.mK());
                                        mS10.append("dnsMessage", this.eob.toString());
                                    }
                                    u.e(mS10);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e27) {
                                    }
                                }
                                closeConnection();
                                this.eoa.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet10 = j.isWifiNet();
                                    if ((isWifiNet10 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet10) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                        } else if (j.is2GNet()) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                        } else {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                        }
                                        e.getInstance().result(c, dVar.Lu, false, z3, isWifiNet10);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (HttpException e28) {
                                bArr10 = bArr4;
                                e = e28;
                                this.eoa.mx().mNetErrorCode = -18;
                                dVar.exception = "errorCode:" + String.valueOf(this.eoa.mx().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                                if (this.eoc && this.eob != null) {
                                    this.eob.as(this.eoa.mx().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                    com.baidu.adp.lib.stats.a mS11 = u.mS();
                                    mS11.append("netException", dVar.exception);
                                    mS11.append("Url", c);
                                    mS11.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mS11.append("netType", Integer.valueOf(j.netType()));
                                    mS11.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mS11.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mS11.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr11 = new Object[2];
                                    objArr11[0] = "isNetChanged";
                                    objArr11[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mS11.append(objArr11);
                                    mS11.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mS11.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eob != null) {
                                        mS11.append("requestUrl", this.eob.mK());
                                        mS11.append("dnsMessage", this.eob.toString());
                                    }
                                    u.e(mS11);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e29) {
                                    }
                                }
                                closeConnection();
                                this.eoa.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet11 = j.isWifiNet();
                                    if ((isWifiNet11 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet11) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                        } else if (j.is2GNet()) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                        } else {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                        }
                                        e.getInstance().result(c, dVar.Lu, false, z2, isWifiNet11);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (Throwable th6) {
                                bArr10 = bArr2;
                                th = th6;
                                this.eoa.mx().mNetErrorCode = -10;
                                dVar.exception = "errorCode:" + String.valueOf(this.eoa.mx().mNetErrorCode) + "|" + th.getClass() + "|" + th.getMessage();
                                this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                                if (this.eoc && this.eob != null) {
                                    this.eob.as(this.eoa.mx().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                    com.baidu.adp.lib.stats.a mS12 = u.mS();
                                    mS12.append("netException", dVar.exception);
                                    mS12.append("Url", c);
                                    mS12.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    mS12.append("netType", Integer.valueOf(j.netType()));
                                    mS12.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    mS12.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    mS12.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr12 = new Object[2];
                                    objArr12[0] = "isNetChanged";
                                    objArr12[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    mS12.append(objArr12);
                                    mS12.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    mS12.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eob != null) {
                                        mS12.append("requestUrl", this.eob.mK());
                                        mS12.append("dnsMessage", this.eob.toString());
                                    }
                                    u.e(mS12);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e30) {
                                    }
                                }
                                closeConnection();
                                this.eoa.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet12 = j.isWifiNet();
                                    if ((isWifiNet12 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet12) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                        } else if (j.is2GNet()) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                        } else {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                        }
                                        e.getInstance().result(c, dVar.Lu, false, z, isWifiNet12);
                                    }
                                }
                                this.enY = 0;
                                this.eoa.mx().retBytes = bArr10;
                            }
                        } else {
                            this.eoc = 0 == 0 && n.Dd(c) && j.isNetworkAvailableForImmediately();
                            if (this.eoc && this.eob != null) {
                                this.eob.as(this.eoa.mx().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && n.Dd(c)) {
                                com.baidu.adp.lib.stats.a mS13 = u.mS();
                                mS13.append("netException", dVar.exception);
                                mS13.append("Url", c);
                                mS13.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                mS13.append("netType", Integer.valueOf(j.netType()));
                                mS13.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                mS13.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                mS13.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr13 = new Object[2];
                                objArr13[0] = "isNetChanged";
                                objArr13[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                mS13.append(objArr13);
                                mS13.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                mS13.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.eob != null) {
                                    mS13.append("requestUrl", this.eob.mK());
                                    mS13.append("dnsMessage", this.eob.toString());
                                }
                                u.e(mS13);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e31) {
                                }
                            }
                            closeConnection();
                            this.eoa.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet13 = j.isWifiNet();
                                if ((isWifiNet13 ? (dVar.Lu == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                    long currentTimeMillis16 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet13) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                                    } else if (j.is2GNet()) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                                    } else {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                                    }
                                    e.getInstance().result(c, dVar.Lu, false, z11, isWifiNet13);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.enZ) {
                    byteArrayOutputStream.write(bArr11, 0, read);
                    i2 = read + i2;
                }
                dVar.Lt = -9;
                if (this.enZ) {
                }
            }
        }
        closeConnection();
        this.eoa.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean isWifiNet14 = j.isWifiNet();
            if ((isWifiNet14 ? dVar.Lu != null || z17 || i3 >= i + (-1) : true) && n.canUseIp(c) && z16) {
                long currentTimeMillis17 = System.currentTimeMillis() - currentTimeMillis;
                if (isWifiNet14) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dWv);
                } else if (j.is2GNet()) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dWx);
                } else {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dWw);
                }
                e.getInstance().result(c, dVar.Lu, z17, z12, isWifiNet14);
            }
        }
        this.enY = 0;
        this.eoa.mx().retBytes = bArr10;
    }

    private void AJ(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(eok) && (System.currentTimeMillis() - eom) - (1800000 * (eol / 3)) >= 0) {
            eol++;
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
                eok = str;
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

    public boolean bkx() {
        return this.eoh;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0020a
    public void cancel() {
        cancelNetConnect();
    }
}
