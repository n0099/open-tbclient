package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6827a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6829c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6830d;

    /* renamed from: e  reason: collision with root package name */
    public int f6831e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6832f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6828b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.A = this.f6828b;
        dot.z = this.f6827a;
        dot.B = this.f6829c;
        dot.f6825b = this.f6831e;
        dot.f6824a = this.f6830d;
        dot.f6826c = this.f6832f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6830d = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
    }

    public DotOptions color(int i2) {
        this.f6831e = i2;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.f6829c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.f6830d;
    }

    public int getColor() {
        return this.f6831e;
    }

    public Bundle getExtraInfo() {
        return this.f6829c;
    }

    public int getRadius() {
        return this.f6832f;
    }

    public int getZIndex() {
        return this.f6827a;
    }

    public boolean isVisible() {
        return this.f6828b;
    }

    public DotOptions radius(int i2) {
        if (i2 > 0) {
            this.f6832f = i2;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.f6828b = z;
        return this;
    }

    public DotOptions zIndex(int i2) {
        this.f6827a = i2;
        return this;
    }
}
