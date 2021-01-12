package com.baidu.down.loopj.android.urlconnection;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.down.common.NameValuePair;
import com.baidu.down.loopj.android.http.ConnectManager;
import com.baidu.down.loopj.android.request.handler.HttpDns;
import com.baidu.down.utils.DownPrefUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes3.dex */
public class ProxyURLConnection {
    public static final String CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded; charset=UTF-8";
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SOCKET_TIMEOUT = 30000;
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_HOST = "Host";
    public static final String REQUEST_METHOD_GET = "GET";
    public static final String REQUEST_METHOD_POST = "POST";
    private static final String TAG = "ProxyURLConnection";
    public static final int WAP_SOCKET_TIMEOUT = 60000;
    private static int mConnectionTimeout = 30000;
    private static int mSocketTimeout = 30000;
    private ConnectManager mConnectManager;
    private Context mContext;
    private boolean mFollowRedirects;
    private String mHost;
    private HostnameVerifier mHostnameVerifier;
    private UrlConnectionRetryHandler mRetryHandler;
    private boolean mUsingDNSProxy;

    public boolean isWap() {
        return this.mConnectManager.isWapNetwork();
    }

    public ConnectManager.NetWorkType getNetWorkType() {
        return this.mConnectManager.getNetType();
    }

    public void initProxyHttpClient() {
        this.mConnectManager = new ConnectManager(this.mContext);
        if (isWap()) {
            mConnectionTimeout = 60000;
            mSocketTimeout = 60000;
        } else {
            mConnectionTimeout = 30000;
            mSocketTimeout = 30000;
        }
        setUsingDNSProxy(TextUtils.equals(DownPrefUtils.getString(this.mContext, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_NAME), DownPrefUtils.HOST_TYPE_IP));
    }

    public ProxyURLConnection(Context context, long[] jArr) {
        this.mFollowRedirects = true;
        this.mUsingDNSProxy = false;
        this.mHost = "";
        this.mContext = context.getApplicationContext();
        disableConnectionReuseIfNecessary();
        initProxyHttpClient();
        this.mRetryHandler = new UrlConnectionRetryHandler(jArr);
    }

    public ProxyURLConnection(Context context, boolean z) {
        this.mFollowRedirects = true;
        this.mUsingDNSProxy = false;
        this.mHost = "";
        this.mContext = context.getApplicationContext();
        disableConnectionReuseIfNecessary();
        this.mConnectManager = new ConnectManager(this.mContext);
        this.mUsingDNSProxy = z;
    }

    public void setSocketTimeout(int i) {
        mSocketTimeout = i;
    }

    public void setConnectTimeout(int i) {
        mConnectionTimeout = i;
    }

    public void setFollowRedirects(boolean z) {
        this.mFollowRedirects = z;
    }

    public HttpURLConnection getHttpURLConnection(String str, Map<String, String> map) throws IOException {
        return getHttpURLConnection(str, map, "GET", null, false, true);
    }

    public HttpURLConnection getHttpURLConnection(String str, Map<String, String> map, boolean z) throws IOException {
        return getHttpURLConnection(str, map, "GET", null, z, true);
    }

    public HttpURLConnection getHttpURLConnection(String str, Map<String, String> map, boolean z, boolean z2) throws IOException {
        return getHttpURLConnection(str, map, "GET", null, z, z2);
    }

    public HttpURLConnection getHttpURLConnection(String str, Map<String, String> map, String str2, List<NameValuePair> list, boolean z, boolean z2) throws IOException {
        if (usingDNSProxy()) {
            str = getRealUrl(str);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(mConnectionTimeout);
        httpURLConnection.setReadTimeout(mSocketTimeout);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setInstanceFollowRedirects(this.mFollowRedirects);
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpURLConnection.addRequestProperty(str3, map.get(str3));
            }
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            if (z) {
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, new X509TrustManager[]{new X509TrustManager() { // from class: com.baidu.down.loopj.android.urlconnection.ProxyURLConnection.1
                        @Override // javax.net.ssl.X509TrustManager
                        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str4) throws CertificateException {
                        }

                        @Override // javax.net.ssl.X509TrustManager
                        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str4) throws CertificateException {
                        }

                        @Override // javax.net.ssl.X509TrustManager
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }}, new SecureRandom());
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (usingDNSProxy() && this.mHostnameVerifier != null) {
                httpURLConnection.addRequestProperty("Host", this.mHost);
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.mHostnameVerifier);
                this.mHostnameVerifier = null;
            } else if (z2) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.down.loopj.android.urlconnection.ProxyURLConnection.2
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str4, SSLSession sSLSession) {
                        HttpsURLConnection.getDefaultHostnameVerifier();
                        return true;
                    }
                });
            }
        }
        httpURLConnection.setRequestMethod(str2);
        if (str2.equals("POST") && !addContentBody(httpURLConnection, list)) {
            httpURLConnection.setFixedLengthStreamingMode(0);
        }
        return httpURLConnection;
    }

    private boolean addContentBody(HttpURLConnection httpURLConnection, List<NameValuePair> list) throws IOException {
        if (list == null) {
            return false;
        }
        String obtainParams = obtainParams(list, true);
        httpURLConnection.setFixedLengthStreamingMode(obtainParams.length());
        httpURLConnection.setDoOutput(true);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("Content-Type"))) {
            httpURLConnection.addRequestProperty("Content-Type", CONTENT_TYPE_VALUE);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(obtainParams.getBytes());
        dataOutputStream.close();
        return true;
    }

    private String obtainParams(List<NameValuePair> list, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        for (NameValuePair nameValuePair : list) {
            stringBuffer.append('&');
            stringBuffer.append(z ? Uri.encode(nameValuePair.getName()) : nameValuePair.getName());
            stringBuffer.append('=');
            stringBuffer.append(Uri.encode(nameValuePair.getValue()));
        }
        return stringBuffer.toString();
    }

    public UrlConnectionRetryHandler getRetryHandler() {
        return this.mRetryHandler;
    }

    private String getRealUrl(String str) {
        Exception e;
        if (!TextUtils.isEmpty(str)) {
            try {
                String host = new URL(str).getHost();
                String[] ipByHost = HttpDns.getInstance().getIpByHost(host);
                if (ipByHost != null && ipByHost.length > 0 && !TextUtils.equals(ipByHost[0], host)) {
                    String replace = str.replace(host, ipByHost[0]);
                    try {
                        new URL(replace);
                        try {
                            this.mHost = host;
                            this.mHostnameVerifier = new HostnameVerifier() { // from class: com.baidu.down.loopj.android.urlconnection.ProxyURLConnection.3
                                @Override // javax.net.ssl.HostnameVerifier
                                public boolean verify(String str2, SSLSession sSLSession) {
                                    return true;
                                }
                            };
                            return replace;
                        } catch (Exception e2) {
                            e = e2;
                            str = replace;
                            e.printStackTrace();
                            return str;
                        }
                    } catch (MalformedURLException e3) {
                        setUsingDNSProxy(false);
                        return str;
                    }
                }
                return str;
            } catch (Exception e4) {
                e = e4;
            }
        } else {
            return str;
        }
    }

    public boolean usingDNSProxy() {
        return this.mUsingDNSProxy;
    }

    public void setUsingDNSProxy(boolean z) {
        this.mUsingDNSProxy = z;
    }

    private void disableConnectionReuseIfNecessary() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }
}
