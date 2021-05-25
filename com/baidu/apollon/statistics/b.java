package com.baidu.apollon.statistics;

import android.os.HandlerThread;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f3937a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static b f3938a = new b();
    }

    public static b a() {
        return a.f3938a;
    }

    public HandlerThread b() {
        return this.f3937a;
    }

    public b() {
        HandlerThread handlerThread = new HandlerThread("CacheThread");
        this.f3937a = handlerThread;
        handlerThread.start();
        this.f3937a.setPriority(10);
    }
}
