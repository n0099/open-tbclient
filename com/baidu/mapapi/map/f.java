package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;
/* loaded from: classes2.dex */
public /* synthetic */ class f {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7119a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f7120b;

    static {
        int[] iArr = new int[com.baidu.mapsdkplatform.comapi.map.aa.values().length];
        f7120b = iArr;
        try {
            iArr[com.baidu.mapsdkplatform.comapi.map.aa.TextureView.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7120b[com.baidu.mapsdkplatform.comapi.map.aa.GLSurfaceView.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[MyLocationConfiguration.LocationMode.values().length];
        f7119a = iArr2;
        try {
            iArr2[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7119a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7119a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
