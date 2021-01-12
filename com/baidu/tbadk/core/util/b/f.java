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
import com.baidu.tbadk.core.util.at;
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
public class f implements b.a {
    private static HttpClient eZM;
    private static String eZR;
    private static int eZS;
    private static long eZT;
    public static String proxyHost;
    private HttpGet eZF;
    private final com.baidu.adp.lib.network.http.e eZI;
    public boolean eZP;
    private final Context mContext;
    private static int eXM = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
    private static volatile String eZD = null;
    private static volatile boolean eZE = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams eZN = new BasicHttpParams();
    private com.baidu.adp.lib.network.http.a.c eZJ = null;
    private boolean eZK = false;
    private boolean eZL = false;
    private boolean mIsGif = false;
    private boolean eZO = false;
    private int eZQ = 0;
    private int eZG = 0;
    private volatile boolean eZH = false;

    static {
        HttpConnectionParams.setConnectionTimeout(eZN, 5000);
        HttpConnectionParams.setSoTimeout(eZN, 30000);
        HttpConnectionParams.setSocketBufferSize(eZN, 1024);
        HttpConnectionParams.setTcpNoDelay(eZN, true);
        HttpClientParams.setRedirecting(eZN, true);
        ConnManagerParams.setMaxConnectionsPerRoute(eZN, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(eZN, 10000L);
        ConnManagerParams.setMaxTotalConnections(eZN, 15);
        HttpProtocolParams.setUserAgent(eZN, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), Constants.SOCKET_PORT_SSL));
        eZM = new DefaultHttpClient(new ThreadSafeClientConnManager(eZN, schemeRegistry), eZN);
        ((DefaultHttpClient) eZM).setRedirectHandler(new DefaultRedirectHandler() { // from class: com.baidu.tbadk.core.util.b.f.1
            @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
            public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
                return false;
            }
        });
        eZR = null;
        eZS = 0;
        eZT = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        bsL();
        this.eZI = eVar;
        this.mContext = TbadkCoreApplication.getInst().getApp();
    }

    public static void bsL() {
        synchronized (f.class) {
            if (!eZE) {
                eZE = true;
                bsM();
            }
        }
    }

    public static synchronized void bsM() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    eZD = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((string + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void cancelNetConnect() {
        this.eZH = true;
        this.eZI.lW().MF = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.eZF != null) {
                this.eZF.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void ao(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().eZB) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (j.isNetWorkAvailable()) {
            this.eZP = false;
            try {
                if (j.isMobileNet()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (proxyHost == null) {
                            proxyHost = j.curMobileProxyHost();
                        }
                        if (proxyHost != null && proxyHost.length() > 0) {
                            this.eZP = true;
                            if (AU(proxyHost) && j.isSupportWap()) {
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
                                        this.eZF = e.getInstance().httpGetFactory(sb.toString(), this.eZQ, false);
                                    } else {
                                        this.eZF = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.eZF = new HttpGet(sb.toString());
                                }
                                this.eZF.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.eZF.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = eZN.getParameter(ConnRoutePNames.DEFAULT_PROXY);
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    eZN.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(proxyHost) || httpHost.getPort() != j.curMobileProxyPort()) {
                                        eZN.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(proxyHost, j.curMobileProxyPort()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.eZF = e.getInstance().httpGetFactory(str, this.eZQ, false);
                                    } else {
                                        this.eZF = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.eZF = new HttpGet(str);
                                }
                                if (eZD != null) {
                                    this.eZF.setHeader(AUTH.PROXY_AUTH_RESP, eZD);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.eZF.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (m.Du(str)) {
                    String host = com.baidu.adp.lib.network.http.a.d.getHost(str);
                    this.eZJ = com.baidu.adp.lib.network.http.a.b.mg().bI(host);
                    if (!at.isEmpty(this.eZJ.mk())) {
                        this.eZF = ap(str, this.eZJ.mk(), host);
                    } else if (this.eZK) {
                        this.eZJ = com.baidu.adp.lib.network.http.a.b.mg().x(host, null);
                        this.eZF = ap(str, this.eZJ.mk(), host);
                    } else {
                        this.eZF = new HttpGet(str);
                    }
                } else if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (j.isMobileNet()) {
                            if (!this.eZP || this.eZF == null) {
                                this.eZF = e.getInstance().httpGetFactory(str, this.eZQ, false);
                            }
                        } else {
                            this.eZF = e.getInstance().httpGetFactory(str, this.eZQ, true);
                        }
                    } else {
                        this.eZF = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.eZF = new HttpGet(str);
                }
                this.eZF.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private HttpGet ap(String str, String str2, String str3) {
        if (this.eZL && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://" + str.substring(8);
        }
        if (this.eZJ != null && !at.isEmpty(this.eZJ.mk())) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String str4 = url.getProtocol() + "://" + str2 + url.getPath();
                HttpGet httpGet = new HttpGet(str4);
                this.eZJ.bJ(str4);
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return new HttpGet(str);
    }

    private boolean AU(String str) {
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
            if (!e.getInstance().eZB) {
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
            if (this.eZH || i3 >= i) {
                break;
            }
            this.eZQ = i3;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.eZI.a(dVar);
            dVar.Mf = -1;
            inputStream = null;
            c = this.eZI.lV().c(dVar);
            try {
                try {
                    dVar.Mf = -2;
                    currentTimeMillis2 = System.currentTimeMillis();
                    if (str == null || str.length() == 0) {
                        ao(c, null, null);
                        if (z16) {
                            dVar.Mg = e.getInstance().getCachedCdnIp(this.eZQ);
                        }
                    } else {
                        ao(c, str, str2);
                        dVar.Mg = str;
                    }
                    dVar.Mf = -3;
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
            if (this.eZF == null) {
                throw new SocketException("network not available.");
            }
            if (this.eZH) {
                this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                if (this.eZK && this.eZJ != null) {
                    this.eZJ.av(this.eZI.lW().mNetErrorCode);
                }
                if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                    com.baidu.adp.lib.stats.a pi = t.pi();
                    pi.append("netException", dVar.exception);
                    pi.append("Url", c);
                    pi.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                    pi.append("netType", Integer.valueOf(j.netType()));
                    pi.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                    pi.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                    pi.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    Object[] objArr = new Object[2];
                    objArr[0] = "isNetChanged";
                    objArr[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                    pi.append(objArr);
                    pi.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                    pi.append("currentActivity", UtilHelper.getTopActivityClassName());
                    if (this.eZJ != null) {
                        pi.append("requestUrl", this.eZJ.mj());
                        pi.append("dnsMessage", this.eZJ.toString());
                    }
                    t.e(pi);
                }
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e13) {
                    }
                }
                closeConnection();
                this.eZI.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean isWifiNet = j.isWifiNet();
                    if ((isWifiNet ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        if (isWifiNet) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                        } else if (j.is2GNet()) {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                        } else {
                            z9 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                        }
                        e.getInstance().result(c, dVar.Mg, false, z9, isWifiNet);
                    }
                }
            } else {
                dVar.Mf = -8;
                execute = eZM.execute(this.eZF);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.eZI.lW().responseCode = execute.getStatusLine().getStatusCode();
                dVar.Me = this.eZI.lW().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                    dVar.Mm = headers[0].getValue();
                    dVar.Mn = headers[1].getValue();
                }
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.eZI.lW().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.eZG < 1) {
                            closeConnection();
                            this.eZG++;
                            this.eZI.lW().responseCode = 0;
                            i3--;
                            this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                            if (this.eZK && this.eZJ != null) {
                                this.eZJ.av(this.eZI.lW().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                com.baidu.adp.lib.stats.a pi2 = t.pi();
                                pi2.append("netException", dVar.exception);
                                pi2.append("Url", c);
                                pi2.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                pi2.append("netType", Integer.valueOf(j.netType()));
                                pi2.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                pi2.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                pi2.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = "isNetChanged";
                                objArr2[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                pi2.append(objArr2);
                                pi2.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                pi2.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.eZJ != null) {
                                    pi2.append("requestUrl", this.eZJ.mj());
                                    pi2.append("dnsMessage", this.eZJ.toString());
                                }
                                t.e(pi2);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            closeConnection();
                            this.eZI.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet2 = j.isWifiNet();
                                if ((isWifiNet2 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet2) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                    } else if (j.is2GNet()) {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                    } else {
                                        z14 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                    }
                                    e.getInstance().result(c, dVar.Mg, false, z14, isWifiNet2);
                                }
                            }
                            i3++;
                            bArr9 = bArr9;
                        } else {
                            this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                            if (this.eZK && this.eZJ != null) {
                                this.eZJ.av(this.eZI.lW().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                com.baidu.adp.lib.stats.a pi3 = t.pi();
                                pi3.append("netException", dVar.exception);
                                pi3.append("Url", c);
                                pi3.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                pi3.append("netType", Integer.valueOf(j.netType()));
                                pi3.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                pi3.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                pi3.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = "isNetChanged";
                                objArr3[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                pi3.append(objArr3);
                                pi3.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                pi3.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.eZJ != null) {
                                    pi3.append("requestUrl", this.eZJ.mj());
                                    pi3.append("dnsMessage", this.eZJ.toString());
                                }
                                t.e(pi3);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e15) {
                                }
                            }
                            closeConnection();
                            this.eZI.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet3 = j.isWifiNet();
                                if ((isWifiNet3 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet3) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                    } else if (j.is2GNet()) {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                    } else {
                                        z13 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                    }
                                    e.getInstance().result(c, dVar.Mg, false, z13, isWifiNet3);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > eXM) {
                    this.eZI.lW().mNetErrorCode = -11;
                    dVar.exception = this.mContext.getResources().getString(R.string.data_too_big);
                    this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                    if (this.eZK && this.eZJ != null) {
                        this.eZJ.av(this.eZI.lW().mNetErrorCode);
                    }
                    if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                        com.baidu.adp.lib.stats.a pi4 = t.pi();
                        pi4.append("netException", dVar.exception);
                        pi4.append("Url", c);
                        pi4.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                        pi4.append("netType", Integer.valueOf(j.netType()));
                        pi4.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                        pi4.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                        pi4.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = "isNetChanged";
                        objArr4[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                        pi4.append(objArr4);
                        pi4.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                        pi4.append("currentActivity", UtilHelper.getTopActivityClassName());
                        if (this.eZJ != null) {
                            pi4.append("requestUrl", this.eZJ.mj());
                            pi4.append("dnsMessage", this.eZJ.toString());
                        }
                        t.e(pi4);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e16) {
                        }
                    }
                    closeConnection();
                    this.eZI.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean isWifiNet4 = j.isWifiNet();
                        if ((isWifiNet4 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (isWifiNet4) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                            } else if (j.is2GNet()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                            }
                            e.getInstance().result(c, dVar.Mg, false, z10, isWifiNet4);
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
                        while (!this.eZH && i2 < eXM && (read = inputStream.read(bArr10)) != -1) {
                            byteArrayOutputStream.write(bArr10, 0, read);
                            i2 = read + i2;
                        }
                        dVar.Mf = -9;
                        if (this.eZH) {
                            if (i2 >= eXM) {
                                this.eZI.lW().mNetErrorCode = -11;
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
                                this.eZI.lW().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.eZI.lW().mNetErrorCode) + "|" + e6.getClass() + "|" + e6.getMessage() + "|getcontent_illegal_error";
                                this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                                if (this.eZK && this.eZJ != null) {
                                    this.eZJ.av(this.eZI.lW().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                    com.baidu.adp.lib.stats.a pi5 = t.pi();
                                    pi5.append("netException", dVar.exception);
                                    pi5.append("Url", c);
                                    pi5.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pi5.append("netType", Integer.valueOf(j.netType()));
                                    pi5.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pi5.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pi5.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr5 = new Object[2];
                                    objArr5[0] = "isNetChanged";
                                    objArr5[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pi5.append(objArr5);
                                    pi5.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pi5.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eZJ != null) {
                                        pi5.append("requestUrl", this.eZJ.mj());
                                        pi5.append("dnsMessage", this.eZJ.toString());
                                    }
                                    t.e(pi5);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                closeConnection();
                                this.eZI.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet5 = j.isWifiNet();
                                    if ((isWifiNet5 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet5) {
                                            z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                        } else if (j.is2GNet()) {
                                            z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                        } else {
                                            z8 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                        }
                                        e.getInstance().result(c, dVar.Mg, false, z8, isWifiNet5);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (SocketException e19) {
                                e5 = e19;
                                bArr9 = bArr7;
                                this.eZI.lW().mNetErrorCode = -12;
                                dVar.exception = "errorCode:" + String.valueOf(this.eZI.lW().mNetErrorCode) + "|" + e5.getClass() + "|" + e5.getMessage();
                                this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                                if (this.eZK && this.eZJ != null) {
                                    this.eZJ.av(this.eZI.lW().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                    com.baidu.adp.lib.stats.a pi6 = t.pi();
                                    pi6.append("netException", dVar.exception);
                                    pi6.append("Url", c);
                                    pi6.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pi6.append("netType", Integer.valueOf(j.netType()));
                                    pi6.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pi6.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pi6.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr6 = new Object[2];
                                    objArr6[0] = "isNetChanged";
                                    objArr6[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pi6.append(objArr6);
                                    pi6.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pi6.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eZJ != null) {
                                        pi6.append("requestUrl", this.eZJ.mj());
                                        pi6.append("dnsMessage", this.eZJ.toString());
                                    }
                                    t.e(pi6);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e20) {
                                    }
                                }
                                closeConnection();
                                this.eZI.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet6 = j.isWifiNet();
                                    if ((isWifiNet6 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet6) {
                                            z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                        } else if (j.is2GNet()) {
                                            z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                        } else {
                                            z7 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                        }
                                        e.getInstance().result(c, dVar.Mg, false, z7, isWifiNet6);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (SocketTimeoutException e21) {
                                e4 = e21;
                                bArr9 = bArr6;
                                this.eZI.lW().mNetErrorCode = -13;
                                dVar.exception = "errorCode:" + String.valueOf(this.eZI.lW().mNetErrorCode) + "|" + e4.getClass() + "|" + e4.getMessage();
                                this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                                if (this.eZK && this.eZJ != null) {
                                    this.eZJ.av(this.eZI.lW().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                    com.baidu.adp.lib.stats.a pi7 = t.pi();
                                    pi7.append("netException", dVar.exception);
                                    pi7.append("Url", c);
                                    pi7.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pi7.append("netType", Integer.valueOf(j.netType()));
                                    pi7.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pi7.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pi7.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr7 = new Object[2];
                                    objArr7[0] = "isNetChanged";
                                    objArr7[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pi7.append(objArr7);
                                    pi7.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pi7.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eZJ != null) {
                                        pi7.append("requestUrl", this.eZJ.mj());
                                        pi7.append("dnsMessage", this.eZJ.toString());
                                    }
                                    t.e(pi7);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e22) {
                                    }
                                }
                                closeConnection();
                                this.eZI.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet7 = j.isWifiNet();
                                    if ((isWifiNet7 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet7) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                        } else if (j.is2GNet()) {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                        } else {
                                            z6 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                        }
                                        e.getInstance().result(c, dVar.Mg, false, z6, isWifiNet7);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (SSLException e23) {
                                e3 = e23;
                                bArr9 = bArr5;
                                this.eZI.lW().mNetErrorCode = -20;
                                dVar.exception = "errorCode:" + String.valueOf(this.eZI.lW().mNetErrorCode) + "|" + e3.getClass() + "|" + e3.getMessage();
                                this.eZL = true;
                                this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                                if (this.eZK && this.eZJ != null) {
                                    this.eZJ.av(this.eZI.lW().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                    com.baidu.adp.lib.stats.a pi8 = t.pi();
                                    pi8.append("netException", dVar.exception);
                                    pi8.append("Url", c);
                                    pi8.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pi8.append("netType", Integer.valueOf(j.netType()));
                                    pi8.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pi8.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pi8.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr8 = new Object[2];
                                    objArr8[0] = "isNetChanged";
                                    objArr8[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pi8.append(objArr8);
                                    pi8.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pi8.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eZJ != null) {
                                        pi8.append("requestUrl", this.eZJ.mj());
                                        pi8.append("dnsMessage", this.eZJ.toString());
                                    }
                                    t.e(pi8);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e24) {
                                    }
                                }
                                closeConnection();
                                this.eZI.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet8 = j.isWifiNet();
                                    if ((isWifiNet8 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet8) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                        } else if (j.is2GNet()) {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                        } else {
                                            z5 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                        }
                                        e.getInstance().result(c, dVar.Mg, false, z5, isWifiNet8);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (IOException e25) {
                                e2 = e25;
                                bArr9 = bArr4;
                                this.eZI.lW().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(this.eZI.lW().mNetErrorCode) + "|" + e2.getClass() + "|" + e2.getMessage();
                                this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                                if (this.eZK && this.eZJ != null) {
                                    this.eZJ.av(this.eZI.lW().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                    com.baidu.adp.lib.stats.a pi9 = t.pi();
                                    pi9.append("netException", dVar.exception);
                                    pi9.append("Url", c);
                                    pi9.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pi9.append("netType", Integer.valueOf(j.netType()));
                                    pi9.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pi9.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pi9.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr9 = new Object[2];
                                    objArr9[0] = "isNetChanged";
                                    objArr9[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pi9.append(objArr9);
                                    pi9.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pi9.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eZJ != null) {
                                        pi9.append("requestUrl", this.eZJ.mj());
                                        pi9.append("dnsMessage", this.eZJ.toString());
                                    }
                                    t.e(pi9);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e26) {
                                    }
                                }
                                closeConnection();
                                this.eZI.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet9 = j.isWifiNet();
                                    if ((isWifiNet9 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet9) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                        } else if (j.is2GNet()) {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                        } else {
                                            z4 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                        }
                                        e.getInstance().result(c, dVar.Mg, false, z4, isWifiNet9);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (HttpException e27) {
                                e = e27;
                                bArr9 = bArr3;
                                this.eZI.lW().mNetErrorCode = -18;
                                dVar.exception = "errorCode:" + String.valueOf(this.eZI.lW().mNetErrorCode) + "|" + e.getClass() + "|" + e.getMessage();
                                this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                                if (this.eZK && this.eZJ != null) {
                                    this.eZJ.av(this.eZI.lW().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                    com.baidu.adp.lib.stats.a pi10 = t.pi();
                                    pi10.append("netException", dVar.exception);
                                    pi10.append("Url", c);
                                    pi10.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pi10.append("netType", Integer.valueOf(j.netType()));
                                    pi10.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pi10.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pi10.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr10 = new Object[2];
                                    objArr10[0] = "isNetChanged";
                                    objArr10[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pi10.append(objArr10);
                                    pi10.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pi10.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eZJ != null) {
                                        pi10.append("requestUrl", this.eZJ.mj());
                                        pi10.append("dnsMessage", this.eZJ.toString());
                                    }
                                    t.e(pi10);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e28) {
                                    }
                                }
                                closeConnection();
                                this.eZI.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet10 = j.isWifiNet();
                                    if ((isWifiNet10 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet10) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                        } else if (j.is2GNet()) {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                        } else {
                                            z3 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                        }
                                        e.getInstance().result(c, dVar.Mg, false, z3, isWifiNet10);
                                    }
                                }
                                i3++;
                                bArr9 = bArr9;
                            } catch (Throwable th5) {
                                th = th5;
                                bArr9 = bArr;
                                this.eZI.lW().mNetErrorCode = -10;
                                dVar.exception = "errorCode:" + String.valueOf(this.eZI.lW().mNetErrorCode) + "|" + th.getClass() + "|" + th.getMessage();
                                this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                                if (this.eZK && this.eZJ != null) {
                                    this.eZJ.av(this.eZI.lW().mNetErrorCode);
                                }
                                if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                    com.baidu.adp.lib.stats.a pi11 = t.pi();
                                    pi11.append("netException", dVar.exception);
                                    pi11.append("Url", c);
                                    pi11.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                    pi11.append("netType", Integer.valueOf(j.netType()));
                                    pi11.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                    pi11.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                    pi11.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                    Object[] objArr11 = new Object[2];
                                    objArr11[0] = "isNetChanged";
                                    objArr11[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                    pi11.append(objArr11);
                                    pi11.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                    pi11.append("currentActivity", UtilHelper.getTopActivityClassName());
                                    if (this.eZJ != null) {
                                        pi11.append("requestUrl", this.eZJ.mj());
                                        pi11.append("dnsMessage", this.eZJ.toString());
                                    }
                                    t.e(pi11);
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e29) {
                                    }
                                }
                                closeConnection();
                                this.eZI.b(dVar);
                                if ((str == null || str.length() == 0) && c != null) {
                                    boolean isWifiNet11 = j.isWifiNet();
                                    if ((isWifiNet11 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                        long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                                        if (isWifiNet11) {
                                            z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                        } else if (j.is2GNet()) {
                                            z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                        } else {
                                            z = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                        }
                                        e.getInstance().result(c, dVar.Mg, false, z, isWifiNet11);
                                    }
                                }
                                this.eZG = 0;
                                this.eZI.lW().retBytes = bArr9;
                            }
                        } else {
                            this.eZK = 0 == 0 && m.Du(c) && j.isNetworkAvailableForImmediately();
                            if (this.eZK && this.eZJ != null) {
                                this.eZJ.av(this.eZI.lW().mNetErrorCode);
                            }
                            if (0 == 0 && i3 == i - 1 && m.Du(c)) {
                                com.baidu.adp.lib.stats.a pi12 = t.pi();
                                pi12.append("netException", dVar.exception);
                                pi12.append("Url", c);
                                pi12.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
                                pi12.append("netType", Integer.valueOf(j.netType()));
                                pi12.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
                                pi12.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
                                pi12.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                Object[] objArr12 = new Object[2];
                                objArr12[0] = "isNetChanged";
                                objArr12[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
                                pi12.append(objArr12);
                                pi12.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
                                pi12.append("currentActivity", UtilHelper.getTopActivityClassName());
                                if (this.eZJ != null) {
                                    pi12.append("requestUrl", this.eZJ.mj());
                                    pi12.append("dnsMessage", this.eZJ.toString());
                                }
                                t.e(pi12);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e30) {
                                }
                            }
                            closeConnection();
                            this.eZI.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean isWifiNet12 = j.isWifiNet();
                                if ((isWifiNet12 ? (dVar.Mg == null && 0 == 0 && i3 < i + (-1)) ? false : true : true) && m.canUseIp(c) && z16) {
                                    long currentTimeMillis15 = System.currentTimeMillis() - currentTimeMillis;
                                    if (isWifiNet12) {
                                        z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                                    } else if (j.is2GNet()) {
                                        z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                                    } else {
                                        z11 = currentTimeMillis15 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                                    }
                                    e.getInstance().result(c, dVar.Mg, false, z11, isWifiNet12);
                                }
                            }
                        }
                    } else {
                        this.mIsGif = false;
                    }
                }
                i2 = i4;
                while (!this.eZH) {
                    byteArrayOutputStream.write(bArr10, 0, read);
                    i2 = read + i2;
                }
                dVar.Mf = -9;
                if (this.eZH) {
                }
            }
        }
        bArr9 = byteArray;
        dVar.downloadSize = i2;
        dVar.retry = i3 + 1;
        dVar.Mc = System.currentTimeMillis() - currentTimeMillis2;
        if (execute.getFirstHeader("Error-Message") != null) {
            Header firstHeader = execute.getFirstHeader("Error-Message");
            if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                this.eZO = false;
            } else {
                this.eZO = true;
            }
        }
        if (i2 > 0 && (this.eZI.lW().responseCode == 200 || this.eZI.lW().responseCode == 302)) {
            z17 = true;
        }
        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
            AV(value);
        }
        this.eZK = !z17 && m.Du(c) && j.isNetworkAvailableForImmediately();
        if (this.eZK && this.eZJ != null) {
            this.eZJ.av(this.eZI.lW().mNetErrorCode);
        }
        if (!z17 && i3 == i - 1 && m.Du(c)) {
            com.baidu.adp.lib.stats.a pi13 = t.pi();
            pi13.append("netException", dVar.exception);
            pi13.append("Url", c);
            pi13.append("isNetAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
            pi13.append("netType", Integer.valueOf(j.netType()));
            pi13.append("clientIp", com.baidu.tbadk.core.util.d.getIp());
            pi13.append("downloadFileSize", Integer.valueOf(bArr9 != null ? bArr9.length : 0));
            pi13.append(BdStatsConstant.StatsKey.COST, Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
            Object[] objArr13 = new Object[2];
            objArr13[0] = "isNetChanged";
            objArr13[1] = Boolean.valueOf(j.getNetChangedTime() > currentTimeMillis3);
            pi13.append(objArr13);
            pi13.append("isBackground", Boolean.valueOf(TbadkCoreApplication.getInst().isInBackground()));
            pi13.append("currentActivity", UtilHelper.getTopActivityClassName());
            if (this.eZJ != null) {
                pi13.append("requestUrl", this.eZJ.mj());
                pi13.append("dnsMessage", this.eZJ.toString());
            }
            t.e(pi13);
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e31) {
            }
        }
        closeConnection();
        this.eZI.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean isWifiNet13 = j.isWifiNet();
            if ((isWifiNet13 ? dVar.Mg != null || z17 || i3 >= i + (-1) : true) && m.canUseIp(c) && z16) {
                long currentTimeMillis16 = System.currentTimeMillis() - currentTimeMillis;
                if (isWifiNet13) {
                    z12 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().eGZ);
                } else if (j.is2GNet()) {
                    z12 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().eHb);
                } else {
                    z12 = currentTimeMillis16 > ((long) e.getInstance().getCDNImageTimeData().eHa);
                }
                e.getInstance().result(c, dVar.Mg, z17, z12, isWifiNet13);
            }
        }
        this.eZG = 0;
        this.eZI.lW().retBytes = bArr9;
    }

    private void AV(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(eZR) && (System.currentTimeMillis() - eZT) - (1800000 * (eZS / 3)) >= 0) {
            eZS++;
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
                eZR = str;
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

    public boolean bsN() {
        return this.eZO;
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        cancelNetConnect();
    }
}
