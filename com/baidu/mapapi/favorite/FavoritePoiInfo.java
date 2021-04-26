package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f7043a;

    /* renamed from: b  reason: collision with root package name */
    public String f7044b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7045c;

    /* renamed from: d  reason: collision with root package name */
    public String f7046d;

    /* renamed from: e  reason: collision with root package name */
    public String f7047e;

    /* renamed from: f  reason: collision with root package name */
    public String f7048f;

    /* renamed from: g  reason: collision with root package name */
    public long f7049g;

    public FavoritePoiInfo addr(String str) {
        this.f7046d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f7047e = str;
        return this;
    }

    public String getAddr() {
        return this.f7046d;
    }

    public String getCityName() {
        return this.f7047e;
    }

    public String getID() {
        return this.f7043a;
    }

    public String getPoiName() {
        return this.f7044b;
    }

    public LatLng getPt() {
        return this.f7045c;
    }

    public long getTimeStamp() {
        return this.f7049g;
    }

    public String getUid() {
        return this.f7048f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f7044b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f7045c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f7048f = str;
        return this;
    }
}
