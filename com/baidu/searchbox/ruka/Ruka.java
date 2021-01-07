package com.baidu.searchbox.ruka;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class Ruka {
    private static final int DEFAULT_BLOCK_THRESHOLD = 2000;
    private static long sProcessLaunchTime = System.currentTimeMillis();
    private static volatile AtomicBoolean sANRInited = new AtomicBoolean(false);
    private static volatile AtomicBoolean sLooperInited = new AtomicBoolean(false);
    private static volatile AtomicBoolean sIsStartTrack = new AtomicBoolean(false);

    public static void startLooperMonitor(Context context, int i) {
        if (AppConfig.isDebug()) {
            Log.d("Ruka", "iLooperMonitor = " + LooperProvider.getLooperMonitor().getClass().getSimpleName());
        }
        if (LooperProvider.getLooperMonitor() == LooperProvider.EMPTY) {
            if (AppConfig.isDebug()) {
                Log.d("Ruka", "iLooperMonitor = LooperProvider.EMPTY");
            }
        } else if (!sLooperInited.get() && LooperProvider.getLooperMonitor().enableMonitor()) {
            sLooperInited.set(true);
            LooperProvider.getLooperMonitor().startLooperMonitor(context, i);
            startTrack(context);
        }
    }

    public static void startLooperMonitor(Context context) {
        startLooperMonitor(context, 2000);
    }

    public static void stopLooperMonitor() {
        LooperProvider.getLooperMonitor().stopLooperMonitor();
    }

    public static void startAnrMonitor(Context context) {
        if (AppConfig.isDebug()) {
            Log.d("Ruka", "IANRMonitor = " + ANRProvider.getANRMonitor().getClass().getSimpleName());
        }
        if (ANRProvider.getANRMonitor() == ANRProvider.EMPTY) {
            if (AppConfig.isDebug()) {
                Log.d("Ruka", "IANRMonitor = ANRProvider.EMPTY");
            }
        } else if (!sANRInited.get() && ANRProvider.getANRMonitor().enableMonitor()) {
            sANRInited.set(true);
            ANRProvider.getANRMonitor().startANRMonitor();
            startTrack(context);
        }
    }

    public static void stopAnrMonitor() {
        ANRProvider.getANRMonitor().stopANRMonitor();
    }

    private static void startTrack(Context context) {
        if (!sIsStartTrack.getAndSet(true)) {
            Track.getInstance().startTrack(context);
        }
    }

    public static long getProcessLaunchTime() {
        return sProcessLaunchTime;
    }

    public static void setProcessLaunchTime(long j) {
        sProcessLaunchTime = j;
    }

    public static boolean isLooperMonitorStarted() {
        return LooperProvider.getLooperMonitor().isMonitorStarted();
    }
}
