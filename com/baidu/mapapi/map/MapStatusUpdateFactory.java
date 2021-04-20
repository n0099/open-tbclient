package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class MapStatusUpdateFactory {
    public static MapStatusUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(2);
        mapStatusUpdate.f6949c = latLng;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(3);
        mapStatusUpdate.f6950d = latLngBounds;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2) {
        if (latLngBounds == null || i <= 0 || i2 <= 0) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(9);
        mapStatusUpdate.f6950d = latLngBounds;
        mapStatusUpdate.f6951e = i;
        mapStatusUpdate.f6952f = i2;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(10);
        mapStatusUpdate.f6950d = latLngBounds;
        mapStatusUpdate.l = i;
        mapStatusUpdate.m = i2;
        mapStatusUpdate.n = i3;
        mapStatusUpdate.o = i4;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngZoom(LatLng latLng, float f2) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(4);
        if (latLng == null) {
            return null;
        }
        mapStatusUpdate.f6949c = latLng;
        mapStatusUpdate.f6953g = f2;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newMapStatus(MapStatus mapStatus) {
        if (mapStatus == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(1);
        mapStatusUpdate.f6948b = mapStatus;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate scrollBy(int i, int i2) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(5);
        mapStatusUpdate.f6954h = i;
        mapStatusUpdate.i = i2;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomBy(float f2) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.j = f2;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomBy(float f2, Point point) {
        if (point == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(7);
        mapStatusUpdate.j = f2;
        mapStatusUpdate.k = point;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomIn() {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.j = 1.0f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomOut() {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.j = -1.0f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomTo(float f2) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(8);
        mapStatusUpdate.f6953g = f2;
        return mapStatusUpdate;
    }
}
