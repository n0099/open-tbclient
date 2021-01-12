package com.baidu.searchbox.looper.impl;
/* loaded from: classes6.dex */
public class LooperMonitor_Factory {
    private static volatile LooperMonitor instance;

    private LooperMonitor_Factory() {
    }

    public static synchronized LooperMonitor get() {
        LooperMonitor looperMonitor;
        synchronized (LooperMonitor_Factory.class) {
            if (instance == null) {
                instance = new LooperMonitor();
            }
            looperMonitor = instance;
        }
        return looperMonitor;
    }
}
