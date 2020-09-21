package com.baidu.mapapi.search.poi;
/* loaded from: classes3.dex */
public class PoiDetailSearchOption {
    private String a = "";
    private String b = "";
    private boolean c = false;

    public String getUid() {
        return this.a;
    }

    public String getUids() {
        return this.b;
    }

    public boolean isSearchByUids() {
        return this.c;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.c = false;
        this.a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.c = true;
        this.b = str;
        return this;
    }
}
