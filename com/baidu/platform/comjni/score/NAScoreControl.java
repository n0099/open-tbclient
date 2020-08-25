package com.baidu.platform.comjni.score;

import android.os.Bundle;
import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes20.dex */
public class NAScoreControl extends JNIBaseApi {
    private native void nativeCancel(long j);

    private native long nativeCreate();

    private native boolean nativeGetMapIntegral(long j, String str, Bundle bundle);

    private native String nativeGetMapIntegralResult(long j, int i);

    private native int nativeInit(long j, String str);

    private native int nativeRelease(long j);

    private native boolean nativeUploadLogin(long j, Bundle bundle, String str);

    private native boolean nativeUploadNavIntegral(long j, String str, Bundle bundle);

    private native boolean nativeUploadSignIn(long j, Bundle bundle, String str);

    private native boolean nativeUploadUGCReportError(long j, String str, String str2);
}
