package c.a.q0.x2.k0;

import android.view.ViewStub;
import c.a.e.e.p.l;
import c.a.q0.x2.e;
import c.a.q0.x2.o;
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
/* loaded from: classes4.dex */
public class b implements c.a.q0.x2.e0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f28946a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28947b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28948c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28949d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28950e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28951f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28952g;

    /* renamed from: h  reason: collision with root package name */
    public final int f28953h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f28954i;

    /* renamed from: j  reason: collision with root package name */
    public int f28955j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28947b = c.a.q0.a.h().n();
        this.f28948c = c.a.q0.a.h().q();
        this.f28949d = c.a.q0.a.h().k();
        this.f28950e = c.a.q0.a.h().l() - 1;
        this.f28951f = c.a.q0.a.h().m();
        this.f28952g = c.a.q0.a.h().p();
        this.f28953h = c.a.q0.a.h().o();
        this.f28955j = e.a("daily_show_count");
        this.f28954i = new HashMap();
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int r = c.a.q0.a.h().r();
        a aVar2 = new a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", aVar);
        this.f28946a = aVar2;
        aVar2.e(r);
        this.f28946a.f(true);
    }

    @Override // c.a.q0.x2.e0.a
    public AdvertAppInfo c(c.a.p0.b1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (!cVar.f12830j && !cVar.k) {
                int i2 = cVar.f12823c;
                String str = cVar.f12827g;
                int i3 = cVar.f12824d;
                int i4 = cVar.f12829i;
                float f2 = cVar.f12826f;
                int i5 = cVar.f12828h;
                t(i2, i3, i4, cVar);
                if (this.f28954i.containsKey(str)) {
                    return this.f28954i.get(str);
                }
                if (r(i2, i3) && s(i5, f2, cVar.f12825e)) {
                    AdvertAppInfo i6 = this.f28946a.i();
                    if (i6 != null) {
                        i6.d4 = "PIC_PAGE_BANNER";
                        i6.position = i2;
                        this.f28954i.put(str, i6);
                        int i7 = this.f28955j + 1;
                        this.f28955j = i7;
                        e.g("daily_show_count", i7);
                    }
                    return i6;
                }
            }
            return null;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // c.a.q0.x2.e0.a
    public o i(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new c.a.q0.x2.i0.d.a.c(viewStub, tbPageContext) : (o) invokeLL.objValue;
    }

    @Override // c.a.q0.x2.e0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f28946a.b();
        }
    }

    public final Map<String, String> q(c.a.p0.b1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", cVar.l);
            hashMap.put("forum_name", cVar.m);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean r(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            if (i2 >= this.f28950e && i2 > i3) {
                return i3 == 0 || i2 - i3 >= this.f28951f;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final boolean s(int i2, float f2, float f3) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f28947b == 4) {
                return true;
            }
            if (f2 == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f2)) {
                return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f28947b) == 1 || i3 == 2);
            }
            int i4 = this.f28947b;
            return i4 == 3 || i4 == 1;
        }
        return invokeCommon.booleanValue;
    }

    public final void t(int i2, int i3, int i4, c.a.p0.b1.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), cVar}) == null) || this.f28955j >= this.f28953h) {
            return;
        }
        this.f28946a.h(this.f28949d);
        if (this.f28946a.j()) {
            return;
        }
        int i5 = i3 == 0 ? this.f28950e : this.f28951f + i3;
        if (i2 < i3 || i5 >= i4 || i2 < i5 - this.f28952g) {
            return;
        }
        this.f28946a.d(Math.min(this.f28953h - this.f28955j, this.f28948c), q(cVar));
    }
}
