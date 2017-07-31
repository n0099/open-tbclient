package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int pH;
    private a pI;

    public a cy() throws IOException {
        a aVar = new a();
        aVar.pK = F("/proc/uid_stat/" + this.pH + "/tcp_rcv");
        aVar.pL = F("/proc/uid_stat/" + this.pH + "/tcp_snd");
        aVar.pJ = d.c(aVar.pK + aVar.pL);
        return aVar;
    }

    public a cz() throws IOException {
        a cy = cy();
        this.pI.pK = d.c(cy.pK - d.cx().pK);
        this.pI.pL = d.c(cy.pL - d.cx().pL);
        this.pI.pJ = d.c(cy.pJ - d.cx().pJ);
        return this.pI;
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
        double pJ = 0.0d;
        double pK = 0.0d;
        double pL = 0.0d;

        public a() {
        }
    }
}
