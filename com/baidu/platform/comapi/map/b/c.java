package com.baidu.platform.comapi.map.b;

import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.b.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements a.InterfaceC0291a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4327a = bVar;
    }

    @Override // com.baidu.platform.comapi.map.b.a.a.InterfaceC0291a
    public boolean a(com.baidu.platform.comapi.map.b.a.a aVar) {
        MapController mapController;
        MapController mapController2;
        MapController mapController3;
        MapController mapController4;
        MapController mapController5;
        MapController mapController6;
        MapController mapController7;
        MapController mapController8;
        mapController = this.f4327a.f4321b;
        if (mapController.isTwoTouchClickZoomEnabled()) {
            mapController2 = this.f4327a.f4321b;
            d gestureMonitor = mapController2.getGestureMonitor();
            mapController3 = this.f4327a.f4321b;
            gestureMonitor.c(mapController3.getZoomLevel() - 1.0f);
            mapController4 = this.f4327a.f4321b;
            mapController4.mapStatusChangeStart();
            mapController5 = this.f4327a.f4321b;
            mapController5.MapMsgProc(8193, 4, 0);
            mapController6 = this.f4327a.f4321b;
            if (mapController6.isNaviMode()) {
                mapController7 = this.f4327a.f4321b;
                if (mapController7.getNaviMapViewListener() != null) {
                    mapController8 = this.f4327a.f4321b;
                    mapController8.getNaviMapViewListener().onAction(521, null);
                }
            }
            return true;
        }
        return false;
    }
}
