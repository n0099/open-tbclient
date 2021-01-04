package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.map.MapLayer;
/* loaded from: classes15.dex */
/* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f3174a = new int[MapLayer.values().length];

    static {
        try {
            f3174a[MapLayer.MAP_LAYER_LOCATION.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3174a[MapLayer.MAP_LAYER_OVERLAY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3174a[MapLayer.MAP_LAYER_INDOOR_POI.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3174a[MapLayer.MAP_LAYER_POI_MARKER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
