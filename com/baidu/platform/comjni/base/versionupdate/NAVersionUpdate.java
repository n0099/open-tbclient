package com.baidu.platform.comjni.base.versionupdate;

import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes20.dex */
public class NAVersionUpdate extends JNIBaseApi {
    private long a = 0;

    private native long nativeCreate();

    private native long nativeRelease(long j);

    private native void nativeSetVerUpdateParams(long j, String str, String str2);
}
