package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
/* loaded from: classes2.dex */
public class WeatherSearchOption {
    public String b;
    public LatLng c;
    public WeatherServerType a = WeatherServerType.WEATHER_SERVER_TYPE_DEFAULT;
    public WeatherDataType d = WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME;
    public LanguageType e = LanguageType.LanguageTypeChinese;

    public WeatherDataType getDataType() {
        return this.d;
    }

    public String getDistrictID() {
        return this.b;
    }

    public LanguageType getLanguageType() {
        return this.e;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public WeatherServerType getServerType() {
        return this.a;
    }

    public WeatherSearchOption districtID(String str) {
        this.b = str;
        return this;
    }

    public WeatherSearchOption languageType(LanguageType languageType) {
        this.e = languageType;
        return this;
    }

    public WeatherSearchOption location(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public WeatherSearchOption serverType(WeatherServerType weatherServerType) {
        this.a = weatherServerType;
        return this;
    }

    public WeatherSearchOption weatherDataType(WeatherDataType weatherDataType) {
        this.d = weatherDataType;
        return this;
    }
}
