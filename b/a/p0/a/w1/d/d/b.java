package b.a.p0.a.w1.d.d;

import android.text.TextUtils;
import b.a.p0.a.h0.m.r.a;
import b.a.p0.q.j.m.g;
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
        public final /* synthetic */ b.a.p0.a.w1.d.b.b f9234a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f9235b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f9236c;

        public a(b bVar, b.a.p0.a.w1.d.b.b bVar2, b.a.p0.a.h0.j.b bVar3) {
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
            this.f9236c = bVar;
            this.f9234a = bVar2;
            this.f9235b = bVar3;
        }

        @Override // b.a.p0.a.h0.m.r.a.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.w1.e.a.b("payment fun page, your pkg is latest");
            }
        }

        @Override // b.a.p0.a.h0.m.r.a.b
        public void b(b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f9236c.d(this.f9234a, false, this.f9235b);
            }
        }

        @Override // b.a.p0.a.h0.m.r.a.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f9236c.d(this.f9234a, true, this.f9235b);
            }
        }
    }

    /* renamed from: b.a.p0.a.w1.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0462b implements b.a.p0.a.h0.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.w1.d.b.b f9237a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f9238b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f9239c;

        public C0462b(b bVar, b.a.p0.a.w1.d.b.b bVar2, b.a.p0.a.h0.j.b bVar3) {
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
            this.f9239c = bVar;
            this.f9237a = bVar2;
            this.f9238b = bVar3;
        }

        @Override // b.a.p0.a.h0.m.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9239c.d(this.f9237a, true, this.f9238b);
            }
        }

        @Override // b.a.p0.a.h0.m.b
        public void b(int i2, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                this.f9239c.d(this.f9237a, false, this.f9238b);
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

    public final void c(b.a.p0.a.w1.d.b.b bVar, String str, b.a.p0.a.h0.j.b<b.a.p0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str, bVar2) == null) {
            b.a.p0.a.w1.e.a.b("local has not main pkg, download fun page main pkg");
            b.a.p0.q.j.m.d dVar = new b.a.p0.q.j.m.d(str, b.a.p0.a.d2.d.J().l());
            dVar.q(0L);
            dVar.t(bVar.f9213c);
            dVar.d("3");
            b.a.p0.q.b.c(dVar, new b.a.p0.a.h0.m.r.a(str, new a(this, bVar, bVar2)));
        }
    }

    public final void d(b.a.p0.a.w1.d.b.b bVar, boolean z, b.a.p0.a.h0.j.b<b.a.p0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Boolean.valueOf(z), bVar2}) == null) {
            if (z) {
                b.a.p0.a.w1.d.b.a f2 = f(bVar);
                if (f2 != null && f2.f9210f) {
                    b.a.p0.a.w1.e.a.b("payment fun page, download success, ready to jump");
                    j(f2.f9207c, bVar);
                    return;
                }
                b.a.p0.a.w1.e.a.b("payment fun page, download success, but not exist");
                b.a.p0.a.w1.d.c.a aVar = new b.a.p0.a.w1.d.c.a(bVar.f9216f);
                aVar.f9220a = bVar.f9215e;
                bVar2.a(aVar);
                return;
            }
            b.a.p0.a.w1.e.a.b("payment fun page, download failed");
            b.a.p0.a.w1.d.c.a aVar2 = new b.a.p0.a.w1.d.c.a(bVar.f9216f);
            aVar2.f9220a = bVar.f9215e;
            bVar2.a(aVar2);
        }
    }

    public final void e(b.a.p0.a.w1.d.b.b bVar, b.a.p0.a.w1.d.b.a aVar, b.a.p0.a.h0.j.b<b.a.p0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, aVar, bVar2) == null) {
            b.a.p0.a.w1.e.a.b("main pkg is exist, download fun page sub pkg");
            String str = aVar.f9205a;
            int i2 = aVar.f9208d;
            b.a.p0.q.b.h(new g(str, i2, b.a.p0.a.w1.h.b.e(aVar.f9207c, aVar.f9206b), 0), new b.a.p0.a.h0.m.t.a(str, String.valueOf(i2), new C0462b(this, bVar, bVar2)));
        }
    }

    public abstract b.a.p0.a.w1.d.b.a f(b.a.p0.a.w1.d.b.b bVar);

    public abstract String g();

    public abstract String h();

    public final boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(str, MiniApp.MINIAPP_VERSION_DEVELOP) : invokeL.booleanValue;
    }

    public abstract b.a.p0.a.u.h.b j(String str, b.a.p0.a.w1.d.b.b bVar);

    public abstract boolean k();

    public final b.a.p0.a.u.h.b l(b.a.p0.a.w1.d.b.b bVar, b.a.p0.a.h0.j.b<b.a.p0.a.w1.d.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bVar, bVar2)) == null) {
            b.a.p0.a.w1.e.a.b("open fun page start");
            if (bVar != null && bVar.a()) {
                b.a.p0.a.u.h.b b2 = b(bVar.f9217g);
                if (b2 != null) {
                    b.a.p0.a.w1.e.a.b("fun page args params invalid");
                    return b2;
                } else if (k()) {
                    b.a.p0.a.w1.e.a.b("open payment fun page");
                    b.a.p0.a.w1.d.b.a f2 = f(bVar);
                    if (f2 == null) {
                        return new b.a.p0.a.u.h.b(1001, "fun page not exists");
                    }
                    if (!f2.f9210f) {
                        b.a.p0.a.w1.e.a.b("payment fun page, " + bVar.f9214d + " mode");
                        if (i(bVar.f9214d)) {
                            if (f2.f9209e) {
                                e(bVar, f2, bVar2);
                            } else {
                                return new b.a.p0.a.u.h.b(1001, "fun page not exists");
                            }
                        } else if (f2.f9209e) {
                            e(bVar, f2, bVar2);
                        } else {
                            c(bVar, f2.f9205a, bVar2);
                        }
                        b.a.p0.a.w1.e.a.b("open fun page end");
                        return new b.a.p0.a.u.h.b(0);
                    }
                    return j(f2.f9207c, bVar);
                } else {
                    b.a.p0.a.w1.e.a.b("open user info or choose address fun page");
                    return m(bVar, bVar2);
                }
            }
            b.a.p0.a.w1.e.a.b("params parse fail");
            return new b.a.p0.a.u.h.b(202, "params parse fail");
        }
        return (b.a.p0.a.u.h.b) invokeLL.objValue;
    }

    public abstract b.a.p0.a.u.h.b m(b.a.p0.a.w1.d.b.b bVar, b.a.p0.a.h0.j.b<b.a.p0.a.w1.d.c.a> bVar2);
}
