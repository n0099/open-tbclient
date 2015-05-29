package com.baidu.adp.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class e extends a implements Runnable {
    private int nU;
    private f nV;

    public f dQ() {
        f fVar = new f(this);
        fVar.nX = F(String.valueOf("/proc/uid_stat/") + this.nU + "/tcp_rcv");
        fVar.nY = F(String.valueOf("/proc/uid_stat/") + this.nU + "/tcp_snd");
        fVar.nW = d.a(fVar.nX + fVar.nY);
        return fVar;
    }

    public f dR() {
        f dQ = dQ();
        this.nV.nX = d.a(dQ.nX - d.dP().nX);
        this.nV.nY = d.a(dQ.nY - d.dP().nY);
        this.nV.nW = d.a(dQ.nW - d.dP().nW);
        return this.nV;
    }

    public double F(String str) {
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
                d.a(dR());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!dN()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
