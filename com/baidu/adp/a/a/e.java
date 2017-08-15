package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int pJ;
    private a pK;

    public a cy() throws IOException {
        a aVar = new a();
        aVar.pM = F("/proc/uid_stat/" + this.pJ + "/tcp_rcv");
        aVar.pN = F("/proc/uid_stat/" + this.pJ + "/tcp_snd");
        aVar.pL = d.c(aVar.pM + aVar.pN);
        return aVar;
    }

    public a cz() throws IOException {
        a cy = cy();
        this.pK.pM = d.c(cy.pM - d.cx().pM);
        this.pK.pN = d.c(cy.pN - d.cx().pN);
        this.pK.pL = d.c(cy.pL - d.cx().pL);
        return this.pK;
    }

    public double F(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.c(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                m.b((Reader) bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    m.b((Reader) bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    m.b((Reader) bufferedReader);
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
                d.a(cz());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!cv()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double pL = 0.0d;
        double pM = 0.0d;
        double pN = 0.0d;

        public a() {
        }
    }
}
