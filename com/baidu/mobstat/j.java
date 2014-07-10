package com.baidu.mobstat;

import android.content.Context;
import android.os.Process;
/* loaded from: classes.dex */
class j extends Thread {
    private static j a = new j();
    private Context b;
    private boolean c = false;
    private boolean d = false;

    private j() {
    }

    public static j a() {
        return a;
    }

    private void d() {
        this.c = true;
    }

    private synchronized void e() {
        this.d = true;
    }

    public void a(Context context) {
        if (context == null || b()) {
            return;
        }
        this.b = context;
        d();
        start();
        com.baidu.mobstat.a.e.a("**************load caceh**start********");
    }

    public boolean b() {
        return this.c;
    }

    public synchronized boolean c() {
        return this.d;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(19);
        while (!this.d) {
            k.a().a(this.b);
            DataCore.getInstance().loadStatData(this.b);
            DataCore.getInstance().loadLastSession(this.b);
            e();
            synchronized (a) {
                try {
                    notifyAll();
                } catch (IllegalMonitorStateException e) {
                    com.baidu.mobstat.a.e.a("statsdk", e);
                }
            }
            DataCore.getInstance().installHeader(this.b);
            k.a().b(this.b);
            com.baidu.mobstat.a.e.a("**************load caceh**end********");
        }
    }
}
