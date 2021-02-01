package com.baidu.live.tbadk.ar;

import com.baidu.live.tbadk.ar.interfaces.ArSoStatusChecker;
/* loaded from: classes11.dex */
public class ArSoCheckerManager {
    private static ArSoCheckerManager instance = null;
    private ArSoStatusChecker mArSoStatusChecker;

    private ArSoCheckerManager() {
    }

    public static synchronized ArSoCheckerManager getInstance() {
        ArSoCheckerManager arSoCheckerManager;
        synchronized (ArSoCheckerManager.class) {
            if (instance == null) {
                instance = new ArSoCheckerManager();
            }
            arSoCheckerManager = instance;
        }
        return arSoCheckerManager;
    }

    public void setArSoStatusChecker(ArSoStatusChecker arSoStatusChecker) {
        this.mArSoStatusChecker = arSoStatusChecker;
    }

    public ArSoStatusChecker getArSoStatusChecker() {
        return this.mArSoStatusChecker;
    }
}
