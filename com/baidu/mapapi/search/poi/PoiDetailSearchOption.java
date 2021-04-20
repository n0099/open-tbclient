package com.baidu.mapapi.search.poi;
/* loaded from: classes2.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7245a;

    /* renamed from: b  reason: collision with root package name */
    public String f7246b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f7247c = "";

    /* renamed from: d  reason: collision with root package name */
    public boolean f7248d = false;

    public String getUid() {
        return this.f7246b;
    }

    public String getUids() {
        return this.f7247c;
    }

    public boolean isSearchByUids() {
        return this.f7248d;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.f7248d = false;
        this.f7246b = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.f7248d = true;
        this.f7247c = str;
        return this;
    }

    public PoiDetailSearchOption showPlaceCarter(boolean z) {
        this.f7245a = z;
        return this;
    }
}
