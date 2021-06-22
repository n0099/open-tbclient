package com.baidu.platform.core.d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.base.e {
    public b(BikingRoutePlanOption bikingRoutePlanOption) {
        a(bikingRoutePlanOption);
    }

    private void a(BikingRoutePlanOption bikingRoutePlanOption) {
        this.f9317a.a("mode", "riding");
        LatLng location = bikingRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            com.baidu.platform.util.a aVar = this.f9317a;
            aVar.a("origin", location.latitude + "," + location.longitude);
        } else {
            this.f9317a.a("origin", bikingRoutePlanOption.mFrom.getName());
        }
        LatLng location2 = bikingRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            com.baidu.platform.util.a aVar2 = this.f9317a;
            aVar2.a("destination", location2.latitude + "," + location2.longitude);
        } else {
            this.f9317a.a("destination", bikingRoutePlanOption.mTo.getName());
        }
        this.f9317a.a("origin_region", bikingRoutePlanOption.mFrom.getCity());
        this.f9317a.a("destination_region", bikingRoutePlanOption.mTo.getCity());
        int i2 = bikingRoutePlanOption.mRidingType;
        if (i2 == 1) {
            this.f9317a.a("riding_type", String.valueOf(i2));
        }
        this.f9317a.a("output", "json");
        this.f9317a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.j();
    }
}
