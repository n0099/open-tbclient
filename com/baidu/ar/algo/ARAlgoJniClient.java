package com.baidu.ar.algo;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ARAlgoJniClient {
    public static native int arCameraIntrinsics(float[] fArr, int i, float[] fArr2);

    public static native int arInit(byte[] bArr, int i, int i2, int i3, int i4, String str, int[] iArr);

    public static native int arRelease();

    public static native void arSetMatchTrackMode(int i);

    public static native int arTracking(byte[] bArr, int i, int i2, float[] fArr, int i3);

    public static native int calModelPosition(float f, float[] fArr, float[] fArr2);

    public static native ArrayList<TrackModel> fetchModelPose();

    public static native int getVersion();

    public static native int insertModel(String str, int i, int i2, float[] fArr, float f);

    public static native int removeAllModel();

    public static native int removeModel(String str);

    public static native int slamPlaneQuality(byte[] bArr, int i, int i2);

    public static native void slamReset();

    public static native boolean slamStart(int i, int i2, float[] fArr, float[] fArr2);

    public static native void slamStop();

    public static native TrackParams slamTrack(byte[] bArr, float[] fArr);
}
