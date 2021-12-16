package c.a.q0.a.w1.d.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends c.a.q0.a.w1.d.d.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.q0.a.w1.d.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0551a implements c.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.w1.d.b.b f9002e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.j.b f9003f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f9004g;

        public C0551a(a aVar, c.a.q0.a.w1.d.b.b bVar, c.a.q0.a.h0.j.b bVar2) {
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
            this.f9004g = aVar;
            this.f9002e = bVar;
            this.f9003f = bVar2;
        }

        @Override // c.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    c.a.q0.a.w1.d.c.a aVar = new c.a.q0.a.w1.d.c.a(this.f9002e.f8994f);
                    aVar.a = this.f9002e.f8993e;
                    this.f9003f.a(aVar);
                    return;
                }
                this.f9004g.o(this.f9002e, this.f9003f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.q0.a.z2.g1.c<c.a.q0.a.h2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.d2.e f9005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f9006f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.w1.d.b.b f9007g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.h0.j.b f9008h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f9009i;

        public b(a aVar, c.a.q0.a.d2.e eVar, SwanAppActivity swanAppActivity, c.a.q0.a.w1.d.b.b bVar, c.a.q0.a.h0.j.b bVar2) {
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
            this.f9009i = aVar;
            this.f9005e = eVar;
            this.f9006f = swanAppActivity;
            this.f9007g = bVar;
            this.f9008h = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.q0.a.h2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f9009i.p(this.f9006f, this.f9005e.N(), this.f9007g, aVar, this.f9008h);
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

    @Override // c.a.q0.a.w1.d.d.b
    public c.a.q0.a.w1.d.b.a f(c.a.q0.a.w1.d.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            return null;
        }
        return (c.a.q0.a.w1.d.b.a) invokeL.objValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public c.a.q0.a.u.h.b j(String str, c.a.q0.a.w1.d.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bVar)) == null) ? new c.a.q0.a.u.h.b(0) : (c.a.q0.a.u.h.b) invokeLL.objValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public c.a.q0.a.u.h.b m(c.a.q0.a.w1.d.b.b bVar, c.a.q0.a.h0.j.b<c.a.q0.a.w1.d.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, bVar2)) == null) {
            if (bVar == null || TextUtils.isEmpty(bVar.a)) {
                return new c.a.q0.a.u.h.b(1001, "get fun page info, provider appKey is empty");
            }
            if (bVar2 == null) {
                return new c.a.q0.a.u.h.b(1001, "get fun page info, cb is null");
            }
            c.a.q0.a.d2.e r = c.a.q0.a.d2.d.J().r();
            SwanAppActivity x = r.x();
            if (x != null && !x.isFinishing()) {
                if (!r.M().e(r)) {
                    r.M().f(x, null, new C0551a(this, bVar, bVar2));
                    return new c.a.q0.a.u.h.b(1001, "not login");
                }
                o(bVar, bVar2);
                return new c.a.q0.a.u.h.b(0);
            }
            return new c.a.q0.a.u.h.b(1001, "get fun page info, master has dead");
        }
        return (c.a.q0.a.u.h.b) invokeLL.objValue;
    }

    public final void o(c.a.q0.a.w1.d.b.b bVar, c.a.q0.a.h0.j.b<c.a.q0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, bVar2) == null) {
            c.a.q0.a.w1.e.a.b("start get open data");
            c.a.q0.a.d2.e r = c.a.q0.a.d2.d.J().r();
            SwanAppActivity x = r.x();
            c.a.q0.a.h2.d.a.B(x, g(), bVar.a, true, h(), new b(this, r, x, bVar, bVar2));
        }
    }

    public abstract void p(SwanAppActivity swanAppActivity, String str, c.a.q0.a.w1.d.b.b bVar, c.a.q0.a.h2.d.a aVar, c.a.q0.a.h0.j.b<c.a.q0.a.w1.d.c.a> bVar2);
}
