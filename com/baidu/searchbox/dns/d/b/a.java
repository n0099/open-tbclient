package com.baidu.searchbox.dns.d.b;

import android.os.Process;
/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    public final String mName = "searchbox task: " + n();
    public final b Y = d.L();

    public abstract void m();

    public abstract String n();

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

    public void start() {
        b bVar = this.Y;
        if (bVar != null) {
            bVar.a(this);
        }
    }
}
