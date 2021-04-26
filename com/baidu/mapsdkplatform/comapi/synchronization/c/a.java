package com.baidu.mapsdkplatform.comapi.synchronization.c;

import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f8045a = 4000;

    /* renamed from: b  reason: collision with root package name */
    public int f8046b = 4000;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f8047c = Executors.newCachedThreadPool();

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractRunnableC0099a implements Runnable {
        public AbstractRunnableC0099a() {
        }

        public /* synthetic */ AbstractRunnableC0099a(b bVar) {
            this();
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public void a(String str, e eVar) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Request URL cannot be null");
        }
        this.f8047c.submit(new b(this, eVar, str));
    }
}
