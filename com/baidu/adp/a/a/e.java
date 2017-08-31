package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int nr;
    private a ns;

    public a cn() throws IOException {
        a aVar = new a();
        aVar.nu = z("/proc/uid_stat/" + this.nr + "/tcp_rcv");
        aVar.nv = z("/proc/uid_stat/" + this.nr + "/tcp_snd");
        aVar.nt = d.c(aVar.nu + aVar.nv);
        return aVar;
    }

    public a co() throws IOException {
        a cn = cn();
        this.ns.nu = d.c(cn.nu - d.cm().nu);
        this.ns.nv = d.c(cn.nv - d.cm().nv);
        this.ns.nt = d.c(cn.nt - d.cm().nt);
        return this.ns;
    }

    public double z(String str) {
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
        double nt = 0.0d;
        double nu = 0.0d;
        double nv = 0.0d;

        public a() {
        }
    }
}
