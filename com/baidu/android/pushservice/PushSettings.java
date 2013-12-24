package com.baidu.android.pushservice;

import android.content.Context;
/* loaded from: classes.dex */
public class PushSettings {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.android.pushservice.PushSettings$1] */
    public static void enableDebugMode(final Context context, final boolean z) {
        new Thread() { // from class: com.baidu.android.pushservice.PushSettings.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (LoadExecutor.loadPush(context)) {
                    com.baidu.android.pushservice.apiproxy.PushSettings.enableDebugMode(context, z);
                }
            }
        }.start();
    }
}
