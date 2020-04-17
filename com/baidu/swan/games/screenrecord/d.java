package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d cQS = null;
    private GameRecorderController cNJ;
    private boolean cQT;

    private d() {
    }

    public static d axE() {
        if (cQS == null) {
            synchronized (d.class) {
                if (cQS == null) {
                    cQS = new d();
                }
            }
        }
        return cQS;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.cNJ != null && this.cNJ != gameRecorderController) {
            this.cNJ.release();
        }
        this.cNJ = gameRecorderController;
    }

    @NonNull
    public GameRecorderController axF() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.cNJ);
        }
        return this.cNJ == null ? GameRecorderController.axD() : this.cNJ;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.cNJ != null && this.cNJ == gameRecorderController) {
            this.cNJ.release();
            this.cNJ = null;
        }
    }

    public boolean axG() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.cQT);
        }
        return this.cQT;
    }

    public void axH() {
        this.cQT = true;
    }

    public void axI() {
        this.cQT = false;
    }
}
