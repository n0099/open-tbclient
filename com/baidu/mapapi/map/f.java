package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements com.baidu.mapsdkplatform.comapi.map.z {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2069a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaiduMap baiduMap) {
        this.f2069a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.z
    public Bundle a(int i, int i2, int i3, Context context) {
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        lock = this.f2069a.J;
        lock.lock();
        try {
            tileOverlay = this.f2069a.G;
            if (tileOverlay != null) {
                tileOverlay2 = this.f2069a.G;
                Tile a2 = tileOverlay2.a(i, i2, i3);
                Log.e("SDKTileLayer", "mapLayerDataReq tile t == null = " + (a2 == null));
                if (a2 != null) {
                    return a2.toBundle();
                }
            }
            lock3 = this.f2069a.J;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.f2069a.J;
            lock2.unlock();
        }
    }
}
