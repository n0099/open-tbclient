package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int Hf;
    private a Hg;

    public a jI() throws IOException {
        a aVar = new a();
        aVar.Hi = bk("/proc/uid_stat/" + this.Hf + "/tcp_rcv");
        aVar.Hj = bk("/proc/uid_stat/" + this.Hf + "/tcp_snd");
        aVar.Hh = d.g(aVar.Hi + aVar.Hj);
        return aVar;
    }

    public a jJ() throws IOException {
        a jI = jI();
        this.Hg.Hi = d.g(jI.Hi - d.jH().Hi);
        this.Hg.Hj = d.g(jI.Hj - d.jH().Hj);
        this.Hg.Hh = d.g(jI.Hh - d.jH().Hh);
        return this.Hg;
    }

    public double bk(String str) {
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
                d.a(jJ());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!jF()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double Hh = 0.0d;
        double Hi = 0.0d;
        double Hj = 0.0d;

        public a() {
        }
    }
}
