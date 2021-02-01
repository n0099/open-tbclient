package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements com.baidu.mapsdkplatform.comapi.map.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaiduMap baiduMap) {
        this.f2788a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.o
    public Bundle a(int i, int i2, int i3) {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        Lock lock3;
        HeatMap heatMap2;
        lock = this.f2788a.F;
        lock.lock();
        try {
            heatMap = this.f2788a.E;
            if (heatMap != null) {
                heatMap2 = this.f2788a.E;
                Tile a2 = heatMap2.a(i, i2, i3);
                if (a2 != null) {
                    return a2.toBundle();
                }
            }
            lock3 = this.f2788a.F;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.f2788a.F;
            lock2.unlock();
        }
    }
}
