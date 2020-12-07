package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
class c<T> implements com.baidu.helios.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f1785a = false;
    private final CountDownLatch awQ = new CountDownLatch(1);
    private b<T> awR = null;
    private a awS = null;

    /* loaded from: classes5.dex */
    public static class a {
        public boolean awT;
        public Throwable awU;
        public Bundle awV;
        public int errorCode;
    }

    /* loaded from: classes5.dex */
    public static class b<T> {
        public Bundle awV;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.awS = new a();
        this.awS.errorCode = i;
        this.awS.awU = th;
        this.awS.awV = bundle;
        this.f1785a = false;
        this.awQ.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.awR = new b<>();
        this.awR.result = t;
        this.awR.awV = bundle;
        this.f1785a = true;
        this.awQ.countDown();
    }

    public boolean a(int i) {
        try {
            this.awQ.await(i, TimeUnit.MILLISECONDS);
            if (this.awS == null) {
                this.awS = new a();
                this.awS.awT = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f1785a;
    }

    public b<T> zC() {
        return this.awR;
    }

    public a zD() {
        return this.awS;
    }
}
