package c.a.q0.x2.i0.d.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.o1.o.l.e;
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
/* loaded from: classes4.dex */
public abstract class a implements e<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdCard f28901e;

    /* renamed from: f  reason: collision with root package name */
    public AdvertAppInfo f28902f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28903g;

    /* renamed from: h  reason: collision with root package name */
    public Context f28904h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f28905i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.o1.o.a f28906j;

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
        this.f28905i = tbPageContext;
        this.f28904h = tbPageContext.getPageActivity();
    }

    public AdvertAppInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28902f : (AdvertAppInfo) invokeV.objValue;
    }

    public abstract void b();

    public void c(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) {
            this.f28901e = adCard;
            this.f28902f = adCard.getAdvertAppInfo();
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void onScrollIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void onViewBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void onViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void registerListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void setAfterClickSchemeListener(c.a.q0.o1.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f28906j = aVar;
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void setDownloadAppCallback(c.a.q0.o1.o.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f28903g = z;
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void update(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, obj) == null) && (obj instanceof AdCard)) {
            this.f28901e = (AdCard) obj;
            b();
            c(this.f28901e);
        }
    }

    @Override // c.a.q0.o1.o.l.e
    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }
}
