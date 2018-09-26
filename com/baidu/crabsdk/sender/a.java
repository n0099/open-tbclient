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
    private static boolean VJ = false;
    private final Context Uy;
    private SoftReference<Handler> VL;
    private final SoftReference<Looper> VK = new SoftReference<>(Looper.getMainLooper());
    private volatile int VM = 0;
    private boolean VN = false;
    private final Runnable VO = new b(this);
    private final int bw = 3000;

    public a(Context context) {
        this.Uy = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
        com.baidu.crabsdk.c.a.cx("===line.contains(tracesWroteLog)===");
        r0 = com.baidu.crabsdk.sender.d.a(r13.Uy, (java.lang.Throwable) null, false);
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
        com.baidu.crabsdk.sender.f.a(r13.Uy, com.baidu.crabsdk.sender.f.k(r0));
        com.baidu.crabsdk.sender.e.ab();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a7, code lost:
        if (com.baidu.crabsdk.sender.e.qs() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
        com.baidu.crabsdk.c.a.cx("===uploadAnr===");
        com.baidu.crabsdk.sender.h.a(false, r13.Uy);
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
    private void R() {
        String readLine;
        com.baidu.crabsdk.c.a.cx("===readLog()===");
        if (this.VN) {
            return;
        }
        this.VN = true;
        try {
            com.baidu.crabsdk.c.a.cx("===readingTrace===");
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
            com.baidu.crabsdk.c.a.f("ANR Log", e);
        }
        this.VN = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.crabsdk.c.a.cx("***isRunning = " + VJ + "***");
        if (VJ) {
            return;
        }
        VJ = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cv("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.VM;
            if (this.VK.get() == null) {
                VJ = false;
                break;
            }
            try {
                if (this.VL == null || this.VL.get() == null) {
                    this.VL = new SoftReference<>(new Handler(this.VK.get()));
                }
                this.VL.get().post(this.VO);
                Thread.sleep(this.bw);
                if (!com.baidu.crabsdk.a.I) {
                    VJ = false;
                    com.baidu.crabsdk.c.a.cz("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.cy("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.VM != i);
        com.baidu.crabsdk.c.a.cv("onAppNotResponding!");
        if (this.Uy != null && !com.baidu.crabsdk.a.J) {
            R();
        }
        VJ = false;
        VJ = false;
        com.baidu.crabsdk.c.a.cz("anr watch thread is over!");
    }
}
