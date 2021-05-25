package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes2.dex */
public final class PolygonOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6967a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6969c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f6970d;

    /* renamed from: f  reason: collision with root package name */
    public List<LatLng> f6972f;

    /* renamed from: e  reason: collision with root package name */
    public int f6971e = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6968b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Polygon polygon = new Polygon();
        polygon.A = this.f6968b;
        polygon.z = this.f6967a;
        polygon.B = this.f6969c;
        List<LatLng> list = this.f6972f;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        polygon.f6966c = this.f6972f;
        polygon.f6965b = this.f6971e;
        polygon.f6964a = this.f6970d;
        return polygon;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.f6969c = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i2) {
        this.f6971e = i2;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.f6969c;
    }

    public int getFillColor() {
        return this.f6971e;
    }

    public List<LatLng> getPoints() {
        return this.f6972f;
    }

    public Stroke getStroke() {
        return this.f6970d;
    }

    public int getZIndex() {
        return this.f6967a;
    }

    public boolean isVisible() {
        return this.f6968b;
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
                this.f6972f = list;
                return this;
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.f6970d = stroke;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f6968b = z;
        return this;
    }

    public PolygonOptions zIndex(int i2) {
        this.f6967a = i2;
        return this;
    }
}
