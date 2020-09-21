package com.baidu.platform.comapi.map.b;

import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements a.InterfaceC0241a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.platform.comapi.map.b.a.a.InterfaceC0241a
    public boolean a(com.baidu.platform.comapi.map.b.a.a aVar) {
        MapController mapController;
        MapController mapController2;
        MapController mapController3;
        MapController mapController4;
        MapController mapController5;
        MapController mapController6;
        MapController mapController7;
        MapController mapController8;
        mapController = this.a.b;
        if (mapController.isTwoTouchClickZoomEnabled()) {
            mapController2 = this.a.b;
            d gestureMonitor = mapController2.getGestureMonitor();
            mapController3 = this.a.b;
            gestureMonitor.c(mapController3.getZoomLevel() - 1.0f);
            mapController4 = this.a.b;
            mapController4.mapStatusChangeStart();
            mapController5 = this.a.b;
            mapController5.MapMsgProc(8193, 4, 0);
            mapController6 = this.a.b;
            if (mapController6.isNaviMode()) {
                mapController7 = this.a.b;
                if (mapController7.getNaviMapViewListener() != null) {
                    mapController8 = this.a.b;
                    mapController8.getNaviMapViewListener().onAction(521, null);
                }
            }
            return true;
        }
        return false;
    }
}
