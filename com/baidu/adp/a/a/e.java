package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int ns;
    private a nt;

    public a eN() throws IOException {
        a aVar = new a();
        aVar.nv = U("/proc/uid_stat/" + this.ns + "/tcp_rcv");
        aVar.nw = U("/proc/uid_stat/" + this.ns + "/tcp_snd");
        aVar.nu = d.c(aVar.nv + aVar.nw);
        return aVar;
    }

    public a eO() throws IOException {
        a eN = eN();
        this.nt.nv = d.c(eN.nv - d.eM().nv);
        this.nt.nw = d.c(eN.nw - d.eM().nw);
        this.nt.nu = d.c(eN.nu - d.eM().nu);
        return this.nt;
    }

    public double U(String str) {
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
                d.a(eO());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!eK()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double nu = 0.0d;
        double nv = 0.0d;
        double nw = 0.0d;

        public a() {
        }
    }
}
