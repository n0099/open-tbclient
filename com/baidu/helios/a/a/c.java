package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
class c<T> implements com.baidu.helios.c<T> {
    private volatile boolean a = false;
    private final CountDownLatch awr = new CountDownLatch(1);
    private b<T> aws = null;
    private a awt = null;

    /* loaded from: classes10.dex */
    public static class a {
        public boolean awu;
        public Throwable awv;
        public Bundle aww;
        public int errorCode;
    }

    /* loaded from: classes10.dex */
    public static class b<T> {
        public Bundle aww;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.awt = new a();
        this.awt.errorCode = i;
        this.awt.awv = th;
        this.awt.aww = bundle;
        this.a = false;
        this.awr.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.aws = new b<>();
        this.aws.result = t;
        this.aws.aww = bundle;
        this.a = true;
        this.awr.countDown();
    }

    public boolean a(int i) {
        try {
            this.awr.await(i, TimeUnit.MILLISECONDS);
            if (this.awt == null) {
                this.awt = new a();
                this.awt.awu = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.a;
    }

    public b<T> zX() {
        return this.aws;
    }

    public a zY() {
        return this.awt;
    }
}
