package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    Rect bry;
    boolean cGd;
    private WeakReference<Bitmap> cGg;
    boolean cGh;
    String id;
    long remainTime;
    String url;
    int cGf = 0;
    long startTime = System.currentTimeMillis();
    int cGe = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.remainTime = j;
        this.cGh = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long avi() {
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
    public void avj() {
        this.cGe = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void avk() {
        this.cGe = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.cGe == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Bitmap bitmap) {
        this.cGg = new WeakReference<>(bitmap);
    }
}
