package c.a.p0.w1.l;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.g;
import c.a.o0.r.e;
import c.a.p0.l3.d;
import c.a.p0.l3.z;
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
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19724b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f19725c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.l3.f0.b f19726d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f19727e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19728f;

    /* renamed from: g  reason: collision with root package name */
    public d f19729g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19730h;
    public long i;
    public int j;
    public boolean k;
    public Map<String, ImageUrlData> l;
    public TbPageContext<ImageViewerActivity> m;

    public b(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<ImageViewerActivity> tbPageContext, DragImageView.h hVar, @Nullable Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, hVar, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.f19725c = list;
        this.a = str;
        this.f19724b = str2;
        this.f19728f = z2;
        this.m = tbPageContext;
        try {
            c.a.p0.l3.f0.b bVar = (c.a.p0.l3.f0.b) z.q().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f19726d = bVar;
            bVar.j(tbPageContext, hVar, z);
        } catch (ClassCastException e2) {
            if (e.e()) {
                throw new RuntimeException(e2);
            }
        }
        this.l = map;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i >= this.f19725c.size()) {
                return null;
            }
            String str = (String) c.a.p0.b2.o.k.a.d(this.f19725c, i);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            boolean z = i == this.f19725c.size() - 1;
            this.k = z;
            View b2 = this.f19726d.b(str, z);
            if (b2 == null) {
                return null;
            }
            if (b2.getParent() != null && (b2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            viewGroup.addView(b2);
            AdvertAppInfo e2 = this.f19726d.e(str);
            if (e2 != null && (this.m.getPageActivity() instanceof c.a.a0.f.b)) {
                e2.u = c.a.a0.f.d.b(e2.u, (c.a.a0.f.b) this.m.getPageActivity(), b2);
            }
            return b2;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f19727e = list;
            if (this.f19730h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i) == null) || i >= this.f19725c.size()) {
            return;
        }
        String str = (String) c.a.p0.b2.o.k.a.d(this.f19725c, i);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f19726d.q(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19726d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.f19728f) {
            if (i < 0) {
                this.f19726d.m(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = c.a.p0.b2.o.k.a.k(this.f19725c);
            String f2 = c.a.p0.l3.a.f(advertAppInfo);
            if (i >= k) {
                if (!c.a.p0.l3.a.l((String) c.a.p0.b2.o.k.a.d(this.f19725c, k - 1)) && (z || !this.f19726d.p())) {
                    this.k = true;
                    i = k;
                    z2 = true;
                } else {
                    this.f19726d.m(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.j + d() : (int) (i + this.i);
            if (c.a.p0.l3.a.n(advertAppInfo)) {
                if (i >= k) {
                    this.f19726d.m(advertAppInfo);
                }
                String str = (String) c.a.p0.b2.o.k.a.d(this.f19725c, i);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f19726d.f(str, advertAppInfo);
                return;
            }
            c.a.p0.b2.o.k.a.b(this.f19725c, f2, i);
            String str2 = (String) c.a.p0.b2.o.k.a.d(this.f19725c, i);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f19726d.f(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || c.a.p0.b2.o.k.a.e(list) || c.a.p0.b2.o.k.a.e(this.f19725c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == c.a.p0.a.h().j() - 1 && c.a.p0.a.h().v()) {
                    if (!i()) {
                        break;
                    } else if (c.a.d.f.m.b.e(next.f29820g, -1) - 1 <= c.a.p0.b2.o.k.a.k(this.f19725c)) {
                        g(next);
                        break;
                    }
                }
                e(next, c.a.d.f.m.b.e(next.f29820g, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f19729g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, c.a.p0.b2.o.k.a.k(this.f19725c), true);
            d dVar = this.f19729g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String str = (String) c.a.p0.b2.o.k.a.d(this.f19725c, i);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f19726d.g(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.f19725c;
            String str = (String) c.a.p0.b2.o.k.a.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.l;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            return imageUrlData != null && imageUrlData.overAllIndex == ((long) this.j);
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
            this.f19726d.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f19730h = true;
            f(this.f19727e);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = (String) c.a.p0.b2.o.k.a.d(this.f19725c, i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f19726d.l(str);
        }
    }

    public void n(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && this.f19728f) {
            this.f19730h = false;
            this.f19729g = dVar;
            this.f19726d.n();
            g gVar = new g();
            gVar.l = this.a;
            gVar.m = this.f19724b;
            this.f19726d.h(gVar);
        }
    }

    public void o(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.i = j - 1;
            this.j = i;
        }
    }
}
