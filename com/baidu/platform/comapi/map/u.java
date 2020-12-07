package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes26.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2935a;
    final /* synthetic */ MapSurfaceView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MapSurfaceView mapSurfaceView, boolean z) {
        this.b = mapSurfaceView;
        this.f2935a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        if (this.b.f2885a == null || (baseMap = this.b.f2885a.getBaseMap()) == null) {
            return;
        }
        baseMap.ShowBaseIndoorMap(this.f2935a);
    }
}
