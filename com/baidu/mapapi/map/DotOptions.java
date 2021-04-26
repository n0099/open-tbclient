package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7115a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7117c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f7118d;

    /* renamed from: e  reason: collision with root package name */
    public int f7119e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f7120f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7116b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.x = this.f7116b;
        dot.w = this.f7115a;
        dot.y = this.f7117c;
        dot.f7113b = this.f7119e;
        dot.f7112a = this.f7118d;
        dot.f7114c = this.f7120f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f7118d = latLng;
            return this;
        }
        throw new IllegalArgumentException("dot center can not be null");
    }

    public DotOptions color(int i2) {
        this.f7119e = i2;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.f7117c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.f7118d;
    }

    public int getColor() {
        return this.f7119e;
    }

    public Bundle getExtraInfo() {
        return this.f7117c;
    }

    public int getRadius() {
        return this.f7120f;
    }

    public int getZIndex() {
        return this.f7115a;
    }

    public boolean isVisible() {
        return this.f7116b;
    }

    public DotOptions radius(int i2) {
        if (i2 > 0) {
            this.f7120f = i2;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.f7116b = z;
        return this;
    }

    public DotOptions zIndex(int i2) {
        this.f7115a = i2;
        return this;
    }
}
