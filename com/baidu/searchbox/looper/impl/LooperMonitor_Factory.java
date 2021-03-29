package com.baidu.searchbox.looper.impl;
/* loaded from: classes2.dex */
public class LooperMonitor_Factory {
    public static volatile LooperMonitor instance;

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
