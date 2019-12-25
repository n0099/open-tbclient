package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes9.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d cnv = null;
    private GameRecorderController cki;
    private boolean cnw;

    private d() {
    }

    public static d amG() {
        if (cnv == null) {
            synchronized (d.class) {
                if (cnv == null) {
                    cnv = new d();
                }
            }
        }
        return cnv;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.cki != null && this.cki != gameRecorderController) {
            this.cki.release();
        }
        this.cki = gameRecorderController;
    }

    @NonNull
    public GameRecorderController amH() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.cki);
        }
        return this.cki == null ? GameRecorderController.amF() : this.cki;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.cki != null && this.cki == gameRecorderController) {
            this.cki.release();
            this.cki = null;
        }
    }

    public boolean amI() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.cnw);
        }
        return this.cnw;
    }

    public void amJ() {
        this.cnw = true;
    }

    public void amK() {
        this.cnw = false;
    }
}
