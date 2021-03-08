package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mapsdkplatform.comapi.map.ai;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements ai {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaiduMap baiduMap) {
        this.f2064a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.ai
    public Bundle a(int i, int i2, int i3, Context context) {
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        lock = this.f2064a.G;
        lock.lock();
        try {
            tileOverlay = this.f2064a.D;
            if (tileOverlay != null) {
                tileOverlay2 = this.f2064a.D;
                Tile a2 = tileOverlay2.a(i, i2, i3);
                if (a2 != null) {
                    return a2.toBundle();
                }
            }
            lock3 = this.f2064a.G;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.f2064a.G;
            lock2.unlock();
        }
    }
}
