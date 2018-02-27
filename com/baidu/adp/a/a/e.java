package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int abW;
    private a abX;

    public a jS() throws IOException {
        a aVar = new a();
        aVar.abZ = G("/proc/uid_stat/" + this.abW + "/tcp_rcv");
        aVar.aca = G("/proc/uid_stat/" + this.abW + "/tcp_snd");
        aVar.abY = d.d(aVar.abZ + aVar.aca);
        return aVar;
    }

    public a jT() throws IOException {
        a jS = jS();
        this.abX.abZ = d.d(jS.abZ - d.jR().abZ);
        this.abX.aca = d.d(jS.aca - d.jR().aca);
        this.abX.abY = d.d(jS.abY - d.jR().abY);
        return this.abX;
    }

    public double G(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.d(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
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
                d.a(jT());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!jP()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double abY = 0.0d;
        double abZ = 0.0d;
        double aca = 0.0d;

        public a() {
        }
    }
}
