package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dwy = null;
    private GameRecorderController dtp;
    private boolean dwz;

    private d() {
    }

    public static d aOZ() {
        if (dwy == null) {
            synchronized (d.class) {
                if (dwy == null) {
                    dwy = new d();
                }
            }
        }
        return dwy;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.dtp != null && this.dtp != gameRecorderController) {
            this.dtp.release();
        }
        this.dtp = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aPa() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.dtp);
        }
        return this.dtp == null ? GameRecorderController.aOY() : this.dtp;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.dtp != null && this.dtp == gameRecorderController) {
            this.dtp.release();
            this.dtp = null;
        }
    }

    public boolean aPb() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dwz);
        }
        return this.dwz;
    }

    public void aPc() {
        this.dwz = true;
    }

    public void aPd() {
        this.dwz = false;
    }
}
