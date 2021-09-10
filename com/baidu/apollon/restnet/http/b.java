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
    public static final p.c f38064e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f38065a;

    /* renamed from: b  reason: collision with root package name */
    public c f38066b;

    /* renamed from: c  reason: collision with root package name */
    public a f38067c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38068d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f38069a;

        /* renamed from: b  reason: collision with root package name */
        public String f38070b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f38071c;

        /* renamed from: d  reason: collision with root package name */
        public String f38072d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f38073e;

        /* renamed from: f  reason: collision with root package name */
        public String f38074f;

        /* renamed from: g  reason: collision with root package name */
        public String f38075g;

        /* renamed from: h  reason: collision with root package name */
        public String f38076h;

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
            this.f38069a = Uri.parse(str).getHost();
            this.f38070b = Uri.parse(str).getPath();
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1615b {

        /* renamed from: a  reason: collision with root package name */
        public static final String f38077a = "plt";

        /* renamed from: b  reason: collision with root package name */
        public static final String f38078b = "dns";

        /* renamed from: c  reason: collision with root package name */
        public static final String f38079c = "pdt";

        /* renamed from: d  reason: collision with root package name */
        public static final String f38080d = "tcp";

        /* renamed from: e  reason: collision with root package name */
        public static final String f38081e = "srt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f38082f = "host";

        /* renamed from: g  reason: collision with root package name */
        public static final String f38083g = "path";

        /* renamed from: h  reason: collision with root package name */
        public static final String f38084h = "proxy";

        /* renamed from: i  reason: collision with root package name */
        public static final String f38085i = "location";

        /* renamed from: j  reason: collision with root package name */
        public static final String f38086j = "protocol";
        public static final String k = "hostAddresses";
        public static final String l = "connectHostAddress";
        public static final String m = "connectFailedHostAddresses";
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f38087a;

        /* renamed from: b  reason: collision with root package name */
        public long f38088b;

        /* renamed from: c  reason: collision with root package name */
        public long f38089c;

        /* renamed from: d  reason: collision with root package name */
        public long f38090d;

        /* renamed from: e  reason: collision with root package name */
        public long f38091e;

        /* renamed from: f  reason: collision with root package name */
        public long f38092f;

        /* renamed from: g  reason: collision with root package name */
        public long f38093g;

        /* renamed from: h  reason: collision with root package name */
        public long f38094h;

        /* renamed from: i  reason: collision with root package name */
        public long f38095i;

        /* renamed from: j  reason: collision with root package name */
        public long f38096j;
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
            this.f38087a = j2;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(InterfaceC1615b.f38077a, this.r - this.f38087a).put(InterfaceC1615b.f38078b, this.f38089c - this.f38088b).put(InterfaceC1615b.f38079c, this.p - this.m).put(InterfaceC1615b.f38080d, this.f38093g - this.f38090d).put(InterfaceC1615b.f38081e, this.m - this.f38095i);
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
        f38064e = new p.c() { // from class: com.baidu.apollon.restnet.http.b.1
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
            this.f38066b = new c(this.f38066b.r);
            this.f38067c = new a(str);
        }
    }

    @Override // c.d.b.p
    public void callEnd(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f38066b.r = a(System.nanoTime() - this.f38065a);
            try {
                JSONObject put = this.f38066b.a().put("host", this.f38067c.f38069a).put("path", this.f38067c.f38070b).put(InterfaceC1615b.l, this.f38067c.f38072d).put("protocol", this.f38067c.f38075g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f38067c.f38074f)) {
                    put.put("proxy", this.f38067c.f38074f);
                }
                if (this.f38067c.f38071c != null) {
                    put.put(InterfaceC1615b.k, Arrays.toString(this.f38067c.f38071c));
                }
                if (!TextUtils.isEmpty(this.f38067c.f38076h)) {
                    put.put("location", this.f38067c.f38076h);
                }
                if (this.f38068d) {
                    a(this.f38067c.f38076h);
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
            this.f38066b.s = a(System.nanoTime() - this.f38065a);
            try {
                JSONObject put = new JSONObject().put("host", this.f38067c.f38069a).put("path", this.f38067c.f38070b).put("protocol", this.f38067c.f38075g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f38067c.f38074f)) {
                    put.put("proxy", this.f38067c.f38074f);
                }
                if (this.f38067c.f38071c != null) {
                    put.put(InterfaceC1615b.k, Arrays.toString(this.f38067c.f38071c));
                }
                if (this.f38067c.f38073e != null) {
                    put.put(InterfaceC1615b.m, this.f38067c.f38073e.toString());
                }
                if (!TextUtils.isEmpty(this.f38067c.f38076h)) {
                    put.put("location", this.f38067c.f38076h);
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
            this.f38066b.f38087a = a(System.nanoTime() - this.f38065a);
            this.f38067c = new a(eVar.request().h().toString());
        }
    }

    @Override // c.d.b.p
    public void connectEnd(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, inetSocketAddress, proxy, protocol) == null) {
            this.f38066b.f38093g = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void connectFailed(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, inetSocketAddress, proxy, protocol, iOException) == null) {
            this.f38066b.t = a(System.nanoTime() - this.f38065a);
            a aVar = this.f38067c;
            if (aVar.f38073e == null) {
                aVar.f38073e = new ArrayList();
            }
            this.f38067c.f38073e.add(String.valueOf(inetSocketAddress));
            if (proxy != null) {
                this.f38067c.f38074f = proxy.toString();
            }
            if (protocol != null) {
                this.f38067c.f38075g = protocol.toString();
            }
        }
    }

    @Override // c.d.b.p
    public void connectStart(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, eVar, inetSocketAddress, proxy) == null) {
            this.f38066b.f38090d = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void connectionAcquired(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, iVar) == null) {
            this.f38066b.f38094h = a(System.nanoTime() - this.f38065a);
            a aVar = this.f38067c;
            aVar.f38069a = iVar.route().a().l().l() + ":" + iVar.route().a().l().w();
            this.f38067c.f38074f = String.valueOf(iVar.route().b());
            this.f38067c.f38072d = String.valueOf(iVar.route().d());
            this.f38067c.f38075g = String.valueOf(iVar.protocol());
        }
    }

    @Override // c.d.b.p
    public void connectionReleased(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, iVar) == null) {
            this.f38066b.q = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void dnsEnd(c.d.b.e eVar, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, str, list) == null) {
            this.f38066b.f38089c = a(System.nanoTime() - this.f38065a);
            this.f38067c.f38071c = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f38067c.f38071c[i2] = list.get(i2).getHostAddress();
            }
        }
    }

    @Override // c.d.b.p
    public void dnsStart(c.d.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eVar, str) == null) {
            this.f38066b.f38088b = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, eVar, j2) == null) {
            this.f38066b.l = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f38066b.k = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersEnd(c.d.b.e eVar, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, eVar, zVar) == null) {
            this.f38066b.f38096j = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f38066b.f38095i = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, eVar, j2) == null) {
            this.f38066b.p = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f38066b.o = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void responseHeadersEnd(c.d.b.e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, b0Var) == null) {
            this.f38066b.n = a(System.nanoTime() - this.f38065a);
            if (b0Var != null) {
                boolean w = b0Var.w();
                this.f38068d = w;
                if (w) {
                    this.f38067c.f38076h = b0Var.s("Location");
                }
            }
        }
    }

    @Override // c.d.b.p
    public void responseHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f38066b.m = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void secureConnectEnd(c.d.b.e eVar, q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, eVar, qVar) == null) {
            this.f38066b.f38092f = a(System.nanoTime() - this.f38065a);
        }
    }

    @Override // c.d.b.p
    public void secureConnectStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.f38066b.f38091e = a(System.nanoTime() - this.f38065a);
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
        this.f38065a = j2;
        this.f38066b = new c();
    }

    private long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) ? TimeUnit.MILLISECONDS.convert(j2, TimeUnit.NANOSECONDS) : invokeJ.longValue;
    }
}
