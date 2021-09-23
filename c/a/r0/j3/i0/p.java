package c.a.r0.j3.i0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.App;
/* loaded from: classes3.dex */
public class p extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo D0;
    public boolean E0;
    public String F0;
    public String G0;
    public String H0;
    public long I0;
    public int J0;
    public boolean K0;
    public int L0;
    public boolean M0;

    public p() {
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
        this.E0 = false;
        this.M0 = false;
    }

    public String E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.D0;
            return advertAppInfo == null ? "" : advertAppInfo.e4;
        }
        return (String) invokeV.objValue;
    }

    public String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdvertAppInfo advertAppInfo = this.D0;
            return advertAppInfo == null ? "" : advertAppInfo.X3;
        }
        return (String) invokeV.objValue;
    }

    public String G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.E0 ? "PB_BANNER" : this.K0 ? "VIDEO_PB" : "PB" : (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.D0;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.f4;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.D0;
            return advertAppInfo != null && advertAppInfo.S4() == 0;
        }
        return invokeV.booleanValue;
    }

    public void J0(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.D0 = advertAppInfo;
            advertAppInfo.U4(app);
            this.D0.h4 = G0();
        }
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.D0 : (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.D0;
            if (advertAppInfo == null) {
                return 0;
            }
            return c.a.e.e.m.b.e(advertAppInfo.d4, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!c.a.q0.s.k.c().g() && (advertAppInfo = this.D0) != null && (iLegoAdvert = advertAppInfo.f4) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.s4;
            }
            if (c.a.q0.b.d.G() && this.E0) {
                return AdvertAppInfo.s4;
            }
            AdvertAppInfo advertAppInfo2 = this.D0;
            if (advertAppInfo2 != null && advertAppInfo2.f4 != null) {
                int i2 = advertAppInfo2.Z3;
                if (i2 != 1001 && i2 != -1001) {
                    if (H0() != null) {
                        return AdvertAppInfo.u4;
                    }
                    return null;
                }
                return AdvertAppInfo.s4;
            }
            return AdvertAppInfo.s4;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
