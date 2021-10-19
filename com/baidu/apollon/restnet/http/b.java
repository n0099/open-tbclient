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
/* loaded from: classes5.dex */
public class b extends p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final C1621b f38116e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f38117a;

    /* renamed from: b  reason: collision with root package name */
    public d f38118b;

    /* renamed from: c  reason: collision with root package name */
    public a f38119c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38120d;

    /* renamed from: com.baidu.apollon.restnet.http.b$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f38121a;

        /* renamed from: b  reason: collision with root package name */
        public String f38122b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f38123c;

        /* renamed from: d  reason: collision with root package name */
        public String f38124d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f38125e;

        /* renamed from: f  reason: collision with root package name */
        public String f38126f;

        /* renamed from: g  reason: collision with root package name */
        public String f38127g;

        /* renamed from: h  reason: collision with root package name */
        public String f38128h;

        /* renamed from: i  reason: collision with root package name */
        public Map<String, Long> f38129i;

        /* renamed from: j  reason: collision with root package name */
        public Map<String, Long> f38130j;
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
            this.f38129i = new HashMap();
            this.f38130j = new HashMap();
            this.k = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f38121a = Uri.parse(str).getHost();
            this.f38122b = Uri.parse(str).getPath();
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1621b implements p.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f38131a;

        public C1621b() {
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
            this.f38131a = 0.1d;
        }

        public void a(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)}) == null) || d2 > 1.0d) {
                return;
            }
            this.f38131a = d2;
        }

        @Override // c.d.b.p.c
        public p create(c.d.b.e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                if (Math.random() < this.f38131a) {
                    return new b(System.nanoTime(), null);
                }
                return p.NONE;
            }
            return (p) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final String f38132a = "plt";

        /* renamed from: b  reason: collision with root package name */
        public static final String f38133b = "dns";

        /* renamed from: c  reason: collision with root package name */
        public static final String f38134c = "pdt";

        /* renamed from: d  reason: collision with root package name */
        public static final String f38135d = "tcp";

        /* renamed from: e  reason: collision with root package name */
        public static final String f38136e = "srt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f38137f = "host";

        /* renamed from: g  reason: collision with root package name */
        public static final String f38138g = "path";

        /* renamed from: h  reason: collision with root package name */
        public static final String f38139h = "proxy";

        /* renamed from: i  reason: collision with root package name */
        public static final String f38140i = "location";

        /* renamed from: j  reason: collision with root package name */
        public static final String f38141j = "protocol";
        public static final String k = "hostAddresses";
        public static final String l = "connectHostAddress";
        public static final String m = "connectFailedHostAddresses";
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f38142a;

        /* renamed from: b  reason: collision with root package name */
        public long f38143b;

        /* renamed from: c  reason: collision with root package name */
        public long f38144c;

        /* renamed from: d  reason: collision with root package name */
        public long f38145d;

        /* renamed from: e  reason: collision with root package name */
        public long f38146e;

        /* renamed from: f  reason: collision with root package name */
        public long f38147f;

        /* renamed from: g  reason: collision with root package name */
        public long f38148g;

        /* renamed from: h  reason: collision with root package name */
        public long f38149h;

        /* renamed from: i  reason: collision with root package name */
        public long f38150i;

        /* renamed from: j  reason: collision with root package name */
        public long f38151j;
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
            this.f38142a = j2;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(c.f38132a, this.r - this.f38142a).put(c.f38133b, this.f38144c - this.f38143b).put(c.f38134c, this.p - this.m).put(c.f38136e, this.m - this.f38150i);
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
        f38116e = new C1621b();
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
            for (Map.Entry<String, Long> entry : aVar.f38129i.entrySet()) {
                if (aVar.f38130j.containsKey(entry.getKey())) {
                    longValue = aVar.f38130j.get(entry.getKey()).longValue();
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
            this.f38118b.r = a(System.nanoTime() - this.f38117a);
            try {
                JSONObject put = this.f38118b.a().put("host", this.f38119c.f38121a).put("path", this.f38119c.f38122b).put(c.l, this.f38119c.f38124d).put("protocol", this.f38119c.f38127g).put(c.f38135d, a(this.f38119c));
                if (!Proxy.Type.DIRECT.toString().equals(this.f38119c.f38126f)) {
                    put.put("proxy", this.f38119c.f38126f);
                }
                if (this.f38119c.f38123c != null) {
                    put.put(c.k, Arrays.toString(this.f38119c.f38123c));
                }
                if (!TextUtils.isEmpty(this.f38119c.f38128h)) {
                    put.put("location", this.f38119c.f38128h);
                }
                if (this.f38120d) {
                    a(this.f38119c.f38128h);
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
            this.f38118b.s = a(System.nanoTime() - this.f38117a);
            try {
                JSONObject put = new JSONObject().put("host", this.f38119c.f38121a).put("path", this.f38119c.f38122b).put("protocol", this.f38119c.f38127g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f38119c.f38126f)) {
                    put.put("proxy", this.f38119c.f38126f);
                }
                if (this.f38119c.f38123c != null) {
                    put.put(c.k, Arrays.toString(this.f38119c.f38123c));
                }
                if (this.f38119c.f38125e != null) {
                    put.put(c.m, this.f38119c.f38125e.toString());
                }
                if (!TextUtils.isEmpty(this.f38119c.f38128h)) {
                    put.put("location", this.f38119c.f38128h);
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
            this.f38118b.f38142a = a(System.nanoTime() - this.f38117a);
            this.f38119c = new a(eVar.request().h().toString());
        }
    }

    @Override // c.d.b.p
    public void connectEnd(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, inetSocketAddress, proxy, protocol) == null) {
            this.f38119c.f38130j.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f38117a)));
        }
    }

    @Override // c.d.b.p
    public void connectFailed(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, inetSocketAddress, proxy, protocol, iOException) == null) {
            this.f38119c.k.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f38117a)));
            a aVar = this.f38119c;
            if (aVar.f38125e == null) {
                aVar.f38125e = new ArrayList();
            }
            this.f38119c.f38125e.add(String.valueOf(inetSocketAddress));
            if (proxy != null) {
                this.f38119c.f38126f = proxy.toString();
            }
            if (protocol != null) {
                this.f38119c.f38127g = protocol.toString();
            }
        }
    }

    @Override // c.d.b.p
    public void connectStart(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, eVar, inetSocketAddress, proxy) == null) {
            this.f38119c.f38129i.put(String.valueOf(inetSocketAddress.getAddress()), Long.valueOf(a(System.nanoTime() - this.f38117a)));
        }
    }

    @Override // c.d.b.p
    public void connectionAcquired(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, iVar) == null) {
            this.f38118b.f38149h = a(System.nanoTime() - this.f38117a);
            a aVar = this.f38119c;
            aVar.f38121a = iVar.route().a().l().l() + ":" + iVar.route().a().l().w();
            this.f38119c.f38126f = String.valueOf(iVar.route().b());
            this.f38119c.f38124d = String.valueOf(iVar.route().d());
            this.f38119c.f38127g = String.valueOf(iVar.protocol());
        }
    }

    @Override // c.d.b.p
    public void connectionReleased(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, iVar) == null) {
            this.f38118b.q = a(System.nanoTime() - this.f38117a);
        }
    }

    @Override // c.d.b.p
    public void dnsEnd(c.d.b.e eVar, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, str, list) == null) {
            this.f38118b.f38144c = a(System.nanoTime() - this.f38117a);
            this.f38119c.f38123c = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f38119c.f38123c[i2] = list.get(i2).getHostAddress();
            }
        }
    }

    @Override // c.d.b.p
    public void dnsStart(c.d.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eVar, str) == null) {
            this.f38118b.f38143b = a(System.nanoTime() - this.f38117a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, eVar, j2) == null) {
            this.f38118b.l = a(System.nanoTime() - this.f38117a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f38118b.k = a(System.nanoTime() - this.f38117a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersEnd(c.d.b.e eVar, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, eVar, zVar) == null) {
            this.f38118b.f38151j = a(System.nanoTime() - this.f38117a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f38118b.f38150i = a(System.nanoTime() - this.f38117a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, eVar, j2) == null) {
            this.f38118b.p = a(System.nanoTime() - this.f38117a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f38118b.o = a(System.nanoTime() - this.f38117a);
        }
    }

    @Override // c.d.b.p
    public void responseHeadersEnd(c.d.b.e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, b0Var) == null) {
            this.f38118b.n = a(System.nanoTime() - this.f38117a);
            if (b0Var != null) {
                boolean w = b0Var.w();
                this.f38120d = w;
                if (w) {
                    this.f38119c.f38128h = b0Var.s("Location");
                }
            }
        }
    }

    @Override // c.d.b.p
    public void responseHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f38118b.m = a(System.nanoTime() - this.f38117a);
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
        this.f38117a = j2;
        this.f38118b = new d();
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) {
            this.f38118b = new d(this.f38118b.r);
            this.f38119c = new a(str);
        }
    }

    private long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) ? TimeUnit.MILLISECONDS.convert(j2, TimeUnit.NANOSECONDS) : invokeJ.longValue;
    }
}
