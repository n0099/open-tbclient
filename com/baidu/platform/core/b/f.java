package com.baidu.platform.core.b;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes2.dex */
public class f extends com.baidu.platform.base.e {
    public f(ReverseGeoCodeOption reverseGeoCodeOption) {
        a(reverseGeoCodeOption);
    }

    private void a(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (reverseGeoCodeOption.getLocation() != null) {
            LatLng latLng = new LatLng(reverseGeoCodeOption.getLocation().latitude, reverseGeoCodeOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            com.baidu.platform.util.a aVar = this.f9379a;
            aVar.a("location", latLng.latitude + "," + latLng.longitude);
        }
        this.f9379a.a("coordtype", "bd09ll");
        this.f9379a.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.f9379a.a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.f9379a.a("pois", "1");
        this.f9379a.a("output", "json");
        this.f9379a.a("from", "android_map_sdk");
        this.f9379a.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
        this.f9379a.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.e();
    }
}
