package com.baidu.apollon.statistics;

import android.os.HandlerThread;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f3956a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static b f3957a = new b();
    }

    public static b a() {
        return a.f3957a;
    }

    public HandlerThread b() {
        return this.f3956a;
    }

    public b() {
        HandlerThread handlerThread = new HandlerThread("CacheThread");
        this.f3956a = handlerThread;
        handlerThread.start();
        this.f3956a.setPriority(10);
    }
}
