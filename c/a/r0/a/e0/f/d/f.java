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
    public static final boolean f5743f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f5744g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.a.h0.k.f a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5745b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5746c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5747d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5748e;

    /* loaded from: classes.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.f1.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.l.a f5749b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5750c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5751d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5752e;

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
            this.f5752e = fVar;
            this.a = bVar;
            this.f5749b = aVar;
            this.f5750c = bVar2;
            this.f5751d = gVar;
        }

        @Override // c.a.r0.a.l0.k
        public void a(c.a.r0.a.l0.a aVar) {
            c.a.r0.a.o0.d.c j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5752e.f5747d = true;
                c.a.r0.a.e0.f.d.d.e().f("loaddebug");
                c.a.r0.a.e0.d.k("LocalDebugger", "prepareDaemon finish.");
                this.f5752e.t(this.f5752e.j(this.a));
                if (f.f5743f) {
                    String str = "debugInitMsg - " + j2.s().toString();
                }
                this.f5752e.n(this.f5749b, this.f5750c, this.a, this.f5751d);
                this.f5752e.p(this.f5749b, this.f5750c, this.a, this.f5751d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5753b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f5754c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5755d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5756e;

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
            this.f5756e = fVar;
            this.a = aVar;
            this.f5753b = bVar;
            this.f5754c = bVar2;
            this.f5755d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5743f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f5756e.f5745b = true;
                this.f5756e.u(this.a, this.f5753b, this.f5754c, this.f5755d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.l.a f5757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5758f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5759g;

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
            this.f5757e = aVar;
            this.f5758f = str;
            this.f5759g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5757e.g().evaluateJavascript(this.f5758f, this.f5759g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f5743f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5761f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5762g;

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
            this.f5760e = bVar;
            this.f5761f = str;
            this.f5762g = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [c.a.r0.a.p.e.c] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5760e.t().evaluateJavascript(this.f5761f, this.f5762g);
            }
        }
    }

    /* renamed from: c.a.r0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0290f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5763b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f5764c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5765d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5766e;

        public C0290f(f fVar, c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b bVar, c.a.r0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f5766e = fVar;
            this.a = aVar;
            this.f5763b = bVar;
            this.f5764c = bVar2;
            this.f5765d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5743f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f5766e.f5746c = true;
                this.f5766e.u(this.a, this.f5763b, this.f5764c, this.f5765d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.l.a f5767e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.p.e.b f5768f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.f1.e.b f5769g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.g f5770h;

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
            this.f5767e = aVar;
            this.f5768f = bVar;
            this.f5769g = bVar2;
            this.f5770h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.f2.f.o0.c.a(this.f5767e, this.f5768f, this.f5769g, this.f5770h);
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
        f5743f = c.a.r0.a.k.a;
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
        this.f5745b = false;
        this.f5746c = false;
        this.f5747d = false;
        this.f5748e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f5744g == null) {
                synchronized (f.class) {
                    if (f5744g == null) {
                        f5744g = new f();
                    }
                }
            }
            return f5744g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5748e : invokeV.booleanValue;
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
            o(bVar, new C0290f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.r0.a.h0.l.a aVar, c.a.r0.a.p.e.b<?> bVar, c.a.r0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.r0.a.h0.u.g.U().q0()) {
            c.a.r0.a.e0.d.k("LocalDebugger", "prepareDaemon start.");
            if (this.f5748e && this.f5747d && this.a != null) {
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
            f5744g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.r0.a.e0.d.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f5748e = true;
            this.f5745b = false;
            this.f5746c = false;
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
                if (this.f5745b && this.f5746c) {
                    c.a.r0.a.e0.d.k("LocalDebugger", "startFirstPage");
                    q0.a0(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
