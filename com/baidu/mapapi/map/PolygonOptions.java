package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.core.view.ViewCompat;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes6.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    int f2754a;
    Bundle c;
    private Stroke d;
    private List<LatLng> f;
    private int e = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: b  reason: collision with root package name */
    boolean f2755b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polygon polygon = new Polygon();
        polygon.x = this.f2755b;
        polygon.w = this.f2754a;
        polygon.y = this.c;
        if (this.f == null || this.f.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polygon.c = this.f;
        polygon.f2753b = this.e;
        polygon.f2752a = this.d;
        return polygon;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.e = i;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getFillColor() {
        return this.e;
    }

    public List<LatLng> getPoints() {
        return this.f;
    }

    public Stroke getStroke() {
        return this.d;
    }

    public int getZIndex() {
        return this.f2754a;
    }

    public boolean isVisible() {
        return this.f2755b;
    }

    public PolygonOptions points(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null");
        }
        if (list.size() <= 2) {
            throw new IllegalArgumentException("points count can not less than three");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("points list can not contains null");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.f = list;
                return this;
            }
            int i3 = i2 + 1;
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    if (list.get(i2) == list.get(i4)) {
                        throw new IllegalArgumentException("points list can not has same points");
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.d = stroke;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f2755b = z;
        return this;
    }

    public PolygonOptions zIndex(int i) {
        this.f2754a = i;
        return this;
    }
}
