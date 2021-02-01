package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    boolean ctE;
    long don;
    private WeakReference<Bitmap> dop;
    boolean doq;
    String id;
    Rect rect;
    String url;
    int doo = 0;
    long startTime = System.currentTimeMillis();
    int dom = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.don = j;
        this.doq = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aCL() {
        if (this.don > 0) {
            this.don -= System.currentTimeMillis() - this.startTime;
        }
        return this.don;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.don > 0) {
            this.don -= System.currentTimeMillis() - this.startTime;
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.don + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCM() {
        this.dom = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCN() {
        this.dom = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.dom == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Bitmap bitmap) {
        this.dop = new WeakReference<>(bitmap);
    }
}
