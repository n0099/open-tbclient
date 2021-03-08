package com.baidu.platform.core.b;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
/* loaded from: classes4.dex */
public class c extends com.baidu.platform.base.e {
    public c(GeoCodeOption geoCodeOption) {
        a(geoCodeOption);
    }

    private void a(GeoCodeOption geoCodeOption) {
        this.f2867a.a("city", geoCodeOption.mCity);
        this.f2867a.a("address", geoCodeOption.mAddress);
        this.f2867a.a("output", "json");
        this.f2867a.a("ret_coordtype", "bd09ll");
        this.f2867a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.f();
    }
}
