package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes26.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MapSurfaceView mapSurfaceView) {
        this.f2931a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2931a.f2885a == null || (baseMap = this.f2931a.f2885a.getBaseMap()) == null) {
            return;
        }
        z = this.f2931a.m;
        baseMap.ShowSatelliteMap(z);
    }
}
