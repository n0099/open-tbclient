package c.a.p0.j.v;

import android.content.Context;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.l0.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.j.p0.f.a f10469b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10470c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.y.b.a f10471d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.y.b.a f10472e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.y.b.a f10473f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.j.v.c f10474g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.j.v.e.b f10475h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.j.v.e.a f10476i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.j.v.e.a f10477j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.p0.j.v.b f10478k;
    public f l;

    /* renamed from: c.a.p0.j.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0682a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0682a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.p0.j.v.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // c.a.p0.j.v.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.p0.j.v.e.b bVar = new c.a.p0.j.v.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                c.a.p0.j.n0.c.call(this.a.f10471d, true, bVar);
            }
        }

        @Override // c.a.p0.j.v.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.f10478k == null) {
                return;
            }
            this.a.f10478k.c(str);
        }

        @Override // c.a.p0.j.v.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.f10478k == null) {
                return;
            }
            this.a.f10478k.b(str);
        }

        @Override // c.a.p0.j.v.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.a.f10478k == null) {
                return;
            }
            this.a.f10478k.d(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10479e;

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
            this.f10479e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.p0.j.p0.f.b.p().n(this.f10479e.f10469b)) {
                    this.f10479e.f10475h.errMsg = "showKeyboard:fail";
                    c.a.p0.j.n0.c.call(this.f10479e.f10471d, false, this.f10479e.f10475h);
                    return;
                }
                this.f10479e.f10469b.j(this.f10479e.f10474g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10480e;

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
            this.f10480e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.p0.j.p0.f.b.p().s(this.f10480e.f10469b)) {
                    this.f10480e.f10476i.errMsg = "hideKeyboard:ok";
                    c.a.p0.j.n0.c.call(this.f10480e.f10472e, true, this.f10480e.f10476i);
                    return;
                }
                this.f10480e.f10476i.errMsg = "hideKeyboard:fail";
                c.a.p0.j.n0.c.call(this.f10480e.f10472e, false, this.f10480e.f10476i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10481e;

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
            this.f10481e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.j.p0.f.b.p().s(this.f10481e.f10469b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10483f;

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
            this.f10483f = aVar;
            this.f10482e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10483f.f10469b.m(this.f10482e)) {
                    this.f10483f.f10477j.errMsg = "updateKeyboard:ok";
                    c.a.p0.j.n0.c.call(this.f10483f.f10473f, true, this.f10483f.f10477j);
                    return;
                }
                this.f10483f.f10477j.errMsg = "updateKeyboard:fail";
                c.a.p0.j.n0.c.call(this.f10483f.f10473f, false, this.f10483f.f10477j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(c.a.p0.a.l0.c cVar, c.a.p0.j.v.b bVar) {
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
        this.f10478k = null;
        this.l = new C0682a(this);
        this.a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f10470c = appContext;
        c.a.p0.j.p0.f.a aVar = new c.a.p0.j.p0.f.a(appContext);
        this.f10469b = aVar;
        aVar.i(this.l);
        this.f10478k = bVar;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q0.e0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        c.a.p0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f10476i = new c.a.p0.j.v.e.a();
            c.a.p0.a.y.b.a F = c.a.p0.a.y.b.a.F(jsObject);
            this.f10472e = F;
            if (F == null) {
                this.f10472e = new c.a.p0.a.y.b.a();
            }
            if (this.a != null && (aVar = this.f10469b) != null && aVar.g()) {
                q0.e0(new c(this));
                return;
            }
            c.a.p0.j.v.e.a aVar2 = this.f10476i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.p0.j.n0.c.call(this.f10472e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.p0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f10475h = new c.a.p0.j.v.e.b();
            c.a.p0.a.y.b.a F = c.a.p0.a.y.b.a.F(jsObject);
            this.f10471d = F;
            if (F == null) {
                this.f10471d = new c.a.p0.a.y.b.a();
            }
            if (this.a != null && (aVar = this.f10469b) != null && !aVar.g()) {
                c.a.p0.j.v.c cVar = new c.a.p0.j.v.c();
                this.f10474g = cVar;
                try {
                    if (cVar.a(this.f10471d)) {
                        q0.f0(new b(this), 500L);
                    } else {
                        this.f10475h.errMsg = "showKeyboard:fail";
                        c.a.p0.j.n0.c.call(this.f10471d, false, this.f10475h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.p0.j.v.e.b bVar = this.f10475h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.p0.j.n0.c.call(this.f10471d, false, bVar);
                    return;
                }
            }
            c.a.p0.j.v.e.b bVar2 = this.f10475h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.p0.j.n0.c.call(this.f10471d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f10477j = new c.a.p0.j.v.e.a();
            c.a.p0.a.y.b.a F = c.a.p0.a.y.b.a.F(jsObject);
            this.f10473f = F;
            if (F == null) {
                this.f10473f = new c.a.p0.a.y.b.a();
            }
            if (this.a != null && this.f10469b != null) {
                q0.e0(new e(this, this.f10473f.B("value")));
                return;
            }
            c.a.p0.j.v.e.a aVar = this.f10477j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.p0.j.n0.c.call(this.f10473f, false, aVar);
        }
    }
}
