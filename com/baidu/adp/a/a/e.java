package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private a JW;
    private int mUid;

    public a kH() throws IOException {
        a aVar = new a();
        aVar.JY = bt("/proc/uid_stat/" + this.mUid + "/tcp_rcv");
        aVar.JZ = bt("/proc/uid_stat/" + this.mUid + "/tcp_snd");
        aVar.JX = d.g(aVar.JY + aVar.JZ);
        return aVar;
    }

    public a kI() throws IOException {
        a kH = kH();
        this.JW.JY = d.g(kH.JY - d.kG().JY);
        this.JW.JZ = d.g(kH.JZ - d.kG().JZ);
        this.JW.JX = d.g(kH.JX - d.kG().JX);
        return this.JW;
    }

    public double bt(String str) {
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
        double JX = 0.0d;
        double JY = 0.0d;
        double JZ = 0.0d;

        public a() {
        }
    }
}
