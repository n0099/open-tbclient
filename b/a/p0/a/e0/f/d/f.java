package b.a.p0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.l0.k;
import b.a.p0.a.z2.q0;
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
    public static final boolean f4570f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f4571g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.h0.k.f f4572a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4573b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f4574c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4575d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f4576e;

    /* loaded from: classes.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4577a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4578b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4579c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f4580d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4581e;

        public a(f fVar, b.a.p0.a.f1.e.b bVar, b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar2, d.g gVar) {
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
            this.f4581e = fVar;
            this.f4577a = bVar;
            this.f4578b = aVar;
            this.f4579c = bVar2;
            this.f4580d = gVar;
        }

        @Override // b.a.p0.a.l0.k
        public void a(b.a.p0.a.l0.a aVar) {
            b.a.p0.a.o0.d.c j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f4581e.f4575d = true;
                b.a.p0.a.e0.f.d.d.e().f("loaddebug");
                b.a.p0.a.e0.d.k("LocalDebugger", "prepareDaemon finish.");
                this.f4581e.t(this.f4581e.j(this.f4577a));
                if (f.f4570f) {
                    String str = "debugInitMsg - " + j.s().toString();
                }
                this.f4581e.n(this.f4578b, this.f4579c, this.f4577a, this.f4580d);
                this.f4581e.p(this.f4578b, this.f4579c, this.f4577a, this.f4580d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4582a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4583b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4584c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f4585d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4586e;

        public b(f fVar, b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f4586e = fVar;
            this.f4582a = aVar;
            this.f4583b = bVar;
            this.f4584c = bVar2;
            this.f4585d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f4570f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f4586e.f4573b = true;
                this.f4586e.u(this.f4582a, this.f4583b, this.f4584c, this.f4585d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4588f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f4589g;

        public c(f fVar, b.a.p0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f4587e = aVar;
            this.f4588f = str;
            this.f4589g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4587e.g().evaluateJavascript(this.f4588f, this.f4589g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f4570f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4591f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f4592g;

        public e(f fVar, b.a.p0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f4590e = bVar;
            this.f4591f = str;
            this.f4592g = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [b.a.p0.a.p.e.c] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4590e.t().evaluateJavascript(this.f4591f, this.f4592g);
            }
        }
    }

    /* renamed from: b.a.p0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0150f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4593a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4594b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4595c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f4596d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4597e;

        public C0150f(f fVar, b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f4597e = fVar;
            this.f4593a = aVar;
            this.f4594b = bVar;
            this.f4595c = bVar2;
            this.f4596d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f4570f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f4597e.f4574c = true;
                this.f4597e.u(this.f4593a, this.f4594b, this.f4595c, this.f4596d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4599f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4600g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.g f4601h;

        public g(f fVar, b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f4598e = aVar;
            this.f4599f = bVar;
            this.f4600g = bVar2;
            this.f4601h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.f2.f.o0.c.a(this.f4598e, this.f4599f, this.f4600g, this.f4601h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1395319529, "Lb/a/p0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1395319529, "Lb/a/p0/a/e0/f/d/f;");
                return;
            }
        }
        f4570f = b.a.p0.a.k.f6863a;
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
        this.f4573b = false;
        this.f4574c = false;
        this.f4575d = false;
        this.f4576e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f4571g == null) {
                synchronized (f.class) {
                    if (f4571g == null) {
                        f4571g = new f();
                    }
                }
            }
            return f4571g;
        }
        return (f) invokeV.objValue;
    }

    public final b.a.p0.a.o0.d.c j(@NonNull b.a.p0.a.f1.e.b<b.a> bVar) {
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
            return new b.a.p0.a.o0.d.c("message", hashMap);
        }
        return (b.a.p0.a.o0.d.c) invokeL.objValue;
    }

    public b.a.p0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.a.h0.k.f fVar = this.f4572a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (b.a.p0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4576e : invokeV.booleanValue;
    }

    public final void n(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b<?> bVar, b.a.p0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.a0(new c(this, aVar, b.a.p0.w.d.E(new File(b.a.p0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                b.a.p0.a.e0.d.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(b.a.p0.a.p.e.b<?> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String E = b.a.p0.w.d.E(new File(b.a.p0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.a0(new e(this, bVar, E, valueCallback));
                return;
            }
            b.a.p0.a.e0.d.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b<?> bVar, b.a.p0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0150f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b<?> bVar, b.a.p0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && b.a.p0.a.h0.u.g.U().q0()) {
            b.a.p0.a.e0.d.k("LocalDebugger", "prepareDaemon start.");
            if (this.f4576e && this.f4575d && this.f4572a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            b.a.p0.a.h0.k.f d2 = b.a.p0.a.h0.u.g.U().f0().d();
            this.f4572a = d2;
            d2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.e0.d.k("LocalDebugger", "releaseLocalDebugger");
            b.a.p0.a.h0.k.f fVar = this.f4572a;
            if (fVar != null) {
                fVar.b();
                this.f4572a = null;
            }
            f4571g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.p0.a.e0.d.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f4576e = true;
            this.f4573b = false;
            this.f4574c = false;
        }
    }

    public final void t(b.a.p0.a.o0.d.b bVar) {
        b.a.p0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || (fVar = this.f4572a) == null) {
            return;
        }
        b.a.p0.a.o0.a.a(fVar.a(), bVar);
    }

    public final synchronized void u(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b<?> bVar, b.a.p0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f4573b && this.f4574c) {
                    b.a.p0.a.e0.d.k("LocalDebugger", "startFirstPage");
                    q0.a0(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
