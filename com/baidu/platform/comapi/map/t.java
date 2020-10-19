package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes7.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MapSurfaceView mapSurfaceView) {
        this.f2930a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2930a.f2881a == null || (baseMap = this.f2930a.f2881a.getBaseMap()) == null) {
            return;
        }
        z = this.f2930a.n;
        baseMap.ShowStreetRoadMap(z);
    }
}
