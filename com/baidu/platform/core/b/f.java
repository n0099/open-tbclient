package com.baidu.platform.core.b;

import android.net.http.Headers;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
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
            this.a.a(Headers.LOCATION, latLng.latitude + "," + latLng.longitude);
        }
        this.a.a("coordtype", "bd09ll");
        this.a.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.a.a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.a.a("pois", "1");
        this.a.a("output", NetworkDef.DataType.JSON);
        this.a.a("from", "android_map_sdk");
        this.a.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.e();
    }
}
