package b.a.p0.j.v;

import android.content.Context;
import b.a.p0.a.z2.q0;
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
    public b.a.p0.a.l0.c f11469a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.j.p0.f.a f11470b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11471c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.y.b.a f11472d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.a.y.b.a f11473e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.y.b.a f11474f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.j.v.c f11475g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.p0.j.v.e.b f11476h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.j.v.e.a f11477i;
    public b.a.p0.j.v.e.a j;
    public b.a.p0.j.v.b k;
    public f l;

    /* renamed from: b.a.p0.j.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0626a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11478a;

        public C0626a(a aVar) {
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
            this.f11478a = aVar;
        }

        @Override // b.a.p0.j.v.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11478a.j();
            }
        }

        @Override // b.a.p0.j.v.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.p0.j.v.e.b bVar = new b.a.p0.j.v.e.b();
                bVar.errMsg = "showKeyboard:ok";
                bVar.height = i2;
                b.a.p0.j.n0.c.call(this.f11478a.f11472d, true, bVar);
            }
        }

        @Override // b.a.p0.j.v.a.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.f11478a.k == null) {
                return;
            }
            this.f11478a.k.c(str);
        }

        @Override // b.a.p0.j.v.a.f
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f11478a.k == null) {
                return;
            }
            this.f11478a.k.b(str);
        }

        @Override // b.a.p0.j.v.a.f
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.f11478a.k == null) {
                return;
            }
            this.f11478a.k.d(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11479e;

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
            this.f11479e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!b.a.p0.j.p0.f.b.p().n(this.f11479e.f11470b)) {
                    this.f11479e.f11476h.errMsg = "showKeyboard:fail";
                    b.a.p0.j.n0.c.call(this.f11479e.f11472d, false, this.f11479e.f11476h);
                    return;
                }
                this.f11479e.f11470b.j(this.f11479e.f11475g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11480e;

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
            this.f11480e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b.a.p0.j.p0.f.b.p().s(this.f11480e.f11470b)) {
                    this.f11480e.f11477i.errMsg = "hideKeyboard:ok";
                    b.a.p0.j.n0.c.call(this.f11480e.f11473e, true, this.f11480e.f11477i);
                    return;
                }
                this.f11480e.f11477i.errMsg = "hideKeyboard:fail";
                b.a.p0.j.n0.c.call(this.f11480e.f11473e, false, this.f11480e.f11477i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11481e;

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
            this.f11481e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.j.p0.f.b.p().s(this.f11481e.f11470b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11483f;

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
            this.f11483f = aVar;
            this.f11482e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11483f.f11470b.m(this.f11482e)) {
                    this.f11483f.j.errMsg = "updateKeyboard:ok";
                    b.a.p0.j.n0.c.call(this.f11483f.f11474f, true, this.f11483f.j);
                    return;
                }
                this.f11483f.j.errMsg = "updateKeyboard:fail";
                b.a.p0.j.n0.c.call(this.f11483f.f11474f, false, this.f11483f.j);
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

    public a(b.a.p0.a.l0.c cVar, b.a.p0.j.v.b bVar) {
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
        this.l = new C0626a(this);
        this.f11469a = cVar;
        Context appContext = AppRuntime.getAppContext();
        this.f11471c = appContext;
        b.a.p0.j.p0.f.a aVar = new b.a.p0.j.p0.f.a(appContext);
        this.f11470b = aVar;
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
        b.a.p0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            this.f11477i = new b.a.p0.j.v.e.a();
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            this.f11473e = F;
            if (F == null) {
                this.f11473e = new b.a.p0.a.y.b.a();
            }
            if (this.f11469a != null && (aVar = this.f11470b) != null && aVar.g()) {
                q0.e0(new c(this));
                return;
            }
            b.a.p0.j.v.e.a aVar2 = this.f11477i;
            aVar2.errMsg = "hideKeyboard:fail";
            b.a.p0.j.n0.c.call(this.f11473e, false, aVar2);
        }
    }

    public void l(JsObject jsObject) {
        b.a.p0.j.p0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            this.f11476h = new b.a.p0.j.v.e.b();
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            this.f11472d = F;
            if (F == null) {
                this.f11472d = new b.a.p0.a.y.b.a();
            }
            if (this.f11469a != null && (aVar = this.f11470b) != null && !aVar.g()) {
                b.a.p0.j.v.c cVar = new b.a.p0.j.v.c();
                this.f11475g = cVar;
                try {
                    if (cVar.a(this.f11472d)) {
                        q0.f0(new b(this), 500L);
                    } else {
                        this.f11476h.errMsg = "showKeyboard:fail";
                        b.a.p0.j.n0.c.call(this.f11472d, false, this.f11476h);
                    }
                    return;
                } catch (JSTypeMismatchException unused) {
                    b.a.p0.j.v.e.b bVar = this.f11476h;
                    bVar.errMsg = "showKeyboard:fail";
                    b.a.p0.j.n0.c.call(this.f11472d, false, bVar);
                    return;
                }
            }
            b.a.p0.j.v.e.b bVar2 = this.f11476h;
            bVar2.errMsg = "showKeyboard:fail";
            b.a.p0.j.n0.c.call(this.f11472d, false, bVar2);
        }
    }

    public void m(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            this.j = new b.a.p0.j.v.e.a();
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            this.f11474f = F;
            if (F == null) {
                this.f11474f = new b.a.p0.a.y.b.a();
            }
            if (this.f11469a != null && this.f11470b != null) {
                q0.e0(new e(this, this.f11474f.B("value")));
                return;
            }
            b.a.p0.j.v.e.a aVar = this.j;
            aVar.errMsg = "updateKeyboard:fail";
            b.a.p0.j.n0.c.call(this.f11474f, false, aVar);
        }
    }
}
