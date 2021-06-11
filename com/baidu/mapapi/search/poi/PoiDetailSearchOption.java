package com.baidu.mapapi.search.poi;
/* loaded from: classes2.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7262a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f7263b = "";

    /* renamed from: c  reason: collision with root package name */
    public boolean f7264c = false;

    public String getUid() {
        return this.f7262a;
    }

    public String getUids() {
        return this.f7263b;
    }

    public boolean isSearchByUids() {
        return this.f7264c;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.f7264c = false;
        this.f7262a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.f7264c = true;
        this.f7263b = str;
        return this;
    }
}
