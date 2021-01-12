package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes6.dex */
public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    String f2681a;

    /* renamed from: b  reason: collision with root package name */
    String f2682b;
    LatLng c;
    String d;
    String e;
    String f;
    long g;

    public FavoritePoiInfo addr(String str) {
        this.d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.e = str;
        return this;
    }

    public String getAddr() {
        return this.d;
    }

    public String getCityName() {
        return this.e;
    }

    public String getID() {
        return this.f2681a;
    }

    public String getPoiName() {
        return this.f2682b;
    }

    public LatLng getPt() {
        return this.c;
    }

    public long getTimeStamp() {
        return this.g;
    }

    public String getUid() {
        return this.f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f2682b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f = str;
        return this;
    }
}
