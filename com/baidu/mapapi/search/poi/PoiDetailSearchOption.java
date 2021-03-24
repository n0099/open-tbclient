package com.baidu.mapapi.search.poi;
/* loaded from: classes2.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7209a;

    /* renamed from: b  reason: collision with root package name */
    public String f7210b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f7211c = "";

    /* renamed from: d  reason: collision with root package name */
    public boolean f7212d = false;

    public String getUid() {
        return this.f7210b;
    }

    public String getUids() {
        return this.f7211c;
    }

    public boolean isSearchByUids() {
        return this.f7212d;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.f7212d = false;
        this.f7210b = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.f7212d = true;
        this.f7211c = str;
        return this;
    }

    public PoiDetailSearchOption showPlaceCarter(boolean z) {
        this.f7209a = z;
        return this;
    }
}
