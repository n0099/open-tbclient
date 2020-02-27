package com.baidu.live.tbadk.realAuthen;
/* loaded from: classes3.dex */
public class RealAuthenManager {
    private static RealAuthenManager instance = null;
    private RealAuthen mRealAuthen;

    private RealAuthenManager() {
    }

    public static synchronized RealAuthenManager getInstance() {
        RealAuthenManager realAuthenManager;
        synchronized (RealAuthenManager.class) {
            if (instance == null) {
                instance = new RealAuthenManager();
            }
            realAuthenManager = instance;
        }
        return realAuthenManager;
    }

    public void setRealAuthen(RealAuthen realAuthen) {
        this.mRealAuthen = realAuthen;
    }

    public RealAuthen getRealAuthen() {
        return this.mRealAuthen;
    }
}
