package b.a.r0.z2.i0.d.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.q1.o.l.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class a implements e<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdCard f28126e;

    /* renamed from: f  reason: collision with root package name */
    public AdvertAppInfo f28127f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28128g;

    /* renamed from: h  reason: collision with root package name */
    public Context f28129h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f28130i;
    public b.a.r0.q1.o.a j;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28130i = tbPageContext;
        this.f28129h = tbPageContext.getPageActivity();
    }

    public AdvertAppInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28127f : (AdvertAppInfo) invokeV.objValue;
    }

    public abstract void b();

    public void c(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            this.f28126e = adCard;
            this.f28127f = adCard.getAdvertAppInfo();
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void onScrollIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void onViewBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void onViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void registerListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void setAfterClickSchemeListener(b.a.r0.q1.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.j = aVar;
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void setDownloadAppCallback(b.a.r0.q1.o.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f28128g = z;
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void update(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, obj) == null) && (obj instanceof AdCard)) {
            this.f28126e = (AdCard) obj;
            b();
            c(this.f28126e);
        }
    }

    @Override // b.a.r0.q1.o.l.e
    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }
}
