package com.baidu.adp.lib.debug.a;

import android.app.ActivityManager;
import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes.dex */
public class q extends a implements Runnable {
    private ActivityManager gE;
    private int gK;
    private r gL;
    private String mPackageName;

    public q(Context context) {
        this.gE = null;
        this.mPackageName = null;
        this.gK = 0;
        this.gL = null;
        this.mPackageName = context.getPackageName();
        this.gE = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.gE.getRunningAppProcesses();
        for (int i = 0; i < runningAppProcesses.size(); i++) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
            if (this.mPackageName.contains(runningAppProcessInfo.processName)) {
                this.gK = runningAppProcessInfo.uid;
            }
        }
        this.gL = new r(this);
        com.baidu.adp.lib.debug.d.b(cN());
    }

    public r cN() {
        r rVar = new r(this);
        rVar.gN = P(String.valueOf("/proc/uid_stat/") + this.gK + "/tcp_rcv");
        rVar.gO = P(String.valueOf("/proc/uid_stat/") + this.gK + "/tcp_snd");
        rVar.gM = com.baidu.adp.lib.debug.d.a(rVar.gN + rVar.gO);
        return rVar;
    }

    public r cO() {
        r cN = cN();
        this.gL.gN = com.baidu.adp.lib.debug.d.a(cN.gN - com.baidu.adp.lib.debug.d.cH().gN);
        this.gL.gO = com.baidu.adp.lib.debug.d.a(cN.gO - com.baidu.adp.lib.debug.d.cH().gO);
        this.gL.gM = com.baidu.adp.lib.debug.d.a(cN.gM - com.baidu.adp.lib.debug.d.cH().gM);
        return this.gL;
    }

    public double P(String str) {
        try {
            return com.baidu.adp.lib.debug.d.a(Long.valueOf(Long.parseLong(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream())).readLine())).longValue() / 1024.0d);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0d;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        super.start();
        while (true) {
            try {
                com.baidu.adp.lib.debug.d.a(cO());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!cJ()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
