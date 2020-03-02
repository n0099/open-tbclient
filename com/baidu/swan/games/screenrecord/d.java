package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d crL = null;
    private GameRecorderController coA;
    private boolean crM;

    private d() {
    }

    public static d app() {
        if (crL == null) {
            synchronized (d.class) {
                if (crL == null) {
                    crL = new d();
                }
            }
        }
        return crL;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.coA != null && this.coA != gameRecorderController) {
            this.coA.release();
        }
        this.coA = gameRecorderController;
    }

    @NonNull
    public GameRecorderController apq() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.coA);
        }
        return this.coA == null ? GameRecorderController.apo() : this.coA;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.coA != null && this.coA == gameRecorderController) {
            this.coA.release();
            this.coA = null;
        }
    }

    public boolean apr() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.crM);
        }
        return this.crM;
    }

    public void aps() {
        this.crM = true;
    }

    public void apt() {
        this.crM = false;
    }
}
