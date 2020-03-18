package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d crX = null;
    private GameRecorderController coM;
    private boolean crY;

    private d() {
    }

    public static d aps() {
        if (crX == null) {
            synchronized (d.class) {
                if (crX == null) {
                    crX = new d();
                }
            }
        }
        return crX;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.coM != null && this.coM != gameRecorderController) {
            this.coM.release();
        }
        this.coM = gameRecorderController;
    }

    @NonNull
    public GameRecorderController apt() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.coM);
        }
        return this.coM == null ? GameRecorderController.apr() : this.coM;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.coM != null && this.coM == gameRecorderController) {
            this.coM.release();
            this.coM = null;
        }
    }

    public boolean apu() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.crY);
        }
        return this.crY;
    }

    public void apv() {
        this.crY = true;
    }

    public void apw() {
        this.crY = false;
    }
}
