package com.baidu.searchbox.dns.d.b;

import android.os.Process;
/* loaded from: classes13.dex */
public abstract class a implements Runnable {
    protected final String mName = "searchbox task: " + n();
    protected final b Y = d.N();

    protected abstract void m();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String n();

    public void start() {
        if (this.Y != null) {
            this.Y.a(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.mName);
        try {
            m();
            this.Y.b(this);
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
