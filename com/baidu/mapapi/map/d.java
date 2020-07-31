package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mapsdkplatform.comapi.map.ai;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d implements ai {
    final /* synthetic */ BaiduMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.ai
    public Bundle a(int i, int i2, int i3, Context context) {
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        lock = this.a.G;
        lock.lock();
        try {
            tileOverlay = this.a.D;
            if (tileOverlay != null) {
                tileOverlay2 = this.a.D;
                Tile a = tileOverlay2.a(i, i2, i3);
                if (a != null) {
                    return a.toBundle();
                }
            }
            lock3 = this.a.G;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.a.G;
            lock2.unlock();
        }
    }
}
