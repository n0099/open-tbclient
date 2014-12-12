package com.baidu.adp.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class e extends a implements Runnable {
    private int cG;
    private f cH;

    public f aq() {
        f fVar = new f(this);
        fVar.cJ = u(String.valueOf("/proc/uid_stat/") + this.cG + "/tcp_rcv");
        fVar.cK = u(String.valueOf("/proc/uid_stat/") + this.cG + "/tcp_snd");
        fVar.cI = d.a(fVar.cJ + fVar.cK);
        return fVar;
    }

    public f ar() {
        f aq = aq();
        this.cH.cJ = d.a(aq.cJ - d.ap().cJ);
        this.cH.cK = d.a(aq.cK - d.ap().cK);
        this.cH.cI = d.a(aq.cI - d.ap().cI);
        return this.cH;
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
