package c.a.r0.t3.j0;

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
/* loaded from: classes6.dex */
public class p extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo H0;
    public boolean I0;
    public String J0;
    public String K0;
    public String L0;
    public long M0;
    public int N0;
    public boolean O0;
    public int P0;
    public boolean Q0;

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
        this.I0 = false;
        this.Q0 = false;
    }

    public String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.H0;
            return advertAppInfo == null ? "" : advertAppInfo.j4;
        }
        return (String) invokeV.objValue;
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdvertAppInfo advertAppInfo = this.H0;
            return advertAppInfo == null ? "" : advertAppInfo.c4;
        }
        return (String) invokeV.objValue;
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.I0 ? "PB_BANNER" : this.O0 ? "VIDEO_PB" : "PB" : (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.H0;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.k4;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.H0;
            return advertAppInfo != null && advertAppInfo.Y4() == 0;
        }
        return invokeV.booleanValue;
    }

    public void N0(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.H0 = advertAppInfo;
            advertAppInfo.a5(app);
            this.H0.m4 = K0();
        }
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.H0 : (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.H0;
            if (advertAppInfo == null) {
                return 0;
            }
            return c.a.d.f.m.b.e(advertAppInfo.i4, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!c.a.q0.s.k.c().g() && (advertAppInfo = this.H0) != null && (iLegoAdvert = advertAppInfo.k4) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.y4;
            }
            if (c.a.q0.b.d.N() && this.I0) {
                return AdvertAppInfo.y4;
            }
            AdvertAppInfo advertAppInfo2 = this.H0;
            if (advertAppInfo2 != null && advertAppInfo2.k4 != null) {
                int i2 = advertAppInfo2.e4;
                if (i2 != 1001 && i2 != -1001) {
                    if (L0() != null) {
                        return AdvertAppInfo.A4;
                    }
                    return null;
                }
                return AdvertAppInfo.y4;
            }
            return AdvertAppInfo.y4;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
