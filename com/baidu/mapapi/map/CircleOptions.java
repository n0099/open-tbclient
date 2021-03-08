package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public final class CircleOptions extends OverlayOptions {
    private static final String d = CircleOptions.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    int f2013a;
    Bundle c;
    private LatLng e;
    private int g;
    private Stroke h;
    private int f = ViewCompat.MEASURED_STATE_MASK;
    boolean b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Circle circle = new Circle();
        circle.x = this.b;
        circle.w = this.f2013a;
        circle.y = this.c;
        circle.b = this.f;
        circle.f2012a = this.e;
        circle.c = this.g;
        circle.d = this.h;
        return circle;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("circle center can not be null");
        }
        this.e = latLng;
        return this;
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.e;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getFillColor() {
        return this.f;
    }

    public int getRadius() {
        return this.g;
    }

    public Stroke getStroke() {
        return this.h;
    }

    public int getZIndex() {
        return this.f2013a;
    }

    public boolean isVisible() {
        return this.b;
    }

    public CircleOptions radius(int i) {
        this.g = i;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public CircleOptions zIndex(int i) {
        this.f2013a = i;
        return this;
    }
}
