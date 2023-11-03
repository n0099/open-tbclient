package com.baidu.searchbox.block.impl;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.aperf.param.ThreadCollector;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IBlockMonitor;
import com.baidu.tieba.y2c;
import com.github.anrwatchdog.ANRError;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
@Singleton
@Service
/* loaded from: classes3.dex */
public class BlockMonitor implements IBlockMonitor {
    public static final int DEFAULT_BLOCK_TIMEOUT = 2000;
    public static final String SEPARATOR = "\r\n";
    public static final String TAG = "Ruka";
    public static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sBlockTimeStamp;
    public boolean mMonitorStarted = false;
    public y2c mBlockWatchDog = null;

    /* loaded from: classes3.dex */
    public static class BlockListenerImpl implements y2c.f {
        public BlockListenerImpl() {
        }

        @Override // com.baidu.tieba.y2c.f
        public void onAppNotResponding(ANRError aNRError) {
            Log.d(BlockMonitor.TAG, "BlockWatchDog catch block", aNRError);
            BlockMonitor.collectData(aNRError.getSTStackMap());
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
    public boolean enableMonitor() {
        return BlockRuntime.getInstance().enableBlock();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
    public void stopBlockMonitor() {
        y2c y2cVar;
        if (this.mMonitorStarted && (y2cVar = this.mBlockWatchDog) != null) {
            y2cVar.interrupt();
            this.mMonitorStarted = false;
        }
    }

    public static void collectData(LinkedHashMap<Long, StackTraceElement[]> linkedHashMap) {
        if (AppRuntime.getAppContext() == null) {
            return;
        }
        sBlockTimeStamp = String.valueOf(System.currentTimeMillis());
        String str = null;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            str = getThreadStackEntries(linkedHashMap);
        }
        if (TextUtils.isEmpty(str)) {
            str = ThreadCollector.getMainThreadStackTrace();
        }
        BlockContext.getBlockContext().onAppBlock(AppRuntime.getAppContext(), new BlockInfo(sBlockTimeStamp, str));
    }

    public static String getThreadStackEntries(LinkedHashMap<Long, StackTraceElement[]> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        for (Long l : linkedHashMap.keySet()) {
            sb.append(TIME_FORMATTER.format(l));
            sb.append("\r\n");
            sb.append(stack2String(linkedHashMap.get(l)));
            sb.append("\r\n");
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public static String stack2String(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        if (stackTraceElementArr != null) {
            try {
                if (stackTraceElementArr.length >= 1) {
                    for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                        sb.append(stackTraceElement.toString() + "\r\n");
                    }
                }
            } catch (Exception e) {
                Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e);
            }
        }
        return sb.toString();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
    public void startBlockMonitor(int i) {
        if (this.mMonitorStarted) {
            return;
        }
        this.mMonitorStarted = true;
        y2c y2cVar = new y2c(i);
        this.mBlockWatchDog = y2cVar;
        y2cVar.e();
        this.mBlockWatchDog.d(true);
        this.mBlockWatchDog.c(new BlockListenerImpl());
        if (AppConfig.isDebug()) {
            Log.d(TAG, "start mBlockWatchDog = " + this.mBlockWatchDog.getName() + " Monitor");
        }
        this.mBlockWatchDog.start();
    }
}
