package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;
/* loaded from: classes7.dex */
/* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f2067a;
    static final /* synthetic */ int[] b = new int[com.baidu.mapsdkplatform.comapi.map.v.values().length];

    static {
        try {
            b[com.baidu.mapsdkplatform.comapi.map.v.TextureView.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[com.baidu.mapsdkplatform.comapi.map.v.GLSurfaceView.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f2067a = new int[MyLocationConfiguration.LocationMode.values().length];
        try {
            f2067a[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2067a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2067a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
    }
}
