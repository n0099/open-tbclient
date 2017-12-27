package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int ace;
    private a acf;

    public a jS() throws IOException {
        a aVar = new a();
        aVar.ach = G("/proc/uid_stat/" + this.ace + "/tcp_rcv");
        aVar.aci = G("/proc/uid_stat/" + this.ace + "/tcp_snd");
        aVar.acg = d.d(aVar.ach + aVar.aci);
        return aVar;
    }

    public a jT() throws IOException {
        a jS = jS();
        this.acf.ach = d.d(jS.ach - d.jR().ach);
        this.acf.aci = d.d(jS.aci - d.jR().aci);
        this.acf.acg = d.d(jS.acg - d.jR().acg);
        return this.acf;
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
        double acg = 0.0d;
        double ach = 0.0d;
        double aci = 0.0d;

        public a() {
        }
    }
}
