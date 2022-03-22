package c.a.p0.l3.l0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.g;
import c.a.p0.l3.j0.d.a.d;
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
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class c implements c.a.p0.l3.f0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.x.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, AdvertAppInfo> f16288b;

    /* renamed from: c  reason: collision with root package name */
    public d f16289c;

    /* renamed from: d  reason: collision with root package name */
    public int f16290d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<String> f16291e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16292f;

    public c(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16291e = new LinkedHashSet();
        this.f16292f = false;
        c.a.p0.x.e.a aVar2 = new c.a.p0.x.e.a(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.a = aVar2;
        aVar2.f(false);
        this.f16288b = new HashMap();
        this.f16290d = c.a.p0.a.h().j();
    }

    @Override // c.a.p0.l3.f0.b
    public View b(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            this.f16292f = z;
            return this.f16289c.b(this.f16288b.get(str), z);
        }
        return (View) invokeLZ.objValue;
    }

    @Override // c.a.p0.l3.f0.b
    public AdvertAppInfo e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f16288b.get(str) : (AdvertAppInfo) invokeL.objValue;
    }

    @Override // c.a.p0.l3.f0.b
    public void f(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, advertAppInfo) == null) {
            this.f16288b.put(str, advertAppInfo);
        }
    }

    @Override // c.a.p0.l3.f0.b
    public boolean g(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? (TextUtils.isEmpty(str) || (advertAppInfo = this.f16288b.get(str)) == null || c.a.p0.l3.a.n(advertAppInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.p0.l3.f0.b
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = 0;
            if (this.f16288b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.f16288b.values()) {
                if (!c.a.p0.l3.a.n(advertAppInfo)) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.l3.f0.b
    public void h(@NonNull g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", gVar.l);
            hashMap.put("forum_name", gVar.m);
            this.a.d(this.f16290d, hashMap);
        }
    }

    @Override // c.a.p0.l3.f0.b
    public void j(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, tbPageContext, hVar, z) == null) {
            this.f16289c = new d(tbPageContext, z, hVar);
        }
    }

    @Override // c.a.p0.l3.f0.b
    public void l(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (advertAppInfo = this.f16288b.get(str)) == null) {
            return;
        }
        c.a.p0.l3.m0.d.q(advertAppInfo);
        c.a.p0.b2.o.h.c.g(c.a.p0.b2.o.h.c.e(advertAppInfo));
        boolean add = this.f16291e.add(str);
        if (!this.f16292f && add) {
            this.f16289c.d();
        } else {
            this.f16289c.c();
        }
    }

    @Override // c.a.p0.l3.f0.b
    public void m(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) {
            c.a.p0.l3.m0.d.i(advertAppInfo, 0, 2);
        }
    }

    @Override // c.a.p0.l3.f0.b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16288b.clear();
        }
    }

    @Override // c.a.p0.l3.f0.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f16289c.e();
            this.a.b();
            this.f16291e.clear();
        }
    }

    @Override // c.a.p0.l3.f0.b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !this.f16288b.isEmpty() : invokeV.booleanValue;
    }

    @Override // c.a.p0.l3.f0.b
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f16289c.f(this.f16288b.get(str));
        }
    }
}
