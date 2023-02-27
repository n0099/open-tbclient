package com.baidu.sapi2.ecommerce.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
/* loaded from: classes2.dex */
public class RegionList implements NoProguard {
    public String nameListStr;
    public String regionListStr;
    public String typeListStr;

    public static RegionList generateRegionList(AddressSelectedBean addressSelectedBean) {
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

    public static String getStrFromBuilder(StringBuilder sb) {
        if (sb != null && sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }
}
