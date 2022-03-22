package c.a.p0.l3.l0;

import android.view.ViewStub;
import c.a.d.f.p.n;
import c.a.o0.c1.g;
import c.a.p0.l3.e;
import c.a.p0.l3.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements c.a.p0.l3.f0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16281b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16282c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16283d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16284e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16285f;

    /* renamed from: g  reason: collision with root package name */
    public final int f16286g;

    /* renamed from: h  reason: collision with root package name */
    public final int f16287h;
    public final Map<String, AdvertAppInfo> i;
    public int j;
    public final int k;
    public final int l;
    public final int m;

    public b(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16281b = c.a.p0.a.h().n();
        this.f16282c = c.a.p0.a.h().q();
        this.f16283d = c.a.p0.a.h().k();
        this.f16284e = c.a.p0.a.h().l() - 1;
        this.f16285f = c.a.p0.a.h().m();
        this.f16286g = c.a.p0.a.h().p();
        this.f16287h = c.a.p0.a.h().o();
        this.j = e.a("daily_show_count");
        this.i = new HashMap();
        int[] p = n.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int r = c.a.p0.a.h().r();
        a aVar2 = new a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", aVar);
        this.a = aVar2;
        aVar2.e(r);
        this.a.f(true);
    }

    @Override // c.a.p0.l3.f0.a
    public AdvertAppInfo d(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (!gVar.j && !gVar.k) {
                int i = gVar.f9942c;
                String str = gVar.f9946g;
                int i2 = gVar.f9943d;
                int i3 = gVar.i;
                float f2 = gVar.f9945f;
                int i4 = gVar.f9947h;
                u(i, i2, i3, gVar);
                if (this.i.containsKey(str)) {
                    return this.i.get(str);
                }
                if (s(i, i2) && t(i4, f2, gVar.f9944e)) {
                    AdvertAppInfo i5 = this.a.i();
                    if (i5 != null) {
                        i5.k = "PIC_PAGE_BANNER";
                        i5.position = i;
                        this.i.put(str, i5);
                        int i6 = this.j + 1;
                        this.j = i6;
                        e.g("daily_show_count", i6);
                    }
                    return i5;
                }
            }
            return null;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // c.a.p0.l3.f0.a
    public o i(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new c.a.p0.l3.j0.d.a.c(viewStub, tbPageContext) : (o) invokeLL.objValue;
    }

    @Override // c.a.p0.l3.f0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.b();
        }
    }

    public final Map<String, String> r(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", gVar.l);
            hashMap.put("forum_name", gVar.m);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean s(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            if (i >= this.f16284e && i > i2) {
                return i2 == 0 || i - i2 >= this.f16285f;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final boolean t(int i, float f2, float f3) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f16281b == 4) {
                return true;
            }
            if (f2 == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f2)) {
                return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i))) > this.m && ((i2 = this.f16281b) == 1 || i2 == 2);
            }
            int i3 = this.f16281b;
            return i3 == 3 || i3 == 1;
        }
        return invokeCommon.booleanValue;
    }

    public final void u(int i, int i2, int i3, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), gVar}) == null) || this.j >= this.f16287h) {
            return;
        }
        this.a.h(this.f16283d);
        if (this.a.j()) {
            return;
        }
        int i4 = i2 == 0 ? this.f16284e : this.f16285f + i2;
        if (i < i2 || i4 >= i3 || i < i4 - this.f16286g) {
            return;
        }
        this.a.d(Math.min(this.f16287h - this.j, this.f16282c), r(gVar));
    }
}
