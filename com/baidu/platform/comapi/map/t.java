package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes7.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MapSurfaceView mapSurfaceView) {
        this.f2932a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2932a.f2883a == null || (baseMap = this.f2932a.f2883a.getBaseMap()) == null) {
            return;
        }
        z = this.f2932a.n;
        baseMap.ShowStreetRoadMap(z);
    }
}
