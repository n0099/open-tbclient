package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6870a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6872c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6873d;

    /* renamed from: e  reason: collision with root package name */
    public int f6874e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6875f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6871b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.A = this.f6871b;
        dot.z = this.f6870a;
        dot.B = this.f6872c;
        dot.f6868b = this.f6874e;
        dot.f6867a = this.f6873d;
        dot.f6869c = this.f6875f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6873d = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
    }

    public DotOptions color(int i2) {
        this.f6874e = i2;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.f6872c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.f6873d;
    }

    public int getColor() {
        return this.f6874e;
    }

    public Bundle getExtraInfo() {
        return this.f6872c;
    }

    public int getRadius() {
        return this.f6875f;
    }

    public int getZIndex() {
        return this.f6870a;
    }

    public boolean isVisible() {
        return this.f6871b;
    }

    public DotOptions radius(int i2) {
        if (i2 > 0) {
            this.f6875f = i2;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.f6871b = z;
        return this;
    }

    public DotOptions zIndex(int i2) {
        this.f6870a = i2;
        return this;
    }
}
