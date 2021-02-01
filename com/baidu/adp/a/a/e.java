package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private a Iz;
    private int mUid;

    public a kH() throws IOException {
        a aVar = new a();
        aVar.IC = bp("/proc/uid_stat/" + this.mUid + "/tcp_rcv");
        aVar.IE = bp("/proc/uid_stat/" + this.mUid + "/tcp_snd");
        aVar.IB = d.g(aVar.IC + aVar.IE);
        return aVar;
    }

    public a kI() throws IOException {
        a kH = kH();
        this.Iz.IC = d.g(kH.IC - d.kG().IC);
        this.Iz.IE = d.g(kH.IE - d.kG().IE);
        this.Iz.IB = d.g(kH.IB - d.kG().IB);
        return this.Iz;
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
                d.a(kI());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!kE()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double IB = 0.0d;
        double IC = 0.0d;
        double IE = 0.0d;

        public a() {
        }
    }
}
