package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f6807a;

    /* renamed from: b  reason: collision with root package name */
    public String f6808b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6809c;

    /* renamed from: d  reason: collision with root package name */
    public String f6810d;

    /* renamed from: e  reason: collision with root package name */
    public String f6811e;

    /* renamed from: f  reason: collision with root package name */
    public String f6812f;

    /* renamed from: g  reason: collision with root package name */
    public long f6813g;

    public FavoritePoiInfo addr(String str) {
        this.f6810d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f6811e = str;
        return this;
    }

    public String getAddr() {
        return this.f6810d;
    }

    public String getCityName() {
        return this.f6811e;
    }

    public String getID() {
        return this.f6807a;
    }

    public String getPoiName() {
        return this.f6808b;
    }

    public LatLng getPt() {
        return this.f6809c;
    }

    public long getTimeStamp() {
        return this.f6813g;
    }

    public String getUid() {
        return this.f6812f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f6808b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f6809c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f6812f = str;
        return this;
    }
}
