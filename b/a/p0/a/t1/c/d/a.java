package b.a.p0.a.t1.c.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends b.a.p0.a.t1.c.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.t1.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0374a implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.t1.c.b.b f7955e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f7956f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7957g;

        public C0374a(a aVar, b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.h0.j.b bVar2) {
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
            this.f7957g = aVar;
            this.f7955e = bVar;
            this.f7956f = bVar2;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    b.a.p0.a.t1.c.c.a aVar = new b.a.p0.a.t1.c.c.a(this.f7955e.f7945f);
                    aVar.f7949a = this.f7955e.f7944e;
                    this.f7956f.a(aVar);
                    return;
                }
                this.f7957g.o(this.f7955e, this.f7956f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f7958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f7959f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.t1.c.b.b f7960g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f7961h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f7962i;

        public b(a aVar, b.a.p0.a.a2.e eVar, SwanAppActivity swanAppActivity, b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.h0.j.b bVar2) {
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
            this.f7962i = aVar;
            this.f7958e = eVar;
            this.f7959f = swanAppActivity;
            this.f7960g = bVar;
            this.f7961h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f7962i.p(this.f7959f, this.f7958e.k(), this.f7960g, aVar, this.f7961h);
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

    @Override // b.a.p0.a.t1.c.d.b
    public b.a.p0.a.t1.c.b.a f(b.a.p0.a.t1.c.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            return null;
        }
        return (b.a.p0.a.t1.c.b.a) invokeL.objValue;
    }

    @Override // b.a.p0.a.t1.c.d.b
    public b.a.p0.a.u.h.b j(String str, b.a.p0.a.t1.c.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) ? new b.a.p0.a.u.h.b(0) : (b.a.p0.a.u.h.b) invokeLL.objValue;
    }

    @Override // b.a.p0.a.t1.c.d.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.t1.c.d.b
    public b.a.p0.a.u.h.b m(b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f7940a)) {
                return new b.a.p0.a.u.h.b(1001, "get fun page info, provider appKey is empty");
            }
            if (bVar2 == null) {
                return new b.a.p0.a.u.h.b(1001, "get fun page info, cb is null");
            }
            b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.j().e(r)) {
                    r.j().f(x, null, new C0374a(this, bVar, bVar2));
                    return new b.a.p0.a.u.h.b(1001, "not login");
                }
                o(bVar, bVar2);
                return new b.a.p0.a.u.h.b(0);
            }
            return new b.a.p0.a.u.h.b(1001, "get fun page info, master has dead");
        }
        return (b.a.p0.a.u.h.b) invokeLL.objValue;
    }

    public final void o(b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            b.a.p0.a.t1.d.a.a("start get open data");
            b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
            SwanAppActivity x = r.x();
            b.a.p0.a.e2.d.a.C(x, g(), bVar.f7940a, true, h(), new b(this, r, x, bVar, bVar2));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.e2.d.a aVar, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2);
}
