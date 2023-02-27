package com.baidu.mapapi.map.track;

import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.a.b;
import java.util.List;
/* loaded from: classes2.dex */
public class TraceOverlay {
    public List<LatLng> c;
    public boolean f;
    public int g;
    public boolean h;
    public b mListener;
    public int a = -265058817;
    public int b = 14;
    public int d = 300;
    public int e = 0;

    public void clear() {
        this.mListener.c(this);
    }

    public int getAnimationDuration() {
        return this.e;
    }

    public int getAnimationTime() {
        return this.d;
    }

    public int getAnimationType() {
        return this.g;
    }

    public int getColor() {
        return this.a;
    }

    public LatLngBounds getLatLngBounds() {
        List<LatLng> list = this.c;
        if (list != null && list.size() != 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(this.c);
            return builder.build();
        }
        return null;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public boolean isAnimate() {
        return this.f;
    }

    public boolean isTrackMove() {
        return this.h;
    }

    public void remove() {
        this.mListener.a(this);
    }

    public void update() {
        this.mListener.b(this);
    }

    public void setAnimate(boolean z) {
        this.f = z;
    }

    public void setAnimationDuration(int i) {
        this.e = i;
    }

    public void setAnimationTime(int i) {
        if (i >= 300) {
            this.d = i;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
    }

    public void setColor(int i) {
        this.a = i;
    }

    public void setTraceAnimationType(TraceOptions.TraceAnimateType traceAnimateType) {
        if (traceAnimateType == null) {
            traceAnimateType = TraceOptions.TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
        }
        this.g = traceAnimateType.ordinal();
    }

    public void setTracePoints(List<LatLng> list) {
        this.c = list;
    }

    public void setTrackMove(boolean z) {
        this.h = z;
    }

    public void setWidth(int i) {
        this.b = i;
    }
}
