package com.baidu.apollon.statistics;

import android.os.HandlerThread;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f3933a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static b f3934a = new b();
    }

    public static b a() {
        return a.f3934a;
    }

    public HandlerThread b() {
        return this.f3933a;
    }

    public b() {
        HandlerThread handlerThread = new HandlerThread("CacheThread");
        this.f3933a = handlerThread;
        handlerThread.start();
        this.f3933a.setPriority(10);
    }
}
