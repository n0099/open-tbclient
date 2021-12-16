package c.a.q0.j.v;

import android.content.Context;
import c.a.q0.a.z2.q0;
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
    public c.a.q0.a.l0.c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.j.p0.f.a f10778b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10779c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.a.y.b.a f10780d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.a.y.b.a f10781e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.a.y.b.a f10782f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.j.v.c f10783g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.j.v.e.b f10784h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.j.v.e.a f10785i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.j.v.e.a f10786j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.j.v.b f10787k;
    public f l;

    /* renamed from: c.a.q0.j.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0716a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0716a(a aVar) {
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

        @Override // c.a.q0.j.v.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // c.a.q0.j.v.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.q0.j.v.e.b bVar = new c.a.q0.j.v.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                c.a.q0.j.n0.c.call(this.a.f10780d, true, bVar);
            }
        }

        @Override // c.a.q0.j.v.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.f10787k == null) {
                return;
            }
            this.a.f10787k.c(str);
        }

        @Override // c.a.q0.j.v.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.f10787k == null) {
                return;
            }
            this.a.f10787k.b(str);
        }

        @Override // c.a.q0.j.v.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.a.f10787k == null) {
                return;
            }
            this.a.f10787k.d(str);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10788e;

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
            this.f10788e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.q0.j.p0.f.b.p().n(this.f10788e.f10778b)) {
                    this.f10788e.f10784h.errMsg = "showKeyboard:fail";
                    c.a.q0.j.n0.c.call(this.f10788e.f10780d, false, this.f10788e.f10784h);
                    return;
                }
                this.f10788e.f10778b.j(this.f10788e.f10783g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10789e;

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
            this.f10789e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.q0.j.p0.f.b.p().s(this.f10789e.f10778b)) {
                    this.f10789e.f10785i.errMsg = "hideKeyboard:ok";
                    c.a.q0.j.n0.c.call(this.f10789e.f10781e, true, this.f10789e.f10785i);
                    return;
                }
                this.f10789e.f10785i.errMsg = "hideKeyboard:fail";
                c.a.q0.j.n0.c.call(this.f10789e.f10781e, false, this.f10789e.f10785i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10790e;

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
            this.f10790e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.j.p0.f.b.p().s(this.f10790e.f10778b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10791e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10792f;

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
            this.f10792f = aVar;
            this.f10791e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10792f.f10778b.m(this.f10791e)) {
                    this.f10792f.f10786j.errMsg = "updateKeyboard:ok";
                    c.a.q0.j.n0.c.call(this.f10792f.f10782f, true, this.f10792f.f10786j);
                    return;
                }
                this.f10792f.f10786j.errMsg = "updateKeyboard:fail";
                c.a.q0.j.n0.c.call(this.f10792f.f10782f, false, this.f10792f.f10786j);
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

    public a(c.a.q0.a.l0.c cVar, c.a.q0.j.v.b bVar) {
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
        this.f10787k = null;
        this.l = new C0716a(this);
        this.a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f10779c = appContext;
        c.a.q0.j.p0.f.a aVar = new c.a.q0.j.p0.f.a(appContext);
        this.f10778b = aVar;
        aVar.i(this.l);
        this.f10787k = bVar;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q0.e0(new d(this));
        }
    }

    public void k(JsObject jsObject) {
        c.a.q0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f10785i = new c.a.q0.j.v.e.a();
            c.a.q0.a.y.b.a F = c.a.q0.a.y.b.a.F(jsObject);
            this.f10781e = F;
            if (F == null) {
                this.f10781e = new c.a.q0.a.y.b.a();
            }
            if (this.a != null && (aVar = this.f10778b) != null && aVar.g()) {
                q0.e0(new c(this));
                return;
            }
            c.a.q0.j.v.e.a aVar2 = this.f10785i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.q0.j.n0.c.call(this.f10781e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.q0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f10784h = new c.a.q0.j.v.e.b();
            c.a.q0.a.y.b.a F = c.a.q0.a.y.b.a.F(jsObject);
            this.f10780d = F;
            if (F == null) {
                this.f10780d = new c.a.q0.a.y.b.a();
            }
            if (this.a != null && (aVar = this.f10778b) != null && !aVar.g()) {
                c.a.q0.j.v.c cVar = new c.a.q0.j.v.c();
                this.f10783g = cVar;
                try {
                    if (cVar.a(this.f10780d)) {
                        q0.f0(new b(this), 500L);
                    } else {
                        this.f10784h.errMsg = "showKeyboard:fail";
                        c.a.q0.j.n0.c.call(this.f10780d, false, this.f10784h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.q0.j.v.e.b bVar = this.f10784h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.q0.j.n0.c.call(this.f10780d, false, bVar);
                    return;
                }
            }
            c.a.q0.j.v.e.b bVar2 = this.f10784h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.q0.j.n0.c.call(this.f10780d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f10786j = new c.a.q0.j.v.e.a();
            c.a.q0.a.y.b.a F = c.a.q0.a.y.b.a.F(jsObject);
            this.f10782f = F;
            if (F == null) {
                this.f10782f = new c.a.q0.a.y.b.a();
            }
            if (this.a != null && this.f10778b != null) {
                q0.e0(new e(this, this.f10782f.B("value")));
                return;
            }
            c.a.q0.j.v.e.a aVar = this.f10786j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.q0.j.n0.c.call(this.f10782f, false, aVar);
        }
    }
}
