package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
public class c extends com.baidu.searchbox.dns.d.c.b<com.baidu.searchbox.dns.d.a.b> {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean L = false;
    public static String M = null;
    public static long N = -1;
    public static boolean P;
    public static HttpDNSStat Q;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean E;
    public String F;
    public int H;
    public boolean O;

    /* loaded from: classes2.dex */
    public static class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a() : (a) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj instanceof a : invokeL.booleanValue;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, sSLSession)) == null) ? HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession) : invokeLL.booleanValue;
        }
    }

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

    public c(boolean z, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.O = false;
        this.E = z;
        this.F = str;
        this.H = i2;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            N = j;
        }
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            P = z;
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            M = str;
        }
    }

    private String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (P && !TextUtils.isEmpty(M) && this.H == 2) ? M : "180.76.76.112" : (String) invokeV.objValue;
    }

    private void s() {
        com.baidu.searchbox.dns.d.a a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || !P || this.H != 2 || N <= 0 || System.currentTimeMillis() - N <= 1800000 || (a2 = b.o().a("httpsdns.baidu.com", false, 2)) == null) {
            return;
        }
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " start update domain task: httpsdns.baidu.com");
        }
        a2.start();
    }

    private void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && P && this.H == 2) {
            M = null;
            N = -1L;
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "changeToBGPServer");
            }
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " server error: " + i2);
            }
            this.O = true;
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public Map<String, Object> getParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap hashMap = new HashMap();
            if (this.E) {
                hashMap.put(NotificationCompatJellybean.KEY_LABEL, this.F);
                if (L) {
                    hashMap.put(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, com.baidu.searchbox.dns.a.a.e().g());
                }
            } else {
                hashMap.put(Config.DEVICE_NAME, this.F);
            }
            if (L) {
                hashMap.put("type", "ipv4,ipv6");
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (L) {
                return "https://" + r() + "/v5/0001/";
            }
            return "https://" + r() + "/v2/0001/";
        }
        return (String) invokeV.objValue;
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
            if (this.O) {
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
            return true;
        }
        return invokeV.booleanValue;
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

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            L = z;
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " exception: ", exc);
            }
            this.O = true;
        }
    }

    @Override // com.baidu.searchbox.dns.d.c.a
    public void a(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpURLConnection) == null) {
            super.a(httpURLConnection);
            httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            httpURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
            if (v()) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a.y());
            }
        }
    }

    public static void a(HttpDNSStat httpDNSStat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, httpDNSStat) == null) {
            Q = httpDNSStat;
        }
    }
}
