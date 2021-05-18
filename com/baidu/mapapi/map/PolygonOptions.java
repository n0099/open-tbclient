package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7067a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7069c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f7070d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f7072f;

    /* renamed from: e  reason: collision with root package name */
    public int f7071e = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7068b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polygon polygon = new Polygon();
        polygon.A = this.f7068b;
        polygon.z = this.f7067a;
        polygon.B = this.f7069c;
        List<LatLng> list = this.f7072f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        polygon.f7066c = this.f7072f;
        polygon.f7065b = this.f7071e;
        polygon.f7064a = this.f7070d;
        return polygon;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.f7069c = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i2) {
        this.f7071e = i2;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.f7069c;
    }

    public int getFillColor() {
        return this.f7071e;
    }

    public List<LatLng> getPoints() {
        return this.f7072f;
    }

    public Stroke getStroke() {
        return this.f7070d;
    }

    public int getZIndex() {
        return this.f7067a;
    }

    public boolean isVisible() {
        return this.f7068b;
    }

    public PolygonOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 2) {
                if (list.contains(null)) {
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                int i2 = 0;
                while (i2 < list.size()) {
                    int i3 = i2 + 1;
                    for (int i4 = i3; i4 < list.size(); i4++) {
                        if (list.get(i2) == list.get(i4)) {
                            throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                        }
                    }
                    i2 = i3;
                }
                this.f7072f = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.f7070d = stroke;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f7068b = z;
        return this;
    }

    public PolygonOptions zIndex(int i2) {
        this.f7067a = i2;
        return this;
    }
}
