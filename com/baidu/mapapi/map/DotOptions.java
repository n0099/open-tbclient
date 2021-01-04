package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes15.dex */
public final class DotOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    int f2810a;
    Bundle c;
    private LatLng d;
    private int e = ViewCompat.MEASURED_STATE_MASK;
    private int f = 5;

    /* renamed from: b  reason: collision with root package name */
    boolean f2811b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Dot dot = new Dot();
        dot.B = this.f2811b;
        dot.A = this.f2810a;
        dot.C = this.c;
        dot.f2809b = this.e;
        dot.f2808a = this.d;
        dot.c = this.f;
        return dot;
    }

    public DotOptions center(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
        }
        this.d = latLng;
        return this;
    }

    public DotOptions color(int i) {
        this.e = i;
        return this;
    }

    public DotOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public LatLng getCenter() {
        return this.d;
    }

    public int getColor() {
        return this.e;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getRadius() {
        return this.f;
    }

    public int getZIndex() {
        return this.f2810a;
    }

    public boolean isVisible() {
        return this.f2811b;
    }

    public DotOptions radius(int i) {
        if (i > 0) {
            this.f = i;
        }
        return this;
    }

    public DotOptions visible(boolean z) {
        this.f2811b = z;
        return this;
    }

    public DotOptions zIndex(int i) {
        this.f2810a = i;
        return this;
    }
}
