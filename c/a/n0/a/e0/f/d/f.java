package c.a.n0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.a1.e;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.k;
import c.a.n0.a.l0.j;
import c.a.n0.a.v2.q0;
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
    public static final boolean f4949f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f4950g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.n0.a.h0.k.f f4951a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f4952b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f4953c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4954d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f4955e;

    /* loaded from: classes.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f1.e.b f4956a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.l.a f4957b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.b f4958c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f4959d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4960e;

        public a(f fVar, c.a.n0.a.f1.e.b bVar, c.a.n0.a.h0.l.a aVar, c.a.n0.a.p.e.b bVar2, e.g gVar) {
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
            this.f4960e = fVar;
            this.f4956a = bVar;
            this.f4957b = aVar;
            this.f4958c = bVar2;
            this.f4959d = gVar;
        }

        @Override // c.a.n0.a.l0.j
        public void a(c.a.n0.a.l0.a aVar) {
            c.a.n0.a.o0.d.b j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f4960e.f4954d = true;
                c.a.n0.a.e0.f.d.d.e().f("loaddebug");
                c.a.n0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
                this.f4960e.t(this.f4960e.j(this.f4956a));
                if (f.f4949f) {
                    String str = "debugInitMsg - " + j2.g().toString();
                }
                this.f4960e.n(this.f4957b, this.f4958c, this.f4956a, this.f4959d);
                this.f4960e.p(this.f4957b, this.f4958c, this.f4956a, this.f4959d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.l.a f4961a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.b f4962b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f1.e.b f4963c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f4964d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4965e;

        public b(f fVar, c.a.n0.a.h0.l.a aVar, c.a.n0.a.p.e.b bVar, c.a.n0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f4965e = fVar;
            this.f4961a = aVar;
            this.f4962b = bVar;
            this.f4963c = bVar2;
            this.f4964d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f4949f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f4965e.f4952b = true;
                this.f4965e.u(this.f4961a, this.f4962b, this.f4963c, this.f4964d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.l.a f4966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4967f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f4968g;

        public c(f fVar, c.a.n0.a.h0.l.a aVar, String str, ValueCallback valueCallback) {
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
            this.f4966e = aVar;
            this.f4967f = str;
            this.f4968g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4966e.g().evaluateJavascript(this.f4967f, this.f4968g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f4949f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.b f4969e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4970f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f4971g;

        public e(f fVar, c.a.n0.a.p.e.b bVar, String str, ValueCallback valueCallback) {
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
            this.f4969e = bVar;
            this.f4970f = str;
            this.f4971g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((NgWebView) this.f4969e.t()).evaluateJavascript(this.f4970f, this.f4971g);
            }
        }
    }

    /* renamed from: c.a.n0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0142f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.l.a f4972a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.b f4973b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f1.e.b f4974c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f4975d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f4976e;

        public C0142f(f fVar, c.a.n0.a.h0.l.a aVar, c.a.n0.a.p.e.b bVar, c.a.n0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f4976e = fVar;
            this.f4972a = aVar;
            this.f4973b = bVar;
            this.f4974c = bVar2;
            this.f4975d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f4949f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f4976e.f4953c = true;
                this.f4976e.u(this.f4972a, this.f4973b, this.f4974c, this.f4975d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.l.a f4977e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p.e.b f4978f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.f1.e.b f4979g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f4980h;

        public g(f fVar, c.a.n0.a.h0.l.a aVar, c.a.n0.a.p.e.b bVar, c.a.n0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f4977e = aVar;
            this.f4978f = bVar;
            this.f4979g = bVar2;
            this.f4980h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.c2.f.p0.c.a(this.f4977e, this.f4978f, this.f4979g, this.f4980h);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1381274632, "Lc/a/n0/a/e0/f/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1381274632, "Lc/a/n0/a/e0/f/d/f;");
                return;
            }
        }
        f4949f = k.f6803a;
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
        this.f4952b = false;
        this.f4953c = false;
        this.f4954d = false;
        this.f4955e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f4950g == null) {
                synchronized (f.class) {
                    if (f4950g == null) {
                        f4950g = new f();
                    }
                }
            }
            return f4950g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.n0.a.o0.d.b j(@NonNull c.a.n0.a.f1.e.b<b.a> bVar) {
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
            return new c.a.n0.a.o0.d.b("message", hashMap);
        }
        return (c.a.n0.a.o0.d.b) invokeL.objValue;
    }

    public c.a.n0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.n0.a.h0.k.f fVar = this.f4951a;
            if (fVar != null) {
                return fVar.a();
            }
            return null;
        }
        return (c.a.n0.a.l0.a) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4955e : invokeV.booleanValue;
    }

    public final void n(c.a.n0.a.h0.l.a aVar, c.a.n0.a.p.e.b<NgWebView> bVar, c.a.n0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.X(new c(this, aVar, c.a.n0.t.d.D(new File(c.a.n0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.n0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.n0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String D = c.a.n0.t.d.D(new File(c.a.n0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.X(new e(this, bVar, D, valueCallback));
                return;
            }
            c.a.n0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.n0.a.h0.l.a aVar, c.a.n0.a.p.e.b<NgWebView> bVar, c.a.n0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0142f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.n0.a.h0.l.a aVar, c.a.n0.a.p.e.b<NgWebView> bVar, c.a.n0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.n0.a.h0.u.g.N().g0()) {
            c.a.n0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f4955e && this.f4954d && this.f4951a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.n0.a.h0.k.f b2 = c.a.n0.a.h0.u.g.N().X().b();
            this.f4951a = b2;
            b2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.n0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
            c.a.n0.a.h0.k.f fVar = this.f4951a;
            if (fVar != null) {
                fVar.b();
                this.f4951a = null;
            }
            f4950g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.n0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f4955e = true;
            this.f4952b = false;
            this.f4953c = false;
        }
    }

    public final void t(c.a.n0.a.o0.d.a aVar) {
        c.a.n0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (fVar = this.f4951a) == null) {
            return;
        }
        c.a.n0.a.o0.a.a(fVar.a(), aVar);
    }

    public final synchronized void u(c.a.n0.a.h0.l.a aVar, c.a.n0.a.p.e.b<NgWebView> bVar, c.a.n0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f4952b && this.f4953c) {
                    c.a.n0.a.e0.d.h("LocalDebugger", "startFirstPage");
                    q0.X(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
