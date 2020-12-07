package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int Jg;
    private a Jh;

    public a lm() throws IOException {
        a aVar = new a();
        aVar.Jj = bu("/proc/uid_stat/" + this.Jg + "/tcp_rcv");
        aVar.Jk = bu("/proc/uid_stat/" + this.Jg + "/tcp_snd");
        aVar.Ji = d.g(aVar.Jj + aVar.Jk);
        return aVar;
    }

    public a ln() throws IOException {
        a lm = lm();
        this.Jh.Jj = d.g(lm.Jj - d.ll().Jj);
        this.Jh.Jk = d.g(lm.Jk - d.ll().Jk);
        this.Jh.Ji = d.g(lm.Ji - d.ll().Ji);
        return this.Jh;
    }

    public double bu(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.g(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
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
                d.a(ln());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!lj()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double Ji = 0.0d;
        double Jj = 0.0d;
        double Jk = 0.0d;

        public a() {
        }
    }
}
