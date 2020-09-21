package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes12.dex */
class c<T> implements com.baidu.helios.c<T> {
    private volatile boolean a = false;
    private final CountDownLatch awT = new CountDownLatch(1);
    private b<T> awU = null;
    private a awV = null;

    /* loaded from: classes12.dex */
    public static class a {
        public boolean awW;
        public Throwable awX;
        public Bundle awY;
        public int errorCode;
    }

    /* loaded from: classes12.dex */
    public static class b<T> {
        public Bundle awY;
        public T result;
    }

    public b<T> Al() {
        return this.awU;
    }

    public a Am() {
        return this.awV;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.awV = new a();
        this.awV.errorCode = i;
        this.awV.awX = th;
        this.awV.awY = bundle;
        this.a = false;
        this.awT.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.awU = new b<>();
        this.awU.result = t;
        this.awU.awY = bundle;
        this.a = true;
        this.awT.countDown();
    }

    public boolean a(int i) {
        try {
            this.awT.await(i, TimeUnit.MILLISECONDS);
            if (this.awV == null) {
                this.awV = new a();
                this.awV.awW = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.a;
    }
}
