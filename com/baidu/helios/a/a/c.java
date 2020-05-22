package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
class c<T> implements com.baidu.helios.c<T> {
    private volatile boolean a = false;
    private final CountDownLatch aqe = new CountDownLatch(1);
    private b<T> aqf = null;
    private a aqg = null;

    /* loaded from: classes6.dex */
    public static class a {
        public boolean aqh;
        public Throwable aqi;
        public Bundle aqj;
        public int errorCode;
    }

    /* loaded from: classes6.dex */
    public static class b<T> {
        public Bundle aqj;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.aqg = new a();
        this.aqg.errorCode = i;
        this.aqg.aqi = th;
        this.aqg.aqj = bundle;
        this.a = false;
        this.aqe.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.aqf = new b<>();
        this.aqf.result = t;
        this.aqf.aqj = bundle;
        this.a = true;
        this.aqe.countDown();
    }

    public boolean a(int i) {
        try {
            this.aqe.await(i, TimeUnit.MILLISECONDS);
            if (this.aqg == null) {
                this.aqg = new a();
                this.aqg.aqh = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.a;
    }

    public b<T> ui() {
        return this.aqf;
    }

    public a uj() {
        return this.aqg;
    }
}
