package com.baidu.location.b;

import android.os.HandlerThread;
/* loaded from: classes7.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f1917a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (y.class) {
            if (f1917a == null) {
                f1917a = new HandlerThread("ServiceStartArguments", 10);
                f1917a.start();
            }
            handlerThread = f1917a;
        }
        return handlerThread;
    }
}
