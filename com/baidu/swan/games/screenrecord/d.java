package com.baidu.swan.games.screenrecord;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d ene = null;
    private GameRecorderController ejU;
    private boolean enf;

    private d() {
    }

    public static d bbE() {
        if (ene == null) {
            synchronized (d.class) {
                if (ene == null) {
                    ene = new d();
                }
            }
        }
        return ene;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.ejU != null && this.ejU != gameRecorderController) {
            this.ejU.release();
        }
        this.ejU = gameRecorderController;
    }

    @NonNull
    public GameRecorderController bbF() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.ejU);
        }
        return this.ejU == null ? GameRecorderController.bbD() : this.ejU;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.ejU != null && this.ejU == gameRecorderController) {
            this.ejU.release();
            this.ejU = null;
        }
    }

    public boolean bbG() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.enf);
        }
        return this.enf;
    }

    public void bbH() {
        this.enf = true;
    }

    public void bbI() {
        this.enf = false;
    }
}
