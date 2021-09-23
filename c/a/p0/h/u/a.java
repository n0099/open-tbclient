package c.a.p0.h.u;

import android.content.Context;
import c.a.p0.a.v2.q0;
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
    public c.a.p0.a.l0.c f11555a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.h.o0.f.a f11556b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11557c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.y.b.a f11558d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.y.b.a f11559e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.y.b.a f11560f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.h.u.c f11561g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.h.u.e.b f11562h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.h.u.e.a f11563i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.h.u.e.a f11564j;
    public c.a.p0.h.u.b k;
    public f l;

    /* renamed from: c.a.p0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0597a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11565a;

        public C0597a(a aVar) {
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
            this.f11565a = aVar;
        }

        @Override // c.a.p0.h.u.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11565a.j();
            }
        }

        @Override // c.a.p0.h.u.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.p0.h.u.e.b bVar = new c.a.p0.h.u.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                c.a.p0.h.m0.c.a(this.f11565a.f11558d, true, bVar);
            }
        }

        @Override // c.a.p0.h.u.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f11565a.k == null) {
                return;
            }
            this.f11565a.k.c(str);
        }

        @Override // c.a.p0.h.u.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f11565a.k == null) {
                return;
            }
            this.f11565a.k.b(str);
        }

        @Override // c.a.p0.h.u.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f11565a.k == null) {
                return;
            }
            this.f11565a.k.d(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11566e;

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
            this.f11566e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.p0.h.o0.f.b.p().n(this.f11566e.f11556b)) {
                    this.f11566e.f11562h.errMsg = "showKeyboard:fail";
                    c.a.p0.h.m0.c.a(this.f11566e.f11558d, false, this.f11566e.f11562h);
                    return;
                }
                this.f11566e.f11556b.j(this.f11566e.f11561g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11567e;

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
            this.f11567e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.p0.h.o0.f.b.p().s(this.f11567e.f11556b)) {
                    this.f11567e.f11563i.errMsg = "hideKeyboard:ok";
                    c.a.p0.h.m0.c.a(this.f11567e.f11559e, true, this.f11567e.f11563i);
                    return;
                }
                this.f11567e.f11563i.errMsg = "hideKeyboard:fail";
                c.a.p0.h.m0.c.a(this.f11567e.f11559e, false, this.f11567e.f11563i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11568e;

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
            this.f11568e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.h.o0.f.b.p().s(this.f11568e.f11556b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11569e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11570f;

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
            this.f11570f = aVar;
            this.f11569e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11570f.f11556b.m(this.f11569e)) {
                    this.f11570f.f11564j.errMsg = "updateKeyboard:ok";
                    c.a.p0.h.m0.c.a(this.f11570f.f11560f, true, this.f11570f.f11564j);
                    return;
                }
                this.f11570f.f11564j.errMsg = "updateKeyboard:fail";
                c.a.p0.h.m0.c.a(this.f11570f.f11560f, false, this.f11570f.f11564j);
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

    public a(c.a.p0.a.l0.c cVar, c.a.p0.h.u.b bVar) {
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
        this.l = new C0597a(this);
        this.f11555a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f11557c = appContext;
        c.a.p0.h.o0.f.a aVar = new c.a.p0.h.o0.f.a(appContext);
        this.f11556b = aVar;
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
        c.a.p0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f11563i = new c.a.p0.h.u.e.a();
            c.a.p0.a.y.b.a G = c.a.p0.a.y.b.a.G(jsObject);
            this.f11559e = G;
            if (G == null) {
                this.f11559e = new c.a.p0.a.y.b.a();
            }
            if (this.f11555a != null && (aVar = this.f11556b) != null && aVar.g()) {
                q0.b0(new c(this));
                return;
            }
            c.a.p0.h.u.e.a aVar2 = this.f11563i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.p0.h.m0.c.a(this.f11559e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.p0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f11562h = new c.a.p0.h.u.e.b();
            c.a.p0.a.y.b.a G = c.a.p0.a.y.b.a.G(jsObject);
            this.f11558d = G;
            if (G == null) {
                this.f11558d = new c.a.p0.a.y.b.a();
            }
            if (this.f11555a != null && (aVar = this.f11556b) != null && !aVar.g()) {
                c.a.p0.h.u.c cVar = new c.a.p0.h.u.c();
                this.f11561g = cVar;
                try {
                    if (cVar.a(this.f11558d)) {
                        q0.c0(new b(this), 500L);
                    } else {
                        this.f11562h.errMsg = "showKeyboard:fail";
                        c.a.p0.h.m0.c.a(this.f11558d, false, this.f11562h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.p0.h.u.e.b bVar = this.f11562h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.p0.h.m0.c.a(this.f11558d, false, bVar);
                    return;
                }
            }
            c.a.p0.h.u.e.b bVar2 = this.f11562h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.p0.h.m0.c.a(this.f11558d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f11564j = new c.a.p0.h.u.e.a();
            c.a.p0.a.y.b.a G = c.a.p0.a.y.b.a.G(jsObject);
            this.f11560f = G;
            if (G == null) {
                this.f11560f = new c.a.p0.a.y.b.a();
            }
            if (this.f11555a != null && this.f11556b != null) {
                q0.b0(new e(this, this.f11560f.C("value")));
                return;
            }
            c.a.p0.h.u.e.a aVar = this.f11564j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.p0.h.m0.c.a(this.f11560f, false, aVar);
        }
    }
}
