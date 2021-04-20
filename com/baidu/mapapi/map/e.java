package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapsdkplatform.comapi.map.aa;
/* loaded from: classes2.dex */
public /* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f7102a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f7103b;

    static {
        int[] iArr = new int[aa.values().length];
        f7103b = iArr;
        try {
            iArr[aa.TextureView.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7103b[aa.GLSurfaceView.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[MyLocationConfiguration.LocationMode.values().length];
        f7102a = iArr2;
        try {
            iArr2[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7102a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7102a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
