package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int HR;
    private a HS;

    public a ll() throws IOException {
        a aVar = new a();
        aVar.HV = br("/proc/uid_stat/" + this.HR + "/tcp_rcv");
        aVar.HW = br("/proc/uid_stat/" + this.HR + "/tcp_snd");
        aVar.HU = d.g(aVar.HV + aVar.HW);
        return aVar;
    }

    public a lm() throws IOException {
        a ll = ll();
        this.HS.HV = d.g(ll.HV - d.lk().HV);
        this.HS.HW = d.g(ll.HW - d.lk().HW);
        this.HS.HU = d.g(ll.HU - d.lk().HU);
        return this.HS;
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
                d.a(lm());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!li()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double HU = 0.0d;
        double HV = 0.0d;
        double HW = 0.0d;

        public a() {
        }
    }
}
