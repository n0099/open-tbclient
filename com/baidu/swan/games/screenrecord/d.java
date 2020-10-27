package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dSX = null;
    private GameRecorderController dPP;
    private boolean dSY;

    private d() {
    }

    public static d aUn() {
        if (dSX == null) {
            synchronized (d.class) {
                if (dSX == null) {
                    dSX = new d();
                }
            }
        }
        return dSX;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.dPP != null && this.dPP != gameRecorderController) {
            this.dPP.release();
        }
        this.dPP = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aUo() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.dPP);
        }
        return this.dPP == null ? GameRecorderController.aUm() : this.dPP;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.dPP != null && this.dPP == gameRecorderController) {
            this.dPP.release();
            this.dPP = null;
        }
    }

    public boolean aUp() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dSY);
        }
        return this.dSY;
    }

    public void aUq() {
        this.dSY = true;
    }

    public void aUr() {
        this.dSY = false;
    }
}
