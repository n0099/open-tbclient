package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6840a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6842c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6843d;

    /* renamed from: e  reason: collision with root package name */
    public int f6844e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6845f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6841b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.x = this.f6841b;
        dot.w = this.f6840a;
        dot.y = this.f6842c;
        dot.f6838b = this.f6844e;
        dot.f6837a = this.f6843d;
        dot.f6839c = this.f6845f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6843d = latLng;
            return this;
        }
        throw new IllegalArgumentException("dot center can not be null");
    }

    public DotOptions color(int i) {
        this.f6844e = i;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.f6842c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.f6843d;
    }

    public int getColor() {
        return this.f6844e;
    }

    public Bundle getExtraInfo() {
        return this.f6842c;
    }

    public int getRadius() {
        return this.f6845f;
    }

    public int getZIndex() {
        return this.f6840a;
    }

    public boolean isVisible() {
        return this.f6841b;
    }

    public DotOptions radius(int i) {
        if (i > 0) {
            this.f6845f = i;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.f6841b = z;
        return this;
    }

    public DotOptions zIndex(int i) {
        this.f6840a = i;
        return this;
    }
}
