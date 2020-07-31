package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
class c<T> implements com.baidu.helios.c<T> {
    private volatile boolean a = false;
    private final CountDownLatch ars = new CountDownLatch(1);
    private b<T> art = null;
    private a aru = null;

    /* loaded from: classes10.dex */
    public static class a {
        public boolean arv;
        public Throwable arw;
        public Bundle arx;
        public int errorCode;
    }

    /* loaded from: classes10.dex */
    public static class b<T> {
        public Bundle arx;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.aru = new a();
        this.aru.errorCode = i;
        this.aru.arw = th;
        this.aru.arx = bundle;
        this.a = false;
        this.ars.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.art = new b<>();
        this.art.result = t;
        this.art.arx = bundle;
        this.a = true;
        this.ars.countDown();
    }

    public boolean a(int i) {
        try {
            this.ars.await(i, TimeUnit.MILLISECONDS);
            if (this.aru == null) {
                this.aru = new a();
                this.aru.arv = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.a;
    }

    public b<T> uA() {
        return this.art;
    }

    public a uB() {
        return this.aru;
    }
}
