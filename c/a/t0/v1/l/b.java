package c.a.t0.v1.l;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.d1.g;
import c.a.t0.k3.d;
import c.a.t0.k3.y;
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
/* loaded from: classes8.dex */
public class b implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24687b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f24688c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.k3.e0.b f24689d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f24690e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24691f;

    /* renamed from: g  reason: collision with root package name */
    public d f24692g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24693h;

    /* renamed from: i  reason: collision with root package name */
    public long f24694i;

    /* renamed from: j  reason: collision with root package name */
    public int f24695j;
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
        this.f24688c = list;
        this.a = str;
        this.f24687b = str2;
        this.f24691f = z2;
        try {
            c.a.t0.k3.e0.b bVar = (c.a.t0.k3.e0.b) y.q().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f24689d = bVar;
            bVar.i(tbPageContext, hVar, z);
        } catch (ClassCastException unused) {
        }
        this.m = map;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 >= this.f24688c.size()) {
                return null;
            }
            String str = (String) c.a.t0.y1.o.k.a.d(this.f24688c, i2);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!this.k) {
                this.k = i2 == this.f24688c.size() - 1;
            }
            View g2 = this.f24689d.g(str, this.l.add(Integer.valueOf(i2)), this.k);
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
            this.f24690e = list;
            if (this.f24693h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f24688c.size()) {
            return;
        }
        String str = (String) c.a.t0.y1.o.k.a.d(this.f24688c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24689d.p(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24689d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f24691f) {
            if (i2 < 0) {
                this.f24689d.l(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = c.a.t0.y1.o.k.a.k(this.f24688c);
            String f2 = c.a.t0.k3.a.f(advertAppInfo);
            if (i2 >= k) {
                if (!c.a.t0.k3.a.l((String) c.a.t0.y1.o.k.a.d(this.f24688c, k - 1)) && (z || !this.f24689d.o())) {
                    this.k = true;
                    i2 = k;
                    z2 = true;
                } else {
                    this.f24689d.l(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.f24695j + d() : (int) (i2 + this.f24694i);
            if (c.a.t0.k3.a.n(advertAppInfo)) {
                if (i2 >= k) {
                    this.f24689d.l(advertAppInfo);
                }
                String str = (String) c.a.t0.y1.o.k.a.d(this.f24688c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f24689d.d(str, advertAppInfo);
                return;
            }
            c.a.t0.y1.o.k.a.b(this.f24688c, f2, i2);
            String str2 = (String) c.a.t0.y1.o.k.a.d(this.f24688c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f24689d.d(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || c.a.t0.y1.o.k.a.e(list) || c.a.t0.y1.o.k.a.e(this.f24688c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == c.a.t0.a.h().j() - 1 && c.a.t0.a.h().v()) {
                    if (!i()) {
                        break;
                    } else if (c.a.d.f.m.b.e(next.m4, -1) - 1 <= c.a.t0.y1.o.k.a.k(this.f24688c)) {
                        g(next);
                        break;
                    }
                }
                e(next, c.a.d.f.m.b.e(next.m4, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f24692g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, c.a.t0.y1.o.k.a.k(this.f24688c), true);
            d dVar = this.f24692g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) c.a.t0.y1.o.k.a.d(this.f24688c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f24689d.e(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.f24688c;
            String str = (String) c.a.t0.y1.o.k.a.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.m;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            return imageUrlData != null && imageUrlData.overAllIndex == ((long) this.f24695j);
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
            this.f24689d.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24693h = true;
            f(this.f24690e);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            String str = (String) c.a.t0.y1.o.k.a.d(this.f24688c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f24689d.k(str);
        }
    }

    public void n(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && this.f24691f) {
            this.f24693h = false;
            this.f24692g = dVar;
            this.f24689d.m();
            g gVar = new g();
            gVar.l = this.a;
            gVar.m = this.f24687b;
            this.f24689d.f(gVar);
        }
    }

    public void o(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f24694i = j2 - 1;
            this.f24695j = i2;
        }
    }
}
