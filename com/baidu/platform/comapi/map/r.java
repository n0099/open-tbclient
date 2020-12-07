package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes26.dex */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MapSurfaceView mapSurfaceView) {
        this.f2932a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2932a.f2885a == null || (baseMap = this.f2932a.f2885a.getBaseMap()) == null) {
            return;
        }
        z = this.f2932a.l;
        baseMap.ShowTrafficMap(z);
    }
}
