package com.baidu.mapapi.search.poi;
/* loaded from: classes4.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    boolean f2114a;
    private String b = "";
    private String c = "";
    private boolean d = false;

    public String getUid() {
        return this.b;
    }

    public String getUids() {
        return this.c;
    }

    public boolean isSearchByUids() {
        return this.d;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.d = false;
        this.b = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.d = true;
        this.c = str;
        return this;
    }

    public PoiDetailSearchOption showPlaceCarter(boolean z) {
        this.f2114a = z;
        return this;
    }
}
