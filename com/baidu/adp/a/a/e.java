package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int GA;
    private a GC;

    public a js() throws IOException {
        a aVar = new a();
        aVar.GF = bj("/proc/uid_stat/" + this.GA + "/tcp_rcv");
        aVar.GG = bj("/proc/uid_stat/" + this.GA + "/tcp_snd");
        aVar.GD = d.g(aVar.GF + aVar.GG);
        return aVar;
    }

    public a jt() throws IOException {
        a js = js();
        this.GC.GF = d.g(js.GF - d.jr().GF);
        this.GC.GG = d.g(js.GG - d.jr().GG);
        this.GC.GD = d.g(js.GD - d.jr().GD);
        return this.GC;
    }

    public double bj(String str) {
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
                d.a(jt());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!jp()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double GD = 0.0d;
        double GF = 0.0d;
        double GG = 0.0d;

        public a() {
        }
    }
}
