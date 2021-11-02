package b.a.p0.a.t1.c.d;

import android.text.TextUtils;
import b.a.p0.a.h0.m.o.a;
import b.a.p0.n.i.m.f;
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
        public final /* synthetic */ b.a.p0.a.t1.c.b.b f7963a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f7964b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f7965c;

        public a(b bVar, b.a.p0.a.t1.c.b.b bVar2, b.a.p0.a.h0.j.b bVar3) {
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
            this.f7965c = bVar;
            this.f7963a = bVar2;
            this.f7964b = bVar3;
        }

        @Override // b.a.p0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.t1.d.a.a("payment fun page, your pkg is latest");
            }
        }

        @Override // b.a.p0.a.h0.m.o.a.b
        public void b(b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f7965c.d(this.f7963a, false, this.f7964b);
            }
        }

        @Override // b.a.p0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f7965c.d(this.f7963a, true, this.f7964b);
            }
        }
    }

    /* renamed from: b.a.p0.a.t1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0375b implements b.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.t1.c.b.b f7966a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f7967b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f7968c;

        public C0375b(b bVar, b.a.p0.a.t1.c.b.b bVar2, b.a.p0.a.h0.j.b bVar3) {
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
            this.f7968c = bVar;
            this.f7966a = bVar2;
            this.f7967b = bVar3;
        }

        @Override // b.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7968c.d(this.f7966a, true, this.f7967b);
            }
        }

        @Override // b.a.p0.a.h0.m.b
        public void b(int i2, b.a.p0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f7968c.d(this.f7966a, false, this.f7967b);
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

    public abstract b.a.p0.a.u.h.b b(JSONObject jSONObject);

    public final void c(b.a.p0.a.t1.c.b.b bVar, String str, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str, bVar2) == null) {
            b.a.p0.a.t1.d.a.a("local has not main pkg, download fun page main pkg");
            b.a.p0.n.i.m.c cVar = new b.a.p0.n.i.m.c(str, b.a.p0.a.a2.d.g().l());
            cVar.o(0L);
            cVar.r(bVar.f7942c);
            cVar.d("3");
            b.a.p0.n.b.b(cVar, new b.a.p0.a.h0.m.o.a(str, new a(this, bVar, bVar2)));
        }
    }

    public final void d(b.a.p0.a.t1.c.b.b bVar, boolean z, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Boolean.valueOf(z), bVar2}) == null) {
            if (z) {
                b.a.p0.a.t1.c.b.a f2 = f(bVar);
                if (f2 != null && f2.f7939f) {
                    b.a.p0.a.t1.d.a.a("payment fun page, download success, ready to jump");
                    j(f2.f7936c, bVar);
                    return;
                }
                b.a.p0.a.t1.d.a.a("payment fun page, download success, but not exist");
                b.a.p0.a.t1.c.c.a aVar = new b.a.p0.a.t1.c.c.a(bVar.f7945f);
                aVar.f7949a = bVar.f7944e;
                bVar2.a(aVar);
                return;
            }
            b.a.p0.a.t1.d.a.a("payment fun page, download failed");
            b.a.p0.a.t1.c.c.a aVar2 = new b.a.p0.a.t1.c.c.a(bVar.f7945f);
            aVar2.f7949a = bVar.f7944e;
            bVar2.a(aVar2);
        }
    }

    public final void e(b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.t1.c.b.a aVar, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, aVar, bVar2) == null) {
            b.a.p0.a.t1.d.a.a("main pkg is exist, download fun page sub pkg");
            String str = aVar.f7934a;
            int i2 = aVar.f7937d;
            b.a.p0.n.b.f(new f(str, i2, b.a.p0.a.t1.g.b.e(aVar.f7936c, aVar.f7935b), 0), new b.a.p0.a.h0.m.q.a(str, String.valueOf(i2), new C0375b(this, bVar, bVar2)));
        }
    }

    public abstract b.a.p0.a.t1.c.b.a f(b.a.p0.a.t1.c.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract b.a.p0.a.u.h.b j(String str, b.a.p0.a.t1.c.b.b bVar);

    public abstract boolean k();

    public final b.a.p0.a.u.h.b l(b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bVar2)) == null) {
            b.a.p0.a.t1.d.a.a("open fun page start");
            if (bVar != null && bVar.a()) {
                b.a.p0.a.u.h.b b2 = b(bVar.f7946g);
                if (b2 != null) {
                    b.a.p0.a.t1.d.a.a("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    b.a.p0.a.t1.d.a.a("open payment fun page");
                    b.a.p0.a.t1.c.b.a f2 = f(bVar);
                    if (f2 == null) {
                        return new b.a.p0.a.u.h.b(1001, "fun page not exists");
                    }
                    if (!f2.f7939f) {
                        b.a.p0.a.t1.d.a.a("payment fun page, " + bVar.f7943d + " mode");
                        if (i(bVar.f7943d)) {
                            if (f2.f7938e) {
                                e(bVar, f2, bVar2);
                            } else {
                                return new b.a.p0.a.u.h.b(1001, "fun page not exists");
                            }
                        } else if (f2.f7938e) {
                            e(bVar, f2, bVar2);
                        } else {
                            c(bVar, f2.f7934a, bVar2);
                        }
                        b.a.p0.a.t1.d.a.a("open fun page end");
                        return new b.a.p0.a.u.h.b(0);
                    }
                    return j(f2.f7936c, bVar);
                } else {
                    b.a.p0.a.t1.d.a.a("open user info or choose address fun page");
                    return m(bVar, bVar2);
                }
            }
            b.a.p0.a.t1.d.a.a("params parse fail");
            return new b.a.p0.a.u.h.b(202, "params parse fail");
        }
        return (b.a.p0.a.u.h.b) invokeLL.objValue;
    }

    public abstract b.a.p0.a.u.h.b m(b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2);
}
