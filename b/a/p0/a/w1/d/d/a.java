package b.a.p0.a.w1.d.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends b.a.p0.a.w1.d.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.w1.d.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0461a implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.w1.d.b.b f9226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f9227f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f9228g;

        public C0461a(a aVar, b.a.p0.a.w1.d.b.b bVar, b.a.p0.a.h0.j.b bVar2) {
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
            this.f9228g = aVar;
            this.f9226e = bVar;
            this.f9227f = bVar2;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    b.a.p0.a.w1.d.c.a aVar = new b.a.p0.a.w1.d.c.a(this.f9226e.f9216f);
                    aVar.f9220a = this.f9226e.f9215e;
                    this.f9227f.a(aVar);
                    return;
                }
                this.f9228g.o(this.f9226e, this.f9227f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f9229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f9230f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.w1.d.b.b f9231g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f9232h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f9233i;

        public b(a aVar, b.a.p0.a.d2.e eVar, SwanAppActivity swanAppActivity, b.a.p0.a.w1.d.b.b bVar, b.a.p0.a.h0.j.b bVar2) {
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
            this.f9233i = aVar;
            this.f9229e = eVar;
            this.f9230f = swanAppActivity;
            this.f9231g = bVar;
            this.f9232h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f9233i.p(this.f9230f, this.f9229e.N(), this.f9231g, aVar, this.f9232h);
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

    @Override // b.a.p0.a.w1.d.d.b
    public b.a.p0.a.w1.d.b.a f(b.a.p0.a.w1.d.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            return null;
        }
        return (b.a.p0.a.w1.d.b.a) invokeL.objValue;
    }

    @Override // b.a.p0.a.w1.d.d.b
    public b.a.p0.a.u.h.b j(String str, b.a.p0.a.w1.d.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) ? new b.a.p0.a.u.h.b(0) : (b.a.p0.a.u.h.b) invokeLL.objValue;
    }

    @Override // b.a.p0.a.w1.d.d.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.w1.d.d.b
    public b.a.p0.a.u.h.b m(b.a.p0.a.w1.d.b.b bVar, b.a.p0.a.h0.j.b<b.a.p0.a.w1.d.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.f9211a)) {
                return new b.a.p0.a.u.h.b(1001, "get fun page info, provider appKey is empty");
            }
            if (bVar2 == null) {
                return new b.a.p0.a.u.h.b(1001, "get fun page info, cb is null");
            }
            b.a.p0.a.d2.e r = b.a.p0.a.d2.d.J().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.M().e(r)) {
                    r.M().f(x, null, new C0461a(this, bVar, bVar2));
                    return new b.a.p0.a.u.h.b(1001, "not login");
                }
                o(bVar, bVar2);
                return new b.a.p0.a.u.h.b(0);
            }
            return new b.a.p0.a.u.h.b(1001, "get fun page info, master has dead");
        }
        return (b.a.p0.a.u.h.b) invokeLL.objValue;
    }

    public final void o(b.a.p0.a.w1.d.b.b bVar, b.a.p0.a.h0.j.b<b.a.p0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            b.a.p0.a.w1.e.a.b("start get open data");
            b.a.p0.a.d2.e r = b.a.p0.a.d2.d.J().r();
            SwanAppActivity x = r.x();
            b.a.p0.a.h2.d.a.B(x, g(), bVar.f9211a, true, h(), new b(this, r, x, bVar, bVar2));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, b.a.p0.a.w1.d.b.b bVar, b.a.p0.a.h2.d.a aVar, b.a.p0.a.h0.j.b<b.a.p0.a.w1.d.c.a> bVar2);
}
