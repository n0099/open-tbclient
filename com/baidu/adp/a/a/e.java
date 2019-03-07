package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int vK;
    private a vL;

    public a gh() throws IOException {
        a aVar = new a();
        aVar.vN = ag("/proc/uid_stat/" + this.vK + "/tcp_rcv");
        aVar.vO = ag("/proc/uid_stat/" + this.vK + "/tcp_snd");
        aVar.vM = d.c(aVar.vN + aVar.vO);
        return aVar;
    }

    public a gi() throws IOException {
        a gh = gh();
        this.vL.vN = d.c(gh.vN - d.gg().vN);
        this.vL.vO = d.c(gh.vO - d.gg().vO);
        this.vL.vM = d.c(gh.vM - d.gg().vM);
        return this.vL;
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
                d.a(gi());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!ge()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double vM = 0.0d;
        double vN = 0.0d;
        double vO = 0.0d;

        public a() {
        }
    }
}
