package com.baidu.location.a;

import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f2586a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (v.class) {
            if (f2586a == null) {
                f2586a = new HandlerThread("ServiceStartArguments", 10);
                f2586a.start();
            }
            handlerThread = f2586a;
        }
        return handlerThread;
    }
}
