package com.baidu.slamlibrary;
/* loaded from: classes3.dex */
public class ARAlgoJniClient {
    public static native int arCameraIntrinsics(float[] fArr, int i, float[] fArr2);

    public static native int arInit(byte[] bArr, int i, int i2, int i3, int i4, String str, int[] iArr);

    public static native int arRelease();

    public static native void arSetMatchTrackMode(int i);

    public static native int arTracking(byte[] bArr, int i, int i2, float[] fArr, int i3);

    public static native int getVersion();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int slamPlaneQuality(byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void slamReset();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean slamStart(int i, int i2, float[] fArr, float[] fArr2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void slamStop();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native TrackParams slamTrack(byte[] bArr, float[] fArr);
}
