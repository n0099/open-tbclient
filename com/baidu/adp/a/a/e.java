package com.baidu.adp.a.a;

import com.baidu.adp.lib.util.n;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.a.a implements Runnable {
    private int ts;
    private a tt;

    public a fg() throws IOException {
        a aVar = new a();
        aVar.f2tv = P("/proc/uid_stat/" + this.ts + "/tcp_rcv");
        aVar.tw = P("/proc/uid_stat/" + this.ts + "/tcp_snd");
        aVar.tu = d.c(aVar.f2tv + aVar.tw);
        return aVar;
    }

    public a fh() throws IOException {
        a fg = fg();
        this.tt.f2tv = d.c(fg.f2tv - d.ff().f2tv);
        this.tt.tw = d.c(fg.tw - d.ff().tw);
        this.tt.tu = d.c(fg.tu - d.ff().tu);
        return this.tt;
    }

    public double P(String str) {
        BufferedReader bufferedReader;
        double d = 0.0d;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat " + str).getInputStream()));
            try {
                d = d.c(Long.valueOf(Long.parseLong(bufferedReader.readLine())).longValue() / 1024.0d);
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
                d.a(fh());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!fd()) {
                return;
            }
            Thread.sleep(500L);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        double tu = 0.0d;

        /* renamed from: tv  reason: collision with root package name */
        double f2tv = 0.0d;
        double tw = 0.0d;

        public a() {
        }
    }
}
