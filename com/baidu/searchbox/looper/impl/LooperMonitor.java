package com.baidu.searchbox.looper.impl;

import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import com.baidu.tieba.c3c;
import com.baidu.tieba.d3c;
import com.baidu.tieba.e3c;
@Singleton
@Service
/* loaded from: classes4.dex */
public class LooperMonitor implements ILooperMonitor {
    public static volatile boolean sIsStartTrack;
    public static LooperContextDispatcher sLooperContextDispatcher;
    public d3c mBlockCanaryCore;
    public boolean mMonitorStarted = false;

    private void startLooperPrint() {
        if (!this.mMonitorStarted) {
            this.mMonitorStarted = true;
            sLooperContextDispatcher.addLooperPrinter(this.mBlockCanaryCore.h());
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public boolean enableMonitor() {
        return LooperRuntime.getInstance().enableLooper();
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public boolean isMonitorStarted() {
        return this.mMonitorStarted;
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public void stopLooperMonitor() {
        if (this.mMonitorStarted) {
            this.mMonitorStarted = false;
            sLooperContextDispatcher.removeLooperPrinter(this.mBlockCanaryCore.h());
            this.mBlockCanaryCore.k().d();
            this.mBlockCanaryCore.e().d();
        }
    }

    public static void startTrack(Context context) {
        if (!sIsStartTrack) {
            sIsStartTrack = true;
            Track.getInstance().startTrack(context);
        }
    }

    public void addBlockInterceptor(e3c e3cVar) {
        if (e3cVar != null) {
            this.mBlockCanaryCore.b(e3cVar);
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public void startLooperMonitor(Context context, int i) {
        if (sLooperContextDispatcher == null) {
            sLooperContextDispatcher = new LooperContextDispatcher();
        }
        c3c.init(context, sLooperContextDispatcher, i);
        d3c.l(c3c.get());
        d3c f = d3c.f();
        this.mBlockCanaryCore = f;
        f.b(c3c.get());
        startLooperPrint();
        startTrack(context);
    }
}
