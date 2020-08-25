package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dwu = null;
    private GameRecorderController dtl;
    private boolean dwv;

    private d() {
    }

    public static d aOZ() {
        if (dwu == null) {
            synchronized (d.class) {
                if (dwu == null) {
                    dwu = new d();
                }
            }
        }
        return dwu;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.dtl != null && this.dtl != gameRecorderController) {
            this.dtl.release();
        }
        this.dtl = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aPa() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.dtl);
        }
        return this.dtl == null ? GameRecorderController.aOY() : this.dtl;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.dtl != null && this.dtl == gameRecorderController) {
            this.dtl.release();
            this.dtl = null;
        }
    }

    public boolean aPb() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dwv);
        }
        return this.dwv;
    }

    public void aPc() {
        this.dwv = true;
    }

    public void aPd() {
        this.dwv = false;
    }
}
