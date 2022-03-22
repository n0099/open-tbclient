package c.a.n0.a.m1.d.d;

import android.text.TextUtils;
import c.a.n0.a.x.m.r.a;
import c.a.n0.q.i.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.m1.d.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.j.b f5464b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f5465c;

        public a(b bVar, c.a.n0.a.m1.d.b.b bVar2, c.a.n0.a.x.j.b bVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, bVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5465c = bVar;
            this.a = bVar2;
            this.f5464b = bVar3;
        }

        @Override // c.a.n0.a.x.m.r.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.m1.e.a.b("payment fun page, your pkg is latest");
            }
        }

        @Override // c.a.n0.a.x.m.r.a.b
        public void b(c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f5465c.d(this.a, false, this.f5464b);
            }
        }

        @Override // c.a.n0.a.x.m.r.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f5465c.d(this.a, true, this.f5464b);
            }
        }
    }

    /* renamed from: c.a.n0.a.m1.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0376b implements c.a.n0.a.x.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.m1.d.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.j.b f5466b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f5467c;

        public C0376b(b bVar, c.a.n0.a.m1.d.b.b bVar2, c.a.n0.a.x.j.b bVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, bVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5467c = bVar;
            this.a = bVar2;
            this.f5466b = bVar3;
        }

        @Override // c.a.n0.a.x.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5467c.d(this.a, true, this.f5466b);
            }
        }

        @Override // c.a.n0.a.x.m.b
        public void b(int i, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                this.f5467c.d(this.a, false, this.f5466b);
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract c.a.n0.a.k.h.b b(JSONObject jSONObject);

    public final void c(c.a.n0.a.m1.d.b.b bVar, String str, c.a.n0.a.x.j.b<c.a.n0.a.m1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str, bVar2) == null) {
            c.a.n0.a.m1.e.a.b("local has not main pkg, download fun page main pkg");
            c.a.n0.q.i.m.d dVar = new c.a.n0.q.i.m.d(str, c.a.n0.a.t1.d.J().l());
            dVar.q(0L);
            dVar.t(bVar.f5448c);
            dVar.d("3");
            c.a.n0.q.b.c(dVar, new c.a.n0.a.x.m.r.a(str, new a(this, bVar, bVar2)));
        }
    }

    public final void d(c.a.n0.a.m1.d.b.b bVar, boolean z, c.a.n0.a.x.j.b<c.a.n0.a.m1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Boolean.valueOf(z), bVar2}) == null) {
            if (z) {
                c.a.n0.a.m1.d.b.a f2 = f(bVar);
                if (f2 != null && f2.f5446f) {
                    c.a.n0.a.m1.e.a.b("payment fun page, download success, ready to jump");
                    j(f2.f5443c, bVar);
                    return;
                }
                c.a.n0.a.m1.e.a.b("payment fun page, download success, but not exist");
                c.a.n0.a.m1.d.c.a aVar = new c.a.n0.a.m1.d.c.a(bVar.f5451f);
                aVar.a = bVar.f5450e;
                bVar2.a(aVar);
                return;
            }
            c.a.n0.a.m1.e.a.b("payment fun page, download failed");
            c.a.n0.a.m1.d.c.a aVar2 = new c.a.n0.a.m1.d.c.a(bVar.f5451f);
            aVar2.a = bVar.f5450e;
            bVar2.a(aVar2);
        }
    }

    public final void e(c.a.n0.a.m1.d.b.b bVar, c.a.n0.a.m1.d.b.a aVar, c.a.n0.a.x.j.b<c.a.n0.a.m1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, aVar, bVar2) == null) {
            c.a.n0.a.m1.e.a.b("main pkg is exist, download fun page sub pkg");
            String str = aVar.a;
            int i = aVar.f5444d;
            c.a.n0.q.b.h(new g(str, i, c.a.n0.a.m1.h.b.e(aVar.f5443c, aVar.f5442b), 0), new c.a.n0.a.x.m.t.a(str, String.valueOf(i), new C0376b(this, bVar, bVar2)));
        }
    }

    public abstract c.a.n0.a.m1.d.b.a f(c.a.n0.a.m1.d.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract c.a.n0.a.k.h.b j(String str, c.a.n0.a.m1.d.b.b bVar);

    public abstract boolean k();

    public final c.a.n0.a.k.h.b l(c.a.n0.a.m1.d.b.b bVar, c.a.n0.a.x.j.b<c.a.n0.a.m1.d.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bVar2)) == null) {
            c.a.n0.a.m1.e.a.b("open fun page start");
            if (bVar != null && bVar.a()) {
                c.a.n0.a.k.h.b b2 = b(bVar.f5452g);
                if (b2 != null) {
                    c.a.n0.a.m1.e.a.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    c.a.n0.a.m1.e.a.b("open payment fun page");
                    c.a.n0.a.m1.d.b.a f2 = f(bVar);
                    if (f2 == null) {
                        return new c.a.n0.a.k.h.b(1001, "fun page not exists");
                    }
                    if (!f2.f5446f) {
                        c.a.n0.a.m1.e.a.b("payment fun page, " + bVar.f5449d + " mode");
                        if (i(bVar.f5449d)) {
                            if (f2.f5445e) {
                                e(bVar, f2, bVar2);
                            } else {
                                return new c.a.n0.a.k.h.b(1001, "fun page not exists");
                            }
                        } else if (f2.f5445e) {
                            e(bVar, f2, bVar2);
                        } else {
                            c(bVar, f2.a, bVar2);
                        }
                        c.a.n0.a.m1.e.a.b("open fun page end");
                        return new c.a.n0.a.k.h.b(0);
                    }
                    return j(f2.f5443c, bVar);
                } else {
                    c.a.n0.a.m1.e.a.b("open user info or choose address fun page");
                    return m(bVar, bVar2);
                }
            }
            c.a.n0.a.m1.e.a.b("params parse fail");
            return new c.a.n0.a.k.h.b(202, "params parse fail");
        }
        return (c.a.n0.a.k.h.b) invokeLL.objValue;
    }

    public abstract c.a.n0.a.k.h.b m(c.a.n0.a.m1.d.b.b bVar, c.a.n0.a.x.j.b<c.a.n0.a.m1.d.c.a> bVar2);
}
