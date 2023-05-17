package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public class RecommendStopSearchOption {
    public LatLng mLocation;

    public LatLng getLocation() {
        return this.mLocation;
    }

    public RecommendStopSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }
}
