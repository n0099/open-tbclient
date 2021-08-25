package c.a.o0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a1.e;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.k;
import c.a.o0.a.l0.j;
import c.a.o0.a.v2.q0;
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
    public static final boolean f5195f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f5196g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.o0.a.h0.k.f f5197a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5198b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5199c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5200d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5201e;

    /* loaded from: classes.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.f1.e.b f5202a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.l.a f5203b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.b f5204c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5205d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5206e;

        public a(f fVar, c.a.o0.a.f1.e.b bVar, c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b bVar2, e.g gVar) {
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
            this.f5206e = fVar;
            this.f5202a = bVar;
            this.f5203b = aVar;
            this.f5204c = bVar2;
            this.f5205d = gVar;
        }

        @Override // c.a.o0.a.l0.j
        public void a(c.a.o0.a.l0.a aVar) {
            c.a.o0.a.o0.d.b j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5206e.f5200d = true;
                c.a.o0.a.e0.f.d.d.e().f("loaddebug");
                c.a.o0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
                this.f5206e.t(this.f5206e.j(this.f5202a));
                if (f.f5195f) {
                    String str = "debugInitMsg - " + j2.g().toString();
                }
                this.f5206e.n(this.f5203b, this.f5204c, this.f5202a, this.f5205d);
                this.f5206e.p(this.f5203b, this.f5204c, this.f5202a, this.f5205d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.l.a f5207a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.b f5208b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.f1.e.b f5209c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5210d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5211e;

        public b(f fVar, c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b bVar, c.a.o0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f5211e = fVar;
            this.f5207a = aVar;
            this.f5208b = bVar;
            this.f5209c = bVar2;
            this.f5210d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5195f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f5211e.f5198b = true;
                this.f5211e.u(this.f5207a, this.f5208b, this.f5209c, this.f5210d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.l.a f5212e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5213f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5214g;

        public c(f fVar, c.a.o0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f5212e = aVar;
            this.f5213f = str;
            this.f5214g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5212e.g().evaluateJavascript(this.f5213f, this.f5214g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f5195f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.b f5215e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5216f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5217g;

        public e(f fVar, c.a.o0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f5215e = bVar;
            this.f5216f = str;
            this.f5217g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((NgWebView) this.f5215e.t()).evaluateJavascript(this.f5216f, this.f5217g);
            }
        }
    }

    /* renamed from: c.a.o0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0150f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.l.a f5218a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.b f5219b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.f1.e.b f5220c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5221d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5222e;

        public C0150f(f fVar, c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b bVar, c.a.o0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f5222e = fVar;
            this.f5218a = aVar;
            this.f5219b = bVar;
            this.f5220c = bVar2;
            this.f5221d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5195f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f5222e.f5199c = true;
                this.f5222e.u(this.f5218a, this.f5219b, this.f5220c, this.f5221d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.l.a f5223e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.p.e.b f5224f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.f1.e.b f5225g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f5226h;

        public g(f fVar, c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b bVar, c.a.o0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f5223e = aVar;
            this.f5224f = bVar;
            this.f5225g = bVar2;
            this.f5226h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.c2.f.p0.c.a(this.f5223e, this.f5224f, this.f5225g, this.f5226h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1886833257, "Lc/a/o0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1886833257, "Lc/a/o0/a/e0/f/d/f;");
                return;
            }
        }
        f5195f = k.f7049a;
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
        this.f5198b = false;
        this.f5199c = false;
        this.f5200d = false;
        this.f5201e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f5196g == null) {
                synchronized (f.class) {
                    if (f5196g == null) {
                        f5196g = new f();
                    }
                }
            }
            return f5196g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.o0.a.o0.d.b j(@NonNull c.a.o0.a.f1.e.b<b.a> bVar) {
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
            return new c.a.o0.a.o0.d.b("message", hashMap);
        }
        return (c.a.o0.a.o0.d.b) invokeL.objValue;
    }

    public c.a.o0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.o0.a.h0.k.f fVar = this.f5197a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (c.a.o0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5201e : invokeV.booleanValue;
    }

    public final void n(c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b<NgWebView> bVar, c.a.o0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.X(new c(this, aVar, c.a.o0.t.d.D(new File(c.a.o0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.o0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.o0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String D = c.a.o0.t.d.D(new File(c.a.o0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.X(new e(this, bVar, D, valueCallback));
                return;
            }
            c.a.o0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b<NgWebView> bVar, c.a.o0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0150f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b<NgWebView> bVar, c.a.o0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.o0.a.h0.u.g.N().g0()) {
            c.a.o0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f5201e && this.f5200d && this.f5197a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.o0.a.h0.k.f b2 = c.a.o0.a.h0.u.g.N().X().b();
            this.f5197a = b2;
            b2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.o0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
            c.a.o0.a.h0.k.f fVar = this.f5197a;
            if (fVar != null) {
                fVar.b();
                this.f5197a = null;
            }
            f5196g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.o0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f5201e = true;
            this.f5198b = false;
            this.f5199c = false;
        }
    }

    public final void t(c.a.o0.a.o0.d.a aVar) {
        c.a.o0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (fVar = this.f5197a) == null) {
            return;
        }
        c.a.o0.a.o0.a.a(fVar.a(), aVar);
    }

    public final synchronized void u(c.a.o0.a.h0.l.a aVar, c.a.o0.a.p.e.b<NgWebView> bVar, c.a.o0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f5198b && this.f5199c) {
                    c.a.o0.a.e0.d.h("LocalDebugger", "startFirstPage");
                    q0.X(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
