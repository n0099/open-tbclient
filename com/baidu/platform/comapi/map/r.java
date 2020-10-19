package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes7.dex */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MapSurfaceView mapSurfaceView) {
        this.f2928a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2928a.f2881a == null || (baseMap = this.f2928a.f2881a.getBaseMap()) == null) {
            return;
        }
        z = this.f2928a.l;
        baseMap.ShowTrafficMap(z);
    }
}
