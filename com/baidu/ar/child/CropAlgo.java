package com.baidu.ar.child;
/* loaded from: classes3.dex */
public class CropAlgo {
    static {
        com.baidu.ar.libloader.b.an("cropface");
        com.baidu.ar.libloader.b.an("childCropFace");
    }

    public native int nativeClear();

    public native byte[] nativeCorpFace(long j, byte[] bArr, int i, float f, float[] fArr, float[] fArr2, boolean z);

    public native float[] nativeGetFaceBoxList(long j);

    public native float[] nativeTrackingPoints(long j);

    public native long nativeWriteCameraDataToHandel(long j, byte[] bArr, int i, int i2, int i3, float f);

    public native long nativeWriteFaceDataToHandel(long j, byte[] bArr);

    public native void nativeWriteTypeToHandle(long j);
}
