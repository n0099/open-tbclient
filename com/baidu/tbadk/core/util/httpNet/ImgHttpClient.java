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
import com.baidu.tieba.y;
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
    private static int Uf;
    public static String Wf;
    private static HttpClient Wg;
    private HttpGet Wd;
    private final com.baidu.adp.lib.network.http.e We;
    public boolean Wj;
    private final Context mContext;
    private static volatile String Ug = null;
    private static volatile boolean Uh = false;
    private static Pattern vz = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams Wh = new BasicHttpParams();
    private boolean rC = false;
    private boolean Wi = false;
    private int Wk = 0;
    private int Ui = 0;
    private volatile boolean Uk = false;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (Wl) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Wm) with 'values()' method */
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
        Uf = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(Wh, 5000);
        HttpConnectionParams.setSoTimeout(Wh, 30000);
        HttpConnectionParams.setSocketBufferSize(Wh, 1024);
        HttpConnectionParams.setTcpNoDelay(Wh, true);
        HttpClientParams.setRedirecting(Wh, true);
        ConnManagerParams.setMaxConnectionsPerRoute(Wh, new ConnPerRouteBean(10));
        ConnManagerParams.setTimeout(Wh, 10000L);
        ConnManagerParams.setMaxTotalConnections(Wh, 10);
        HttpProtocolParams.setUserAgent(Wh, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        Wg = new DefaultHttpClient(new ThreadSafeClientConnManager(Wh, schemeRegistry), Wh);
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            Uf = 4194304;
        }
    }

    public ImgHttpClient(com.baidu.adp.lib.network.http.e eVar) {
        sw();
        this.We = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void sw() {
        synchronized (ImgHttpClient.class) {
            if (!Uh) {
                Uh = true;
                sx();
            }
        }
    }

    public static synchronized void sx() {
        synchronized (ImgHttpClient.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    Ug = "Basic " + com.baidu.adp.lib.util.c.m((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public static NetworkState ac(Context context) {
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

    public void hh() {
        this.Uk = true;
        this.We.hn().vW = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.Wd != null) {
                this.Wd.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void j(String str, String str2, String str3) {
        boolean z;
        NetworkState ac = ac(this.mContext);
        if (e.getInstance() != null) {
            if (!e.getInstance().Wb) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (ac != NetworkState.UNAVAIL) {
            this.Wj = false;
            try {
                if (ac == NetworkState.MOBILE) {
                    URL url = new URL(str);
                    synchronized (ImgHttpClient.class) {
                        if (Wf == null) {
                            Wf = k.iQ();
                        }
                        if (Wf != null && Wf.length() > 0) {
                            this.Wj = true;
                            if (cT(Wf) && k.iS()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(Wf);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.Wd = e.getInstance().httpGetFactory(sb.toString(), this.Wk, false);
                                    } else {
                                        this.Wd = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.Wd = new HttpGet(sb.toString());
                                }
                                this.Wd.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.Wd.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = Wh.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    Wh.setParameter("http.route.default-proxy", new HttpHost(Wf, k.iR()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(Wf) || httpHost.getPort() != k.iR()) {
                                        Wh.setParameter("http.route.default-proxy", new HttpHost(Wf, k.iR()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.Wd = e.getInstance().httpGetFactory(str, this.Wk, false);
                                    } else {
                                        this.Wd = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.Wd = new HttpGet(str);
                                }
                                if (Ug != null) {
                                    this.Wd.setHeader("Proxy-Authorization", Ug);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.Wd.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (ac == NetworkState.MOBILE) {
                            if (!this.Wj || this.Wd == null) {
                                this.Wd = e.getInstance().httpGetFactory(str, this.Wk, false);
                                return;
                            }
                            return;
                        }
                        this.Wd = e.getInstance().httpGetFactory(str, this.Wk, true);
                        return;
                    }
                    this.Wd = e.getInstance().httpGetFactory(str, str2, str3);
                    return;
                }
                this.Wd = new HttpGet(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void cS(String str) {
        j(str, null, null);
    }

    private boolean cT(String str) {
        if (vz.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [629=12, 630=12, 634=12, 636=12, 637=12, 638=24, 639=12, 640=12, 641=24, 643=12, 644=12, 645=12, 646=12, 649=12, 650=24, 651=12, 652=12, 653=24, 654=12, 655=12, 656=12, 657=12, 659=24, 660=12] */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x0877, code lost:
        if (r12 == null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x0879, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:627:0x0a76  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0a7a  */
    /* JADX WARN: Removed duplicated region for block: B:642:0x0a98  */
    /* JADX WARN: Removed duplicated region for block: B:648:0x0ab7  */
    /* JADX WARN: Removed duplicated region for block: B:651:0x0abd  */
    /* JADX WARN: Removed duplicated region for block: B:719:0x0a5a A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            if (!e.getInstance().Wb) {
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
            if (this.Uk || i2 >= i) {
                break;
            }
            this.Wk = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.We.a(dVar);
            dVar.vN = -1;
            InputStream inputStream2 = null;
            b = this.We.hm().b(dVar);
            try {
                dVar.vN = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    cS(b);
                    if (z16) {
                        dVar.vO = e.getInstance().getCachedCdnIp(this.Wk);
                    }
                } else {
                    j(b, str, str2);
                    dVar.vO = str;
                }
                dVar.vN = -3;
            } catch (SocketException e) {
                e = e;
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
            } catch (HttpException e3) {
                inputStream = null;
            } catch (SocketTimeoutException e4) {
                e = e4;
                inputStream = null;
            } catch (IOException e5) {
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.Wd == null) {
                throw new SocketException("network not available.");
            }
            if (this.Uk) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                closeConnection();
                if ((str == null || str.length() == 0) && b != null) {
                    boolean z18 = ac(this.mContext) == NetworkState.WIFI;
                    if ((z18 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (z18) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                        } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().NB);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().NA);
                        }
                        e.getInstance().result(b, dVar.vO, z17, z8, z18);
                    }
                }
            } else {
                dVar.vN = -8;
                HttpResponse execute = Wg.execute(this.Wd);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.We.hn().responseCode = execute.getStatusLine().getStatusCode();
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
                } catch (SocketException e7) {
                    e = e7;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e8) {
                    e = e8;
                } catch (IOException e9) {
                } catch (HttpException e10) {
                } catch (Exception e11) {
                    e = e11;
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.We.hn().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.Ui < 1) {
                            closeConnection();
                            this.Ui++;
                            this.We.hn().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            closeConnection();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean z19 = ac(this.mContext) == NetworkState.WIFI;
                                if ((z19 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (z19) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                                    } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().NB);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().NA);
                                    }
                                    e.getInstance().result(b, dVar.vO, z17, z14, z19);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e13) {
                                }
                            }
                            closeConnection();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean z20 = ac(this.mContext) == NetworkState.WIFI;
                                if ((z20 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (z20) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                                    } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().NB);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().NA);
                                    }
                                    e.getInstance().result(b, dVar.vO, z17, z13, z20);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > Uf) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    closeConnection();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean z21 = ac(this.mContext) == NetworkState.WIFI;
                        if ((z21 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (z21) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                            } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().NB);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().NA);
                            }
                            e.getInstance().result(b, dVar.vO, z17, z9, z21);
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
                        this.rC = true;
                    } else {
                        this.rC = false;
                    }
                }
                while (!this.Uk && i3 < Uf && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.vN = -9;
                if (this.Uk) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    closeConnection();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean z23 = ac(this.mContext) == NetworkState.WIFI;
                        if ((z23 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (z23) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                            } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().NB);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().NA);
                            }
                            e.getInstance().result(b, dVar.vO, z17, z10, z23);
                        }
                    }
                } else {
                    if (i3 < Uf) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.g.b(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.We.hn().responseCode = -11;
                        dVar.vL = this.mContext.getResources().getString(y.data_too_big);
                    }
                    dVar.vF = i3;
                    dVar.vI = i2 + 1;
                    dVar.vH = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.Wi = false;
                        } else {
                            this.Wi = true;
                        }
                    }
                    z11 = i3 > 0 ? true : z17;
                    try {
                        if (com.baidu.adp.b.a.lX() != null && dVar != null) {
                            com.baidu.adp.b.a.lX().b(TbConfig.TMP_PIC_DIR_NAME, dVar.vE, dVar.vF);
                            break;
                        }
                        break;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        z17 = z11;
                        this.We.hn().responseCode = -13;
                        dVar.vL = String.valueOf(String.valueOf(this.We.hn().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        closeConnection();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean z24 = ac(this.mContext) == NetworkState.WIFI;
                            if ((z24 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (z24) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                                } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().NB);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().NA);
                                }
                                e.getInstance().result(b, dVar.vO, z17, z7, z24);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e18) {
                        z17 = z11;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        closeConnection();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean z25 = ac(this.mContext) == NetworkState.WIFI;
                            if ((z25 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (z25) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                                } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().NB);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().NA);
                                }
                                e.getInstance().result(b, dVar.vO, z17, z6, z25);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.We.hn().responseCode = -12;
                            dVar.vL = String.valueOf(String.valueOf(this.We.hn().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            closeConnection();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean z26 = ac(this.mContext) == NetworkState.WIFI;
                                if ((z26 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (z26) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                                    } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().NB);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().NA);
                                    }
                                    e.getInstance().result(b, dVar.vO, z17, z5, z26);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e22) {
                                }
                            }
                            closeConnection();
                            if ((str != null || str.length() == 0) && b != null) {
                                z3 = ac(this.mContext) != NetworkState.WIFI;
                                if ((z3 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!z3) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                                    } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().NB);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().NA);
                                    }
                                    e.getInstance().result(b, dVar.vO, z17, z4, z3);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e23) {
                        z17 = z11;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        closeConnection();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean z27 = ac(this.mContext) == NetworkState.WIFI;
                            if ((z27 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (z27) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                                } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().NB);
                                } else {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().NA);
                                }
                                e.getInstance().result(b, dVar.vO, z17, z2, z27);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Exception e25) {
                        e = e25;
                        z17 = z11;
                        this.We.hn().responseCode = -10;
                        dVar.vL = String.valueOf(String.valueOf(this.We.hn().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        closeConnection();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean z28 = ac(this.mContext) == NetworkState.WIFI;
                            if ((z28 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (z28) {
                                    z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                                } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                                    z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().NB);
                                } else {
                                    z = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().NA);
                                }
                                e.getInstance().result(b, dVar.vO, z17, z, z28);
                            }
                        }
                        this.Ui = 0;
                        this.We.hn().vY = bArr;
                    } catch (Throwable th5) {
                        th = th5;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        closeConnection();
                        if (str != null) {
                        }
                        if (ac(this.mContext) != NetworkState.WIFI) {
                        }
                        if (z3 ? dVar.vO != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!z3) {
                            }
                            e.getInstance().result(b, dVar.vO, z17, z4, z3);
                        }
                        throw th;
                    }
                }
            }
        }
        closeConnection();
        if ((str == null || str.length() == 0) && b != null) {
            boolean z29 = ac(this.mContext) == NetworkState.WIFI;
            if ((z29 ? dVar.vO != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.g.eG(b) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (z29) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().Nz);
                } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().NB);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().NA);
                }
                e.getInstance().result(b, dVar.vO, z11, z12, z29);
            }
        }
        this.Ui = 0;
        this.We.hn().vY = bArr;
    }

    public void tu() {
        e(null, null, -1);
    }

    public boolean fI() {
        return this.rC;
    }

    public boolean tv() {
        return this.Wi;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        hh();
    }
}
