package com.baidu.searchbox.suspensionball.impl;
/* loaded from: classes5.dex */
public class SuspensionBallInfoImpl_Factory {
    private static volatile SuspensionBallInfoImpl instance;

    private SuspensionBallInfoImpl_Factory() {
    }

    public static synchronized SuspensionBallInfoImpl get() {
        SuspensionBallInfoImpl suspensionBallInfoImpl;
        synchronized (SuspensionBallInfoImpl_Factory.class) {
            if (instance == null) {
                instance = new SuspensionBallInfoImpl();
            }
            suspensionBallInfoImpl = instance;
        }
        return suspensionBallInfoImpl;
    }
}
