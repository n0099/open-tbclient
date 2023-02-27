package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class Polygon extends Overlay {
    public Stroke a;
    public int b;
    public List<LatLng> c;
    public List<HoleOptions> d;
    public HoleOptions e;
    public boolean f;
    public String g;
    public EncodePointType h;
    public int i = 0;

    public Polygon() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.j;
    }

    public String getEncodedPoint() {
        return this.g;
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

    public EncodePointType getPointType() {
        return this.h;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public Stroke getStroke() {
        return this.a;
    }

    private void b(Bundle bundle) {
        String str;
        if (this.i == 1) {
            str = "CircleDashTexture.png";
        } else {
            str = "lineDashTexture.png";
        }
        BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset(str);
        if (fromAsset != null) {
            bundle.putBundle("image_info", fromAsset.b());
        }
    }

    public void setFillColor(int i) {
        this.b = i;
        this.listener.c(this);
    }

    public void setHoleOption(HoleOptions holeOptions) {
        this.e = holeOptions;
        this.d = null;
        this.listener.c(this);
    }

    public void setHoleOptions(List<HoleOptions> list) {
        this.d = list;
        this.e = null;
        this.listener.c(this);
    }

    public void setStroke(Stroke stroke) {
        this.a = stroke;
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

    public void setEncodeInfo(String str, EncodePointType encodePointType) {
        this.g = str;
        this.h = encodePointType;
        this.listener.c(this);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.f) {
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        String str = this.g;
        if (str != null && str.length() > 0 && this.h != null) {
            bundle.putString("encodedPoints", this.g);
            bundle.putInt("encodePointType", this.h.ordinal());
        } else {
            List<LatLng> list = this.c;
            if (list != null) {
                GeoPoint ll2mc = CoordUtil.ll2mc(list.get(0));
                bundle.putDouble("location_x", ll2mc.getLongitudeE6());
                bundle.putDouble("location_y", ll2mc.getLatitudeE6());
                Overlay.a(this.c, bundle);
                if (this.f) {
                    bundle.putDouble("dotted_stroke_location_x", ll2mc.getLongitudeE6());
                    bundle.putDouble("dotted_stroke_location_y", ll2mc.getLatitudeE6());
                }
            }
        }
        Overlay.a(this.b, bundle);
        if (this.a == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.a.a(new Bundle()));
        }
        List<HoleOptions> list2 = this.d;
        if (list2 != null && list2.size() != 0) {
            c(this.d, bundle);
        } else if (this.e != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.e);
            c((List<HoleOptions>) arrayList, bundle);
        } else {
            bundle.putInt("has_holes", 0);
        }
        return bundle;
    }

    public void setPoints(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 2) {
                if (!list.contains(null)) {
                    int i = 0;
                    while (i < list.size()) {
                        int i2 = i + 1;
                        for (int i3 = i2; i3 < list.size(); i3++) {
                            if (list.get(i) == list.get(i3)) {
                                throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                            }
                        }
                        i = i2;
                    }
                    this.c = list;
                    this.listener.c(this);
                    return;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }
}
