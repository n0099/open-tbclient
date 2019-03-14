package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes5.dex */
public class HistoryTraceManager {
    private com.baidu.mapsdkplatform.comapi.synchronization.b.b a = new com.baidu.mapsdkplatform.comapi.synchronization.b.b();

    public void queryHistoryTraceData(HistoryTraceQueryOptions historyTraceQueryOptions) {
        if (this.a != null) {
            this.a.a(historyTraceQueryOptions);
        }
    }

    public void release() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void renderHistoryTrace(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        if (this.a != null) {
            this.a.a(baiduMap, historyTraceData, historyTraceDisplayOptions, i);
        }
    }

    public void setOnHistoryTraceListener(OnHistoryTraceListener onHistoryTraceListener) {
        if (onHistoryTraceListener == null) {
            throw new IllegalArgumentException("HistoryTraceManager-- OnHistoryTraceListener must not be null.");
        }
        if (this.a != null) {
            this.a.a(onHistoryTraceListener);
        }
    }
}
