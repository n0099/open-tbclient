package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
    public static String ckR;
    private static HttpClient ckS;
    private static String ckX;
    private static int ckY;
    private static long ckZ;
    private HttpGet ckK;
    private final com.baidu.adp.lib.network.http.e ckN;
    public boolean ckV;
    private final Context mContext;
    private static int cjl = 5242880;
    private static volatile String ckI = null;
    private static volatile boolean ckJ = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ckT = new BasicHttpParams();
    private com.baidu.tbadk.core.util.b.c ckO = null;
    private boolean ckP = false;
    private boolean ckQ = false;
    private boolean mIsGif = false;
    private boolean ckU = false;
    private int ckW = 0;
    private int ckL = 0;
    private volatile boolean ckM = false;

    static {
        HttpConnectionParams.setConnectionTimeout(ckT, 5000);
        HttpConnectionParams.setSoTimeout(ckT, 30000);
        HttpConnectionParams.setSocketBufferSize(ckT, 1024);
        HttpConnectionParams.setTcpNoDelay(ckT, true);
        HttpClientParams.setRedirecting(ckT, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ckT, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ckT, 10000L);
        ConnManagerParams.setMaxTotalConnections(ckT, 15);
        HttpProtocolParams.setUserAgent(ckT, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ckS = new DefaultHttpClient(new ThreadSafeClientConnManager(ckT, schemeRegistry), ckT);
        ((DefaultHttpClient) ckS).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.a.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        ckX = null;
        ckY = 0;
        ckZ = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        amV();
        this.ckN = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void amV() {
        synchronized (f.class) {
            if (!ckJ) {
                ckJ = true;
                amW();
            }
        }
    }

    public static synchronized void amW() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    ckI = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void cancelNetConnect() {
        this.ckM = true;
        this.ckN.fK().pz = true;
        amX();
    }

    private void amX() {
        try {
            if (this.ckK != null) {
                this.ckK.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void J(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().ckG) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.isNetWorkAvailable()) {
            this.ckV = false;
            try {
                if (j.isMobileNet()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ckR == null) {
                            ckR = j.curMobileProxyHost();
                        }
                        if (ckR != null && ckR.length() > 0) {
                            this.ckV = true;
                            if (nX(ckR) && j.isSupportWap()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ckR);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ckK = e.getInstance().httpGetFactory(sb.toString(), this.ckW, false);
                                    } else {
                                        this.ckK = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ckK = new HttpGet(sb.toString());
                                }
                                this.ckK.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ckK.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ckT.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ckT.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(ckR, j.curMobileProxyPort()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ckR) || httpHost.getPort() != j.curMobileProxyPort()) {
                                        ckT.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(ckR, j.curMobileProxyPort()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ckK = e.getInstance().httpGetFactory(str, this.ckW, false);
                                    } else {
                                        this.ckK = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ckK = new HttpGet(str);
                                }
                                if (ckI != null) {
                                    this.ckK.setHeader(AUTH.PROXY_AUTH_RESP, ckI);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ckK.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (k.ql(str)) {
                    String host = com.baidu.tbadk.core.util.b.d.getHost(str);
                    this.ckO = com.baidu.tbadk.core.util.b.b.and().oc(host);
                    if (!aq.isEmpty(this.ckO.anh())) {
                        this.ckK = K(str, this.ckO.anh(), host);
                    } else if (this.ckP) {
                        this.ckO = com.baidu.tbadk.core.util.b.b.and().od(host);
                        this.ckK = K(str, this.ckO.anh(), host);
                    } else {
                        this.ckK = new HttpGet(str);
                    }
                } else if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.isMobileNet()) {
                            if (!this.ckV || this.ckK == null) {
                                this.ckK = e.getInstance().httpGetFactory(str, this.ckW, false);
                            }
                        } else {
                            this.ckK = e.getInstance().httpGetFactory(str, this.ckW, true);
                        }
                    } else {
                        this.ckK = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.ckK = new HttpGet(str);
                }
                this.ckK.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private HttpGet K(String str, String str2, String str3) {
        if (this.ckQ && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://" + str.substring(8);
        }
        if (this.ckO != null && !aq.isEmpty(this.ckO.anh())) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String str4 = url.getProtocol() + "://" + str2 + url.getPath();
                HttpGet httpGet = new HttpGet(str4);
                this.ckO.og(str4);
                httpGet.addHeader(HTTP.TARGET_HOST, str3);
                return httpGet;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return new HttpGet(str);
    }

    private boolean nX(String str) {
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
        r13.downloadSize = r6;
        r13.oV = r10 + 1;
        r13.oU = java.lang.System.currentTimeMillis() - r18;
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
        r27.ckU = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x1481, code lost:
        if (r6 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x148f, code lost:
        if (r27.ckN.fK().responseCode == 200) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x149d, code lost:
        if (r27.ckN.fK().responseCode != 302) goto L267;
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
        nY(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:756:0x14c1, code lost:
        if (r7 != false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:758:0x14c7, code lost:
        if (com.baidu.tbadk.util.k.ql(r5) == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:760:0x14cd, code lost:
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() == false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:761:0x14cf, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:762:0x14d0, code lost:
        r27.ckP = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:763:0x14d8, code lost:
        if (r27.ckP == false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x14de, code lost:
        if (r27.ckO == null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:766:0x14e0, code lost:
        r27.ckO.ix(r27.ckN.fK().mNetErrorCode);
     */
    /* JADX WARN: Code restructure failed: missing block: B:767:0x14f1, code lost:
        if (r7 != false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:769:0x14f5, code lost:
        if (r10 != (r30 - 1)) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:771:0x14fb, code lost:
        if (com.baidu.tbadk.util.k.ql(r5) == false) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:772:0x14fd, code lost:
        r6 = com.baidu.tbadk.core.util.s.fU();
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
        if (r27.ckO == null) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:780:0x15c1, code lost:
        r6.append("requestUrl", r27.ckO.ang());
        r6.append("dnsMessage", r27.ckO.toString());
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
        r27.ckU = true;
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
    public void i(String str, String str2, int i) {
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
            if (!e.getInstance().ckG) {
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
            if (this.ckM || i3 >= i) {
                break;
            }
            this.ckW = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.ckN.a(dVar);
            dVar.oZ = -1;
            InputStream inputStream2 = null;
            c = this.ckN.fJ().c(dVar);
            try {
                dVar.oZ = -2;
                long currentTimeMillis3 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    J(c, null, null);
                    if (z16) {
                        dVar.pa = e.getInstance().getCachedCdnIp(this.ckW);
                    }
                } else {
                    J(c, str, str2);
                    dVar.pa = str;
                }
                dVar.oZ = -3;
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
            if (this.ckK == null) {
                throw new SocketException("network not available.");
            }
            if (this.ckM) {
                this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                if (this.ckP && this.ckO != null) {
                    this.ckO.ix(this.ckN.fK().mNetErrorCode);
                }
                if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                    com.baidu.adp.lib.stats.a fU = s.fU();
                    fU.append("netException", dVar.exception);
                    fU.append("Url", c);
                    fU.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                    fU.append("netType", Integer.valueOf(j.netType()));
                    fU.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                    fU.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                    fU.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    Object[] objArr = new Object[2];
                    objArr[0] = "isNetChanged";
                    objArr[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                    fU.append(objArr);
                    fU.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                    fU.append("currentActivity", UtilHelper.getTopActivityClassName());
                    if (this.ckO != null) {
                        fU.append("requestUrl", this.ckO.ang());
                        fU.append("dnsMessage", this.ckO.toString());
                    }
                    s.d(fU);
                }
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e7) {
                    }
                }
                amX();
                this.ckN.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean isWifiNet2 = j.isWifiNet();
                    if ((isWifiNet2 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        if (isWifiNet2) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                        } else if (j.is2GNet()) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                        } else {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                        }
                        e.getInstance().result(c, dVar.pa, false, z9, isWifiNet2);
                    }
                }
            } else {
                dVar.oZ = -8;
                HttpResponse execute = ckS.execute(this.ckK);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ckN.fK().responseCode = execute.getStatusLine().getStatusCode();
                dVar.oY = this.ckN.fK().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            dVar.pf = headers[0].getValue();
                            dVar.pg = headers[1].getValue();
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
                    this.ckN.fK().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.ckL < 1) {
                            amX();
                            this.ckL++;
                            this.ckN.fK().responseCode = 0;
                            i3--;
                            this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                            if (this.ckP && this.ckO != null) {
                                this.ckO.ix(this.ckN.fK().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                com.baidu.adp.lib.stats.a fU2 = s.fU();
                                fU2.append("netException", dVar.exception);
                                fU2.append("Url", c);
                                fU2.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                fU2.append("netType", Integer.valueOf(j.netType()));
                                fU2.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                fU2.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                fU2.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = "isNetChanged";
                                objArr2[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                fU2.append(objArr2);
                                fU2.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                fU2.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.ckO != null) {
                                    fU2.append("requestUrl", this.ckO.ang());
                                    fU2.append("dnsMessage", this.ckO.toString());
                                }
                                s.d(fU2);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            amX();
                            this.ckN.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet3 = j.isWifiNet();
                                if ((isWifiNet3 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet3) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                    } else if (j.is2GNet()) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                    } else {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                    }
                                    e.getInstance().result(c, dVar.pa, false, z14, isWifiNet3);
                                }
                            }
                            i3++;
                            bArr10 = bArr10;
                        } else {
                            this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                            if (this.ckP && this.ckO != null) {
                                this.ckO.ix(this.ckN.fK().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                com.baidu.adp.lib.stats.a fU3 = s.fU();
                                fU3.append("netException", dVar.exception);
                                fU3.append("Url", c);
                                fU3.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                fU3.append("netType", Integer.valueOf(j.netType()));
                                fU3.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                fU3.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                fU3.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = "isNetChanged";
                                objArr3[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                fU3.append(objArr3);
                                fU3.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                fU3.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.ckO != null) {
                                    fU3.append("requestUrl", this.ckO.ang());
                                    fU3.append("dnsMessage", this.ckO.toString());
                                }
                                s.d(fU3);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            amX();
                            this.ckN.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet4 = j.isWifiNet();
                                if ((isWifiNet4 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet4) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                    } else if (j.is2GNet()) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                    } else {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                    }
                                    e.getInstance().result(c, dVar.pa, false, z13, isWifiNet4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > cjl) {
                    this.ckN.fK().mNetErrorCode = -11;
                    dVar.exception = this.mContext.getResources().getString(R.string.data_too_big);
                    this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                    if (this.ckP && this.ckO != null) {
                        this.ckO.ix(this.ckN.fK().mNetErrorCode);
                    }
                    if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                        com.baidu.adp.lib.stats.a fU4 = s.fU();
                        fU4.append("netException", dVar.exception);
                        fU4.append("Url", c);
                        fU4.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                        fU4.append("netType", Integer.valueOf(j.netType()));
                        fU4.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                        fU4.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                        fU4.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = "isNetChanged";
                        objArr4[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                        fU4.append(objArr4);
                        fU4.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                        fU4.append("currentActivity", UtilHelper.getTopActivityClassName());
                        if (this.ckO != null) {
                            fU4.append("requestUrl", this.ckO.ang());
                            fU4.append("dnsMessage", this.ckO.toString());
                        }
                        s.d(fU4);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                        }
                    }
                    amX();
                    this.ckN.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean isWifiNet5 = j.isWifiNet();
                        if ((isWifiNet5 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (isWifiNet5) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                            } else if (j.is2GNet()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                            }
                            e.getInstance().result(c, dVar.pa, false, z10, isWifiNet5);
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
                        while (!this.ckM && i2 < cjl && (read = inputStream.read(bArr11)) != -1) {
                            byteArrayOutputStream.write(bArr11, 0, read);
                            i2 = read + i2;
                        }
                        dVar.oZ = -9;
                        if (this.ckM) {
                            if (i2 >= cjl) {
                                this.ckN.fK().mNetErrorCode = -11;
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
                                    this.ckN.fK().mNetErrorCode = -12;
                                    dVar.exception = "errorCode:" + String.valueOf(this.ckN.fK().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                    this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                                    if (this.ckP && this.ckO != null) {
                                        this.ckO.ix(this.ckN.fK().mNetErrorCode);
                                    }
                                    if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                        com.baidu.adp.lib.stats.a fU5 = s.fU();
                                        fU5.append("netException", dVar.exception);
                                        fU5.append("Url", c);
                                        fU5.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                        fU5.append("netType", Integer.valueOf(j.netType()));
                                        fU5.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        fU5.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                        fU5.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr5 = new Object[2];
                                        objArr5[0] = "isNetChanged";
                                        objArr5[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                        fU5.append(objArr5);
                                        fU5.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        fU5.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.ckO != null) {
                                            fU5.append("requestUrl", this.ckO.ang());
                                            fU5.append("dnsMessage", this.ckO.toString());
                                        }
                                        s.d(fU5);
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    amX();
                                    this.ckN.b(dVar);
                                    if ((str == null || str.length() == 0) && c != null) {
                                        boolean isWifiNet6 = j.isWifiNet();
                                        if ((isWifiNet6 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                            long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                            if (isWifiNet6) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                            } else if (j.is2GNet()) {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                            } else {
                                                z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                            }
                                            e.getInstance().result(c, dVar.pa, false, z8, isWifiNet6);
                                        }
                                    }
                                    i3++;
                                    bArr10 = bArr10;
                                } catch (Throwable th5) {
                                    inputStream = inputStream2;
                                    bArr = bArr10;
                                    th = th5;
                                    this.ckP = 0 != 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                                    if (this.ckP && this.ckO != null) {
                                        this.ckO.ix(this.ckN.fK().mNetErrorCode);
                                    }
                                    if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                        com.baidu.adp.lib.stats.a fU6 = s.fU();
                                        fU6.append("netException", dVar.exception);
                                        fU6.append("Url", c);
                                        fU6.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                        fU6.append("netType", Integer.valueOf(j.netType()));
                                        fU6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                        fU6.append("downloadFileSize", Integer.valueOf(bArr != null ? bArr.length : 0));
                                        fU6.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                        Object[] objArr6 = new Object[2];
                                        objArr6[0] = "isNetChanged";
                                        objArr6[1] = Boolean.valueOf(j.getNetChangedTime() <= currentTimeMillis2);
                                        fU6.append(objArr6);
                                        fU6.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                        fU6.append("currentActivity", UtilHelper.getTopActivityClassName());
                                        if (this.ckO != null) {
                                            fU6.append("requestUrl", this.ckO.ang());
                                            fU6.append("dnsMessage", this.ckO.toString());
                                        }
                                        s.d(fU6);
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e19) {
                                        }
                                    }
                                    amX();
                                    this.ckN.b(dVar);
                                    if ((str != null || str.length() == 0) && c != null) {
                                        isWifiNet = j.isWifiNet();
                                        if ((isWifiNet ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (!isWifiNet) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                            } else if (j.is2GNet()) {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                            } else {
                                                z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                            }
                                            e.getInstance().result(c, dVar.pa, false, z7, isWifiNet);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e20) {
                                bArr10 = bArr8;
                                e = e20;
                                this.ckN.fK().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.ckN.fK().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                                if (this.ckP && this.ckO != null) {
                                    this.ckO.ix(this.ckN.fK().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                    com.baidu.adp.lib.stats.a fU7 = s.fU();
                                    fU7.append("netException", dVar.exception);
                                    fU7.append("Url", c);
                                    fU7.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    fU7.append("netType", Integer.valueOf(j.netType()));
                                    fU7.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    fU7.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    fU7.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr7 = new Object[2];
                                    objArr7[0] = "isNetChanged";
                                    objArr7[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    fU7.append(objArr7);
                                    fU7.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    fU7.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.ckO != null) {
                                        fU7.append("requestUrl", this.ckO.ang());
                                        fU7.append("dnsMessage", this.ckO.toString());
                                    }
                                    s.d(fU7);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                amX();
                                this.ckN.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet7 = j.isWifiNet();
                                    if ((isWifiNet7 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet7) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                        } else if (j.is2GNet()) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                        } else {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                        }
                                        e.getInstance().result(c, dVar.pa, false, z6, isWifiNet7);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (IllegalStateException e22) {
                                bArr10 = bArr7;
                                e = e22;
                                this.ckN.fK().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.ckN.fK().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                                if (this.ckP && this.ckO != null) {
                                    this.ckO.ix(this.ckN.fK().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                    com.baidu.adp.lib.stats.a fU8 = s.fU();
                                    fU8.append("netException", dVar.exception);
                                    fU8.append("Url", c);
                                    fU8.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    fU8.append("netType", Integer.valueOf(j.netType()));
                                    fU8.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    fU8.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    fU8.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr8 = new Object[2];
                                    objArr8[0] = "isNetChanged";
                                    objArr8[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    fU8.append(objArr8);
                                    fU8.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    fU8.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.ckO != null) {
                                        fU8.append("requestUrl", this.ckO.ang());
                                        fU8.append("dnsMessage", this.ckO.toString());
                                    }
                                    s.d(fU8);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e23) {
                                    }
                                }
                                amX();
                                this.ckN.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet8 = j.isWifiNet();
                                    if ((isWifiNet8 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet8) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                        } else if (j.is2GNet()) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                        } else {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                        }
                                        e.getInstance().result(c, dVar.pa, false, z5, isWifiNet8);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SocketTimeoutException e24) {
                                bArr10 = bArr6;
                                e = e24;
                                this.ckN.fK().mNetErrorCode = -13;
                                dVar.exception = "errorCode:" + String.valueOf(this.ckN.fK().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                                if (this.ckP && this.ckO != null) {
                                    this.ckO.ix(this.ckN.fK().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                    com.baidu.adp.lib.stats.a fU9 = s.fU();
                                    fU9.append("netException", dVar.exception);
                                    fU9.append("Url", c);
                                    fU9.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    fU9.append("netType", Integer.valueOf(j.netType()));
                                    fU9.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    fU9.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    fU9.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr9 = new Object[2];
                                    objArr9[0] = "isNetChanged";
                                    objArr9[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    fU9.append(objArr9);
                                    fU9.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    fU9.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.ckO != null) {
                                        fU9.append("requestUrl", this.ckO.ang());
                                        fU9.append("dnsMessage", this.ckO.toString());
                                    }
                                    s.d(fU9);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e25) {
                                    }
                                }
                                amX();
                                this.ckN.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet9 = j.isWifiNet();
                                    if ((isWifiNet9 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet9) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                        } else if (j.is2GNet()) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                        } else {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                        }
                                        e.getInstance().result(c, dVar.pa, false, z4, isWifiNet9);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (SSLException e26) {
                                bArr10 = bArr5;
                                e = e26;
                                this.ckN.fK().mNetErrorCode = -20;
                                dVar.exception = "errorCode:" + String.valueOf(this.ckN.fK().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.ckQ = true;
                                this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                                if (this.ckP && this.ckO != null) {
                                    this.ckO.ix(this.ckN.fK().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                    com.baidu.adp.lib.stats.a fU10 = s.fU();
                                    fU10.append("netException", dVar.exception);
                                    fU10.append("Url", c);
                                    fU10.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    fU10.append("netType", Integer.valueOf(j.netType()));
                                    fU10.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    fU10.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    fU10.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr10 = new Object[2];
                                    objArr10[0] = "isNetChanged";
                                    objArr10[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    fU10.append(objArr10);
                                    fU10.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    fU10.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.ckO != null) {
                                        fU10.append("requestUrl", this.ckO.ang());
                                        fU10.append("dnsMessage", this.ckO.toString());
                                    }
                                    s.d(fU10);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e27) {
                                    }
                                }
                                amX();
                                this.ckN.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet10 = j.isWifiNet();
                                    if ((isWifiNet10 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet10) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                        } else if (j.is2GNet()) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                        } else {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                        }
                                        e.getInstance().result(c, dVar.pa, false, z3, isWifiNet10);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (HttpException e28) {
                                bArr10 = bArr4;
                                e = e28;
                                this.ckN.fK().mNetErrorCode = -18;
                                dVar.exception = "errorCode:" + String.valueOf(this.ckN.fK().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                                if (this.ckP && this.ckO != null) {
                                    this.ckO.ix(this.ckN.fK().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                    com.baidu.adp.lib.stats.a fU11 = s.fU();
                                    fU11.append("netException", dVar.exception);
                                    fU11.append("Url", c);
                                    fU11.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    fU11.append("netType", Integer.valueOf(j.netType()));
                                    fU11.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    fU11.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    fU11.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr11 = new Object[2];
                                    objArr11[0] = "isNetChanged";
                                    objArr11[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    fU11.append(objArr11);
                                    fU11.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    fU11.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.ckO != null) {
                                        fU11.append("requestUrl", this.ckO.ang());
                                        fU11.append("dnsMessage", this.ckO.toString());
                                    }
                                    s.d(fU11);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e29) {
                                    }
                                }
                                amX();
                                this.ckN.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet11 = j.isWifiNet();
                                    if ((isWifiNet11 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                        long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet11) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                        } else if (j.is2GNet()) {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                        } else {
                                            z2 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                        }
                                        e.getInstance().result(c, dVar.pa, false, z2, isWifiNet11);
                                    }
                                }
                                i3++;
                                bArr10 = bArr10;
                            } catch (Throwable th6) {
                                bArr10 = bArr2;
                                th = th6;
                                this.ckN.fK().mNetErrorCode = -10;
                                dVar.exception = "errorCode:" + String.valueOf(this.ckN.fK().mNetErrorCode) + "|" + th.getClass() + "|" + th.getMessage();
                                this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                                if (this.ckP && this.ckO != null) {
                                    this.ckO.ix(this.ckN.fK().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                    com.baidu.adp.lib.stats.a fU12 = s.fU();
                                    fU12.append("netException", dVar.exception);
                                    fU12.append("Url", c);
                                    fU12.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    fU12.append("netType", Integer.valueOf(j.netType()));
                                    fU12.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    fU12.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                    fU12.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                    Object[] objArr12 = new Object[2];
                                    objArr12[0] = "isNetChanged";
                                    objArr12[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                    fU12.append(objArr12);
                                    fU12.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    fU12.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.ckO != null) {
                                        fU12.append("requestUrl", this.ckO.ang());
                                        fU12.append("dnsMessage", this.ckO.toString());
                                    }
                                    s.d(fU12);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e30) {
                                    }
                                }
                                amX();
                                this.ckN.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet12 = j.isWifiNet();
                                    if ((isWifiNet12 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                        long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet12) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                        } else if (j.is2GNet()) {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                        } else {
                                            z = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                        }
                                        e.getInstance().result(c, dVar.pa, false, z, isWifiNet12);
                                    }
                                }
                                this.ckL = 0;
                                this.ckN.fK().retBytes = bArr10;
                            }
                        } else {
                            this.ckP = 0 == 0 && k.ql(c) && j.isNetworkAvailableForImmediately();
                            if (this.ckP && this.ckO != null) {
                                this.ckO.ix(this.ckN.fK().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && k.ql(c)) {
                                com.baidu.adp.lib.stats.a fU13 = s.fU();
                                fU13.append("netException", dVar.exception);
                                fU13.append("Url", c);
                                fU13.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                fU13.append("netType", Integer.valueOf(j.netType()));
                                fU13.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                fU13.append("downloadFileSize", Integer.valueOf(bArr10 != null ? bArr10.length : 0));
                                fU13.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                Object[] objArr13 = new Object[2];
                                objArr13[0] = "isNetChanged";
                                objArr13[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis2);
                                fU13.append(objArr13);
                                fU13.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                fU13.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.ckO != null) {
                                    fU13.append("requestUrl", this.ckO.ang());
                                    fU13.append("dnsMessage", this.ckO.toString());
                                }
                                s.d(fU13);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e31) {
                                }
                            }
                            amX();
                            this.ckN.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet13 = j.isWifiNet();
                                if ((isWifiNet13 ? (dVar.pa == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && k.canUseIp(c) && z16) {
                                    long currentTimeMillis16 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet13) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                                    } else if (j.is2GNet()) {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                                    } else {
                                        z11 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                                    }
                                    e.getInstance().result(c, dVar.pa, false, z11, isWifiNet13);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.ckM) {
                    byteArrayOutputStream.write(bArr11, 0, read);
                    i2 = read + i2;
                }
                dVar.oZ = -9;
                if (this.ckM) {
                }
            }
        }
        amX();
        this.ckN.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean isWifiNet14 = j.isWifiNet();
            if ((isWifiNet14 ? dVar.pa != null || z17 || i3 >= i + (-1) : true) && k.canUseIp(c) && z16) {
                long currentTimeMillis17 = System.currentTimeMillis() - currentTimeMillis;
                if (isWifiNet14) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().bVu);
                } else if (j.is2GNet()) {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().bVw);
                } else {
                    z12 = currentTimeMillis17 > ((long) e.getInstance().getCDNImageTimeData().bVv);
                }
                e.getInstance().result(c, dVar.pa, z17, z12, isWifiNet14);
            }
        }
        this.ckL = 0;
        this.ckN.fK().retBytes = bArr10;
    }

    private void nY(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !str.equals(ckX) && (System.currentTimeMillis() - ckZ) - (1800000 * (ckY / 3)) >= 0) {
            ckY++;
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
                ckX = str;
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

    public boolean amY() {
        return this.ckU;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        cancelNetConnect();
    }
}
