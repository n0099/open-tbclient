package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dYP = null;
    private GameRecorderController dVH;
    private boolean dYQ;

    private d() {
    }

    public static d aWN() {
        if (dYP == null) {
            synchronized (d.class) {
                if (dYP == null) {
                    dYP = new d();
                }
            }
        }
        return dYP;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.dVH != null && this.dVH != gameRecorderController) {
            this.dVH.release();
        }
        this.dVH = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aWO() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.dVH);
        }
        return this.dVH == null ? GameRecorderController.aWM() : this.dVH;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.dVH != null && this.dVH == gameRecorderController) {
            this.dVH.release();
            this.dVH = null;
        }
    }

    public boolean aWP() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dYQ);
        }
        return this.dYQ;
    }

    public void aWQ() {
        this.dYQ = true;
    }

    public void aWR() {
        this.dYQ = false;
    }
}
