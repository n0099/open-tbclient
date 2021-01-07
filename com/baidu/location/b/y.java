package com.baidu.location.b;

import android.os.HandlerThread;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f2668a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (y.class) {
            if (f2668a == null) {
                f2668a = new HandlerThread("ServiceStartArguments", 10);
                f2668a.start();
            }
            handlerThread = f2668a;
        }
        return handlerThread;
    }
}
