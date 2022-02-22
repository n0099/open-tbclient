package c.a.s0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.a1.d;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.l0.k;
import c.a.s0.a.z2.q0;
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
    public static final boolean f5859f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f5860g;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.a.h0.k.f a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5861b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5862c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5863d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5864e;

    /* loaded from: classes.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.f1.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.l.a f5865b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.p.e.b f5866c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5867d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5868e;

        public a(f fVar, c.a.s0.a.f1.e.b bVar, c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b bVar2, d.g gVar) {
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
            this.f5868e = fVar;
            this.a = bVar;
            this.f5865b = aVar;
            this.f5866c = bVar2;
            this.f5867d = gVar;
        }

        @Override // c.a.s0.a.l0.k
        public void a(c.a.s0.a.l0.a aVar) {
            c.a.s0.a.o0.d.c j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5868e.f5863d = true;
                c.a.s0.a.e0.f.d.d.e().f("loaddebug");
                c.a.s0.a.e0.d.k("LocalDebugger", "prepareDaemon finish.");
                this.f5868e.t(this.f5868e.j(this.a));
                if (f.f5859f) {
                    String str = "debugInitMsg - " + j2.s().toString();
                }
                this.f5868e.n(this.f5865b, this.f5866c, this.a, this.f5867d);
                this.f5868e.p(this.f5865b, this.f5866c, this.a, this.f5867d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.p.e.b f5869b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f5870c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5871d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5872e;

        public b(f fVar, c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b bVar, c.a.s0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f5872e = fVar;
            this.a = aVar;
            this.f5869b = bVar;
            this.f5870c = bVar2;
            this.f5871d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5859f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f5872e.f5861b = true;
                this.f5872e.u(this.a, this.f5869b, this.f5870c, this.f5871d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.l.a f5873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5874f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5875g;

        public c(f fVar, c.a.s0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f5873e = aVar;
            this.f5874f = str;
            this.f5875g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5873e.g().evaluateJavascript(this.f5874f, this.f5875g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f5859f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.p.e.b f5876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5877f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5878g;

        public e(f fVar, c.a.s0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f5876e = bVar;
            this.f5877f = str;
            this.f5878g = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [c.a.s0.a.p.e.c] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5876e.t().evaluateJavascript(this.f5877f, this.f5878g);
            }
        }
    }

    /* renamed from: c.a.s0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0319f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.h0.l.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.p.e.b f5879b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f5880c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.g f5881d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5882e;

        public C0319f(f fVar, c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b bVar, c.a.s0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f5882e = fVar;
            this.a = aVar;
            this.f5879b = bVar;
            this.f5880c = bVar2;
            this.f5881d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5859f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f5882e.f5862c = true;
                this.f5882e.u(this.a, this.f5879b, this.f5880c, this.f5881d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.l.a f5883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.p.e.b f5884f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f5885g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.g f5886h;

        public g(f fVar, c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b bVar, c.a.s0.a.f1.e.b bVar2, d.g gVar) {
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
            this.f5883e = aVar;
            this.f5884f = bVar;
            this.f5885g = bVar2;
            this.f5886h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.f2.f.o0.c.a(this.f5883e, this.f5884f, this.f5885g, this.f5886h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(385899539, "Lc/a/s0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(385899539, "Lc/a/s0/a/e0/f/d/f;");
                return;
            }
        }
        f5859f = c.a.s0.a.k.a;
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
        this.f5861b = false;
        this.f5862c = false;
        this.f5863d = false;
        this.f5864e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f5860g == null) {
                synchronized (f.class) {
                    if (f5860g == null) {
                        f5860g = new f();
                    }
                }
            }
            return f5860g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.s0.a.o0.d.c j(@NonNull c.a.s0.a.f1.e.b<b.a> bVar) {
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
            return new c.a.s0.a.o0.d.c("message", hashMap);
        }
        return (c.a.s0.a.o0.d.c) invokeL.objValue;
    }

    public c.a.s0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.s0.a.h0.k.f fVar = this.a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (c.a.s0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5864e : invokeV.booleanValue;
    }

    public final void n(c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b<?> bVar, c.a.s0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.a0(new c(this, aVar, c.a.s0.w.d.E(new File(c.a.s0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.s0.a.e0.d.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.s0.a.p.e.b<?> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String E = c.a.s0.w.d.E(new File(c.a.s0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.a0(new e(this, bVar, E, valueCallback));
                return;
            }
            c.a.s0.a.e0.d.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b<?> bVar, c.a.s0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0319f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b<?> bVar, c.a.s0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.s0.a.h0.u.g.U().q0()) {
            c.a.s0.a.e0.d.k("LocalDebugger", "prepareDaemon start.");
            if (this.f5864e && this.f5863d && this.a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.s0.a.h0.k.f d2 = c.a.s0.a.h0.u.g.U().f0().d();
            this.a = d2;
            d2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.s0.a.e0.d.k("LocalDebugger", "releaseLocalDebugger");
            c.a.s0.a.h0.k.f fVar = this.a;
            if (fVar != null) {
                fVar.b();
                this.a = null;
            }
            f5860g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.s0.a.e0.d.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f5864e = true;
            this.f5861b = false;
            this.f5862c = false;
        }
    }

    public final void t(c.a.s0.a.o0.d.b bVar) {
        c.a.s0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) || (fVar = this.a) == null) {
            return;
        }
        c.a.s0.a.o0.a.a(fVar.a(), bVar);
    }

    public final synchronized void u(c.a.s0.a.h0.l.a aVar, c.a.s0.a.p.e.b<?> bVar, c.a.s0.a.f1.e.b<b.a> bVar2, d.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f5861b && this.f5862c) {
                    c.a.s0.a.e0.d.k("LocalDebugger", "startFirstPage");
                    q0.a0(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
