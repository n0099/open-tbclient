package c.a.n0.a.t1.c.d;

import android.text.TextUtils;
import c.a.n0.a.h0.m.o.a;
import c.a.n0.n.i.m.f;
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
        public final /* synthetic */ c.a.n0.a.t1.c.b.b f8415a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.j.b f8416b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8417c;

        public a(b bVar, c.a.n0.a.t1.c.b.b bVar2, c.a.n0.a.h0.j.b bVar3) {
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
            this.f8417c = bVar;
            this.f8415a = bVar2;
            this.f8416b = bVar3;
        }

        @Override // c.a.n0.a.h0.m.o.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.t1.d.a.a("payment fun page, your pkg is latest");
            }
        }

        @Override // c.a.n0.a.h0.m.o.a.b
        public void b(c.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f8417c.d(this.f8415a, false, this.f8416b);
            }
        }

        @Override // c.a.n0.a.h0.m.o.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f8417c.d(this.f8415a, true, this.f8416b);
            }
        }
    }

    /* renamed from: c.a.n0.a.t1.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0370b implements c.a.n0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.c.b.b f8418a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.j.b f8419b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8420c;

        public C0370b(b bVar, c.a.n0.a.t1.c.b.b bVar2, c.a.n0.a.h0.j.b bVar3) {
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
            this.f8420c = bVar;
            this.f8418a = bVar2;
            this.f8419b = bVar3;
        }

        @Override // c.a.n0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8420c.d(this.f8418a, true, this.f8419b);
            }
        }

        @Override // c.a.n0.a.h0.m.b
        public void b(int i2, c.a.n0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f8420c.d(this.f8418a, false, this.f8419b);
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

    public abstract c.a.n0.a.u.h.b b(JSONObject jSONObject);

    public final void c(c.a.n0.a.t1.c.b.b bVar, String str, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str, bVar2) == null) {
            c.a.n0.a.t1.d.a.a("local has not main pkg, download fun page main pkg");
            c.a.n0.n.i.m.c cVar = new c.a.n0.n.i.m.c(str, c.a.n0.a.a2.d.g().l());
            cVar.o(0L);
            cVar.r(bVar.f8394c);
            cVar.d("3");
            c.a.n0.n.b.b(cVar, new c.a.n0.a.h0.m.o.a(str, new a(this, bVar, bVar2)));
        }
    }

    public final void d(c.a.n0.a.t1.c.b.b bVar, boolean z, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Boolean.valueOf(z), bVar2}) == null) {
            if (z) {
                c.a.n0.a.t1.c.b.a f2 = f(bVar);
                if (f2 != null && f2.f8391f) {
                    c.a.n0.a.t1.d.a.a("payment fun page, download success, ready to jump");
                    j(f2.f8388c, bVar);
                    return;
                }
                c.a.n0.a.t1.d.a.a("payment fun page, download success, but not exist");
                c.a.n0.a.t1.c.c.a aVar = new c.a.n0.a.t1.c.c.a(bVar.f8397f);
                aVar.f8401a = bVar.f8396e;
                bVar2.a(aVar);
                return;
            }
            c.a.n0.a.t1.d.a.a("payment fun page, download failed");
            c.a.n0.a.t1.c.c.a aVar2 = new c.a.n0.a.t1.c.c.a(bVar.f8397f);
            aVar2.f8401a = bVar.f8396e;
            bVar2.a(aVar2);
        }
    }

    public final void e(c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.t1.c.b.a aVar, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, aVar, bVar2) == null) {
            c.a.n0.a.t1.d.a.a("main pkg is exist, download fun page sub pkg");
            String str = aVar.f8386a;
            int i2 = aVar.f8389d;
            c.a.n0.n.b.f(new f(str, i2, c.a.n0.a.t1.g.b.e(aVar.f8388c, aVar.f8387b), 0), new c.a.n0.a.h0.m.q.a(str, String.valueOf(i2), new C0370b(this, bVar, bVar2)));
        }
    }

    public abstract c.a.n0.a.t1.c.b.a f(c.a.n0.a.t1.c.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract c.a.n0.a.u.h.b j(String str, c.a.n0.a.t1.c.b.b bVar);

    public abstract boolean k();

    public final c.a.n0.a.u.h.b l(c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bVar2)) == null) {
            c.a.n0.a.t1.d.a.a("open fun page start");
            if (bVar != null && bVar.a()) {
                c.a.n0.a.u.h.b b2 = b(bVar.f8398g);
                if (b2 != null) {
                    c.a.n0.a.t1.d.a.a("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    c.a.n0.a.t1.d.a.a("open payment fun page");
                    c.a.n0.a.t1.c.b.a f2 = f(bVar);
                    if (f2 == null) {
                        return new c.a.n0.a.u.h.b(1001, "fun page not exists");
                    }
                    if (!f2.f8391f) {
                        c.a.n0.a.t1.d.a.a("payment fun page, " + bVar.f8395d + " mode");
                        if (i(bVar.f8395d)) {
                            if (f2.f8390e) {
                                e(bVar, f2, bVar2);
                            } else {
                                return new c.a.n0.a.u.h.b(1001, "fun page not exists");
                            }
                        } else if (f2.f8390e) {
                            e(bVar, f2, bVar2);
                        } else {
                            c(bVar, f2.f8386a, bVar2);
                        }
                        c.a.n0.a.t1.d.a.a("open fun page end");
                        return new c.a.n0.a.u.h.b(0);
                    }
                    return j(f2.f8388c, bVar);
                } else {
                    c.a.n0.a.t1.d.a.a("open user info or choose address fun page");
                    return m(bVar, bVar2);
                }
            }
            c.a.n0.a.t1.d.a.a("params parse fail");
            return new c.a.n0.a.u.h.b(202, "params parse fail");
        }
        return (c.a.n0.a.u.h.b) invokeLL.objValue;
    }

    public abstract c.a.n0.a.u.h.b m(c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2);
}
