package com.baidu.crabsdk;

import java.util.Map;
/* loaded from: classes6.dex */
public interface OnAnrCrashListener {
    void onAnrStarted(Map<String, Object> map);

    void onCrashStarted(Thread thread, Throwable th);

    void onNativeCrashStarted(String str);
}
