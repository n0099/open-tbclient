package c.a.p0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.d;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.l0.k;
import c.a.p0.a.z2.q0;
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
    public static final boolean f4699f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f4700g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.h0.k.f a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4701b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f4702c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4703d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f4704e;

    /* loaded from: classes.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.f1.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f4705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f4706c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f4707d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4708e;

        public a(f fVar, c.a.p0.a.f1.e.b bVar, c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b bVar2, d.g gVar) {
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
            this.f4708e = fVar;
            this.a = bVar;
            this.f4705b = aVar;
            this.f4706c = bVar2;
            this.f4707d = gVar;
        }

        @Override // c.a.p0.a.l0.k
        public void a(c.a.p0.a.l0.a aVar) {
            c.a.p0.a.o0.d.c j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f4708e.f4703d = true;
                c.a.p0.a.e0.f.d.d.e().f("loaddebug");
                c.a.p0.a.e0.d.k("LocalDebugger", "prepareDaemon finish.");
                this.f4708e.t(this.f4708e.j(this.a));
                if (f.f4699f) {
                    String str = "debugInitMsg - " + j2.s().toString();
                }
                this.f4708e.n(this.f4705b, this.f4706c, this.a, this.f4707d);
                this.f4708e.p(this.f4705b, this.f4706c, this.a, this.f4707d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f4709b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f4710c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f4711d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4712e;

        public b(f fVar, c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b bVar, c.a.p0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f4712e = fVar;
            this.a = aVar;
            this.f4709b = bVar;
            this.f4710c = bVar2;
            this.f4711d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f4699f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f4712e.f4701b = true;
                this.f4712e.u(this.a, this.f4709b, this.f4710c, this.f4711d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f4713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4714f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f4715g;

        public c(f fVar, c.a.p0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f4713e = aVar;
            this.f4714f = str;
            this.f4715g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4713e.g().evaluateJavascript(this.f4714f, this.f4715g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f4699f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f4716e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4717f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f4718g;

        public e(f fVar, c.a.p0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f4716e = bVar;
            this.f4717f = str;
            this.f4718g = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [c.a.p0.a.p.e.c] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4716e.t().evaluateJavascript(this.f4717f, this.f4718g);
            }
        }
    }

    /* renamed from: c.a.p0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0206f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f4719b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f4720c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f4721d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4722e;

        public C0206f(f fVar, c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b bVar, c.a.p0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f4722e = fVar;
            this.a = aVar;
            this.f4719b = bVar;
            this.f4720c = bVar2;
            this.f4721d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f4699f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f4722e.f4702c = true;
                this.f4722e.u(this.a, this.f4719b, this.f4720c, this.f4721d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f4723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f4724f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f4725g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.g f4726h;

        public g(f fVar, c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b bVar, c.a.p0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f4723e = aVar;
            this.f4724f = bVar;
            this.f4725g = bVar2;
            this.f4726h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.f2.f.o0.c.a(this.f4723e, this.f4724f, this.f4725g, this.f4726h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1902575414, "Lc/a/p0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1902575414, "Lc/a/p0/a/e0/f/d/f;");
                return;
            }
        }
        f4699f = c.a.p0.a.k.a;
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
        this.f4701b = false;
        this.f4702c = false;
        this.f4703d = false;
        this.f4704e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f4700g == null) {
                synchronized (f.class) {
                    if (f4700g == null) {
                        f4700g = new f();
                    }
                }
            }
            return f4700g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.p0.a.o0.d.c j(@NonNull c.a.p0.a.f1.e.b<b.a> bVar) {
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
            return new c.a.p0.a.o0.d.c("message", hashMap);
        }
        return (c.a.p0.a.o0.d.c) invokeL.objValue;
    }

    public c.a.p0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.a.h0.k.f fVar = this.a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (c.a.p0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4704e : invokeV.booleanValue;
    }

    public final void n(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<?> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.a0(new c(this, aVar, c.a.p0.w.d.E(new File(c.a.p0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.p0.a.e0.d.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.p0.a.p.e.b<?> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String E = c.a.p0.w.d.E(new File(c.a.p0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.a0(new e(this, bVar, E, valueCallback));
                return;
            }
            c.a.p0.a.e0.d.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<?> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0206f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<?> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.p0.a.h0.u.g.U().q0()) {
            c.a.p0.a.e0.d.k("LocalDebugger", "prepareDaemon start.");
            if (this.f4704e && this.f4703d && this.a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.p0.a.h0.k.f d2 = c.a.p0.a.h0.u.g.U().f0().d();
            this.a = d2;
            d2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.e0.d.k("LocalDebugger", "releaseLocalDebugger");
            c.a.p0.a.h0.k.f fVar = this.a;
            if (fVar != null) {
                fVar.b();
                this.a = null;
            }
            f4700g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.a.e0.d.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f4704e = true;
            this.f4701b = false;
            this.f4702c = false;
        }
    }

    public final void t(c.a.p0.a.o0.d.b bVar) {
        c.a.p0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || (fVar = this.a) == null) {
            return;
        }
        c.a.p0.a.o0.a.a(fVar.a(), bVar);
    }

    public final synchronized void u(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<?> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f4701b && this.f4702c) {
                    c.a.p0.a.e0.d.k("LocalDebugger", "startFirstPage");
                    q0.a0(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
