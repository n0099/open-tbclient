package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MapViewLayoutParams;
/* loaded from: classes2.dex */
public class e implements Runnable {
    public final /* synthetic */ InfoWindow a;
    public final /* synthetic */ d b;

    public e(d dVar, InfoWindow infoWindow) {
        this.b = dVar;
        this.a = infoWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c.setLayoutParams(new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(this.a.d).yOffset(this.a.g).build());
    }
}
