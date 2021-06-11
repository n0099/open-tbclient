package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mapsdkplatform.comapi.map.ai;
import java.util.concurrent.locks.Lock;
/* loaded from: classes2.dex */
public class e implements ai {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduMap f7118a;

    public e(BaiduMap baiduMap) {
        this.f7118a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.ai
    public Bundle a(int i2, int i3, int i4, Context context) {
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        lock = this.f7118a.J;
        lock.lock();
        try {
            tileOverlay = this.f7118a.G;
            if (tileOverlay != null) {
                tileOverlay2 = this.f7118a.G;
                Tile a2 = tileOverlay2.a(i2, i3, i4);
                if (a2 != null) {
                    return a2.toBundle();
                }
            }
            lock3 = this.f7118a.J;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.f7118a.J;
            lock2.unlock();
        }
    }
}
