package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
/* loaded from: classes3.dex */
class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapController.a f4352a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MapController.a aVar) {
        this.f4352a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GeoPoint fromPixels = MapController.this.h.get().getProjection().fromPixels(MapController.this.getScreenWidth() / 2, MapController.this.getScreenHeight() / 2);
        if (fromPixels != null) {
            MapController.CleanAfterDBClick(MapController.this.s, (float) fromPixels.getLongitudeE6(), (float) fromPixels.getLatitudeE6());
        }
        MapController.this.M = false;
    }
}
