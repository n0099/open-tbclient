package com.baidu.location.a;

import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f6622a;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (v.class) {
            if (f6622a == null) {
                HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                f6622a = handlerThread2;
                handlerThread2.start();
            }
            handlerThread = f6622a;
        }
        return handlerThread;
    }
}
