package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f implements com.baidu.mapsdkplatform.comapi.map.z {
    final /* synthetic */ BaiduMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.z
    public Bundle a(int i, int i2, int i3, Context context) {
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        lock = this.a.J;
        lock.lock();
        try {
            tileOverlay = this.a.G;
            if (tileOverlay != null) {
                tileOverlay2 = this.a.G;
                Tile a = tileOverlay2.a(i, i2, i3);
                Log.e("SDKTileLayer", "mapLayerDataReq tile t == null = " + (a == null));
                if (a != null) {
                    return a.toBundle();
                }
            }
            lock3 = this.a.J;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.a.J;
            lock2.unlock();
        }
    }
}
