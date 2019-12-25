package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int nr;
    private a ns;

    public a eM() throws IOException {
        a aVar = new a();
        aVar.nu = T("/proc/uid_stat/" + this.nr + "/tcp_rcv");
        aVar.nv = T("/proc/uid_stat/" + this.nr + "/tcp_snd");
        aVar.nt = d.c(aVar.nu + aVar.nv);
        return aVar;
    }

    public a eN() throws IOException {
        a eM = eM();
        this.ns.nu = d.c(eM.nu - d.eL().nu);
        this.ns.nv = d.c(eM.nv - d.eL().nv);
        this.ns.nt = d.c(eM.nt - d.eL().nt);
        return this.ns;
    }

    public double T(String str) {
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
                d.a(eN());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!eJ()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double nt = 0.0d;
        double nu = 0.0d;
        double nv = 0.0d;

        public a() {
        }
    }
}
