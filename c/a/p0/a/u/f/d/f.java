package c.a.p0.a.u.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.b0.k;
import c.a.p0.a.p2.q0;
import c.a.p0.a.q0.d;
import c.a.p0.a.v0.e.b;
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
    public static final boolean f7592f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f7593g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.x.k.f a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f7594b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f7595c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f7596d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f7597e;

    /* loaded from: classes.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.v0.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.l.a f7598b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f.e.b f7599c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f7600d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7601e;

        public a(f fVar, c.a.p0.a.v0.e.b bVar, c.a.p0.a.x.l.a aVar, c.a.p0.a.f.e.b bVar2, d.g gVar) {
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
            this.f7601e = fVar;
            this.a = bVar;
            this.f7598b = aVar;
            this.f7599c = bVar2;
            this.f7600d = gVar;
        }

        @Override // c.a.p0.a.b0.k
        public void a(c.a.p0.a.b0.a aVar) {
            c.a.p0.a.e0.d.c j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f7601e.f7596d = true;
                c.a.p0.a.u.f.d.d.e().f("loaddebug");
                c.a.p0.a.u.d.k("LocalDebugger", "prepareDaemon finish.");
                this.f7601e.t(this.f7601e.j(this.a));
                if (f.f7592f) {
                    String str = "debugInitMsg - " + j2.s().toString();
                }
                this.f7601e.n(this.f7598b, this.f7599c, this.a, this.f7600d);
                this.f7601e.p(this.f7598b, this.f7599c, this.a, this.f7600d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.x.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f.e.b f7602b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v0.e.b f7603c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f7604d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7605e;

        public b(f fVar, c.a.p0.a.x.l.a aVar, c.a.p0.a.f.e.b bVar, c.a.p0.a.v0.e.b bVar2, d.g gVar) {
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
            this.f7605e = fVar;
            this.a = aVar;
            this.f7602b = bVar;
            this.f7603c = bVar2;
            this.f7604d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f7592f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f7605e.f7594b = true;
                this.f7605e.u(this.a, this.f7602b, this.f7603c, this.f7604d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.l.a f7606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7607f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f7608g;

        public c(f fVar, c.a.p0.a.x.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f7606e = aVar;
            this.f7607f = str;
            this.f7608g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7606e.g().evaluateJavascript(this.f7607f, this.f7608g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f7592f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f.e.b f7609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f7611g;

        public e(f fVar, c.a.p0.a.f.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f7609e = bVar;
            this.f7610f = str;
            this.f7611g = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [c.a.p0.a.f.e.c] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7609e.t().evaluateJavascript(this.f7610f, this.f7611g);
            }
        }
    }

    /* renamed from: c.a.p0.a.u.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0473f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.x.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f.e.b f7612b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v0.e.b f7613c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f7614d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f7615e;

        public C0473f(f fVar, c.a.p0.a.x.l.a aVar, c.a.p0.a.f.e.b bVar, c.a.p0.a.v0.e.b bVar2, d.g gVar) {
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
            this.f7615e = fVar;
            this.a = aVar;
            this.f7612b = bVar;
            this.f7613c = bVar2;
            this.f7614d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f7592f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f7615e.f7595c = true;
                this.f7615e.u(this.a, this.f7612b, this.f7613c, this.f7614d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.l.a f7616e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f.e.b f7617f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v0.e.b f7618g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.g f7619h;

        public g(f fVar, c.a.p0.a.x.l.a aVar, c.a.p0.a.f.e.b bVar, c.a.p0.a.v0.e.b bVar2, d.g gVar) {
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
            this.f7616e = aVar;
            this.f7617f = bVar;
            this.f7618g = bVar2;
            this.f7619h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.v1.f.o0.c.a(this.f7616e, this.f7617f, this.f7618g, this.f7619h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1151802618, "Lc/a/p0/a/u/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1151802618, "Lc/a/p0/a/u/f/d/f;");
                return;
            }
        }
        f7592f = c.a.p0.a.a.a;
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
        this.f7594b = false;
        this.f7595c = false;
        this.f7596d = false;
        this.f7597e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f7593g == null) {
                synchronized (f.class) {
                    if (f7593g == null) {
                        f7593g = new f();
                    }
                }
            }
            return f7593g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.p0.a.e0.d.c j(@NonNull c.a.p0.a.v0.e.b<b.a> bVar) {
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
            return new c.a.p0.a.e0.d.c("message", hashMap);
        }
        return (c.a.p0.a.e0.d.c) invokeL.objValue;
    }

    public c.a.p0.a.b0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.a.x.k.f fVar = this.a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (c.a.p0.a.b0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7597e : invokeV.booleanValue;
    }

    public final void n(c.a.p0.a.x.l.a aVar, c.a.p0.a.f.e.b<?> bVar, c.a.p0.a.v0.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.a0(new c(this, aVar, c.a.p0.w.d.E(new File(c.a.p0.a.u.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.p0.a.u.d.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.p0.a.f.e.b<?> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String E = c.a.p0.w.d.E(new File(c.a.p0.a.u.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.a0(new e(this, bVar, E, valueCallback));
                return;
            }
            c.a.p0.a.u.d.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.p0.a.x.l.a aVar, c.a.p0.a.f.e.b<?> bVar, c.a.p0.a.v0.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0473f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.p0.a.x.l.a aVar, c.a.p0.a.f.e.b<?> bVar, c.a.p0.a.v0.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.p0.a.x.u.g.U().q0()) {
            c.a.p0.a.u.d.k("LocalDebugger", "prepareDaemon start.");
            if (this.f7597e && this.f7596d && this.a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.p0.a.x.k.f d2 = c.a.p0.a.x.u.g.U().f0().d();
            this.a = d2;
            d2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.u.d.k("LocalDebugger", "releaseLocalDebugger");
            c.a.p0.a.x.k.f fVar = this.a;
            if (fVar != null) {
                fVar.b();
                this.a = null;
            }
            f7593g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.a.u.d.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f7597e = true;
            this.f7594b = false;
            this.f7595c = false;
        }
    }

    public final void t(c.a.p0.a.e0.d.b bVar) {
        c.a.p0.a.x.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || (fVar = this.a) == null) {
            return;
        }
        c.a.p0.a.e0.a.a(fVar.a(), bVar);
    }

    public final synchronized void u(c.a.p0.a.x.l.a aVar, c.a.p0.a.f.e.b<?> bVar, c.a.p0.a.v0.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f7594b && this.f7595c) {
                    c.a.p0.a.u.d.k("LocalDebugger", "startFirstPage");
                    q0.a0(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
