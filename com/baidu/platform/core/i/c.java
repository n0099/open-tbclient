package com.baidu.platform.core.i;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.weather.WeatherDataType;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.mapapi.search.weather.WeatherServerType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeatherSearchOption b;

    public c(WeatherSearchOption weatherSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {weatherSearchOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = weatherSearchOption;
        a(weatherSearchOption);
    }

    private String a(CoordType coordType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, coordType)) == null) {
            int i = d.b[coordType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                return "gcj02";
            }
            return "bd09ll";
        }
        return (String) invokeL.objValue;
    }

    private String a(LanguageType languageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, languageType)) == null) {
            int i = d.c[languageType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                return "cn";
            }
            return "en";
        }
        return (String) invokeL.objValue;
    }

    private String a(WeatherDataType weatherDataType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, weatherDataType)) == null) {
            switch (d.a[weatherDataType.ordinal()]) {
                case 1:
                    return "now";
                case 2:
                    return "fc";
                case 3:
                    return "fc_hour";
                case 4:
                    return "index";
                case 5:
                    return "alert";
                case 6:
                    return "all";
                default:
                    return "";
            }
        }
        return (String) invokeL.objValue;
    }

    private void a(WeatherSearchOption weatherSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, weatherSearchOption) == null) {
            if (!TextUtils.isEmpty(weatherSearchOption.getDistrictID())) {
                this.a.a(AddressField.KEY_DISTRICT_ID, weatherSearchOption.getDistrictID());
            }
            if (weatherSearchOption.getLocation() != null) {
                LatLng latLng = new LatLng(weatherSearchOption.getLocation().latitude, weatherSearchOption.getLocation().longitude);
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    latLng = CoordTrans.gcjToBaidu(latLng);
                }
                com.baidu.platform.util.a aVar = this.a;
                aVar.a("location", latLng.longitude + "," + latLng.latitude);
                this.a.a("coordtype", a(CoordType.BD09LL));
            }
            if (weatherSearchOption.getDataType() != null) {
                this.a.a("data_type", a(weatherSearchOption.getDataType()));
            }
            if (weatherSearchOption.getLanguageType() != null) {
                this.a.a("language", a(weatherSearchOption.getLanguageType()));
            }
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            WeatherSearchOption weatherSearchOption = this.b;
            if (weatherSearchOption == null) {
                return "";
            }
            if (weatherSearchOption.getServerType() == WeatherServerType.LANGUAGE_SERVER_TYPE_ABROAD) {
                return cVar.t();
            }
            return cVar.s();
        }
        return (String) invokeL.objValue;
    }
}
