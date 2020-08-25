package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    boolean cDZ;
    private WeakReference<Bitmap> cEc;
    boolean cEd;
    String id;
    Rect rect;
    long remainTime;
    String url;
    int cEb = 0;
    long startTime = System.currentTimeMillis();
    int cEa = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.remainTime = j;
        this.cEd = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long auz() {
        if (this.remainTime > 0) {
            this.remainTime -= System.currentTimeMillis() - this.startTime;
        }
        return this.remainTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.remainTime > 0) {
            this.remainTime -= System.currentTimeMillis() - this.startTime;
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.remainTime + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auA() {
        this.cEa = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void auB() {
        this.cEa = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.cEa == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Bitmap bitmap) {
        this.cEc = new WeakReference<>(bitmap);
    }
}
