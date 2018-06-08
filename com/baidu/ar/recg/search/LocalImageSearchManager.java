package com.baidu.ar.recg.search;
/* loaded from: classes3.dex */
public class LocalImageSearchManager {
    static {
        System.loadLibrary("ARSameSearch");
    }

    public static native boolean deleteFeatures();

    public static native boolean frameResize(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, float f);

    public static native FrameResizeParams getFrameResizeParams(int i, int i2, int i3);

    public static native boolean initLocalFeatures(String[] strArr);

    public static native FeatureSearchResult[] searchByYUVImage(byte[] bArr, int i, int i2, int i3);
}
