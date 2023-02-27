package com.baidu.searchbox.block.impl;
/* loaded from: classes2.dex */
public class BlockMonitor_Factory {
    public static volatile BlockMonitor instance;

    public static synchronized BlockMonitor get() {
        BlockMonitor blockMonitor;
        synchronized (BlockMonitor_Factory.class) {
            if (instance == null) {
                instance = new BlockMonitor();
            }
            blockMonitor = instance;
        }
        return blockMonitor;
    }
}
