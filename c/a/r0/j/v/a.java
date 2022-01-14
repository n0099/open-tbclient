package c.a.r0.j.v;

import android.content.Context;
import c.a.r0.a.z2.q0;
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
    public c.a.r0.a.l0.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.j.p0.f.a f11256b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11257c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.y.b.a f11258d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a.y.b.a f11259e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.a.y.b.a f11260f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.j.v.c f11261g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j.v.e.b f11262h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.j.v.e.a f11263i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.j.v.e.a f11264j;
    public c.a.r0.j.v.b k;
    public f l;

    /* renamed from: c.a.r0.j.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0775a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0775a(a aVar) {
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

        @Override // c.a.r0.j.v.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // c.a.r0.j.v.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.r0.j.v.e.b bVar = new c.a.r0.j.v.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                c.a.r0.j.n0.c.call(this.a.f11258d, true, bVar);
            }
        }

        @Override // c.a.r0.j.v.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.c(str);
        }

        @Override // c.a.r0.j.v.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.k == null) {
                return;
            }
            this.a.k.b(str);
        }

        @Override // c.a.r0.j.v.a.f
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
        public final /* synthetic */ a f11265e;

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
            this.f11265e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.r0.j.p0.f.b.p().n(this.f11265e.f11256b)) {
                    this.f11265e.f11262h.errMsg = "showKeyboard:fail";
                    c.a.r0.j.n0.c.call(this.f11265e.f11258d, false, this.f11265e.f11262h);
                    return;
                }
                this.f11265e.f11256b.j(this.f11265e.f11261g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11266e;

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
            this.f11266e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.r0.j.p0.f.b.p().s(this.f11266e.f11256b)) {
                    this.f11266e.f11263i.errMsg = "hideKeyboard:ok";
                    c.a.r0.j.n0.c.call(this.f11266e.f11259e, true, this.f11266e.f11263i);
                    return;
                }
                this.f11266e.f11263i.errMsg = "hideKeyboard:fail";
                c.a.r0.j.n0.c.call(this.f11266e.f11259e, false, this.f11266e.f11263i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11267e;

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
            this.f11267e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.j.p0.f.b.p().s(this.f11267e.f11256b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11269f;

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
            this.f11269f = aVar;
            this.f11268e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11269f.f11256b.m(this.f11268e)) {
                    this.f11269f.f11264j.errMsg = "updateKeyboard:ok";
                    c.a.r0.j.n0.c.call(this.f11269f.f11260f, true, this.f11269f.f11264j);
                    return;
                }
                this.f11269f.f11264j.errMsg = "updateKeyboard:fail";
                c.a.r0.j.n0.c.call(this.f11269f.f11260f, false, this.f11269f.f11264j);
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

    public a(c.a.r0.a.l0.c cVar, c.a.r0.j.v.b bVar) {
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
        this.l = new C0775a(this);
        this.a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f11257c = appContext;
        c.a.r0.j.p0.f.a aVar = new c.a.r0.j.p0.f.a(appContext);
        this.f11256b = aVar;
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
        c.a.r0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f11263i = new c.a.r0.j.v.e.a();
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            this.f11259e = F;
            if (F == null) {
                this.f11259e = new c.a.r0.a.y.b.a();
            }
            if (this.a != null && (aVar = this.f11256b) != null && aVar.g()) {
                q0.e0(new c(this));
                return;
            }
            c.a.r0.j.v.e.a aVar2 = this.f11263i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.r0.j.n0.c.call(this.f11259e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.r0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f11262h = new c.a.r0.j.v.e.b();
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            this.f11258d = F;
            if (F == null) {
                this.f11258d = new c.a.r0.a.y.b.a();
            }
            if (this.a != null && (aVar = this.f11256b) != null && !aVar.g()) {
                c.a.r0.j.v.c cVar = new c.a.r0.j.v.c();
                this.f11261g = cVar;
                try {
                    if (cVar.a(this.f11258d)) {
                        q0.f0(new b(this), 500L);
                    } else {
                        this.f11262h.errMsg = "showKeyboard:fail";
                        c.a.r0.j.n0.c.call(this.f11258d, false, this.f11262h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.r0.j.v.e.b bVar = this.f11262h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.r0.j.n0.c.call(this.f11258d, false, bVar);
                    return;
                }
            }
            c.a.r0.j.v.e.b bVar2 = this.f11262h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.r0.j.n0.c.call(this.f11258d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f11264j = new c.a.r0.j.v.e.a();
            c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObject);
            this.f11260f = F;
            if (F == null) {
                this.f11260f = new c.a.r0.a.y.b.a();
            }
            if (this.a != null && this.f11256b != null) {
                q0.e0(new e(this, this.f11260f.B("value")));
                return;
            }
            c.a.r0.j.v.e.a aVar = this.f11264j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.r0.j.n0.c.call(this.f11260f, false, aVar);
        }
    }
}
