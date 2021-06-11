package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f6797a;

    /* renamed from: b  reason: collision with root package name */
    public String f6798b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6799c;

    /* renamed from: d  reason: collision with root package name */
    public String f6800d;

    /* renamed from: e  reason: collision with root package name */
    public String f6801e;

    /* renamed from: f  reason: collision with root package name */
    public String f6802f;

    /* renamed from: g  reason: collision with root package name */
    public long f6803g;

    public FavoritePoiInfo addr(String str) {
        this.f6800d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f6801e = str;
        return this;
    }

    public String getAddr() {
        return this.f6800d;
    }

    public String getCityName() {
        return this.f6801e;
    }

    public String getID() {
        return this.f6797a;
    }

    public String getPoiName() {
        return this.f6798b;
    }

    public LatLng getPt() {
        return this.f6799c;
    }

    public long getTimeStamp() {
        return this.f6803g;
    }

    public String getUid() {
        return this.f6802f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f6798b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f6799c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f6802f = str;
        return this;
    }
}
