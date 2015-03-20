package com.baidu.adp.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class e extends a implements Runnable {
    private int nR;
    private f nS;

    public f dO() {
        f fVar = new f(this);
        fVar.nU = E(String.valueOf("/proc/uid_stat/") + this.nR + "/tcp_rcv");
        fVar.nV = E(String.valueOf("/proc/uid_stat/") + this.nR + "/tcp_snd");
        fVar.nT = d.a(fVar.nU + fVar.nV);
        return fVar;
    }

    public f dP() {
        f dO = dO();
        this.nS.nU = d.a(dO.nU - d.dN().nU);
        this.nS.nV = d.a(dO.nV - d.dN().nV);
        this.nS.nT = d.a(dO.nT - d.dN().nT);
        return this.nS;
    }

    public double E(String str) {
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
                d.a(dP());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!dL()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
