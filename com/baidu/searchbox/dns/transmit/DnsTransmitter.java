package com.baidu.searchbox.dns.transmit;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.HttpDnsRuntime;
import com.baidu.searchbox.dns.IHttpDnsConfig;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.transmit.model.DnsResponse;
import com.baidu.searchbox.dns.transmit.transmitter.HttpGetDataTransmitter;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.webkit.internal.ETAG;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DnsTransmitter extends HttpGetDataTransmitter<DnsResponse> {
    public static final int ADDRESS_BGP_IP = 1;
    public static final int ADDRESS_IDC_IP = 2;
    public static final String BACKUP = "backup";
    public static final String BGP_IP = "180.76.76.112";
    public static final String BGP_IPV6 = "[240c:4006::6666]";
    public static final String DN = "dn";
    public static final String GROUP = "group";
    public static final String GROUP_V6 = "ipv6";
    public static final String GROUP_V6_12_8 = "ipv6_12_8";
    public static final String HTTPDNS_VERSION = "/v5/";
    public static final String IDC_HOST = "httpsdns.baidu.com";
    public static String IDC_IP = null;
    public static long IDC_IP_CACHETIME = -1;
    public static final int IDC_IP_TTL = 1800000;
    public static final String LABEL = "label";
    public static final String PATH_V6 = "/v6/0001/";
    public static final String PROTOCOL = "https://";
    public static final String TYPE_NAME = "type";
    public static final String TYPE_VALUE_IPV4 = "ipv4";
    public static final String TYPE_VALUE_IPV6 = "ipv6";
    public static HttpDNSStat dnsStat;
    public static IHttpDnsConfig httpDnsConfig = HttpDnsRuntime.getHttpDnsConfig();
    public static boolean idcEnable;
    public boolean hasError = false;
    public int mAddressType;
    public String mHost;
    public boolean mIsBatch;

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public int getMaxRetryTimes() {
        return 0;
    }

    /* loaded from: classes3.dex */
    public static class HttpDnsHostnameVerifier implements HostnameVerifier {
        public static HttpDnsHostnameVerifier get() {
            return new HttpDnsHostnameVerifier();
        }

        public boolean equals(Object obj) {
            return obj instanceof HttpDnsHostnameVerifier;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(DnsTransmitter.IDC_HOST, sSLSession);
        }
    }

    private void changeToBGPServer() {
        if (idcEnable && this.mAddressType == 2) {
            IDC_IP = null;
            IDC_IP_CACHETIME = -1L;
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "changeToBGPServer");
            }
        }
    }

    private String getDnsIp() {
        if (idcEnable && !TextUtils.isEmpty(IDC_IP) && this.mAddressType == 2) {
            return IDC_IP;
        }
        if (isIPv6Only()) {
            return BGP_IPV6;
        }
        return BGP_IP;
    }

    private String getHttpDnsPath() {
        String accountId = httpDnsConfig.getAccountId();
        return HTTPDNS_VERSION + accountId + "/";
    }

    private boolean isDualStack() {
        if (DnsUtil.stackType == 3) {
            return true;
        }
        return false;
    }

    private boolean isIPv6Only() {
        if (DnsUtil.stackType == 2) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public boolean isHttps() {
        if (getHttpUrl().toLowerCase(Locale.getDefault()).startsWith("https")) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter, com.baidu.searchbox.dns.transmit.transmitter.HttpTransmitter
    public DnsResponse sendRequest() {
        checkIDCIp();
        DnsResponse dnsResponse = (DnsResponse) super.sendRequest();
        if (this.hasError) {
            changeToBGPServer();
        }
        return dnsResponse;
    }

    public DnsTransmitter(boolean z, String str, int i) {
        this.mIsBatch = z;
        this.mHost = str;
        this.mAddressType = i;
    }

    private void checkIDCIp() {
        DnsTransmitTask task;
        if (idcEnable && this.mAddressType == 2 && IDC_IP_CACHETIME > 0 && System.currentTimeMillis() - IDC_IP_CACHETIME > 1800000 && (task = DnsTransmitTaskManager.getInstance().getTask(IDC_HOST, false, 2)) != null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " start update domain task: httpsdns.baidu.com");
            }
            task.start();
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpGetDataTransmitter
    public String getHttpUrl() {
        String str;
        if (DnsUtil.DEBUG && !TextUtils.isEmpty(DnsUtil.httpDnsDebugAddress)) {
            return DnsUtil.httpDnsDebugAddress;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(getDnsIp());
        if (!DnsUtil.idcIPv6Perfer && !isIPv6Only()) {
            str = getHttpDnsPath();
        } else {
            str = PATH_V6;
        }
        sb.append(str);
        return sb.toString();
    }

    private void reportDNSState(boolean z) {
        if (!this.mIsBatch && dnsStat != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", DnsCacheHelper.DIR_NAME);
                jSONObject.put("host", this.mHost);
                jSONObject.put(ETAG.KEY_DNS_INFO, getDnsIp());
                jSONObject.put("idcEnable", idcEnable);
                jSONObject.put("isSucess", z);
            } catch (JSONException e) {
                if (DnsUtil.DEBUG) {
                    e.printStackTrace();
                }
            }
            dnsStat.onHttpDnsFinish(jSONObject);
        }
    }

    public static void setDnsStat(HttpDNSStat httpDNSStat) {
        dnsStat = httpDNSStat;
    }

    public static void setIDCEable(boolean z) {
        idcEnable = z;
    }

    public static void setIDCIp(String str) {
        IDC_IP = str;
    }

    public static void setIDCIpCacheTime(long j) {
        IDC_IP_CACHETIME = j;
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void handleException(Exception exc) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " exception: ", exc);
        }
        this.hasError = true;
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void handleServerError(int i) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " server error: " + i);
        }
        this.hasError = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public DnsResponse parseResult(String str) {
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " response " + str);
        }
        return new DnsResponse(str, getDnsIp(), this.mAddressType, this.hasError);
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void processExtraConnection(HttpURLConnection httpURLConnection) throws ProtocolException {
        super.processExtraConnection(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Host", IDC_HOST);
        if (isHttps()) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(HttpDnsHostnameVerifier.get());
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public Map<String, Object> getParameters() {
        HashMap hashMap = new HashMap();
        if (this.mIsBatch) {
            hashMap.put("label", httpDnsConfig.getLabel());
        } else {
            hashMap.put("dn", this.mHost);
        }
        hashMap.put("backup", DnsCacheHelper.getCacheHelper().getDiskBackUpIpVersion());
        if (isIPv6Only()) {
            hashMap.put("group", "ipv6");
            hashMap.put("type", "ipv6");
        } else if (isDualStack()) {
            if (DnsUtil.idcIPv6Perfer) {
                hashMap.put("group", GROUP_V6_12_8);
            }
            hashMap.put("type", "ipv4,ipv6");
        } else {
            hashMap.put("type", TYPE_VALUE_IPV4);
        }
        return hashMap;
    }
}
