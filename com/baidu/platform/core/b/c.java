package com.baidu.platform.core.b;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
/* loaded from: classes2.dex */
public class c extends com.baidu.platform.base.e {
    public c(GeoCodeOption geoCodeOption) {
        a(geoCodeOption);
    }

    private void a(GeoCodeOption geoCodeOption) {
        this.f9821a.a("city", geoCodeOption.mCity);
        this.f9821a.a("address", geoCodeOption.mAddress);
        this.f9821a.a("output", "json");
        this.f9821a.a("ret_coordtype", "bd09ll");
        this.f9821a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.f();
    }
}
