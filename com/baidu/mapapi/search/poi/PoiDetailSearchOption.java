package com.baidu.mapapi.search.poi;
/* loaded from: classes3.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    private String f2996a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f2997b = "";
    private boolean c = false;

    public String getUid() {
        return this.f2996a;
    }

    public String getUids() {
        return this.f2997b;
    }

    public boolean isSearchByUids() {
        return this.c;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.c = false;
        this.f2996a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.c = true;
        this.f2997b = str;
        return this;
    }
}
