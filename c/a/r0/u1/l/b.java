package c.a.r0.u1.l;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.g;
import c.a.q0.r.e;
import c.a.r0.j3.d;
import c.a.r0.j3.z;
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
    public final String f22979b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f22980c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.j3.f0.b f22981d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f22982e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22983f;

    /* renamed from: g  reason: collision with root package name */
    public d f22984g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22985h;

    /* renamed from: i  reason: collision with root package name */
    public long f22986i;

    /* renamed from: j  reason: collision with root package name */
    public int f22987j;
    public boolean k;
    public Map<String, ImageUrlData> l;

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
        this.f22980c = list;
        this.a = str;
        this.f22979b = str2;
        this.f22983f = z2;
        try {
            c.a.r0.j3.f0.b bVar = (c.a.r0.j3.f0.b) z.q().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f22981d = bVar;
            bVar.i(tbPageContext, hVar, z);
        } catch (ClassCastException e2) {
            if (e.e()) {
                throw new RuntimeException(e2);
            }
        }
        this.l = map;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 >= this.f22980c.size()) {
                return null;
            }
            String str = (String) c.a.r0.z1.o.k.a.d(this.f22980c, i2);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            boolean z = i2 == this.f22980c.size() - 1;
            this.k = z;
            View b2 = this.f22981d.b(str, z);
            if (b2 == null) {
                return null;
            }
            if (b2.getParent() != null && (b2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            viewGroup.addView(b2);
            return b2;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f22982e = list;
            if (this.f22985h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f22980c.size()) {
            return;
        }
        String str = (String) c.a.r0.z1.o.k.a.d(this.f22980c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f22981d.p(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22981d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f22983f) {
            if (i2 < 0) {
                this.f22981d.l(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = c.a.r0.z1.o.k.a.k(this.f22980c);
            String f2 = c.a.r0.j3.a.f(advertAppInfo);
            if (i2 >= k) {
                if (!c.a.r0.j3.a.l((String) c.a.r0.z1.o.k.a.d(this.f22980c, k - 1)) && (z || !this.f22981d.o())) {
                    this.k = true;
                    i2 = k;
                    z2 = true;
                } else {
                    this.f22981d.l(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.f22987j + d() : (int) (i2 + this.f22986i);
            if (c.a.r0.j3.a.n(advertAppInfo)) {
                if (i2 >= k) {
                    this.f22981d.l(advertAppInfo);
                }
                String str = (String) c.a.r0.z1.o.k.a.d(this.f22980c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f22981d.e(str, advertAppInfo);
                return;
            }
            c.a.r0.z1.o.k.a.b(this.f22980c, f2, i2);
            String str2 = (String) c.a.r0.z1.o.k.a.d(this.f22980c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f22981d.e(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || c.a.r0.z1.o.k.a.e(list) || c.a.r0.z1.o.k.a.e(this.f22980c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == c.a.r0.a.h().j() - 1 && c.a.r0.a.h().v()) {
                    if (!i()) {
                        break;
                    } else if (c.a.d.f.m.b.e(next.m4, -1) - 1 <= c.a.r0.z1.o.k.a.k(this.f22980c)) {
                        g(next);
                        break;
                    }
                }
                e(next, c.a.d.f.m.b.e(next.m4, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f22984g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, c.a.r0.z1.o.k.a.k(this.f22980c), true);
            d dVar = this.f22984g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) c.a.r0.z1.o.k.a.d(this.f22980c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f22981d.f(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.f22980c;
            String str = (String) c.a.r0.z1.o.k.a.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.l;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            return imageUrlData != null && imageUrlData.overAllIndex == ((long) this.f22987j);
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
            this.f22981d.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f22985h = true;
            f(this.f22982e);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            String str = (String) c.a.r0.z1.o.k.a.d(this.f22980c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f22981d.k(str);
        }
    }

    public void n(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) && this.f22983f) {
            this.f22985h = false;
            this.f22984g = dVar;
            this.f22981d.m();
            g gVar = new g();
            gVar.l = this.a;
            gVar.m = this.f22979b;
            this.f22981d.g(gVar);
        }
    }

    public void o(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f22986i = j2 - 1;
            this.f22987j = i2;
        }
    }
}
