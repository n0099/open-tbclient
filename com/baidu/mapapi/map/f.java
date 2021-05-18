package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;
/* loaded from: classes2.dex */
public /* synthetic */ class f {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7176a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f7177b;

    static {
        int[] iArr = new int[com.baidu.mapsdkplatform.comapi.map.aa.values().length];
        f7177b = iArr;
        try {
            iArr[com.baidu.mapsdkplatform.comapi.map.aa.TextureView.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7177b[com.baidu.mapsdkplatform.comapi.map.aa.GLSurfaceView.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[MyLocationConfiguration.LocationMode.values().length];
        f7176a = iArr2;
        try {
            iArr2[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7176a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7176a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
