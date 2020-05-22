package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int GC;
    private a GD;

    public a js() throws IOException {
        a aVar = new a();
        aVar.GG = bj("/proc/uid_stat/" + this.GC + "/tcp_rcv");
        aVar.GH = bj("/proc/uid_stat/" + this.GC + "/tcp_snd");
        aVar.GF = d.g(aVar.GG + aVar.GH);
        return aVar;
    }

    public a jt() throws IOException {
        a js = js();
        this.GD.GG = d.g(js.GG - d.jr().GG);
        this.GD.GH = d.g(js.GH - d.jr().GH);
        this.GD.GF = d.g(js.GF - d.jr().GF);
        return this.GD;
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
        double GF = 0.0d;
        double GG = 0.0d;
        double GH = 0.0d;

        public a() {
        }
    }
}
