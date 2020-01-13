package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes10.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d cnI = null;
    private GameRecorderController ckv;
    private boolean cnJ;

    private d() {
    }

    public static d amZ() {
        if (cnI == null) {
            synchronized (d.class) {
                if (cnI == null) {
                    cnI = new d();
                }
            }
        }
        return cnI;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.ckv != null && this.ckv != gameRecorderController) {
            this.ckv.release();
        }
        this.ckv = gameRecorderController;
    }

    @NonNull
    public GameRecorderController ana() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.ckv);
        }
        return this.ckv == null ? GameRecorderController.amY() : this.ckv;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.ckv != null && this.ckv == gameRecorderController) {
            this.ckv.release();
            this.ckv = null;
        }
    }

    public boolean anb() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.cnJ);
        }
        return this.cnJ;
    }

    public void anc() {
        this.cnJ = true;
    }

    public void and() {
        this.cnJ = false;
    }
}
