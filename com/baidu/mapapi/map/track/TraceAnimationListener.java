package com.baidu.mapapi.map.track;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public interface TraceAnimationListener {
    void onTraceAnimationFinish();

    void onTraceAnimationUpdate(int i);

    void onTraceUpdatePosition(LatLng latLng);
}
