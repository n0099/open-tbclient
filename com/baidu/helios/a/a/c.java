package com.baidu.helios.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
class c<T> implements com.baidu.helios.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f2441a = false;

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f2442b = new CountDownLatch(1);
    private b<T> axl = null;
    private a axm = null;

    /* loaded from: classes4.dex */
    public static class a {
        public boolean axn;
        public Throwable axo;
        public Bundle axp;
        public int errorCode;
    }

    /* loaded from: classes4.dex */
    public static class b<T> {
        public Bundle axp;
        public T result;
    }

    @Override // com.baidu.helios.c
    public void a(int i, Throwable th, Bundle bundle) {
        this.axm = new a();
        this.axm.errorCode = i;
        this.axm.axo = th;
        this.axm.axp = bundle;
        this.f2441a = false;
        this.f2442b.countDown();
    }

    @Override // com.baidu.helios.c
    public void a(T t, Bundle bundle) {
        this.axl = new b<>();
        this.axl.result = t;
        this.axl.axp = bundle;
        this.f2441a = true;
        this.f2442b.countDown();
    }

    public boolean a(int i) {
        try {
            this.f2442b.await(i, TimeUnit.MILLISECONDS);
            if (this.axm == null) {
                this.axm = new a();
                this.axm.axn = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.f2441a;
    }

    public b<T> yT() {
        return this.axl;
    }

    public a yU() {
        return this.axm;
    }
}
