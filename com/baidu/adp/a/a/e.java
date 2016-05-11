package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int dS;
    private a dT;

    public a ak() {
        a aVar = new a();
        aVar.dV = t(String.valueOf("/proc/uid_stat/") + this.dS + "/tcp_rcv");
        aVar.dW = t(String.valueOf("/proc/uid_stat/") + this.dS + "/tcp_snd");
        aVar.dU = d.a(aVar.dV + aVar.dW);
        return aVar;
    }

    public a al() {
        a ak = ak();
        this.dT.dV = d.a(ak.dV - d.aj().dV);
        this.dT.dW = d.a(ak.dW - d.aj().dW);
        this.dT.dU = d.a(ak.dU - d.aj().dU);
        return this.dT;
    }

    public double t(String str) {
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
        double dU = 0.0d;
        double dV = 0.0d;
        double dW = 0.0d;

        public a() {
        }
    }
}
