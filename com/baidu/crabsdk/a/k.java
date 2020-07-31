package com.baidu.crabsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes12.dex */
final class k {
    private Handler handler;

    public k(String str) {
        this.handler = null;
        HandlerThread handlerThread = new HandlerThread("BlockCanaryThread_" + str);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper());
    }

    public final Handler getHandler() {
        return this.handler;
    }
}
