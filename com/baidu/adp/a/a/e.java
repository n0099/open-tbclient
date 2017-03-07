package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private a oA;
    private int oz;

    public a co() throws IOException {
        a aVar = new a();
        aVar.oC = x(String.valueOf("/proc/uid_stat/") + this.oz + "/tcp_rcv");
        aVar.oD = x(String.valueOf("/proc/uid_stat/") + this.oz + "/tcp_snd");
        aVar.oB = d.a(aVar.oC + aVar.oD);
        return aVar;
    }

    public a cp() throws IOException {
        a co = co();
        this.oA.oC = d.a(co.oC - d.cn().oC);
        this.oA.oD = d.a(co.oD - d.cn().oD);
        this.oA.oB = d.a(co.oB - d.cn().oB);
        return this.oA;
    }

    public double x(String str) {
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
                d.a(cp());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!cl()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double oB = 0.0d;
        double oC = 0.0d;
        double oD = 0.0d;

        public a() {
        }
    }
}
