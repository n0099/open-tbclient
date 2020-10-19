package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int Ii;
    private a Ij;

    public a lm() throws IOException {
        a aVar = new a();
        aVar.Il = br("/proc/uid_stat/" + this.Ii + "/tcp_rcv");
        aVar.Im = br("/proc/uid_stat/" + this.Ii + "/tcp_snd");
        aVar.Ik = d.g(aVar.Il + aVar.Im);
        return aVar;
    }

    public a ln() throws IOException {
        a lm = lm();
        this.Ij.Il = d.g(lm.Il - d.ll().Il);
        this.Ij.Im = d.g(lm.Im - d.ll().Im);
        this.Ij.Ik = d.g(lm.Ik - d.ll().Ik);
        return this.Ij;
    }

    public double br(String str) {
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
        double Ik = 0.0d;
        double Il = 0.0d;
        double Im = 0.0d;

        public a() {
        }
    }
}
