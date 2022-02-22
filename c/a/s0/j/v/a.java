package c.a.s0.j.v;

import android.content.Context;
import c.a.s0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.a.l0.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.j.p0.f.a f11498b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11499c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.a.y.b.a f11500d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.a.y.b.a f11501e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.a.y.b.a f11502f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.j.v.c f11503g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.j.v.e.b f11504h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.j.v.e.a f11505i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.j.v.e.a f11506j;
    public c.a.s0.j.v.b k;
    public f l;

    /* renamed from: c.a.s0.j.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0795a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0795a(a aVar) {
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

        @Override // c.a.s0.j.v.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // c.a.s0.j.v.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.s0.j.v.e.b bVar = new c.a.s0.j.v.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                c.a.s0.j.n0.c.call(this.a.f11500d, true, bVar);
            }
        }

        @Override // c.a.s0.j.v.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.c(str);
        }

        @Override // c.a.s0.j.v.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.b(str);
        }

        @Override // c.a.s0.j.v.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.d(str);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11507e;

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
            this.f11507e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.s0.j.p0.f.b.p().n(this.f11507e.f11498b)) {
                    this.f11507e.f11504h.errMsg = "showKeyboard:fail";
                    c.a.s0.j.n0.c.call(this.f11507e.f11500d, false, this.f11507e.f11504h);
                    return;
                }
                this.f11507e.f11498b.j(this.f11507e.f11503g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11508e;

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
            this.f11508e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.s0.j.p0.f.b.p().s(this.f11508e.f11498b)) {
                    this.f11508e.f11505i.errMsg = "hideKeyboard:ok";
                    c.a.s0.j.n0.c.call(this.f11508e.f11501e, true, this.f11508e.f11505i);
                    return;
                }
                this.f11508e.f11505i.errMsg = "hideKeyboard:fail";
                c.a.s0.j.n0.c.call(this.f11508e.f11501e, false, this.f11508e.f11505i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11509e;

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
            this.f11509e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.j.p0.f.b.p().s(this.f11509e.f11498b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11510e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11511f;

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
            this.f11511f = aVar;
            this.f11510e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11511f.f11498b.m(this.f11510e)) {
                    this.f11511f.f11506j.errMsg = "updateKeyboard:ok";
                    c.a.s0.j.n0.c.call(this.f11511f.f11502f, true, this.f11511f.f11506j);
                    return;
                }
                this.f11511f.f11506j.errMsg = "updateKeyboard:fail";
                c.a.s0.j.n0.c.call(this.f11511f.f11502f, false, this.f11511f.f11506j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(c.a.s0.a.l0.c cVar, c.a.s0.j.v.b bVar) {
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
        this.l = new C0795a(this);
        this.a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f11499c = appContext;
        c.a.s0.j.p0.f.a aVar = new c.a.s0.j.p0.f.a(appContext);
        this.f11498b = aVar;
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
        c.a.s0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f11505i = new c.a.s0.j.v.e.a();
            c.a.s0.a.y.b.a F = c.a.s0.a.y.b.a.F(jsObject);
            this.f11501e = F;
            if (F == null) {
                this.f11501e = new c.a.s0.a.y.b.a();
            }
            if (this.a != null && (aVar = this.f11498b) != null && aVar.g()) {
                q0.e0(new c(this));
                return;
            }
            c.a.s0.j.v.e.a aVar2 = this.f11505i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.s0.j.n0.c.call(this.f11501e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.s0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f11504h = new c.a.s0.j.v.e.b();
            c.a.s0.a.y.b.a F = c.a.s0.a.y.b.a.F(jsObject);
            this.f11500d = F;
            if (F == null) {
                this.f11500d = new c.a.s0.a.y.b.a();
            }
            if (this.a != null && (aVar = this.f11498b) != null && !aVar.g()) {
                c.a.s0.j.v.c cVar = new c.a.s0.j.v.c();
                this.f11503g = cVar;
                try {
                    if (cVar.a(this.f11500d)) {
                        q0.f0(new b(this), 500L);
                    } else {
                        this.f11504h.errMsg = "showKeyboard:fail";
                        c.a.s0.j.n0.c.call(this.f11500d, false, this.f11504h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.s0.j.v.e.b bVar = this.f11504h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.s0.j.n0.c.call(this.f11500d, false, bVar);
                    return;
                }
            }
            c.a.s0.j.v.e.b bVar2 = this.f11504h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.s0.j.n0.c.call(this.f11500d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f11506j = new c.a.s0.j.v.e.a();
            c.a.s0.a.y.b.a F = c.a.s0.a.y.b.a.F(jsObject);
            this.f11502f = F;
            if (F == null) {
                this.f11502f = new c.a.s0.a.y.b.a();
            }
            if (this.a != null && this.f11498b != null) {
                q0.e0(new e(this, this.f11502f.B("value")));
                return;
            }
            c.a.s0.j.v.e.a aVar = this.f11506j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.s0.j.n0.c.call(this.f11502f, false, aVar);
        }
    }
}
