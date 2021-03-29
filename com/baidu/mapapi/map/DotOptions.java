package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6841a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6843c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6844d;

    /* renamed from: e  reason: collision with root package name */
    public int f6845e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6846f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6842b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.x = this.f6842b;
        dot.w = this.f6841a;
        dot.y = this.f6843c;
        dot.f6839b = this.f6845e;
        dot.f6838a = this.f6844d;
        dot.f6840c = this.f6846f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6844d = latLng;
            return this;
        }
        throw new IllegalArgumentException("dot center can not be null");
    }

    public DotOptions color(int i) {
        this.f6845e = i;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.f6843c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.f6844d;
    }

    public int getColor() {
        return this.f6845e;
    }

    public Bundle getExtraInfo() {
        return this.f6843c;
    }

    public int getRadius() {
        return this.f6846f;
    }

    public int getZIndex() {
        return this.f6841a;
    }

    public boolean isVisible() {
        return this.f6842b;
    }

    public DotOptions radius(int i) {
        if (i > 0) {
            this.f6846f = i;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.f6842b = z;
        return this;
    }

    public DotOptions zIndex(int i) {
        this.f6841a = i;
        return this;
    }
}
