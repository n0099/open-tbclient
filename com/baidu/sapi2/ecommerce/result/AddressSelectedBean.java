package com.baidu.sapi2.ecommerce.result;

import com.baidu.sapi2.NoProguard;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class AddressSelectedBean implements Serializable, NoProguard {
    public static String CITY_TYPE = "city";
    public static String COUNTRY_TYPE = "country";
    public static String DISTRICT_TYPE = "district";
    public static String PROVINCE_TYPE = "province";
    public static String TOWN_TYPE = "town";
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

    public boolean compare(AddressSelectedBean addressSelectedBean) {
        if (addressSelectedBean == null) {
            return false;
        }
        return makeKey().equals(addressSelectedBean.makeKey());
    }

    public String makeKey() {
        return "AddressSelectedBean{countryId='" + this.countryId + "', countryName='" + this.countryName + "', provinceId='" + this.provinceId + "', provinceName='" + this.provinceName + "', cityId='" + this.cityId + "', cityName='" + this.cityName + "', districtId='" + this.districtId + "', districtName='" + this.districtName + "'}";
    }
}
