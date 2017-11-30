package com.baidu.location.a;

import android.os.HandlerThread;
/* loaded from: classes.dex */
public class i {
    private static HandlerThread a = null;

    public static synchronized HandlerThread mh() {
        HandlerThread handlerThread;
        synchronized (i.class) {
            if (a == null) {
                a = new HandlerThread("ServiceStartArguments", 10);
                a.start();
            }
            handlerThread = a;
        }
        return handlerThread;
    }
}
