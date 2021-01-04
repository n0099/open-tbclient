package com.baidu.ala.adp.lib.safe;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes15.dex */
public class SafeHandler extends Handler {
    private static final SafeHandler instance = new SafeHandler();

    private SafeHandler() {
        super(Looper.getMainLooper());
    }

    public static final SafeHandler getInst() {
        return instance;
    }
}
