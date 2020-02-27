package com.baidu.mapapi.search.district;
/* loaded from: classes8.dex */
public class DistrictSearchOption {
    public String mCityName;
    public String mDistrictName;

    public DistrictSearchOption cityName(String str) {
        this.mCityName = str;
        return this;
    }

    public DistrictSearchOption districtName(String str) {
        this.mDistrictName = str;
        return this;
    }
}
