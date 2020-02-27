package com.baidu.platform.core.b;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.sapi2.activity.SlideActiviy;
/* loaded from: classes8.dex */
public class c extends com.baidu.platform.base.e {
    public c(GeoCodeOption geoCodeOption) {
        a(geoCodeOption);
    }

    private void a(GeoCodeOption geoCodeOption) {
        this.a.a("city", geoCodeOption.mCity);
        this.a.a(SlideActiviy.ADDRESS_PAGE_NAME, geoCodeOption.mAddress);
        this.a.a("output", "json");
        this.a.a("ret_coordtype", "bd09ll");
        this.a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.f();
    }
}
