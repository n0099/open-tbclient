package com.baidu.platform.core.b;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.platform.base.SearchType;
/* loaded from: classes4.dex */
public class a extends com.baidu.platform.base.a implements d {
    OnGetGeoCoderResultListener b = null;

    @Override // com.baidu.platform.core.b.d
    public void a() {
        this.a.lock();
        this.b = null;
        this.a.unlock();
    }

    @Override // com.baidu.platform.core.b.d
    public void a(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        this.a.lock();
        this.b = onGetGeoCoderResultListener;
        this.a.unlock();
    }

    @Override // com.baidu.platform.core.b.d
    public boolean a(GeoCodeOption geoCodeOption) {
        b bVar = new b();
        c cVar = new c(geoCodeOption);
        bVar.a(SearchType.GEO_CODER);
        return a(cVar, this.b, bVar);
    }

    @Override // com.baidu.platform.core.b.d
    public boolean a(ReverseGeoCodeOption reverseGeoCodeOption) {
        e eVar = new e();
        f fVar = new f(reverseGeoCodeOption);
        eVar.a(SearchType.REVERSE_GEO_CODER);
        return a(fVar, this.b, eVar);
    }
}
