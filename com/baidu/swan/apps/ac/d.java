package com.baidu.swan.apps.ac;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class d {
    boolean ceB;
    private WeakReference<Bitmap> ceE;
    boolean ceF;
    String id;
    Rect rect;
    long remainTime;
    String url;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    int ceD = 0;
    long startTime = System.currentTimeMillis();
    int ceC = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.remainTime = j;
        this.ceF = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long agO() {
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
                Log.d(TAG, "pause, left " + this.remainTime + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void agP() {
        this.ceC = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void agQ() {
        this.ceC = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.ceC == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Bitmap bitmap) {
        this.ceE = new WeakReference<>(bitmap);
    }
}
