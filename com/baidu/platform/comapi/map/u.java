package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes7.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2933a;
    final /* synthetic */ MapSurfaceView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MapSurfaceView mapSurfaceView, boolean z) {
        this.b = mapSurfaceView;
        this.f2933a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        if (this.b.f2883a == null || (baseMap = this.b.f2883a.getBaseMap()) == null) {
            return;
        }
        baseMap.ShowBaseIndoorMap(this.f2933a);
    }
}
