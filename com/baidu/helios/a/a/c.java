package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes14.dex */
class c<T> implements com.baidu.helios.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f1823a = false;
    private final CountDownLatch b = new CountDownLatch(1);
    private b<T> atP = null;
    private a atQ = null;

    /* loaded from: classes14.dex */
    public static class a {
        public boolean atR;
        public Throwable atS;
        public Bundle atT;
        public int errorCode;
    }

    /* loaded from: classes14.dex */
    public static class b<T> {
        public Bundle atT;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.atQ = new a();
        this.atQ.errorCode = i;
        this.atQ.atS = th;
        this.atQ.atT = bundle;
        this.f1823a = false;
        this.b.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.atP = new b<>();
        this.atP.result = t;
        this.atP.atT = bundle;
        this.f1823a = true;
        this.b.countDown();
    }

    public boolean a(int i) {
        try {
            this.b.await(i, TimeUnit.MILLISECONDS);
            if (this.atQ == null) {
                this.atQ = new a();
                this.atQ.atR = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f1823a;
    }

    public b<T> uY() {
        return this.atP;
    }

    public a uZ() {
        return this.atQ;
    }
}
