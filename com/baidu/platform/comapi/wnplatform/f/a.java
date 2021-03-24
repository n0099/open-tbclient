package com.baidu.platform.comapi.wnplatform.f;

import android.os.Bundle;
import com.baidu.mapapi.bikenavi.model.BikeRouteDetailInfo;
import java.math.BigDecimal;
/* loaded from: classes2.dex */
public class a {
    public static BikeRouteDetailInfo a(Bundle bundle) {
        BikeRouteDetailInfo bikeRouteDetailInfo = new BikeRouteDetailInfo();
        try {
            bikeRouteDetailInfo.setSpeed(new BigDecimal((bundle.getFloat("curSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue());
            bikeRouteDetailInfo.setMaxSpeed(new BigDecimal((bundle.getFloat("maxSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue());
            bikeRouteDetailInfo.setAvSpeed(new BigDecimal((bundle.getFloat("avgSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue());
            float f2 = bundle.getFloat("altidiff");
            float f3 = bundle.getFloat("altitude");
            bikeRouteDetailInfo.setDiffAltitude(f2);
            bikeRouteDetailInfo.setAltitude(f3);
        } catch (Exception unused) {
        }
        return bikeRouteDetailInfo;
    }
}
