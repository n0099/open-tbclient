package c.a.p0.a.m1.d.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends c.a.p0.a.m1.d.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.m1.d.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0387a implements c.a.p0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.d.b.b f6496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.j.b f6497f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6498g;

        public C0387a(a aVar, c.a.p0.a.m1.d.b.b bVar, c.a.p0.a.x.j.b bVar2) {
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
            this.f6498g = aVar;
            this.f6496e = bVar;
            this.f6497f = bVar2;
        }

        @Override // c.a.p0.a.c.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    c.a.p0.a.m1.d.c.a aVar = new c.a.p0.a.m1.d.c.a(this.f6496e.f6488f);
                    aVar.a = this.f6496e.f6487e;
                    this.f6497f.a(aVar);
                    return;
                }
                this.f6498g.o(this.f6496e, this.f6497f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f6499e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f6500f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m1.d.b.b f6501g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.j.b f6502h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f6503i;

        public b(a aVar, c.a.p0.a.t1.e eVar, SwanAppActivity swanAppActivity, c.a.p0.a.m1.d.b.b bVar, c.a.p0.a.x.j.b bVar2) {
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
            this.f6503i = aVar;
            this.f6499e = eVar;
            this.f6500f = swanAppActivity;
            this.f6501g = bVar;
            this.f6502h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f6503i.p(this.f6500f, this.f6499e.N(), this.f6501g, aVar, this.f6502h);
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

    @Override // c.a.p0.a.m1.d.d.b
    public c.a.p0.a.m1.d.b.a f(c.a.p0.a.m1.d.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            return null;
        }
        return (c.a.p0.a.m1.d.b.a) invokeL.objValue;
    }

    @Override // c.a.p0.a.m1.d.d.b
    public c.a.p0.a.k.h.b j(String str, c.a.p0.a.m1.d.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) ? new c.a.p0.a.k.h.b(0) : (c.a.p0.a.k.h.b) invokeLL.objValue;
    }

    @Override // c.a.p0.a.m1.d.d.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.m1.d.d.b
    public c.a.p0.a.k.h.b m(c.a.p0.a.m1.d.b.b bVar, c.a.p0.a.x.j.b<c.a.p0.a.m1.d.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.a)) {
                return new c.a.p0.a.k.h.b(1001, "get fun page info, provider appKey is empty");
            }
            if (bVar2 == null) {
                return new c.a.p0.a.k.h.b(1001, "get fun page info, cb is null");
            }
            c.a.p0.a.t1.e r = c.a.p0.a.t1.d.J().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.M().e(r)) {
                    r.M().f(x, null, new C0387a(this, bVar, bVar2));
                    return new c.a.p0.a.k.h.b(1001, "not login");
                }
                o(bVar, bVar2);
                return new c.a.p0.a.k.h.b(0);
            }
            return new c.a.p0.a.k.h.b(1001, "get fun page info, master has dead");
        }
        return (c.a.p0.a.k.h.b) invokeLL.objValue;
    }

    public final void o(c.a.p0.a.m1.d.b.b bVar, c.a.p0.a.x.j.b<c.a.p0.a.m1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            c.a.p0.a.m1.e.a.b("start get open data");
            c.a.p0.a.t1.e r = c.a.p0.a.t1.d.J().r();
            SwanAppActivity x = r.x();
            c.a.p0.a.x1.d.a.B(x, g(), bVar.a, true, h(), new b(this, r, x, bVar, bVar2));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, c.a.p0.a.m1.d.b.b bVar, c.a.p0.a.x1.d.a aVar, c.a.p0.a.x.j.b<c.a.p0.a.m1.d.c.a> bVar2);
}
