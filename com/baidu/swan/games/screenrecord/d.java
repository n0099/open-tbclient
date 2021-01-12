package com.baidu.swan.games.screenrecord;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d eir = null;
    private GameRecorderController efh;
    private boolean eis;

    private d() {
    }

    public static d aXL() {
        if (eir == null) {
            synchronized (d.class) {
                if (eir == null) {
                    eir = new d();
                }
            }
        }
        return eir;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.efh != null && this.efh != gameRecorderController) {
            this.efh.release();
        }
        this.efh = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aXM() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.efh);
        }
        return this.efh == null ? GameRecorderController.aXK() : this.efh;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.efh != null && this.efh == gameRecorderController) {
            this.efh.release();
            this.efh = null;
        }
    }

    public boolean aXN() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.eis);
        }
        return this.eis;
    }

    public void aXO() {
        this.eis = true;
    }

    public void aXP() {
        this.eis = false;
    }
}
