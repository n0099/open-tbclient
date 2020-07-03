package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
class c<T> implements com.baidu.helios.c<T> {
    private volatile boolean a = false;
    private final CountDownLatch arw = new CountDownLatch(1);
    private b<T> arx = null;
    private a ary = null;

    /* loaded from: classes6.dex */
    public static class a {
        public Throwable arA;
        public Bundle arB;
        public boolean arz;
        public int errorCode;
    }

    /* loaded from: classes6.dex */
    public static class b<T> {
        public Bundle arB;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.ary = new a();
        this.ary.errorCode = i;
        this.ary.arA = th;
        this.ary.arB = bundle;
        this.a = false;
        this.arw.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.arx = new b<>();
        this.arx.result = t;
        this.arx.arB = bundle;
        this.a = true;
        this.arw.countDown();
    }

    public boolean a(int i) {
        try {
            this.arw.await(i, TimeUnit.MILLISECONDS);
            if (this.ary == null) {
                this.ary = new a();
                this.ary.arz = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.a;
    }

    public b<T> uA() {
        return this.arx;
    }

    public a uB() {
        return this.ary;
    }
}
