package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int dR;
    private a dS;

    public a ak() {
        a aVar = new a();
        aVar.dU = t(String.valueOf("/proc/uid_stat/") + this.dR + "/tcp_rcv");
        aVar.dV = t(String.valueOf("/proc/uid_stat/") + this.dR + "/tcp_snd");
        aVar.dT = d.a(aVar.dU + aVar.dV);
        return aVar;
    }

    public a al() {
        a ak = ak();
        this.dS.dU = d.a(ak.dU - d.aj().dU);
        this.dS.dV = d.a(ak.dV - d.aj().dV);
        this.dS.dT = d.a(ak.dT - d.aj().dT);
        return this.dS;
    }

    public double t(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.a(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                o.b((Reader) bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    o.b((Reader) bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    o.b((Reader) bufferedReader);
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
                d.a(al());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!ah()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double dT = 0.0d;
        double dU = 0.0d;
        double dV = 0.0d;

        public a() {
        }
    }
}
