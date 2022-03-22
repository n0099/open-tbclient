package c.a.n0.j.v;

import android.content.Context;
import c.a.n0.a.p2.q0;
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
    public c.a.n0.a.b0.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.j.p0.f.a f8939b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8940c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.o.b.a f8941d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.a.o.b.a f8942e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.o.b.a f8943f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.j.v.c f8944g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.j.v.e.b f8945h;
    public c.a.n0.j.v.e.a i;
    public c.a.n0.j.v.e.a j;
    public c.a.n0.j.v.b k;
    public f l;

    /* renamed from: c.a.n0.j.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0735a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0735a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.j.v.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // c.a.n0.j.v.a.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                c.a.n0.j.v.e.b bVar = new c.a.n0.j.v.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i;
                c.a.n0.j.n0.c.call(this.a.f8941d, true, bVar);
            }
        }

        @Override // c.a.n0.j.v.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.c(str);
        }

        @Override // c.a.n0.j.v.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.b(str);
        }

        @Override // c.a.n0.j.v.a.f
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
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.n0.j.p0.f.b.p().n(this.a.f8939b)) {
                    this.a.f8945h.errMsg = "showKeyboard:fail";
                    c.a.n0.j.n0.c.call(this.a.f8941d, false, this.a.f8945h);
                    return;
                }
                this.a.f8939b.j(this.a.f8944g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.n0.j.p0.f.b.p().s(this.a.f8939b)) {
                    this.a.i.errMsg = "hideKeyboard:ok";
                    c.a.n0.j.n0.c.call(this.a.f8942e, true, this.a.i);
                    return;
                }
                this.a.i.errMsg = "hideKeyboard:fail";
                c.a.n0.j.n0.c.call(this.a.f8942e, false, this.a.i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.j.p0.f.b.p().s(this.a.f8939b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8946b;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8946b = aVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8946b.f8939b.m(this.a)) {
                    this.f8946b.j.errMsg = "updateKeyboard:ok";
                    c.a.n0.j.n0.c.call(this.f8946b.f8943f, true, this.f8946b.j);
                    return;
                }
                this.f8946b.j.errMsg = "updateKeyboard:fail";
                c.a.n0.j.n0.c.call(this.f8946b.f8943f, false, this.f8946b.j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b(int i);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(c.a.n0.a.b0.c cVar, c.a.n0.j.v.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = new C0735a(this);
        this.a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f8940c = appContext;
        c.a.n0.j.p0.f.a aVar = new c.a.n0.j.p0.f.a(appContext);
        this.f8939b = aVar;
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
        c.a.n0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.i = new c.a.n0.j.v.e.a();
            c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
            this.f8942e = F;
            if (F == null) {
                this.f8942e = new c.a.n0.a.o.b.a();
            }
            if (this.a != null && (aVar = this.f8939b) != null && aVar.g()) {
                q0.e0(new c(this));
                return;
            }
            c.a.n0.j.v.e.a aVar2 = this.i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.n0.j.n0.c.call(this.f8942e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.n0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f8945h = new c.a.n0.j.v.e.b();
            c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
            this.f8941d = F;
            if (F == null) {
                this.f8941d = new c.a.n0.a.o.b.a();
            }
            if (this.a != null && (aVar = this.f8939b) != null && !aVar.g()) {
                c.a.n0.j.v.c cVar = new c.a.n0.j.v.c();
                this.f8944g = cVar;
                try {
                    if (cVar.a(this.f8941d)) {
                        q0.f0(new b(this), 500L);
                    } else {
                        this.f8945h.errMsg = "showKeyboard:fail";
                        c.a.n0.j.n0.c.call(this.f8941d, false, this.f8945h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.n0.j.v.e.b bVar = this.f8945h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.n0.j.n0.c.call(this.f8941d, false, bVar);
                    return;
                }
            }
            c.a.n0.j.v.e.b bVar2 = this.f8945h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.n0.j.n0.c.call(this.f8941d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new c.a.n0.j.v.e.a();
            c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
            this.f8943f = F;
            if (F == null) {
                this.f8943f = new c.a.n0.a.o.b.a();
            }
            if (this.a != null && this.f8939b != null) {
                q0.e0(new e(this, this.f8943f.B("value")));
                return;
            }
            c.a.n0.j.v.e.a aVar = this.j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.n0.j.n0.c.call(this.f8943f, false, aVar);
        }
    }
}
