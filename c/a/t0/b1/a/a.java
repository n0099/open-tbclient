package c.a.t0.b1.a;

import c.a.t0.b1.e.c;
import c.a.t0.b1.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a<Q extends c, P extends d> implements b<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f12514b;

    /* renamed from: c  reason: collision with root package name */
    public int f12515c;

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
                return;
            }
        }
        this.a = true;
        this.f12514b = 1;
        this.f12515c = 1;
    }

    @Override // c.a.t0.b1.a.b
    public void a(Q q, P p) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, q, p) == null) || p == null) {
            return;
        }
        if (p.getPageInfo() != null) {
            c.a.t0.b1.d.b pageInfo = p.getPageInfo();
            this.f12515c = pageInfo.a;
            this.a = pageInfo.f12585b;
            if (q != null && q.c() != null) {
                q.c().f12584d = pageInfo.f12586c;
            }
        }
        if (this.f12515c <= 0 && q != null && q.c() != null && q.c().f12583c > 0) {
            this.f12515c = q.c().f12583c;
            this.a = true;
        }
        c.a.t0.b1.h.a.b("onResp--->pn=" + this.f12515c + ",hasMore=" + this.a);
    }

    @Override // c.a.t0.b1.a.b
    public void b(Q q, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q, z) == null) || q == null || q.c() == null) {
            return;
        }
        c.a.t0.b1.d.a c2 = q.c();
        if (z) {
            if (!c2.a()) {
                this.f12515c = this.f12514b;
            }
            c2.f12582b = c2.a() ? LoadType.PREPEND : LoadType.REFRESH;
            c2.f12583c = this.f12515c;
        } else {
            int i2 = this.f12515c + 1;
            this.f12515c = i2;
            c2.f12582b = LoadType.APPEND;
            c2.f12583c = i2;
        }
        c.a.t0.b1.h.a.b("onReq--->pn=" + this.f12515c + ",hasMore=" + this.a + ",isPullRefresh=" + z + ",loadType=" + c2.f12582b);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
