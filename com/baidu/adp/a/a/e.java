package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int gG;
    private a gH;

    public a bf() throws IOException {
        a aVar = new a();
        aVar.gJ = y(String.valueOf("/proc/uid_stat/") + this.gG + "/tcp_rcv");
        aVar.gK = y(String.valueOf("/proc/uid_stat/") + this.gG + "/tcp_snd");
        aVar.gI = d.a(aVar.gJ + aVar.gK);
        return aVar;
    }

    public a bg() throws IOException {
        a bf = bf();
        this.gH.gJ = d.a(bf.gJ - d.be().gJ);
        this.gH.gK = d.a(bf.gK - d.be().gK);
        this.gH.gI = d.a(bf.gI - d.be().gI);
        return this.gH;
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
        double gI = 0.0d;
        double gJ = 0.0d;
        double gK = 0.0d;

        public a() {
        }
    }
}
