package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dbT = null;
    private GameRecorderController cYG;
    private boolean dbU;

    private d() {
    }

    public static d aBv() {
        if (dbT == null) {
            synchronized (d.class) {
                if (dbT == null) {
                    dbT = new d();
                }
            }
        }
        return dbT;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.cYG != null && this.cYG != gameRecorderController) {
            this.cYG.release();
        }
        this.cYG = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aBw() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.cYG);
        }
        return this.cYG == null ? GameRecorderController.aBu() : this.cYG;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.cYG != null && this.cYG == gameRecorderController) {
            this.cYG.release();
            this.cYG = null;
        }
    }

    public boolean aBx() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dbU);
        }
        return this.dbU;
    }

    public void aBy() {
        this.dbU = true;
    }

    public void aBz() {
        this.dbU = false;
    }
}
