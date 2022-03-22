package c.a.o0.a1.a;

import c.a.o0.a1.e.c;
import c.a.o0.a1.e.d;
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
    public int f9731b;

    /* renamed from: c  reason: collision with root package name */
    public int f9732c;

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
                return;
            }
        }
        this.a = true;
        this.f9731b = 1;
        this.f9732c = 1;
    }

    @Override // c.a.o0.a1.a.b
    public void a(Q q, P p) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, q, p) == null) || p == null) {
            return;
        }
        if (p.getPageInfo() != null) {
            c.a.o0.a1.d.b pageInfo = p.getPageInfo();
            this.f9732c = pageInfo.a;
            this.a = pageInfo.f9781b;
            if (q != null && q.c() != null) {
                q.c().f9780d = pageInfo.f9782c;
            }
        }
        if (this.f9732c <= 0 && q != null && q.c() != null && q.c().f9779c > 0) {
            this.f9732c = q.c().f9779c;
            this.a = true;
        }
        c.a.o0.a1.h.a.b("onResp--->pn=" + this.f9732c + ",hasMore=" + this.a);
    }

    @Override // c.a.o0.a1.a.b
    public void b(Q q, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q, z) == null) || q == null || q.c() == null) {
            return;
        }
        c.a.o0.a1.d.a c2 = q.c();
        if (z) {
            if (!c2.a()) {
                this.f9732c = this.f9731b;
            }
            c2.f9778b = c2.a() ? LoadType.PREPEND : LoadType.REFRESH;
            c2.f9779c = this.f9732c;
        } else {
            int i = this.f9732c + 1;
            this.f9732c = i;
            c2.f9778b = LoadType.APPEND;
            c2.f9779c = i;
        }
        c.a.o0.a1.h.a.b("onReq--->pn=" + this.f9732c + ",hasMore=" + this.a + ",isPullRefresh=" + z + ",loadType=" + c2.f9778b);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
