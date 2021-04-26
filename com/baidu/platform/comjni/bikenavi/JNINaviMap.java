package com.baidu.platform.comjni.bikenavi;
/* loaded from: classes2.dex */
public class JNINaviMap {
    public native boolean ShowLayer(long j, int i2, boolean z);

    public native boolean UpdataBaseLayers(long j);

    public native boolean convertGeoPoint2ScrPt4Ar(long j, int[] iArr, int[] iArr2);

    public native boolean convertScrPt2GeoPoint(long j, int[] iArr, int[] iArr2);

    public native float getRouteDirection(long j);

    public native boolean resetBackgroundColor(long j);

    public native boolean resetMapStatusLimits(long j);

    public native boolean setArMapStatusLimits(long j);

    public native boolean setBackgroundTransparent(long j);

    public native boolean showBaseLayers(long j, boolean z);
}
