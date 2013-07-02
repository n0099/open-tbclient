package com.baidu.mapapi;

import android.graphics.Point;
/* loaded from: classes.dex */
public interface Projection {
    GeoPoint fromPixels(int i, int i2);

    float metersToEquatorPixels(float f);

    Point toPixels(GeoPoint geoPoint, Point point);
}
