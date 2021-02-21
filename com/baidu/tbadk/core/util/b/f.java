package com.baidu.tbadk.core.util.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
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
public class f implements b.a {
    private static HttpClient fcb;
    private static String fcg;
    private static int fch;
    private static long fci;
    public static String proxyHost;
    private HttpGet fbU;
    private final com.baidu.adp.lib.network.http.e fbX;
    public boolean fce;
    private final Context mContext;
    private static int fab = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
    private static volatile String fbS = null;
    private static volatile boolean fbT = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams fcc = new BasicHttpParams();
    private com.baidu.adp.lib.network.http.a.c fbY = null;
    private boolean fbZ = false;
    private boolean fca = false;
    private boolean mIsGif = false;
    private boolean fcd = false;
    private int fcf = 0;
    private int fbV = 0;
    private volatile boolean fbW = false;

    static {
        HttpConnectionParams.setConnectionTimeout(fcc, 5000);
        HttpConnectionParams.setSoTimeout(fcc, 30000);
        HttpConnectionParams.setSocketBufferSize(fcc, 1024);
        HttpConnectionParams.setTcpNoDelay(fcc, true);
        HttpClientParams.setRedirecting(fcc, true);
        ConnManagerParams.setMaxConnectionsPerRoute(fcc, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(fcc, 10000L);
        ConnManagerParams.setMaxTotalConnections(fcc, 15);
        HttpProtocolParams.setUserAgent(fcc, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), Constants.SOCKET_PORT_SSL));
        fcb = new DefaultHttpClient(new ThreadSafeClientConnManager(fcc, schemeRegistry), fcc);
        ((DefaultHttpClient) fcb).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.b.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        fcg = null;
        fch = 0;
        fci = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        btf();
        this.fbX = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void btf() {
        synchronized (f.class) {
            if (!fbT) {
                fbT = true;
                btg();
            }
        }
    }

    public static synchronized void btg() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    fbS = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void cancelNetConnect() {
        this.fbW = true;
        this.fbX.lV().MD = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.fbU != null) {
                this.fbU.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aq(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().fbQ) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.isNetWorkAvailable()) {
            this.fce = false;
            try {
                if (j.isMobileNet()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (proxyHost == null) {
                            proxyHost = j.curMobileProxyHost();
                        }
                        if (proxyHost != null && proxyHost.length() > 0) {
                            this.fce = true;
                            if (Bl(proxyHost) && j.isSupportWap()) {
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
                                        this.fbU = e.getInstance().httpGetFactory(sb.toString(), this.fcf, false);
                                    } else {
                                        this.fbU = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.fbU = new HttpGet(sb.toString());
                                }
                                this.fbU.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.fbU.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = fcc.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    fcc.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(proxyHost) || httpHost.getPort() != j.curMobileProxyPort()) {
                                        fcc.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.fbU = e.getInstance().httpGetFactory(str, this.fcf, false);
                                    } else {
                                        this.fbU = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.fbU = new HttpGet(str);
                                }
                                if (fbS != null) {
                                    this.fbU.setHeader(AUTH.PROXY_AUTH_RESP, fbS);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.fbU.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (n.DK(str)) {
                    String host = com.baidu.adp.lib.network.http.a.d.getHost(str);
                    this.fbY = com.baidu.adp.lib.network.http.a.b.mf().bI(host);
                    if (!au.isEmpty(this.fbY.mj())) {
                        this.fbU = ar(str, this.fbY.mj(), host);
                    } else if (this.fbZ) {
                        this.fbY = com.baidu.adp.lib.network.http.a.b.mf().t(host, null);
                        this.fbU = ar(str, this.fbY.mj(), host);
                    } else {
                        this.fbU = new HttpGet(str);
                    }
                } else if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.isMobileNet()) {
                            if (!this.fce || this.fbU == null) {
                                this.fbU = e.getInstance().httpGetFactory(str, this.fcf, false);
                            }
                        } else {
                            this.fbU = e.getInstance().httpGetFactory(str, this.fcf, true);
                        }
                    } else {
                        this.fbU = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.fbU = new HttpGet(str);
                }
                this.fbU.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private HttpGet ar(String str, String str2, String str3) {
        if (this.fca && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://" + str.substring(8);
        }
        if (this.fbY != null && !au.isEmpty(this.fbY.mj())) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String str4 = url.getProtocol() + "://" + str2 + url.getPath();
                HttpGet httpGet = new HttpGet(str4);
                this.fbY.bJ(str4);
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return new HttpGet(str);
    }

    private boolean Bl(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [609=29, 610=14, 611=14, 613=14, 614=14, 615=14, 616=14, 617=14, 618=14, 619=14, 620=14, 621=14, 622=14, 624=14, 625=14, 626=28, 627=14, 628=14, 629=14, 630=14, 631=14, 633=14, 636=14, 637=14, 641=14, 646=14, 647=14, 648=14, 649=14, 650=14, 651=28, 653=14, 654=14, 655=14, 657=14, 658=28, 659=14, 660=14, 662=14, 664=14, 668=7] */
    /* JADX WARN: Removed duplicated region for block: B:1203:0x1468 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:776:0x161d A[Catch: SocketException -> 0x0095, SocketTimeoutException -> 0x027c, HttpException -> 0x0633, SSLException -> 0x0815, IOException -> 0x0a1c, IllegalStateException -> 0x0c2d, Throwable -> 0x187d, all -> 0x1a53, TRY_ENTER, TryCatch #25 {all -> 0x1a53, blocks: (B:16:0x0058, B:18:0x0062, B:84:0x026b, B:23:0x0081, B:25:0x008c, B:26:0x0094, B:142:0x044f, B:216:0x061a, B:218:0x062a, B:219:0x0632, B:276:0x0806, B:278:0x080c, B:279:0x0814, B:336:0x09ed, B:338:0x0a13, B:339:0x0a1b, B:396:0x0bef, B:398:0x0c00, B:400:0x0c09, B:402:0x0c0c, B:404:0x0c24, B:405:0x0c2c, B:462:0x0e07, B:464:0x0e0d, B:466:0x0e29, B:468:0x0e30, B:607:0x11bc, B:609:0x11c7, B:679:0x139c, B:681:0x13b6, B:683:0x13c5, B:688:0x13d2, B:690:0x13fb, B:691:0x1408, B:693:0x1411, B:695:0x1427, B:696:0x142d, B:698:0x1433, B:700:0x1437, B:702:0x1443, B:705:0x1458, B:776:0x161d, B:778:0x1621, B:788:0x165a, B:790:0x167b, B:792:0x1684, B:794:0x168e, B:920:0x1a4d, B:796:0x169b, B:798:0x16a2, B:800:0x16b0, B:803:0x16bf, B:805:0x16c8, B:807:0x16d5, B:809:0x16db, B:866:0x187f, B:408:0x0c2f, B:342:0x0a1e, B:282:0x0817, B:222:0x0635, B:88:0x027e, B:29:0x0097, B:862:0x185d, B:703:0x1451, B:20:0x0068, B:22:0x0071), top: B:1191:0x0058 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        InputStream inputStream;
        String c;
        Throwable th;
        HttpException e;
        IOException e2;
        SSLException e3;
        SocketTimeoutException e4;
        SocketException e5;
        IllegalStateException e6;
        Throwable th2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        long currentTimeMillis2;
        boolean z9;
        HttpResponse execute;
        boolean z10;
        int i2;
        boolean z11;
        boolean z12;
        String value;
        byte[] byteArray;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        int read;
        String obj;
        boolean z13;
        boolean z14;
        Header[] headers;
        byte[] bArr9 = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().fbQ) {
                e.getInstance().init();
            }
        }
        boolean z16 = z15;
        if (i <= 0) {
            i = 5;
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        boolean z17 = false;
        int i3 = 0;
        while (true) {
            if (this.fbW || i3 >= i) {
                break;
            }
            this.fcf = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.fbX.a(dVar);
            dVar.Md = -1;
            inputStream = null;
            c = this.fbX.lU().c(dVar);
            try {
                try {
                    dVar.Md = -2;
                    currentTimeMillis2 = System.currentTimeMillis();
                    if (str == null || str.length() == 0) {
                        aq(c, null, null);
                        if (z16) {
                            dVar.Me = e.getInstance().getCachedCdnIp(this.fcf);
                        }
                    } else {
                        aq(c, str, str2);
                        dVar.Me = str;
                    }
                    dVar.Md = -3;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } catch (IllegalStateException e7) {
                e6 = e7;
            } catch (SocketException e8) {
                e5 = e8;
            } catch (SocketTimeoutException e9) {
                e4 = e9;
            } catch (SSLException e10) {
                e3 = e10;
            } catch (IOException e11) {
                e2 = e11;
            } catch (HttpException e12) {
                e = e12;
            } catch (Throwable th4) {
                th = th4;
            }
            if (this.fbU == null) {
                throw new SocketException("network not available.");
            }
            if (this.fbW) {
                this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                if (this.fbZ && this.fbY != null) {
                    this.fbY.av(this.fbX.lV().mNetErrorCode);
                }
                if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                    com.baidu.adp.lib.stats.a pg = u.pg();
                    pg.append("netException", dVar.exception);
                    pg.append("Url", c);
                    pg.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                    pg.append("netType", Integer.valueOf(j.netType()));
                    pg.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                    pg.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                    pg.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    Object[] objArr = new Object[2];
                    objArr[0] = "isNetChanged";
                    objArr[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                    pg.append(objArr);
                    pg.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                    pg.append("currentActivity", UtilHelper.getTopActivityClassName());
                    if (this.fbY != null) {
                        pg.append("requestUrl", this.fbY.mi());
                        pg.append("dnsMessage", this.fbY.toString());
                    }
                    u.e(pg);
                }
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e13) {
                    }
                }
                closeConnection();
                this.fbX.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean isWifiNet = j.isWifiNet();
                    if ((isWifiNet ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        if (isWifiNet) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                        } else if (j.is2GNet()) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                        } else {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                        }
                        e.getInstance().result(c, dVar.Me, false, z9, isWifiNet);
                    }
                }
            } else {
                dVar.Md = -8;
                execute = fcb.execute(this.fbU);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.fbX.lV().responseCode = execute.getStatusLine().getStatusCode();
                dVar.Mc = this.fbX.lV().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                    dVar.Mk = headers[0].getValue();
                    dVar.Ml = headers[1].getValue();
                }
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.fbX.lV().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.fbV < 1) {
                            closeConnection();
                            this.fbV++;
                            this.fbX.lV().responseCode = 0;
                            i3--;
                            this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                            if (this.fbZ && this.fbY != null) {
                                this.fbY.av(this.fbX.lV().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                com.baidu.adp.lib.stats.a pg2 = u.pg();
                                pg2.append("netException", dVar.exception);
                                pg2.append("Url", c);
                                pg2.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                pg2.append("netType", Integer.valueOf(j.netType()));
                                pg2.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                pg2.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                pg2.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = "isNetChanged";
                                objArr2[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                pg2.append(objArr2);
                                pg2.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                pg2.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.fbY != null) {
                                    pg2.append("requestUrl", this.fbY.mi());
                                    pg2.append("dnsMessage", this.fbY.toString());
                                }
                                u.e(pg2);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            closeConnection();
                            this.fbX.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet2 = j.isWifiNet();
                                if ((isWifiNet2 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet2) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                    } else if (j.is2GNet()) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                    } else {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                    }
                                    e.getInstance().result(c, dVar.Me, false, z14, isWifiNet2);
                                }
                            }
                            i3++;
                            bArr9 = bArr9;
                        } else {
                            this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                            if (this.fbZ && this.fbY != null) {
                                this.fbY.av(this.fbX.lV().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                com.baidu.adp.lib.stats.a pg3 = u.pg();
                                pg3.append("netException", dVar.exception);
                                pg3.append("Url", c);
                                pg3.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                pg3.append("netType", Integer.valueOf(j.netType()));
                                pg3.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                pg3.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                pg3.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = "isNetChanged";
                                objArr3[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                pg3.append(objArr3);
                                pg3.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                pg3.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.fbY != null) {
                                    pg3.append("requestUrl", this.fbY.mi());
                                    pg3.append("dnsMessage", this.fbY.toString());
                                }
                                u.e(pg3);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            closeConnection();
                            this.fbX.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet3 = j.isWifiNet();
                                if ((isWifiNet3 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet3) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                    } else if (j.is2GNet()) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                    } else {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                    }
                                    e.getInstance().result(c, dVar.Me, false, z13, isWifiNet3);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > fab) {
                    this.fbX.lV().mNetErrorCode = -11;
                    dVar.exception = this.mContext.getResources().getString(R.string.data_too_big);
                    this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                    if (this.fbZ && this.fbY != null) {
                        this.fbY.av(this.fbX.lV().mNetErrorCode);
                    }
                    if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                        com.baidu.adp.lib.stats.a pg4 = u.pg();
                        pg4.append("netException", dVar.exception);
                        pg4.append("Url", c);
                        pg4.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                        pg4.append("netType", Integer.valueOf(j.netType()));
                        pg4.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                        pg4.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                        pg4.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = "isNetChanged";
                        objArr4[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                        pg4.append(objArr4);
                        pg4.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                        pg4.append("currentActivity", UtilHelper.getTopActivityClassName());
                        if (this.fbY != null) {
                            pg4.append("requestUrl", this.fbY.mi());
                            pg4.append("dnsMessage", this.fbY.toString());
                        }
                        u.e(pg4);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                        }
                    }
                    closeConnection();
                    this.fbX.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean isWifiNet4 = j.isWifiNet();
                        if ((isWifiNet4 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (isWifiNet4) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                            } else if (j.is2GNet()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                            }
                            e.getInstance().result(c, dVar.Me, false, z10, isWifiNet4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr10 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i4 = 0;
                boolean z18 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z18 = true;
                }
                if (z18) {
                    byte[] bArr11 = new byte[23];
                    int read2 = inputStream.read(bArr11, 0, 23);
                    if (!new String(bArr11, 0, bArr11.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                        byteArrayOutputStream.write(bArr11, 0, read2);
                        i4 = 0 + read2;
                    }
                }
                if (execute.getFirstHeader("Src-Content-Type") != null) {
                    if (DownloadConstants.MIMETYPE_GIF.equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                        this.mIsGif = true;
                        i2 = i4;
                        while (!this.fbW && i2 < fab && (read = inputStream.read(bArr10)) != -1) {
                            byteArrayOutputStream.write(bArr10, 0, read);
                            i2 = read + i2;
                        }
                        dVar.Md = -9;
                        if (this.fbW) {
                            if (i2 >= fab) {
                                this.fbX.lV().mNetErrorCode = -11;
                                dVar.exception = this.mContext.getResources().getString(R.string.data_too_big);
                                break;
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                if (entity.getContentEncoding() == null) {
                                    bArr9 = byteArray;
                                    break;
                                }
                                String value2 = entity.getContentEncoding().getValue();
                                if (value2 == null || !value2.contains("gzip")) {
                                    break;
                                }
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                com.baidu.adp.lib.util.g.decompress(byteArrayInputStream, byteArrayOutputStream2);
                                byteArray = byteArrayOutputStream2.toByteArray();
                                break;
                            } catch (IllegalStateException e17) {
                                e6 = e17;
                                bArr9 = bArr8;
                                this.fbX.lV().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.fbX.lV().mNetErrorCode) + "|" + e6.getClass() + "|" + e6.getMessage() + "|getcontent_illegal_error";
                                this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                                if (this.fbZ && this.fbY != null) {
                                    this.fbY.av(this.fbX.lV().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                    com.baidu.adp.lib.stats.a pg5 = u.pg();
                                    pg5.append("netException", dVar.exception);
                                    pg5.append("Url", c);
                                    pg5.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pg5.append("netType", Integer.valueOf(j.netType()));
                                    pg5.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pg5.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pg5.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr5 = new Object[2];
                                    objArr5[0] = "isNetChanged";
                                    objArr5[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pg5.append(objArr5);
                                    pg5.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pg5.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.fbY != null) {
                                        pg5.append("requestUrl", this.fbY.mi());
                                        pg5.append("dnsMessage", this.fbY.toString());
                                    }
                                    u.e(pg5);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                closeConnection();
                                this.fbX.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet5 = j.isWifiNet();
                                    if ((isWifiNet5 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet5) {
                                            z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                        } else if (j.is2GNet()) {
                                            z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                        } else {
                                            z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                        }
                                        e.getInstance().result(c, dVar.Me, false, z8, isWifiNet5);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (SocketException e19) {
                                e5 = e19;
                                bArr9 = bArr7;
                                this.fbX.lV().mNetErrorCode = -12;
                                dVar.exception = "errorCode:" + String.valueOf(this.fbX.lV().mNetErrorCode) + "|" + e5.getClass() + "|" + e5.getMessage();
                                this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                                if (this.fbZ && this.fbY != null) {
                                    this.fbY.av(this.fbX.lV().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                    com.baidu.adp.lib.stats.a pg6 = u.pg();
                                    pg6.append("netException", dVar.exception);
                                    pg6.append("Url", c);
                                    pg6.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pg6.append("netType", Integer.valueOf(j.netType()));
                                    pg6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pg6.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pg6.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr6 = new Object[2];
                                    objArr6[0] = "isNetChanged";
                                    objArr6[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pg6.append(objArr6);
                                    pg6.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pg6.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.fbY != null) {
                                        pg6.append("requestUrl", this.fbY.mi());
                                        pg6.append("dnsMessage", this.fbY.toString());
                                    }
                                    u.e(pg6);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e20) {
                                    }
                                }
                                closeConnection();
                                this.fbX.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet6 = j.isWifiNet();
                                    if ((isWifiNet6 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet6) {
                                            z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                        } else if (j.is2GNet()) {
                                            z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                        } else {
                                            z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                        }
                                        e.getInstance().result(c, dVar.Me, false, z7, isWifiNet6);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (SocketTimeoutException e21) {
                                e4 = e21;
                                bArr9 = bArr6;
                                this.fbX.lV().mNetErrorCode = -13;
                                dVar.exception = "errorCode:" + String.valueOf(this.fbX.lV().mNetErrorCode) + "|" + e4.getClass() + "|" + e4.getMessage();
                                this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                                if (this.fbZ && this.fbY != null) {
                                    this.fbY.av(this.fbX.lV().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                    com.baidu.adp.lib.stats.a pg7 = u.pg();
                                    pg7.append("netException", dVar.exception);
                                    pg7.append("Url", c);
                                    pg7.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pg7.append("netType", Integer.valueOf(j.netType()));
                                    pg7.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pg7.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pg7.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr7 = new Object[2];
                                    objArr7[0] = "isNetChanged";
                                    objArr7[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pg7.append(objArr7);
                                    pg7.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pg7.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.fbY != null) {
                                        pg7.append("requestUrl", this.fbY.mi());
                                        pg7.append("dnsMessage", this.fbY.toString());
                                    }
                                    u.e(pg7);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e22) {
                                    }
                                }
                                closeConnection();
                                this.fbX.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet7 = j.isWifiNet();
                                    if ((isWifiNet7 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet7) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                        } else if (j.is2GNet()) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                        } else {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                        }
                                        e.getInstance().result(c, dVar.Me, false, z6, isWifiNet7);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (SSLException e23) {
                                e3 = e23;
                                bArr9 = bArr5;
                                this.fbX.lV().mNetErrorCode = -20;
                                dVar.exception = "errorCode:" + String.valueOf(this.fbX.lV().mNetErrorCode) + "|" + e3.getClass() + "|" + e3.getMessage();
                                this.fca = true;
                                this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                                if (this.fbZ && this.fbY != null) {
                                    this.fbY.av(this.fbX.lV().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                    com.baidu.adp.lib.stats.a pg8 = u.pg();
                                    pg8.append("netException", dVar.exception);
                                    pg8.append("Url", c);
                                    pg8.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pg8.append("netType", Integer.valueOf(j.netType()));
                                    pg8.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pg8.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pg8.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr8 = new Object[2];
                                    objArr8[0] = "isNetChanged";
                                    objArr8[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pg8.append(objArr8);
                                    pg8.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pg8.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.fbY != null) {
                                        pg8.append("requestUrl", this.fbY.mi());
                                        pg8.append("dnsMessage", this.fbY.toString());
                                    }
                                    u.e(pg8);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e24) {
                                    }
                                }
                                closeConnection();
                                this.fbX.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet8 = j.isWifiNet();
                                    if ((isWifiNet8 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet8) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                        } else if (j.is2GNet()) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                        } else {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                        }
                                        e.getInstance().result(c, dVar.Me, false, z5, isWifiNet8);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (IOException e25) {
                                e2 = e25;
                                bArr9 = bArr4;
                                this.fbX.lV().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.fbX.lV().mNetErrorCode) + "|" + e2.getClass() + "|" + e2.getMessage();
                                this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                                if (this.fbZ && this.fbY != null) {
                                    this.fbY.av(this.fbX.lV().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                    com.baidu.adp.lib.stats.a pg9 = u.pg();
                                    pg9.append("netException", dVar.exception);
                                    pg9.append("Url", c);
                                    pg9.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pg9.append("netType", Integer.valueOf(j.netType()));
                                    pg9.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pg9.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pg9.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr9 = new Object[2];
                                    objArr9[0] = "isNetChanged";
                                    objArr9[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pg9.append(objArr9);
                                    pg9.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pg9.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.fbY != null) {
                                        pg9.append("requestUrl", this.fbY.mi());
                                        pg9.append("dnsMessage", this.fbY.toString());
                                    }
                                    u.e(pg9);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e26) {
                                    }
                                }
                                closeConnection();
                                this.fbX.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet9 = j.isWifiNet();
                                    if ((isWifiNet9 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet9) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                        } else if (j.is2GNet()) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                        } else {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                        }
                                        e.getInstance().result(c, dVar.Me, false, z4, isWifiNet9);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (HttpException e27) {
                                e = e27;
                                bArr9 = bArr3;
                                this.fbX.lV().mNetErrorCode = -18;
                                dVar.exception = "errorCode:" + String.valueOf(this.fbX.lV().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                                if (this.fbZ && this.fbY != null) {
                                    this.fbY.av(this.fbX.lV().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                    com.baidu.adp.lib.stats.a pg10 = u.pg();
                                    pg10.append("netException", dVar.exception);
                                    pg10.append("Url", c);
                                    pg10.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pg10.append("netType", Integer.valueOf(j.netType()));
                                    pg10.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pg10.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pg10.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr10 = new Object[2];
                                    objArr10[0] = "isNetChanged";
                                    objArr10[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pg10.append(objArr10);
                                    pg10.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pg10.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.fbY != null) {
                                        pg10.append("requestUrl", this.fbY.mi());
                                        pg10.append("dnsMessage", this.fbY.toString());
                                    }
                                    u.e(pg10);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e28) {
                                    }
                                }
                                closeConnection();
                                this.fbX.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet10 = j.isWifiNet();
                                    if ((isWifiNet10 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet10) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                        } else if (j.is2GNet()) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                        } else {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                        }
                                        e.getInstance().result(c, dVar.Me, false, z3, isWifiNet10);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (Throwable th5) {
                                th = th5;
                                bArr9 = bArr;
                                this.fbX.lV().mNetErrorCode = -10;
                                dVar.exception = "errorCode:" + String.valueOf(this.fbX.lV().mNetErrorCode) + "|" + th.getClass() + "|" + th.getMessage();
                                this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                                if (this.fbZ && this.fbY != null) {
                                    this.fbY.av(this.fbX.lV().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                    com.baidu.adp.lib.stats.a pg11 = u.pg();
                                    pg11.append("netException", dVar.exception);
                                    pg11.append("Url", c);
                                    pg11.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pg11.append("netType", Integer.valueOf(j.netType()));
                                    pg11.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pg11.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pg11.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr11 = new Object[2];
                                    objArr11[0] = "isNetChanged";
                                    objArr11[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pg11.append(objArr11);
                                    pg11.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pg11.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.fbY != null) {
                                        pg11.append("requestUrl", this.fbY.mi());
                                        pg11.append("dnsMessage", this.fbY.toString());
                                    }
                                    u.e(pg11);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e29) {
                                    }
                                }
                                closeConnection();
                                this.fbX.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet11 = j.isWifiNet();
                                    if ((isWifiNet11 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                        long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet11) {
                                            z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                        } else if (j.is2GNet()) {
                                            z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                        } else {
                                            z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                        }
                                        e.getInstance().result(c, dVar.Me, false, z, isWifiNet11);
                                    }
                                }
                                this.fbV = 0;
                                this.fbX.lV().retBytes = bArr9;
                            }
                        } else {
                            this.fbZ = 0 == 0 && n.DK(c) && j.isNetworkAvailableForImmediately();
                            if (this.fbZ && this.fbY != null) {
                                this.fbY.av(this.fbX.lV().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && n.DK(c)) {
                                com.baidu.adp.lib.stats.a pg12 = u.pg();
                                pg12.append("netException", dVar.exception);
                                pg12.append("Url", c);
                                pg12.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                pg12.append("netType", Integer.valueOf(j.netType()));
                                pg12.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                pg12.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                pg12.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                Object[] objArr12 = new Object[2];
                                objArr12[0] = "isNetChanged";
                                objArr12[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                pg12.append(objArr12);
                                pg12.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                pg12.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.fbY != null) {
                                    pg12.append("requestUrl", this.fbY.mi());
                                    pg12.append("dnsMessage", this.fbY.toString());
                                }
                                u.e(pg12);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e30) {
                                }
                            }
                            closeConnection();
                            this.fbX.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet12 = j.isWifiNet();
                                if ((isWifiNet12 ? (dVar.Me == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && n.canUseIp(c) && z16) {
                                    long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet12) {
                                        z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                                    } else if (j.is2GNet()) {
                                        z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                                    } else {
                                        z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                                    }
                                    e.getInstance().result(c, dVar.Me, false, z11, isWifiNet12);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.fbW) {
                    byteArrayOutputStream.write(bArr10, 0, read);
                    i2 = read + i2;
                }
                dVar.Md = -9;
                if (this.fbW) {
                }
            }
        }
        bArr9 = byteArray;
        dVar.downloadSize = i2;
        dVar.retry = i3 + 1;
        dVar.Ma = System.currentTimeMillis() - currentTimeMillis2;
        if (execute.getFirstHeader("Error-Message") != null) {
            Header firstHeader = execute.getFirstHeader("Error-Message");
            if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                this.fcd = false;
            } else {
                this.fcd = true;
            }
        }
        if (i2 > 0 && (this.fbX.lV().responseCode == 200 || this.fbX.lV().responseCode == 302)) {
            z17 = true;
        }
        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
            Bm(value);
        }
        this.fbZ = !z17 && n.DK(c) && j.isNetworkAvailableForImmediately();
        if (this.fbZ && this.fbY != null) {
            this.fbY.av(this.fbX.lV().mNetErrorCode);
        }
        if (!z17 && i3 == i - 1 && n.DK(c)) {
            com.baidu.adp.lib.stats.a pg13 = u.pg();
            pg13.append("netException", dVar.exception);
            pg13.append("Url", c);
            pg13.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
            pg13.append("netType", Integer.valueOf(j.netType()));
            pg13.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
            pg13.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
            pg13.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
            Object[] objArr13 = new Object[2];
            objArr13[0] = "isNetChanged";
            objArr13[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
            pg13.append(objArr13);
            pg13.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
            pg13.append("currentActivity", UtilHelper.getTopActivityClassName());
            if (this.fbY != null) {
                pg13.append("requestUrl", this.fbY.mi());
                pg13.append("dnsMessage", this.fbY.toString());
            }
            u.e(pg13);
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e31) {
            }
        }
        closeConnection();
        this.fbX.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean isWifiNet13 = j.isWifiNet();
            if ((isWifiNet13 ? dVar.Me != null || z17 || i3 >= i + (-1) : true) && n.canUseIp(c) && z16) {
                long currentTimeMillis16 = System.currentTimeMillis() - currentTimeMillis;
                if (isWifiNet13) {
                    z12 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().eJf);
                } else if (j.is2GNet()) {
                    z12 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().eJh);
                } else {
                    z12 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().eJg);
                }
                e.getInstance().result(c, dVar.Me, z17, z12, isWifiNet13);
            }
        }
        this.fbV = 0;
        this.fbX.lV().retBytes = bArr9;
    }

    private void Bm(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(fcg) && (System.currentTimeMillis() - fci) - (1800000 * (fch / 3)) >= 0) {
            fch++;
            try {
                char[] charArray = TbadkCoreApplication.getInst().getCuid().toCharArray();
                StringBuilder sb = new StringBuilder();
                sb.append("http://");
                sb.append(str);
                int i = 0;
                for (int i2 = 0; i2 < charArray.length && i < 32; i2++) {
                    if (Character.isLetterOrDigit(charArray[i2])) {
                        sb.append(charArray[i2]);
                        i++;
                    }
                }
                sb.append(".tieba.galileo.baiduyundns.com");
                final URL url = new URL(sb.toString());
                fcg = str;
                new Thread(new Runnable() { // from class: com.baidu.tbadk.core.util.b.f.2
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

    public boolean bth() {
        return this.fcd;
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        cancelNetConnect();
    }
}
