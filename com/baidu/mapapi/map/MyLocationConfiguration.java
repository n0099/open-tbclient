package com.baidu.mapapi.map;

import android.graphics.Color;
/* loaded from: classes2.dex */
public class MyLocationConfiguration {
    public int accuracyCircleFillColor;
    public int accuracyCircleStrokeColor;
    public final BitmapDescriptor customMarker;
    public final boolean enableDirection;
    public final LocationMode locationMode;

    /* loaded from: classes2.dex */
    public enum LocationMode {
        NORMAL,
        FOLLOWING,
        COMPASS
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor) {
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.enableDirection = z;
        this.customMarker = bitmapDescriptor;
        this.accuracyCircleFillColor = a(this.accuracyCircleFillColor);
        this.accuracyCircleStrokeColor = a(this.accuracyCircleStrokeColor);
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor, int i2, int i3) {
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.enableDirection = z;
        this.customMarker = bitmapDescriptor;
        this.accuracyCircleFillColor = a(i2);
        this.accuracyCircleStrokeColor = a(i3);
    }

    private int a(int i2) {
        int i3 = (65280 & i2) >> 8;
        return Color.argb(((-16777216) & i2) >> 24, i2 & 255, i3, (16711680 & i2) >> 16);
    }
}
