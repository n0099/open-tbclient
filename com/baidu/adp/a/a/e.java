package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int tq;
    private a tr;

    public a eZ() throws IOException {
        a aVar = new a();
        aVar.tt = P("/proc/uid_stat/" + this.tq + "/tcp_rcv");
        aVar.tu = P("/proc/uid_stat/" + this.tq + "/tcp_snd");
        aVar.ts = d.c(aVar.tt + aVar.tu);
        return aVar;
    }

    public a fa() throws IOException {
        a eZ = eZ();
        this.tr.tt = d.c(eZ.tt - d.eY().tt);
        this.tr.tu = d.c(eZ.tu - d.eY().tu);
        this.tr.ts = d.c(eZ.ts - d.eY().ts);
        return this.tr;
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
        double ts = 0.0d;
        double tt = 0.0d;
        double tu = 0.0d;

        public a() {
        }
    }
}
