package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int nW;
    private a nX;

    public a dU() {
        a aVar = new a();
        aVar.nZ = E(String.valueOf("/proc/uid_stat/") + this.nW + "/tcp_rcv");
        aVar.oa = E(String.valueOf("/proc/uid_stat/") + this.nW + "/tcp_snd");
        aVar.nY = d.a(aVar.nZ + aVar.oa);
        return aVar;
    }

    public a dV() {
        a dU = dU();
        this.nX.nZ = d.a(dU.nZ - d.dT().nZ);
        this.nX.oa = d.a(dU.oa - d.dT().oa);
        this.nX.nY = d.a(dU.nY - d.dT().nY);
        return this.nX;
    }

    public double E(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.a(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                o.a((Reader) bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    o.a((Reader) bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    o.a((Reader) bufferedReader);
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
                d.a(dV());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!dR()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double nY = 0.0d;
        double nZ = 0.0d;
        double oa = 0.0d;

        public a() {
        }
    }
}
