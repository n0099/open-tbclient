package com.baidu.searchbox.dns.transmit;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.HttpDnsRuntime;
import com.baidu.searchbox.dns.IHttpDnsConfig;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.transmit.model.DnsResponse;
import com.baidu.searchbox.dns.transmit.transmitter.HttpGetDataTransmitter;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import com.yy.hiidostatis.inner.FlushManager;
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
/* loaded from: classes2.dex */
public class DnsTransmitter extends HttpGetDataTransmitter<DnsResponse> {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static IHttpDnsConfig httpDnsConfig;
    public static boolean idcEnable;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasError;
    public int mAddressType;
    public String mHost;
    public boolean mIsBatch;

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public int getMaxRetryTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public static class HttpDnsHostnameVerifier implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public HttpDnsHostnameVerifier() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static HttpDnsHostnameVerifier get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new HttpDnsHostnameVerifier();
            }
            return (HttpDnsHostnameVerifier) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return obj instanceof HttpDnsHostnameVerifier;
            }
            return invokeL.booleanValue;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, sSLSession)) == null) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(DnsTransmitter.IDC_HOST, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1907240108, "Lcom/baidu/searchbox/dns/transmit/DnsTransmitter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1907240108, "Lcom/baidu/searchbox/dns/transmit/DnsTransmitter;");
                return;
            }
        }
        httpDnsConfig = HttpDnsRuntime.getHttpDnsConfig();
    }

    private void changeToBGPServer() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && idcEnable && this.mAddressType == 2) {
            IDC_IP = null;
            IDC_IP_CACHETIME = -1L;
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "changeToBGPServer");
            }
        }
    }

    private String getHttpDnsPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            String accountId = httpDnsConfig.getAccountId();
            return HTTPDNS_VERSION + accountId + "/";
        }
        return (String) invokeV.objValue;
    }

    private boolean isDualStack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (DnsUtil.stackType == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isIPv6Only() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (DnsUtil.stackType == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public boolean isHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getHttpUrl().toLowerCase(Locale.getDefault()).startsWith("https")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter, com.baidu.searchbox.dns.transmit.transmitter.HttpTransmitter
    public DnsResponse sendRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            checkIDCIp();
            DnsResponse dnsResponse = (DnsResponse) super.sendRequest();
            if (this.hasError) {
                changeToBGPServer();
            }
            return dnsResponse;
        }
        return (DnsResponse) invokeV.objValue;
    }

    public DnsTransmitter(boolean z, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hasError = false;
        this.mIsBatch = z;
        this.mHost = str;
        this.mAddressType = i;
    }

    private void checkIDCIp() {
        DnsTransmitTask task;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && idcEnable && this.mAddressType == 2 && IDC_IP_CACHETIME > 0 && System.currentTimeMillis() - IDC_IP_CACHETIME > FlushManager.ReportTimer.DEFAULT_INTERVAL && (task = DnsTransmitTaskManager.getInstance().getTask(IDC_HOST, false, 2)) != null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " start update domain task: httpsdns.baidu.com");
            }
            task.start();
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpGetDataTransmitter
    public String getHttpUrl() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    private String getDnsIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (idcEnable && !TextUtils.isEmpty(IDC_IP) && this.mAddressType == 2) {
                return IDC_IP;
            }
            if (isIPv6Only()) {
                return BGP_IPV6;
            }
            return BGP_IP;
        }
        return (String) invokeV.objValue;
    }

    private void reportDNSState(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65544, this, z) == null) && !this.mIsBatch && dnsStat != null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, httpDNSStat) == null) {
            dnsStat = httpDNSStat;
        }
    }

    public static void setIDCEable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            idcEnable = z;
        }
    }

    public static void setIDCIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            IDC_IP = str;
        }
    }

    public static void setIDCIpCacheTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65548, null, j) == null) {
            IDC_IP_CACHETIME = j;
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void handleException(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " exception: ", exc);
            }
            this.hasError = true;
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void handleServerError(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " server error: " + i);
            }
            this.hasError = true;
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void processExtraConnection(HttpURLConnection httpURLConnection) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpURLConnection) == null) {
            super.processExtraConnection(httpURLConnection);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty("Host", IDC_HOST);
            if (isHttps()) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(HttpDnsHostnameVerifier.get());
            }
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public Map<String, Object> getParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return (Map) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public DnsResponse parseResult(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " response " + str);
            }
            return new DnsResponse(str, getDnsIp(), this.mAddressType, this.hasError);
        }
        return (DnsResponse) invokeL.objValue;
    }
}
