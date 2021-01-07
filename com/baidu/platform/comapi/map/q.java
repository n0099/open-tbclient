package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes3.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f4361a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MapSurfaceView mapSurfaceView) {
        this.f4361a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f4361a.f4278a == null || (baseMap = this.f4361a.f4278a.getBaseMap()) == null) {
            return;
        }
        z = this.f4361a.m;
        baseMap.ShowSatelliteMap(z);
    }
}
