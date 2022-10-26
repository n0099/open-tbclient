package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import com.yy.hiidostatis.inner.FlushManager;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
public class c extends com.baidu.searchbox.dns.d.c.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String L = null;
    public static long M = -1;
    public static boolean O;
    public static HttpDNSStat P;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean E;
    public String F;
    public int H;
    public boolean N;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-957690909, "Lcom/baidu/searchbox/dns/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-957690909, "Lcom/baidu/searchbox/dns/d/c;");
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public static a y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new a();
            }
            return (a) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return obj instanceof a;
            }
            return invokeL.booleanValue;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, sSLSession)) == null) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    public c(boolean z, String str, int i) {
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
        this.N = false;
        this.E = z;
        this.F = str;
        this.H = i;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            M = j;
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            O = z;
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            L = str;
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " server error: " + i);
            }
            this.N = true;
        }
    }

    public static void a(HttpDNSStat httpDNSStat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, httpDNSStat) == null) {
            P = httpDNSStat;
        }
    }

    private String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (O && !TextUtils.isEmpty(L) && this.H == 2) {
                return L;
            }
            return "180.76.76.112";
        }
        return (String) invokeV.objValue;
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && O && this.H == 2) {
            L = null;
            M = -1L;
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "changeToBGPServer");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.d.c.a
    /* renamed from: t */
    public com.baidu.searchbox.dns.d.a.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            s();
            com.baidu.searchbox.dns.d.a.b bVar = (com.baidu.searchbox.dns.d.a.b) super.x();
            if (this.N) {
                u();
            }
            return bVar;
        }
        return (com.baidu.searchbox.dns.d.a.b) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (q().toLowerCase().startsWith("https")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void s() {
        com.baidu.searchbox.dns.d.a a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && O && this.H == 2 && M > 0 && System.currentTimeMillis() - M > FlushManager.ReportTimer.DEFAULT_INTERVAL && (a2 = b.o().a("httpsdns.baidu.com", false, 2)) != null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " start update domain task: httpsdns.baidu.com");
            }
            a2.start();
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public Map getParameters() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap hashMap = new HashMap();
            if (this.E) {
                hashMap.put("label", this.F);
            } else {
                hashMap.put(Config.DEVICE_NAME, this.F);
            }
            hashMap.put(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, com.baidu.searchbox.dns.a.a.e().g());
            hashMap.put("type", "ipv4,ipv6");
            if (DnsUtil.iPv6TestEnable) {
                if (DnsUtil.iPv6Perfer) {
                    str = HttpDnsCacheForHost.JSON_KEY_IPV6;
                } else {
                    str = "ipv4";
                }
                hashMap.put("group", str);
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " exception: ", exc);
            }
            this.N = true;
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void a(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpURLConnection) == null) {
            super.a(httpURLConnection);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
            if (v()) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a.y());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.dns.d.c.a
    /* renamed from: l */
    public com.baidu.searchbox.dns.d.a.b m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " response " + str);
            }
            return new com.baidu.searchbox.dns.d.a.b(str);
        }
        return (com.baidu.searchbox.dns.d.a.b) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.dns.d.c.b
    public String q() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (DnsUtil.DEBUG && !TextUtils.isEmpty(DnsUtil.httpDnsDebugAddress)) {
                return DnsUtil.httpDnsDebugAddress;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("https://");
            sb.append(r());
            if (DnsUtil.iPv6TestEnable) {
                str = "/v6/0001/";
            } else {
                str = "/v5/0001/";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
