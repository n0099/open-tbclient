package com.baidu.adp.lib.debug.a;

import android.app.ActivityManager;
import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes.dex */
public class p extends a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private ActivityManager f409a;
    private String b;
    private int c;
    private q d;

    public p(Context context) {
        this.f409a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.b = context.getPackageName();
        this.f409a = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.f409a.getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            if (this.b.contains(runningAppProcessInfo.processName)) {
                this.c = runningAppProcessInfo.uid;
            }
        }
        this.d = new q(this);
        com.baidu.adp.lib.debug.b.b(d());
    }

    public q d() {
        q qVar = new q(this);
        qVar.b = a(String.valueOf("/proc/uid_stat/") + this.c + "/tcp_rcv");
        qVar.c = a(String.valueOf("/proc/uid_stat/") + this.c + "/tcp_snd");
        qVar.f410a = com.baidu.adp.lib.debug.b.a(qVar.b + qVar.c);
        return qVar;
    }

    public q e() {
        q d = d();
        this.d.b = com.baidu.adp.lib.debug.b.a(d.b - com.baidu.adp.lib.debug.b.h().b);
        this.d.c = com.baidu.adp.lib.debug.b.a(d.c - com.baidu.adp.lib.debug.b.h().c);
        this.d.f410a = com.baidu.adp.lib.debug.b.a(d.f410a - com.baidu.adp.lib.debug.b.h().f410a);
        return this.d;
    }

    public double a(String str) {
        try {
            return com.baidu.adp.lib.debug.b.a(Long.valueOf(Long.parseLong(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream())).readLine())).longValue() / 1024.0d);
        } catch (IOException e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        super.b();
        while (true) {
            try {
                com.baidu.adp.lib.debug.b.a(e());
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
