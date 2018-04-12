package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int mk;
    private a ml;

    public a bW() throws IOException {
        a aVar = new a();
        aVar.mn = D("/proc/uid_stat/" + this.mk + "/tcp_rcv");
        aVar.mo = D("/proc/uid_stat/" + this.mk + "/tcp_snd");
        aVar.mm = d.e(aVar.mn + aVar.mo);
        return aVar;
    }

    public a bX() throws IOException {
        a bW = bW();
        this.ml.mn = d.e(bW.mn - d.bV().mn);
        this.ml.mo = d.e(bW.mo - d.bV().mo);
        this.ml.mm = d.e(bW.mm - d.bV().mm);
        return this.ml;
    }

    public double D(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.e(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
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
                d.a(bX());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!bT()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double mm = 0.0d;
        double mn = 0.0d;
        double mo = 0.0d;

        public a() {
        }
    }
}
