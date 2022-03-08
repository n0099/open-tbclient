package c.a.q0.a1.a;

import c.a.q0.a1.e.c;
import c.a.q0.a1.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.model.LoadType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a<Q extends c, P extends d> implements b<Q, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f11931b;

    /* renamed from: c  reason: collision with root package name */
    public int f11932c;

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
        this.f11931b = 1;
        this.f11932c = 1;
    }

    @Override // c.a.q0.a1.a.b
    public void a(Q q, P p) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, q, p) == null) || p == null) {
            return;
        }
        if (p.getPageInfo() != null) {
            c.a.q0.a1.d.b pageInfo = p.getPageInfo();
            this.f11932c = pageInfo.a;
            this.a = pageInfo.f12002b;
            if (q != null && q.c() != null) {
                q.c().f12001d = pageInfo.f12003c;
            }
        }
        if (this.f11932c <= 0 && q != null && q.c() != null && q.c().f12000c > 0) {
            this.f11932c = q.c().f12000c;
            this.a = true;
        }
        c.a.q0.a1.h.a.b("onResp--->pn=" + this.f11932c + ",hasMore=" + this.a);
    }

    @Override // c.a.q0.a1.a.b
    public void b(Q q, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q, z) == null) || q == null || q.c() == null) {
            return;
        }
        c.a.q0.a1.d.a c2 = q.c();
        if (z) {
            if (!c2.a()) {
                this.f11932c = this.f11931b;
            }
            c2.f11999b = c2.a() ? LoadType.PREPEND : LoadType.REFRESH;
            c2.f12000c = this.f11932c;
        } else {
            int i2 = this.f11932c + 1;
            this.f11932c = i2;
            c2.f11999b = LoadType.APPEND;
            c2.f12000c = i2;
        }
        c.a.q0.a1.h.a.b("onReq--->pn=" + this.f11932c + ",hasMore=" + this.a + ",isPullRefresh=" + z + ",loadType=" + c2.f11999b);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
