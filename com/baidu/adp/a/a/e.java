package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private a sA;
    private int sz;

    public a eJ() throws IOException {
        a aVar = new a();
        aVar.sC = P("/proc/uid_stat/" + this.sz + "/tcp_rcv");
        aVar.sD = P("/proc/uid_stat/" + this.sz + "/tcp_snd");
        aVar.sB = d.c(aVar.sC + aVar.sD);
        return aVar;
    }

    public a eK() throws IOException {
        a eJ = eJ();
        this.sA.sC = d.c(eJ.sC - d.eI().sC);
        this.sA.sD = d.c(eJ.sD - d.eI().sD);
        this.sA.sB = d.c(eJ.sB - d.eI().sB);
        return this.sA;
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
                d.a(eK());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!eG()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double sB = 0.0d;
        double sC = 0.0d;
        double sD = 0.0d;

        public a() {
        }
    }
}
