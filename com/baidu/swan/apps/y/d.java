package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    boolean cvg;
    long dpQ;
    private WeakReference<Bitmap> dpS;
    boolean dpT;
    String id;
    Rect rect;
    String url;
    int dpR = 0;
    long startTime = System.currentTimeMillis();
    int dpP = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.dpQ = j;
        this.dpT = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long aCO() {
        if (this.dpQ > 0) {
            this.dpQ -= System.currentTimeMillis() - this.startTime;
        }
        return this.dpQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.dpQ > 0) {
            this.dpQ -= System.currentTimeMillis() - this.startTime;
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "pause, left " + this.dpQ + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCP() {
        this.dpP = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aCQ() {
        this.dpP = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.dpP == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Bitmap bitmap) {
        this.dpS = new WeakReference<>(bitmap);
    }
}
