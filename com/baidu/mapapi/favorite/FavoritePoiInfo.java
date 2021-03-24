package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f6771a;

    /* renamed from: b  reason: collision with root package name */
    public String f6772b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6773c;

    /* renamed from: d  reason: collision with root package name */
    public String f6774d;

    /* renamed from: e  reason: collision with root package name */
    public String f6775e;

    /* renamed from: f  reason: collision with root package name */
    public String f6776f;

    /* renamed from: g  reason: collision with root package name */
    public long f6777g;

    public FavoritePoiInfo addr(String str) {
        this.f6774d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f6775e = str;
        return this;
    }

    public String getAddr() {
        return this.f6774d;
    }

    public String getCityName() {
        return this.f6775e;
    }

    public String getID() {
        return this.f6771a;
    }

    public String getPoiName() {
        return this.f6772b;
    }

    public LatLng getPt() {
        return this.f6773c;
    }

    public long getTimeStamp() {
        return this.f6777g;
    }

    public String getUid() {
        return this.f6776f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f6772b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f6773c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f6776f = str;
        return this;
    }
}
