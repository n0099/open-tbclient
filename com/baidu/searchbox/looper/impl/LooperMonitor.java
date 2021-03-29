package com.baidu.searchbox.looper.impl;

import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import d.f.b.a.b;
import d.f.b.a.c;
import d.f.b.a.d;
@Singleton
@Service
/* loaded from: classes2.dex */
public class LooperMonitor implements ILooperMonitor {
    public static volatile boolean sIsStartTrack = false;
    public static LooperContextDispatcher sLooperContextDispatcher;
    public c mBlockCanaryCore;
    public boolean mMonitorStarted = false;

    private void startLooperPrint() {
        if (this.mMonitorStarted) {
            return;
        }
        this.mMonitorStarted = true;
        sLooperContextDispatcher.addLooperPrinter(this.mBlockCanaryCore.h());
    }

    public static void startTrack(Context context) {
        if (sIsStartTrack) {
            return;
        }
        sIsStartTrack = true;
        Track.getInstance().startTrack(context);
    }

    public void addBlockInterceptor(d dVar) {
        if (dVar != null) {
            this.mBlockCanaryCore.b(dVar);
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
    public void startLooperMonitor(Context context, int i) {
        if (sLooperContextDispatcher == null) {
            sLooperContextDispatcher = new LooperContextDispatcher();
        }
        b.init(context, sLooperContextDispatcher, i);
        c.l(b.get());
        c f2 = c.f();
        this.mBlockCanaryCore = f2;
        f2.b(b.get());
        startLooperPrint();
        startTrack(context);
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
}
