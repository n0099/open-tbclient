package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    boolean crN;
    long dmb;
    private WeakReference<Bitmap> dmd;
    boolean dme;
    String id;
    Rect rect;
    String url;
    int dmc = 0;
    long startTime = System.currentTimeMillis();
    int dma = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.dmb = j;
        this.dme = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aCp() {
        if (this.dmb > 0) {
            this.dmb -= System.currentTimeMillis() - this.startTime;
        }
        return this.dmb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.dmb > 0) {
            this.dmb -= System.currentTimeMillis() - this.startTime;
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.dmb + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCq() {
        this.dma = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCr() {
        this.dma = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.dma == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Bitmap bitmap) {
        this.dmd = new WeakReference<>(bitmap);
    }
}
