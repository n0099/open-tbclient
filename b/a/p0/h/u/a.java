package b.a.p0.h.u;

import android.content.Context;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.l0.c f10747a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.h.o0.f.a f10748b;

    /* renamed from: c  reason: collision with root package name */
    public Context f10749c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.y.b.a f10750d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.y.b.a f10751e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.y.b.a f10752f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.h.u.c f10753g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.h.u.e.b f10754h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.h.u.e.a f10755i;
    public b.a.p0.h.u.e.a j;
    public b.a.p0.h.u.b k;
    public f l;

    /* renamed from: b.a.p0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0592a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10756a;

        public C0592a(a aVar) {
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
            this.f10756a = aVar;
        }

        @Override // b.a.p0.h.u.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10756a.j();
            }
        }

        @Override // b.a.p0.h.u.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.p0.h.u.e.b bVar = new b.a.p0.h.u.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                b.a.p0.h.m0.c.call(this.f10756a.f10750d, true, bVar);
            }
        }

        @Override // b.a.p0.h.u.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f10756a.k == null) {
                return;
            }
            this.f10756a.k.c(str);
        }

        @Override // b.a.p0.h.u.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f10756a.k == null) {
                return;
            }
            this.f10756a.k.b(str);
        }

        @Override // b.a.p0.h.u.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f10756a.k == null) {
                return;
            }
            this.f10756a.k.d(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10757e;

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
            this.f10757e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.p0.h.o0.f.b.p().n(this.f10757e.f10748b)) {
                    this.f10757e.f10754h.errMsg = "showKeyboard:fail";
                    b.a.p0.h.m0.c.call(this.f10757e.f10750d, false, this.f10757e.f10754h);
                    return;
                }
                this.f10757e.f10748b.j(this.f10757e.f10753g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10758e;

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
            this.f10758e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b.a.p0.h.o0.f.b.p().s(this.f10758e.f10748b)) {
                    this.f10758e.f10755i.errMsg = "hideKeyboard:ok";
                    b.a.p0.h.m0.c.call(this.f10758e.f10751e, true, this.f10758e.f10755i);
                    return;
                }
                this.f10758e.f10755i.errMsg = "hideKeyboard:fail";
                b.a.p0.h.m0.c.call(this.f10758e.f10751e, false, this.f10758e.f10755i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f10759e;

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
            this.f10759e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.h.o0.f.b.p().s(this.f10759e.f10748b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f10761f;

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
            this.f10761f = aVar;
            this.f10760e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10761f.f10748b.m(this.f10760e)) {
                    this.f10761f.j.errMsg = "updateKeyboard:ok";
                    b.a.p0.h.m0.c.call(this.f10761f.f10752f, true, this.f10761f.j);
                    return;
                }
                this.f10761f.j.errMsg = "updateKeyboard:fail";
                b.a.p0.h.m0.c.call(this.f10761f.f10752f, false, this.f10761f.j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d(String str);

        void e(String str);
    }

    public a(b.a.p0.a.l0.c cVar, b.a.p0.h.u.b bVar) {
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
        this.l = new C0592a(this);
        this.f10747a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f10749c = appContext;
        b.a.p0.h.o0.f.a aVar = new b.a.p0.h.o0.f.a(appContext);
        this.f10748b = aVar;
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
        b.a.p0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f10755i = new b.a.p0.h.u.e.a();
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            this.f10751e = F;
            if (F == null) {
                this.f10751e = new b.a.p0.a.y.b.a();
            }
            if (this.f10747a != null && (aVar = this.f10748b) != null && aVar.g()) {
                q0.b0(new c(this));
                return;
            }
            b.a.p0.h.u.e.a aVar2 = this.f10755i;
            aVar2.errMsg = "hideKeyboard:fail";
            b.a.p0.h.m0.c.call(this.f10751e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        b.a.p0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f10754h = new b.a.p0.h.u.e.b();
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            this.f10750d = F;
            if (F == null) {
                this.f10750d = new b.a.p0.a.y.b.a();
            }
            if (this.f10747a != null && (aVar = this.f10748b) != null && !aVar.g()) {
                b.a.p0.h.u.c cVar = new b.a.p0.h.u.c();
                this.f10753g = cVar;
                try {
                    if (cVar.a(this.f10750d)) {
                        q0.c0(new b(this), 500L);
                    } else {
                        this.f10754h.errMsg = "showKeyboard:fail";
                        b.a.p0.h.m0.c.call(this.f10750d, false, this.f10754h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    b.a.p0.h.u.e.b bVar = this.f10754h;
                    bVar.errMsg = "showKeyboard:fail";
                    b.a.p0.h.m0.c.call(this.f10750d, false, bVar);
                    return;
                }
            }
            b.a.p0.h.u.e.b bVar2 = this.f10754h;
            bVar2.errMsg = "showKeyboard:fail";
            b.a.p0.h.m0.c.call(this.f10750d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new b.a.p0.h.u.e.a();
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            this.f10752f = F;
            if (F == null) {
                this.f10752f = new b.a.p0.a.y.b.a();
            }
            if (this.f10747a != null && this.f10748b != null) {
                q0.b0(new e(this, this.f10752f.B("value")));
                return;
            }
            b.a.p0.h.u.e.a aVar = this.j;
            aVar.errMsg = "updateKeyboard:fail";
            b.a.p0.h.m0.c.call(this.f10752f, false, aVar);
        }
    }
}
