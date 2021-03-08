package com.baidu.ar.c;
/* loaded from: classes3.dex */
public abstract class a<T> implements Runnable {
    private int mPriority = 5;

    public abstract T ay();

    public abstract String getTag();

    @Override // java.lang.Runnable
    public final void run() {
        Thread.currentThread().setPriority(this.mPriority);
        try {
            c.cd().c(ay());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPriority(int i) {
        if (i > 10) {
            i = 10;
        } else if (i < 1) {
            i = 1;
        }
        this.mPriority = i;
    }
}
