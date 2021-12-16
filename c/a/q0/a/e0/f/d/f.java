package c.a.q0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.a1.d;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.l0.k;
import c.a.q0.a.z2.q0;
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
    public static final boolean f5008f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f5009g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.a.h0.k.f a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5010b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5011c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5012d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5013e;

    /* loaded from: classes.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.a.f1.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.l.a f5014b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.p.e.b f5015c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5016d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5017e;

        public a(f fVar, c.a.q0.a.f1.e.b bVar, c.a.q0.a.h0.l.a aVar, c.a.q0.a.p.e.b bVar2, d.g gVar) {
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
            this.f5017e = fVar;
            this.a = bVar;
            this.f5014b = aVar;
            this.f5015c = bVar2;
            this.f5016d = gVar;
        }

        @Override // c.a.q0.a.l0.k
        public void a(c.a.q0.a.l0.a aVar) {
            c.a.q0.a.o0.d.c j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5017e.f5012d = true;
                c.a.q0.a.e0.f.d.d.e().f("loaddebug");
                c.a.q0.a.e0.d.k("LocalDebugger", "prepareDaemon finish.");
                this.f5017e.t(this.f5017e.j(this.a));
                if (f.f5008f) {
                    String str = "debugInitMsg - " + j2.s().toString();
                }
                this.f5017e.n(this.f5014b, this.f5015c, this.a, this.f5016d);
                this.f5017e.p(this.f5014b, this.f5015c, this.a, this.f5016d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.p.e.b f5018b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.f1.e.b f5019c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5020d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5021e;

        public b(f fVar, c.a.q0.a.h0.l.a aVar, c.a.q0.a.p.e.b bVar, c.a.q0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f5021e = fVar;
            this.a = aVar;
            this.f5018b = bVar;
            this.f5019c = bVar2;
            this.f5020d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5008f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f5021e.f5010b = true;
                this.f5021e.u(this.a, this.f5018b, this.f5019c, this.f5020d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.l.a f5022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5023f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5024g;

        public c(f fVar, c.a.q0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f5022e = aVar;
            this.f5023f = str;
            this.f5024g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5022e.g().evaluateJavascript(this.f5023f, this.f5024g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f5008f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.p.e.b f5025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5026f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5027g;

        public e(f fVar, c.a.q0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f5025e = bVar;
            this.f5026f = str;
            this.f5027g = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [c.a.q0.a.p.e.c] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5025e.t().evaluateJavascript(this.f5026f, this.f5027g);
            }
        }
    }

    /* renamed from: c.a.q0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0240f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.p.e.b f5028b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.f1.e.b f5029c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5030d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5031e;

        public C0240f(f fVar, c.a.q0.a.h0.l.a aVar, c.a.q0.a.p.e.b bVar, c.a.q0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f5031e = fVar;
            this.a = aVar;
            this.f5028b = bVar;
            this.f5029c = bVar2;
            this.f5030d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5008f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f5031e.f5011c = true;
                this.f5031e.u(this.a, this.f5028b, this.f5029c, this.f5030d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.l.a f5032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.p.e.b f5033f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.f1.e.b f5034g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.g f5035h;

        public g(f fVar, c.a.q0.a.h0.l.a aVar, c.a.q0.a.p.e.b bVar, c.a.q0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f5032e = aVar;
            this.f5033f = bVar;
            this.f5034g = bVar2;
            this.f5035h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.f2.f.o0.c.a(this.f5032e, this.f5033f, this.f5034g, this.f5035h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1397016789, "Lc/a/q0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1397016789, "Lc/a/q0/a/e0/f/d/f;");
                return;
            }
        }
        f5008f = c.a.q0.a.k.a;
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
        this.f5010b = false;
        this.f5011c = false;
        this.f5012d = false;
        this.f5013e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f5009g == null) {
                synchronized (f.class) {
                    if (f5009g == null) {
                        f5009g = new f();
                    }
                }
            }
            return f5009g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.q0.a.o0.d.c j(@NonNull c.a.q0.a.f1.e.b<b.a> bVar) {
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
            return new c.a.q0.a.o0.d.c("message", hashMap);
        }
        return (c.a.q0.a.o0.d.c) invokeL.objValue;
    }

    public c.a.q0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.q0.a.h0.k.f fVar = this.a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (c.a.q0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5013e : invokeV.booleanValue;
    }

    public final void n(c.a.q0.a.h0.l.a aVar, c.a.q0.a.p.e.b<?> bVar, c.a.q0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.a0(new c(this, aVar, c.a.q0.w.d.E(new File(c.a.q0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.q0.a.e0.d.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.q0.a.p.e.b<?> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String E = c.a.q0.w.d.E(new File(c.a.q0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.a0(new e(this, bVar, E, valueCallback));
                return;
            }
            c.a.q0.a.e0.d.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.q0.a.h0.l.a aVar, c.a.q0.a.p.e.b<?> bVar, c.a.q0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0240f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.q0.a.h0.l.a aVar, c.a.q0.a.p.e.b<?> bVar, c.a.q0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.q0.a.h0.u.g.U().q0()) {
            c.a.q0.a.e0.d.k("LocalDebugger", "prepareDaemon start.");
            if (this.f5013e && this.f5012d && this.a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.q0.a.h0.k.f d2 = c.a.q0.a.h0.u.g.U().f0().d();
            this.a = d2;
            d2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.q0.a.e0.d.k("LocalDebugger", "releaseLocalDebugger");
            c.a.q0.a.h0.k.f fVar = this.a;
            if (fVar != null) {
                fVar.b();
                this.a = null;
            }
            f5009g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.q0.a.e0.d.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f5013e = true;
            this.f5010b = false;
            this.f5011c = false;
        }
    }

    public final void t(c.a.q0.a.o0.d.b bVar) {
        c.a.q0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || (fVar = this.a) == null) {
            return;
        }
        c.a.q0.a.o0.a.a(fVar.a(), bVar);
    }

    public final synchronized void u(c.a.q0.a.h0.l.a aVar, c.a.q0.a.p.e.b<?> bVar, c.a.q0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f5010b && this.f5011c) {
                    c.a.q0.a.e0.d.k("LocalDebugger", "startFirstPage");
                    q0.a0(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
