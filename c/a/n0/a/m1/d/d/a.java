package c.a.n0.a.m1.d.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends c.a.n0.a.m1.d.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.m1.d.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0375a implements c.a.n0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.m1.d.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.j.b f5458b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f5459c;

        public C0375a(a aVar, c.a.n0.a.m1.d.b.b bVar, c.a.n0.a.x.j.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5459c = aVar;
            this.a = bVar;
            this.f5458b = bVar2;
        }

        @Override // c.a.n0.a.c.a
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    c.a.n0.a.m1.d.c.a aVar = new c.a.n0.a.m1.d.c.a(this.a.f5451f);
                    aVar.a = this.a.f5450e;
                    this.f5458b.a(aVar);
                    return;
                }
                this.f5459c.o(this.a, this.f5458b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f5460b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.m1.d.b.b f5461c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.j.b f5462d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5463e;

        public b(a aVar, c.a.n0.a.t1.e eVar, SwanAppActivity swanAppActivity, c.a.n0.a.m1.d.b.b bVar, c.a.n0.a.x.j.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, swanAppActivity, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5463e = aVar;
            this.a = eVar;
            this.f5460b = swanAppActivity;
            this.f5461c = bVar;
            this.f5462d = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f5463e.p(this.f5460b, this.a.N(), this.f5461c, aVar, this.f5462d);
            }
        }
    }

    public a() {
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

    @Override // c.a.n0.a.m1.d.d.b
    public c.a.n0.a.m1.d.b.a f(c.a.n0.a.m1.d.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            return null;
        }
        return (c.a.n0.a.m1.d.b.a) invokeL.objValue;
    }

    @Override // c.a.n0.a.m1.d.d.b
    public c.a.n0.a.k.h.b j(String str, c.a.n0.a.m1.d.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) ? new c.a.n0.a.k.h.b(0) : (c.a.n0.a.k.h.b) invokeLL.objValue;
    }

    @Override // c.a.n0.a.m1.d.d.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.m1.d.d.b
    public c.a.n0.a.k.h.b m(c.a.n0.a.m1.d.b.b bVar, c.a.n0.a.x.j.b<c.a.n0.a.m1.d.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.a)) {
                return new c.a.n0.a.k.h.b(1001, "get fun page info, provider appKey is empty");
            }
            if (bVar2 == null) {
                return new c.a.n0.a.k.h.b(1001, "get fun page info, cb is null");
            }
            c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.M().e(r)) {
                    r.M().f(x, null, new C0375a(this, bVar, bVar2));
                    return new c.a.n0.a.k.h.b(1001, "not login");
                }
                o(bVar, bVar2);
                return new c.a.n0.a.k.h.b(0);
            }
            return new c.a.n0.a.k.h.b(1001, "get fun page info, master has dead");
        }
        return (c.a.n0.a.k.h.b) invokeLL.objValue;
    }

    public final void o(c.a.n0.a.m1.d.b.b bVar, c.a.n0.a.x.j.b<c.a.n0.a.m1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            c.a.n0.a.m1.e.a.b("start get open data");
            c.a.n0.a.t1.e r = c.a.n0.a.t1.d.J().r();
            SwanAppActivity x = r.x();
            c.a.n0.a.x1.d.a.B(x, g(), bVar.a, true, h(), new b(this, r, x, bVar, bVar2));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, c.a.n0.a.m1.d.b.b bVar, c.a.n0.a.x1.d.a aVar, c.a.n0.a.x.j.b<c.a.n0.a.m1.d.c.a> bVar2);
}
