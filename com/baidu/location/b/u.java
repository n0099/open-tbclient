package com.baidu.location.b;

import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f6673a;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (u.class) {
            if (f6673a == null) {
                HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                f6673a = handlerThread2;
                handlerThread2.start();
            }
            handlerThread = f6673a;
        }
        return handlerThread;
    }
}
