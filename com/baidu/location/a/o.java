package com.baidu.location.a;

import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class o {
    private static HandlerThread a = null;

    public static synchronized HandlerThread tq() {
        HandlerThread handlerThread;
        synchronized (o.class) {
            if (a == null) {
                a = new HandlerThread("ServiceStartArguments", 10);
                a.start();
            }
            handlerThread = a;
        }
        return handlerThread;
    }
}
