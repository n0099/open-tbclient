package com.baidu.tbadk.core.util.httpNet;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.regex.Pattern;
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
    private static int Iv;
    public static String Kn;
    private static HttpClient Ko;
    private HttpGet Kl;
    private final com.baidu.adp.lib.network.http.e Km;
    public boolean Kr;
    private Context mContext;
    private static volatile String Iw = null;
    private static volatile boolean Ix = false;
    private static Pattern kg = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams Kp = new BasicHttpParams();
    private boolean gg = false;
    private boolean Kq = false;
    private int Ks = 0;
    private int Iy = 0;
    private volatile boolean IA = false;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (Kt) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (Ku) with 'values()' method */
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
        Iv = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(Kp, 5000);
        HttpConnectionParams.setSoTimeout(Kp, 30000);
        HttpConnectionParams.setSocketBufferSize(Kp, 1024);
        HttpConnectionParams.setTcpNoDelay(Kp, true);
        HttpClientParams.setRedirecting(Kp, true);
        ConnManagerParams.setMaxConnectionsPerRoute(Kp, new ConnPerRouteBean(10));
        ConnManagerParams.setTimeout(Kp, 10000L);
        ConnManagerParams.setMaxTotalConnections(Kp, 10);
        HttpProtocolParams.setUserAgent(Kp, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        Ko = new DefaultHttpClient(new ThreadSafeClientConnManager(Kp, schemeRegistry), Kp);
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            Iv = 4194304;
        }
    }

    public ImgHttpClient(com.baidu.adp.lib.network.http.e eVar) {
        pd();
        this.Km = eVar;
        this.mContext = TbadkCoreApplication.m255getInst().getApp();
    }

    public static void pd() {
        synchronized (ImgHttpClient.class) {
            if (!Ix) {
                Ix = true;
                pe();
            }
        }
    }

    public static synchronized void pe() {
        synchronized (ImgHttpClient.class) {
            try {
                Cursor query = TbadkCoreApplication.m255getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    Iw = "Basic " + ba.base64Encode((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public static NetworkState T(Context context) {
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

    public void dL() {
        this.IA = true;
        this.Km.dQ().kF = true;
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (this.Kl != null) {
                this.Kl.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        NetworkState T = T(this.mContext);
        if (T != NetworkState.UNAVAIL) {
            this.Kr = false;
            try {
                if (T == NetworkState.MOBILE) {
                    URL url = new URL(str);
                    synchronized (ImgHttpClient.class) {
                        if (Kn == null) {
                            Kn = com.baidu.adp.lib.util.i.fp();
                        }
                        if (Kn != null && Kn.length() > 0) {
                            this.Kr = true;
                            if (cO(Kn)) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(Kn);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (str2 == null || str2.length() == 0) {
                                    this.Kl = CDNIPDirectConnect.pM().c(sb.toString(), this.Ks, false);
                                } else {
                                    this.Kl = CDNIPDirectConnect.pM().k(str, str2, str3);
                                }
                                this.Kl.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.Kl.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = Kp.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    Kp.setParameter("http.route.default-proxy", new HttpHost(Kn, com.baidu.adp.lib.util.i.fq()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(Kn) || httpHost.getPort() != com.baidu.adp.lib.util.i.fq()) {
                                        Kp.setParameter("http.route.default-proxy", new HttpHost(Kn, com.baidu.adp.lib.util.i.fq()));
                                    }
                                }
                                if (str2 == null || str2.length() == 0) {
                                    this.Kl = CDNIPDirectConnect.pM().c(str, this.Ks, false);
                                } else {
                                    this.Kl = CDNIPDirectConnect.pM().k(str, str2, str3);
                                }
                                if (Iw != null) {
                                    this.Kl.setHeader("Proxy-Authorization", Iw);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.Kl.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (str2 == null || str2.length() == 0) {
                    if (T == NetworkState.MOBILE) {
                        if (!this.Kr || this.Kl == null) {
                            this.Kl = CDNIPDirectConnect.pM().c(str, this.Ks, false);
                            return;
                        }
                        return;
                    }
                    this.Kl = CDNIPDirectConnect.pM().c(str, this.Ks, true);
                    return;
                }
                this.Kl = CDNIPDirectConnect.pM().k(str, str2, str3);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void cN(String str) {
        l(str, null, null);
    }

    private boolean cO(String str) {
        if (kg.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, IF, IGET, INVOKE, SGET, IF, IF, INVOKE, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, IF, IGET, INVOKE, SGET, IF, IF, INVOKE, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, IF, IGET, INVOKE, SGET, IF, IF, INVOKE, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, IF, IGET, INVOKE, SGET, IF, IF, INVOKE, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, IF, IGET, INVOKE, SGET, IF, IF, INVOKE, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, IF, IGET, INVOKE, SGET, IF, IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, IF, IGET, INVOKE, SGET, IF, IF, INVOKE, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, ARITH, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, CONST, IF, IGET, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, INVOKE, IGET, INVOKE, MOVE, CONST, INVOKE, IGET, INVOKE, MOVE, CONST, IF, INVOKE, IGET, IGET, CAST, CMP_L, IF, INVOKE, IF, INVOKE, ARITH, IF, INVOKE, IF, IF, CONST, CONST, IF, IGET, INVOKE, SGET, IF, IF, INVOKE, MOVE_EXCEPTION, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [518=12, 519=12, 523=12, 525=12, 526=12, 527=24, 528=12, 529=12, 530=24, 532=12, 533=12, 534=12, 536=12, 537=24, 538=12, 539=24, 540=12, 541=12, 543=12] */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x055b, code lost:
        if (((int) r16.getContentLength()) <= com.baidu.tbadk.core.util.httpNet.ImgHttpClient.Iv) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x055d, code lost:
        if (r5 == null) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x055f, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x05e3, code lost:
        r0 = new byte[1024];
        r18 = new java.io.ByteArrayOutputStream(1024);
        r3 = 0;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x05fa, code lost:
        if (r8.getFirstHeader("imgsrc") == null) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x05fc, code lost:
        r19 = r8.getFirstHeader("imgsrc").toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x0608, code lost:
        if (r19 == null) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x060e, code lost:
        if (r19.length() <= 0) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0610, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0611, code lost:
        if (r7 == false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0613, code lost:
        r7 = new byte[23];
        r19 = r5.read(r7, 0, 23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0639, code lost:
        if (new java.lang.String(r7, 0, r7.length).equalsIgnoreCase("app:tiebaclient;type:0;") != false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x063b, code lost:
        r18.write(r7, 0, r19);
        r3 = 0 + r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x064e, code lost:
        if (r8.getFirstHeader("Src-Content-Type") == null) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0662, code lost:
        if ("image/gif".equalsIgnoreCase(r8.getFirstHeader("Src-Content-Type").getValue()) == false) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0664, code lost:
        r23.gg = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x066d, code lost:
        if (r23.IA != false) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0671, code lost:
        if (r3 >= com.baidu.tbadk.core.util.httpNet.ImgHttpClient.Iv) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0673, code lost:
        r7 = r5.read(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x067d, code lost:
        if (r7 != (-1)) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x067f, code lost:
        r13.ku = -9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0687, code lost:
        if (r23.IA == false) goto L265;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0689, code lost:
        if (r5 == null) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x068b, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x06df, code lost:
        r23.gg = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x073c, code lost:
        r18.write(r0, 0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x0745, code lost:
        r3 = r3 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x077e, code lost:
        if (r3 >= com.baidu.tbadk.core.util.httpNet.ImgHttpClient.Iv) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x0780, code lost:
        r10 = r18.toByteArray();
        r18.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x078b, code lost:
        if (r16.getContentEncoding() == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x078d, code lost:
        r7 = r16.getContentEncoding().getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x0795, code lost:
        if (r7 == null) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x079f, code lost:
        if (r7.contains("gzip") == false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x07a1, code lost:
        r7 = new java.io.ByteArrayInputStream(r10);
        r16 = new java.io.ByteArrayOutputStream(1024);
        com.baidu.tbadk.util.d.b(r7, r16);
        r10 = r16.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x07b6, code lost:
        r13.km = r3;
        r13.retry = r9 + 1;
        r13.kp = java.lang.System.currentTimeMillis() - r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x07ca, code lost:
        if (r8.getFirstHeader("Error-Message") == null) goto L284;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x07cc, code lost:
        r7 = r8.getFirstHeader("Error-Message");
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x07d2, code lost:
        if (r7 == null) goto L283;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x07dc, code lost:
        if (android.text.TextUtils.isEmpty(r7.getValue()) != false) goto L283;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x07e8, code lost:
        if (r7.getValue().equalsIgnoreCase("OK") == false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x07ea, code lost:
        r23.Kq = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x07ef, code lost:
        if (r3 <= 0) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x07f1, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x07f2, code lost:
        if (r5 == null) goto L287;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x07f4, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x0849, code lost:
        r23.Km.dQ().responseCode = -11;
        r13.ks = r23.mContext.getResources().getString(com.baidu.tieba.z.data_too_big);
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x086b, code lost:
        r23.Kq = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String b;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        byte[] bArr = null;
        if (i <= 0) {
            i = 5;
        }
        boolean z13 = false;
        int i2 = 0;
        while (true) {
            if (this.IA || i2 >= i) {
                break;
            }
            this.Ks = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.Km.a(dVar);
            dVar.ku = -1;
            InputStream inputStream = null;
            b = this.Km.dP().b(dVar);
            try {
                try {
                    try {
                        try {
                            dVar.ku = -2;
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (str == null || str.length() == 0) {
                                cN(b);
                                dVar.kv = CDNIPDirectConnect.pM().ca(this.Ks);
                            } else {
                                l(b, str, str2);
                                dVar.kv = str;
                            }
                            dVar.ku = -3;
                        } catch (Throwable th) {
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (Exception e) {
                                }
                            }
                            closeConnection();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean z14 = T(this.mContext) == NetworkState.WIFI;
                                if ((z14 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                                    if (z14) {
                                        z6 = currentTimeMillis3 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                                    } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                                        z6 = currentTimeMillis3 > ((long) CDNIPDirectConnect.pM().JX.BB);
                                    } else {
                                        z6 = currentTimeMillis3 > ((long) CDNIPDirectConnect.pM().JX.BA);
                                    }
                                    CDNIPDirectConnect.pM().c(b, dVar.kv, false, z6, z14);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e2) {
                        this.Km.dQ().responseCode = -13;
                        dVar.ks = String.valueOf(String.valueOf(this.Km.dQ().responseCode)) + "|retryCount:" + i2 + "|" + e2.getClass() + "|" + e2.getMessage();
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        closeConnection();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean z15 = T(this.mContext) == NetworkState.WIFI;
                            if ((z15 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                if (z15) {
                                    z5 = currentTimeMillis4 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                                } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                                    z5 = currentTimeMillis4 > ((long) CDNIPDirectConnect.pM().JX.BB);
                                } else {
                                    z5 = currentTimeMillis4 > ((long) CDNIPDirectConnect.pM().JX.BA);
                                }
                                CDNIPDirectConnect.pM().c(b, dVar.kv, false, z5, z15);
                            }
                        }
                    }
                } catch (Exception e4) {
                    this.Km.dQ().responseCode = -10;
                    dVar.ks = String.valueOf(String.valueOf(this.Km.dQ().responseCode)) + "|retryCount:" + i2 + "|" + e4.getClass() + "|" + e4.getMessage();
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    closeConnection();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean z16 = T(this.mContext) == NetworkState.WIFI;
                        if ((z16 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                            long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                            if (z16) {
                                z4 = currentTimeMillis5 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                            } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                                z4 = currentTimeMillis5 > ((long) CDNIPDirectConnect.pM().JX.BB);
                            } else {
                                z4 = currentTimeMillis5 > ((long) CDNIPDirectConnect.pM().JX.BA);
                            }
                            CDNIPDirectConnect.pM().c(b, dVar.kv, false, z4, z16);
                        }
                    }
                } catch (HttpException e6) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    closeConnection();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean z17 = T(this.mContext) == NetworkState.WIFI;
                        if ((z17 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (z17) {
                                z3 = currentTimeMillis6 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                            } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                                z3 = currentTimeMillis6 > ((long) CDNIPDirectConnect.pM().JX.BB);
                            } else {
                                z3 = currentTimeMillis6 > ((long) CDNIPDirectConnect.pM().JX.BA);
                            }
                            CDNIPDirectConnect.pM().c(b, dVar.kv, false, z3, z17);
                        }
                    }
                }
            } catch (SocketException e8) {
                this.Km.dQ().responseCode = -12;
                dVar.ks = String.valueOf(String.valueOf(this.Km.dQ().responseCode)) + "|retryCount:" + i2 + "|" + e8.getClass() + "|" + e8.getMessage();
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e9) {
                    }
                }
                closeConnection();
                if ((str == null || str.length() == 0) && b != null) {
                    boolean z18 = T(this.mContext) == NetworkState.WIFI;
                    if ((z18 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                        if (z18) {
                            z2 = currentTimeMillis7 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                        } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                            z2 = currentTimeMillis7 > ((long) CDNIPDirectConnect.pM().JX.BB);
                        } else {
                            z2 = currentTimeMillis7 > ((long) CDNIPDirectConnect.pM().JX.BA);
                        }
                        CDNIPDirectConnect.pM().c(b, dVar.kv, false, z2, z18);
                    }
                }
            } catch (IOException e10) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception e11) {
                    }
                }
                closeConnection();
                if ((str == null || str.length() == 0) && b != null) {
                    boolean z19 = T(this.mContext) == NetworkState.WIFI;
                    if ((z19 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                        if (z19) {
                            z = currentTimeMillis8 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                        } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                            z = currentTimeMillis8 > ((long) CDNIPDirectConnect.pM().JX.BB);
                        } else {
                            z = currentTimeMillis8 > ((long) CDNIPDirectConnect.pM().JX.BA);
                        }
                        CDNIPDirectConnect.pM().c(b, dVar.kv, false, z, z19);
                    }
                }
            }
            if (this.Kl != null) {
                if (!this.IA) {
                    dVar.ku = -8;
                    HttpResponse execute = Ko.execute(this.Kl);
                    if (execute != null) {
                        if (execute.getStatusLine() != null) {
                            this.Km.dQ().responseCode = execute.getStatusLine().getStatusCode();
                            if (execute.getEntity() != null) {
                                HttpEntity entity = execute.getEntity();
                                InputStream content = entity.getContent();
                                if (entity.getContentType() == null) {
                                    break;
                                }
                                String obj = entity.getContentType().toString();
                                this.Km.dQ().contentType = obj;
                                if (!obj.contains("text/vnd.wap.wml")) {
                                    break;
                                } else if (this.Iy < 1) {
                                    closeConnection();
                                    this.Iy++;
                                    this.Km.dQ().responseCode = 0;
                                    i2--;
                                    if (content != null) {
                                        try {
                                            content.close();
                                        } catch (Exception e12) {
                                        }
                                    }
                                    closeConnection();
                                    if ((str == null || str.length() == 0) && b != null) {
                                        boolean z20 = T(this.mContext) == NetworkState.WIFI;
                                        if ((z20 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                                            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                            if (z20) {
                                                z12 = currentTimeMillis9 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                                            } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                                                z12 = currentTimeMillis9 > ((long) CDNIPDirectConnect.pM().JX.BB);
                                            } else {
                                                z12 = currentTimeMillis9 > ((long) CDNIPDirectConnect.pM().JX.BA);
                                            }
                                            CDNIPDirectConnect.pM().c(b, dVar.kv, false, z12, z20);
                                        }
                                    }
                                    i2++;
                                    bArr = bArr;
                                } else {
                                    if (content != null) {
                                        try {
                                            content.close();
                                        } catch (Exception e13) {
                                        }
                                    }
                                    closeConnection();
                                    if ((str == null || str.length() == 0) && b != null) {
                                        boolean z21 = T(this.mContext) == NetworkState.WIFI;
                                        if ((z21 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                                            long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                            if (z21) {
                                                z11 = currentTimeMillis10 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                                            } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                                                z11 = currentTimeMillis10 > ((long) CDNIPDirectConnect.pM().JX.BB);
                                            } else {
                                                z11 = currentTimeMillis10 > ((long) CDNIPDirectConnect.pM().JX.BA);
                                            }
                                            CDNIPDirectConnect.pM().c(b, dVar.kv, false, z11, z21);
                                        }
                                    }
                                }
                            } else {
                                throw new SocketException("httpResponse getEntity is null.");
                            }
                        } else {
                            throw new SocketException("httpResponse getStatusLine is null.");
                        }
                    } else {
                        throw new SocketException("httpResponse is null.");
                    }
                } else {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    closeConnection();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean z22 = T(this.mContext) == NetworkState.WIFI;
                        if ((z22 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                            long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                            if (z22) {
                                z7 = currentTimeMillis11 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                            } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                                z7 = currentTimeMillis11 > ((long) CDNIPDirectConnect.pM().JX.BB);
                            } else {
                                z7 = currentTimeMillis11 > ((long) CDNIPDirectConnect.pM().JX.BA);
                            }
                            CDNIPDirectConnect.pM().c(b, dVar.kv, false, z7, z22);
                        }
                    }
                }
            } else {
                throw new SocketException("network not available.");
            }
        }
        this.Iy = 0;
        this.Km.dQ().kH = bArr;
        closeConnection();
        if ((str == null || str.length() == 0) && b != null) {
            boolean z23 = T(this.mContext) == NetworkState.WIFI;
            if ((z23 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                if (z23) {
                    z10 = currentTimeMillis12 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                    z10 = currentTimeMillis12 > ((long) CDNIPDirectConnect.pM().JX.BB);
                } else {
                    z10 = currentTimeMillis12 > ((long) CDNIPDirectConnect.pM().JX.BA);
                }
                CDNIPDirectConnect.pM().c(b, dVar.kv, false, z10, z23);
                return;
            }
            return;
        }
        return;
        closeConnection();
        if ((str == null || str.length() == 0) && b != null) {
            boolean z24 = T(this.mContext) == NetworkState.WIFI;
            if ((z24 ? dVar.kv != null || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                if (z24) {
                    z9 = currentTimeMillis13 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                    z9 = currentTimeMillis13 > ((long) CDNIPDirectConnect.pM().JX.BB);
                } else {
                    z9 = currentTimeMillis13 > ((long) CDNIPDirectConnect.pM().JX.BA);
                }
                CDNIPDirectConnect.pM().c(b, dVar.kv, false, z9, z24);
            }
        }
        this.Iy = 0;
        this.Km.dQ().kH = bArr;
        closeConnection();
        if ((str == null || str.length() == 0) && b != null) {
            boolean z25 = T(this.mContext) == NetworkState.WIFI;
            if ((z25 ? dVar.kv != null || z13 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.eE(b)) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (z25) {
                    z8 = currentTimeMillis14 > ((long) CDNIPDirectConnect.pM().JX.Bz);
                } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                    z8 = currentTimeMillis14 > ((long) CDNIPDirectConnect.pM().JX.BB);
                } else {
                    z8 = currentTimeMillis14 > ((long) CDNIPDirectConnect.pM().JX.BA);
                }
                CDNIPDirectConnect.pM().c(b, dVar.kv, z13, z8, z25);
            }
        }
        this.Iy = 0;
        this.Km.dQ().kH = bArr;
    }

    public void qa() {
        c(null, null, -1);
    }

    public boolean cm() {
        return this.gg;
    }

    public boolean qb() {
        return this.Kq;
    }

    @Override // com.baidu.adp.lib.f.b
    public void cancel() {
        dL();
    }
}
