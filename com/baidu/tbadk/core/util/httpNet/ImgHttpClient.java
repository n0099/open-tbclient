package com.baidu.tbadk.core.util.httpNet;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
/* loaded from: classes.dex */
public class ImgHttpClient implements com.baidu.adp.lib.f.b {
    private static int US;
    public static String WT;
    private static HttpClient WU;
    private HttpGet WP;
    private final com.baidu.adp.lib.network.http.e WS;
    public boolean WX;
    private final Context mContext;
    private static volatile String WN = null;
    private static volatile boolean WO = false;
    private static Pattern uL = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams WV = new BasicHttpParams();
    private boolean rM = false;
    private boolean WW = false;
    private int WY = 0;
    private int WQ = 0;
    private volatile boolean WR = false;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (WZ) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkState[] valuesCustom() {
            NetworkState[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkState[] networkStateArr = new NetworkState[length];
            System.arraycopy(valuesCustom, 0, networkStateArr, 0, length);
            return networkStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG;

        /* JADX DEBUG: Replace access to removed values field (Xa) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkStateInfo[] valuesCustom() {
            NetworkStateInfo[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkStateInfo[] networkStateInfoArr = new NetworkStateInfo[length];
            System.arraycopy(valuesCustom, 0, networkStateInfoArr, 0, length);
            return networkStateInfoArr;
        }
    }

    static {
        US = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(WV, 5000);
        HttpConnectionParams.setSoTimeout(WV, 30000);
        HttpConnectionParams.setSocketBufferSize(WV, 1024);
        HttpConnectionParams.setTcpNoDelay(WV, true);
        HttpClientParams.setRedirecting(WV, true);
        ConnManagerParams.setMaxConnectionsPerRoute(WV, new ConnPerRouteBean(10));
        ConnManagerParams.setTimeout(WV, 10000L);
        ConnManagerParams.setMaxTotalConnections(WV, 10);
        HttpProtocolParams.setUserAgent(WV, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        WU = new DefaultHttpClient(new ThreadSafeClientConnManager(WV, schemeRegistry), WV);
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            US = 4194304;
        }
    }

    public ImgHttpClient(com.baidu.adp.lib.network.http.e eVar) {
        tX();
        this.WS = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void tX() {
        synchronized (ImgHttpClient.class) {
            if (!WO) {
                WO = true;
                tY();
            }
        }
    }

    public static synchronized void tY() {
        synchronized (ImgHttpClient.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    WN = "Basic " + com.baidu.adp.lib.util.c.m((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public static NetworkState ag(Context context) {
        NetworkState networkState;
        NetworkState networkState2 = NetworkState.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkState = NetworkState.UNAVAIL;
            } else if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                networkState = NetworkState.WIFI;
            } else {
                networkState = NetworkState.MOBILE;
            }
            return networkState;
        } catch (Exception e) {
            return networkState2;
        }
    }

    public void gS() {
        this.WR = true;
        this.WS.gZ().vi = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.WP != null) {
                this.WP.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void j(String str, String str2, String str3) {
        boolean z;
        NetworkState ag = ag(this.mContext);
        if (e.getInstance() != null) {
            if (!e.getInstance().WL) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (ag != NetworkState.UNAVAIL) {
            this.WX = false;
            try {
                if (ag == NetworkState.MOBILE) {
                    URL url = new URL(str);
                    synchronized (ImgHttpClient.class) {
                        if (WT == null) {
                            WT = k.jg();
                        }
                        if (WT != null && WT.length() > 0) {
                            this.WX = true;
                            if (dh(WT) && k.ji()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(WT);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.WP = e.getInstance().httpGetFactory(sb.toString(), this.WY, false);
                                    } else {
                                        this.WP = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.WP = new HttpGet(sb.toString());
                                }
                                this.WP.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.WP.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = WV.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    WV.setParameter("http.route.default-proxy", new HttpHost(WT, k.jh()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(WT) || httpHost.getPort() != k.jh()) {
                                        WV.setParameter("http.route.default-proxy", new HttpHost(WT, k.jh()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.WP = e.getInstance().httpGetFactory(str, this.WY, false);
                                    } else {
                                        this.WP = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.WP = new HttpGet(str);
                                }
                                if (WN != null) {
                                    this.WP.setHeader("Proxy-Authorization", WN);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.WP.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (ag == NetworkState.MOBILE) {
                            if (!this.WX || this.WP == null) {
                                this.WP = e.getInstance().httpGetFactory(str, this.WY, false);
                                return;
                            }
                            return;
                        }
                        this.WP = e.getInstance().httpGetFactory(str, this.WY, true);
                        return;
                    }
                    this.WP = e.getInstance().httpGetFactory(str, str2, str3);
                    return;
                }
                this.WP = new HttpGet(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dg(String str) {
        j(str, null, null);
    }

    private boolean dh(String str) {
        if (uL.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [651=12, 652=12, 656=12, 658=12, 659=12, 660=24, 661=12, 662=12, 663=24, 665=12, 666=12, 667=12, 668=12, 671=12, 672=24, 673=12, 674=12, 675=24, 676=12, 677=12, 678=12, 679=12, 681=24, 682=12] */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x0937, code lost:
        if (r12 == null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x0939, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0b36  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0b3a  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0b58  */
    /* JADX WARN: Removed duplicated region for block: B:651:0x0b77  */
    /* JADX WARN: Removed duplicated region for block: B:654:0x0b7d  */
    /* JADX WARN: Removed duplicated region for block: B:722:0x0b1a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String b;
        Throwable th;
        InputStream inputStream;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        long currentTimeMillis2;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        String value;
        int read;
        String obj;
        boolean z13;
        boolean z14;
        byte[] bArr = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().WL) {
                e.getInstance().init();
            }
        }
        boolean z16 = z15;
        if (i <= 0) {
            i = 5;
        }
        boolean z17 = false;
        int i2 = 0;
        while (true) {
            if (this.WR || i2 >= i) {
                break;
            }
            this.WY = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.WS.a(dVar);
            dVar.uZ = -1;
            InputStream inputStream2 = null;
            b = this.WS.gY().b(dVar);
            try {
                dVar.uZ = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    dg(b);
                    if (z16) {
                        dVar.va = e.getInstance().getCachedCdnIp(this.WY);
                    }
                } else {
                    j(b, str, str2);
                    dVar.va = str;
                }
                dVar.uZ = -3;
            } catch (SocketException e) {
                e = e;
            } catch (HttpException e2) {
                e = e2;
                inputStream = null;
            } catch (SocketTimeoutException e3) {
                e = e3;
                inputStream = null;
            } catch (IOException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.WP == null) {
                throw new SocketException("network not available.");
            }
            if (this.WR) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                closeConnection();
                if ((str == null || str.length() == 0) && b != null) {
                    boolean z18 = ag(this.mContext) == NetworkState.WIFI;
                    if ((z18 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (z18) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().NT);
                        } else if (com.baidu.adp.lib.network.a.b.hi()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().NV);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().NU);
                        }
                        e.getInstance().result(b, dVar.va, z17, z8, z18);
                    }
                }
            } else {
                dVar.uZ = -8;
                HttpResponse execute = WU.execute(this.WP);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.WS.gZ().responseCode = execute.getStatusLine().getStatusCode();
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                } catch (IOException e8) {
                    e = e8;
                } catch (HttpException e9) {
                    e = e9;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.WS.gZ().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.WQ < 1) {
                            closeConnection();
                            this.WQ++;
                            this.WS.gZ().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e10) {
                                }
                            }
                            closeConnection();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean z19 = ag(this.mContext) == NetworkState.WIFI;
                                if ((z19 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (z19) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().NT);
                                    } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().NV);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().NU);
                                    }
                                    e.getInstance().result(b, dVar.va, z17, z14, z19);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e11) {
                                }
                            }
                            closeConnection();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean z20 = ag(this.mContext) == NetworkState.WIFI;
                                if ((z20 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (z20) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().NT);
                                    } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().NV);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().NU);
                                    }
                                    e.getInstance().result(b, dVar.va, z17, z13, z20);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > US) {
                    this.WS.gZ().responseCode = -11;
                    dVar.uX = this.mContext.getResources().getString(t.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                        }
                    }
                    closeConnection();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean z21 = ag(this.mContext) == NetworkState.WIFI;
                        if ((z21 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (z21) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().NT);
                            } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().NV);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().NU);
                            }
                            e.getInstance().result(b, dVar.va, z17, z9, z21);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i3 = 0;
                boolean z22 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z22 = true;
                }
                if (z22) {
                    byte[] bArr3 = new byte[23];
                    int read2 = inputStream.read(bArr3, 0, 23);
                    if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                        byteArrayOutputStream.write(bArr3, 0, read2);
                        i3 = 0 + read2;
                    }
                }
                if (execute.getFirstHeader("Src-Content-Type") != null) {
                    if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                        this.rM = true;
                    } else {
                        this.rM = false;
                    }
                }
                while (!this.WR && i3 < US && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.uZ = -9;
                if (this.WR) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e13) {
                        }
                    }
                    closeConnection();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean z23 = ag(this.mContext) == NetworkState.WIFI;
                        if ((z23 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (z23) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().NT);
                            } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().NV);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().NU);
                            }
                            e.getInstance().result(b, dVar.va, z17, z10, z23);
                        }
                    }
                } else {
                    if (i3 < US) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.g.b(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.WS.gZ().responseCode = -11;
                        dVar.uX = this.mContext.getResources().getString(t.data_too_big);
                    }
                    dVar.uR = i3;
                    dVar.uU = i2 + 1;
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.WW = false;
                        } else {
                            this.WW = true;
                        }
                    }
                    z11 = i3 > 0 ? true : z17;
                    try {
                        if (com.baidu.adp.b.a.mq() != null && dVar != null) {
                            com.baidu.adp.b.a.mq().b(TbConfig.TMP_PIC_DIR_NAME, dVar.uQ, dVar.uR);
                            break;
                        }
                        break;
                    } catch (SocketTimeoutException e14) {
                        e = e14;
                        z17 = z11;
                        this.WS.gZ().responseCode = -13;
                        dVar.uX = String.valueOf(String.valueOf(this.WS.gZ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                            }
                        }
                        closeConnection();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean z24 = ag(this.mContext) == NetworkState.WIFI;
                            if ((z24 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (z24) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().NT);
                                } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().NV);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().NU);
                                }
                                e.getInstance().result(b, dVar.va, z17, z7, z24);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.WS.gZ().responseCode = -18;
                        dVar.uX = String.valueOf(String.valueOf(this.WS.gZ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        closeConnection();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean z25 = ag(this.mContext) == NetworkState.WIFI;
                            if ((z25 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (z25) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().NT);
                                } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().NV);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().NU);
                                }
                                e.getInstance().result(b, dVar.va, z17, z6, z25);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e18) {
                        e = e18;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.WS.gZ().responseCode = -12;
                            dVar.uX = String.valueOf(String.valueOf(this.WS.gZ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e19) {
                                }
                            }
                            closeConnection();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean z26 = ag(this.mContext) == NetworkState.WIFI;
                                if ((z26 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (z26) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().NT);
                                    } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().NV);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().NU);
                                    }
                                    e.getInstance().result(b, dVar.va, z17, z5, z26);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e20) {
                                }
                            }
                            closeConnection();
                            if ((str != null || str.length() == 0) && b != null) {
                                z3 = ag(this.mContext) != NetworkState.WIFI;
                                if ((z3 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!z3) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().NT);
                                    } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().NV);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().NU);
                                    }
                                    e.getInstance().result(b, dVar.va, z17, z4, z3);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e21) {
                        e = e21;
                        z17 = z11;
                        this.WS.gZ().responseCode = -19;
                        dVar.uX = String.valueOf(String.valueOf(this.WS.gZ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        closeConnection();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean z27 = ag(this.mContext) == NetworkState.WIFI;
                            if ((z27 ? dVar.va != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (z27) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().NT);
                                } else if (com.baidu.adp.lib.network.a.b.hi()) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().NV);
                                } else {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().NU);
                                }
                                e.getInstance().result(b, dVar.va, z17, z2, z27);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        closeConnection();
                        if (str != null) {
                        }
                        if (ag(this.mContext) != NetworkState.WIFI) {
                        }
                        if (z3 ? dVar.va != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!z3) {
                            }
                            e.getInstance().result(b, dVar.va, z17, z4, z3);
                        }
                        throw th;
                    }
                }
            }
        }
        this.WQ = 0;
        this.WS.gZ().vk = bArr;
        closeConnection();
        if ((str == null || str.length() == 0) && b != null) {
            boolean z28 = ag(this.mContext) == NetworkState.WIFI;
            if ((z28 ? dVar.va != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.fe(b) && z16) {
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                if (z28) {
                    z12 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().NT);
                } else if (com.baidu.adp.lib.network.a.b.hi()) {
                    z12 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().NV);
                } else {
                    z12 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().NU);
                }
                e.getInstance().result(b, dVar.va, z11, z12, z28);
            }
        }
        this.WQ = 0;
        this.WS.gZ().vk = bArr;
    }

    public void tZ() {
        e(null, null, -1);
    }

    public boolean fN() {
        return this.rM;
    }

    public boolean ua() {
        return this.WW;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        gS();
    }
}
