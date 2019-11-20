package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int kU;
    private a kV;

    public a es() throws IOException {
        a aVar = new a();
        aVar.kX = O("/proc/uid_stat/" + this.kU + "/tcp_rcv");
        aVar.kY = O("/proc/uid_stat/" + this.kU + "/tcp_snd");
        aVar.kW = d.c(aVar.kX + aVar.kY);
        return aVar;
    }

    public a et() throws IOException {
        a es = es();
        this.kV.kX = d.c(es.kX - d.er().kX);
        this.kV.kY = d.c(es.kY - d.er().kY);
        this.kV.kW = d.c(es.kW - d.er().kW);
        return this.kV;
    }

    public double O(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.c(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                n.close((Reader) bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    n.close((Reader) bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    n.close((Reader) bufferedReader);
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
                d.a(et());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!ep()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double kW = 0.0d;
        double kX = 0.0d;
        double kY = 0.0d;

        public a() {
        }
    }
}
