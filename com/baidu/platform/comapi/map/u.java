package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes3.dex */
class u implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ MapSurfaceView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MapSurfaceView mapSurfaceView, boolean z) {
        this.b = mapSurfaceView;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        if (this.b.a == null || (baseMap = this.b.a.getBaseMap()) == null) {
            return;
        }
        baseMap.ShowBaseIndoorMap(this.a);
    }
}
