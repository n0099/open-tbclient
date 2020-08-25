package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes20.dex */
class t implements Runnable {
    final /* synthetic */ MapSurfaceView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MapSurfaceView mapSurfaceView) {
        this.a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.a.a == null || (baseMap = this.a.a.getBaseMap()) == null) {
            return;
        }
        z = this.a.n;
        baseMap.ShowStreetRoadMap(z);
    }
}
