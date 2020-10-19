package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements com.baidu.mapsdkplatform.comapi.map.l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaiduMap baiduMap) {
        this.f2068a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public Bundle a(int i, int i2, int i3) {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        Lock lock3;
        HeatMap heatMap2;
        lock = this.f2068a.I;
        lock.lock();
        try {
            heatMap = this.f2068a.H;
            if (heatMap != null) {
                heatMap2 = this.f2068a.H;
                Tile a2 = heatMap2.a(i, i2, i3);
                Log.e("SPTest", "mapLayerDataReq t == null = " + (a2 == null));
                if (a2 != null) {
                    return a2.toBundle();
                }
            }
            lock3 = this.f2068a.I;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.f2068a.I;
            lock2.unlock();
        }
    }
}
