package com.baidu.swan.games.screenrecord;

import android.util.Log;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d elZ = null;
    private GameRecorderController eiQ;
    private boolean ema;

    private d() {
    }

    public static d aYa() {
        if (elZ == null) {
            synchronized (d.class) {
                if (elZ == null) {
                    elZ = new d();
                }
            }
        }
        return elZ;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.eiQ != null && this.eiQ != gameRecorderController) {
            this.eiQ.release();
        }
        this.eiQ = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aYb() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.eiQ);
        }
        return this.eiQ == null ? GameRecorderController.aXZ() : this.eiQ;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.eiQ != null && this.eiQ == gameRecorderController) {
            this.eiQ.release();
            this.eiQ = null;
        }
    }

    public boolean aYc() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.ema);
        }
        return this.ema;
    }

    public void aYd() {
        this.ema = true;
    }

    public void aYe() {
        this.ema = false;
    }
}
