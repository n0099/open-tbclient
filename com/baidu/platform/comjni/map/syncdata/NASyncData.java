package com.baidu.platform.comjni.map.syncdata;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes7.dex */
public class NASyncData extends JNIBaseApi {

    /* renamed from: a  reason: collision with root package name */
    private long f3188a = 0;

    private native boolean nativeCleanData(long j, String str);

    private native boolean nativeCleanGetData(long j, Bundle bundle);

    private native boolean nativeClearData(long j, String str);

    private native long nativeCreate();

    private native boolean nativeGetBusinessInfo(long j, Bundle bundle);

    private native String nativeGetErrorCid(long j, int i, int i2);

    private native int nativeGetSyncData(long j, Bundle bundle);

    private native boolean nativeGetUserInfo(long j, Bundle bundle);

    private native boolean nativeInit(long j, String str);

    private native int nativeRelease(long j);

    private native boolean nativeSetBusinessInfo(long j, String str);

    private native boolean nativeSetUserInfo(long j, String str);

    private native boolean nativeStartSync(long j, int i);

    private native boolean nativeStopSync(long j, int i);

    private native boolean nativeSyncData(long j, String str);
}
