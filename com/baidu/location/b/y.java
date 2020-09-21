package com.baidu.location.b;

import android.os.HandlerThread;
/* loaded from: classes3.dex */
public class y {
    private static HandlerThread a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (y.class) {
            if (a == null) {
                a = new HandlerThread("ServiceStartArguments", 10);
                a.start();
            }
            handlerThread = a;
        }
        return handlerThread;
    }
}
