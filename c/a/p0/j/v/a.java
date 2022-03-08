package c.a.p0.j.v;

import android.content.Context;
import c.a.p0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.b0.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.j.p0.f.a f10723b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10724c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.o.b.a f10725d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.o.b.a f10726e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.o.b.a f10727f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.j.v.c f10728g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.j.v.e.b f10729h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.j.v.e.a f10730i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.j.v.e.a f10731j;
    public c.a.p0.j.v.b k;
    public f l;

    /* renamed from: c.a.p0.j.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0740a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0740a(a aVar) {
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
                c.a.p0.j.n0.c.call(this.a.f10725d, true, bVar);
            }
        }

        @Override // c.a.p0.j.v.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.c(str);
        }

        @Override // c.a.p0.j.v.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.b(str);
        }

        @Override // c.a.p0.j.v.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.d(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10732e;

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
            this.f10732e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.p0.j.p0.f.b.p().n(this.f10732e.f10723b)) {
                    this.f10732e.f10729h.errMsg = "showKeyboard:fail";
                    c.a.p0.j.n0.c.call(this.f10732e.f10725d, false, this.f10732e.f10729h);
                    return;
                }
                this.f10732e.f10723b.j(this.f10732e.f10728g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10733e;

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
            this.f10733e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.p0.j.p0.f.b.p().s(this.f10733e.f10723b)) {
                    this.f10733e.f10730i.errMsg = "hideKeyboard:ok";
                    c.a.p0.j.n0.c.call(this.f10733e.f10726e, true, this.f10733e.f10730i);
                    return;
                }
                this.f10733e.f10730i.errMsg = "hideKeyboard:fail";
                c.a.p0.j.n0.c.call(this.f10733e.f10726e, false, this.f10733e.f10730i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10734e;

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
            this.f10734e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.j.p0.f.b.p().s(this.f10734e.f10723b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10736f;

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
            this.f10736f = aVar;
            this.f10735e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10736f.f10723b.m(this.f10735e)) {
                    this.f10736f.f10731j.errMsg = "updateKeyboard:ok";
                    c.a.p0.j.n0.c.call(this.f10736f.f10727f, true, this.f10736f.f10731j);
                    return;
                }
                this.f10736f.f10731j.errMsg = "updateKeyboard:fail";
                c.a.p0.j.n0.c.call(this.f10736f.f10727f, false, this.f10736f.f10731j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(c.a.p0.a.b0.c cVar, c.a.p0.j.v.b bVar) {
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
        this.l = new C0740a(this);
        this.a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f10724c = appContext;
        c.a.p0.j.p0.f.a aVar = new c.a.p0.j.p0.f.a(appContext);
        this.f10723b = aVar;
        aVar.i(this.l);
        this.k = bVar;
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
            this.f10730i = new c.a.p0.j.v.e.a();
            c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
            this.f10726e = F;
            if (F == null) {
                this.f10726e = new c.a.p0.a.o.b.a();
            }
            if (this.a != null && (aVar = this.f10723b) != null && aVar.g()) {
                q0.e0(new c(this));
                return;
            }
            c.a.p0.j.v.e.a aVar2 = this.f10730i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.p0.j.n0.c.call(this.f10726e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.p0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f10729h = new c.a.p0.j.v.e.b();
            c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
            this.f10725d = F;
            if (F == null) {
                this.f10725d = new c.a.p0.a.o.b.a();
            }
            if (this.a != null && (aVar = this.f10723b) != null && !aVar.g()) {
                c.a.p0.j.v.c cVar = new c.a.p0.j.v.c();
                this.f10728g = cVar;
                try {
                    if (cVar.a(this.f10725d)) {
                        q0.f0(new b(this), 500L);
                    } else {
                        this.f10729h.errMsg = "showKeyboard:fail";
                        c.a.p0.j.n0.c.call(this.f10725d, false, this.f10729h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.p0.j.v.e.b bVar = this.f10729h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.p0.j.n0.c.call(this.f10725d, false, bVar);
                    return;
                }
            }
            c.a.p0.j.v.e.b bVar2 = this.f10729h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.p0.j.n0.c.call(this.f10725d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f10731j = new c.a.p0.j.v.e.a();
            c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
            this.f10727f = F;
            if (F == null) {
                this.f10727f = new c.a.p0.a.o.b.a();
            }
            if (this.a != null && this.f10723b != null) {
                q0.e0(new e(this, this.f10727f.B("value")));
                return;
            }
            c.a.p0.j.v.e.a aVar = this.f10731j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.p0.j.n0.c.call(this.f10727f, false, aVar);
        }
    }
}
