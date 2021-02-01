package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.mapapi.map.BaiduMap;
/* loaded from: classes4.dex */
public class HistoryTraceManager {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.synchronization.b.b f2953a = new com.baidu.mapsdkplatform.comapi.synchronization.b.b();

    public void queryHistoryTraceData(HistoryTraceQueryOptions historyTraceQueryOptions) {
        if (this.f2953a != null) {
            this.f2953a.a(historyTraceQueryOptions);
        }
    }

    public void release() {
        if (this.f2953a != null) {
            this.f2953a.a();
        }
    }

    public void renderHistoryTrace(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        if (this.f2953a != null) {
            this.f2953a.a(baiduMap, historyTraceData, historyTraceDisplayOptions, i);
        }
    }

    public void setOnHistoryTraceListener(OnHistoryTraceListener onHistoryTraceListener) {
        if (onHistoryTraceListener == null) {
            throw new IllegalArgumentException("HistoryTraceManager-- OnHistoryTraceListener must not be null.");
        }
        if (this.f2953a != null) {
            this.f2953a.a(onHistoryTraceListener);
        }
    }
}
