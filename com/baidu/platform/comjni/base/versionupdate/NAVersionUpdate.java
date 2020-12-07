package com.baidu.platform.comjni.base.versionupdate;

import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes26.dex */
public class NAVersionUpdate extends JNIBaseApi {

    /* renamed from: a  reason: collision with root package name */
    private long f3164a = 0;

    private native long nativeCreate();

    private native long nativeRelease(long j);

    private native void nativeSetVerUpdateParams(long j, String str, String str2);
}
