package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.locks.Lock;
/* loaded from: classes3.dex */
public class g implements com.baidu.mapsdkplatform.comapi.map.ab {
    public final /* synthetic */ BaiduMap a;

    public g(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.ab
    public Bundle a(int i, int i2, int i3, Context context) {
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        boolean z;
        lock = this.a.M;
        lock.lock();
        try {
            tileOverlay = this.a.J;
            if (tileOverlay != null) {
                tileOverlay2 = this.a.J;
                Tile a = tileOverlay2.a(i, i2, i3);
                StringBuilder sb = new StringBuilder();
                sb.append("mapLayerDataReq tile t == null = ");
                if (a == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.e("SDKTileLayer", sb.toString());
                if (a != null) {
                    return a.toBundle();
                }
            }
            lock3 = this.a.M;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.a.M;
            lock2.unlock();
        }
    }
}
