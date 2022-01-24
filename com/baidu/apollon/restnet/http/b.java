package com.baidu.apollon.restnet.http;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.d.b.b0;
import c.d.b.i;
import c.d.b.p;
import c.d.b.q;
import c.d.b.z;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes10.dex */
public class b extends p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final C1755b f32595e;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public d f32596b;

    /* renamed from: c  reason: collision with root package name */
    public a f32597c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32598d;

    /* renamed from: com.baidu.apollon.restnet.http.b$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f32599b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f32600c;

        /* renamed from: d  reason: collision with root package name */
        public String f32601d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f32602e;

        /* renamed from: f  reason: collision with root package name */
        public String f32603f;

        /* renamed from: g  reason: collision with root package name */
        public String f32604g;

        /* renamed from: h  reason: collision with root package name */
        public String f32605h;

        /* renamed from: i  reason: collision with root package name */
        public Map<String, Long> f32606i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Long> f32607j;
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
            this.f32606i = new HashMap();
            this.f32607j = new HashMap();
            this.k = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.a = Uri.parse(str).getHost();
            this.f32599b = Uri.parse(str).getPath();
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C1755b implements p.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;

        public C1755b() {
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
            this.a = 0.1d;
        }

        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) || d2 > 1.0d) {
                return;
            }
            this.a = d2;
        }

        @Override // c.d.b.p.c
        public p create(c.d.b.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                if (Math.random() < this.a) {
                    return new b(System.nanoTime(), null);
                }
                return p.NONE;
            }
            return (p) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        public static final String a = "plt";

        /* renamed from: b  reason: collision with root package name */
        public static final String f32608b = "dns";

        /* renamed from: c  reason: collision with root package name */
        public static final String f32609c = "pdt";

        /* renamed from: d  reason: collision with root package name */
        public static final String f32610d = "tcp";

        /* renamed from: e  reason: collision with root package name */
        public static final String f32611e = "srt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f32612f = "host";

        /* renamed from: g  reason: collision with root package name */
        public static final String f32613g = "path";

        /* renamed from: h  reason: collision with root package name */
        public static final String f32614h = "proxy";

        /* renamed from: i  reason: collision with root package name */
        public static final String f32615i = "location";

        /* renamed from: j  reason: collision with root package name */
        public static final String f32616j = "protocol";
        public static final String k = "hostAddresses";
        public static final String l = "connectHostAddress";
        public static final String m = "connectFailedHostAddresses";
    }

    /* loaded from: classes10.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f32617b;

        /* renamed from: c  reason: collision with root package name */
        public long f32618c;

        /* renamed from: d  reason: collision with root package name */
        public long f32619d;

        /* renamed from: e  reason: collision with root package name */
        public long f32620e;

        /* renamed from: f  reason: collision with root package name */
        public long f32621f;

        /* renamed from: g  reason: collision with root package name */
        public long f32622g;

        /* renamed from: h  reason: collision with root package name */
        public long f32623h;

        /* renamed from: i  reason: collision with root package name */
        public long f32624i;

        /* renamed from: j  reason: collision with root package name */
        public long f32625j;
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

        public d(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = j2;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(c.a, this.r - this.a).put(c.f32608b, this.f32618c - this.f32617b).put(c.f32609c, this.p - this.m).put(c.f32611e, this.m - this.f32624i);
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
        f32595e = new C1755b();
    }

    public /* synthetic */ b(long j2, AnonymousClass1 anonymousClass1) {
        this(j2);
    }

    private long a(a aVar) {
        InterceptResult invokeL;
        long longValue;
        long longValue2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar)) == null) {
            long j2 = 0;
            if (aVar == null) {
                return 0L;
            }
            for (Map.Entry<String, Long> entry : aVar.f32606i.entrySet()) {
                if (aVar.f32607j.containsKey(entry.getKey())) {
                    longValue = aVar.f32607j.get(entry.getKey()).longValue();
                    longValue2 = entry.getValue().longValue();
                } else if (aVar.k.containsKey(entry.getKey())) {
                    longValue = aVar.k.get(entry.getKey()).longValue();
                    longValue2 = entry.getValue().longValue();
                }
                j2 += longValue - longValue2;
            }
            return j2;
        }
        return invokeL.longValue;
    }

    @Override // c.d.b.p
    public void callEnd(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f32596b.r = a(System.nanoTime() - this.a);
            try {
                JSONObject put = this.f32596b.a().put("host", this.f32597c.a).put("path", this.f32597c.f32599b).put(c.l, this.f32597c.f32601d).put("protocol", this.f32597c.f32604g).put(c.f32610d, a(this.f32597c));
                if (!Proxy.Type.DIRECT.toString().equals(this.f32597c.f32603f)) {
                    put.put("proxy", this.f32597c.f32603f);
                }
                if (this.f32597c.f32600c != null) {
                    put.put(c.k, Arrays.toString(this.f32597c.f32600c));
                }
                if (!TextUtils.isEmpty(this.f32597c.f32605h)) {
                    put.put("location", this.f32597c.f32605h);
                }
                if (this.f32598d) {
                    a(this.f32597c.f32605h);
                }
                com.baidu.apollon.restnet.a.a().a(put);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // c.d.b.p
    public void callFailed(c.d.b.e eVar, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, iOException) == null) {
            this.f32596b.s = a(System.nanoTime() - this.a);
            try {
                JSONObject put = new JSONObject().put("host", this.f32597c.a).put("path", this.f32597c.f32599b).put("protocol", this.f32597c.f32604g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f32597c.f32603f)) {
                    put.put("proxy", this.f32597c.f32603f);
                }
                if (this.f32597c.f32600c != null) {
                    put.put(c.k, Arrays.toString(this.f32597c.f32600c));
                }
                if (this.f32597c.f32602e != null) {
                    put.put(c.m, this.f32597c.f32602e.toString());
                }
                if (!TextUtils.isEmpty(this.f32597c.f32605h)) {
                    put.put("location", this.f32597c.f32605h);
                }
                com.baidu.apollon.restnet.a.a().a(put);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // c.d.b.p
    public void callStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f32596b.a = a(System.nanoTime() - this.a);
            this.f32597c = new a(eVar.request().h().toString());
        }
    }

    @Override // c.d.b.p
    public void connectEnd(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, inetSocketAddress, proxy, protocol) == null) {
            this.f32597c.f32607j.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
        }
    }

    @Override // c.d.b.p
    public void connectFailed(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, inetSocketAddress, proxy, protocol, iOException) == null) {
            this.f32597c.k.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
            a aVar = this.f32597c;
            if (aVar.f32602e == null) {
                aVar.f32602e = new ArrayList();
            }
            this.f32597c.f32602e.add(String.valueOf(inetSocketAddress));
            if (proxy != null) {
                this.f32597c.f32603f = proxy.toString();
            }
            if (protocol != null) {
                this.f32597c.f32604g = protocol.toString();
            }
        }
    }

    @Override // c.d.b.p
    public void connectStart(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, eVar, inetSocketAddress, proxy) == null) {
            this.f32597c.f32606i.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
        }
    }

    @Override // c.d.b.p
    public void connectionAcquired(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, iVar) == null) {
            this.f32596b.f32623h = a(System.nanoTime() - this.a);
            a aVar = this.f32597c;
            aVar.a = iVar.route().a().l().l() + ":" + iVar.route().a().l().w();
            this.f32597c.f32603f = String.valueOf(iVar.route().b());
            this.f32597c.f32601d = String.valueOf(iVar.route().d());
            this.f32597c.f32604g = String.valueOf(iVar.protocol());
        }
    }

    @Override // c.d.b.p
    public void connectionReleased(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, iVar) == null) {
            this.f32596b.q = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void dnsEnd(c.d.b.e eVar, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, str, list) == null) {
            this.f32596b.f32618c = a(System.nanoTime() - this.a);
            this.f32597c.f32600c = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f32597c.f32600c[i2] = list.get(i2).getHostAddress();
            }
        }
    }

    @Override // c.d.b.p
    public void dnsStart(c.d.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eVar, str) == null) {
            this.f32596b.f32617b = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, eVar, j2) == null) {
            this.f32596b.l = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f32596b.k = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersEnd(c.d.b.e eVar, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, eVar, zVar) == null) {
            this.f32596b.f32625j = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f32596b.f32624i = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, eVar, j2) == null) {
            this.f32596b.p = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f32596b.o = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void responseHeadersEnd(c.d.b.e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, b0Var) == null) {
            this.f32596b.n = a(System.nanoTime() - this.a);
            if (b0Var != null) {
                boolean k = b0Var.k();
                this.f32598d = k;
                if (k) {
                    this.f32597c.f32605h = b0Var.g("Location");
                }
            }
        }
    }

    @Override // c.d.b.p
    public void responseHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f32596b.m = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void secureConnectEnd(c.d.b.e eVar, q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, eVar, qVar) == null) {
        }
    }

    @Override // c.d.b.p
    public void secureConnectStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
        }
    }

    public b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j2;
        this.f32596b = new d();
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            this.f32596b = new d(this.f32596b.r);
            this.f32597c = new a(str);
        }
    }

    private long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) ? TimeUnit.MILLISECONDS.convert(j2, TimeUnit.NANOSECONDS) : invokeJ.longValue;
    }
}
