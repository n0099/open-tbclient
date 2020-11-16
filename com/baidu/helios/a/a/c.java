package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes19.dex */
class c<T> implements com.baidu.helios.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f1783a = false;
    private final CountDownLatch avS = new CountDownLatch(1);
    private b<T> avT = null;
    private a avU = null;

    /* loaded from: classes19.dex */
    public static class a {
        public boolean avV;
        public Throwable avW;
        public Bundle avX;
        public int errorCode;
    }

    /* loaded from: classes19.dex */
    public static class b<T> {
        public Bundle avX;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.avU = new a();
        this.avU.errorCode = i;
        this.avU.avW = th;
        this.avU.avX = bundle;
        this.f1783a = false;
        this.avS.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.avT = new b<>();
        this.avT.result = t;
        this.avT.avX = bundle;
        this.f1783a = true;
        this.avS.countDown();
    }

    public boolean a(int i) {
        try {
            this.avS.await(i, TimeUnit.MILLISECONDS);
            if (this.avU == null) {
                this.avU = new a();
                this.avU.avV = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f1783a;
    }

    public b<T> zK() {
        return this.avT;
    }

    public a zL() {
        return this.avU;
    }
}
