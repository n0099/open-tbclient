package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.map.MapLayer;
/* loaded from: classes3.dex */
/* synthetic */ class e {
    static final /* synthetic */ int[] a = new int[MapLayer.values().length];

    static {
        try {
            a[MapLayer.MAP_LAYER_LOCATION.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[MapLayer.MAP_LAYER_OVERLAY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[MapLayer.MAP_LAYER_INDOOR_POI.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[MapLayer.MAP_LAYER_POI_MARKER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
