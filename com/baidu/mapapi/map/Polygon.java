package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class Polygon extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    Stroke f2032a;
    int b;
    List<LatLng> c;
    List<HoleOptions> d;
    HoleOptions e;
    boolean f;
    int g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Polygon() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.polygon;
    }

    private void b(Bundle bundle) {
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(this.g == 1 ? "CircleDashTexture.png" : "lineDashTexture.png");
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
        GeoPoint ll2mc = CoordUtil.ll2mc(this.c.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        Overlay.a(this.c, bundle);
        Overlay.a(this.b, bundle);
        if (this.f2032a == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f2032a.a(new Bundle()));
        }
        if (this.d != null && this.d.size() != 0) {
            c(this.d, bundle);
        } else if (this.e != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.e);
            c((List<HoleOptions>) arrayList, bundle);
        } else {
            bundle.putInt("has_holes", 0);
        }
        if (this.f) {
            bundle.putDouble("dotted_stroke_location_x", ll2mc.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", ll2mc.getLatitudeE6());
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        return bundle;
    }

    public int getFillColor() {
        return this.b;
    }

    public HoleOptions getHoleOption() {
        return this.e;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.d;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public Stroke getStroke() {
        return this.f2032a;
    }

    public void setFillColor(int i) {
        this.b = i;
        this.listener.b(this);
    }

    public void setHoleOption(HoleOptions holeOptions) {
        this.e = holeOptions;
        this.d = null;
        this.listener.b(this);
    }

    public void setHoleOptions(List<HoleOptions> list) {
        this.d = list;
        this.e = null;
        this.listener.b(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() <= 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.c = list;
                this.listener.b(this);
                return;
            }
            int i3 = i2 + 1;
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    if (list.get(i2) == list.get(i4)) {
                        throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void setStroke(Stroke stroke) {
        this.f2032a = stroke;
        this.listener.b(this);
    }
}
