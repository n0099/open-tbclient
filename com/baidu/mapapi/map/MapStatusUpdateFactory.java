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
        mapStatusUpdate.f6950b = latLng;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(3);
        mapStatusUpdate.f6951c = latLngBounds;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2, int i3) {
        if (latLngBounds == null || i2 <= 0 || i3 <= 0) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(9);
        mapStatusUpdate.f6951c = latLngBounds;
        mapStatusUpdate.f6952d = i2;
        mapStatusUpdate.f6953e = i3;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(10);
        mapStatusUpdate.f6951c = latLngBounds;
        mapStatusUpdate.k = i2;
        mapStatusUpdate.l = i3;
        mapStatusUpdate.m = i4;
        mapStatusUpdate.n = i5;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngZoom(LatLng latLng, float f2) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(4);
        if (latLng == null) {
            return null;
        }
        mapStatusUpdate.f6950b = latLng;
        mapStatusUpdate.f6954f = f2;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngZoom(LatLngBounds latLngBounds, int i2, int i3, int i4, int i5) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(11);
        mapStatusUpdate.f6951c = latLngBounds;
        mapStatusUpdate.k = i2;
        mapStatusUpdate.l = i3;
        mapStatusUpdate.m = i4;
        mapStatusUpdate.n = i5;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newMapStatus(MapStatus mapStatus) {
        if (mapStatus == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(1);
        mapStatusUpdate.f6949a = mapStatus;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate scrollBy(int i2, int i3) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(5);
        mapStatusUpdate.f6955g = i2;
        mapStatusUpdate.f6956h = i3;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomBy(float f2) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f6957i = f2;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomBy(float f2, Point point) {
        if (point == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(7);
        mapStatusUpdate.f6957i = f2;
        mapStatusUpdate.j = point;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomIn() {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f6957i = 1.0f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomOut() {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f6957i = -1.0f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomTo(float f2) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(8);
        mapStatusUpdate.f6954f = f2;
        return mapStatusUpdate;
    }
}
