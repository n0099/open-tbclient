package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int tp;
    private a tq;

    public a eZ() throws IOException {
        a aVar = new a();
        aVar.ts = P("/proc/uid_stat/" + this.tp + "/tcp_rcv");
        aVar.tt = P("/proc/uid_stat/" + this.tp + "/tcp_snd");
        aVar.tr = d.c(aVar.ts + aVar.tt);
        return aVar;
    }

    public a fa() throws IOException {
        a eZ = eZ();
        this.tq.ts = d.c(eZ.ts - d.eY().ts);
        this.tq.tt = d.c(eZ.tt - d.eY().tt);
        this.tq.tr = d.c(eZ.tr - d.eY().tr);
        return this.tq;
    }

    public double P(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.c(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                n.b((Reader) bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    n.b((Reader) bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    n.b((Reader) bufferedReader);
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
                d.a(fa());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!eW()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double tr = 0.0d;
        double ts = 0.0d;
        double tt = 0.0d;

        public a() {
        }
    }
}
