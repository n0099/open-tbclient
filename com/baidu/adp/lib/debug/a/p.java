package com.baidu.adp.lib.debug.a;

import android.app.ActivityManager;
import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes.dex */
public class p extends a implements Runnable {
    private ActivityManager a;
    private String b;
    private int c;
    private q d;

    public p(Context context) {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.b = context.getPackageName();
        this.a = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.a.getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            if (this.b.contains(runningAppProcessInfo.processName)) {
                this.c = runningAppProcessInfo.uid;
            }
        }
        this.d = new q(this);
        com.baidu.adp.lib.debug.d.b(d());
    }

    public q d() {
        q qVar = new q(this);
        qVar.b = a(String.valueOf("/proc/uid_stat/") + this.c + "/tcp_rcv");
        qVar.c = a(String.valueOf("/proc/uid_stat/") + this.c + "/tcp_snd");
        qVar.a = com.baidu.adp.lib.debug.d.a(qVar.b + qVar.c);
        return qVar;
    }

    public q e() {
        q d = d();
        this.d.b = com.baidu.adp.lib.debug.d.a(d.b - com.baidu.adp.lib.debug.d.h().b);
        this.d.c = com.baidu.adp.lib.debug.d.a(d.c - com.baidu.adp.lib.debug.d.h().c);
        this.d.a = com.baidu.adp.lib.debug.d.a(d.a - com.baidu.adp.lib.debug.d.h().a);
        return this.d;
    }

    public double a(String str) {
        try {
            return com.baidu.adp.lib.debug.d.a(Long.valueOf(Long.parseLong(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream())).readLine())).longValue() / 1024.0d);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0d;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        super.b();
        while (true) {
            try {
                com.baidu.adp.lib.debug.d.a(e());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!a()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
