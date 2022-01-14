package c.a.r0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.l0.k;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5617f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f5618g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.h0.k.f a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5619b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5620c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5621d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5622e;

    /* loaded from: classes.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.f1.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.l.a f5623b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5624c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5625d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5626e;

        public a(f fVar, c.a.r0.a.f1.e.b bVar, c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, aVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5626e = fVar;
            this.a = bVar;
            this.f5623b = aVar;
            this.f5624c = bVar2;
            this.f5625d = gVar;
        }

        @Override // c.a.r0.a.l0.k
        public void a(c.a.r0.a.l0.a aVar) {
            c.a.r0.a.o0.d.c j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5626e.f5621d = true;
                c.a.r0.a.e0.f.d.d.e().f("loaddebug");
                c.a.r0.a.e0.d.k("LocalDebugger", "prepareDaemon finish.");
                this.f5626e.t(this.f5626e.j(this.a));
                if (f.f5617f) {
                    String str = "debugInitMsg - " + j2.s().toString();
                }
                this.f5626e.n(this.f5623b, this.f5624c, this.a, this.f5625d);
                this.f5626e.p(this.f5623b, this.f5624c, this.a, this.f5625d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5627b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f5628c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5629d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5630e;

        public b(f fVar, c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b bVar, c.a.r0.a.f1.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5630e = fVar;
            this.a = aVar;
            this.f5627b = bVar;
            this.f5628c = bVar2;
            this.f5629d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5617f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f5630e.f5619b = true;
                this.f5630e.u(this.a, this.f5627b, this.f5628c, this.f5629d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.l.a f5631e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5632f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5633g;

        public c(f fVar, c.a.r0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5631e = aVar;
            this.f5632f = str;
            this.f5633g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5631e.g().evaluateJavascript(this.f5632f, this.f5633g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f5617f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5635f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5636g;

        public e(f fVar, c.a.r0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5634e = bVar;
            this.f5635f = str;
            this.f5636g = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [c.a.r0.a.p.e.c] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5634e.t().evaluateJavascript(this.f5635f, this.f5636g);
            }
        }
    }

    /* renamed from: c.a.r0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0299f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5637b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f5638c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5639d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5640e;

        public C0299f(f fVar, c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b bVar, c.a.r0.a.f1.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5640e = fVar;
            this.a = aVar;
            this.f5637b = bVar;
            this.f5638c = bVar2;
            this.f5639d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5617f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f5640e.f5620c = true;
                this.f5640e.u(this.a, this.f5637b, this.f5638c, this.f5639d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.l.a f5641e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5642f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f5643g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.g f5644h;

        public g(f fVar, c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b bVar, c.a.r0.a.f1.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5641e = aVar;
            this.f5642f = bVar;
            this.f5643g = bVar2;
            this.f5644h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.f2.f.o0.c.a(this.f5641e, this.f5642f, this.f5643g, this.f5644h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(891458164, "Lc/a/r0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(891458164, "Lc/a/r0/a/e0/f/d/f;");
                return;
            }
        }
        f5617f = c.a.r0.a.k.a;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5619b = false;
        this.f5620c = false;
        this.f5621d = false;
        this.f5622e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f5618g == null) {
                synchronized (f.class) {
                    if (f5618g == null) {
                        f5618g = new f();
                    }
                }
            }
            return f5618g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.r0.a.o0.d.c j(@NonNull c.a.r0.a.f1.e.b<b.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", bVar.X());
                jSONObject.put("wsServerPort", bVar.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new c.a.r0.a.o0.d.c("message", hashMap);
        }
        return (c.a.r0.a.o0.d.c) invokeL.objValue;
    }

    public c.a.r0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.r0.a.h0.k.f fVar = this.a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (c.a.r0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5622e : invokeV.booleanValue;
    }

    public final void n(c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b<?> bVar, c.a.r0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.a0(new c(this, aVar, c.a.r0.w.d.E(new File(c.a.r0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.r0.a.e0.d.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.r0.a.p.e.b<?> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String E = c.a.r0.w.d.E(new File(c.a.r0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.a0(new e(this, bVar, E, valueCallback));
                return;
            }
            c.a.r0.a.e0.d.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b<?> bVar, c.a.r0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0299f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b<?> bVar, c.a.r0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.r0.a.h0.u.g.U().q0()) {
            c.a.r0.a.e0.d.k("LocalDebugger", "prepareDaemon start.");
            if (this.f5622e && this.f5621d && this.a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.r0.a.h0.k.f d2 = c.a.r0.a.h0.u.g.U().f0().d();
            this.a = d2;
            d2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.a.e0.d.k("LocalDebugger", "releaseLocalDebugger");
            c.a.r0.a.h0.k.f fVar = this.a;
            if (fVar != null) {
                fVar.b();
                this.a = null;
            }
            f5618g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.a.e0.d.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f5622e = true;
            this.f5619b = false;
            this.f5620c = false;
        }
    }

    public final void t(c.a.r0.a.o0.d.b bVar) {
        c.a.r0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || (fVar = this.a) == null) {
            return;
        }
        c.a.r0.a.o0.a.a(fVar.a(), bVar);
    }

    public final synchronized void u(c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b<?> bVar, c.a.r0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f5619b && this.f5620c) {
                    c.a.r0.a.e0.d.k("LocalDebugger", "startFirstPage");
                    q0.a0(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
