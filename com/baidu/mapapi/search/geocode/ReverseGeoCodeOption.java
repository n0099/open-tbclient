package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
/* loaded from: classes3.dex */
public class ReverseGeoCodeOption {
    public int a = 10;
    public int b = 0;
    public LatLng c = null;
    public int d = 1;
    public int e = 1000;
    public String f = null;
    public boolean g = false;
    public LanguageType h = LanguageType.LanguageTypeChinese;

    public boolean getExtensionsRoad() {
        return this.g;
    }

    public LanguageType getLanguage() {
        return this.h;
    }

    public int getLatestAdmin() {
        return this.d;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public int getPageNum() {
        return this.b;
    }

    public int getPageSize() {
        return this.a;
    }

    public String getPoiType() {
        return this.f;
    }

    public int getRadius() {
        return this.e;
    }

    public ReverseGeoCodeOption extensionsRoad(boolean z) {
        this.g = z;
        return this;
    }

    public ReverseGeoCodeOption language(LanguageType languageType) {
        this.h = languageType;
        return this;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i) {
        this.d = i;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i) {
        if (i < 0) {
            i = 0;
        }
        this.b = i;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        if (i <= 0) {
            this.a = 10;
        } else if (i > 100) {
            this.a = 100;
        } else {
            this.a = i;
        }
        return this;
    }

    public ReverseGeoCodeOption poiType(String str) {
        this.f = str;
        return this;
    }

    public ReverseGeoCodeOption radius(int i) {
        if (i < 0) {
            this.e = 0;
        } else if (i > 1000) {
            this.e = 1000;
        } else {
            this.e = i;
        }
        return this;
    }
}
