package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
class c<T> implements com.baidu.helios.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f1783a = false;
    private final CountDownLatch axD = new CountDownLatch(1);
    private b<T> axE = null;
    private a axF = null;

    /* loaded from: classes7.dex */
    public static class a {
        public boolean axG;
        public Throwable axH;
        public Bundle axI;
        public int errorCode;
    }

    /* loaded from: classes7.dex */
    public static class b<T> {
        public Bundle axI;
        public T result;
    }

    public b<T> At() {
        return this.axE;
    }

    public a Au() {
        return this.axF;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.axF = new a();
        this.axF.errorCode = i;
        this.axF.axH = th;
        this.axF.axI = bundle;
        this.f1783a = false;
        this.axD.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.axE = new b<>();
        this.axE.result = t;
        this.axE.axI = bundle;
        this.f1783a = true;
        this.axD.countDown();
    }

    public boolean a(int i) {
        try {
            this.axD.await(i, TimeUnit.MILLISECONDS);
            if (this.axF == null) {
                this.axF = new a();
                this.axF.axG = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f1783a;
    }
}
