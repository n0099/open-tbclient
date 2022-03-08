package c.a.r0.j3.l0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.g;
import c.a.r0.j3.j0.d.a.d;
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
public class c implements c.a.r0.j3.f0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.v.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, AdvertAppInfo> f18524b;

    /* renamed from: c  reason: collision with root package name */
    public d f18525c;

    /* renamed from: d  reason: collision with root package name */
    public int f18526d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<String> f18527e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18528f;

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
        this.f18527e = new LinkedHashSet();
        this.f18528f = false;
        c.a.r0.v.e.a aVar2 = new c.a.r0.v.e.a(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.a = aVar2;
        aVar2.f(false);
        this.f18524b = new HashMap();
        this.f18526d = c.a.r0.a.h().j();
    }

    @Override // c.a.r0.j3.f0.b
    public View b(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            this.f18528f = z;
            return this.f18525c.b(this.f18524b.get(str), z);
        }
        return (View) invokeLZ.objValue;
    }

    @Override // c.a.r0.j3.f0.b
    public void e(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, advertAppInfo) == null) {
            this.f18524b.put(str, advertAppInfo);
        }
    }

    @Override // c.a.r0.j3.f0.b
    public boolean f(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? (TextUtils.isEmpty(str) || (advertAppInfo = this.f18524b.get(str)) == null || c.a.r0.j3.a.n(advertAppInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.r0.j3.f0.b
    public void g(@NonNull g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", gVar.l);
            hashMap.put("forum_name", gVar.m);
            this.a.d(this.f18526d, hashMap);
        }
    }

    @Override // c.a.r0.j3.f0.b
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 0;
            if (this.f18524b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.f18524b.values()) {
                if (!c.a.r0.j3.a.n(advertAppInfo)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.j3.f0.b
    public void i(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, tbPageContext, hVar, z) == null) {
            this.f18525c = new d(tbPageContext, z, hVar);
        }
    }

    @Override // c.a.r0.j3.f0.b
    public void k(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (advertAppInfo = this.f18524b.get(str)) == null) {
            return;
        }
        c.a.r0.j3.m0.d.q(advertAppInfo);
        c.a.r0.z1.o.h.c.g(c.a.r0.z1.o.h.c.e(advertAppInfo));
        boolean add = this.f18527e.add(str);
        if (!this.f18528f && add) {
            this.f18525c.d();
        } else {
            this.f18525c.c();
        }
    }

    @Override // c.a.r0.j3.f0.b
    public void l(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, advertAppInfo) == null) {
            c.a.r0.j3.m0.d.i(advertAppInfo, 0, 2);
        }
    }

    @Override // c.a.r0.j3.f0.b
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f18524b.clear();
        }
    }

    @Override // c.a.r0.j3.f0.b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !this.f18524b.isEmpty() : invokeV.booleanValue;
    }

    @Override // c.a.r0.j3.f0.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f18525c.e();
            this.a.b();
            this.f18527e.clear();
        }
    }

    @Override // c.a.r0.j3.f0.b
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f18525c.f(this.f18524b.get(str));
        }
    }
}
