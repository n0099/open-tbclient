package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6968a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6970c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f6971d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f6973f;

    /* renamed from: e  reason: collision with root package name */
    public int f6972e = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6969b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polygon polygon = new Polygon();
        polygon.x = this.f6969b;
        polygon.w = this.f6968a;
        polygon.y = this.f6970c;
        List<LatLng> list = this.f6973f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polygon.f6967c = this.f6973f;
        polygon.f6966b = this.f6972e;
        polygon.f6965a = this.f6971d;
        return polygon;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.f6970c = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f6972e = i;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.f6970c;
    }

    public int getFillColor() {
        return this.f6972e;
    }

    public List<LatLng> getPoints() {
        return this.f6973f;
    }

    public Stroke getStroke() {
        return this.f6971d;
    }

    public int getZIndex() {
        return this.f6968a;
    }

    public boolean isVisible() {
        return this.f6969b;
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
                this.f6973f = list;
                return this;
            }
            throw new IllegalArgumentException("points count can not less than three");
        }
        throw new IllegalArgumentException("points list can not be null");
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.f6971d = stroke;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f6969b = z;
        return this;
    }

    public PolygonOptions zIndex(int i) {
        this.f6968a = i;
        return this;
    }
}
