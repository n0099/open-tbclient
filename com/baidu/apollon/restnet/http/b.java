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
    public static final C1754b f32567e;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public d f32568b;

    /* renamed from: c  reason: collision with root package name */
    public a f32569c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32570d;

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
        public String f32571b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f32572c;

        /* renamed from: d  reason: collision with root package name */
        public String f32573d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f32574e;

        /* renamed from: f  reason: collision with root package name */
        public String f32575f;

        /* renamed from: g  reason: collision with root package name */
        public String f32576g;

        /* renamed from: h  reason: collision with root package name */
        public String f32577h;

        /* renamed from: i  reason: collision with root package name */
        public Map<String, Long> f32578i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Long> f32579j;
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
            this.f32578i = new HashMap();
            this.f32579j = new HashMap();
            this.k = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.a = Uri.parse(str).getHost();
            this.f32571b = Uri.parse(str).getPath();
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C1754b implements p.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;

        public C1754b() {
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
        public static final String f32580b = "dns";

        /* renamed from: c  reason: collision with root package name */
        public static final String f32581c = "pdt";

        /* renamed from: d  reason: collision with root package name */
        public static final String f32582d = "tcp";

        /* renamed from: e  reason: collision with root package name */
        public static final String f32583e = "srt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f32584f = "host";

        /* renamed from: g  reason: collision with root package name */
        public static final String f32585g = "path";

        /* renamed from: h  reason: collision with root package name */
        public static final String f32586h = "proxy";

        /* renamed from: i  reason: collision with root package name */
        public static final String f32587i = "location";

        /* renamed from: j  reason: collision with root package name */
        public static final String f32588j = "protocol";
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
        public long f32589b;

        /* renamed from: c  reason: collision with root package name */
        public long f32590c;

        /* renamed from: d  reason: collision with root package name */
        public long f32591d;

        /* renamed from: e  reason: collision with root package name */
        public long f32592e;

        /* renamed from: f  reason: collision with root package name */
        public long f32593f;

        /* renamed from: g  reason: collision with root package name */
        public long f32594g;

        /* renamed from: h  reason: collision with root package name */
        public long f32595h;

        /* renamed from: i  reason: collision with root package name */
        public long f32596i;

        /* renamed from: j  reason: collision with root package name */
        public long f32597j;
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
                    jSONObject.put(c.a, this.r - this.a).put(c.f32580b, this.f32590c - this.f32589b).put(c.f32581c, this.p - this.m).put(c.f32583e, this.m - this.f32596i);
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
        f32567e = new C1754b();
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
            for (Map.Entry<String, Long> entry : aVar.f32578i.entrySet()) {
                if (aVar.f32579j.containsKey(entry.getKey())) {
                    longValue = aVar.f32579j.get(entry.getKey()).longValue();
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
            this.f32568b.r = a(System.nanoTime() - this.a);
            try {
                JSONObject put = this.f32568b.a().put("host", this.f32569c.a).put("path", this.f32569c.f32571b).put(c.l, this.f32569c.f32573d).put("protocol", this.f32569c.f32576g).put(c.f32582d, a(this.f32569c));
                if (!Proxy.Type.DIRECT.toString().equals(this.f32569c.f32575f)) {
                    put.put("proxy", this.f32569c.f32575f);
                }
                if (this.f32569c.f32572c != null) {
                    put.put(c.k, Arrays.toString(this.f32569c.f32572c));
                }
                if (!TextUtils.isEmpty(this.f32569c.f32577h)) {
                    put.put("location", this.f32569c.f32577h);
                }
                if (this.f32570d) {
                    a(this.f32569c.f32577h);
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
            this.f32568b.s = a(System.nanoTime() - this.a);
            try {
                JSONObject put = new JSONObject().put("host", this.f32569c.a).put("path", this.f32569c.f32571b).put("protocol", this.f32569c.f32576g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f32569c.f32575f)) {
                    put.put("proxy", this.f32569c.f32575f);
                }
                if (this.f32569c.f32572c != null) {
                    put.put(c.k, Arrays.toString(this.f32569c.f32572c));
                }
                if (this.f32569c.f32574e != null) {
                    put.put(c.m, this.f32569c.f32574e.toString());
                }
                if (!TextUtils.isEmpty(this.f32569c.f32577h)) {
                    put.put("location", this.f32569c.f32577h);
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
            this.f32568b.a = a(System.nanoTime() - this.a);
            this.f32569c = new a(eVar.request().h().toString());
        }
    }

    @Override // c.d.b.p
    public void connectEnd(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, inetSocketAddress, proxy, protocol) == null) {
            this.f32569c.f32579j.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
        }
    }

    @Override // c.d.b.p
    public void connectFailed(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, inetSocketAddress, proxy, protocol, iOException) == null) {
            this.f32569c.k.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
            a aVar = this.f32569c;
            if (aVar.f32574e == null) {
                aVar.f32574e = new ArrayList();
            }
            this.f32569c.f32574e.add(String.valueOf(inetSocketAddress));
            if (proxy != null) {
                this.f32569c.f32575f = proxy.toString();
            }
            if (protocol != null) {
                this.f32569c.f32576g = protocol.toString();
            }
        }
    }

    @Override // c.d.b.p
    public void connectStart(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, eVar, inetSocketAddress, proxy) == null) {
            this.f32569c.f32578i.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.a)));
        }
    }

    @Override // c.d.b.p
    public void connectionAcquired(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, iVar) == null) {
            this.f32568b.f32595h = a(System.nanoTime() - this.a);
            a aVar = this.f32569c;
            aVar.a = iVar.route().a().l().l() + ":" + iVar.route().a().l().w();
            this.f32569c.f32575f = String.valueOf(iVar.route().b());
            this.f32569c.f32573d = String.valueOf(iVar.route().d());
            this.f32569c.f32576g = String.valueOf(iVar.protocol());
        }
    }

    @Override // c.d.b.p
    public void connectionReleased(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, iVar) == null) {
            this.f32568b.q = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void dnsEnd(c.d.b.e eVar, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, str, list) == null) {
            this.f32568b.f32590c = a(System.nanoTime() - this.a);
            this.f32569c.f32572c = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f32569c.f32572c[i2] = list.get(i2).getHostAddress();
            }
        }
    }

    @Override // c.d.b.p
    public void dnsStart(c.d.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eVar, str) == null) {
            this.f32568b.f32589b = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, eVar, j2) == null) {
            this.f32568b.l = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f32568b.k = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersEnd(c.d.b.e eVar, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, eVar, zVar) == null) {
            this.f32568b.f32597j = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f32568b.f32596i = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, eVar, j2) == null) {
            this.f32568b.p = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f32568b.o = a(System.nanoTime() - this.a);
        }
    }

    @Override // c.d.b.p
    public void responseHeadersEnd(c.d.b.e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, b0Var) == null) {
            this.f32568b.n = a(System.nanoTime() - this.a);
            if (b0Var != null) {
                boolean k = b0Var.k();
                this.f32570d = k;
                if (k) {
                    this.f32569c.f32577h = b0Var.g("Location");
                }
            }
        }
    }

    @Override // c.d.b.p
    public void responseHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f32568b.m = a(System.nanoTime() - this.a);
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
        this.f32568b = new d();
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            this.f32568b = new d(this.f32568b.r);
            this.f32569c = new a(str);
        }
    }

    private long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) ? TimeUnit.MILLISECONDS.convert(j2, TimeUnit.NANOSECONDS) : invokeJ.longValue;
    }
}
