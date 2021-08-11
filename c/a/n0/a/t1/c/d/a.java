package c.a.n0.a.t1.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends c.a.n0.a.t1.c.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.t1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0369a implements c.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.c.b.b f8407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.j.b f8408f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f8409g;

        public C0369a(a aVar, c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.h0.j.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8409g = aVar;
            this.f8407e = bVar;
            this.f8408f = bVar2;
        }

        @Override // c.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    c.a.n0.a.t1.c.c.a aVar = new c.a.n0.a.t1.c.c.a(this.f8407e.f8397f);
                    aVar.f8401a = this.f8407e.f8396e;
                    this.f8408f.a(aVar);
                    return;
                }
                this.f8409g.o(this.f8407e, this.f8408f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.v2.e1.b<c.a.n0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.a2.e f8410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f8411f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.c.b.b f8412g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.j.b f8413h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f8414i;

        public b(a aVar, c.a.n0.a.a2.e eVar, SwanAppActivity swanAppActivity, c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.h0.j.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, swanAppActivity, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8414i = aVar;
            this.f8410e = eVar;
            this.f8411f = swanAppActivity;
            this.f8412g = bVar;
            this.f8413h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.n0.a.e2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f8414i.p(this.f8411f, this.f8410e.D(), this.f8412g, aVar, this.f8413h);
            }
        }
    }

    public a() {
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

    @Override // c.a.n0.a.t1.c.d.b
    public c.a.n0.a.t1.c.b.a f(c.a.n0.a.t1.c.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            return null;
        }
        return (c.a.n0.a.t1.c.b.a) invokeL.objValue;
    }

    @Override // c.a.n0.a.t1.c.d.b
    public c.a.n0.a.u.h.b j(String str, c.a.n0.a.t1.c.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) ? new c.a.n0.a.u.h.b(0) : (c.a.n0.a.u.h.b) invokeLL.objValue;
    }

    @Override // c.a.n0.a.t1.c.d.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.t1.c.d.b
    public c.a.n0.a.u.h.b m(c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f8392a)) {
                return new c.a.n0.a.u.h.b(1001, "get fun page info, provider appKey is empty");
            }
            if (bVar2 == null) {
                return new c.a.n0.a.u.h.b(1001, "get fun page info, cb is null");
            }
            c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.j().e(r)) {
                    r.j().f(x, null, new C0369a(this, bVar, bVar2));
                    return new c.a.n0.a.u.h.b(1001, "not login");
                }
                o(bVar, bVar2);
                return new c.a.n0.a.u.h.b(0);
            }
            return new c.a.n0.a.u.h.b(1001, "get fun page info, master has dead");
        }
        return (c.a.n0.a.u.h.b) invokeLL.objValue;
    }

    public final void o(c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            c.a.n0.a.t1.d.a.a("start get open data");
            c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            c.a.n0.a.e2.d.a.C(x, g(), bVar.f8392a, true, h(), new b(this, r, x, bVar, bVar2));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.e2.d.a aVar, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2);
}
