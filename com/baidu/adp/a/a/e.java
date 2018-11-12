package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int vO;
    private a vP;

    public a gk() throws IOException {
        a aVar = new a();
        aVar.vR = ag("/proc/uid_stat/" + this.vO + "/tcp_rcv");
        aVar.vS = ag("/proc/uid_stat/" + this.vO + "/tcp_snd");
        aVar.vQ = d.c(aVar.vR + aVar.vS);
        return aVar;
    }

    public a gl() throws IOException {
        a gk = gk();
        this.vP.vR = d.c(gk.vR - d.gj().vR);
        this.vP.vS = d.c(gk.vS - d.gj().vS);
        this.vP.vQ = d.c(gk.vQ - d.gj().vQ);
        return this.vP;
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
                d.a(gl());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!gh()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double vQ = 0.0d;
        double vR = 0.0d;
        double vS = 0.0d;

        public a() {
        }
    }
}
