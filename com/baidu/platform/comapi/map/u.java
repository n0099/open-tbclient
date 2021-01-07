package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes3.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f4365a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f4366b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MapSurfaceView mapSurfaceView, boolean z) {
        this.f4366b = mapSurfaceView;
        this.f4365a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        if (this.f4366b.f4278a == null || (baseMap = this.f4366b.f4278a.getBaseMap()) == null) {
            return;
        }
        baseMap.ShowBaseIndoorMap(this.f4365a);
    }
}
