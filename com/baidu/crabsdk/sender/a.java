package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
/* loaded from: classes6.dex */
public final class a extends Thread {
    private static boolean YF = false;
    private final Context Xw;
    private SoftReference<Handler> YH;
    private final SoftReference<Looper> YG = new SoftReference<>(Looper.getMainLooper());
    private volatile int by = 0;
    private boolean YJ = false;
    private final Runnable YK = new b(this);
    private final int YI = 3000;

    public a(Context context) {
        this.Xw = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
        com.baidu.crabsdk.c.a.cJ("===line.contains(tracesWroteLog)===");
        r0 = com.baidu.crabsdk.sender.d.a(r13.Xw, (java.lang.Throwable) null, false);
        r1 = com.baidu.crabsdk.b.c.t();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0092, code lost:
        if (r1 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
        if (r1.size() == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
        r0.putAll(r1);
        com.baidu.crabsdk.sender.d.b(r0);
        com.baidu.crabsdk.sender.f.a(r13.Xw, com.baidu.crabsdk.sender.f.j(r0));
        com.baidu.crabsdk.sender.e.ac();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
        if (com.baidu.crabsdk.sender.e.rB() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b2, code lost:
        com.baidu.crabsdk.c.a.cJ("===uploadAnr===");
        com.baidu.crabsdk.sender.h.a(false, r13.Xw);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
        if (com.baidu.crabsdk.a.N == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
        com.baidu.crabsdk.a.N.onAnrStarted(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void S() {
        String readLine;
        com.baidu.crabsdk.c.a.cJ("===readLog()===");
        if (this.YJ) {
            return;
        }
        this.YJ = true;
        try {
            com.baidu.crabsdk.c.a.cJ("===readingTrace===");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            String str = Build.VERSION.SDK_INT >= 27 ? "Wrote stack traces to '[tombstoned]'" : "Wrote stack traces to '/data/anr/traces.txt'";
            long currentTimeMillis = System.currentTimeMillis();
            String format = simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v time").getInputStream()), 8192);
            while (true) {
                if (System.currentTimeMillis() - currentTimeMillis > StatisticConfig.MIN_UPLOAD_INTERVAL || (readLine = bufferedReader.readLine()) == null || readLine.length() < "MM-dd HH:mm:ss.SSS".length()) {
                    break;
                } else if (readLine.substring(0, "MM-dd HH:mm:ss.SSS".length()).compareTo(format) >= 0 && readLine.contains(str)) {
                    break;
                }
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("ANR Log", e);
        } catch (OutOfMemoryError e2) {
            com.baidu.crabsdk.c.a.f("内存溢出了！", e2);
        }
        this.YJ = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.crabsdk.c.a.cJ("***isRunning = " + YF + "***");
        if (YF) {
            return;
        }
        YF = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cH("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.by;
            if (this.YG.get() == null) {
                YF = false;
                break;
            }
            try {
                if (this.YH == null || this.YH.get() == null) {
                    this.YH = new SoftReference<>(new Handler(this.YG.get()));
                }
                this.YH.get().post(this.YK);
                Thread.sleep(this.YI);
                if (!com.baidu.crabsdk.a.I) {
                    YF = false;
                    com.baidu.crabsdk.c.a.v("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.cK("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.by != i);
        com.baidu.crabsdk.c.a.cH("onAppNotResponding!");
        if (this.Xw != null && !com.baidu.crabsdk.a.J) {
            S();
        }
        YF = false;
        YF = false;
        com.baidu.crabsdk.c.a.v("anr watch thread is over!");
    }
}
