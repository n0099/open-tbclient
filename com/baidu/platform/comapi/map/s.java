package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes15.dex */
class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f4362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MapSurfaceView mapSurfaceView) {
        this.f4362a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f4362a.f4277a == null || (baseMap = this.f4362a.f4277a.getBaseMap()) == null) {
            return;
        }
        z = this.f4362a.l;
        baseMap.ShowTrafficMap(z);
    }
}
