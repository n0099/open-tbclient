package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes3.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dyz = null;
    private GameRecorderController dvr;
    private boolean dyA;

    private d() {
    }

    public static d aPK() {
        if (dyz == null) {
            synchronized (d.class) {
                if (dyz == null) {
                    dyz = new d();
                }
            }
        }
        return dyz;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.dvr != null && this.dvr != gameRecorderController) {
            this.dvr.release();
        }
        this.dvr = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aPL() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.dvr);
        }
        return this.dvr == null ? GameRecorderController.aPJ() : this.dvr;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.dvr != null && this.dvr == gameRecorderController) {
            this.dvr.release();
            this.dvr = null;
        }
    }

    public boolean aPM() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dyA);
        }
        return this.dyA;
    }

    public void aPN() {
        this.dyA = true;
    }

    public void aPO() {
        this.dyA = false;
    }
}
