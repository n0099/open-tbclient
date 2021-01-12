package com.baidu.searchbox.anr.impl;
/* loaded from: classes6.dex */
public class ANRMonitor_Factory {
    private static volatile ANRMonitor instance;

    private ANRMonitor_Factory() {
    }

    public static synchronized ANRMonitor get() {
        ANRMonitor aNRMonitor;
        synchronized (ANRMonitor_Factory.class) {
            if (instance == null) {
                instance = new ANRMonitor();
            }
            aNRMonitor = instance;
        }
        return aNRMonitor;
    }
}
