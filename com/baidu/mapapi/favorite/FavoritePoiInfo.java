package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f6854a;

    /* renamed from: b  reason: collision with root package name */
    public String f6855b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6856c;

    /* renamed from: d  reason: collision with root package name */
    public String f6857d;

    /* renamed from: e  reason: collision with root package name */
    public String f6858e;

    /* renamed from: f  reason: collision with root package name */
    public String f6859f;

    /* renamed from: g  reason: collision with root package name */
    public long f6860g;

    public FavoritePoiInfo addr(String str) {
        this.f6857d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f6858e = str;
        return this;
    }

    public String getAddr() {
        return this.f6857d;
    }

    public String getCityName() {
        return this.f6858e;
    }

    public String getID() {
        return this.f6854a;
    }

    public String getPoiName() {
        return this.f6855b;
    }

    public LatLng getPt() {
        return this.f6856c;
    }

    public long getTimeStamp() {
        return this.f6860g;
    }

    public String getUid() {
        return this.f6859f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f6855b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f6856c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f6859f = str;
        return this;
    }
}
