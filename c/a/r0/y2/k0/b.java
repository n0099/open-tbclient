package c.a.r0.y2.k0;

import android.view.ViewStub;
import c.a.e.e.p.l;
import c.a.r0.y2.e;
import c.a.r0.y2.o;
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
public class b implements c.a.r0.y2.e0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f29566a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29567b;

    /* renamed from: c  reason: collision with root package name */
    public final int f29568c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29569d;

    /* renamed from: e  reason: collision with root package name */
    public final int f29570e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29571f;

    /* renamed from: g  reason: collision with root package name */
    public final int f29572g;

    /* renamed from: h  reason: collision with root package name */
    public final int f29573h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f29574i;

    /* renamed from: j  reason: collision with root package name */
    public int f29575j;
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
        this.f29567b = c.a.r0.a.h().n();
        this.f29568c = c.a.r0.a.h().q();
        this.f29569d = c.a.r0.a.h().k();
        this.f29570e = c.a.r0.a.h().l() - 1;
        this.f29571f = c.a.r0.a.h().m();
        this.f29572g = c.a.r0.a.h().p();
        this.f29573h = c.a.r0.a.h().o();
        this.f29575j = e.a("daily_show_count");
        this.f29574i = new HashMap();
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int r = c.a.r0.a.h().r();
        a aVar2 = new a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", aVar);
        this.f29566a = aVar2;
        aVar2.e(r);
        this.f29566a.f(true);
    }

    @Override // c.a.r0.y2.e0.a
    public AdvertAppInfo c(c.a.q0.d1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (!cVar.f12903j && !cVar.k) {
                int i2 = cVar.f12896c;
                String str = cVar.f12900g;
                int i3 = cVar.f12897d;
                int i4 = cVar.f12902i;
                float f2 = cVar.f12899f;
                int i5 = cVar.f12901h;
                t(i2, i3, i4, cVar);
                if (this.f29574i.containsKey(str)) {
                    return this.f29574i.get(str);
                }
                if (r(i2, i3) && s(i5, f2, cVar.f12898e)) {
                    AdvertAppInfo i6 = this.f29566a.i();
                    if (i6 != null) {
                        i6.g4 = "PIC_PAGE_BANNER";
                        i6.position = i2;
                        this.f29574i.put(str, i6);
                        int i7 = this.f29575j + 1;
                        this.f29575j = i7;
                        e.g("daily_show_count", i7);
                    }
                    return i6;
                }
            }
            return null;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // c.a.r0.y2.e0.a
    public o i(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new c.a.r0.y2.i0.d.a.c(viewStub, tbPageContext) : (o) invokeLL.objValue;
    }

    @Override // c.a.r0.y2.e0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29566a.b();
        }
    }

    public final Map<String, String> q(c.a.q0.d1.c cVar) {
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
            if (i2 >= this.f29570e && i2 > i3) {
                return i3 == 0 || i2 - i3 >= this.f29571f;
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
            if (this.f29567b == 4) {
                return true;
            }
            if (f2 == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f2)) {
                return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f29567b) == 1 || i3 == 2);
            }
            int i4 = this.f29567b;
            return i4 == 3 || i4 == 1;
        }
        return invokeCommon.booleanValue;
    }

    public final void t(int i2, int i3, int i4, c.a.q0.d1.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), cVar}) == null) || this.f29575j >= this.f29573h) {
            return;
        }
        this.f29566a.h(this.f29569d);
        if (this.f29566a.j()) {
            return;
        }
        int i5 = i3 == 0 ? this.f29570e : this.f29571f + i3;
        if (i2 < i3 || i5 >= i4 || i2 < i5 - this.f29572g) {
            return;
        }
        this.f29566a.d(Math.min(this.f29573h - this.f29575j, this.f29568c), q(cVar));
    }
}
