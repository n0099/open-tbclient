package com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil;

import android.graphics.Color;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.searchbox.ng.ai.apps.R;
/* loaded from: classes4.dex */
public class MyDrivingRouteOverlay extends DrivingRouteOverlay {
    private static final int DRIVING_LINE_COLOR = Color.parseColor("#26c56c");

    public MyDrivingRouteOverlay(BaiduMap baiduMap) {
        super(baiduMap);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil.DrivingRouteOverlay
    public BitmapDescriptor getStartMarker() {
        return BitmapDescriptorFactory.fromResource(R.drawable.aiapps_icon_route_st);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil.DrivingRouteOverlay
    public BitmapDescriptor getTerminalMarker() {
        return BitmapDescriptorFactory.fromResource(R.drawable.aiapps_icon_route_en);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil.DrivingRouteOverlay
    public int getLineColor() {
        return DRIVING_LINE_COLOR;
    }
}
