package com.baidu.searchbox.ruka;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
import com.baidu.searchbox.ruka.ioc.IBlockMonitor;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class Ruka {
    public static final int DEFAULT_BLOCK_THRESHOLD = 2000;
    public static long sProcessLaunchTime = System.currentTimeMillis();
    public static volatile AtomicBoolean sANRInited = new AtomicBoolean(false);
    public static volatile AtomicBoolean sLooperInited = new AtomicBoolean(false);
    public static volatile AtomicBoolean sBlockInited = new AtomicBoolean(false);
    public static volatile AtomicBoolean sIsStartTrack = new AtomicBoolean(false);
    public static int sLineMappingMode = -1;

    public static int getLineMappingMode() {
        return sLineMappingMode;
    }

    public static long getProcessLaunchTime() {
        return sProcessLaunchTime;
    }

    public static boolean isLooperMonitorStarted() {
        return LooperProvider.getLooperMonitor().isMonitorStarted();
    }

    public static void stopAnrMonitor() {
        ANRProvider.getANRMonitor().stopANRMonitor();
    }

    public static void stopBlockMonitor() {
        BlockProvider.getBlockMonitor().stopBlockMonitor();
    }

    public static void stopLooperMonitor() {
        LooperProvider.getLooperMonitor().stopLooperMonitor();
    }

    public static void setLineMappingMode(int i) {
        if (i >= 0) {
            sLineMappingMode = i;
        }
    }

    public static void setProcessLaunchTime(long j) {
        sProcessLaunchTime = j;
    }

    public static void startBlockMonitor(Context context) {
        startBlockMonitor(context, 2000);
    }

    public static void startLooperMonitor(Context context) {
        startLooperMonitor(context, 2000);
    }

    public static void startTrack(Context context) {
        if (!sIsStartTrack.getAndSet(true)) {
            Track.getInstance().startTrack(context);
        }
    }

    public static void startAnrMonitor(Context context) {
        if (AppConfig.isDebug()) {
            IANRMonitor aNRMonitor = ANRProvider.getANRMonitor();
            Log.d(BlockMonitor.TAG, "IANRMonitor = " + aNRMonitor.getClass().getSimpleName());
        }
        if (ANRProvider.getANRMonitor() == ANRProvider.EMPTY) {
            if (AppConfig.isDebug()) {
                Log.d(BlockMonitor.TAG, "IANRMonitor = ANRProvider.EMPTY");
            }
        } else if (!sANRInited.get() && ANRProvider.getANRMonitor().enableMonitor()) {
            sANRInited.set(true);
            ANRProvider.getANRMonitor().startANRMonitor();
            startTrack(context);
        }
    }

    public static void startBlockMonitor(Context context, int i) {
        if (AppConfig.isDebug()) {
            IBlockMonitor blockMonitor = BlockProvider.getBlockMonitor();
            Log.d(BlockMonitor.TAG, "iBlockMonitor = " + blockMonitor.getClass().getSimpleName());
        }
        if (BlockProvider.getBlockMonitor() == BlockProvider.EMPTY) {
            if (AppConfig.isDebug()) {
                Log.d(BlockMonitor.TAG, "iBlockMonitor = BlockProvider.EMPTY");
            }
        } else if (!sBlockInited.get() && BlockProvider.getBlockMonitor().enableMonitor()) {
            sBlockInited.set(true);
            BlockProvider.getBlockMonitor().startBlockMonitor(i);
            startTrack(context);
        }
    }

    public static void startLooperMonitor(Context context, int i) {
        if (AppConfig.isDebug()) {
            ILooperMonitor looperMonitor = LooperProvider.getLooperMonitor();
            Log.d(BlockMonitor.TAG, "iLooperMonitor = " + looperMonitor.getClass().getSimpleName());
        }
        if (LooperProvider.getLooperMonitor() == LooperProvider.EMPTY) {
            if (AppConfig.isDebug()) {
                Log.d(BlockMonitor.TAG, "iLooperMonitor = LooperProvider.EMPTY");
            }
        } else if (!sLooperInited.get() && LooperProvider.getLooperMonitor().enableMonitor()) {
            sLooperInited.set(true);
            LooperProvider.getLooperMonitor().startLooperMonitor(context, i);
            startTrack(context);
        }
    }
}
