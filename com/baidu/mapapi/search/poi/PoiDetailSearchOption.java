package com.baidu.mapapi.search.poi;
/* loaded from: classes2.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7219a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f7220b = "";

    /* renamed from: c  reason: collision with root package name */
    public boolean f7221c = false;

    public String getUid() {
        return this.f7219a;
    }

    public String getUids() {
        return this.f7220b;
    }

    public boolean isSearchByUids() {
        return this.f7221c;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.f7221c = false;
        this.f7219a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.f7221c = true;
        this.f7220b = str;
        return this;
    }
}
