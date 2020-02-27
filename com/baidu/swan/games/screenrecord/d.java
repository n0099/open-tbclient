package com.baidu.swan.games.screenrecord;

import android.support.annotation.NonNull;
import android.util.Log;
/* loaded from: classes11.dex */
public class d {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d crK = null;
    private GameRecorderController coz;
    private boolean crL;

    private d() {
    }

    public static d apn() {
        if (crK == null) {
            synchronized (d.class) {
                if (crK == null) {
                    crK = new d();
                }
            }
        }
        return crK;
    }

    public void g(GameRecorderController gameRecorderController) {
        if (this.coz != null && this.coz != gameRecorderController) {
            this.coz.release();
        }
        this.coz = gameRecorderController;
    }

    @NonNull
    public GameRecorderController apo() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "getRecorderController:" + this.coz);
        }
        return this.coz == null ? GameRecorderController.apm() : this.coz;
    }

    public void h(GameRecorderController gameRecorderController) {
        if (this.coz != null && this.coz == gameRecorderController) {
            this.coz.release();
            this.coz = null;
        }
    }

    public boolean app() {
        if (DEBUG) {
            Log.i("GameRecorderManager", "isGamePause:" + this.crL);
        }
        return this.crL;
    }

    public void apq() {
        this.crL = true;
    }

    public void apr() {
        this.crL = false;
    }
}
