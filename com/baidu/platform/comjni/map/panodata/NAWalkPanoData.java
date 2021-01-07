package com.baidu.platform.comjni.map.panodata;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes3.dex */
public class NAWalkPanoData extends JNIBaseApi {

    /* renamed from: a  reason: collision with root package name */
    private long f4760a = 0;

    private static native long nativeCreate();

    private static native boolean nativeGetPanoIDData(long j, int i, Bundle bundle);

    private static native boolean nativeGetPanoRouteData(long j, int i, int i2, int i3, Bundle bundle);

    private static native int nativeRelease(long j);

    private static native boolean nativeSetRoute(long j, byte[] bArr);
}
