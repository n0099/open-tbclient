package com.baidu.location.a;

import android.os.HandlerThread;
/* loaded from: classes4.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f1938a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (v.class) {
            if (f1938a == null) {
                f1938a = new HandlerThread("ServiceStartArguments", 10);
                f1938a.start();
            }
            handlerThread = f1938a;
        }
        return handlerThread;
    }
}
