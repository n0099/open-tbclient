package com.baidu.ar.b.b;

import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public abstract class d implements Runnable {
    int cK;
    protected WeakReference<com.baidu.ar.b.a.a> cL;
    int level;
    long timestamp = System.currentTimeMillis();

    public d(int i) {
        this.cK = i;
    }

    public void a(com.baidu.ar.b.a.a aVar) {
        this.cL = new WeakReference<>(aVar);
    }

    public int af() {
        return this.cK;
    }

    protected abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.class) {
            execute();
        }
    }
}
