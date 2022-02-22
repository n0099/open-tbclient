package c.a.s0.a.w1.d.d;

import android.text.TextUtils;
import c.a.s0.a.h0.m.r.a;
import c.a.s0.q.j.m.g;
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
        public final /* synthetic */ c.a.s0.a.w1.d.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.j.b f9776b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f9777c;

        public a(b bVar, c.a.s0.a.w1.d.b.b bVar2, c.a.s0.a.h0.j.b bVar3) {
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
            this.f9777c = bVar;
            this.a = bVar2;
            this.f9776b = bVar3;
        }

        @Override // c.a.s0.a.h0.m.r.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.w1.e.a.b("payment fun page, your pkg is latest");
            }
        }

        @Override // c.a.s0.a.h0.m.r.a.b
        public void b(c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f9777c.d(this.a, false, this.f9776b);
            }
        }

        @Override // c.a.s0.a.h0.m.r.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f9777c.d(this.a, true, this.f9776b);
            }
        }
    }

    /* renamed from: c.a.s0.a.w1.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0631b implements c.a.s0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.w1.d.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.j.b f9778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f9779c;

        public C0631b(b bVar, c.a.s0.a.w1.d.b.b bVar2, c.a.s0.a.h0.j.b bVar3) {
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
            this.f9779c = bVar;
            this.a = bVar2;
            this.f9778b = bVar3;
        }

        @Override // c.a.s0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9779c.d(this.a, true, this.f9778b);
            }
        }

        @Override // c.a.s0.a.h0.m.b
        public void b(int i2, c.a.s0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f9779c.d(this.a, false, this.f9778b);
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

    public abstract c.a.s0.a.u.h.b b(JSONObject jSONObject);

    public final void c(c.a.s0.a.w1.d.b.b bVar, String str, c.a.s0.a.h0.j.b<c.a.s0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str, bVar2) == null) {
            c.a.s0.a.w1.e.a.b("local has not main pkg, download fun page main pkg");
            c.a.s0.q.j.m.d dVar = new c.a.s0.q.j.m.d(str, c.a.s0.a.d2.d.J().l());
            dVar.q(0L);
            dVar.t(bVar.f9757c);
            dVar.d("3");
            c.a.s0.q.b.c(dVar, new c.a.s0.a.h0.m.r.a(str, new a(this, bVar, bVar2)));
        }
    }

    public final void d(c.a.s0.a.w1.d.b.b bVar, boolean z, c.a.s0.a.h0.j.b<c.a.s0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Boolean.valueOf(z), bVar2}) == null) {
            if (z) {
                c.a.s0.a.w1.d.b.a f2 = f(bVar);
                if (f2 != null && f2.f9755f) {
                    c.a.s0.a.w1.e.a.b("payment fun page, download success, ready to jump");
                    j(f2.f9752c, bVar);
                    return;
                }
                c.a.s0.a.w1.e.a.b("payment fun page, download success, but not exist");
                c.a.s0.a.w1.d.c.a aVar = new c.a.s0.a.w1.d.c.a(bVar.f9760f);
                aVar.a = bVar.f9759e;
                bVar2.a(aVar);
                return;
            }
            c.a.s0.a.w1.e.a.b("payment fun page, download failed");
            c.a.s0.a.w1.d.c.a aVar2 = new c.a.s0.a.w1.d.c.a(bVar.f9760f);
            aVar2.a = bVar.f9759e;
            bVar2.a(aVar2);
        }
    }

    public final void e(c.a.s0.a.w1.d.b.b bVar, c.a.s0.a.w1.d.b.a aVar, c.a.s0.a.h0.j.b<c.a.s0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, aVar, bVar2) == null) {
            c.a.s0.a.w1.e.a.b("main pkg is exist, download fun page sub pkg");
            String str = aVar.a;
            int i2 = aVar.f9753d;
            c.a.s0.q.b.h(new g(str, i2, c.a.s0.a.w1.h.b.e(aVar.f9752c, aVar.f9751b), 0), new c.a.s0.a.h0.m.t.a(str, String.valueOf(i2), new C0631b(this, bVar, bVar2)));
        }
    }

    public abstract c.a.s0.a.w1.d.b.a f(c.a.s0.a.w1.d.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract c.a.s0.a.u.h.b j(String str, c.a.s0.a.w1.d.b.b bVar);

    public abstract boolean k();

    public final c.a.s0.a.u.h.b l(c.a.s0.a.w1.d.b.b bVar, c.a.s0.a.h0.j.b<c.a.s0.a.w1.d.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bVar2)) == null) {
            c.a.s0.a.w1.e.a.b("open fun page start");
            if (bVar != null && bVar.a()) {
                c.a.s0.a.u.h.b b2 = b(bVar.f9761g);
                if (b2 != null) {
                    c.a.s0.a.w1.e.a.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    c.a.s0.a.w1.e.a.b("open payment fun page");
                    c.a.s0.a.w1.d.b.a f2 = f(bVar);
                    if (f2 == null) {
                        return new c.a.s0.a.u.h.b(1001, "fun page not exists");
                    }
                    if (!f2.f9755f) {
                        c.a.s0.a.w1.e.a.b("payment fun page, " + bVar.f9758d + " mode");
                        if (i(bVar.f9758d)) {
                            if (f2.f9754e) {
                                e(bVar, f2, bVar2);
                            } else {
                                return new c.a.s0.a.u.h.b(1001, "fun page not exists");
                            }
                        } else if (f2.f9754e) {
                            e(bVar, f2, bVar2);
                        } else {
                            c(bVar, f2.a, bVar2);
                        }
                        c.a.s0.a.w1.e.a.b("open fun page end");
                        return new c.a.s0.a.u.h.b(0);
                    }
                    return j(f2.f9752c, bVar);
                } else {
                    c.a.s0.a.w1.e.a.b("open user info or choose address fun page");
                    return m(bVar, bVar2);
                }
            }
            c.a.s0.a.w1.e.a.b("params parse fail");
            return new c.a.s0.a.u.h.b(202, "params parse fail");
        }
        return (c.a.s0.a.u.h.b) invokeLL.objValue;
    }

    public abstract c.a.s0.a.u.h.b m(c.a.s0.a.w1.d.b.b bVar, c.a.s0.a.h0.j.b<c.a.s0.a.w1.d.c.a> bVar2);
}
