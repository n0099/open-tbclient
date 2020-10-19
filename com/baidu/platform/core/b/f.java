package com.baidu.platform.core.b;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
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
            this.f2814a.a("location", latLng.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + latLng.longitude);
        }
        this.f2814a.a("coordtype", "bd09ll");
        this.f2814a.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.f2814a.a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.f2814a.a("pois", "1");
        this.f2814a.a("output", "jsonaes");
        this.f2814a.a("from", "android_map_sdk");
        this.f2814a.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
        this.f2814a.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.e();
    }
}
