package c.a.r0.b0.e0;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.o0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends BaseCardInfo implements p, o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f15727e;

    /* renamed from: f  reason: collision with root package name */
    public String f15728f;

    /* renamed from: g  reason: collision with root package name */
    public int f15729g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15730h;

    public d(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {advertAppInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f15728f = "";
        this.f15729g = 0;
        this.f15730h = false;
        this.f15727e = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // c.a.r0.b0.e0.p
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    @Override // c.a.q0.s.q.o0
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15730h : invokeV.booleanValue;
    }

    @Override // c.a.q0.s.q.o0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.position : invokeV.intValue;
    }

    public AdvertAppInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15727e : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.r0.b0.e0.p
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f15727e;
            return c.a.e.e.m.b.e(advertAppInfo != null ? advertAppInfo.d4 : "-1", -1);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f15727e;
            if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.r4) {
                return AdvertAppInfo.t4;
            }
            AdvertAppInfo advertAppInfo2 = this.f15727e;
            if (advertAppInfo2 == null || (iLegoAdvert = advertAppInfo2.f4) == null) {
                return null;
            }
            BdUniqueId bdUniqueId = AdvertAppInfo.u4;
            int goodsStyle = iLegoAdvert.getGoodsStyle();
            if (goodsStyle != 2) {
                if (goodsStyle != 6) {
                    if (goodsStyle != 7) {
                        if (goodsStyle != 8) {
                            switch (goodsStyle) {
                                case 12:
                                    return AdvertAppInfo.z4;
                                case 13:
                                    return AdvertAppInfo.y4;
                                case 14:
                                    break;
                                default:
                                    return bdUniqueId;
                            }
                        }
                    }
                    return AdvertAppInfo.x4;
                }
                return AdvertAppInfo.w4;
            }
            return AdvertAppInfo.v4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.r0.b0.e0.p
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.s.q.o0
    public AdvertAppInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15727e : (AdvertAppInfo) invokeV.objValue;
    }

    @Override // c.a.r0.b0.e0.p
    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // c.a.q0.s.q.o0
    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.position = i2;
            this.f15727e.position = i2;
            this.f15730h = true;
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15728f = "";
        this.f15729g = 0;
        this.f15730h = false;
        this.f15727e = null;
        this.position = -1;
    }
}
