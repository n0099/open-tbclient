package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7004a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7006c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f7007d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f7009f;

    /* renamed from: e  reason: collision with root package name */
    public int f7008e = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7005b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polygon polygon = new Polygon();
        polygon.x = this.f7005b;
        polygon.w = this.f7004a;
        polygon.y = this.f7006c;
        List<LatLng> list = this.f7009f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("when you add polyline, you must at least supply 2 points");
        }
        polygon.f7003c = this.f7009f;
        polygon.f7002b = this.f7008e;
        polygon.f7001a = this.f7007d;
        return polygon;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.f7006c = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f7008e = i;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.f7006c;
    }

    public int getFillColor() {
        return this.f7008e;
    }

    public List<LatLng> getPoints() {
        return this.f7009f;
    }

    public Stroke getStroke() {
        return this.f7007d;
    }

    public int getZIndex() {
        return this.f7004a;
    }

    public boolean isVisible() {
        return this.f7005b;
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
                this.f7009f = list;
                return this;
            }
            throw new IllegalArgumentException("points count can not less than three");
        }
        throw new IllegalArgumentException("points list can not be null");
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.f7007d = stroke;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f7005b = z;
        return this;
    }

    public PolygonOptions zIndex(int i) {
        this.f7004a = i;
        return this;
    }
}
