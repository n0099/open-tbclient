package c.a.u0.v1.l;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.g;
import c.a.t0.s.e;
import c.a.u0.l3.d;
import c.a.u0.l3.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class b implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24869b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f24870c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.u0.l3.e0.b f24871d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f24872e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24873f;

    /* renamed from: g  reason: collision with root package name */
    public d f24874g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24875h;

    /* renamed from: i  reason: collision with root package name */
    public long f24876i;

    /* renamed from: j  reason: collision with root package name */
    public int f24877j;
    public boolean k;
    public Set<Integer> l;
    public Map<String, ImageUrlData> m;

    public b(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<ImageViewerActivity> tbPageContext, DragImageView.h hVar, @Nullable Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, hVar, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = new LinkedHashSet();
        this.f24870c = list;
        this.a = str;
        this.f24869b = str2;
        this.f24873f = z2;
        try {
            c.a.u0.l3.e0.b bVar = (c.a.u0.l3.e0.b) y.q().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f24871d = bVar;
            bVar.i(tbPageContext, hVar, z);
        } catch (ClassCastException e2) {
            if (e.e()) {
                throw new RuntimeException(e2);
            }
        }
        this.m = map;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 >= this.f24870c.size()) {
                return null;
            }
            String str = (String) c.a.u0.z1.o.k.a.d(this.f24870c, i2);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.k = i2 == this.f24870c.size() - 1;
            View g2 = this.f24871d.g(str, this.l.add(Integer.valueOf(i2)), this.k);
            if (g2 == null) {
                return null;
            }
            if (g2.getParent() != null && (g2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) g2.getParent()).removeView(g2);
            }
            viewGroup.addView(g2);
            return g2;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f24872e = list;
            if (this.f24875h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f24870c.size()) {
            return;
        }
        String str = (String) c.a.u0.z1.o.k.a.d(this.f24870c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24871d.p(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24871d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f24873f) {
            if (i2 < 0) {
                this.f24871d.l(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = c.a.u0.z1.o.k.a.k(this.f24870c);
            String f2 = c.a.u0.l3.a.f(advertAppInfo);
            if (i2 >= k) {
                if (!c.a.u0.l3.a.l((String) c.a.u0.z1.o.k.a.d(this.f24870c, k - 1)) && (z || !this.f24871d.o())) {
                    this.k = true;
                    i2 = k;
                    z2 = true;
                } else {
                    this.f24871d.l(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.f24877j + d() : (int) (i2 + this.f24876i);
            if (c.a.u0.l3.a.n(advertAppInfo)) {
                if (i2 >= k) {
                    this.f24871d.l(advertAppInfo);
                }
                String str = (String) c.a.u0.z1.o.k.a.d(this.f24870c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f24871d.d(str, advertAppInfo);
                return;
            }
            c.a.u0.z1.o.k.a.b(this.f24870c, f2, i2);
            String str2 = (String) c.a.u0.z1.o.k.a.d(this.f24870c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f24871d.d(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || c.a.u0.z1.o.k.a.e(list) || c.a.u0.z1.o.k.a.e(this.f24870c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == c.a.u0.a.h().j() - 1 && c.a.u0.a.h().v()) {
                    if (!i()) {
                        break;
                    } else if (c.a.d.f.m.b.e(next.m4, -1) - 1 <= c.a.u0.z1.o.k.a.k(this.f24870c)) {
                        g(next);
                        break;
                    }
                }
                e(next, c.a.d.f.m.b.e(next.m4, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f24874g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, c.a.u0.z1.o.k.a.k(this.f24870c), true);
            d dVar = this.f24874g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) c.a.u0.z1.o.k.a.d(this.f24870c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f24871d.e(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.f24870c;
            String str = (String) c.a.u0.z1.o.k.a.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.m;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            return imageUrlData != null && imageUrlData.overAllIndex == ((long) this.f24877j);
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f24871d.onDestroy();
            Set<Integer> set = this.l;
            if (set != null) {
                set.clear();
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24875h = true;
            f(this.f24872e);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            String str = (String) c.a.u0.z1.o.k.a.d(this.f24870c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f24871d.k(str);
        }
    }

    public void n(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && this.f24873f) {
            this.f24875h = false;
            this.f24874g = dVar;
            this.f24871d.m();
            g gVar = new g();
            gVar.l = this.a;
            gVar.m = this.f24869b;
            this.f24871d.f(gVar);
        }
    }

    public void o(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f24876i = j2 - 1;
            this.f24877j = i2;
        }
    }
}
