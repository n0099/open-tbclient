package com.baidu.searchbox.dns.d.b;

import android.os.Process;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    protected final String mName = "searchbox task: " + l();
    protected final b H = d.B();

    protected abstract void k();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String l();

    public void start() {
        if (this.H != null) {
            this.H.a(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.mName);
        try {
            k();
            this.H.b(this);
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
