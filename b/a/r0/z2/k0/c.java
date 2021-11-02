package b.a.r0.z2.k0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.e;
import b.a.r0.z2.i0.d.a.d;
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
/* loaded from: classes6.dex */
public class c implements b.a.r0.z2.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.r0.r.c.a f28181a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, AdvertAppInfo> f28182b;

    /* renamed from: c  reason: collision with root package name */
    public d f28183c;

    /* renamed from: d  reason: collision with root package name */
    public int f28184d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28185e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28186f;

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
        this.f28185e = true;
        this.f28186f = false;
        b.a.r0.r.c.a aVar2 = new b.a.r0.r.c.a(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.f28181a = aVar2;
        aVar2.f(false);
        this.f28182b = new HashMap();
        this.f28184d = b.a.r0.a.h().j();
    }

    @Override // b.a.r0.z2.e0.b
    public void d(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, advertAppInfo) == null) {
            this.f28182b.put(str, advertAppInfo);
        }
    }

    @Override // b.a.r0.z2.e0.b
    public boolean e(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (TextUtils.isEmpty(str) || (advertAppInfo = this.f28182b.get(str)) == null || b.a.r0.z2.a.n(advertAppInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // b.a.r0.z2.e0.b
    public void f(@NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", eVar.l);
            hashMap.put("forum_name", eVar.m);
            this.f28181a.d(this.f28184d, hashMap);
        }
    }

    @Override // b.a.r0.z2.e0.b
    public View g(@NonNull String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            this.f28185e = z;
            this.f28186f = z2;
            return this.f28183c.b(this.f28182b.get(str), z, z2);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // b.a.r0.z2.e0.b
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 0;
            if (this.f28182b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.f28182b.values()) {
                if (!b.a.r0.z2.a.n(advertAppInfo)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.z2.e0.b
    public void i(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, tbPageContext, hVar, z) == null) {
            this.f28183c = new d(tbPageContext, z, hVar);
        }
    }

    @Override // b.a.r0.z2.e0.b
    public void k(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (advertAppInfo = this.f28182b.get(str)) == null) {
            return;
        }
        b.a.r0.z2.l0.d.q(advertAppInfo);
        b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(advertAppInfo));
        if (!this.f28186f && this.f28185e) {
            this.f28183c.d();
        } else {
            this.f28183c.c();
        }
        this.f28185e = false;
    }

    @Override // b.a.r0.z2.e0.b
    public void l(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, advertAppInfo) == null) {
            b.a.r0.z2.l0.d.i(advertAppInfo, 0, 2);
        }
    }

    @Override // b.a.r0.z2.e0.b
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !this.f28182b.isEmpty() : invokeV.booleanValue;
    }

    @Override // b.a.r0.z2.e0.b
    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f28183c.f(this.f28182b.get(str));
        }
    }

    @Override // b.a.r0.z2.e0.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f28183c.e();
            this.f28181a.b();
        }
    }
}
