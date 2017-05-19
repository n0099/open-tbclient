package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int nV;
    private a nW;

    public a cn() throws IOException {
        a aVar = new a();
        aVar.nY = s(String.valueOf("/proc/uid_stat/") + this.nV + "/tcp_rcv");
        aVar.nZ = s(String.valueOf("/proc/uid_stat/") + this.nV + "/tcp_snd");
        aVar.nX = d.a(aVar.nY + aVar.nZ);
        return aVar;
    }

    public a co() throws IOException {
        a cn = cn();
        this.nW.nY = d.a(cn.nY - d.cm().nY);
        this.nW.nZ = d.a(cn.nZ - d.cm().nZ);
        this.nW.nX = d.a(cn.nX - d.cm().nX);
        return this.nW;
    }

    public double s(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.a(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
                o.a(bufferedReader);
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    o.a(bufferedReader);
                    return d;
                } catch (Throwable th2) {
                    o.a(bufferedReader);
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
