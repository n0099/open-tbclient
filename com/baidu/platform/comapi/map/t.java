package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes26.dex */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapSurfaceView f2934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MapSurfaceView mapSurfaceView) {
        this.f2934a = mapSurfaceView;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppBaseMap baseMap;
        boolean z;
        if (this.f2934a.f2885a == null || (baseMap = this.f2934a.f2885a.getBaseMap()) == null) {
            return;
        }
        z = this.f2934a.n;
        baseMap.ShowStreetRoadMap(z);
    }
}
