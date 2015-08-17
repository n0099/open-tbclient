package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int nU;
    private a nV;

    public a dR() {
        a aVar = new a();
        aVar.nX = F(String.valueOf("/proc/uid_stat/") + this.nU + "/tcp_rcv");
        aVar.nY = F(String.valueOf("/proc/uid_stat/") + this.nU + "/tcp_snd");
        aVar.nW = d.b(aVar.nX + aVar.nY);
        return aVar;
    }

    public a dS() {
        a dR = dR();
        this.nV.nX = d.b(dR.nX - d.dQ().nX);
        this.nV.nY = d.b(dR.nY - d.dQ().nY);
        this.nV.nW = d.b(dR.nW - d.dQ().nW);
        return this.nV;
    }

    public double F(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.b(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                o.a(bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    o.a(bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    o.a(bufferedReader);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        return d;
    }

    @Override // java.lang.Runnable
    public void run() {
        super.start();
        while (true) {
            try {
                d.a(dS());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!dO()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double nW = 0.0d;
        double nX = 0.0d;
        double nY = 0.0d;

        public a() {
        }
    }
}
