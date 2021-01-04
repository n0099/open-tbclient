package com.baidu.location.b;

import android.os.HandlerThread;
/* loaded from: classes15.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f2667a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (y.class) {
            if (f2667a == null) {
                f2667a = new HandlerThread("ServiceStartArguments", 10);
                f2667a.start();
            }
            handlerThread = f2667a;
        }
        return handlerThread;
    }
}
