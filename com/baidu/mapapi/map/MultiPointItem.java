package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class MultiPointItem {
    public LatLng a;
    public String b;

    public MultiPointItem(LatLng latLng) {
        if (latLng != null) {
            this.a = latLng;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: MultiPointItem point can not be null");
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public LatLng getPoint() {
        return this.a;
    }

    public String getTitle() {
        return this.b;
    }
}
