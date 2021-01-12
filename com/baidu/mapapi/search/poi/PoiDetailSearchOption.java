package com.baidu.mapapi.search.poi;
/* loaded from: classes6.dex */
public class PoiDetailSearchOption {

    /* renamed from: a  reason: collision with root package name */
    boolean f2874a;

    /* renamed from: b  reason: collision with root package name */
    private String f2875b = "";
    private String c = "";
    private boolean d = false;

    public String getUid() {
        return this.f2875b;
    }

    public String getUids() {
        return this.c;
    }

    public boolean isSearchByUids() {
        return this.d;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.d = false;
        this.f2875b = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.d = true;
        this.c = str;
        return this;
    }

    public PoiDetailSearchOption showPlaceCarter(boolean z) {
        this.f2874a = z;
        return this;
    }
}
