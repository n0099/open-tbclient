package com.baidu.platform.core.d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes3.dex */
public class i extends com.baidu.platform.base.e {
    public i(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        a(massTransitRoutePlanOption);
    }

    private void a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        LatLng location = massTransitRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            this.f4178a.a("origin", location.latitude + "," + location.longitude);
        } else {
            this.f4178a.a("origin", massTransitRoutePlanOption.mFrom.getName());
        }
        if (massTransitRoutePlanOption.mFrom.getCity() != null) {
            this.f4178a.a("origin_region", massTransitRoutePlanOption.mFrom.getCity());
        }
        LatLng location2 = massTransitRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            this.f4178a.a("destination", location2.latitude + "," + location2.longitude);
        } else {
            this.f4178a.a("destination", massTransitRoutePlanOption.mTo.getName());
        }
        if (massTransitRoutePlanOption.mTo.getCity() != null) {
            this.f4178a.a("destination_region", massTransitRoutePlanOption.mTo.getCity());
        }
        this.f4178a.a("tactics_incity", massTransitRoutePlanOption.mTacticsIncity.getInt() + "");
        this.f4178a.a("tactics_intercity", massTransitRoutePlanOption.mTacticsIntercity.getInt() + "");
        this.f4178a.a("trans_type_intercity", massTransitRoutePlanOption.mTransTypeIntercity.getInt() + "");
        this.f4178a.a("page_index", massTransitRoutePlanOption.mPageIndex + "");
        this.f4178a.a("page_size", massTransitRoutePlanOption.mPageSize + "");
        this.f4178a.a("coord_type", massTransitRoutePlanOption.mCoordType);
        this.f4178a.a("output", "json");
        this.f4178a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.g();
    }
}
