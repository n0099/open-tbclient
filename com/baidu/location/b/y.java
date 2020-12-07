package com.baidu.location.b;

import android.os.HandlerThread;
/* loaded from: classes26.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f1919a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (y.class) {
            if (f1919a == null) {
                f1919a = new HandlerThread("ServiceStartArguments", 10);
                f1919a.start();
            }
            handlerThread = f1919a;
        }
        return handlerThread;
    }
}
