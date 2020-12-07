package com.baidu.mapapi.search.poi;
/* loaded from: classes26.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    private String f2121a = "";
    private String b = "";
    private boolean c = false;

    public String getUid() {
        return this.f2121a;
    }

    public String getUids() {
        return this.b;
    }

    public boolean isSearchByUids() {
        return this.c;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.c = false;
        this.f2121a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.c = true;
        this.b = str;
        return this;
    }
}
