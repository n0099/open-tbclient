package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
class c<T> implements com.baidu.helios.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f1781a = false;
    private final CountDownLatch axC = new CountDownLatch(1);
    private b<T> axD = null;
    private a axE = null;

    /* loaded from: classes7.dex */
    public static class a {
        public boolean axF;
        public Throwable axG;
        public Bundle axH;
        public int errorCode;
    }

    /* loaded from: classes7.dex */
    public static class b<T> {
        public Bundle axH;
        public T result;
    }

    public b<T> At() {
        return this.axD;
    }

    public a Au() {
        return this.axE;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.axE = new a();
        this.axE.errorCode = i;
        this.axE.axG = th;
        this.axE.axH = bundle;
        this.f1781a = false;
        this.axC.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.axD = new b<>();
        this.axD.result = t;
        this.axD.axH = bundle;
        this.f1781a = true;
        this.axC.countDown();
    }

    public boolean a(int i) {
        try {
            this.axC.await(i, TimeUnit.MILLISECONDS);
            if (this.axE == null) {
                this.axE = new a();
                this.axE.axF = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f1781a;
    }
}
