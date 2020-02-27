package com.baidu.location.a;

import android.os.HandlerThread;
/* loaded from: classes8.dex */
public class v {
    private static HandlerThread a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (v.class) {
            if (a == null) {
                a = new HandlerThread("ServiceStartArguments", 10);
                a.start();
            }
            handlerThread = a;
        }
        return handlerThread;
    }
}
