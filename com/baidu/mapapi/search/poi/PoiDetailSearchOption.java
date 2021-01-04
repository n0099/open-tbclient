package com.baidu.mapapi.search.poi;
/* loaded from: classes15.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    private String f2995a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f2996b = "";
    private boolean c = false;

    public String getUid() {
        return this.f2995a;
    }

    public String getUids() {
        return this.f2996b;
    }

    public boolean isSearchByUids() {
        return this.c;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.c = false;
        this.f2995a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.c = true;
        this.f2996b = str;
        return this;
    }
}
