package com.baidu.platform.comapi.map.b;

import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements a.InterfaceC0256a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2907a = bVar;
    }

    @Override // com.baidu.platform.comapi.map.b.a.a.InterfaceC0256a
    public boolean a(com.baidu.platform.comapi.map.b.a.a aVar) {
        MapController mapController;
        MapController mapController2;
        MapController mapController3;
        MapController mapController4;
        MapController mapController5;
        MapController mapController6;
        MapController mapController7;
        MapController mapController8;
        mapController = this.f2907a.b;
        if (mapController.isTwoTouchClickZoomEnabled()) {
            mapController2 = this.f2907a.b;
            d gestureMonitor = mapController2.getGestureMonitor();
            mapController3 = this.f2907a.b;
            gestureMonitor.c(mapController3.getZoomLevel() - 1.0f);
            mapController4 = this.f2907a.b;
            mapController4.mapStatusChangeStart();
            mapController5 = this.f2907a.b;
            mapController5.MapMsgProc(8193, 4, 0);
            mapController6 = this.f2907a.b;
            if (mapController6.isNaviMode()) {
                mapController7 = this.f2907a.b;
                if (mapController7.getNaviMapViewListener() != null) {
                    mapController8 = this.f2907a.b;
                    mapController8.getNaviMapViewListener().onAction(521, null);
                }
            }
            return true;
        }
        return false;
    }
}
