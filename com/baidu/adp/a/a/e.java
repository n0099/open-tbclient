package com.baidu.adp.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class e extends a implements Runnable {
    private int cH;
    private f cI;

    public f aq() {
        f fVar = new f(this);
        fVar.cK = u(String.valueOf("/proc/uid_stat/") + this.cH + "/tcp_rcv");
        fVar.cL = u(String.valueOf("/proc/uid_stat/") + this.cH + "/tcp_snd");
        fVar.cJ = d.a(fVar.cK + fVar.cL);
        return fVar;
    }

    public f ar() {
        f aq = aq();
        this.cI.cK = d.a(aq.cK - d.ap().cK);
        this.cI.cL = d.a(aq.cL - d.ap().cL);
        this.cI.cJ = d.a(aq.cJ - d.ap().cJ);
        return this.cI;
    }

    public double u(String str) {
        try {
            return d.a(Long.valueOf(Long.parseLong(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream())).readLine())).longValue() / 1024.0d);
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
                d.a(ar());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!an()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
