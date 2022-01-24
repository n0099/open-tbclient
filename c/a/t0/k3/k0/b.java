package c.a.t0.k3.k0;

import android.view.ViewStub;
import c.a.d.f.p.n;
import c.a.s0.d1.g;
import c.a.t0.k3.e;
import c.a.t0.k3.o;
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
/* loaded from: classes7.dex */
public class b implements c.a.t0.k3.e0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;

    /* renamed from: b  reason: collision with root package name */
    public final int f18933b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18934c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18935d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18936e;

    /* renamed from: f  reason: collision with root package name */
    public final int f18937f;

    /* renamed from: g  reason: collision with root package name */
    public final int f18938g;

    /* renamed from: h  reason: collision with root package name */
    public final int f18939h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f18940i;

    /* renamed from: j  reason: collision with root package name */
    public int f18941j;
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
        this.f18933b = c.a.t0.a.h().n();
        this.f18934c = c.a.t0.a.h().q();
        this.f18935d = c.a.t0.a.h().k();
        this.f18936e = c.a.t0.a.h().l() - 1;
        this.f18937f = c.a.t0.a.h().m();
        this.f18938g = c.a.t0.a.h().p();
        this.f18939h = c.a.t0.a.h().o();
        this.f18941j = e.a("daily_show_count");
        this.f18940i = new HashMap();
        int[] p = n.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int r = c.a.t0.a.h().r();
        a aVar2 = new a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", aVar);
        this.a = aVar2;
        aVar2.e(r);
        this.a.f(true);
    }

    @Override // c.a.t0.k3.e0.a
    public AdvertAppInfo c(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            if (!gVar.f12513j && !gVar.k) {
                int i2 = gVar.f12506c;
                String str = gVar.f12510g;
                int i3 = gVar.f12507d;
                int i4 = gVar.f12512i;
                float f2 = gVar.f12509f;
                int i5 = gVar.f12511h;
                t(i2, i3, i4, gVar);
                if (this.f18940i.containsKey(str)) {
                    return this.f18940i.get(str);
                }
                if (r(i2, i3) && s(i5, f2, gVar.f12508e)) {
                    AdvertAppInfo i6 = this.a.i();
                    if (i6 != null) {
                        i6.q4 = "PIC_PAGE_BANNER";
                        i6.position = i2;
                        this.f18940i.put(str, i6);
                        int i7 = this.f18941j + 1;
                        this.f18941j = i7;
                        e.g("daily_show_count", i7);
                    }
                    return i6;
                }
            }
            return null;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // c.a.t0.k3.e0.a
    public o h(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new c.a.t0.k3.i0.d.a.c(viewStub, tbPageContext) : (o) invokeLL.objValue;
    }

    @Override // c.a.t0.k3.e0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.b();
        }
    }

    public final Map<String, String> q(g gVar) {
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

    public final boolean r(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            if (i2 >= this.f18936e && i2 > i3) {
                return i3 == 0 || i2 - i3 >= this.f18937f;
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
            if (this.f18933b == 4) {
                return true;
            }
            if (f2 == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f2)) {
                return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f18933b) == 1 || i3 == 2);
            }
            int i4 = this.f18933b;
            return i4 == 3 || i4 == 1;
        }
        return invokeCommon.booleanValue;
    }

    public final void t(int i2, int i3, int i4, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), gVar}) == null) || this.f18941j >= this.f18939h) {
            return;
        }
        this.a.h(this.f18935d);
        if (this.a.j()) {
            return;
        }
        int i5 = i3 == 0 ? this.f18936e : this.f18937f + i3;
        if (i2 < i3 || i5 >= i4 || i2 < i5 - this.f18938g) {
            return;
        }
        this.a.d(Math.min(this.f18939h - this.f18941j, this.f18934c), q(gVar));
    }
}
