package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements com.baidu.mapsdkplatform.comapi.map.o {
    final /* synthetic */ BaiduMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.o
    public Bundle a(int i, int i2, int i3) {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        Lock lock3;
        HeatMap heatMap2;
        lock = this.a.F;
        lock.lock();
        try {
            heatMap = this.a.E;
            if (heatMap != null) {
                heatMap2 = this.a.E;
                Tile a = heatMap2.a(i, i2, i3);
                if (a != null) {
                    return a.toBundle();
                }
            }
            lock3 = this.a.F;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.a.F;
            lock2.unlock();
        }
    }
}
