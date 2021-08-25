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
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final p.c f37945e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f37946a;

    /* renamed from: b  reason: collision with root package name */
    public c f37947b;

    /* renamed from: c  reason: collision with root package name */
    public a f37948c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37949d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f37950a;

        /* renamed from: b  reason: collision with root package name */
        public String f37951b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f37952c;

        /* renamed from: d  reason: collision with root package name */
        public String f37953d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f37954e;

        /* renamed from: f  reason: collision with root package name */
        public String f37955f;

        /* renamed from: g  reason: collision with root package name */
        public String f37956g;

        /* renamed from: h  reason: collision with root package name */
        public String f37957h;

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
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f37950a = Uri.parse(str).getHost();
            this.f37951b = Uri.parse(str).getPath();
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1615b {

        /* renamed from: a  reason: collision with root package name */
        public static final String f37958a = "plt";

        /* renamed from: b  reason: collision with root package name */
        public static final String f37959b = "dns";

        /* renamed from: c  reason: collision with root package name */
        public static final String f37960c = "pdt";

        /* renamed from: d  reason: collision with root package name */
        public static final String f37961d = "tcp";

        /* renamed from: e  reason: collision with root package name */
        public static final String f37962e = "srt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f37963f = "host";

        /* renamed from: g  reason: collision with root package name */
        public static final String f37964g = "path";

        /* renamed from: h  reason: collision with root package name */
        public static final String f37965h = "proxy";

        /* renamed from: i  reason: collision with root package name */
        public static final String f37966i = "location";

        /* renamed from: j  reason: collision with root package name */
        public static final String f37967j = "protocol";
        public static final String k = "hostAddresses";
        public static final String l = "connectHostAddress";
        public static final String m = "connectFailedHostAddresses";
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f37968a;

        /* renamed from: b  reason: collision with root package name */
        public long f37969b;

        /* renamed from: c  reason: collision with root package name */
        public long f37970c;

        /* renamed from: d  reason: collision with root package name */
        public long f37971d;

        /* renamed from: e  reason: collision with root package name */
        public long f37972e;

        /* renamed from: f  reason: collision with root package name */
        public long f37973f;

        /* renamed from: g  reason: collision with root package name */
        public long f37974g;

        /* renamed from: h  reason: collision with root package name */
        public long f37975h;

        /* renamed from: i  reason: collision with root package name */
        public long f37976i;

        /* renamed from: j  reason: collision with root package name */
        public long f37977j;
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

        public c() {
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

        public c(long j2) {
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
            this.f37968a = j2;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(InterfaceC1615b.f37958a, this.r - this.f37968a).put(InterfaceC1615b.f37959b, this.f37970c - this.f37969b).put(InterfaceC1615b.f37960c, this.p - this.m).put(InterfaceC1615b.f37961d, this.f37974g - this.f37971d).put(InterfaceC1615b.f37962e, this.m - this.f37976i);
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
        f37945e = new p.c() { // from class: com.baidu.apollon.restnet.http.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.d.b.p.c
            public p create(c.d.b.e eVar) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, eVar)) == null) {
                    if (Math.random() < 0.1d) {
                        return new b(System.nanoTime());
                    }
                    return p.NONE;
                }
                return (p) invokeL.objValue;
            }
        };
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            this.f37947b = new c(this.f37947b.r);
            this.f37948c = new a(str);
        }
    }

    @Override // c.d.b.p
    public void callEnd(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f37947b.r = a(System.nanoTime() - this.f37946a);
            try {
                JSONObject put = this.f37947b.a().put("host", this.f37948c.f37950a).put("path", this.f37948c.f37951b).put(InterfaceC1615b.l, this.f37948c.f37953d).put("protocol", this.f37948c.f37956g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f37948c.f37955f)) {
                    put.put("proxy", this.f37948c.f37955f);
                }
                if (this.f37948c.f37952c != null) {
                    put.put(InterfaceC1615b.k, Arrays.toString(this.f37948c.f37952c));
                }
                if (!TextUtils.isEmpty(this.f37948c.f37957h)) {
                    put.put("location", this.f37948c.f37957h);
                }
                if (this.f37949d) {
                    a(this.f37948c.f37957h);
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
            this.f37947b.s = a(System.nanoTime() - this.f37946a);
            try {
                JSONObject put = new JSONObject().put("host", this.f37948c.f37950a).put("path", this.f37948c.f37951b).put("protocol", this.f37948c.f37956g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f37948c.f37955f)) {
                    put.put("proxy", this.f37948c.f37955f);
                }
                if (this.f37948c.f37952c != null) {
                    put.put(InterfaceC1615b.k, Arrays.toString(this.f37948c.f37952c));
                }
                if (this.f37948c.f37954e != null) {
                    put.put(InterfaceC1615b.m, this.f37948c.f37954e.toString());
                }
                if (!TextUtils.isEmpty(this.f37948c.f37957h)) {
                    put.put("location", this.f37948c.f37957h);
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
            this.f37947b.f37968a = a(System.nanoTime() - this.f37946a);
            this.f37948c = new a(eVar.request().h().toString());
        }
    }

    @Override // c.d.b.p
    public void connectEnd(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, inetSocketAddress, proxy, protocol) == null) {
            this.f37947b.f37974g = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void connectFailed(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, inetSocketAddress, proxy, protocol, iOException) == null) {
            this.f37947b.t = a(System.nanoTime() - this.f37946a);
            a aVar = this.f37948c;
            if (aVar.f37954e == null) {
                aVar.f37954e = new ArrayList();
            }
            this.f37948c.f37954e.add(String.valueOf(inetSocketAddress));
            if (proxy != null) {
                this.f37948c.f37955f = proxy.toString();
            }
            if (protocol != null) {
                this.f37948c.f37956g = protocol.toString();
            }
        }
    }

    @Override // c.d.b.p
    public void connectStart(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, eVar, inetSocketAddress, proxy) == null) {
            this.f37947b.f37971d = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void connectionAcquired(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, iVar) == null) {
            this.f37947b.f37975h = a(System.nanoTime() - this.f37946a);
            a aVar = this.f37948c;
            aVar.f37950a = iVar.route().a().l().l() + ":" + iVar.route().a().l().w();
            this.f37948c.f37955f = String.valueOf(iVar.route().b());
            this.f37948c.f37953d = String.valueOf(iVar.route().d());
            this.f37948c.f37956g = String.valueOf(iVar.protocol());
        }
    }

    @Override // c.d.b.p
    public void connectionReleased(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, iVar) == null) {
            this.f37947b.q = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void dnsEnd(c.d.b.e eVar, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, str, list) == null) {
            this.f37947b.f37970c = a(System.nanoTime() - this.f37946a);
            this.f37948c.f37952c = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f37948c.f37952c[i2] = list.get(i2).getHostAddress();
            }
        }
    }

    @Override // c.d.b.p
    public void dnsStart(c.d.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eVar, str) == null) {
            this.f37947b.f37969b = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, eVar, j2) == null) {
            this.f37947b.l = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f37947b.k = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersEnd(c.d.b.e eVar, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, eVar, zVar) == null) {
            this.f37947b.f37977j = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f37947b.f37976i = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, eVar, j2) == null) {
            this.f37947b.p = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f37947b.o = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void responseHeadersEnd(c.d.b.e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, b0Var) == null) {
            this.f37947b.n = a(System.nanoTime() - this.f37946a);
            if (b0Var != null) {
                boolean w = b0Var.w();
                this.f37949d = w;
                if (w) {
                    this.f37948c.f37957h = b0Var.s("Location");
                }
            }
        }
    }

    @Override // c.d.b.p
    public void responseHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f37947b.m = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void secureConnectEnd(c.d.b.e eVar, q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, eVar, qVar) == null) {
            this.f37947b.f37973f = a(System.nanoTime() - this.f37946a);
        }
    }

    @Override // c.d.b.p
    public void secureConnectStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.f37947b.f37972e = a(System.nanoTime() - this.f37946a);
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
        this.f37946a = j2;
        this.f37947b = new c();
    }

    private long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) ? TimeUnit.MILLISECONDS.convert(j2, TimeUnit.NANOSECONDS) : invokeJ.longValue;
    }
}
