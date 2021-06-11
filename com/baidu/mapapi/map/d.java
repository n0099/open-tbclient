package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.concurrent.locks.Lock;
/* loaded from: classes2.dex */
public class d implements com.baidu.mapsdkplatform.comapi.map.o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduMap f7117a;

    public d(BaiduMap baiduMap) {
        this.f7117a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.o
    public Bundle a(int i2, int i3, int i4) {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        Lock lock3;
        HeatMap heatMap2;
        lock = this.f7117a.I;
        lock.lock();
        try {
            heatMap = this.f7117a.H;
            if (heatMap != null) {
                heatMap2 = this.f7117a.H;
                Tile a2 = heatMap2.a(i2, i3, i4);
                if (a2 != null) {
                    return a2.toBundle();
                }
            }
            lock3 = this.f7117a.I;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.f7117a.I;
            lock2.unlock();
        }
    }
}
