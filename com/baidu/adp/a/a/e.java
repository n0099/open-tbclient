package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private a IE;
    private int mUid;

    public a kI() throws IOException {
        a aVar = new a();
        aVar.IG = bp("/proc/uid_stat/" + this.mUid + "/tcp_rcv");
        aVar.IH = bp("/proc/uid_stat/" + this.mUid + "/tcp_snd");
        aVar.IF = d.g(aVar.IG + aVar.IH);
        return aVar;
    }

    public a kJ() throws IOException {
        a kI = kI();
        this.IE.IG = d.g(kI.IG - d.kH().IG);
        this.IE.IH = d.g(kI.IH - d.kH().IH);
        this.IE.IF = d.g(kI.IF - d.kH().IF);
        return this.IE;
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
        double IF = 0.0d;
        double IG = 0.0d;
        double IH = 0.0d;

        public a() {
        }
    }
}
