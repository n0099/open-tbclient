package c.a.r0.y3.k0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.App;
/* loaded from: classes3.dex */
public class o extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo I0;
    public boolean J0;
    public String K0;
    public String L0;
    public String M0;
    public long N0;
    public int O0;
    public boolean P0;
    public int Q0;
    public boolean R0;

    public o() {
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
        this.J0 = false;
        this.R0 = false;
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            return advertAppInfo == null ? "" : advertAppInfo.n4;
        }
        return (String) invokeV.objValue;
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            return advertAppInfo == null ? "" : advertAppInfo.g4;
        }
        return (String) invokeV.objValue;
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.J0 ? "PB_BANNER" : this.P0 ? "VIDEO_PB" : "PB" : (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.o4;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            return advertAppInfo != null && advertAppInfo.Z4() == 0;
        }
        return invokeV.booleanValue;
    }

    public void O0(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.I0 = advertAppInfo;
            advertAppInfo.b5(app);
            this.I0.q4 = L0();
        }
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.I0 : (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.I0;
            if (advertAppInfo == null) {
                return 0;
            }
            return c.a.d.f.m.b.e(advertAppInfo.m4, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!c.a.q0.r.l.c().g() && (advertAppInfo = this.I0) != null && (iLegoAdvert = advertAppInfo.o4) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.C4;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && this.J0) {
                return AdvertAppInfo.C4;
            }
            AdvertAppInfo advertAppInfo2 = this.I0;
            if (advertAppInfo2 != null && advertAppInfo2.o4 != null) {
                int i2 = advertAppInfo2.i4;
                if (i2 != 1001 && i2 != -1001) {
                    if (M0() != null) {
                        return AdvertAppInfo.E4;
                    }
                    return null;
                }
                return AdvertAppInfo.C4;
            }
            return AdvertAppInfo.C4;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
