package com.baidu.ala.ndk;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes15.dex */
public class AlaNdkAdapter {
    public static final int CONVERT_TYPE_BGRA_YUV420P = 82448;
    public static final int CONVERT_TYPE_BGRA_YUV420SP = 16912;
    public static final int CONVERT_TYPE_BGR_YUV420P = 78352;
    public static final int CONVERT_TYPE_BGR_YUV420SP = 12816;
    public static final int CONVERT_TYPE_RGBA_YUV420P = 81938;
    public static final int CONVERT_TYPE_RGBA_YUV420SP = 16402;
    public static final int CONVERT_TYPE_RGB_YUV420P = 77842;
    public static final int CONVERT_TYPE_RGB_YUV420SP = 12306;
    public static final int LINK_IP_MOBILE = 2;
    public static final int LINK_IP_TELECOM = 3;
    public static final int LINK_IP_UNICOM = 1;
    public static final int LINK_IP_UNKNOW = 0;

    public static native String getLibraryBuildDateNative();

    public static native String getLibraryGitCommitIdNative();

    public static native String getLibraryGitVersionNative();

    public static native String getLibraryVersionNative();

    public static native void rgbaConvertToYUVNative(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public static native void setDomainConfig(String str, String str2, int i);

    public static native void setDomainConfigEnable(int i);

    public static native void setHttpDnsEnable(int i);

    public static native void setLibraryPrintLogNative(int i);

    public static native void setPushOptTimestamp(int i);

    public static long getMediaStreamTS(boolean z) {
        return z ? System.nanoTime() : System.nanoTime() / TimeUtils.NANOS_PER_MS;
    }
}
