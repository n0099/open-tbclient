package com.baidu.mapapi.search.poi;
/* loaded from: classes2.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7210a;

    /* renamed from: b  reason: collision with root package name */
    public String f7211b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f7212c = "";

    /* renamed from: d  reason: collision with root package name */
    public boolean f7213d = false;

    public String getUid() {
        return this.f7211b;
    }

    public String getUids() {
        return this.f7212c;
    }

    public boolean isSearchByUids() {
        return this.f7213d;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.f7213d = false;
        this.f7211b = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.f7213d = true;
        this.f7212c = str;
        return this;
    }

    public PoiDetailSearchOption showPlaceCarter(boolean z) {
        this.f7210a = z;
        return this;
    }
}
