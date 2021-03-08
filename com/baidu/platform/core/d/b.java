package com.baidu.platform.core.d;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes4.dex */
public class b extends com.baidu.platform.base.e {
    public b(BikingRoutePlanOption bikingRoutePlanOption) {
        a(bikingRoutePlanOption);
    }

    private void a(BikingRoutePlanOption bikingRoutePlanOption) {
        this.f2867a.a(UbcStatConstant.KEY_CONTENT_EXT_MODE, "riding");
        LatLng location = bikingRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            this.f2867a.a("origin", location.latitude + "," + location.longitude);
        } else {
            this.f2867a.a("origin", bikingRoutePlanOption.mFrom.getName());
        }
        LatLng location2 = bikingRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            this.f2867a.a("destination", location2.latitude + "," + location2.longitude);
        } else {
            this.f2867a.a("destination", bikingRoutePlanOption.mTo.getName());
        }
        this.f2867a.a("origin_region", bikingRoutePlanOption.mFrom.getCity());
        this.f2867a.a("destination_region", bikingRoutePlanOption.mTo.getCity());
        if (bikingRoutePlanOption.mRidingType == 1) {
            this.f2867a.a("riding_type", String.valueOf(bikingRoutePlanOption.mRidingType));
        }
        this.f2867a.a("output", "json");
        this.f2867a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.j();
    }
}
