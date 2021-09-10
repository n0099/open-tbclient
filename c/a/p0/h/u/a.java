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
    public c.a.p0.a.l0.c f11547a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.h.o0.f.a f11548b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11549c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.a.y.b.a f11550d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.y.b.a f11551e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a.y.b.a f11552f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.h.u.c f11553g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.h.u.e.b f11554h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.h.u.e.a f11555i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.h.u.e.a f11556j;
    public c.a.p0.h.u.b k;
    public f l;

    /* renamed from: c.a.p0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0597a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11557a;

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
            this.f11557a = aVar;
        }

        @Override // c.a.p0.h.u.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11557a.j();
            }
        }

        @Override // c.a.p0.h.u.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.p0.h.u.e.b bVar = new c.a.p0.h.u.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                c.a.p0.h.m0.c.a(this.f11557a.f11550d, true, bVar);
            }
        }

        @Override // c.a.p0.h.u.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f11557a.k == null) {
                return;
            }
            this.f11557a.k.c(str);
        }

        @Override // c.a.p0.h.u.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f11557a.k == null) {
                return;
            }
            this.f11557a.k.b(str);
        }

        @Override // c.a.p0.h.u.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f11557a.k == null) {
                return;
            }
            this.f11557a.k.d(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11558e;

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
            this.f11558e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.p0.h.o0.f.b.p().n(this.f11558e.f11548b)) {
                    this.f11558e.f11554h.errMsg = "showKeyboard:fail";
                    c.a.p0.h.m0.c.a(this.f11558e.f11550d, false, this.f11558e.f11554h);
                    return;
                }
                this.f11558e.f11548b.j(this.f11558e.f11553g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11559e;

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
            this.f11559e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.p0.h.o0.f.b.p().s(this.f11559e.f11548b)) {
                    this.f11559e.f11555i.errMsg = "hideKeyboard:ok";
                    c.a.p0.h.m0.c.a(this.f11559e.f11551e, true, this.f11559e.f11555i);
                    return;
                }
                this.f11559e.f11555i.errMsg = "hideKeyboard:fail";
                c.a.p0.h.m0.c.a(this.f11559e.f11551e, false, this.f11559e.f11555i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11560e;

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
            this.f11560e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.h.o0.f.b.p().s(this.f11560e.f11548b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11561e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11562f;

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
            this.f11562f = aVar;
            this.f11561e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11562f.f11548b.m(this.f11561e)) {
                    this.f11562f.f11556j.errMsg = "updateKeyboard:ok";
                    c.a.p0.h.m0.c.a(this.f11562f.f11552f, true, this.f11562f.f11556j);
                    return;
                }
                this.f11562f.f11556j.errMsg = "updateKeyboard:fail";
                c.a.p0.h.m0.c.a(this.f11562f.f11552f, false, this.f11562f.f11556j);
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
        this.f11547a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f11549c = appContext;
        c.a.p0.h.o0.f.a aVar = new c.a.p0.h.o0.f.a(appContext);
        this.f11548b = aVar;
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
            this.f11555i = new c.a.p0.h.u.e.a();
            c.a.p0.a.y.b.a G = c.a.p0.a.y.b.a.G(jsObject);
            this.f11551e = G;
            if (G == null) {
                this.f11551e = new c.a.p0.a.y.b.a();
            }
            if (this.f11547a != null && (aVar = this.f11548b) != null && aVar.g()) {
                q0.b0(new c(this));
                return;
            }
            c.a.p0.h.u.e.a aVar2 = this.f11555i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.p0.h.m0.c.a(this.f11551e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.p0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f11554h = new c.a.p0.h.u.e.b();
            c.a.p0.a.y.b.a G = c.a.p0.a.y.b.a.G(jsObject);
            this.f11550d = G;
            if (G == null) {
                this.f11550d = new c.a.p0.a.y.b.a();
            }
            if (this.f11547a != null && (aVar = this.f11548b) != null && !aVar.g()) {
                c.a.p0.h.u.c cVar = new c.a.p0.h.u.c();
                this.f11553g = cVar;
                try {
                    if (cVar.a(this.f11550d)) {
                        q0.c0(new b(this), 500L);
                    } else {
                        this.f11554h.errMsg = "showKeyboard:fail";
                        c.a.p0.h.m0.c.a(this.f11550d, false, this.f11554h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.p0.h.u.e.b bVar = this.f11554h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.p0.h.m0.c.a(this.f11550d, false, bVar);
                    return;
                }
            }
            c.a.p0.h.u.e.b bVar2 = this.f11554h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.p0.h.m0.c.a(this.f11550d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f11556j = new c.a.p0.h.u.e.a();
            c.a.p0.a.y.b.a G = c.a.p0.a.y.b.a.G(jsObject);
            this.f11552f = G;
            if (G == null) {
                this.f11552f = new c.a.p0.a.y.b.a();
            }
            if (this.f11547a != null && this.f11548b != null) {
                q0.b0(new e(this, this.f11552f.C("value")));
                return;
            }
            c.a.p0.h.u.e.a aVar = this.f11556j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.p0.h.m0.c.a(this.f11552f, false, aVar);
        }
    }
}
