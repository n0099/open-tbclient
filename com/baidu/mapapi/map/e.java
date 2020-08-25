package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class e implements com.baidu.mapsdkplatform.comapi.map.l {
    final /* synthetic */ BaiduMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public Bundle a(int i, int i2, int i3) {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        Lock lock3;
        HeatMap heatMap2;
        lock = this.a.I;
        lock.lock();
        try {
            heatMap = this.a.H;
            if (heatMap != null) {
                heatMap2 = this.a.H;
                Tile a = heatMap2.a(i, i2, i3);
                Log.e("SPTest", "mapLayerDataReq t == null = " + (a == null));
                if (a != null) {
                    return a.toBundle();
                }
            }
            lock3 = this.a.I;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.a.I;
            lock2.unlock();
        }
    }
}
