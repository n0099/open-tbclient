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
    public static final boolean f5231f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f5232g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.a.h0.k.f f5233a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5234b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5235c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5236d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f5237e;

    /* loaded from: classes.dex */
    public class a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5238a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5239b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5240c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5241d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5242e;

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
            this.f5242e = fVar;
            this.f5238a = bVar;
            this.f5239b = aVar;
            this.f5240c = bVar2;
            this.f5241d = gVar;
        }

        @Override // c.a.p0.a.l0.j
        public void a(c.a.p0.a.l0.a aVar) {
            c.a.p0.a.o0.d.b j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5242e.f5236d = true;
                c.a.p0.a.e0.f.d.d.e().f("loaddebug");
                c.a.p0.a.e0.d.h("LocalDebugger", "prepareDaemon finish.");
                this.f5242e.t(this.f5242e.j(this.f5238a));
                if (f.f5231f) {
                    String str = "debugInitMsg - " + j2.g().toString();
                }
                this.f5242e.n(this.f5239b, this.f5240c, this.f5238a, this.f5241d);
                this.f5242e.p(this.f5239b, this.f5240c, this.f5238a, this.f5241d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5243a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5244b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5245c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5246d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5247e;

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
            this.f5247e = fVar;
            this.f5243a = aVar;
            this.f5244b = bVar;
            this.f5245c = bVar2;
            this.f5246d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5231f) {
                    String str2 = "master onReceiveValue: " + str;
                }
                this.f5247e.f5234b = true;
                this.f5247e.u(this.f5243a, this.f5244b, this.f5245c, this.f5246d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5249f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5250g;

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
            this.f5248e = aVar;
            this.f5249f = str;
            this.f5250g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5248e.g().evaluateJavascript(this.f5249f, this.f5250g);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && f.f5231f) {
                String str2 = "slave onReceiveValue: " + str;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5251e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5252f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f5253g;

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
            this.f5251e = bVar;
            this.f5252f = str;
            this.f5253g = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((NgWebView) this.f5251e.t()).evaluateJavascript(this.f5252f, this.f5253g);
            }
        }
    }

    /* renamed from: c.a.p0.a.e0.f.d.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0152f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5254a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5256c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e.g f5257d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5258e;

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
            this.f5258e = fVar;
            this.f5254a = aVar;
            this.f5255b = bVar;
            this.f5256c = bVar2;
            this.f5257d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (f.f5231f) {
                    String str2 = "slave onReceiveValue: " + str;
                }
                this.f5258e.f5235c = true;
                this.f5258e.u(this.f5254a, this.f5255b, this.f5256c, this.f5257d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.l.a f5259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p.e.b f5260f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f5261g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e.g f5262h;

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
            this.f5259e = aVar;
            this.f5260f = bVar;
            this.f5261g = bVar2;
            this.f5262h = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.c2.f.p0.c.a(this.f5259e, this.f5260f, this.f5261g, this.f5262h);
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
        f5231f = k.f7085a;
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
        this.f5234b = false;
        this.f5235c = false;
        this.f5236d = false;
        this.f5237e = false;
    }

    public static f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f5232g == null) {
                synchronized (f.class) {
                    if (f5232g == null) {
                        f5232g = new f();
                    }
                }
            }
            return f5232g;
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
            c.a.p0.a.h0.k.f fVar = this.f5233a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5237e : invokeV.booleanValue;
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
            if (this.f5237e && this.f5236d && this.f5233a != null) {
                n(aVar, bVar, bVar2, gVar);
                p(aVar, bVar, bVar2, gVar);
                return;
            }
            c.a.p0.a.h0.k.f b2 = c.a.p0.a.h0.u.g.N().X().b();
            this.f5233a = b2;
            b2.c(new a(this, bVar2, aVar, bVar, gVar));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.p0.a.e0.d.h("LocalDebugger", "releaseLocalDebugger");
            c.a.p0.a.h0.k.f fVar = this.f5233a;
            if (fVar != null) {
                fVar.b();
                this.f5233a = null;
            }
            f5232g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c.a.p0.a.e0.d.h("LocalDebugger", "resetMasterAndSlaveStatus");
            this.f5237e = true;
            this.f5234b = false;
            this.f5235c = false;
        }
    }

    public final void t(c.a.p0.a.o0.d.a aVar) {
        c.a.p0.a.h0.k.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (fVar = this.f5233a) == null) {
            return;
        }
        c.a.p0.a.o0.a.a(fVar.a(), aVar);
    }

    public final synchronized void u(c.a.p0.a.h0.l.a aVar, c.a.p0.a.p.e.b<NgWebView> bVar, c.a.p0.a.f1.e.b<b.a> bVar2, e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, aVar, bVar, bVar2, gVar) == null) {
            synchronized (this) {
                if (this.f5234b && this.f5235c) {
                    c.a.p0.a.e0.d.h("LocalDebugger", "startFirstPage");
                    q0.X(new g(this, aVar, bVar, bVar2, gVar));
                }
            }
        }
    }
}
