package com.baidu.apollon.restnet.http;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.c.b.b0;
import b.c.b.i;
import b.c.b.p;
import b.c.b.q;
import b.c.b.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final C1615b f36958e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f36959a;

    /* renamed from: b  reason: collision with root package name */
    public d f36960b;

    /* renamed from: c  reason: collision with root package name */
    public a f36961c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36962d;

    /* renamed from: com.baidu.apollon.restnet.http.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f36963a;

        /* renamed from: b  reason: collision with root package name */
        public String f36964b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f36965c;

        /* renamed from: d  reason: collision with root package name */
        public String f36966d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f36967e;

        /* renamed from: f  reason: collision with root package name */
        public String f36968f;

        /* renamed from: g  reason: collision with root package name */
        public String f36969g;

        /* renamed from: h  reason: collision with root package name */
        public String f36970h;

        /* renamed from: i  reason: collision with root package name */
        public Map<String, Long> f36971i;
        public Map<String, Long> j;
        public Map<String, Long> k;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36971i = new HashMap();
            this.j = new HashMap();
            this.k = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f36963a = Uri.parse(str).getHost();
            this.f36964b = Uri.parse(str).getPath();
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1615b implements p.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f36972a;

        public C1615b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36972a = 0.1d;
        }

        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) || d2 > 1.0d) {
                return;
            }
            this.f36972a = d2;
        }

        @Override // b.c.b.p.c
        public p create(b.c.b.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                if (Math.random() < this.f36972a) {
                    return new b(System.nanoTime(), null);
                }
                return p.NONE;
            }
            return (p) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final String f36973a = "plt";

        /* renamed from: b  reason: collision with root package name */
        public static final String f36974b = "dns";

        /* renamed from: c  reason: collision with root package name */
        public static final String f36975c = "pdt";

        /* renamed from: d  reason: collision with root package name */
        public static final String f36976d = "tcp";

        /* renamed from: e  reason: collision with root package name */
        public static final String f36977e = "srt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f36978f = "host";

        /* renamed from: g  reason: collision with root package name */
        public static final String f36979g = "path";

        /* renamed from: h  reason: collision with root package name */
        public static final String f36980h = "proxy";

        /* renamed from: i  reason: collision with root package name */
        public static final String f36981i = "location";
        public static final String j = "protocol";
        public static final String k = "hostAddresses";
        public static final String l = "connectHostAddress";
        public static final String m = "connectFailedHostAddresses";
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f36982a;

        /* renamed from: b  reason: collision with root package name */
        public long f36983b;

        /* renamed from: c  reason: collision with root package name */
        public long f36984c;

        /* renamed from: d  reason: collision with root package name */
        public long f36985d;

        /* renamed from: e  reason: collision with root package name */
        public long f36986e;

        /* renamed from: f  reason: collision with root package name */
        public long f36987f;

        /* renamed from: g  reason: collision with root package name */
        public long f36988g;

        /* renamed from: h  reason: collision with root package name */
        public long f36989h;

        /* renamed from: i  reason: collision with root package name */
        public long f36990i;
        public long j;
        public long k;
        public long l;
        public long m;
        public long n;
        public long o;
        public long p;
        public long q;
        public long r;
        public long s;
        public long t;

        public d() {
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

        public d(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f36982a = j;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(c.f36973a, this.r - this.f36982a).put(c.f36974b, this.f36984c - this.f36983b).put(c.f36975c, this.p - this.m).put(c.f36977e, this.m - this.f36990i);
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1125603108, "Lcom/baidu/apollon/restnet/http/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1125603108, "Lcom/baidu/apollon/restnet/http/b;");
                return;
            }
        }
        f36958e = new C1615b();
    }

    public /* synthetic */ b(long j, AnonymousClass1 anonymousClass1) {
        this(j);
    }

    private long a(a aVar) {
        InterceptResult invokeL;
        long longValue;
        long longValue2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar)) == null) {
            long j = 0;
            if (aVar == null) {
                return 0L;
            }
            for (Map.Entry<String, Long> entry : aVar.f36971i.entrySet()) {
                if (aVar.j.containsKey(entry.getKey())) {
                    longValue = aVar.j.get(entry.getKey()).longValue();
                    longValue2 = entry.getValue().longValue();
                } else if (aVar.k.containsKey(entry.getKey())) {
                    longValue = aVar.k.get(entry.getKey()).longValue();
                    longValue2 = entry.getValue().longValue();
                }
                j += longValue - longValue2;
            }
            return j;
        }
        return invokeL.longValue;
    }

    @Override // b.c.b.p
    public void callEnd(b.c.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f36960b.r = a(System.nanoTime() - this.f36959a);
            try {
                JSONObject put = this.f36960b.a().put("host", this.f36961c.f36963a).put("path", this.f36961c.f36964b).put(c.l, this.f36961c.f36966d).put("protocol", this.f36961c.f36969g).put(c.f36976d, a(this.f36961c));
                if (!Proxy.Type.DIRECT.toString().equals(this.f36961c.f36968f)) {
                    put.put("proxy", this.f36961c.f36968f);
                }
                if (this.f36961c.f36965c != null) {
                    put.put(c.k, Arrays.toString(this.f36961c.f36965c));
                }
                if (!TextUtils.isEmpty(this.f36961c.f36970h)) {
                    put.put("location", this.f36961c.f36970h);
                }
                if (this.f36962d) {
                    a(this.f36961c.f36970h);
                }
                com.baidu.apollon.restnet.a.a().a(put);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // b.c.b.p
    public void callFailed(b.c.b.e eVar, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, iOException) == null) {
            this.f36960b.s = a(System.nanoTime() - this.f36959a);
            try {
                JSONObject put = new JSONObject().put("host", this.f36961c.f36963a).put("path", this.f36961c.f36964b).put("protocol", this.f36961c.f36969g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f36961c.f36968f)) {
                    put.put("proxy", this.f36961c.f36968f);
                }
                if (this.f36961c.f36965c != null) {
                    put.put(c.k, Arrays.toString(this.f36961c.f36965c));
                }
                if (this.f36961c.f36967e != null) {
                    put.put(c.m, this.f36961c.f36967e.toString());
                }
                if (!TextUtils.isEmpty(this.f36961c.f36970h)) {
                    put.put("location", this.f36961c.f36970h);
                }
                com.baidu.apollon.restnet.a.a().a(put);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // b.c.b.p
    public void callStart(b.c.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f36960b.f36982a = a(System.nanoTime() - this.f36959a);
            this.f36961c = new a(eVar.request().h().toString());
        }
    }

    @Override // b.c.b.p
    public void connectEnd(b.c.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, inetSocketAddress, proxy, protocol) == null) {
            this.f36961c.j.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f36959a)));
        }
    }

    @Override // b.c.b.p
    public void connectFailed(b.c.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, inetSocketAddress, proxy, protocol, iOException) == null) {
            this.f36961c.k.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f36959a)));
            a aVar = this.f36961c;
            if (aVar.f36967e == null) {
                aVar.f36967e = new ArrayList();
            }
            this.f36961c.f36967e.add(String.valueOf(inetSocketAddress));
            if (proxy != null) {
                this.f36961c.f36968f = proxy.toString();
            }
            if (protocol != null) {
                this.f36961c.f36969g = protocol.toString();
            }
        }
    }

    @Override // b.c.b.p
    public void connectStart(b.c.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, eVar, inetSocketAddress, proxy) == null) {
            this.f36961c.f36971i.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f36959a)));
        }
    }

    @Override // b.c.b.p
    public void connectionAcquired(b.c.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, iVar) == null) {
            this.f36960b.f36989h = a(System.nanoTime() - this.f36959a);
            a aVar = this.f36961c;
            aVar.f36963a = iVar.route().a().l().l() + ":" + iVar.route().a().l().w();
            this.f36961c.f36968f = String.valueOf(iVar.route().b());
            this.f36961c.f36966d = String.valueOf(iVar.route().d());
            this.f36961c.f36969g = String.valueOf(iVar.protocol());
        }
    }

    @Override // b.c.b.p
    public void connectionReleased(b.c.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, iVar) == null) {
            this.f36960b.q = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void dnsEnd(b.c.b.e eVar, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, str, list) == null) {
            this.f36960b.f36984c = a(System.nanoTime() - this.f36959a);
            this.f36961c.f36965c = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f36961c.f36965c[i2] = list.get(i2).getHostAddress();
            }
        }
    }

    @Override // b.c.b.p
    public void dnsStart(b.c.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eVar, str) == null) {
            this.f36960b.f36983b = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void requestBodyEnd(b.c.b.e eVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, eVar, j) == null) {
            this.f36960b.l = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void requestBodyStart(b.c.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f36960b.k = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void requestHeadersEnd(b.c.b.e eVar, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, eVar, zVar) == null) {
            this.f36960b.j = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void requestHeadersStart(b.c.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f36960b.f36990i = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void responseBodyEnd(b.c.b.e eVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, eVar, j) == null) {
            this.f36960b.p = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void responseBodyStart(b.c.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f36960b.o = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void responseHeadersEnd(b.c.b.e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, b0Var) == null) {
            this.f36960b.n = a(System.nanoTime() - this.f36959a);
            if (b0Var != null) {
                boolean k = b0Var.k();
                this.f36962d = k;
                if (k) {
                    this.f36961c.f36970h = b0Var.g("Location");
                }
            }
        }
    }

    @Override // b.c.b.p
    public void responseHeadersStart(b.c.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f36960b.m = a(System.nanoTime() - this.f36959a);
        }
    }

    @Override // b.c.b.p
    public void secureConnectEnd(b.c.b.e eVar, q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, eVar, qVar) == null) {
        }
    }

    @Override // b.c.b.p
    public void secureConnectStart(b.c.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
        }
    }

    public b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36959a = j;
        this.f36960b = new d();
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) {
            this.f36960b = new d(this.f36960b.r);
            this.f36961c = new a(str);
        }
    }

    private long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) ? TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) : invokeJ.longValue;
    }
}
