package com.baidu.bdhttpdns;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.tieba.cp;
import com.baidu.tieba.hp;
import com.baidu.tieba.ip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class HttpDnsClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile HttpDnsClient q = null;
    public static boolean r = true;
    public static d s;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public long f;
    public final HashSet<String> g;
    public final Object h;
    public final Object i;
    public ArrayList<String> j;
    public String k;
    public String l;
    public boolean m;
    public int n;
    public int o;
    public int p;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, RequestParamType requestParamType, Map<String, e> map, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-661556435, "Lcom/baidu/bdhttpdns/HttpDnsClient;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-661556435, "Lcom/baidu/bdhttpdns/HttpDnsClient;");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class RequestParamType {
        public static final /* synthetic */ RequestParamType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RequestParamType DNLIST_HOSTS;
        public static final RequestParamType TAG_OF_HOSTS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-113941715, "Lcom/baidu/bdhttpdns/HttpDnsClient$RequestParamType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-113941715, "Lcom/baidu/bdhttpdns/HttpDnsClient$RequestParamType;");
                    return;
                }
            }
            DNLIST_HOSTS = new RequestParamType("DNLIST_HOSTS", 0);
            RequestParamType requestParamType = new RequestParamType("TAG_OF_HOSTS", 1);
            TAG_OF_HOSTS = requestParamType;
            $VALUES = new RequestParamType[]{DNLIST_HOSTS, requestParamType};
        }

        public RequestParamType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RequestParamType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RequestParamType) Enum.valueOf(RequestParamType.class, str);
            }
            return (RequestParamType) invokeL.objValue;
        }

        public static RequestParamType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RequestParamType[]) $VALUES.clone();
            }
            return (RequestParamType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public RequestParamType b;
        public b c;
        public boolean d;
        public boolean e;
        public final /* synthetic */ HttpDnsClient f;

        public c(HttpDnsClient httpDnsClient, String str, RequestParamType requestParamType, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpDnsClient, str, requestParamType, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = httpDnsClient;
            this.a = str;
            this.b = requestParamType;
            this.c = bVar;
            this.d = false;
            this.e = false;
        }

        public final String a(String str, RequestParamType requestParamType) {
            InterceptResult invokeLL;
            String b;
            String str2;
            String format;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, requestParamType)) == null) {
                long currentTimeMillis = (System.currentTimeMillis() / 1000) + 300 + this.f.f;
                String v = this.f.v(str, currentTimeMillis);
                if (v == null) {
                    return null;
                }
                if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                    b = b(this.f.b, this.f.n);
                    if (b == null) {
                        b = this.f.a;
                        this.e = false;
                        hp.a("Using BGPServerIp(%s)", this.f.a);
                    }
                    if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                        str2 = "dual_stack";
                    } else {
                        str2 = DnsTransmitter.TYPE_VALUE_IPV4;
                    }
                } else if (!BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                    return null;
                } else {
                    b = b(this.f.d, this.f.o);
                    if (b == null) {
                        b = this.f.c;
                        this.e = false;
                        hp.a("Using BGPServerIp(%s)", this.f.c);
                    }
                    str2 = "ipv6";
                }
                if (requestParamType.equals(RequestParamType.TAG_OF_HOSTS)) {
                    format = String.format("%s/v4/resolve?account_id=%s&tag=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true&type=%s", b, this.f.k, str, v, Long.valueOf(currentTimeMillis), "1.3", "android", str2);
                } else {
                    format = String.format("%s/v4/resolve?account_id=%s&dn=%s&sign=%s&t=%d&sdk_ver=%s&os_type=%s&alt_server_ip=true&type=%s", b, this.f.k, str, v, Long.valueOf(currentTimeMillis), "1.3", "android", str2);
                }
                if (this.f.e) {
                    return String.format("https://%s", format);
                }
                return String.format("http://%s", format);
            }
            return (String) invokeLL.objValue;
        }

        public final String b(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
                if (str != null && i < 3) {
                    this.e = true;
                    hp.a("Using IDCServerIP(%s)", str);
                    return str;
                }
                return null;
            }
            return (String) invokeLI.objValue;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:99:0x0010 */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x019c, code lost:
            if (r1 == null) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0203, code lost:
            if (r1 == null) goto L70;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r7v25, types: [com.baidu.bdhttpdns.HttpDnsClient] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(String str) {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            HttpURLConnection httpURLConnection3;
            Boolean bool;
            HttpURLConnection httpURLConnection4;
            HttpsURLConnection httpsURLConnection;
            InputStream inputStream;
            Boolean bool2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                Map<String, e> hashMap = new HashMap<>();
                ?? r1 = Boolean.TRUE;
                try {
                    try {
                        URL url = new URL(str);
                        if (this.f.e) {
                            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                            httpsURLConnection2.setRequestProperty("Host", "httpdns.baidubce.com");
                            httpsURLConnection2.setHostnameVerifier(HttpDnsClient.s);
                            httpsURLConnection = httpsURLConnection2;
                        } else {
                            httpsURLConnection = (HttpURLConnection) url.openConnection();
                        }
                        try {
                            httpsURLConnection.setRequestMethod("GET");
                            httpsURLConnection.setReadTimeout(30000);
                            httpsURLConnection.setConnectTimeout(30000);
                            httpsURLConnection.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                            httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                            httpsURLConnection.connect();
                            int responseCode = httpsURLConnection.getResponseCode();
                            if (responseCode >= 400) {
                                inputStream = httpsURLConnection.getErrorStream();
                            } else {
                                inputStream = httpsURLConnection.getInputStream();
                            }
                            if (inputStream == null) {
                                Boolean bool3 = Boolean.FALSE;
                                this.f.H(Boolean.valueOf(this.e));
                                hp.a("Httpdns request failed for %s(%s), get null response stream", this.b.toString(), this.a);
                                this.c.a(-1, this.b, null, this.a);
                                bool2 = bool3;
                            } else {
                                String F = this.f.F(inputStream, httpsURLConnection);
                                hp.a("Response data is : %s", F);
                                if (F == null) {
                                    Boolean bool4 = Boolean.FALSE;
                                    this.f.H(Boolean.valueOf(this.e));
                                    hp.a("Httpdns request failed for %s(%s), get empty response data", this.b.toString(), this.a);
                                    this.c.a(-1, this.b, null, this.a);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                        return;
                                    }
                                    return;
                                }
                                Map w = this.f.w(F, this.a, this.b);
                                if (w.get("isSignExpired").equals(Boolean.TRUE)) {
                                    this.d = true;
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (this.e) {
                                        if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                                            this.f.n = 0;
                                            return;
                                        } else if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                                            this.f.o = 0;
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    return;
                                } else if (w.get("isMsgOK").equals(Boolean.TRUE) && responseCode == 200) {
                                    hashMap = this.f.J(F, this.a);
                                    bool2 = r1;
                                } else {
                                    this.c.a(-1, this.b, null, this.a);
                                    bool2 = r1;
                                }
                            }
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            if (bool2.booleanValue() && this.e) {
                                if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                                    this.f.n = 0;
                                } else if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                                    this.f.o = 0;
                                }
                            }
                        } catch (IOException e) {
                            httpURLConnection3 = httpsURLConnection;
                            e = e;
                            e.printStackTrace();
                            bool = Boolean.FALSE;
                            this.f.H(Boolean.valueOf(this.e));
                            hp.a("Httpdns request failed for %s(%s), caught network IOException", this.b.toString(), this.a);
                            this.c.a(-1, this.b, null, this.a);
                            httpURLConnection4 = httpURLConnection3;
                            r1 = httpURLConnection3;
                        } catch (ArrayIndexOutOfBoundsException e2) {
                            httpURLConnection2 = httpsURLConnection;
                            e = e2;
                            e.printStackTrace();
                            bool = Boolean.FALSE;
                            this.f.H(Boolean.valueOf(this.e));
                            hp.a("Httpdns request failed for %s(%s), caught ArrayIndexOutOfBoundsException", this.b.toString(), this.a);
                            this.c.a(-1, this.b, null, this.a);
                            r1 = httpURLConnection2;
                            if (httpURLConnection2 != null) {
                                httpURLConnection4 = httpURLConnection2;
                                httpURLConnection4.disconnect();
                                r1 = httpURLConnection4;
                            }
                            if (hashMap == null) {
                            }
                            this.c.a(-1, this.b, null, this.a);
                        } catch (Throwable th) {
                            httpURLConnection = httpsURLConnection;
                            th = th;
                            th.printStackTrace();
                            bool = Boolean.FALSE;
                            this.f.H(Boolean.valueOf(this.e));
                            hp.a("Httpdns request failed for %s(%s), caught Exception", this.b.toString(), this.a);
                            this.c.a(-1, this.b, null, this.a);
                            httpURLConnection4 = httpURLConnection;
                            r1 = httpURLConnection;
                        }
                    } catch (Throwable th2) {
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                        if (bool.booleanValue() && this.e) {
                            if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                                this.f.n = 0;
                            } else if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                                this.f.o = 0;
                            }
                        }
                        throw th2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    httpURLConnection3 = null;
                } catch (ArrayIndexOutOfBoundsException e4) {
                    e = e4;
                    httpURLConnection2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = null;
                }
                if (hashMap == null && !hashMap.isEmpty()) {
                    this.c.a(0, this.b, hashMap, this.a);
                } else {
                    this.c.a(-1, this.b, null, this.a);
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                String a = a(this.a, this.b);
                hp.a("Request url is :%s", a);
                if (a == null) {
                    this.c.a(-1, this.b, null, this.a);
                    hp.a("Httpdns request failed for  %s(%s), get url error", this.b.toString(), this.a);
                    return;
                }
                c(a);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                d();
                if (this.d) {
                    hp.a("Retry for %s(%s).", this.b.toString(), this.a);
                    d();
                }
                synchronized (this.f.h) {
                    if (!this.b.equals(RequestParamType.TAG_OF_HOSTS)) {
                        for (String str : this.a.split(",")) {
                            this.f.g.remove(str);
                        }
                    }
                }
                synchronized (this.f.i) {
                    if (this.b.equals(RequestParamType.DNLIST_HOSTS)) {
                        for (String str2 : this.a.split(",")) {
                            this.f.j.remove(str2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(HttpDnsClient httpDnsClient) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpDnsClient};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(HttpDnsClient httpDnsClient, a aVar) {
            this(httpDnsClient);
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify("httpdns.baidubce.com", sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList<String> a;
        public final ArrayList<String> b;
        public final long c;

        public e(HttpDnsClient httpDnsClient, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpDnsClient, arrayList, arrayList2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = arrayList;
            this.b = arrayList2;
            this.c = j;
        }

        public ArrayList<String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (ArrayList) invokeV.objValue;
        }

        public ArrayList<String> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (ArrayList) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.longValue;
        }
    }

    public HttpDnsClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "180.76.76.200";
        this.c = DnsTransmitter.BGP_IPV6;
        this.e = true;
        this.f = 0L;
        this.i = new Object();
        this.j = new ArrayList<>();
        this.k = "";
        this.l = "";
        this.m = false;
        this.p = 10;
        this.h = new Object();
        this.g = new HashSet<>();
        s = new d(this, null);
    }

    public static boolean I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                new JSONObject(str);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.k = str;
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.e = z;
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.m = z;
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            String d2 = cp.d(str);
            this.l = d2;
            if (d2 == null) {
                this.l = str;
                r = false;
            }
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            synchronized (this.i) {
                if (!this.j.contains(str)) {
                    this.j.add(str);
                }
            }
        }
    }

    public final String v(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048592, this, str, j)) == null) {
            return cp.j(String.format("%s-%s-%d", str, D(), Long.valueOf(j)));
        }
        return (String) invokeLJ.objValue;
    }

    public static HttpDnsClient z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            if (q == null) {
                synchronized (HttpDnsClient.class) {
                    if (q == null) {
                        q = new HttpDnsClient();
                    }
                }
            }
            return q;
        }
        return (HttpDnsClient) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!r) {
                return this.l;
            }
            return cp.b(this.l);
        }
        return (String) invokeV.objValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.n = 0;
            this.o = 0;
            this.b = null;
            this.d = null;
        }
    }

    public ArrayList y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.j;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final String B(String str, String str2, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return jSONObject.getString("msg");
            } catch (JSONException e2) {
                e2.printStackTrace();
                hp.a("Httpdns request failed, host(%s), response has no msg in %s ", str2, str);
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public final ArrayList<String> A(String str, String str2, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, jSONObject)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("ip");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (optString != null && !optString.isEmpty()) {
                        if (!cp.l(optString) && !cp.m(optString)) {
                            hp.a("Httpdns request warning, host(%s), response of data get invalid ip(%s) in %s", str2, optString, str);
                        } else {
                            arrayList.add(optString);
                        }
                    } else {
                        hp.a("Httpdns request warning, host(%s), response of data get ip error in %s", str2, str);
                    }
                }
                return arrayList;
            }
            hp.a("Httpdns request warning, host(%s), response has no ip field in %s", str2, str);
            return null;
        }
        return (ArrayList) invokeLLL.objValue;
    }

    public final String E(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bArr, i)) == null) {
            byte[] bArr2 = new byte[i];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                do {
                    int read = gZIPInputStream.read(bArr2, 0, i);
                    byteArrayOutputStream.write(bArr2, 0, read);
                    if (read == -1) {
                        break;
                    }
                } while (!I(byteArrayOutputStream.toString()));
                gZIPInputStream.close();
                return byteArrayOutputStream.toString();
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLI.objValue;
    }

    public final String F(InputStream inputStream, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, inputStream, httpURLConnection)) == null) {
            String contentEncoding = httpURLConnection.getContentEncoding();
            if (contentEncoding != null) {
                try {
                    if (contentEncoding.contains("gzip")) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int contentLength = httpURLConnection.getContentLength();
                        if (contentLength > 0) {
                            byte[] bArr = new byte[contentLength];
                            inputStream.read(bArr);
                            byteArrayOutputStream.write(bArr, 0, contentLength);
                        } else {
                            contentLength = 1024;
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (-1 == read) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                        }
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        return E(byteArrayOutputStream.toByteArray(), contentLength);
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } else {
            return (String) invokeLL.objValue;
        }
    }

    public void O(ArrayList<String> arrayList, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, arrayList, bVar) == null) {
            ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
            int i = 0;
            int i2 = 0;
            while (i < arrayList2.size()) {
                String str = "";
                int i3 = 0;
                while (true) {
                    int i4 = this.p;
                    if (i3 >= i4 || (i = i3 + (i4 * i2)) >= arrayList2.size()) {
                        break;
                    }
                    str = str + ((String) arrayList2.get(i)) + ",";
                    i3++;
                }
                i2++;
                if (str != null && !str.isEmpty()) {
                    String substring = str.substring(0, str.length() - 1);
                    hp.a("Hosts for httpdns request is (%s) ", substring);
                    u(substring, RequestParamType.DNLIST_HOSTS, bVar);
                }
            }
        }
    }

    public final long G(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLLL;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, jSONObject, jSONObject2)) == null) {
            if (jSONObject != null) {
                try {
                    j = jSONObject.getLong("ttl");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    hp.a("Httpdns request failed, host(%s), response has no ttl, will use defaults ttl(60s)", str);
                    return -1L;
                }
            } else {
                j = -1;
            }
            if (jSONObject2 != null) {
                j2 = jSONObject2.getLong("ttl");
            } else {
                j2 = -1;
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i > 0 && j2 > 0) {
                if (j >= j2) {
                    return j2;
                }
                return j;
            } else if (i > 0) {
                return j;
            } else {
                if (j2 <= 0) {
                    return -1L;
                }
                return j2;
            }
        }
        return invokeLLL.longValue;
    }

    public final synchronized void H(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bool) == null) {
            synchronized (this) {
                if (bool.booleanValue()) {
                    if (BDNetworkStateChangeReceiver.isIPv4Reachable()) {
                        int i = this.n + 1;
                        this.n = i;
                        hp.a("requestV4IDCFailNum: %s", Integer.valueOf(i));
                    } else if (BDNetworkStateChangeReceiver.isIPv6Reachable()) {
                        int i2 = this.o + 1;
                        this.o = i2;
                        hp.a("requestV6IDCFailNum: %s", Integer.valueOf(i2));
                    }
                }
            }
        }
    }

    public Map J(String str, String str2) {
        InterceptResult invokeLL;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            boolean z = false;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("serverip")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("serverip");
                    JSONArray optJSONArray = optJSONObject.optJSONArray(DnsTransmitter.TYPE_VALUE_IPV4);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        this.b = optJSONArray.optString(0);
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("ipv6");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        this.d = PreferencesUtil.LEFT_MOUNT + optJSONArray2.optString(0) + PreferencesUtil.RIGHT_MOUNT;
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    hp.a("Httpdns request failed, hostsOrTag(%s), response has empty data", str2);
                    return null;
                }
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next);
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject(DnsTransmitter.TYPE_VALUE_IPV4);
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("ipv6");
                    long G = G(next, optJSONObject4, optJSONObject5);
                    if (G < 0) {
                        hashMap.put(next, z);
                    } else {
                        String B = B("ipv4Obj", next, optJSONObject4);
                        String B2 = B("ipv6Obj", next, optJSONObject5);
                        if (B != null && !B.isEmpty()) {
                            arrayList = A("ipv4Obj", next, optJSONObject4);
                        } else {
                            hp.a("Host(%s) ipv4Msg(%s), will deprecated the ipv4List result", next, B);
                            arrayList = null;
                        }
                        if (B2 != null && !B2.isEmpty()) {
                            arrayList2 = A("ipv6Obj", next, optJSONObject5);
                        } else {
                            hp.a("Host(%s) ipv6Msg(%s), will deprecated the ipv6List result", next, B2);
                            arrayList2 = null;
                        }
                        if ((arrayList != null && !arrayList.isEmpty()) || (arrayList2 != null && !arrayList2.isEmpty())) {
                            hashMap.put(next, new e(this, arrayList, arrayList2, G));
                        } else {
                            hp.a("Httpdns request failed, host(%s), response has no valid ip", next);
                            hashMap.put(next, null);
                        }
                        z = false;
                    }
                }
                return hashMap;
            } catch (JSONException e2) {
                e2.printStackTrace();
                hp.a("Httpdns request failed, hostsOrTag(%s), response parse data json error", str2);
                return null;
            }
        }
        return (Map) invokeLL.objValue;
    }

    public void u(String str, RequestParamType requestParamType, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048591, this, str, requestParamType, bVar) == null) && str != null && !str.isEmpty()) {
            synchronized (this.h) {
                if (requestParamType.equals(RequestParamType.DNLIST_HOSTS)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(Arrays.asList(str.split(",")));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        if (!this.g.contains(str2)) {
                            this.g.add(str2);
                        } else {
                            hp.a("Httpdns request request for host(%s) is in processing，will exclude it.", str2);
                            it.remove();
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append((String) arrayList.get(i));
                        sb.append(",");
                    }
                    str = sb.toString().replaceAll("^,*|,*$", "");
                }
                if (str != null && !str.isEmpty()) {
                    try {
                        ip.b().a().execute(new c(this, str, requestParamType, bVar));
                    } catch (RejectedExecutionException e2) {
                        e2.printStackTrace();
                        hp.a("Httpdns request failed, host(%s), async tasks has exceed the maximum thread limit.", str);
                    }
                }
            }
        }
    }

    public Map w(String str, String str2, RequestParamType requestParamType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, str2, requestParamType)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("isMsgOK", Boolean.FALSE);
            hashMap.put("isSignExpired", Boolean.FALSE);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("msg");
                if (optString != null && !optString.isEmpty()) {
                    if ("SignatureExpired".equals(optString)) {
                        int optInt = jSONObject.optInt("timestamp");
                        if (optInt == 0) {
                            hp.a("Httpdns request failed for %s(%s), response get invalid timestamp", requestParamType.toString(), str2);
                        } else {
                            this.f = optInt - (System.currentTimeMillis() / 1000);
                            hashMap.put("isSignExpired", Boolean.TRUE);
                        }
                        return hashMap;
                    } else if (!DnsModel.MSG_OK.equals(optString)) {
                        hp.a("Httpdns request failed for %s(%s), response msg(%s) is not ok", requestParamType.toString(), str2, optString);
                        return hashMap;
                    } else {
                        hashMap.put("isMsgOK", Boolean.TRUE);
                        return hashMap;
                    }
                }
                hp.a("Httpdns request failed for %s(%s), response lack of msg", requestParamType.toString(), str2);
                return hashMap;
            } catch (JSONException e2) {
                e2.printStackTrace();
                hp.a("Httpdns request failed for %s(%s), response parse json error", requestParamType.toString(), str2);
                return hashMap;
            }
        }
        return (Map) invokeLLL.objValue;
    }
}
