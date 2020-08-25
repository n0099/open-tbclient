package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int HJ;
    private a HK;

    public a lh() throws IOException {
        a aVar = new a();
        aVar.HM = bp("/proc/uid_stat/" + this.HJ + "/tcp_rcv");
        aVar.HN = bp("/proc/uid_stat/" + this.HJ + "/tcp_snd");
        aVar.HL = d.g(aVar.HM + aVar.HN);
        return aVar;
    }

    public a li() throws IOException {
        a lh = lh();
        this.HK.HM = d.g(lh.HM - d.lg().HM);
        this.HK.HN = d.g(lh.HN - d.lg().HN);
        this.HK.HL = d.g(lh.HL - d.lg().HL);
        return this.HK;
    }

    public double bp(String str) {
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
                d.a(li());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!le()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double HL = 0.0d;
        double HM = 0.0d;
        double HN = 0.0d;

        public a() {
        }
    }
}
