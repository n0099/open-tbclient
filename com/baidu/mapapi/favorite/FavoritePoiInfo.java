package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f6754a;

    /* renamed from: b  reason: collision with root package name */
    public String f6755b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6756c;

    /* renamed from: d  reason: collision with root package name */
    public String f6757d;

    /* renamed from: e  reason: collision with root package name */
    public String f6758e;

    /* renamed from: f  reason: collision with root package name */
    public String f6759f;

    /* renamed from: g  reason: collision with root package name */
    public long f6760g;

    public FavoritePoiInfo addr(String str) {
        this.f6757d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f6758e = str;
        return this;
    }

    public String getAddr() {
        return this.f6757d;
    }

    public String getCityName() {
        return this.f6758e;
    }

    public String getID() {
        return this.f6754a;
    }

    public String getPoiName() {
        return this.f6755b;
    }

    public LatLng getPt() {
        return this.f6756c;
    }

    public long getTimeStamp() {
        return this.f6760g;
    }

    public String getUid() {
        return this.f6759f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f6755b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f6756c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f6759f = str;
        return this;
    }
}
