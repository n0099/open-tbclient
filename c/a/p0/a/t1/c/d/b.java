package c.a.p0.a.t1.c.d;

import android.text.TextUtils;
import c.a.p0.a.h0.m.o.a;
import c.a.p0.n.i.m.f;
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.c.b.b f8689a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.j.b f8690b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8691c;

        public a(b bVar, c.a.p0.a.t1.c.b.b bVar2, c.a.p0.a.h0.j.b bVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, bVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8691c = bVar;
            this.f8689a = bVar2;
            this.f8690b = bVar3;
        }

        @Override // c.a.p0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.t1.d.a.a("payment fun page, your pkg is latest");
            }
        }

        @Override // c.a.p0.a.h0.m.o.a.b
        public void b(c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f8691c.d(this.f8689a, false, this.f8690b);
            }
        }

        @Override // c.a.p0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f8691c.d(this.f8689a, true, this.f8690b);
            }
        }
    }

    /* renamed from: c.a.p0.a.t1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0380b implements c.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.c.b.b f8692a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.j.b f8693b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8694c;

        public C0380b(b bVar, c.a.p0.a.t1.c.b.b bVar2, c.a.p0.a.h0.j.b bVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, bVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8694c = bVar;
            this.f8692a = bVar2;
            this.f8693b = bVar3;
        }

        @Override // c.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8694c.d(this.f8692a, true, this.f8693b);
            }
        }

        @Override // c.a.p0.a.h0.m.b
        public void b(int i2, c.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f8694c.d(this.f8692a, false, this.f8693b);
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract c.a.p0.a.u.h.b b(JSONObject jSONObject);

    public final void c(c.a.p0.a.t1.c.b.b bVar, String str, c.a.p0.a.h0.j.b<c.a.p0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str, bVar2) == null) {
            c.a.p0.a.t1.d.a.a("local has not main pkg, download fun page main pkg");
            c.a.p0.n.i.m.c cVar = new c.a.p0.n.i.m.c(str, c.a.p0.a.a2.d.g().l());
            cVar.o(0L);
            cVar.r(bVar.f8668c);
            cVar.d("3");
            c.a.p0.n.b.b(cVar, new c.a.p0.a.h0.m.o.a(str, new a(this, bVar, bVar2)));
        }
    }

    public final void d(c.a.p0.a.t1.c.b.b bVar, boolean z, c.a.p0.a.h0.j.b<c.a.p0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Boolean.valueOf(z), bVar2}) == null) {
            if (z) {
                c.a.p0.a.t1.c.b.a f2 = f(bVar);
                if (f2 != null && f2.f8665f) {
                    c.a.p0.a.t1.d.a.a("payment fun page, download success, ready to jump");
                    j(f2.f8662c, bVar);
                    return;
                }
                c.a.p0.a.t1.d.a.a("payment fun page, download success, but not exist");
                c.a.p0.a.t1.c.c.a aVar = new c.a.p0.a.t1.c.c.a(bVar.f8671f);
                aVar.f8675a = bVar.f8670e;
                bVar2.a(aVar);
                return;
            }
            c.a.p0.a.t1.d.a.a("payment fun page, download failed");
            c.a.p0.a.t1.c.c.a aVar2 = new c.a.p0.a.t1.c.c.a(bVar.f8671f);
            aVar2.f8675a = bVar.f8670e;
            bVar2.a(aVar2);
        }
    }

    public final void e(c.a.p0.a.t1.c.b.b bVar, c.a.p0.a.t1.c.b.a aVar, c.a.p0.a.h0.j.b<c.a.p0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, aVar, bVar2) == null) {
            c.a.p0.a.t1.d.a.a("main pkg is exist, download fun page sub pkg");
            String str = aVar.f8660a;
            int i2 = aVar.f8663d;
            c.a.p0.n.b.f(new f(str, i2, c.a.p0.a.t1.g.b.e(aVar.f8662c, aVar.f8661b), 0), new c.a.p0.a.h0.m.q.a(str, String.valueOf(i2), new C0380b(this, bVar, bVar2)));
        }
    }

    public abstract c.a.p0.a.t1.c.b.a f(c.a.p0.a.t1.c.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract c.a.p0.a.u.h.b j(String str, c.a.p0.a.t1.c.b.b bVar);

    public abstract boolean k();

    public final c.a.p0.a.u.h.b l(c.a.p0.a.t1.c.b.b bVar, c.a.p0.a.h0.j.b<c.a.p0.a.t1.c.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bVar2)) == null) {
            c.a.p0.a.t1.d.a.a("open fun page start");
            if (bVar != null && bVar.a()) {
                c.a.p0.a.u.h.b b2 = b(bVar.f8672g);
                if (b2 != null) {
                    c.a.p0.a.t1.d.a.a("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    c.a.p0.a.t1.d.a.a("open payment fun page");
                    c.a.p0.a.t1.c.b.a f2 = f(bVar);
                    if (f2 == null) {
                        return new c.a.p0.a.u.h.b(1001, "fun page not exists");
                    }
                    if (!f2.f8665f) {
                        c.a.p0.a.t1.d.a.a("payment fun page, " + bVar.f8669d + " mode");
                        if (i(bVar.f8669d)) {
                            if (f2.f8664e) {
                                e(bVar, f2, bVar2);
                            } else {
                                return new c.a.p0.a.u.h.b(1001, "fun page not exists");
                            }
                        } else if (f2.f8664e) {
                            e(bVar, f2, bVar2);
                        } else {
                            c(bVar, f2.f8660a, bVar2);
                        }
                        c.a.p0.a.t1.d.a.a("open fun page end");
                        return new c.a.p0.a.u.h.b(0);
                    }
                    return j(f2.f8662c, bVar);
                } else {
                    c.a.p0.a.t1.d.a.a("open user info or choose address fun page");
                    return m(bVar, bVar2);
                }
            }
            c.a.p0.a.t1.d.a.a("params parse fail");
            return new c.a.p0.a.u.h.b(202, "params parse fail");
        }
        return (c.a.p0.a.u.h.b) invokeLL.objValue;
    }

    public abstract c.a.p0.a.u.h.b m(c.a.p0.a.t1.c.b.b bVar, c.a.p0.a.h0.j.b<c.a.p0.a.t1.c.c.a> bVar2);
}
