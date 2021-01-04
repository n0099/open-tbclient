package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes15.dex */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f4361a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MapSurfaceView mapSurfaceView) {
        this.f4361a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f4361a.f4277a == null || (baseMap = this.f4361a.f4277a.getBaseMap()) == null) {
            return;
        }
        z = this.f4361a.l;
        baseMap.ShowTrafficMap(z);
    }
}
