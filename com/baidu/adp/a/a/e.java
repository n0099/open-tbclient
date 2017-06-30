package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int nV;
    private a nW;

    public a cn() throws IOException {
        a aVar = new a();
        aVar.nY = z(String.valueOf("/proc/uid_stat/") + this.nV + "/tcp_rcv");
        aVar.nZ = z(String.valueOf("/proc/uid_stat/") + this.nV + "/tcp_snd");
        aVar.nX = d.c(aVar.nY + aVar.nZ);
        return aVar;
    }

    public a co() throws IOException {
        a cn = cn();
        this.nW.nY = d.c(cn.nY - d.cm().nY);
        this.nW.nZ = d.c(cn.nZ - d.cm().nZ);
        this.nW.nX = d.c(cn.nX - d.cm().nX);
        return this.nW;
    }

    public double z(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.c(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
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
                d.a(co());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!ck()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double nX = 0.0d;
        double nY = 0.0d;
        double nZ = 0.0d;

        public a() {
        }
    }
}
