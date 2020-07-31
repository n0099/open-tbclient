package com.baidu.platform.core.d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes10.dex */
public class b extends com.baidu.platform.base.e {
    public b(BikingRoutePlanOption bikingRoutePlanOption) {
        a(bikingRoutePlanOption);
    }

    private void a(BikingRoutePlanOption bikingRoutePlanOption) {
        this.a.a("mode", "riding");
        LatLng location = bikingRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            this.a.a("origin", location.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + location.longitude);
        } else {
            this.a.a("origin", bikingRoutePlanOption.mFrom.getName());
        }
        LatLng location2 = bikingRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            this.a.a("destination", location2.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + location2.longitude);
        } else {
            this.a.a("destination", bikingRoutePlanOption.mTo.getName());
        }
        this.a.a("origin_region", bikingRoutePlanOption.mFrom.getCity());
        this.a.a("destination_region", bikingRoutePlanOption.mTo.getCity());
        if (bikingRoutePlanOption.mRidingType == 1) {
            this.a.a("riding_type", String.valueOf(bikingRoutePlanOption.mRidingType));
        }
        this.a.a("output", "json");
        this.a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.j();
    }
}
