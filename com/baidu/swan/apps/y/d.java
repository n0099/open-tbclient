package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    Rect bHi;
    boolean cpz;
    long dlS;
    private WeakReference<Bitmap> dlU;
    boolean dlV;
    String id;
    String url;
    int dlT = 0;
    long startTime = System.currentTimeMillis();
    int dlR = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.dlS = j;
        this.dlV = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aEO() {
        if (this.dlS > 0) {
            this.dlS -= System.currentTimeMillis() - this.startTime;
        }
        return this.dlS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.dlS > 0) {
            this.dlS -= System.currentTimeMillis() - this.startTime;
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.dlS + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEP() {
        this.dlR = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aEQ() {
        this.dlR = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.dlR == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Bitmap bitmap) {
        this.dlU = new WeakReference<>(bitmap);
    }
}
