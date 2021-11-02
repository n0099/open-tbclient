package b.a.p0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.l0.j;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
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
    public static final boolean f4600f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f4601g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.h0.k.f f4602a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4603b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f4604c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4605d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f4606e;

    /* loaded from: classes.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4607a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4608b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4609c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f4610d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4611e;

        public a(f fVar, b.a.p0.a.f1.e.b bVar, b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar2, e.g gVar) {
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
            this.f4611e = fVar;
            this.f4607a = bVar;
            this.f4608b = aVar;
            this.f4609c = bVar2;
            this.f4610d = gVar;
        }

        @Override // b.a.p0.a.l0.j
        public void a(b.a.p0.a.l0.a aVar) {
            b.a.p0.a.o0.d.b j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f4611e.f4605d = true;
                b.a.p0.a.e0.f.d.d.e().f("loaddebug");
                b.a.p0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
                this.f4611e.t(this.f4611e.j(this.f4607a));
                if (f.f4600f) {
                    String str = "debugInitMsg - " + j.g().toString();
                }
                this.f4611e.n(this.f4608b, this.f4609c, this.f4607a, this.f4610d);
                this.f4611e.p(this.f4608b, this.f4609c, this.f4607a, this.f4610d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4612a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4613b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4614c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f4615d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4616e;

        public b(f fVar, b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f4616e = fVar;
            this.f4612a = aVar;
            this.f4613b = bVar;
            this.f4614c = bVar2;
            this.f4615d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f4600f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f4616e.f4603b = true;
                this.f4616e.u(this.f4612a, this.f4613b, this.f4614c, this.f4615d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4617e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4618f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f4619g;

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
            this.f4617e = aVar;
            this.f4618f = str;
            this.f4619g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4617e.f().evaluateJavascript(this.f4618f, this.f4619g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f4600f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4620e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4621f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f4622g;

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
            this.f4620e = bVar;
            this.f4621f = str;
            this.f4622g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((NgWebView) this.f4620e.s()).evaluateJavascript(this.f4621f, this.f4622g);
            }
        }
    }

    /* renamed from: b.a.p0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0147f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4623a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4624b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4625c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f4626d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4627e;

        public C0147f(f fVar, b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f4627e = fVar;
            this.f4623a = aVar;
            this.f4624b = bVar;
            this.f4625c = bVar2;
            this.f4626d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f4600f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f4627e.f4604c = true;
                this.f4627e.u(this.f4623a, this.f4624b, this.f4625c, this.f4626d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.l.a f4628e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f4629f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f4630g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f4631h;

        public g(f fVar, b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b bVar, b.a.p0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f4628e = aVar;
            this.f4629f = bVar;
            this.f4630g = bVar2;
            this.f4631h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.c2.f.p0.c.a(this.f4628e, this.f4629f, this.f4630g, this.f4631h);
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
        f4600f = k.f6397a;
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
        this.f4603b = false;
        this.f4604c = false;
        this.f4605d = false;
        this.f4606e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f4601g == null) {
                synchronized (f.class) {
                    if (f4601g == null) {
                        f4601g = new f();
                    }
                }
            }
            return f4601g;
        }
        return (f) invokeV.objValue;
    }

    public final b.a.p0.a.o0.d.b j(@NonNull b.a.p0.a.f1.e.b<b.a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", bVar.W());
                jSONObject.put("wsServerPort", bVar.X());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new b.a.p0.a.o0.d.b("message", hashMap);
        }
        return (b.a.p0.a.o0.d.b) invokeL.objValue;
    }

    public b.a.p0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.a.h0.k.f fVar = this.f4602a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4606e : invokeV.booleanValue;
    }

    public final void n(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b<NgWebView> bVar, b.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.f() != null) {
                q0.X(new c(this, aVar, b.a.p0.t.d.D(new File(b.a.p0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                b.a.p0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(b.a.p0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.s() != null) {
                String D = b.a.p0.t.d.D(new File(b.a.p0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.X(new e(this, bVar, D, valueCallback));
                return;
            }
            b.a.p0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b<NgWebView> bVar, b.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0147f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b<NgWebView> bVar, b.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && b.a.p0.a.h0.u.g.M().f0()) {
            b.a.p0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f4606e && this.f4605d && this.f4602a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            b.a.p0.a.h0.k.f b2 = b.a.p0.a.h0.u.g.M().W().b();
            this.f4602a = b2;
            b2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
            b.a.p0.a.h0.k.f fVar = this.f4602a;
            if (fVar != null) {
                fVar.b();
                this.f4602a = null;
            }
            f4601g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b.a.p0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f4606e = true;
            this.f4603b = false;
            this.f4604c = false;
        }
    }

    public final void t(b.a.p0.a.o0.d.a aVar) {
        b.a.p0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (fVar = this.f4602a) == null) {
            return;
        }
        b.a.p0.a.o0.a.a(fVar.a(), aVar);
    }

    public final synchronized void u(b.a.p0.a.h0.l.a aVar, b.a.p0.a.p.e.b<NgWebView> bVar, b.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f4603b && this.f4604c) {
                    b.a.p0.a.e0.d.h("LocalDebugger", "startFirstPage");
                    q0.X(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
