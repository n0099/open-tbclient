package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes2.dex */
public class HistoryTraceManager {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.synchronization.b.b f7381a = new com.baidu.mapsdkplatform.comapi.synchronization.b.b();

    public void queryHistoryTraceData(HistoryTraceQueryOptions historyTraceQueryOptions) {
        com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar = this.f7381a;
        if (bVar != null) {
            bVar.a(historyTraceQueryOptions);
        }
    }

    public void release() {
        com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar = this.f7381a;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void renderHistoryTrace(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar = this.f7381a;
        if (bVar != null) {
            bVar.a(baiduMap, historyTraceData, historyTraceDisplayOptions, i);
        }
    }

    public void setOnHistoryTraceListener(OnHistoryTraceListener onHistoryTraceListener) {
        if (onHistoryTraceListener == null) {
            throw new IllegalArgumentException("HistoryTraceManager-- OnHistoryTraceListener must not be null.");
        }
        com.baidu.mapsdkplatform.comapi.synchronization.b.b bVar = this.f7381a;
        if (bVar != null) {
            bVar.a(onHistoryTraceListener);
        }
    }
}
