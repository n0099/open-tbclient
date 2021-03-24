package com.baidu.location.a;

import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f6586a;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (v.class) {
            if (f6586a == null) {
                HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                f6586a = handlerThread2;
                handlerThread2.start();
            }
            handlerThread = f6586a;
        }
        return handlerThread;
    }
}
