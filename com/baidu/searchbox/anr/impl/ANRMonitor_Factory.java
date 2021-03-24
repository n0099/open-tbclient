package com.baidu.searchbox.anr.impl;
/* loaded from: classes2.dex */
public class ANRMonitor_Factory {
    public static volatile ANRMonitor instance;

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
