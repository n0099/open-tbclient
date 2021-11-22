package b.a.r0.a3.k0;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c1.e;
import b.a.r0.a3.i0.d.a.d;
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
public class c implements b.a.r0.a3.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.r0.r.c.a f15816a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, AdvertAppInfo> f15817b;

    /* renamed from: c  reason: collision with root package name */
    public d f15818c;

    /* renamed from: d  reason: collision with root package name */
    public int f15819d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15820e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15821f;

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
        this.f15820e = true;
        this.f15821f = false;
        b.a.r0.r.c.a aVar2 = new b.a.r0.r.c.a(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.f15816a = aVar2;
        aVar2.f(false);
        this.f15817b = new HashMap();
        this.f15819d = b.a.r0.a.h().j();
    }

    @Override // b.a.r0.a3.e0.b
    public void d(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, advertAppInfo) == null) {
            this.f15817b.put(str, advertAppInfo);
        }
    }

    @Override // b.a.r0.a3.e0.b
    public boolean e(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (TextUtils.isEmpty(str) || (advertAppInfo = this.f15817b.get(str)) == null || b.a.r0.a3.a.n(advertAppInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // b.a.r0.a3.e0.b
    public void f(@NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", eVar.l);
            hashMap.put("forum_name", eVar.m);
            this.f15816a.d(this.f15819d, hashMap);
        }
    }

    @Override // b.a.r0.a3.e0.b
    public View g(@NonNull String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            this.f15820e = z;
            this.f15821f = z2;
            return this.f15818c.b(this.f15817b.get(str), z, z2);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // b.a.r0.a3.e0.b
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 0;
            if (this.f15817b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.f15817b.values()) {
                if (!b.a.r0.a3.a.n(advertAppInfo)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.a3.e0.b
    public void i(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, tbPageContext, hVar, z) == null) {
            this.f15818c = new d(tbPageContext, z, hVar);
        }
    }

    @Override // b.a.r0.a3.e0.b
    public void k(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (advertAppInfo = this.f15817b.get(str)) == null) {
            return;
        }
        b.a.r0.a3.l0.d.q(advertAppInfo);
        b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(advertAppInfo));
        if (!this.f15821f && this.f15820e) {
            this.f15818c.d();
        } else {
            this.f15818c.c();
        }
        this.f15820e = false;
    }

    @Override // b.a.r0.a3.e0.b
    public void l(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, advertAppInfo) == null) {
            b.a.r0.a3.l0.d.i(advertAppInfo, 0, 2);
        }
    }

    @Override // b.a.r0.a3.e0.b
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f15817b.clear();
        }
    }

    @Override // b.a.r0.a3.e0.b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !this.f15817b.isEmpty() : invokeV.booleanValue;
    }

    @Override // b.a.r0.a3.e0.b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f15818c.e();
            this.f15816a.b();
        }
    }

    @Override // b.a.r0.a3.e0.b
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f15818c.f(this.f15817b.get(str));
        }
    }
}
