package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes7.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MapSurfaceView mapSurfaceView) {
        this.f2929a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2929a.f2883a == null || (baseMap = this.f2929a.f2883a.getBaseMap()) == null) {
            return;
        }
        z = this.f2929a.m;
        baseMap.ShowSatelliteMap(z);
    }
}
