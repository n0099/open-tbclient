package com.baidu.searchbox.looper.impl;

import android.content.Context;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import com.github.a.a.b;
import com.github.a.a.c;
import com.github.a.a.d;
/* loaded from: classes6.dex */
public class LooperMonitor implements ILooperMonitor {
    private static volatile boolean sIsStartTrack = false;
    private static LooperContextDispatcher sLooperContextDispatcher;
    private c mBlockCanaryCore;
    private boolean mMonitorStarted = false;

    public static void startTrack(Context context) {
        if (!sIsStartTrack) {
            sIsStartTrack = true;
            Track.getInstance().startTrack(context);
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public boolean enableMonitor() {
        return LooperRuntime.getInstance().enableLooper();
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public void startLooperMonitor(Context context, int i) {
        if (sLooperContextDispatcher == null) {
            sLooperContextDispatcher = new LooperContextDispatcher();
        }
        b.init(context, sLooperContextDispatcher, i);
        c.a(b.get());
        this.mBlockCanaryCore = c.eyg();
        this.mBlockCanaryCore.addBlockInterceptor(b.get());
        startLooperPrint();
        startTrack(context);
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public void stopLooperMonitor() {
        if (this.mMonitorStarted) {
            this.mMonitorStarted = false;
            sLooperContextDispatcher.removeLooperPrinter(this.mBlockCanaryCore.eyd());
            this.mBlockCanaryCore.eye().stop();
            this.mBlockCanaryCore.eyf().stop();
        }
    }

    private void startLooperPrint() {
        if (!this.mMonitorStarted) {
            this.mMonitorStarted = true;
            sLooperContextDispatcher.addLooperPrinter(this.mBlockCanaryCore.eyd());
        }
    }

    public void addBlockInterceptor(d dVar) {
        if (dVar != null) {
            this.mBlockCanaryCore.addBlockInterceptor(dVar);
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public boolean isMonitorStarted() {
        return this.mMonitorStarted;
    }
}
