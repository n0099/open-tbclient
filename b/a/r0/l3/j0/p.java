package b.a.r0.l3.j0;

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
/* loaded from: classes5.dex */
public class p extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo G0;
    public boolean H0;
    public String I0;
    public String J0;
    public String K0;
    public long L0;
    public int M0;
    public boolean N0;
    public int O0;
    public boolean P0;

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
        this.H0 = false;
        this.P0 = false;
    }

    public String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.G0;
            return advertAppInfo == null ? "" : advertAppInfo.e4;
        }
        return (String) invokeV.objValue;
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdvertAppInfo advertAppInfo = this.G0;
            return advertAppInfo == null ? "" : advertAppInfo.X3;
        }
        return (String) invokeV.objValue;
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.H0 ? "PB_BANNER" : this.N0 ? "VIDEO_PB" : "PB" : (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.G0;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.f4;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.G0;
            return advertAppInfo != null && advertAppInfo.U4() == 0;
        }
        return invokeV.booleanValue;
    }

    public void N0(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.G0 = advertAppInfo;
            advertAppInfo.W4(app);
            this.G0.h4 = K0();
        }
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.G0 : (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.G0;
            if (advertAppInfo == null) {
                return 0;
            }
            return b.a.e.e.m.b.e(advertAppInfo.d4, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!b.a.q0.s.k.c().g() && (advertAppInfo = this.G0) != null && (iLegoAdvert = advertAppInfo.f4) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.s4;
            }
            if (b.a.q0.b.d.H() && this.H0) {
                return AdvertAppInfo.s4;
            }
            AdvertAppInfo advertAppInfo2 = this.G0;
            if (advertAppInfo2 != null && advertAppInfo2.f4 != null) {
                int i2 = advertAppInfo2.Z3;
                if (i2 != 1001 && i2 != -1001) {
                    if (L0() != null) {
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
