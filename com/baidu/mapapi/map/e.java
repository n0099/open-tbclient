package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapsdkplatform.comapi.map.aa;
/* loaded from: classes8.dex */
/* synthetic */ class e {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b = new int[aa.values().length];

    static {
        try {
            b[aa.TextureView.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[aa.GLSurfaceView.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        a = new int[MyLocationConfiguration.LocationMode.values().length];
        try {
            a[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
    }
}
