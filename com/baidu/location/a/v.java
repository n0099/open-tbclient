package com.baidu.location.a;

import android.os.HandlerThread;
/* loaded from: classes4.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f2584a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (v.class) {
            if (f2584a == null) {
                f2584a = new HandlerThread("ServiceStartArguments", 10);
                f2584a.start();
            }
            handlerThread = f2584a;
        }
        return handlerThread;
    }
}
