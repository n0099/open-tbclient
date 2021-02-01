package com.baidu.platform.core.b;

import android.net.http.Headers;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes4.dex */
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
            this.f4143a.a(Headers.LOCATION, latLng.latitude + "," + latLng.longitude);
        }
        this.f4143a.a("coordtype", "bd09ll");
        this.f4143a.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.f4143a.a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.f4143a.a("pois", "1");
        this.f4143a.a("output", "json");
        this.f4143a.a("from", "android_map_sdk");
        this.f4143a.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
        this.f4143a.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.e();
    }
}
