package b.a.r0.n1.l;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c1.e;
import b.a.r0.a3.d;
import b.a.r0.a3.y;
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
/* loaded from: classes5.dex */
public class b implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f22889a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22890b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f22891c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.a3.e0.b f22892d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f22893e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22894f;

    /* renamed from: g  reason: collision with root package name */
    public d f22895g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22896h;

    /* renamed from: i  reason: collision with root package name */
    public long f22897i;
    public int j;
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
        this.f22891c = list;
        this.f22889a = str;
        this.f22890b = str2;
        this.f22894f = z2;
        try {
            b.a.r0.a3.e0.b bVar = (b.a.r0.a3.e0.b) y.o().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f22892d = bVar;
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
            if (i2 >= this.f22891c.size()) {
                return null;
            }
            String str = (String) b.a.r0.q1.o.k.a.d(this.f22891c, i2);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!this.k) {
                this.k = i2 == this.f22891c.size() - 1;
            }
            View g2 = this.f22892d.g(str, this.l.add(Integer.valueOf(i2)), this.k);
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
            this.f22893e = list;
            if (this.f22896h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f22891c.size()) {
            return;
        }
        String str = (String) b.a.r0.q1.o.k.a.d(this.f22891c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f22892d.p(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22892d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f22894f) {
            if (i2 < 0) {
                this.f22892d.l(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = b.a.r0.q1.o.k.a.k(this.f22891c);
            String f2 = b.a.r0.a3.a.f(advertAppInfo);
            if (i2 >= k) {
                if (!b.a.r0.a3.a.l((String) b.a.r0.q1.o.k.a.d(this.f22891c, k - 1)) && (z || !this.f22892d.o())) {
                    this.k = true;
                    i2 = k;
                    z2 = true;
                } else {
                    this.f22892d.l(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.j + d() : (int) (i2 + this.f22897i);
            if (b.a.r0.a3.a.n(advertAppInfo)) {
                if (i2 >= k) {
                    this.f22892d.l(advertAppInfo);
                }
                String str = (String) b.a.r0.q1.o.k.a.d(this.f22891c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f22892d.d(str, advertAppInfo);
                return;
            }
            b.a.r0.q1.o.k.a.b(this.f22891c, f2, i2);
            String str2 = (String) b.a.r0.q1.o.k.a.d(this.f22891c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f22892d.d(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || b.a.r0.q1.o.k.a.e(list) || b.a.r0.q1.o.k.a.e(this.f22891c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == b.a.r0.a.h().j() - 1 && b.a.r0.a.h().v()) {
                    if (!i()) {
                        break;
                    } else if (b.a.e.f.m.b.e(next.e4, -1) - 1 <= b.a.r0.q1.o.k.a.k(this.f22891c)) {
                        g(next);
                        break;
                    }
                }
                e(next, b.a.e.f.m.b.e(next.e4, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f22895g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, b.a.r0.q1.o.k.a.k(this.f22891c), true);
            d dVar = this.f22895g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) b.a.r0.q1.o.k.a.d(this.f22891c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f22892d.e(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.f22891c;
            String str = (String) b.a.r0.q1.o.k.a.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.m;
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
            this.f22892d.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f22896h = true;
            f(this.f22893e);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            String str = (String) b.a.r0.q1.o.k.a.d(this.f22891c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f22892d.k(str);
        }
    }

    public void n(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && this.f22894f) {
            this.f22896h = false;
            this.f22895g = dVar;
            this.f22892d.m();
            e eVar = new e();
            eVar.l = this.f22889a;
            eVar.m = this.f22890b;
            this.f22892d.f(eVar);
        }
    }

    public void o(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.f22897i = j - 1;
            this.j = i2;
        }
    }
}
