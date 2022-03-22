package c.a.p0.l3.j0.d.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b2.o.l.e;
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
/* loaded from: classes2.dex */
public abstract class a implements e<AdCard> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdCard a;

    /* renamed from: b  reason: collision with root package name */
    public AdvertAppInfo f16249b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f16250c;

    /* renamed from: d  reason: collision with root package name */
    public Context f16251d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16252e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.b2.o.a f16253f;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16252e = tbPageContext;
        this.f16251d = tbPageContext.getPageActivity();
    }

    public AdvertAppInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16249b : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.p0.b2.o.l.e
    public void b(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
        }
    }

    public abstract void c();

    public void d(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adCard) == null) {
            this.a = adCard;
            this.f16249b = adCard.getAdvertAppInfo();
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void setAfterClickSchemeListener(c.a.p0.b2.o.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f16253f = aVar;
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void setDownloadAppCallback(c.a.p0.b2.o.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f16250c = z;
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void update(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, obj) == null) && (obj instanceof AdCard)) {
            this.a = (AdCard) obj;
            c();
            d(this.a);
        }
    }
}
