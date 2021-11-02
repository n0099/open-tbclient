package b.a.r0.n1.l;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.e;
import b.a.r0.z2.d;
import b.a.r0.z2.y;
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
/* loaded from: classes5.dex */
public class b implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f21393a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21394b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f21395c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.z2.e0.b f21396d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f21397e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21398f;

    /* renamed from: g  reason: collision with root package name */
    public d f21399g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21400h;

    /* renamed from: i  reason: collision with root package name */
    public long f21401i;
    public int j;
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
        this.f21395c = list;
        this.f21393a = str;
        this.f21394b = str2;
        this.f21398f = z2;
        try {
            b.a.r0.z2.e0.b bVar = (b.a.r0.z2.e0.b) y.o().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f21396d = bVar;
            bVar.i(tbPageContext, hVar, z);
        } catch (ClassCastException unused) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 >= this.f21395c.size()) {
                return null;
            }
            String str = (String) b.a.r0.q1.o.k.a.d(this.f21395c, i2);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!this.k) {
                this.k = i2 == this.f21395c.size() - 1;
            }
            View g2 = this.f21396d.g(str, this.l.add(Integer.valueOf(i2)), this.k);
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
            this.f21397e = list;
            if (this.f21400h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f21395c.size()) {
            return;
        }
        String str = (String) b.a.r0.q1.o.k.a.d(this.f21395c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f21396d.o(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21396d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f21398f) {
            if (i2 < 0) {
                this.f21396d.l(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = b.a.r0.q1.o.k.a.k(this.f21395c);
            String f2 = b.a.r0.z2.a.f(advertAppInfo);
            if (i2 >= k) {
                if (!b.a.r0.z2.a.l((String) b.a.r0.q1.o.k.a.d(this.f21395c, k - 1)) && (z || !this.f21396d.n())) {
                    this.k = true;
                    i2 = k;
                    z2 = true;
                } else {
                    this.f21396d.l(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.j + d() : (int) (i2 + this.f21401i);
            if (b.a.r0.z2.a.n(advertAppInfo)) {
                if (i2 >= k) {
                    this.f21396d.l(advertAppInfo);
                }
                String str = (String) b.a.r0.q1.o.k.a.d(this.f21395c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f21396d.d(str, advertAppInfo);
                return;
            }
            b.a.r0.q1.o.k.a.b(this.f21395c, f2, i2);
            String str2 = (String) b.a.r0.q1.o.k.a.d(this.f21395c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f21396d.d(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || b.a.r0.q1.o.k.a.e(list) || b.a.r0.q1.o.k.a.e(this.f21395c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            if (next != null) {
                e(next, b.a.e.e.m.b.e(next.d4, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f21399g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, b.a.r0.q1.o.k.a.k(this.f21395c), true);
            d dVar = this.f21399g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) b.a.r0.q1.o.k.a.d(this.f21395c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f21396d.e(str);
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
            this.f21396d.onDestroy();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f21400h = true;
            f(this.f21397e);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            String str = (String) b.a.r0.q1.o.k.a.d(this.f21395c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f21396d.k(str);
        }
    }

    public void m(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) && this.f21398f) {
            this.f21400h = false;
            this.f21399g = dVar;
            e eVar = new e();
            eVar.l = this.f21393a;
            eVar.m = this.f21394b;
            this.f21396d.f(eVar);
        }
    }

    public void n(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.f21401i = j - 1;
            this.j = i2;
        }
    }
}
