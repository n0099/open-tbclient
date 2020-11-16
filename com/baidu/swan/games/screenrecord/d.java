package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes7.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dXh = null;
    private GameRecorderController dTZ;
    private boolean dXi;

    private d() {
    }

    public static d aWf() {
        if (dXh == null) {
            synchronized (d.class) {
                if (dXh == null) {
                    dXh = new d();
                }
            }
        }
        return dXh;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.dTZ != null && this.dTZ != gameRecorderController) {
            this.dTZ.release();
        }
        this.dTZ = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aWg() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.dTZ);
        }
        return this.dTZ == null ? GameRecorderController.aWe() : this.dTZ;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.dTZ != null && this.dTZ == gameRecorderController) {
            this.dTZ.release();
            this.dTZ = null;
        }
    }

    public boolean aWh() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dXi);
        }
        return this.dXi;
    }

    public void aWi() {
        this.dXi = true;
    }

    public void aWj() {
        this.dXi = false;
    }
}
