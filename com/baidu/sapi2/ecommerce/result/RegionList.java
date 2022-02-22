package com.baidu.sapi2.ecommerce.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class RegionList implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String nameListStr;
    public String regionListStr;
    public String typeListStr;

    public RegionList() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static RegionList generateRegionList(AddressSelectedBean addressSelectedBean) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, addressSelectedBean)) == null) {
            RegionList regionList = new RegionList();
            if (addressSelectedBean == null) {
                return regionList;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            if (!TextUtils.isEmpty(addressSelectedBean.countryId)) {
                sb.append(addressSelectedBean.countryId);
                sb.append(",");
                sb3.append(addressSelectedBean.countryName);
                sb3.append(",");
                sb2.append(AddressSelectedBean.COUNTRY_TYPE);
                sb2.append(",");
            }
            if (!TextUtils.isEmpty(addressSelectedBean.provinceId)) {
                sb.append(addressSelectedBean.provinceId);
                sb.append(",");
                sb3.append(addressSelectedBean.provinceName);
                sb3.append(",");
                sb2.append(AddressSelectedBean.PROVINCE_TYPE);
                sb2.append(",");
            }
            if (!TextUtils.isEmpty(addressSelectedBean.cityId)) {
                sb.append(addressSelectedBean.cityId);
                sb.append(",");
                sb3.append(addressSelectedBean.cityName);
                sb3.append(",");
                sb2.append(AddressSelectedBean.CITY_TYPE);
                sb2.append(",");
            }
            if (!TextUtils.isEmpty(addressSelectedBean.districtId)) {
                sb.append(addressSelectedBean.districtId);
                sb.append(",");
                sb3.append(addressSelectedBean.districtName);
                sb3.append(",");
                sb2.append(AddressSelectedBean.DISTRICT_TYPE);
                sb2.append(",");
            }
            if (!TextUtils.isEmpty(addressSelectedBean.townId)) {
                sb.append(addressSelectedBean.townId);
                sb.append(",");
                sb3.append(addressSelectedBean.townName);
                sb3.append(",");
                sb2.append(AddressSelectedBean.TOWN_TYPE);
                sb2.append(",");
            }
            regionList.regionListStr = getStrFromBuilder(sb);
            regionList.nameListStr = getStrFromBuilder(sb3);
            regionList.typeListStr = getStrFromBuilder(sb2);
            return regionList;
        }
        return (RegionList) invokeL.objValue;
    }

    public static String getStrFromBuilder(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sb)) == null) ? (sb == null || sb.length() <= 0) ? "" : sb.substring(0, sb.length() - 1) : (String) invokeL.objValue;
    }
}
