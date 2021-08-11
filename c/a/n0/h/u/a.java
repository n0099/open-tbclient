package c.a.n0.h.u;

import android.content.Context;
import c.a.n0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.n0.a.l0.c f11273a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.h.o0.f.a f11274b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11275c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.y.b.a f11276d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.y.b.a f11277e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.y.b.a f11278f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.h.u.c f11279g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.h.u.e.b f11280h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.n0.h.u.e.a f11281i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.n0.h.u.e.a f11282j;
    public c.a.n0.h.u.b k;
    public f l;

    /* renamed from: c.a.n0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0587a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11283a;

        public C0587a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11283a = aVar;
        }

        @Override // c.a.n0.h.u.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11283a.j();
            }
        }

        @Override // c.a.n0.h.u.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.n0.h.u.e.b bVar = new c.a.n0.h.u.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                c.a.n0.h.m0.c.a(this.f11283a.f11276d, true, bVar);
            }
        }

        @Override // c.a.n0.h.u.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f11283a.k == null) {
                return;
            }
            this.f11283a.k.c(str);
        }

        @Override // c.a.n0.h.u.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f11283a.k == null) {
                return;
            }
            this.f11283a.k.b(str);
        }

        @Override // c.a.n0.h.u.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f11283a.k == null) {
                return;
            }
            this.f11283a.k.d(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11284e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11284e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.n0.h.o0.f.b.p().n(this.f11284e.f11274b)) {
                    this.f11284e.f11280h.errMsg = "showKeyboard:fail";
                    c.a.n0.h.m0.c.a(this.f11284e.f11276d, false, this.f11284e.f11280h);
                    return;
                }
                this.f11284e.f11274b.j(this.f11284e.f11279g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11285e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11285e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.n0.h.o0.f.b.p().s(this.f11285e.f11274b)) {
                    this.f11285e.f11281i.errMsg = "hideKeyboard:ok";
                    c.a.n0.h.m0.c.a(this.f11285e.f11277e, true, this.f11285e.f11281i);
                    return;
                }
                this.f11285e.f11281i.errMsg = "hideKeyboard:fail";
                c.a.n0.h.m0.c.a(this.f11285e.f11277e, false, this.f11285e.f11281i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11286e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11286e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.h.o0.f.b.p().s(this.f11286e.f11274b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11287e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11288f;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11288f = aVar;
            this.f11287e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11288f.f11274b.m(this.f11287e)) {
                    this.f11288f.f11282j.errMsg = "updateKeyboard:ok";
                    c.a.n0.h.m0.c.a(this.f11288f.f11278f, true, this.f11288f.f11282j);
                    return;
                }
                this.f11288f.f11282j.errMsg = "updateKeyboard:fail";
                c.a.n0.h.m0.c.a(this.f11288f.f11278f, false, this.f11288f.f11282j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(c.a.n0.a.l0.c cVar, c.a.n0.h.u.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = new C0587a(this);
        this.f11273a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f11275c = appContext;
        c.a.n0.h.o0.f.a aVar = new c.a.n0.h.o0.f.a(appContext);
        this.f11274b = aVar;
        aVar.i(this.l);
        this.k = bVar;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q0.b0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        c.a.n0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f11281i = new c.a.n0.h.u.e.a();
            c.a.n0.a.y.b.a G = c.a.n0.a.y.b.a.G(jsObject);
            this.f11277e = G;
            if (G == null) {
                this.f11277e = new c.a.n0.a.y.b.a();
            }
            if (this.f11273a != null && (aVar = this.f11274b) != null && aVar.g()) {
                q0.b0(new c(this));
                return;
            }
            c.a.n0.h.u.e.a aVar2 = this.f11281i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.n0.h.m0.c.a(this.f11277e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.n0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f11280h = new c.a.n0.h.u.e.b();
            c.a.n0.a.y.b.a G = c.a.n0.a.y.b.a.G(jsObject);
            this.f11276d = G;
            if (G == null) {
                this.f11276d = new c.a.n0.a.y.b.a();
            }
            if (this.f11273a != null && (aVar = this.f11274b) != null && !aVar.g()) {
                c.a.n0.h.u.c cVar = new c.a.n0.h.u.c();
                this.f11279g = cVar;
                try {
                    if (cVar.a(this.f11276d)) {
                        q0.c0(new b(this), 500L);
                    } else {
                        this.f11280h.errMsg = "showKeyboard:fail";
                        c.a.n0.h.m0.c.a(this.f11276d, false, this.f11280h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.n0.h.u.e.b bVar = this.f11280h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.n0.h.m0.c.a(this.f11276d, false, bVar);
                    return;
                }
            }
            c.a.n0.h.u.e.b bVar2 = this.f11280h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.n0.h.m0.c.a(this.f11276d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f11282j = new c.a.n0.h.u.e.a();
            c.a.n0.a.y.b.a G = c.a.n0.a.y.b.a.G(jsObject);
            this.f11278f = G;
            if (G == null) {
                this.f11278f = new c.a.n0.a.y.b.a();
            }
            if (this.f11273a != null && this.f11274b != null) {
                q0.b0(new e(this, this.f11278f.C("value")));
                return;
            }
            c.a.n0.h.u.e.a aVar = this.f11282j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.n0.h.m0.c.a(this.f11278f, false, aVar);
        }
    }
}
