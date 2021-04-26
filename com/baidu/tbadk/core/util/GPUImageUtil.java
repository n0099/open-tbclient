package com.baidu.tbadk.core.util;
/* loaded from: classes3.dex */
public class GPUImageUtil {
    static {
        System.loadLibrary("gpuimage_library");
    }

    public static native void YUVtoARBG(byte[] bArr, int i2, int i3, int[] iArr);

    public static native void YUVtoRBGA(byte[] bArr, int i2, int i3, int[] iArr);
}
