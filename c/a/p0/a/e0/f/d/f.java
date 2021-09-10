package c.a.p0.a.e0.f.d;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.a1.e;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.k;
import c.a.p0.a.l0.j;
import c.a.p0.a.v2.q0;
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
    public static final boolean f5223f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f5224g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.a.h0.k.f f5225a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5226b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5227c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5228d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5229e;

    /* loaded from: classes.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5230a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5231b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5232c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5233d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5234e;

        public a(f fVar, c.a.p0.a.f1.e.b bVar, c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b bVar2, e.g gVar) {
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
            this.f5234e = fVar;
            this.f5230a = bVar;
            this.f5231b = aVar;
            this.f5232c = bVar2;
            this.f5233d = gVar;
        }

        @Override // c.a.p0.a.l0.j
        public void a(c.a.p0.a.l0.a aVar) {
            c.a.p0.a.o0.d.b j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5234e.f5228d = true;
                c.a.p0.a.e0.f.d.d.e().f("loaddebug");
                c.a.p0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
                this.f5234e.t(this.f5234e.j(this.f5230a));
                if (f.f5223f) {
                    String str = "debugInitMsg - " + j2.g().toString();
                }
                this.f5234e.n(this.f5231b, this.f5232c, this.f5230a, this.f5233d);
                this.f5234e.p(this.f5231b, this.f5232c, this.f5230a, this.f5233d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5235a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5236b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5237c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5238d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5239e;

        public b(f fVar, c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b bVar, c.a.p0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f5239e = fVar;
            this.f5235a = aVar;
            this.f5236b = bVar;
            this.f5237c = bVar2;
            this.f5238d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5223f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f5239e.f5226b = true;
                this.f5239e.u(this.f5235a, this.f5236b, this.f5237c, this.f5238d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5240e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5241f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5242g;

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
            this.f5240e = aVar;
            this.f5241f = str;
            this.f5242g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5240e.g().evaluateJavascript(this.f5241f, this.f5242g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f5223f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5244f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5245g;

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
            this.f5243e = bVar;
            this.f5244f = str;
            this.f5245g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((NgWebView) this.f5243e.t()).evaluateJavascript(this.f5244f, this.f5245g);
            }
        }
    }

    /* renamed from: c.a.p0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0152f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5246a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5247b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5248c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5249d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5250e;

        public C0152f(f fVar, c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b bVar, c.a.p0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f5250e = fVar;
            this.f5246a = aVar;
            this.f5247b = bVar;
            this.f5248c = bVar2;
            this.f5249d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5223f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f5250e.f5227c = true;
                this.f5250e.u(this.f5246a, this.f5247b, this.f5248c, this.f5249d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5251e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5252f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5253g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f5254h;

        public g(f fVar, c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b bVar, c.a.p0.a.f1.e.b bVar2, e.g gVar) {
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
            this.f5251e = aVar;
            this.f5252f = bVar;
            this.f5253g = bVar2;
            this.f5254h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.c2.f.p0.c.a(this.f5251e, this.f5252f, this.f5253g, this.f5254h);
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
        f5223f = k.f7077a;
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
        this.f5226b = false;
        this.f5227c = false;
        this.f5228d = false;
        this.f5229e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f5224g == null) {
                synchronized (f.class) {
                    if (f5224g == null) {
                        f5224g = new f();
                    }
                }
            }
            return f5224g;
        }
        return (f) invokeV.objValue;
    }

    public final c.a.p0.a.o0.d.b j(@NonNull c.a.p0.a.f1.e.b<b.a> bVar) {
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
            return new c.a.p0.a.o0.d.b("message", hashMap);
        }
        return (c.a.p0.a.o0.d.b) invokeL.objValue;
    }

    public c.a.p0.a.l0.a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.a.h0.k.f fVar = this.f5225a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5229e : invokeV.booleanValue;
    }

    public final void n(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<NgWebView> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, aVar, bVar, bVar2, gVar) == null) {
            if (aVar != null && aVar.g() != null) {
                q0.X(new c(this, aVar, c.a.p0.t.d.D(new File(c.a.p0.a.e0.f.d.b.e())), new b(this, aVar, bVar, bVar2, gVar)));
            } else {
                c.a.p0.a.e0.d.h("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(c.a.p0.a.p.e.b<NgWebView> bVar, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, valueCallback) == null) {
            if (bVar != null && bVar.t() != null) {
                String D = c.a.p0.t.d.D(new File(c.a.p0.a.e0.f.d.b.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                q0.X(new e(this, bVar, D, valueCallback));
                return;
            }
            c.a.p0.a.e0.d.h("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<NgWebView> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, aVar, bVar, bVar2, gVar) == null) {
            o(bVar, new C0152f(this, aVar, bVar, bVar2, gVar));
        }
    }

    public void q(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<NgWebView> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048582, this, aVar, bVar, bVar2, gVar) == null) && c.a.p0.a.h0.u.g.N().g0()) {
            c.a.p0.a.e0.d.h("LocalDebugger", "prepareDaemon start.");
            if (this.f5229e && this.f5228d && this.f5225a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.p0.a.h0.k.f b2 = c.a.p0.a.h0.u.g.N().X().b();
            this.f5225a = b2;
            b2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
            c.a.p0.a.h0.k.f fVar = this.f5225a;
            if (fVar != null) {
                fVar.b();
                this.f5225a = null;
            }
            f5224g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f5229e = true;
            this.f5226b = false;
            this.f5227c = false;
        }
    }

    public final void t(c.a.p0.a.o0.d.a aVar) {
        c.a.p0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (fVar = this.f5225a) == null) {
            return;
        }
        c.a.p0.a.o0.a.a(fVar.a(), aVar);
    }

    public final synchronized void u(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<NgWebView> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f5226b && this.f5227c) {
                    c.a.p0.a.e0.d.h("LocalDebugger", "startFirstPage");
                    q0.X(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
