package com.baidu.location.b;

import android.os.HandlerThread;
/* loaded from: classes7.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f1915a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (y.class) {
            if (f1915a == null) {
                f1915a = new HandlerThread("ServiceStartArguments", 10);
                f1915a.start();
            }
            handlerThread = f1915a;
        }
        return handlerThread;
    }
}
