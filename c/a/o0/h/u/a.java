package c.a.o0.h.u;

import android.content.Context;
import c.a.o0.a.v2.q0;
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
    public c.a.o0.a.l0.c f11519a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.h.o0.f.a f11520b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11521c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a.y.b.a f11522d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.y.b.a f11523e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.a.y.b.a f11524f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.h.u.c f11525g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.h.u.e.b f11526h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.o0.h.u.e.a f11527i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.o0.h.u.e.a f11528j;
    public c.a.o0.h.u.b k;
    public f l;

    /* renamed from: c.a.o0.h.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0595a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11529a;

        public C0595a(a aVar) {
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
            this.f11529a = aVar;
        }

        @Override // c.a.o0.h.u.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11529a.j();
            }
        }

        @Override // c.a.o0.h.u.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.o0.h.u.e.b bVar = new c.a.o0.h.u.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                c.a.o0.h.m0.c.a(this.f11529a.f11522d, true, bVar);
            }
        }

        @Override // c.a.o0.h.u.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f11529a.k == null) {
                return;
            }
            this.f11529a.k.c(str);
        }

        @Override // c.a.o0.h.u.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f11529a.k == null) {
                return;
            }
            this.f11529a.k.b(str);
        }

        @Override // c.a.o0.h.u.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f11529a.k == null) {
                return;
            }
            this.f11529a.k.d(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11530e;

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
            this.f11530e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.o0.h.o0.f.b.p().n(this.f11530e.f11520b)) {
                    this.f11530e.f11526h.errMsg = "showKeyboard:fail";
                    c.a.o0.h.m0.c.a(this.f11530e.f11522d, false, this.f11530e.f11526h);
                    return;
                }
                this.f11530e.f11520b.j(this.f11530e.f11525g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11531e;

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
            this.f11531e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (c.a.o0.h.o0.f.b.p().s(this.f11531e.f11520b)) {
                    this.f11531e.f11527i.errMsg = "hideKeyboard:ok";
                    c.a.o0.h.m0.c.a(this.f11531e.f11523e, true, this.f11531e.f11527i);
                    return;
                }
                this.f11531e.f11527i.errMsg = "hideKeyboard:fail";
                c.a.o0.h.m0.c.a(this.f11531e.f11523e, false, this.f11531e.f11527i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11532e;

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
            this.f11532e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.h.o0.f.b.p().s(this.f11532e.f11520b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11533e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11534f;

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
            this.f11534f = aVar;
            this.f11533e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11534f.f11520b.m(this.f11533e)) {
                    this.f11534f.f11528j.errMsg = "updateKeyboard:ok";
                    c.a.o0.h.m0.c.a(this.f11534f.f11524f, true, this.f11534f.f11528j);
                    return;
                }
                this.f11534f.f11528j.errMsg = "updateKeyboard:fail";
                c.a.o0.h.m0.c.a(this.f11534f.f11524f, false, this.f11534f.f11528j);
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

    public a(c.a.o0.a.l0.c cVar, c.a.o0.h.u.b bVar) {
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
        this.l = new C0595a(this);
        this.f11519a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f11521c = appContext;
        c.a.o0.h.o0.f.a aVar = new c.a.o0.h.o0.f.a(appContext);
        this.f11520b = aVar;
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
        c.a.o0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f11527i = new c.a.o0.h.u.e.a();
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            this.f11523e = G;
            if (G == null) {
                this.f11523e = new c.a.o0.a.y.b.a();
            }
            if (this.f11519a != null && (aVar = this.f11520b) != null && aVar.g()) {
                q0.b0(new c(this));
                return;
            }
            c.a.o0.h.u.e.a aVar2 = this.f11527i;
            aVar2.errMsg = "hideKeyboard:fail";
            c.a.o0.h.m0.c.a(this.f11523e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        c.a.o0.h.o0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f11526h = new c.a.o0.h.u.e.b();
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            this.f11522d = G;
            if (G == null) {
                this.f11522d = new c.a.o0.a.y.b.a();
            }
            if (this.f11519a != null && (aVar = this.f11520b) != null && !aVar.g()) {
                c.a.o0.h.u.c cVar = new c.a.o0.h.u.c();
                this.f11525g = cVar;
                try {
                    if (cVar.a(this.f11522d)) {
                        q0.c0(new b(this), 500L);
                    } else {
                        this.f11526h.errMsg = "showKeyboard:fail";
                        c.a.o0.h.m0.c.a(this.f11522d, false, this.f11526h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    c.a.o0.h.u.e.b bVar = this.f11526h;
                    bVar.errMsg = "showKeyboard:fail";
                    c.a.o0.h.m0.c.a(this.f11522d, false, bVar);
                    return;
                }
            }
            c.a.o0.h.u.e.b bVar2 = this.f11526h;
            bVar2.errMsg = "showKeyboard:fail";
            c.a.o0.h.m0.c.a(this.f11522d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.f11528j = new c.a.o0.h.u.e.a();
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            this.f11524f = G;
            if (G == null) {
                this.f11524f = new c.a.o0.a.y.b.a();
            }
            if (this.f11519a != null && this.f11520b != null) {
                q0.b0(new e(this, this.f11524f.C("value")));
                return;
            }
            c.a.o0.h.u.e.a aVar = this.f11528j;
            aVar.errMsg = "updateKeyboard:fail";
            c.a.o0.h.m0.c.a(this.f11524f, false, aVar);
        }
    }
}
