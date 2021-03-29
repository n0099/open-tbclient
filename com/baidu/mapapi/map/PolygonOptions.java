package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6969a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6971c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f6972d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f6974f;

    /* renamed from: e  reason: collision with root package name */
    public int f6973e = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6970b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polygon polygon = new Polygon();
        polygon.x = this.f6970b;
        polygon.w = this.f6969a;
        polygon.y = this.f6971c;
        List<LatLng> list = this.f6974f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polygon.f6968c = this.f6974f;
        polygon.f6967b = this.f6973e;
        polygon.f6966a = this.f6972d;
        return polygon;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.f6971c = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f6973e = i;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.f6971c;
    }

    public int getFillColor() {
        return this.f6973e;
    }

    public List<LatLng> getPoints() {
        return this.f6974f;
    }

    public Stroke getStroke() {
        return this.f6972d;
    }

    public int getZIndex() {
        return this.f6969a;
    }

    public boolean isVisible() {
        return this.f6970b;
    }

    public PolygonOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 2) {
                if (list.contains(null)) {
                    throw new IllegalArgumentException("points list can not contains null");
                }
                int i = 0;
                while (i < list.size()) {
                    int i2 = i + 1;
                    for (int i3 = i2; i3 < list.size(); i3++) {
                        if (list.get(i) == list.get(i3)) {
                            throw new IllegalArgumentException("points list can not has same points");
                        }
                    }
                    i = i2;
                }
                this.f6974f = list;
                return this;
            }
            throw new IllegalArgumentException("points count can not less than three");
        }
        throw new IllegalArgumentException("points list can not be null");
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.f6972d = stroke;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f6970b = z;
        return this;
    }

    public PolygonOptions zIndex(int i) {
        this.f6969a = i;
        return this;
    }
}
