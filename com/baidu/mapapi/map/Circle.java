package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class Circle extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    LatLng f1999a;
    int b;
    int c;
    Stroke d;
    boolean e;
    int f = 0;
    List<HoleOptions> g;
    HoleOptions h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.circle;
    }

    private void b(Bundle bundle) {
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(this.f == 1 ? "CircleDashTexture.png" : "lineDashTexture.png");
        if (fromAsset != null) {
            bundle.putBundle("image_info", fromAsset.b());
        }
    }

    private void c(List<HoleOptions> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        boolean b = Overlay.b(list, bundle2);
        bundle.putInt("has_holes", b ? 1 : 0);
        if (b) {
            bundle.putBundle("holes", bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f1999a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        if (this.e) {
            bundle.putDouble("dotted_stroke_location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", ll2mc.getLatitudeE6());
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f1999a, this.c));
        Overlay.a(this.b, bundle);
        if (this.d == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.d.a(new Bundle()));
        }
        if (this.g != null && this.g.size() != 0) {
            c(this.g, bundle);
        } else if (this.h != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.h);
            c((List<HoleOptions>) arrayList, bundle);
        } else {
            bundle.putInt("has_holes", 0);
        }
        return bundle;
    }

    public LatLng getCenter() {
        return this.f1999a;
    }

    public int getDottedStrokeType() {
        return this.f;
    }

    public int getFillColor() {
        return this.b;
    }

    public HoleOptions getHoleOption() {
        return this.h;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.g;
    }

    public int getRadius() {
        return this.c;
    }

    public Stroke getStroke() {
        return this.d;
    }

    public boolean isDottedStroke() {
        return this.e;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
        }
        this.f1999a = latLng;
        this.listener.b(this);
    }

    public void setDottedStroke(boolean z) {
        this.e = z;
        this.listener.b(this);
    }

    public void setDottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        this.f = circleDottedStrokeType.ordinal();
        this.listener.b(this);
    }

    public void setFillColor(int i) {
        this.b = i;
        this.listener.b(this);
    }

    public void setHoleOption(HoleOptions holeOptions) {
        this.h = holeOptions;
        this.g = null;
        this.listener.b(this);
    }

    public void setHoleOptions(List<HoleOptions> list) {
        this.g = list;
        this.h = null;
        this.listener.b(this);
    }

    public void setRadius(int i) {
        this.c = i;
        this.listener.b(this);
    }

    public void setStroke(Stroke stroke) {
        this.d = stroke;
        this.listener.b(this);
    }
}
