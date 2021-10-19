package c.a.r0.n1.l;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.e;
import c.a.r0.z2.d;
import c.a.r0.z2.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
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
import java.util.Set;
/* loaded from: classes3.dex */
public class b implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f22493a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22494b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f22495c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.z2.e0.b f22496d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f22497e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22498f;

    /* renamed from: g  reason: collision with root package name */
    public d f22499g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22500h;

    /* renamed from: i  reason: collision with root package name */
    public long f22501i;

    /* renamed from: j  reason: collision with root package name */
    public int f22502j;
    public boolean k;
    public Set<Integer> l;

    public b(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<ImageViewerActivity> tbPageContext, DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, hVar};
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
        this.f22495c = list;
        this.f22493a = str;
        this.f22494b = str2;
        this.f22498f = z2;
        try {
            c.a.r0.z2.e0.b bVar = (c.a.r0.z2.e0.b) y.o().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f22496d = bVar;
            bVar.j(tbPageContext, hVar, z);
        } catch (ClassCastException unused) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 >= this.f22495c.size()) {
                return null;
            }
            String str = (String) c.a.r0.q1.o.k.a.d(this.f22495c, i2);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!this.k) {
                this.k = i2 == this.f22495c.size() - 1;
            }
            View h2 = this.f22496d.h(str, this.l.add(Integer.valueOf(i2)), this.k);
            if (h2 == null) {
                return null;
            }
            if (h2.getParent() != null && (h2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) h2.getParent()).removeView(h2);
            }
            viewGroup.addView(h2);
            return h2;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f22497e = list;
            if (this.f22500h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f22495c.size()) {
            return;
        }
        String str = (String) c.a.r0.q1.o.k.a.d(this.f22495c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f22496d.p(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22496d.e() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f22498f) {
            if (i2 < 0) {
                this.f22496d.m(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = c.a.r0.q1.o.k.a.k(this.f22495c);
            String f2 = c.a.r0.z2.a.f(advertAppInfo);
            if (i2 >= k) {
                if (!c.a.r0.z2.a.l((String) c.a.r0.q1.o.k.a.d(this.f22495c, k - 1)) && (z || !this.f22496d.o())) {
                    this.k = true;
                    i2 = k;
                    z2 = true;
                } else {
                    this.f22496d.m(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.f22502j + d() : (int) (i2 + this.f22501i);
            if (c.a.r0.z2.a.n(advertAppInfo)) {
                if (i2 >= k) {
                    this.f22496d.m(advertAppInfo);
                }
                String str = (String) c.a.r0.q1.o.k.a.d(this.f22495c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f22496d.d(str, advertAppInfo);
                return;
            }
            c.a.r0.q1.o.k.a.b(this.f22495c, f2, i2);
            String str2 = (String) c.a.r0.q1.o.k.a.d(this.f22495c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f22496d.d(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || c.a.r0.q1.o.k.a.e(list) || c.a.r0.q1.o.k.a.e(this.f22495c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            if (next != null) {
                e(next, c.a.e.e.m.b.e(next.d4, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f22499g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, c.a.r0.q1.o.k.a.k(this.f22495c), true);
            d dVar = this.f22499g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) c.a.r0.q1.o.k.a.d(this.f22495c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f22496d.f(str);
        }
        return invokeI.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f22496d.onDestroy();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f22500h = true;
            f(this.f22497e);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            String str = (String) c.a.r0.q1.o.k.a.d(this.f22495c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f22496d.l(str);
        }
    }

    public void m(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) && this.f22498f) {
            this.f22500h = false;
            this.f22499g = dVar;
            e eVar = new e();
            eVar.l = this.f22493a;
            eVar.m = this.f22494b;
            this.f22496d.g(eVar);
        }
    }

    public void n(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f22501i = j2 - 1;
            this.f22502j = i2;
        }
    }
}
