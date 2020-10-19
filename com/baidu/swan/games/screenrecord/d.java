package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dKA = null;
    private GameRecorderController dHs;
    private boolean dKB;

    private d() {
    }

    public static d aSt() {
        if (dKA == null) {
            synchronized (d.class) {
                if (dKA == null) {
                    dKA = new d();
                }
            }
        }
        return dKA;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.dHs != null && this.dHs != gameRecorderController) {
            this.dHs.release();
        }
        this.dHs = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aSu() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.dHs);
        }
        return this.dHs == null ? GameRecorderController.aSs() : this.dHs;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.dHs != null && this.dHs == gameRecorderController) {
            this.dHs.release();
            this.dHs = null;
        }
    }

    public boolean aSv() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dKB);
        }
        return this.dKB;
    }

    public void aSw() {
        this.dKB = true;
    }

    public void aSx() {
        this.dKB = false;
    }
}
