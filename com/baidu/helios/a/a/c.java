package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
class c<T> implements com.baidu.helios.c<T> {
    private volatile boolean a = false;
    private final CountDownLatch awp = new CountDownLatch(1);
    private b<T> awq = null;
    private a awr = null;

    /* loaded from: classes10.dex */
    public static class a {
        public boolean aws;
        public Throwable awt;
        public Bundle awu;
        public int errorCode;
    }

    /* loaded from: classes10.dex */
    public static class b<T> {
        public Bundle awu;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.awr = new a();
        this.awr.errorCode = i;
        this.awr.awt = th;
        this.awr.awu = bundle;
        this.a = false;
        this.awp.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.awq = new b<>();
        this.awq.result = t;
        this.awq.awu = bundle;
        this.a = true;
        this.awp.countDown();
    }

    public boolean a(int i) {
        try {
            this.awp.await(i, TimeUnit.MILLISECONDS);
            if (this.awr == null) {
                this.awr = new a();
                this.awr.aws = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.a;
    }

    public b<T> zX() {
        return this.awq;
    }

    public a zY() {
        return this.awr;
    }
}
