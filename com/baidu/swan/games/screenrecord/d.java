package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes25.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d eeg = null;
    private GameRecorderController eaX;
    private boolean eeh;

    private d() {
    }

    public static d aZk() {
        if (eeg == null) {
            synchronized (d.class) {
                if (eeg == null) {
                    eeg = new d();
                }
            }
        }
        return eeg;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.eaX != null && this.eaX != gameRecorderController) {
            this.eaX.release();
        }
        this.eaX = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aZl() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.eaX);
        }
        return this.eaX == null ? GameRecorderController.aZj() : this.eaX;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.eaX != null && this.eaX == gameRecorderController) {
            this.eaX.release();
            this.eaX = null;
        }
    }

    public boolean aZm() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.eeh);
        }
        return this.eeh;
    }

    public void aZn() {
        this.eeh = true;
    }

    public void aZo() {
        this.eeh = false;
    }
}
