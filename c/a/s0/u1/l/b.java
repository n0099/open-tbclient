package c.a.s0.u1.l;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.d1.g;
import c.a.s0.j3.d;
import c.a.s0.j3.y;
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
    public final String f24578b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f24579c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.j3.e0.b f24580d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f24581e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24582f;

    /* renamed from: g  reason: collision with root package name */
    public d f24583g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24584h;

    /* renamed from: i  reason: collision with root package name */
    public long f24585i;

    /* renamed from: j  reason: collision with root package name */
    public int f24586j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f24587k;
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
        this.f24587k = false;
        this.l = new LinkedHashSet();
        this.f24579c = list;
        this.a = str;
        this.f24578b = str2;
        this.f24582f = z2;
        try {
            c.a.s0.j3.e0.b bVar = (c.a.s0.j3.e0.b) y.q().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f24580d = bVar;
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
            if (i2 >= this.f24579c.size()) {
                return null;
            }
            String str = (String) c.a.s0.x1.o.k.a.d(this.f24579c, i2);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!this.f24587k) {
                this.f24587k = i2 == this.f24579c.size() - 1;
            }
            View g2 = this.f24580d.g(str, this.l.add(Integer.valueOf(i2)), this.f24587k);
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
            this.f24581e = list;
            if (this.f24584h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f24579c.size()) {
            return;
        }
        String str = (String) c.a.s0.x1.o.k.a.d(this.f24579c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f24580d.p(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24580d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f24582f) {
            if (i2 < 0) {
                this.f24580d.l(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k2 = c.a.s0.x1.o.k.a.k(this.f24579c);
            String f2 = c.a.s0.j3.a.f(advertAppInfo);
            if (i2 >= k2) {
                if (!c.a.s0.j3.a.l((String) c.a.s0.x1.o.k.a.d(this.f24579c, k2 - 1)) && (z || !this.f24580d.o())) {
                    this.f24587k = true;
                    i2 = k2;
                    z2 = true;
                } else {
                    this.f24580d.l(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.f24586j + d() : (int) (i2 + this.f24585i);
            if (c.a.s0.j3.a.n(advertAppInfo)) {
                if (i2 >= k2) {
                    this.f24580d.l(advertAppInfo);
                }
                String str = (String) c.a.s0.x1.o.k.a.d(this.f24579c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f24580d.d(str, advertAppInfo);
                return;
            }
            c.a.s0.x1.o.k.a.b(this.f24579c, f2, i2);
            String str2 = (String) c.a.s0.x1.o.k.a.d(this.f24579c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f24580d.d(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || c.a.s0.x1.o.k.a.e(list) || c.a.s0.x1.o.k.a.e(this.f24579c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == c.a.s0.a.h().j() - 1 && c.a.s0.a.h().v()) {
                    if (!i()) {
                        break;
                    } else if (c.a.d.f.m.b.e(next.j4, -1) - 1 <= c.a.s0.x1.o.k.a.k(this.f24579c)) {
                        g(next);
                        break;
                    }
                }
                e(next, c.a.d.f.m.b.e(next.j4, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f24583g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, c.a.s0.x1.o.k.a.k(this.f24579c), true);
            d dVar = this.f24583g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) c.a.s0.x1.o.k.a.d(this.f24579c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f24580d.e(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.f24579c;
            String str = (String) c.a.s0.x1.o.k.a.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.m;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            return imageUrlData != null && imageUrlData.overAllIndex == ((long) this.f24586j);
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f24587k : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f24580d.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24584h = true;
            f(this.f24581e);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            String str = (String) c.a.s0.x1.o.k.a.d(this.f24579c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f24580d.k(str);
        }
    }

    public void n(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && this.f24582f) {
            this.f24584h = false;
            this.f24583g = dVar;
            this.f24580d.m();
            g gVar = new g();
            gVar.l = this.a;
            gVar.m = this.f24578b;
            this.f24580d.f(gVar);
        }
    }

    public void o(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f24585i = j2 - 1;
            this.f24586j = i2;
        }
    }
}
