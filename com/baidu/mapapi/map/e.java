package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapsdkplatform.comapi.map.aa;
/* loaded from: classes4.dex */
/* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f2065a;
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
        f2065a = new int[MyLocationConfiguration.LocationMode.values().length];
        try {
            f2065a[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2065a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2065a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
    }
}
