package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    boolean cwE;
    long dqR;
    private WeakReference<Bitmap> dqT;
    boolean dqU;
    String id;
    Rect rect;
    String url;
    int dqS = 0;
    long startTime = System.currentTimeMillis();
    int dqQ = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.dqR = j;
        this.dqU = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aGj() {
        if (this.dqR > 0) {
            this.dqR -= System.currentTimeMillis() - this.startTime;
        }
        return this.dqR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.dqR > 0) {
            this.dqR -= System.currentTimeMillis() - this.startTime;
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.dqR + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aGk() {
        this.dqQ = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aGl() {
        this.dqQ = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.dqQ == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Bitmap bitmap) {
        this.dqT = new WeakReference<>(bitmap);
    }
}
