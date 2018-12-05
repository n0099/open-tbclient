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
    private static boolean Yw = false;
    private final Context Xn;
    private SoftReference<Handler> Yy;
    private final SoftReference<Looper> Yx = new SoftReference<>(Looper.getMainLooper());
    private volatile int by = 0;
    private boolean YA = false;
    private final Runnable YB = new b(this);
    private final int Yz = 3000;

    public a(Context context) {
        this.Xn = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
        com.baidu.crabsdk.c.a.cI("===line.contains(tracesWroteLog)===");
        r0 = com.baidu.crabsdk.sender.d.a(r13.Xn, (java.lang.Throwable) null, false);
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
        com.baidu.crabsdk.sender.f.a(r13.Xn, com.baidu.crabsdk.sender.f.j(r0));
        com.baidu.crabsdk.sender.e.ac();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
        if (com.baidu.crabsdk.sender.e.rx() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b2, code lost:
        com.baidu.crabsdk.c.a.cI("===uploadAnr===");
        com.baidu.crabsdk.sender.h.a(false, r13.Xn);
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
        com.baidu.crabsdk.c.a.cI("===readLog()===");
        if (this.YA) {
            return;
        }
        this.YA = true;
        try {
            com.baidu.crabsdk.c.a.cI("===readingTrace===");
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
        this.YA = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.crabsdk.c.a.cI("***isRunning = " + Yw + "***");
        if (Yw) {
            return;
        }
        Yw = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.cG("AnrWatchThread start!");
        do {
            if (isInterrupted()) {
                break;
            }
            i = this.by;
            if (this.Yx.get() == null) {
                Yw = false;
                break;
            }
            try {
                if (this.Yy == null || this.Yy.get() == null) {
                    this.Yy = new SoftReference<>(new Handler(this.Yx.get()));
                }
                this.Yy.get().post(this.YB);
                Thread.sleep(this.Yz);
                if (!com.baidu.crabsdk.a.I) {
                    Yw = false;
                    com.baidu.crabsdk.c.a.v("anr watch thread is breakdown!");
                    break;
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.cJ("AnrWatchThread Exception: " + e.getMessage());
            }
        } while (this.by != i);
        com.baidu.crabsdk.c.a.cG("onAppNotResponding!");
        if (this.Xn != null && !com.baidu.crabsdk.a.J) {
            S();
        }
        Yw = false;
        Yw = false;
        com.baidu.crabsdk.c.a.v("anr watch thread is over!");
    }
}
