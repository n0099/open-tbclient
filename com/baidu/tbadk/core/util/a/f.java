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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.t;
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
/* loaded from: classes.dex */
public class f implements a.InterfaceC0021a {
    private static HttpClient dVE;
    private static String dVJ;
    private static int dVK;
    private static long dVL;
    public static String proxyHost;
    private final com.baidu.adp.lib.network.http.e dVA;
    public boolean dVH;
    private HttpGet dVx;
    private final Context mContext;
    private static int dTS = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
    private static volatile String dVv = null;
    private static volatile boolean dVw = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams dVF = new BasicHttpParams();
    private com.baidu.adp.lib.network.http.a.c dVB = null;
    private boolean dVC = false;
    private boolean dVD = false;
    private boolean mIsGif = false;
    private boolean dVG = false;
    private int dVI = 0;
    private int dVy = 0;
    private volatile boolean dVz = false;

    static {
        HttpConnectionParams.setConnectionTimeout(dVF, 5000);
        HttpConnectionParams.setSoTimeout(dVF, 30000);
        HttpConnectionParams.setSocketBufferSize(dVF, 1024);
        HttpConnectionParams.setTcpNoDelay(dVF, true);
        HttpClientParams.setRedirecting(dVF, true);
        ConnManagerParams.setMaxConnectionsPerRoute(dVF, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(dVF, 10000L);
        ConnManagerParams.setMaxTotalConnections(dVF, 15);
        HttpProtocolParams.setUserAgent(dVF, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), Constants.SOCKET_PORT_SSL));
        dVE = new DefaultHttpClient(new ThreadSafeClientConnManager(dVF, schemeRegistry), dVF);
        ((DefaultHttpClient) dVE).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        dVJ = null;
        dVK = 0;
        dVL = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        aXa();
        this.dVA = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void aXa() {
        synchronized (f.class) {
            if (!dVw) {
                dVw = true;
                aXb();
            }
        }
    }

    public static synchronized void aXb() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    dVv = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void cancelNetConnect() {
        this.dVz = true;
        this.dVA.kU().Le = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.dVx != null) {
                this.dVx.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ab(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().dVt) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.isNetWorkAvailable()) {
            this.dVH = false;
            try {
                if (j.isMobileNet()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (proxyHost == null) {
                            proxyHost = j.curMobileProxyHost();
                        }
                        if (proxyHost != null && proxyHost.length() > 0) {
                            this.dVH = true;
                            if (wP(proxyHost) && j.isSupportWap()) {
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
                                        this.dVx = e.getInstance().httpGetFactory(sb.toString(), this.dVI, false);
                                    } else {
                                        this.dVx = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.dVx = new HttpGet(sb.toString());
                                }
                                this.dVx.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.dVx.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = dVF.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    dVF.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(proxyHost) || httpHost.getPort() != j.curMobileProxyPort()) {
                                        dVF.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.dVx = e.getInstance().httpGetFactory(str, this.dVI, false);
                                    } else {
                                        this.dVx = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.dVx = new HttpGet(str);
                                }
                                if (dVv != null) {
                                    this.dVx.setHeader(AUTH.PROXY_AUTH_RESP, dVv);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.dVx.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (m.zi(str)) {
                    String host = com.baidu.adp.lib.network.http.a.d.getHost(str);
                    this.dVB = com.baidu.adp.lib.network.http.a.b.ld().bE(host);
                    if (!ar.isEmpty(this.dVB.lh())) {
                        this.dVx = ac(str, this.dVB.lh(), host);
                    } else if (this.dVC) {
                        this.dVB = com.baidu.adp.lib.network.http.a.b.ld().t(host, null);
                        this.dVx = ac(str, this.dVB.lh(), host);
                    } else {
                        this.dVx = new HttpGet(str);
                    }
                } else if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.isMobileNet()) {
                            if (!this.dVH || this.dVx == null) {
                                this.dVx = e.getInstance().httpGetFactory(str, this.dVI, false);
                            }
                        } else {
                            this.dVx = e.getInstance().httpGetFactory(str, this.dVI, true);
                        }
                    } else {
                        this.dVx = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.dVx = new HttpGet(str);
                }
                this.dVx.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private HttpGet ac(String str, String str2, String str3) {
        if (this.dVD && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://" + str.substring(8);
        }
        if (this.dVB != null && !ar.isEmpty(this.dVB.lh())) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String str4 = url.getProtocol() + "://" + str2 + url.getPath();
                HttpGet httpGet = new HttpGet(str4);
                this.dVB.bH(str4);
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return new HttpGet(str);
    }

    private boolean wP(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [609=29, 610=14, 611=14, 613=14, 614=14, 615=14, 616=14, 617=14, 618=14, 619=14, 620=14, 621=14, 622=14, 624=14, 625=14, 626=28, 627=14, 628=14, 629=14, 630=14, 631=14, 633=14, 636=14, 637=14, 641=14, 646=14, 647=14, 648=14, 649=14, 650=14, 651=28, 653=14, 654=14, 655=14, 657=14, 658=28, 659=14, 660=14, 662=14, 664=14, 668=7] */
    /* JADX WARN: Code restructure failed: missing block: B:732:0x143b, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:734:0x143f, code lost:
        r13.downloadSize = r6;
        r13.retry = r10 + 1;
        r13.KD = java.lang.System.currentTimeMillis() - r18;
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
        r27.dVG = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x1481, code lost:
        if (r6 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x148f, code lost:
        if (r27.dVA.kU().responseCode == 200) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x149d, code lost:
        if (r27.dVA.kU().responseCode != 302) goto L267;
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
        wQ(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:756:0x14c1, code lost:
        if (r7 != false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:758:0x14c7, code lost:
        if (com.baidu.tbadk.util.m.zi(r5) == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:760:0x14cd, code lost:
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:761:0x14cf, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:762:0x14d0, code lost:
        r27.dVC = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:763:0x14d8, code lost:
        if (r27.dVC == false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x14de, code lost:
        if (r27.dVB == null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:766:0x14e0, code lost:
        r27.dVB.al(r27.dVA.kU().mNetErrorCode);
     */
    /* JADX WARN: Code restructure failed: missing block: B:767:0x14f1, code lost:
        if (r7 != false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:769:0x14f5, code lost:
        if (r10 != (r30 - 1)) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:771:0x14fb, code lost:
        if (com.baidu.tbadk.util.m.zi(r5) == false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:772:0x14fd, code lost:
        r6 = com.baidu.tbadk.core.util.t.lo();
        r6.append("netException", r13.exception);
        r6.append("Url", r5);
        r6.append("isNetAvailable", java.lang.Boolean.valueOf(com.baidu.adp.lib.util.j.isNetWorkAvailable()));
        r6.append("netType", java.lang.Integer.valueOf(com.baidu.adp.lib.util.j.netType()));
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
        r6.append("downloadFileSize", java.lang.Integer.valueOf(r4));
        r6.append(com.baidu.live.adp.lib.stats.BdStatsConstant.StatsKey.COST, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - r14));
        r9 = new java.lang.Object[2];
        r9[0] = "isNetChanged";
     */
    /* JADX WARN: Code restructure failed: missing block: B:776:0x158a, code lost:
        if (com.baidu.adp.lib.util.j.getNetChangedTime() <= r14) goto L300;
     */
    /* JADX WARN: Code restructure failed: missing block: B:777:0x158c, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:778:0x158d, code lost:
        r9[1] = java.lang.Boolean.valueOf(r4);
        r6.append(r9);
        r6.append("isBackground", java.lang.Boolean.valueOf(com.baidu.tbadk.core.TbadkCoreApplication.getInst().isInBackground()));
        r6.append("currentActivity", com.baidu.tbadk.core.util.UtilHelper.getTopActivityClassName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:779:0x15bf, code lost:
        if (r27.dVB == null) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:780:0x15c1, code lost:
        r6.append("requestUrl", r27.dVB.lg());
        r6.append("dnsMessage", r27.dVB.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:781:0x15dd, code lost:
        com.baidu.tbadk.core.util.t.e(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:782:0x15e0, code lost:
        if (r8 == null) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x15e2, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:811:0x1661, code lost:
        r27.dVG = true;
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
            if (!e.getInstance().dVt) {
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
            if (this.dVz || i3 >= i) {
                break;
            }
            this.dVI = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.dVA.a(dVar);
            dVar.KG = -1;
            InputStream inputStream2 = null;
            c = this.dVA.kT().c(dVar);
            try {
                dVar.KG = -2;
                long currentTimeMillis3 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    ab(c, null, null);
                    if (z16) {
                        dVar.KH = e.getInstance().getCachedCdnIp(this.dVI);
                    }
                } else {
                    ab(c, str, str2);
                    dVar.KH = str;
                }
                dVar.KG = -3;
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
            if (this.dVx == null) {
                throw new SocketException("network not available.");
            }
            if (this.dVz) {
                this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                if (this.dVC && this.dVB != null) {
                    this.dVB.al(this.dVA.kU().mNetErrorCode);
                }
                if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                    com.baidu.adp.lib.stats.a lo = t.lo();
                    lo.append("netException", dVar.exception);
                    lo.append("Url", c);
                    lo.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                    lo.append("netType", Integer.valueOf(j.netType()));
                    lo.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                    lo.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                    lo.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    Object[] objArr = new Object[2];
                    objArr[0] = "isNetChanged";
                    objArr[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                    lo.append(objArr);
                    lo.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                    lo.append("currentActivity", UtilHelper.getTopActivityClassName());
                    if (this.dVB != null) {
                        lo.append("requestUrl", this.dVB.lg());
                        lo.append("dnsMessage", this.dVB.toString());
                    }
                    t.e(lo);
                }
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e7) {
                    }
                }
                closeConnection();
                this.dVA.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean isWifiNet2 = j.isWifiNet();
                    if ((isWifiNet2 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        if (isWifiNet2) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                        } else if (j.is2GNet()) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                        } else {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                        }
                        e.getInstance().result(c, dVar.KH, false, z9, isWifiNet2);
                    }
                }
            } else {
                dVar.KG = -8;
                HttpResponse execute = dVE.execute(this.dVx);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.dVA.kU().responseCode = execute.getStatusLine().getStatusCode();
                dVar.KF = this.dVA.kU().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.KN = headers[0].getValue();
                            dVar.KO = headers[1].getValue();
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
                    this.dVA.kU().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.dVy < 1) {
                            closeConnection();
                            this.dVy++;
                            this.dVA.kU().responseCode = 0;
                            i3--;
                            this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                            if (this.dVC && this.dVB != null) {
                                this.dVB.al(this.dVA.kU().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                com.baidu.adp.lib.stats.a lo2 = t.lo();
                                lo2.append("netException", dVar.exception);
                                lo2.append("Url", c);
                                lo2.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                lo2.append("netType", Integer.valueOf(j.netType()));
                                lo2.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                lo2.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                lo2.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = "isNetChanged";
                                objArr2[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                lo2.append(objArr2);
                                lo2.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                lo2.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.dVB != null) {
                                    lo2.append("requestUrl", this.dVB.lg());
                                    lo2.append("dnsMessage", this.dVB.toString());
                                }
                                t.e(lo2);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            closeConnection();
                            this.dVA.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet3 = j.isWifiNet();
                                if ((isWifiNet3 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet3) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                    } else if (j.is2GNet()) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                    } else {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                    }
                                    e.getInstance().result(c, dVar.KH, false, z14, isWifiNet3);
                                }
                            }
                            i3++;
                            bArr10 = bArr10;
                        } else {
                            this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                            if (this.dVC && this.dVB != null) {
                                this.dVB.al(this.dVA.kU().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                com.baidu.adp.lib.stats.a lo3 = t.lo();
                                lo3.append("netException", dVar.exception);
                                lo3.append("Url", c);
                                lo3.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                lo3.append("netType", Integer.valueOf(j.netType()));
                                lo3.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                lo3.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                lo3.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = "isNetChanged";
                                objArr3[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                lo3.append(objArr3);
                                lo3.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                lo3.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.dVB != null) {
                                    lo3.append("requestUrl", this.dVB.lg());
                                    lo3.append("dnsMessage", this.dVB.toString());
                                }
                                t.e(lo3);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            closeConnection();
                            this.dVA.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet4 = j.isWifiNet();
                                if ((isWifiNet4 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet4) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                    } else if (j.is2GNet()) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                    } else {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                    }
                                    e.getInstance().result(c, dVar.KH, false, z13, isWifiNet4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > dTS) {
                    this.dVA.kU().mNetErrorCode = -11;
                    dVar.exception = this.mContext.getResources().getString(R.string.data_too_big);
                    this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                    if (this.dVC && this.dVB != null) {
                        this.dVB.al(this.dVA.kU().mNetErrorCode);
                    }
                    if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                        com.baidu.adp.lib.stats.a lo4 = t.lo();
                        lo4.append("netException", dVar.exception);
                        lo4.append("Url", c);
                        lo4.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                        lo4.append("netType", Integer.valueOf(j.netType()));
                        lo4.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                        lo4.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                        lo4.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = "isNetChanged";
                        objArr4[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                        lo4.append(objArr4);
                        lo4.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                        lo4.append("currentActivity", UtilHelper.getTopActivityClassName());
                        if (this.dVB != null) {
                            lo4.append("requestUrl", this.dVB.lg());
                            lo4.append("dnsMessage", this.dVB.toString());
                        }
                        t.e(lo4);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                        }
                    }
                    closeConnection();
                    this.dVA.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean isWifiNet5 = j.isWifiNet();
                        if ((isWifiNet5 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (isWifiNet5) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                            } else if (j.is2GNet()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                            }
                            e.getInstance().result(c, dVar.KH, false, z10, isWifiNet5);
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
                        while (!this.dVz && i2 < dTS && (read = inputStream.read(bArr11)) != -1) {
                            byteArrayOutputStream.write(bArr11, 0, read);
                            i2 = read + i2;
                        }
                        dVar.KG = -9;
                        if (this.dVz) {
                            if (i2 >= dTS) {
                                this.dVA.kU().mNetErrorCode = -11;
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
                                    this.dVA.kU().mNetErrorCode = -12;
                                    dVar.exception = "errorCode:" + String.valueOf(this.dVA.kU().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                    this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                                    if (this.dVC && this.dVB != null) {
                                        this.dVB.al(this.dVA.kU().mNetErrorCode);
                                    }
                                    if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                        com.baidu.adp.lib.stats.a lo5 = t.lo();
                                        lo5.append("netException", dVar.exception);
                                        lo5.append("Url", c);
                                        lo5.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                        lo5.append("netType", Integer.valueOf(j.netType()));
                                        lo5.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        lo5.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                        lo5.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr5 = new Object[2];
                                        objArr5[0] = "isNetChanged";
                                        objArr5[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                        lo5.append(objArr5);
                                        lo5.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        lo5.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.dVB != null) {
                                            lo5.append("requestUrl", this.dVB.lg());
                                            lo5.append("dnsMessage", this.dVB.toString());
                                        }
                                        t.e(lo5);
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    closeConnection();
                                    this.dVA.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean isWifiNet6 = j.isWifiNet();
                                        if ((isWifiNet6 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (isWifiNet6) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                            } else if (j.is2GNet()) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                            } else {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                            }
                                            e.getInstance().result(c, dVar.KH, false, z8, isWifiNet6);
                                        }
                                    }
                                    i3++;
                                    bArr10 = bArr10;
                                } catch (Throwable th5) {
                                    inputStream = inputStream2;
                                    bArr = bArr10;
                                    th = th5;
                                    this.dVC = 0 != 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                                    if (this.dVC && this.dVB != null) {
                                        this.dVB.al(this.dVA.kU().mNetErrorCode);
                                    }
                                    if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                        com.baidu.adp.lib.stats.a lo6 = t.lo();
                                        lo6.append("netException", dVar.exception);
                                        lo6.append("Url", c);
                                        lo6.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                        lo6.append("netType", Integer.valueOf(j.netType()));
                                        lo6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        lo6.append("downloadFileSize", Integer.valueOf(bArr != null ? bArr.length : 0));
                                        lo6.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr6 = new Object[2];
                                        objArr6[0] = "isNetChanged";
                                        objArr6[1] = Boolean.valueOf(j.getNetChangedTime() <= currentTimeMillis2);
                                        lo6.append(objArr6);
                                        lo6.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        lo6.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.dVB != null) {
                                            lo6.append("requestUrl", this.dVB.lg());
                                            lo6.append("dnsMessage", this.dVB.toString());
                                        }
                                        t.e(lo6);
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e19) {
                                        }
                                    }
                                    closeConnection();
                                    this.dVA.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        isWifiNet = j.isWifiNet();
                                        if ((isWifiNet ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!isWifiNet) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                            } else if (j.is2GNet()) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                            } else {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                            }
                                            e.getInstance().result(c, dVar.KH, false, z7, isWifiNet);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e20) {
                                bArr10 = bArr8;
                                e = e20;
                                this.dVA.kU().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.dVA.kU().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                                if (this.dVC && this.dVB != null) {
                                    this.dVB.al(this.dVA.kU().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                    com.baidu.adp.lib.stats.a lo7 = t.lo();
                                    lo7.append("netException", dVar.exception);
                                    lo7.append("Url", c);
                                    lo7.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    lo7.append("netType", Integer.valueOf(j.netType()));
                                    lo7.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    lo7.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    lo7.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr7 = new Object[2];
                                    objArr7[0] = "isNetChanged";
                                    objArr7[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    lo7.append(objArr7);
                                    lo7.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    lo7.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.dVB != null) {
                                        lo7.append("requestUrl", this.dVB.lg());
                                        lo7.append("dnsMessage", this.dVB.toString());
                                    }
                                    t.e(lo7);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                closeConnection();
                                this.dVA.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet7 = j.isWifiNet();
                                    if ((isWifiNet7 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet7) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                        } else if (j.is2GNet()) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                        } else {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                        }
                                        e.getInstance().result(c, dVar.KH, false, z6, isWifiNet7);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (IllegalStateException e22) {
                                bArr10 = bArr7;
                                e = e22;
                                this.dVA.kU().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.dVA.kU().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                                if (this.dVC && this.dVB != null) {
                                    this.dVB.al(this.dVA.kU().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                    com.baidu.adp.lib.stats.a lo8 = t.lo();
                                    lo8.append("netException", dVar.exception);
                                    lo8.append("Url", c);
                                    lo8.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    lo8.append("netType", Integer.valueOf(j.netType()));
                                    lo8.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    lo8.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    lo8.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr8 = new Object[2];
                                    objArr8[0] = "isNetChanged";
                                    objArr8[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    lo8.append(objArr8);
                                    lo8.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    lo8.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.dVB != null) {
                                        lo8.append("requestUrl", this.dVB.lg());
                                        lo8.append("dnsMessage", this.dVB.toString());
                                    }
                                    t.e(lo8);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                closeConnection();
                                this.dVA.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet8 = j.isWifiNet();
                                    if ((isWifiNet8 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet8) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                        } else if (j.is2GNet()) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                        } else {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                        }
                                        e.getInstance().result(c, dVar.KH, false, z5, isWifiNet8);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SocketTimeoutException e24) {
                                bArr10 = bArr6;
                                e = e24;
                                this.dVA.kU().mNetErrorCode = -13;
                                dVar.exception = "errorCode:" + String.valueOf(this.dVA.kU().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                                if (this.dVC && this.dVB != null) {
                                    this.dVB.al(this.dVA.kU().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                    com.baidu.adp.lib.stats.a lo9 = t.lo();
                                    lo9.append("netException", dVar.exception);
                                    lo9.append("Url", c);
                                    lo9.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    lo9.append("netType", Integer.valueOf(j.netType()));
                                    lo9.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    lo9.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    lo9.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr9 = new Object[2];
                                    objArr9[0] = "isNetChanged";
                                    objArr9[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    lo9.append(objArr9);
                                    lo9.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    lo9.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.dVB != null) {
                                        lo9.append("requestUrl", this.dVB.lg());
                                        lo9.append("dnsMessage", this.dVB.toString());
                                    }
                                    t.e(lo9);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                closeConnection();
                                this.dVA.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet9 = j.isWifiNet();
                                    if ((isWifiNet9 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet9) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                        } else if (j.is2GNet()) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                        } else {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                        }
                                        e.getInstance().result(c, dVar.KH, false, z4, isWifiNet9);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SSLException e26) {
                                bArr10 = bArr5;
                                e = e26;
                                this.dVA.kU().mNetErrorCode = -20;
                                dVar.exception = "errorCode:" + String.valueOf(this.dVA.kU().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.dVD = true;
                                this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                                if (this.dVC && this.dVB != null) {
                                    this.dVB.al(this.dVA.kU().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                    com.baidu.adp.lib.stats.a lo10 = t.lo();
                                    lo10.append("netException", dVar.exception);
                                    lo10.append("Url", c);
                                    lo10.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    lo10.append("netType", Integer.valueOf(j.netType()));
                                    lo10.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    lo10.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    lo10.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr10 = new Object[2];
                                    objArr10[0] = "isNetChanged";
                                    objArr10[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    lo10.append(objArr10);
                                    lo10.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    lo10.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.dVB != null) {
                                        lo10.append("requestUrl", this.dVB.lg());
                                        lo10.append("dnsMessage", this.dVB.toString());
                                    }
                                    t.e(lo10);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e27) {
                                    }
                                }
                                closeConnection();
                                this.dVA.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet10 = j.isWifiNet();
                                    if ((isWifiNet10 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet10) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                        } else if (j.is2GNet()) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                        } else {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                        }
                                        e.getInstance().result(c, dVar.KH, false, z3, isWifiNet10);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (HttpException e28) {
                                bArr10 = bArr4;
                                e = e28;
                                this.dVA.kU().mNetErrorCode = -18;
                                dVar.exception = "errorCode:" + String.valueOf(this.dVA.kU().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                                if (this.dVC && this.dVB != null) {
                                    this.dVB.al(this.dVA.kU().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                    com.baidu.adp.lib.stats.a lo11 = t.lo();
                                    lo11.append("netException", dVar.exception);
                                    lo11.append("Url", c);
                                    lo11.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    lo11.append("netType", Integer.valueOf(j.netType()));
                                    lo11.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    lo11.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    lo11.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr11 = new Object[2];
                                    objArr11[0] = "isNetChanged";
                                    objArr11[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    lo11.append(objArr11);
                                    lo11.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    lo11.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.dVB != null) {
                                        lo11.append("requestUrl", this.dVB.lg());
                                        lo11.append("dnsMessage", this.dVB.toString());
                                    }
                                    t.e(lo11);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e29) {
                                    }
                                }
                                closeConnection();
                                this.dVA.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet11 = j.isWifiNet();
                                    if ((isWifiNet11 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet11) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                        } else if (j.is2GNet()) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                        } else {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                        }
                                        e.getInstance().result(c, dVar.KH, false, z2, isWifiNet11);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (Throwable th6) {
                                bArr10 = bArr2;
                                th = th6;
                                this.dVA.kU().mNetErrorCode = -10;
                                dVar.exception = "errorCode:" + String.valueOf(this.dVA.kU().mNetErrorCode) + "|" + th.getClass() + "|" + th.getMessage();
                                this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                                if (this.dVC && this.dVB != null) {
                                    this.dVB.al(this.dVA.kU().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                    com.baidu.adp.lib.stats.a lo12 = t.lo();
                                    lo12.append("netException", dVar.exception);
                                    lo12.append("Url", c);
                                    lo12.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    lo12.append("netType", Integer.valueOf(j.netType()));
                                    lo12.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    lo12.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    lo12.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr12 = new Object[2];
                                    objArr12[0] = "isNetChanged";
                                    objArr12[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    lo12.append(objArr12);
                                    lo12.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    lo12.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.dVB != null) {
                                        lo12.append("requestUrl", this.dVB.lg());
                                        lo12.append("dnsMessage", this.dVB.toString());
                                    }
                                    t.e(lo12);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e30) {
                                    }
                                }
                                closeConnection();
                                this.dVA.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet12 = j.isWifiNet();
                                    if ((isWifiNet12 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet12) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                        } else if (j.is2GNet()) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                        } else {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                        }
                                        e.getInstance().result(c, dVar.KH, false, z, isWifiNet12);
                                    }
                                }
                                this.dVy = 0;
                                this.dVA.kU().retBytes = bArr10;
                            }
                        } else {
                            this.dVC = 0 == 0 && m.zi(c) && j.isNetworkAvailableForImmediately();
                            if (this.dVC && this.dVB != null) {
                                this.dVB.al(this.dVA.kU().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.zi(c)) {
                                com.baidu.adp.lib.stats.a lo13 = t.lo();
                                lo13.append("netException", dVar.exception);
                                lo13.append("Url", c);
                                lo13.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                lo13.append("netType", Integer.valueOf(j.netType()));
                                lo13.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                lo13.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                lo13.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr13 = new Object[2];
                                objArr13[0] = "isNetChanged";
                                objArr13[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                lo13.append(objArr13);
                                lo13.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                lo13.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.dVB != null) {
                                    lo13.append("requestUrl", this.dVB.lg());
                                    lo13.append("dnsMessage", this.dVB.toString());
                                }
                                t.e(lo13);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e31) {
                                }
                            }
                            closeConnection();
                            this.dVA.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet13 = j.isWifiNet();
                                if ((isWifiNet13 ? (dVar.KH == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis16 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet13) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                                    } else if (j.is2GNet()) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                                    } else {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                                    }
                                    e.getInstance().result(c, dVar.KH, false, z11, isWifiNet13);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.dVz) {
                    byteArrayOutputStream.write(bArr11, 0, read);
                    i2 = read + i2;
                }
                dVar.KG = -9;
                if (this.dVz) {
                }
            }
        }
        closeConnection();
        this.dVA.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean isWifiNet14 = j.isWifiNet();
            if ((isWifiNet14 ? dVar.KH != null || z17 || i3 >= i + (-1) : true) && m.canUseIp(c) && z16) {
                long currentTimeMillis17 = System.currentTimeMillis() - currentTimeMillis;
                if (isWifiNet14) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dFc);
                } else if (j.is2GNet()) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dFe);
                } else {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().dFd);
                }
                e.getInstance().result(c, dVar.KH, z17, z12, isWifiNet14);
            }
        }
        this.dVy = 0;
        this.dVA.kU().retBytes = bArr10;
    }

    private void wQ(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(dVJ) && (System.currentTimeMillis() - dVL) - (1800000 * (dVK / 3)) >= 0) {
            dVK++;
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
                dVJ = str;
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

    public boolean aXc() {
        return this.dVG;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0021a
    public void cancel() {
        cancelNetConnect();
    }
}
