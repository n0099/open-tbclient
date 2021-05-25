package com.baidu.platform.core.d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
/* loaded from: classes2.dex */
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
            com.baidu.platform.util.a aVar = this.f9252a;
            aVar.a("origin", location.latitude + "," + location.longitude);
        } else {
            this.f9252a.a("origin", massTransitRoutePlanOption.mFrom.getName());
        }
        if (massTransitRoutePlanOption.mFrom.getCity() != null) {
            this.f9252a.a("origin_region", massTransitRoutePlanOption.mFrom.getCity());
        }
        LatLng location2 = massTransitRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            com.baidu.platform.util.a aVar2 = this.f9252a;
            aVar2.a("destination", location2.latitude + "," + location2.longitude);
        } else {
            this.f9252a.a("destination", massTransitRoutePlanOption.mTo.getName());
        }
        if (massTransitRoutePlanOption.mTo.getCity() != null) {
            this.f9252a.a("destination_region", massTransitRoutePlanOption.mTo.getCity());
        }
        com.baidu.platform.util.a aVar3 = this.f9252a;
        aVar3.a("tactics_incity", massTransitRoutePlanOption.mTacticsIncity.getInt() + "");
        com.baidu.platform.util.a aVar4 = this.f9252a;
        aVar4.a("tactics_intercity", massTransitRoutePlanOption.mTacticsIntercity.getInt() + "");
        com.baidu.platform.util.a aVar5 = this.f9252a;
        aVar5.a("trans_type_intercity", massTransitRoutePlanOption.mTransTypeIntercity.getInt() + "");
        com.baidu.platform.util.a aVar6 = this.f9252a;
        aVar6.a("page_index", massTransitRoutePlanOption.mPageIndex + "");
        com.baidu.platform.util.a aVar7 = this.f9252a;
        aVar7.a("page_size", massTransitRoutePlanOption.mPageSize + "");
        this.f9252a.a("coord_type", massTransitRoutePlanOption.mCoordType);
        this.f9252a.a("output", "json");
        this.f9252a.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.g();
    }
}
