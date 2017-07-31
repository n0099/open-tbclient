package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class GPUImageUtil {
    public static native void YUVtoARBG(byte[] bArr, int i, int i2, int[] iArr);

    static {
        System.loadLibrary("gpuimage_library");
    }
}
