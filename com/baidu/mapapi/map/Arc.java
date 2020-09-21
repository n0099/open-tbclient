package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class Arc extends Overlay {
    private static final String f = Arc.class.getSimpleName();
    int a;
    int b;
    LatLng c;
    LatLng d;
    LatLng e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Arc() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.arc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.c);
        arrayList.add(this.d);
        arrayList.add(this.e);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.b);
        Overlay.a(arrayList, bundle);
        Overlay.a(this.a, bundle);
        return bundle;
    }

    public int getColor() {
        return this.a;
    }

    public LatLng getEndPoint() {
        return this.e;
    }

    public LatLng getMiddlePoint() {
        return this.d;
    }

    public LatLng getStartPoint() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public void setColor(int i) {
        this.a = i;
        this.listener.b(this);
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("BDMapSDKException:start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        this.c = latLng;
        this.d = latLng2;
        this.e = latLng3;
        this.listener.b(this);
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.b = i;
            this.listener.b(this);
        }
    }
}
