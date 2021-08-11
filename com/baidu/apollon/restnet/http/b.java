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
    public static final p.c f37839e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f37840a;

    /* renamed from: b  reason: collision with root package name */
    public c f37841b;

    /* renamed from: c  reason: collision with root package name */
    public a f37842c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37843d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f37844a;

        /* renamed from: b  reason: collision with root package name */
        public String f37845b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f37846c;

        /* renamed from: d  reason: collision with root package name */
        public String f37847d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f37848e;

        /* renamed from: f  reason: collision with root package name */
        public String f37849f;

        /* renamed from: g  reason: collision with root package name */
        public String f37850g;

        /* renamed from: h  reason: collision with root package name */
        public String f37851h;

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
            this.f37844a = Uri.parse(str).getHost();
            this.f37845b = Uri.parse(str).getPath();
        }
    }

    /* renamed from: com.baidu.apollon.restnet.http.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1611b {

        /* renamed from: a  reason: collision with root package name */
        public static final String f37852a = "plt";

        /* renamed from: b  reason: collision with root package name */
        public static final String f37853b = "dns";

        /* renamed from: c  reason: collision with root package name */
        public static final String f37854c = "pdt";

        /* renamed from: d  reason: collision with root package name */
        public static final String f37855d = "tcp";

        /* renamed from: e  reason: collision with root package name */
        public static final String f37856e = "srt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f37857f = "host";

        /* renamed from: g  reason: collision with root package name */
        public static final String f37858g = "path";

        /* renamed from: h  reason: collision with root package name */
        public static final String f37859h = "proxy";

        /* renamed from: i  reason: collision with root package name */
        public static final String f37860i = "location";

        /* renamed from: j  reason: collision with root package name */
        public static final String f37861j = "protocol";
        public static final String k = "hostAddresses";
        public static final String l = "connectHostAddress";
        public static final String m = "connectFailedHostAddresses";
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f37862a;

        /* renamed from: b  reason: collision with root package name */
        public long f37863b;

        /* renamed from: c  reason: collision with root package name */
        public long f37864c;

        /* renamed from: d  reason: collision with root package name */
        public long f37865d;

        /* renamed from: e  reason: collision with root package name */
        public long f37866e;

        /* renamed from: f  reason: collision with root package name */
        public long f37867f;

        /* renamed from: g  reason: collision with root package name */
        public long f37868g;

        /* renamed from: h  reason: collision with root package name */
        public long f37869h;

        /* renamed from: i  reason: collision with root package name */
        public long f37870i;

        /* renamed from: j  reason: collision with root package name */
        public long f37871j;
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
            this.f37862a = j2;
        }

        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(InterfaceC1611b.f37852a, this.r - this.f37862a).put(InterfaceC1611b.f37853b, this.f37864c - this.f37863b).put(InterfaceC1611b.f37854c, this.p - this.m).put(InterfaceC1611b.f37855d, this.f37868g - this.f37865d).put(InterfaceC1611b.f37856e, this.m - this.f37870i);
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
        f37839e = new p.c() { // from class: com.baidu.apollon.restnet.http.b.1
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
            this.f37841b = new c(this.f37841b.r);
            this.f37842c = new a(str);
        }
    }

    @Override // c.d.b.p
    public void callEnd(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f37841b.r = a(System.nanoTime() - this.f37840a);
            try {
                JSONObject put = this.f37841b.a().put("host", this.f37842c.f37844a).put("path", this.f37842c.f37845b).put(InterfaceC1611b.l, this.f37842c.f37847d).put("protocol", this.f37842c.f37850g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f37842c.f37849f)) {
                    put.put("proxy", this.f37842c.f37849f);
                }
                if (this.f37842c.f37846c != null) {
                    put.put(InterfaceC1611b.k, Arrays.toString(this.f37842c.f37846c));
                }
                if (!TextUtils.isEmpty(this.f37842c.f37851h)) {
                    put.put("location", this.f37842c.f37851h);
                }
                if (this.f37843d) {
                    a(this.f37842c.f37851h);
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
            this.f37841b.s = a(System.nanoTime() - this.f37840a);
            try {
                JSONObject put = new JSONObject().put("host", this.f37842c.f37844a).put("path", this.f37842c.f37845b).put("protocol", this.f37842c.f37850g);
                if (!Proxy.Type.DIRECT.toString().equals(this.f37842c.f37849f)) {
                    put.put("proxy", this.f37842c.f37849f);
                }
                if (this.f37842c.f37846c != null) {
                    put.put(InterfaceC1611b.k, Arrays.toString(this.f37842c.f37846c));
                }
                if (this.f37842c.f37848e != null) {
                    put.put(InterfaceC1611b.m, this.f37842c.f37848e.toString());
                }
                if (!TextUtils.isEmpty(this.f37842c.f37851h)) {
                    put.put("location", this.f37842c.f37851h);
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
            this.f37841b.f37862a = a(System.nanoTime() - this.f37840a);
            this.f37842c = new a(eVar.request().h().toString());
        }
    }

    @Override // c.d.b.p
    public void connectEnd(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, eVar, inetSocketAddress, proxy, protocol) == null) {
            this.f37841b.f37868g = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void connectFailed(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, eVar, inetSocketAddress, proxy, protocol, iOException) == null) {
            this.f37841b.t = a(System.nanoTime() - this.f37840a);
            a aVar = this.f37842c;
            if (aVar.f37848e == null) {
                aVar.f37848e = new ArrayList();
            }
            this.f37842c.f37848e.add(String.valueOf(inetSocketAddress));
            if (proxy != null) {
                this.f37842c.f37849f = proxy.toString();
            }
            if (protocol != null) {
                this.f37842c.f37850g = protocol.toString();
            }
        }
    }

    @Override // c.d.b.p
    public void connectStart(c.d.b.e eVar, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, eVar, inetSocketAddress, proxy) == null) {
            this.f37841b.f37865d = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void connectionAcquired(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, eVar, iVar) == null) {
            this.f37841b.f37869h = a(System.nanoTime() - this.f37840a);
            a aVar = this.f37842c;
            aVar.f37844a = iVar.route().a().l().l() + ":" + iVar.route().a().l().w();
            this.f37842c.f37849f = String.valueOf(iVar.route().b());
            this.f37842c.f37847d = String.valueOf(iVar.route().d());
            this.f37842c.f37850g = String.valueOf(iVar.protocol());
        }
    }

    @Override // c.d.b.p
    public void connectionReleased(c.d.b.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, eVar, iVar) == null) {
            this.f37841b.q = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void dnsEnd(c.d.b.e eVar, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, str, list) == null) {
            this.f37841b.f37864c = a(System.nanoTime() - this.f37840a);
            this.f37842c.f37846c = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f37842c.f37846c[i2] = list.get(i2).getHostAddress();
            }
        }
    }

    @Override // c.d.b.p
    public void dnsStart(c.d.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, eVar, str) == null) {
            this.f37841b.f37863b = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, eVar, j2) == null) {
            this.f37841b.l = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void requestBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f37841b.k = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersEnd(c.d.b.e eVar, z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, eVar, zVar) == null) {
            this.f37841b.f37871j = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void requestHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f37841b.f37870i = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyEnd(c.d.b.e eVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, eVar, j2) == null) {
            this.f37841b.p = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void responseBodyStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.f37841b.o = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void responseHeadersEnd(c.d.b.e eVar, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, eVar, b0Var) == null) {
            this.f37841b.n = a(System.nanoTime() - this.f37840a);
            if (b0Var != null) {
                boolean w = b0Var.w();
                this.f37843d = w;
                if (w) {
                    this.f37842c.f37851h = b0Var.s("Location");
                }
            }
        }
    }

    @Override // c.d.b.p
    public void responseHeadersStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.f37841b.m = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void secureConnectEnd(c.d.b.e eVar, q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, eVar, qVar) == null) {
            this.f37841b.f37867f = a(System.nanoTime() - this.f37840a);
        }
    }

    @Override // c.d.b.p
    public void secureConnectStart(c.d.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.f37841b.f37866e = a(System.nanoTime() - this.f37840a);
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
        this.f37840a = j2;
        this.f37841b = new c();
    }

    private long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) ? TimeUnit.MILLISECONDS.convert(j2, TimeUnit.NANOSECONDS) : invokeJ.longValue;
    }
}
