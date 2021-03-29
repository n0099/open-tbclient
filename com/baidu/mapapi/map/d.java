package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mapsdkplatform.comapi.map.ai;
import java.util.concurrent.locks.Lock;
/* loaded from: classes2.dex */
public class d implements ai {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduMap f7066a;

    public d(BaiduMap baiduMap) {
        this.f7066a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.ai
    public Bundle a(int i, int i2, int i3, Context context) {
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        lock = this.f7066a.G;
        lock.lock();
        try {
            tileOverlay = this.f7066a.D;
            if (tileOverlay != null) {
                tileOverlay2 = this.f7066a.D;
                Tile a2 = tileOverlay2.a(i, i2, i3);
                if (a2 != null) {
                    return a2.toBundle();
                }
            }
            lock3 = this.f7066a.G;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.f7066a.G;
            lock2.unlock();
        }
    }
}
