package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class Circle extends Overlay {
    public LatLng a;
    public int b;
    public int c;
    public Stroke d;
    public boolean e;
    public int f = 0;
    public List<HoleOptions> g;
    public HoleOptions h;

    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.h;
    }

    public LatLng getCenter() {
        return this.a;
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

    private void b(Bundle bundle) {
        String str;
        if (this.f == 1) {
            str = "CircleDashTexture.png";
        } else {
            str = "lineDashTexture.png";
        }
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
        if (fromAsset != null) {
            bundle.putBundle("image_info", fromAsset.b());
        }
    }

    public void setCenter(LatLng latLng) {
        if (latLng != null) {
            this.a = latLng;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
    }

    public void setDottedStroke(boolean z) {
        this.e = z;
        this.listener.c(this);
    }

    public void setDottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        this.f = circleDottedStrokeType.ordinal();
        this.listener.c(this);
    }

    public void setFillColor(int i) {
        this.b = i;
        this.listener.c(this);
    }

    public void setHoleOption(HoleOptions holeOptions) {
        this.h = holeOptions;
        this.g = null;
        this.listener.c(this);
    }

    public void setHoleOptions(List<HoleOptions> list) {
        this.g = list;
        this.h = null;
        this.listener.c(this);
    }

    public void setRadius(int i) {
        this.c = i;
        this.listener.c(this);
    }

    public void setStroke(Stroke stroke) {
        this.d = stroke;
        this.listener.c(this);
    }

    private void c(List<HoleOptions> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        boolean b = Overlay.b(list, bundle2);
        bundle.putInt("has_holes", b ? 1 : 0);
        if (b) {
            bundle.putBundle("holes", bundle2);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.a);
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
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.a, this.c));
        Overlay.a(this.b, bundle);
        if (this.d == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.d.a(new Bundle()));
        }
        List<HoleOptions> list = this.g;
        if (list != null && list.size() != 0) {
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
}
