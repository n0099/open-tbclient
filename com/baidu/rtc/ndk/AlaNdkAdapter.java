package com.baidu.rtc.ndk;
/* loaded from: classes7.dex */
public class AlaNdkAdapter {
    public static final int CONVERT_TYPE_BGRA_YUV420P = 82448;
    public static final int CONVERT_TYPE_BGRA_YUV420SP = 16912;
    public static final int CONVERT_TYPE_BGR_YUV420P = 78352;
    public static final int CONVERT_TYPE_BGR_YUV420SP = 12816;
    public static final int CONVERT_TYPE_RGBA_YUV420P = 81938;
    public static final int CONVERT_TYPE_RGBA_YUV420SP = 16402;
    public static final int CONVERT_TYPE_RGB_YUV420P = 77842;
    public static final int CONVERT_TYPE_RGB_YUV420SP = 12306;

    public static native String getLibraryBuildDateNative();

    public static native String getLibraryGitCommitIdNative();

    public static native String getLibraryGitVersionNative();

    public static native String getLibraryVersionNative();

    public static native void rgbaConvertToYUVNative(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public static native void setLibraryPrintLogNative(int i);
}
