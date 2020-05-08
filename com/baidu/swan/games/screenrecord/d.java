package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d cQX = null;
    private GameRecorderController cNO;
    private boolean cQY;

    private d() {
    }

    public static d axE() {
        if (cQX == null) {
            synchronized (d.class) {
                if (cQX == null) {
                    cQX = new d();
                }
            }
        }
        return cQX;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.cNO != null && this.cNO != gameRecorderController) {
            this.cNO.release();
        }
        this.cNO = gameRecorderController;
    }

    @NonNull
    public GameRecorderController axF() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.cNO);
        }
        return this.cNO == null ? GameRecorderController.axD() : this.cNO;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.cNO != null && this.cNO == gameRecorderController) {
            this.cNO.release();
            this.cNO = null;
        }
    }

    public boolean axG() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.cQY);
        }
        return this.cQY;
    }

    public void axH() {
        this.cQY = true;
    }

    public void axI() {
        this.cQY = false;
    }
}
