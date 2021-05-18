package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6927a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6929c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6930d;

    /* renamed from: e  reason: collision with root package name */
    public int f6931e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6932f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6928b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.A = this.f6928b;
        dot.z = this.f6927a;
        dot.B = this.f6929c;
        dot.f6925b = this.f6931e;
        dot.f6924a = this.f6930d;
        dot.f6926c = this.f6932f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6930d = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
    }

    public DotOptions color(int i2) {
        this.f6931e = i2;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.f6929c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.f6930d;
    }

    public int getColor() {
        return this.f6931e;
    }

    public Bundle getExtraInfo() {
        return this.f6929c;
    }

    public int getRadius() {
        return this.f6932f;
    }

    public int getZIndex() {
        return this.f6927a;
    }

    public boolean isVisible() {
        return this.f6928b;
    }

    public DotOptions radius(int i2) {
        if (i2 > 0) {
            this.f6932f = i2;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.f6928b = z;
        return this;
    }

    public DotOptions zIndex(int i2) {
        this.f6927a = i2;
        return this;
    }
}
