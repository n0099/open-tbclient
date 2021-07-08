package com.baidu.sapi2.ecommerce.result;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class AddressSelectedBean implements Serializable, NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static String CITY_TYPE = "city";
    public static String COUNTRY_TYPE = "country";
    public static String DISTRICT_TYPE = "district";
    public static String PROVINCE_TYPE = "province";
    public static String TOWN_TYPE = "town";
    public transient /* synthetic */ FieldHolder $fh;
    public String cityId;
    public String cityName;
    public String countryId;
    public String countryName;
    public String districtId;
    public String districtName;
    public String provinceId;
    public String provinceName;
    public String townId;
    public String townName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1496136179, "Lcom/baidu/sapi2/ecommerce/result/AddressSelectedBean;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1496136179, "Lcom/baidu/sapi2/ecommerce/result/AddressSelectedBean;");
        }
    }

    public AddressSelectedBean() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean compare(AddressSelectedBean addressSelectedBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, addressSelectedBean)) == null) {
            if (addressSelectedBean == null) {
                return false;
            }
            return makeKey().equals(addressSelectedBean.makeKey());
        }
        return invokeL.booleanValue;
    }

    public String makeKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AddressSelectedBean{countryId='" + this.countryId + "', countryName='" + this.countryName + "', provinceId='" + this.provinceId + "', provinceName='" + this.provinceName + "', cityId='" + this.cityId + "', cityName='" + this.cityName + "', districtId='" + this.districtId + "', districtName='" + this.districtName + "'}";
        }
        return (String) invokeV.objValue;
    }
}
