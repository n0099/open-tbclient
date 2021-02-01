package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
class c<T> implements com.baidu.helios.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f2390a = false;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f2391b = new CountDownLatch(1);
    private b<T> asp = null;
    private a asq = null;

    /* loaded from: classes6.dex */
    public static class a {
        public boolean asr;
        public Throwable ass;
        public Bundle ast;
        public int errorCode;
    }

    /* loaded from: classes6.dex */
    public static class b<T> {
        public Bundle ast;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.asq = new a();
        this.asq.errorCode = i;
        this.asq.ass = th;
        this.asq.ast = bundle;
        this.f2390a = false;
        this.f2391b.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.asp = new b<>();
        this.asp.result = t;
        this.asp.ast = bundle;
        this.f2390a = true;
        this.f2391b.countDown();
    }

    public boolean a(int i) {
        try {
            this.f2391b.await(i, TimeUnit.MILLISECONDS);
            if (this.asq == null) {
                this.asq = new a();
                this.asq.asr = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f2390a;
    }

    public b<T> uV() {
        return this.asp;
    }

    public a uW() {
        return this.asq;
    }
}
