package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private a IB;
    private int mUid;

    public a kI() throws IOException {
        a aVar = new a();
        aVar.IE = bp("/proc/uid_stat/" + this.mUid + "/tcp_rcv");
        aVar.IF = bp("/proc/uid_stat/" + this.mUid + "/tcp_snd");
        aVar.IC = d.g(aVar.IE + aVar.IF);
        return aVar;
    }

    public a kJ() throws IOException {
        a kI = kI();
        this.IB.IE = d.g(kI.IE - d.kH().IE);
        this.IB.IF = d.g(kI.IF - d.kH().IF);
        this.IB.IC = d.g(kI.IC - d.kH().IC);
        return this.IB;
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
                d.a(kJ());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!kF()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double IC = 0.0d;
        double IE = 0.0d;
        double IF = 0.0d;

        public a() {
        }
    }
}
