package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int nn;
    private a np;

    public a eM() throws IOException {
        a aVar = new a();
        aVar.nr = T("/proc/uid_stat/" + this.nn + "/tcp_rcv");
        aVar.ns = T("/proc/uid_stat/" + this.nn + "/tcp_snd");
        aVar.nq = d.c(aVar.nr + aVar.ns);
        return aVar;
    }

    public a eN() throws IOException {
        a eM = eM();
        this.np.nr = d.c(eM.nr - d.eL().nr);
        this.np.ns = d.c(eM.ns - d.eL().ns);
        this.np.nq = d.c(eM.nq - d.eL().nq);
        return this.np;
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
        double nq = 0.0d;
        double nr = 0.0d;
        double ns = 0.0d;

        public a() {
        }
    }
}
