package com.baidu.platform.comjni.map.panodata;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes20.dex */
public class NAWalkPanoData extends JNIBaseApi {
    private long a = 0;

    private static native long nativeCreate();

    private static native boolean nativeGetPanoIDData(long j, int i, Bundle bundle);

    private static native boolean nativeGetPanoRouteData(long j, int i, int i2, int i3, Bundle bundle);

    private static native int nativeRelease(long j);

    private static native boolean nativeSetRoute(long j, byte[] bArr);
}
