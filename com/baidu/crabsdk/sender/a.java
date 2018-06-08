package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
/* loaded from: classes2.dex */
public final class a extends Thread {
    private static boolean Th = false;
    private final Context RV;
    private SoftReference<Handler> Tj;
    private final SoftReference<Looper> Ti = new SoftReference<>(Looper.getMainLooper());
    private volatile int Tk = 0;
    private boolean Tl = false;
    private final Runnable Tm = new b(this);
    private final int bw = 3000;

    public a(Context context) {
        this.RV = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
        com.baidu.crabsdk.c.a.cd("===line.contains(tracesWroteLog)===");
        r0 = com.baidu.crabsdk.sender.d.a(r13.RV, (java.lang.Throwable) null, false);
        r1 = com.baidu.crabsdk.b.c.t();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0089, code lost:
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
        if (r1.size() == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
        r0.putAll(r1);
        com.baidu.crabsdk.sender.d.b(r0);
        com.baidu.crabsdk.sender.f.a(r13.RV, com.baidu.crabsdk.sender.f.j(r0));
        com.baidu.crabsdk.sender.e.ab();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a7, code lost:
        if (com.baidu.crabsdk.sender.e.pm() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
        com.baidu.crabsdk.c.a.cd("===uploadAnr===");
        com.baidu.crabsdk.sender.h.a(false, r13.RV);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b7, code lost:
        if (com.baidu.crabsdk.a.M == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b9, code lost:
        com.baidu.crabsdk.a.M.onAnrStarted(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pj() {
        String readLine;
        com.baidu.crabsdk.c.a.cd("===readLog()===");
        if (this.Tl) {
            return;
        }
        this.Tl = true;
        try {
            com.baidu.crabsdk.c.a.cd("===readingTrace===");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            long currentTimeMillis = System.currentTimeMillis();
            String format = simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v time").getInputStream()), 8192);
            while (true) {
                if (System.currentTimeMillis() - currentTimeMillis > StatisticConfig.MIN_UPLOAD_INTERVAL || (readLine = bufferedReader.readLine()) == null || readLine.length() < "MM-dd HH:mm:ss.SSS".length()) {
                    break;
                } else if (readLine.substring(0, "MM-dd HH:mm:ss.SSS".length()).compareTo(format) >= 0 && readLine.contains("Wrote stack traces to '/data/anr/traces.txt'")) {
                    break;
                }
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.b("ANR Log", e);
        }
        this.Tl = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.crabsdk.c.a.cd("***isRunning = " + Th + "***");
        if (Th) {
            return;
        }
        Th = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cb("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.Tk;
            if (this.Ti.get() == null) {
                Th = false;
                break;
            }
            try {
                if (this.Tj == null || this.Tj.get() == null) {
                    this.Tj = new SoftReference<>(new Handler(this.Ti.get()));
                }
                this.Tj.get().post(this.Tm);
                Thread.sleep(this.bw);
                if (!com.baidu.crabsdk.a.I) {
                    Th = false;
                    com.baidu.crabsdk.c.a.cf("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.ce("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.Tk != i);
        com.baidu.crabsdk.c.a.cb("onAppNotResponding!");
        if (this.RV != null && !com.baidu.crabsdk.a.J) {
            pj();
        }
        Th = false;
        Th = false;
        com.baidu.crabsdk.c.a.cf("anr watch thread is over!");
    }
}
