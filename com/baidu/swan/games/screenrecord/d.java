package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes7.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dmp = null;
    private GameRecorderController dje;
    private boolean dmq;

    private d() {
    }

    public static d aGi() {
        if (dmp == null) {
            synchronized (d.class) {
                if (dmp == null) {
                    dmp = new d();
                }
            }
        }
        return dmp;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.dje != null && this.dje != gameRecorderController) {
            this.dje.release();
        }
        this.dje = gameRecorderController;
    }

    @NonNull
    public GameRecorderController aGj() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.dje);
        }
        return this.dje == null ? GameRecorderController.aGh() : this.dje;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.dje != null && this.dje == gameRecorderController) {
            this.dje.release();
            this.dje = null;
        }
    }

    public boolean aGk() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.dmq);
        }
        return this.dmq;
    }

    public void aGl() {
        this.dmq = true;
    }

    public void aGm() {
        this.dmq = false;
    }
}
