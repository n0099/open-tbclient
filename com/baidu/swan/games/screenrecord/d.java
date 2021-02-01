package com.baidu.swan.games.screenrecord;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d eky = null;
    private GameRecorderController ehp;
    private boolean ekz;

    private d() {
    }

    public static d aXX() {
        if (eky == null) {
            synchronized (d.class) {
                if (eky == null) {
                    eky = new d();
                }
            }
        }
        return eky;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.ehp != null && this.ehp != gameRecorderController) {
            this.ehp.release();
        }
        this.ehp = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aXY() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.ehp);
        }
        return this.ehp == null ? GameRecorderController.aXW() : this.ehp;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.ehp != null && this.ehp == gameRecorderController) {
            this.ehp.release();
            this.ehp = null;
        }
    }

    public boolean aXZ() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.ekz);
        }
        return this.ekz;
    }

    public void aYa() {
        this.ekz = true;
    }

    public void aYb() {
        this.ekz = false;
    }
}
