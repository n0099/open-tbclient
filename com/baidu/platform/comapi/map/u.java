package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes15.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f4364a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f4365b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MapSurfaceView mapSurfaceView, boolean z) {
        this.f4365b = mapSurfaceView;
        this.f4364a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        if (this.f4365b.f4277a == null || (baseMap = this.f4365b.f4277a.getBaseMap()) == null) {
            return;
        }
        baseMap.ShowBaseIndoorMap(this.f4364a);
    }
}
