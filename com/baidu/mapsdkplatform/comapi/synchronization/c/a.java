package com.baidu.mapsdkplatform.comapi.synchronization.c;

import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class a {
    private int a = 4000;
    private int b = 4000;
    private ExecutorService c = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractRunnableC0198a implements Runnable {
        private AbstractRunnableC0198a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ AbstractRunnableC0198a(b bVar) {
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
        this.c.submit(new b(this, eVar, str));
    }
}
