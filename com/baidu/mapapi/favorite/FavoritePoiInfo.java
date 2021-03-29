package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f6772a;

    /* renamed from: b  reason: collision with root package name */
    public String f6773b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6774c;

    /* renamed from: d  reason: collision with root package name */
    public String f6775d;

    /* renamed from: e  reason: collision with root package name */
    public String f6776e;

    /* renamed from: f  reason: collision with root package name */
    public String f6777f;

    /* renamed from: g  reason: collision with root package name */
    public long f6778g;

    public FavoritePoiInfo addr(String str) {
        this.f6775d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f6776e = str;
        return this;
    }

    public String getAddr() {
        return this.f6775d;
    }

    public String getCityName() {
        return this.f6776e;
    }

    public String getID() {
        return this.f6772a;
    }

    public String getPoiName() {
        return this.f6773b;
    }

    public LatLng getPt() {
        return this.f6774c;
    }

    public long getTimeStamp() {
        return this.f6778g;
    }

    public String getUid() {
        return this.f6777f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f6773b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f6774c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f6777f = str;
        return this;
    }
}
