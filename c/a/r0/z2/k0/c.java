package c.a.r0.z2.k0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.e;
import c.a.r0.z2.i0.d.a.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
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
public class c implements c.a.r0.z2.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.r0.r.c.a f29772a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, AdvertAppInfo> f29773b;

    /* renamed from: c  reason: collision with root package name */
    public d f29774c;

    /* renamed from: d  reason: collision with root package name */
    public int f29775d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29776e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29777f;

    public c(IAdBaseAsyncController.a aVar) {
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
        this.f29776e = true;
        this.f29777f = false;
        c.a.r0.r.c.a aVar2 = new c.a.r0.r.c.a(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.f29772a = aVar2;
        aVar2.f(false);
        this.f29773b = new HashMap();
        this.f29775d = c.a.r0.a.h().j();
    }

    @Override // c.a.r0.z2.e0.b
    public void d(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, advertAppInfo) == null) {
            this.f29773b.put(str, advertAppInfo);
        }
    }

    @Override // c.a.r0.z2.e0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 0;
            if (this.f29773b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.f29773b.values()) {
                if (!c.a.r0.z2.a.n(advertAppInfo)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.z2.e0.b
    public boolean f(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? (TextUtils.isEmpty(str) || (advertAppInfo = this.f29773b.get(str)) == null || c.a.r0.z2.a.n(advertAppInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.r0.z2.e0.b
    public void g(@NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", eVar.l);
            hashMap.put("forum_name", eVar.m);
            this.f29772a.d(this.f29775d, hashMap);
        }
    }

    @Override // c.a.r0.z2.e0.b
    public View h(@NonNull String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            this.f29776e = z;
            this.f29777f = z2;
            return this.f29774c.b(this.f29773b.get(str), z, z2);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.r0.z2.e0.b
    public void j(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, tbPageContext, hVar, z) == null) {
            this.f29774c = new d(tbPageContext, z, hVar);
        }
    }

    @Override // c.a.r0.z2.e0.b
    public void l(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (advertAppInfo = this.f29773b.get(str)) == null) {
            return;
        }
        c.a.r0.z2.l0.d.p(advertAppInfo);
        c.a.r0.q1.o.h.c.g(c.a.r0.q1.o.h.c.e(advertAppInfo));
        if (!this.f29777f && this.f29776e) {
            this.f29774c.d();
        } else {
            this.f29774c.c();
        }
        this.f29776e = false;
    }

    @Override // c.a.r0.z2.e0.b
    public void m(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, advertAppInfo) == null) {
            c.a.r0.z2.l0.d.h(advertAppInfo, 0, 2);
        }
    }

    @Override // c.a.r0.z2.e0.b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !this.f29773b.isEmpty() : invokeV.booleanValue;
    }

    @Override // c.a.r0.z2.e0.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f29774c.e();
            this.f29772a.b();
        }
    }

    @Override // c.a.r0.z2.e0.b
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f29774c.f(this.f29773b.get(str));
        }
    }
}
