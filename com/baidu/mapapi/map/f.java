package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import java.util.concurrent.locks.Lock;
/* loaded from: classes2.dex */
public class f implements com.baidu.mapsdkplatform.comapi.map.m {
    public final /* synthetic */ BaiduMap a;

    public f(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.m
    public Bundle a(int i, int i2) {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        BaiduMap.OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack;
        HeatMap heatMap2;
        BaiduMap.OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack2;
        lock = this.a.L;
        lock.lock();
        try {
            heatMap = this.a.K;
            if (heatMap == null) {
                return null;
            }
            onHeatMapDrawFrameCallBack = this.a.H;
            if (onHeatMapDrawFrameCallBack != null) {
                onHeatMapDrawFrameCallBack2 = this.a.H;
                onHeatMapDrawFrameCallBack2.frameIndex(i);
            }
            heatMap2 = this.a.K;
            HeatMapData data = heatMap2.getData(i, i2);
            if (data == null) {
                return null;
            }
            return data.toBundle();
        } finally {
            lock2 = this.a.L;
            lock2.unlock();
        }
    }
}
