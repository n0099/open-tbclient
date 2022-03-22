package c.a.n0.a.u.f.d;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.b0.k;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q0.d;
import c.a.n0.a.v0.e.b;
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
    public static final boolean f6416f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f6417g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.x.k.f a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f6418b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f6419c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f6420d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f6421e;

    /* loaded from: classes.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.v0.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.l.a f6422b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f.e.b f6423c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f6424d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6425e;

        public a(f fVar, c.a.n0.a.v0.e.b bVar, c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, aVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6425e = fVar;
            this.a = bVar;
            this.f6422b = aVar;
            this.f6423c = bVar2;
            this.f6424d = gVar;
        }

        @Override // c.a.n0.a.b0.k
        public void a(c.a.n0.a.b0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f6425e.f6420d = true;
                c.a.n0.a.u.f.d.d.e().f("loaddebug");
                c.a.n0.a.u.d.k("LocalDebugger", "prepareDaemon finish.");
                c.a.n0.a.e0.d.c j = this.f6425e.j(this.a);
                this.f6425e.t(j);
                if (f.f6416f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.f6425e.n(this.f6422b, this.f6423c, this.a, this.f6424d);
                this.f6425e.p(this.f6422b, this.f6423c, this.a, this.f6424d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f.e.b f6426b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f6427c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f6428d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6429e;

        public b(f fVar, c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b bVar, c.a.n0.a.v0.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6429e = fVar;
            this.a = aVar;
            this.f6426b = bVar;
            this.f6427c = bVar2;
            this.f6428d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f6416f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.f6429e.f6418b = true;
                this.f6429e.u(this.a, this.f6426b, this.f6427c, this.f6428d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6430b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f6431c;

        public c(f fVar, c.a.n0.a.x.l.a aVar, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f6430b = str;
            this.f6431c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h().evaluateJavascript(this.f6430b, this.f6431c);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f6416f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.f.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6432b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f6433c;

        public e(f fVar, c.a.n0.a.f.e.b bVar, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, bVar, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f6432b = str;
            this.f6433c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [c.a.n0.a.f.e.c] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u().evaluateJavascript(this.f6432b, this.f6433c);
            }
        }
    }

    /* renamed from: c.a.n0.a.u.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0465f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f.e.b f6434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f6435c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f6436d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f6437e;

        public C0465f(f fVar, c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b bVar, c.a.n0.a.v0.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6437e = fVar;
            this.a = aVar;
            this.f6434b = bVar;
            this.f6435c = bVar2;
            this.f6436d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f6416f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.f6437e.f6419c = true;
                this.f6437e.u(this.a, this.f6434b, this.f6435c, this.f6436d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f.e.b f6438b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f6439c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f6440d;

        public g(f fVar, c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b bVar, c.a.n0.a.v0.e.b bVar2, d.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, aVar, bVar, bVar2, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f6438b = bVar;
            this.f6439c = bVar2;
            this.f6440d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.v1.f.o0.c.a(this.a, this.f6438b, this.f6439c, this.f6440d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738608632, "Lc/a/n0/a/u/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738608632, "Lc/a/n0/a/u/f/d/f;");
                return;
            }
        }
        f6416f = c.a.n0.a.a.a;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6418b = false;
        this.f6419c = false;
        this.f6420d = false;
        this.f6421e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f6417g == null) {
                synchronized (f.class) {
                    if (f6417g == null) {
                        f6417g = new f();
                    }
                }
            }
            return f6417g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.n0.a.e0.d.c j(@NonNull c.a.n0.a.v0.e.b<b.a> bVar) {
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
            return new c.a.n0.a.e0.d.c("message", hashMap);
        }
        return (c.a.n0.a.e0.d.c) invokeL.objValue;
    }

    public c.a.n0.a.b0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.n0.a.x.k.f fVar = this.a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (c.a.n0.a.b0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6421e : invokeV.booleanValue;
    }

    public final void n(c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b<?> bVar, c.a.n0.a.v0.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.h() != null) {
                q0.a0(new c(this, aVar, c.a.n0.w.d.E(new File(c.a.n0.a.u.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.n0.a.u.d.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.n0.a.f.e.b<?> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.u() != null) {
                String E = c.a.n0.w.d.E(new File(c.a.n0.a.u.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.a0(new e(this, bVar, E, valueCallback));
                return;
            }
            c.a.n0.a.u.d.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b<?> bVar, c.a.n0.a.v0.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0465f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b<?> bVar, c.a.n0.a.v0.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.n0.a.x.u.g.U().q0()) {
            c.a.n0.a.u.d.k("LocalDebugger", "prepareDaemon start.");
            if (this.f6421e && this.f6420d && this.a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.n0.a.x.k.f d2 = c.a.n0.a.x.u.g.U().f0().d();
            this.a = d2;
            d2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.n0.a.u.d.k("LocalDebugger", "releaseLocalDebugger");
            c.a.n0.a.x.k.f fVar = this.a;
            if (fVar != null) {
                fVar.b();
                this.a = null;
            }
            f6417g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.n0.a.u.d.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f6421e = true;
            this.f6418b = false;
            this.f6419c = false;
        }
    }

    public final void t(c.a.n0.a.e0.d.b bVar) {
        c.a.n0.a.x.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || (fVar = this.a) == null) {
            return;
        }
        c.a.n0.a.e0.a.a(fVar.a(), bVar);
    }

    public final synchronized void u(c.a.n0.a.x.l.a aVar, c.a.n0.a.f.e.b<?> bVar, c.a.n0.a.v0.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f6418b && this.f6419c) {
                    c.a.n0.a.u.d.k("LocalDebugger", "startFirstPage");
                    q0.a0(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
