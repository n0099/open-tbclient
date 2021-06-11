package com.baidu.location.b;

import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f6616a;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (u.class) {
            if (f6616a == null) {
                HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                f6616a = handlerThread2;
                handlerThread2.start();
            }
            handlerThread = f6616a;
        }
        return handlerThread;
    }
}
