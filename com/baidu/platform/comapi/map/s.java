package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes7.dex */
class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MapSurfaceView mapSurfaceView) {
        this.f2931a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2931a.f2883a == null || (baseMap = this.f2931a.f2883a.getBaseMap()) == null) {
            return;
        }
        z = this.f2931a.l;
        baseMap.ShowTrafficMap(z);
    }
}
