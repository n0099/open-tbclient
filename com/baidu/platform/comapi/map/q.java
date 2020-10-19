package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes7.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MapSurfaceView mapSurfaceView) {
        this.f2927a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2927a.f2881a == null || (baseMap = this.f2927a.f2881a.getBaseMap()) == null) {
            return;
        }
        z = this.f2927a.m;
        baseMap.ShowSatelliteMap(z);
    }
}
