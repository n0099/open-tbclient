package com.baidu.ar.b.b;

import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public abstract class d implements Runnable {
    int cX;
    protected WeakReference<com.baidu.ar.b.a.a> cY;
    int level;
    long timestamp = System.currentTimeMillis();

    public d(int i) {
        this.cX = i;
    }

    public void a(com.baidu.ar.b.a.a aVar) {
        this.cY = new WeakReference<>(aVar);
    }

    public int at() {
        return this.cX;
    }

    protected abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (d.class) {
            execute();
        }
    }
}
