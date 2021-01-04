package com.baidu.platform.comjni.map.userinfosecure;

import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes15.dex */
public class NAUserinfoSecure extends JNIBaseApi {

    /* renamed from: a  reason: collision with root package name */
    private long f4761a = 0;

    private native void nativeCancel(long j);

    private native long nativeCreate();

    private native long nativeGetUploadTimeStamp(long j);

    private native boolean nativeInit(long j);

    private native int nativeRelease(long j);

    private native void nativeSetUserInfoWithString(long j, String str);

    private native boolean nativeUnInit(long j);

    private native boolean nativeUploadUserInfo(long j);
}
