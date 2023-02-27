package com.baidu.mapapi.map.track;

import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public class TraceOptions {
    public List<LatLng> c;
    public int f;
    public int a = -15794282;
    public int b = 14;
    public int d = 300;
    public boolean e = false;
    public int g = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear.ordinal();
    public boolean h = false;

    /* loaded from: classes2.dex */
    public enum TraceAnimateType {
        TraceOverlayAnimationEasingCurveLinear,
        TraceOverlayAnimationEasingCurveEaseIn,
        TraceOverlayAnimationEasingCurveEaseOut,
        TraceOverlayAnimationEasingCurveEaseInOut
    }

    public TraceAnimateType getAnimateType() {
        int i = this.g;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
                }
                return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseInOut;
            }
            return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseOut;
        }
        return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseIn;
    }

    public int getAnimationDuration() {
        return this.f;
    }

    public int getAnimationTime() {
        return this.d;
    }

    public int getColor() {
        return this.a;
    }

    public TraceOverlay getOverlay() {
        TraceOverlay traceOverlay = new TraceOverlay();
        traceOverlay.a = this.a;
        traceOverlay.b = this.b;
        traceOverlay.c = this.c;
        traceOverlay.d = this.d;
        traceOverlay.f = this.e;
        traceOverlay.e = this.f;
        traceOverlay.g = this.g;
        traceOverlay.h = this.h;
        return traceOverlay;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public boolean isAnimation() {
        return this.e;
    }

    public boolean isTrackMove() {
        return this.h;
    }

    public TraceOptions animate(boolean z) {
        this.e = z;
        return this;
    }

    public TraceOptions animationDuration(int i) {
        this.f = i;
        return this;
    }

    public TraceOptions animationTime(int i) {
        if (i >= 300) {
            this.d = i;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
    }

    public TraceOptions animationType(TraceAnimateType traceAnimateType) {
        if (traceAnimateType == null) {
            traceAnimateType = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
        }
        this.g = traceAnimateType.ordinal();
        return this;
    }

    public TraceOptions color(int i) {
        this.a = i;
        return this;
    }

    public TraceOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() >= 2) {
                if (!list.contains(null)) {
                    this.c = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public TraceOptions setTrackMove(boolean z) {
        this.h = z;
        return this;
    }

    public TraceOptions width(int i) {
        this.b = i;
        return this;
    }
}
