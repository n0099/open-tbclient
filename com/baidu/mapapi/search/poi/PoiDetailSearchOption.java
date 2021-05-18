package com.baidu.mapapi.search.poi;
/* loaded from: classes2.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7319a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f7320b = "";

    /* renamed from: c  reason: collision with root package name */
    public boolean f7321c = false;

    public String getUid() {
        return this.f7319a;
    }

    public String getUids() {
        return this.f7320b;
    }

    public boolean isSearchByUids() {
        return this.f7321c;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.f7321c = false;
        this.f7319a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.f7321c = true;
        this.f7320b = str;
        return this;
    }
}
