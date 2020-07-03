package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dgG = null;
    private GameRecorderController ddt;
    private boolean dgH;

    private d() {
    }

    public static d aCB() {
        if (dgG == null) {
            synchronized (d.class) {
                if (dgG == null) {
                    dgG = new d();
                }
            }
        }
        return dgG;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.ddt != null && this.ddt != gameRecorderController) {
            this.ddt.release();
        }
        this.ddt = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aCC() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.ddt);
        }
        return this.ddt == null ? GameRecorderController.aCA() : this.ddt;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.ddt != null && this.ddt == gameRecorderController) {
            this.ddt.release();
            this.ddt = null;
        }
    }

    public boolean aCD() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dgH);
        }
        return this.dgH;
    }

    public void aCE() {
        this.dgH = true;
    }

    public void aCF() {
        this.dgH = false;
    }
}
