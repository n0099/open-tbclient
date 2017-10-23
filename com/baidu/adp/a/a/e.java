package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int nt;
    private a nu;

    public a cn() throws IOException {
        a aVar = new a();
        aVar.nw = z("/proc/uid_stat/" + this.nt + "/tcp_rcv");
        aVar.nx = z("/proc/uid_stat/" + this.nt + "/tcp_snd");
        aVar.nv = d.c(aVar.nw + aVar.nx);
        return aVar;
    }

    public a co() throws IOException {
        a cn = cn();
        this.nu.nw = d.c(cn.nw - d.cm().nw);
        this.nu.nx = d.c(cn.nx - d.cm().nx);
        this.nu.nv = d.c(cn.nv - d.cm().nv);
        return this.nu;
    }

    public double z(String str) {
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
                d.a(co());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!ck()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double nv = 0.0d;
        double nw = 0.0d;
        double nx = 0.0d;

        public a() {
        }
    }
}
