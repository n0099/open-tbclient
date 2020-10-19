package com.baidu.mapapi.search.poi;
/* loaded from: classes7.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    private String f2117a = "";
    private String b = "";
    private boolean c = false;

    public String getUid() {
        return this.f2117a;
    }

    public String getUids() {
        return this.b;
    }

    public boolean isSearchByUids() {
        return this.c;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.c = false;
        this.f2117a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.c = true;
        this.b = str;
        return this;
    }
}
