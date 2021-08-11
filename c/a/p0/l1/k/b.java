package c.a.p0.l1.k;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.b1.c;
import c.a.p0.x2.d;
import c.a.p0.x2.y;
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
import java.util.List;
/* loaded from: classes3.dex */
public class b implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f21390a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21391b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f21392c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.x2.e0.b f21393d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f21394e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21395f;

    /* renamed from: g  reason: collision with root package name */
    public d f21396g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21397h;

    /* renamed from: i  reason: collision with root package name */
    public long f21398i;

    /* renamed from: j  reason: collision with root package name */
    public int f21399j;

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
        this.f21392c = list;
        this.f21390a = str;
        this.f21391b = str2;
        this.f21395f = z2;
        try {
            c.a.p0.x2.e0.b bVar = (c.a.p0.x2.e0.b) y.o().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f21393d = bVar;
            bVar.j(tbPageContext, hVar, z);
        } catch (ClassCastException unused) {
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        View h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (i2 >= this.f21392c.size()) {
                return null;
            }
            String str = (String) c.a.p0.o1.o.k.a.d(this.f21392c, i2);
            if (TextUtils.isEmpty(str) || (h2 = this.f21393d.h(str)) == null) {
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
            this.f21394e = list;
            if (this.f21397h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f21392c.size()) {
            return;
        }
        String str = (String) c.a.p0.o1.o.k.a.d(this.f21392c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f21393d.p(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21393d.e() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f21395f) {
            if (i2 < 0) {
                this.f21393d.m(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = c.a.p0.o1.o.k.a.k(this.f21392c);
            String f2 = c.a.p0.x2.a.f(advertAppInfo);
            if (i2 >= k) {
                if (c.a.p0.x2.a.l((String) c.a.p0.o1.o.k.a.d(this.f21392c, k - 1)) || (!z && this.f21393d.o())) {
                    this.f21393d.m(advertAppInfo);
                    return;
                } else {
                    z2 = true;
                    i2 = k;
                }
            }
            advertAppInfo.position = z2 ? this.f21399j + d() : (int) (i2 + this.f21398i);
            if (c.a.p0.x2.a.n(advertAppInfo)) {
                if (i2 >= k) {
                    this.f21393d.m(advertAppInfo);
                }
                String str = (String) c.a.p0.o1.o.k.a.d(this.f21392c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f21393d.d(str, advertAppInfo);
                return;
            }
            c.a.p0.o1.o.k.a.b(this.f21392c, f2, i2);
            String str2 = (String) c.a.p0.o1.o.k.a.d(this.f21392c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f21393d.d(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || c.a.p0.o1.o.k.a.e(list) || c.a.p0.o1.o.k.a.e(this.f21392c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            if (next != null) {
                e(next, c.a.e.e.m.b.d(next.Z3, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f21396g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, c.a.p0.o1.o.k.a.k(this.f21392c), true);
            d dVar = this.f21396g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) c.a.p0.o1.o.k.a.d(this.f21392c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f21393d.f(str);
        }
        return invokeI.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f21393d.onDestroy();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f21397h = true;
            f(this.f21394e);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            String str = (String) c.a.p0.o1.o.k.a.d(this.f21392c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f21393d.l(str);
        }
    }

    public void l(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) && this.f21395f) {
            this.f21397h = false;
            this.f21396g = dVar;
            c cVar = new c();
            cVar.l = this.f21390a;
            cVar.m = this.f21391b;
            this.f21393d.g(cVar);
        }
    }

    public void m(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.f21398i = j2 - 1;
            this.f21399j = i2;
        }
    }
}
