package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int sG;
    private a sH;

    public a eK() throws IOException {
        a aVar = new a();
        aVar.sJ = P("/proc/uid_stat/" + this.sG + "/tcp_rcv");
        aVar.sK = P("/proc/uid_stat/" + this.sG + "/tcp_snd");
        aVar.sI = d.e(aVar.sJ + aVar.sK);
        return aVar;
    }

    public a eL() throws IOException {
        a eK = eK();
        this.sH.sJ = d.e(eK.sJ - d.eJ().sJ);
        this.sH.sK = d.e(eK.sK - d.eJ().sK);
        this.sH.sI = d.e(eK.sI - d.eJ().sI);
        return this.sH;
    }

    public double P(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.e(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                n.b((Reader) bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    n.b((Reader) bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    n.b((Reader) bufferedReader);
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
                d.a(eL());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!eH()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double sI = 0.0d;
        double sJ = 0.0d;
        double sK = 0.0d;

        public a() {
        }
    }
}
