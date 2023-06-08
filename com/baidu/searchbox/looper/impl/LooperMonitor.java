package com.baidu.searchbox.looper.impl;

import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import com.baidu.tieba.l6b;
import com.baidu.tieba.m6b;
import com.baidu.tieba.n6b;
@Singleton
@Service
/* loaded from: classes4.dex */
public class LooperMonitor implements ILooperMonitor {
    public static volatile boolean sIsStartTrack;
    public static LooperContextDispatcher sLooperContextDispatcher;
    public m6b mBlockCanaryCore;
    public boolean mMonitorStarted = false;

    private void startLooperPrint() {
        if (!this.mMonitorStarted) {
            this.mMonitorStarted = true;
            sLooperContextDispatcher.addLooperPrinter(this.mBlockCanaryCore.g());
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
            sLooperContextDispatcher.removeLooperPrinter(this.mBlockCanaryCore.g());
            this.mBlockCanaryCore.j().d();
            this.mBlockCanaryCore.d().d();
        }
    }

    public static void startTrack(Context context) {
        if (!sIsStartTrack) {
            sIsStartTrack = true;
            Track.getInstance().startTrack(context);
        }
    }

    public void addBlockInterceptor(n6b n6bVar) {
        if (n6bVar != null) {
            this.mBlockCanaryCore.b(n6bVar);
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public void startLooperMonitor(Context context, int i) {
        if (sLooperContextDispatcher == null) {
            sLooperContextDispatcher = new LooperContextDispatcher();
        }
        l6b.init(context, sLooperContextDispatcher, i);
        m6b.k(l6b.get());
        m6b e = m6b.e();
        this.mBlockCanaryCore = e;
        e.b(l6b.get());
        startLooperPrint();
        startTrack(context);
    }
}
