package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int uZ;
    private a va;

    public a fR() throws IOException {
        a aVar = new a();
        aVar.vc = ag("/proc/uid_stat/" + this.uZ + "/tcp_rcv");
        aVar.vd = ag("/proc/uid_stat/" + this.uZ + "/tcp_snd");
        aVar.vb = d.c(aVar.vc + aVar.vd);
        return aVar;
    }

    public a fS() throws IOException {
        a fR = fR();
        this.va.vc = d.c(fR.vc - d.fQ().vc);
        this.va.vd = d.c(fR.vd - d.fQ().vd);
        this.va.vb = d.c(fR.vb - d.fQ().vb);
        return this.va;
    }

    public double ag(String str) {
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
                d.a(fS());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!fO()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double vb = 0.0d;
        double vc = 0.0d;
        double vd = 0.0d;

        public a() {
        }
    }
}
