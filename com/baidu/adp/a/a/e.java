package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int gE;
    private a gF;

    public a bf() throws IOException {
        a aVar = new a();
        aVar.gH = y(String.valueOf("/proc/uid_stat/") + this.gE + "/tcp_rcv");
        aVar.gI = y(String.valueOf("/proc/uid_stat/") + this.gE + "/tcp_snd");
        aVar.gG = d.a(aVar.gH + aVar.gI);
        return aVar;
    }

    public a bg() throws IOException {
        a bf = bf();
        this.gF.gH = d.a(bf.gH - d.be().gH);
        this.gF.gI = d.a(bf.gI - d.be().gI);
        this.gF.gG = d.a(bf.gG - d.be().gG);
        return this.gF;
    }

    public double y(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.a(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                o.b((Reader) bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    o.b((Reader) bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    o.b((Reader) bufferedReader);
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
                d.a(bg());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!bc()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double gG = 0.0d;
        double gH = 0.0d;
        double gI = 0.0d;

        public a() {
        }
    }
}
