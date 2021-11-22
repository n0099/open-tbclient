package b.a.r0.a3.k0;

import android.view.ViewStub;
import b.a.e.f.p.l;
import b.a.r0.a3.e;
import b.a.r0.a3.o;
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
public class b implements b.a.r0.a3.e0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f15807a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15808b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15809c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15810d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15811e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15812f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15813g;

    /* renamed from: h  reason: collision with root package name */
    public final int f15814h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f15815i;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15808b = b.a.r0.a.h().n();
        this.f15809c = b.a.r0.a.h().q();
        this.f15810d = b.a.r0.a.h().k();
        this.f15811e = b.a.r0.a.h().l() - 1;
        this.f15812f = b.a.r0.a.h().m();
        this.f15813g = b.a.r0.a.h().p();
        this.f15814h = b.a.r0.a.h().o();
        this.j = e.a("daily_show_count");
        this.f15815i = new HashMap();
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int r = b.a.r0.a.h().r();
        a aVar2 = new a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", aVar);
        this.f15807a = aVar2;
        aVar2.e(r);
        this.f15807a.f(true);
    }

    @Override // b.a.r0.a3.e0.a
    public AdvertAppInfo c(b.a.q0.c1.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            if (!eVar.j && !eVar.k) {
                int i2 = eVar.f12765c;
                String str = eVar.f12769g;
                int i3 = eVar.f12766d;
                int i4 = eVar.f12771i;
                float f2 = eVar.f12768f;
                int i5 = eVar.f12770h;
                t(i2, i3, i4, eVar);
                if (this.f15815i.containsKey(str)) {
                    return this.f15815i.get(str);
                }
                if (r(i2, i3) && s(i5, f2, eVar.f12767e)) {
                    AdvertAppInfo i6 = this.f15807a.i();
                    if (i6 != null) {
                        i6.i4 = "PIC_PAGE_BANNER";
                        i6.position = i2;
                        this.f15815i.put(str, i6);
                        int i7 = this.j + 1;
                        this.j = i7;
                        e.g("daily_show_count", i7);
                    }
                    return i6;
                }
            }
            return null;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // b.a.r0.a3.e0.a
    public o h(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new b.a.r0.a3.i0.d.a.c(viewStub, tbPageContext) : (o) invokeLL.objValue;
    }

    @Override // b.a.r0.a3.e0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15807a.b();
        }
    }

    public final Map<String, String> q(b.a.q0.c1.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", eVar.l);
            hashMap.put("forum_name", eVar.m);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean r(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            if (i2 >= this.f15811e && i2 > i3) {
                return i3 == 0 || i2 - i3 >= this.f15812f;
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
            if (this.f15808b == 4) {
                return true;
            }
            if (f2 == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f2)) {
                return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f15808b) == 1 || i3 == 2);
            }
            int i4 = this.f15808b;
            return i4 == 3 || i4 == 1;
        }
        return invokeCommon.booleanValue;
    }

    public final void t(int i2, int i3, int i4, b.a.q0.c1.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar}) == null) || this.j >= this.f15814h) {
            return;
        }
        this.f15807a.h(this.f15810d);
        if (this.f15807a.j()) {
            return;
        }
        int i5 = i3 == 0 ? this.f15811e : this.f15812f + i3;
        if (i2 < i3 || i5 >= i4 || i2 < i5 - this.f15813g) {
            return;
        }
        this.f15807a.d(Math.min(this.f15814h - this.j, this.f15809c), q(eVar));
    }
}
