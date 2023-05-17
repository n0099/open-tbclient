package com.baidu.mapapi.search.poi;
/* loaded from: classes3.dex */
public class PoiDetailSearchOption {
    public String a = "";
    public boolean b = true;
    public String c = "";
    public boolean d = false;

    public String getUid() {
        return this.a;
    }

    public String getUids() {
        return this.c;
    }

    public boolean isExtendAdcode() {
        return this.b;
    }

    public boolean isSearchByUids() {
        return this.d;
    }

    public PoiDetailSearchOption extendAdcode(boolean z) {
        this.b = z;
        return this;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.d = false;
        this.a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.d = true;
        this.c = str;
        return this;
    }
}
