package com.baidu.apollon.restnet.http;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.d.b.b0;
import b.d.b.i;
import b.d.b.p;
import b.d.b.q;
import b.d.b.z;
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
    public static final C1578b f36129e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f36130a;

    /* renamed from: b  reason: collision with root package name */
    public d f36131b;

    /* renamed from: c  reason: collision with root package name */
    public a f36132c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36133d;

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
        public String f36134a;

        /* renamed from: b  reason: collision with root package name */
        public String f36135b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f36136c;

        /* renamed from: d  reason: collision with root package name */
        public String f36137d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f36138e;

        /* renamed from: f  reason: collision with root package name */
        public String f36139f;

        /* renamed from: g  reason: collision with root package name */
        public String f36140g;

        /* renamed from: h  reason: collision with root package name */
        public String f36141h;

        /* renamed from: i  reason: collision with root package name */
        public Map<String, Long> f36142i;
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
            this.f36142i = new HashMap();
            this.j = new HashMap();
            this.k = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f36134a = Uri.parse(str).getHost();
            this.f36135b = Uri.parse(str).getPath();
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1578b implements p.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f36143a;

        public C1578b() {
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
            this.f36143a = 0.1d;
        }

        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) || d2 > 1.0d) {
                return;
            }
            this.f36143a = d2;
        }

        @Override // b.d.b.p.c
        public p create(b.d.b.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                if (Math.random() < this.f36143a) {
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
        public static final String f36144a = "plt";

        /* renamed from: b  reason: collision with root package name */
        public static final String f36145b = "dns";

        /* renamed from: c  reason: collision with root package name */
        public static final String f36146c = "pdt";

        /* renamed from: d  reason: collision with root package name */
        public static final String f36147d = "tcp";

        /* renamed from: e  reason: collision with root package name */
        public static final String f36148e = "srt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f36149f = "host";

        /* renamed from: g  reason: collision with root package name */
        public static final String f36150g = "path";

        /* renamed from: h  reason: collision with root package name */
        public static final String f36151h = "proxy";

        /* renamed from: i  reason: collision with root package name */
        public static final String f36152i = "location";
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
        public long f36153a;

        /* renamed from: b  reason: collision with root package name */
        public long f36154b;

        /* renamed from: c  reason: collision with root package name */
        public long f36155c;

        /* renamed from: d  reason: collision with root package name */
        public long f36156d;

        /* renamed from: e  reason: collision with root package name */
        public long f36157e;

        /* renamed from: f  reason: collision with root package name */
        public long f36158f;

        /* renamed from: g  reason: collision with root package name */
        public long f36159g;

        /* renamed from: h  reason: collision with root package name */
        public long f36160h;

        /* renamed from: i  reason: collision with root package name */
        public long f36161i;
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
            this.f36153a = j;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(c.f36144a, this.r - this.f36153a).put(c.f36145b, this.f36155c - this.f36154b).put(c.f36146c, this.p - this.m).put(c.f36148e, this.m - this.f36161i);
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
        f36129e = new C1578b();
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
            for (Map.Entry<String, Long> entry : aVar.f36142i.entrySet()) {
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

    @Override // b.d.b.p
    public void callEnd(b.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f36131b.r = a(System.nanoTime() - this.f36130a);
            try {
                JSONObject put = this.f36131b.a().put("host", this.f36132c.f36134a).put("path", this.f36132c.f36135b).put(c.l, this.f36132c.f36137d).put("protocol", this.f36132c.f36140g).put(c.f36147d, a(this.f36132c));
                if (!Proxy.Type.DIRECT.toString().equals(this.f36132c.f36139f)) {
                    put.put("proxy", this.f36132c.f36139f);
                }
                if (this.f36132c.f36136c != null) {
                    put.put(c.k, Arrays.toString(this.f36132c.f36136c));
                }
                if (!TextUtils.isEmpty(this.f36132c.f36141h)) {
                    put.put("location", this.f36132c.f36141h);
                }
                if (this.f36133d) {
                    a(this.f36132c.f36141h);
                }
                com.baidu.apollon.restnet.a.a().a(put);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // b.d.b.p
    public void callFailed(b.d.b.e eVar, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, iOException) == null) {
            this.f36131b.s = a(System.nanoTime() - this.f36130a);
            try {
                JSONObject put = new JSONObject().put("host", this.f36132c.f36134a).put("path", this.f36132c.f36135b).put("protocol", this.f36132c.f36140g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f36132c.f36139f)) {
                    put.put("proxy", this.f36132c.f36139f);
                }
                if (this.f36132c.f36136c != null) {
                    put.put(c.k, Arrays.toString(this.f36132c.f36136c));
                }
                if (this.f36132c.f36138e != null) {
                    put.put(c.m, this.f36132c.f36138e.toString());
                }
                if (!TextUtils.isEmpty(this.f36132c.f36141h)) {
                    put.put("location", this.f36132c.f36141h);
                }
                com.baidu.apollon.restnet.a.a().a(put);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // b.d.b.p
    public void callStart(b.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f36131b.f36153a = a(System.nanoTime() - this.f36130a);
            this.f36132c = new a(eVar.request().h().toString());
        }
    }

    @Override // b.d.b.p
    public void connectEnd(b.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, inetSocketAddress, proxy, protocol) == null) {
            this.f36132c.j.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f36130a)));
        }
    }

    @Override // b.d.b.p
    public void connectFailed(b.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, inetSocketAddress, proxy, protocol, iOException) == null) {
            this.f36132c.k.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f36130a)));
            a aVar = this.f36132c;
            if (aVar.f36138e == null) {
                aVar.f36138e = new ArrayList();
            }
            this.f36132c.f36138e.add(String.valueOf(inetSocketAddress));
            if (proxy != null) {
                this.f36132c.f36139f = proxy.toString();
            }
            if (protocol != null) {
                this.f36132c.f36140g = protocol.toString();
            }
        }
    }

    @Override // b.d.b.p
    public void connectStart(b.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, eVar, inetSocketAddress, proxy) == null) {
            this.f36132c.f36142i.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f36130a)));
        }
    }

    @Override // b.d.b.p
    public void connectionAcquired(b.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, iVar) == null) {
            this.f36131b.f36160h = a(System.nanoTime() - this.f36130a);
            a aVar = this.f36132c;
            aVar.f36134a = iVar.route().a().l().l() + ":" + iVar.route().a().l().w();
            this.f36132c.f36139f = String.valueOf(iVar.route().b());
            this.f36132c.f36137d = String.valueOf(iVar.route().d());
            this.f36132c.f36140g = String.valueOf(iVar.protocol());
        }
    }

    @Override // b.d.b.p
    public void connectionReleased(b.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, iVar) == null) {
            this.f36131b.q = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void dnsEnd(b.d.b.e eVar, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, str, list) == null) {
            this.f36131b.f36155c = a(System.nanoTime() - this.f36130a);
            this.f36132c.f36136c = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f36132c.f36136c[i2] = list.get(i2).getHostAddress();
            }
        }
    }

    @Override // b.d.b.p
    public void dnsStart(b.d.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eVar, str) == null) {
            this.f36131b.f36154b = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void requestBodyEnd(b.d.b.e eVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, eVar, j) == null) {
            this.f36131b.l = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void requestBodyStart(b.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f36131b.k = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void requestHeadersEnd(b.d.b.e eVar, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, eVar, zVar) == null) {
            this.f36131b.j = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void requestHeadersStart(b.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f36131b.f36161i = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void responseBodyEnd(b.d.b.e eVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, eVar, j) == null) {
            this.f36131b.p = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void responseBodyStart(b.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f36131b.o = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void responseHeadersEnd(b.d.b.e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, b0Var) == null) {
            this.f36131b.n = a(System.nanoTime() - this.f36130a);
            if (b0Var != null) {
                boolean k = b0Var.k();
                this.f36133d = k;
                if (k) {
                    this.f36132c.f36141h = b0Var.g("Location");
                }
            }
        }
    }

    @Override // b.d.b.p
    public void responseHeadersStart(b.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f36131b.m = a(System.nanoTime() - this.f36130a);
        }
    }

    @Override // b.d.b.p
    public void secureConnectEnd(b.d.b.e eVar, q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, eVar, qVar) == null) {
        }
    }

    @Override // b.d.b.p
    public void secureConnectStart(b.d.b.e eVar) {
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
        this.f36130a = j;
        this.f36131b = new d();
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) {
            this.f36131b = new d(this.f36131b.r);
            this.f36132c = new a(str);
        }
    }

    private long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) ? TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) : invokeJ.longValue;
    }
}
