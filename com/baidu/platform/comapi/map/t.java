package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes15.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f4363a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MapSurfaceView mapSurfaceView) {
        this.f4363a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f4363a.f4277a == null || (baseMap = this.f4363a.f4277a.getBaseMap()) == null) {
            return;
        }
        z = this.f4363a.n;
        baseMap.ShowStreetRoadMap(z);
    }
}
