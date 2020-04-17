package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int Gx;
    private a Gy;

    public a js() throws IOException {
        a aVar = new a();
        aVar.GA = bj("/proc/uid_stat/" + this.Gx + "/tcp_rcv");
        aVar.GC = bj("/proc/uid_stat/" + this.Gx + "/tcp_snd");
        aVar.Gz = d.g(aVar.GA + aVar.GC);
        return aVar;
    }

    public a jt() throws IOException {
        a js = js();
        this.Gy.GA = d.g(js.GA - d.jr().GA);
        this.Gy.GC = d.g(js.GC - d.jr().GC);
        this.Gy.Gz = d.g(js.Gz - d.jr().Gz);
        return this.Gy;
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
        double Gz = 0.0d;
        double GA = 0.0d;
        double GC = 0.0d;

        public a() {
        }
    }
}
