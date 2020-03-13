package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d crM = null;
    private GameRecorderController coB;
    private boolean crN;

    private d() {
    }

    public static d app() {
        if (crM == null) {
            synchronized (d.class) {
                if (crM == null) {
                    crM = new d();
                }
            }
        }
        return crM;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.coB != null && this.coB != gameRecorderController) {
            this.coB.release();
        }
        this.coB = gameRecorderController;
    }

    @NonNull
    public GameRecorderController apq() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.coB);
        }
        return this.coB == null ? GameRecorderController.apo() : this.coB;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.coB != null && this.coB == gameRecorderController) {
            this.coB.release();
            this.coB = null;
        }
    }

    public boolean apr() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.crN);
        }
        return this.crN;
    }

    public void aps() {
        this.crN = true;
    }

    public void apt() {
        this.crN = false;
    }
}
