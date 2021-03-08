package com.baidu.ar.child;
/* loaded from: classes3.dex */
public class CropAlgo {
    static {
        com.baidu.ar.libloader.a.require("cropface");
        com.baidu.ar.libloader.a.require("childCropFace");
    }

    public native int nativeClear();

    public native byte[] nativeCorpFace(c cVar);

    public native float[] nativeGetFaceBoxList(long j);

    public native float[] nativeTrackingPoints(long j);

    public native long nativeWriteCameraDataToHandel(long j, byte[] bArr, int i, int i2, float f);

    public native long nativeWriteFaceDataToHandel(long j, byte[] bArr);

    public native void nativeWriteTypeToHandle(long j);
}
