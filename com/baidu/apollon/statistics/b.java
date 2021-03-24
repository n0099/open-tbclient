package com.baidu.apollon.statistics;

import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f3845a;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static b f3846a = new b();
    }

    public static b a() {
        return a.f3846a;
    }

    public HandlerThread b() {
        return this.f3845a;
    }

    public b() {
        HandlerThread handlerThread = new HandlerThread("CacheThread");
        this.f3845a = handlerThread;
        handlerThread.start();
        this.f3845a.setPriority(10);
    }
}
