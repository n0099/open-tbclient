package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes14.dex */
class c<T> implements com.baidu.helios.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f2392a = false;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f2393b = new CountDownLatch(1);
    private b<T> asz = null;
    private a asA = null;

    /* loaded from: classes14.dex */
    public static class a {
        public boolean asB;
        public Throwable asC;
        public Bundle asD;
        public int errorCode;
    }

    /* loaded from: classes14.dex */
    public static class b<T> {
        public Bundle asD;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.asA = new a();
        this.asA.errorCode = i;
        this.asA.asC = th;
        this.asA.asD = bundle;
        this.f2392a = false;
        this.f2393b.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.asz = new b<>();
        this.asz.result = t;
        this.asz.asD = bundle;
        this.f2392a = true;
        this.f2393b.countDown();
    }

    public boolean a(int i) {
        try {
            this.f2393b.await(i, TimeUnit.MILLISECONDS);
            if (this.asA == null) {
                this.asA = new a();
                this.asA.asB = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f2392a;
    }

    public b<T> uY() {
        return this.asz;
    }

    public a uZ() {
        return this.asA;
    }
}
