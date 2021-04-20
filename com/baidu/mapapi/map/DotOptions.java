package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6876a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6878c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6879d;

    /* renamed from: e  reason: collision with root package name */
    public int f6880e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6881f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6877b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.x = this.f6877b;
        dot.w = this.f6876a;
        dot.y = this.f6878c;
        dot.f6874b = this.f6880e;
        dot.f6873a = this.f6879d;
        dot.f6875c = this.f6881f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6879d = latLng;
            return this;
        }
        throw new IllegalArgumentException("dot center can not be null");
    }

    public DotOptions color(int i) {
        this.f6880e = i;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.f6878c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.f6879d;
    }

    public int getColor() {
        return this.f6880e;
    }

    public Bundle getExtraInfo() {
        return this.f6878c;
    }

    public int getRadius() {
        return this.f6881f;
    }

    public int getZIndex() {
        return this.f6876a;
    }

    public boolean isVisible() {
        return this.f6877b;
    }

    public DotOptions radius(int i) {
        if (i > 0) {
            this.f6881f = i;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.f6877b = z;
        return this;
    }

    public DotOptions zIndex(int i) {
        this.f6876a = i;
        return this;
    }
}
