package com.baidu.swan.apps.ac;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d {
    private WeakReference<Bitmap> bBC;
    boolean bBz;
    String id;
    boolean isFirstPage;
    Rect rect;
    long remainTime;
    String url;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    int bBB = 0;
    long startTime = System.currentTimeMillis();
    int bBA = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.remainTime = j;
        this.isFirstPage = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long Wp() {
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
    public void Wq() {
        this.bBA = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wr() {
        this.bBA = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.bBA == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Bitmap bitmap) {
        this.bBC = new WeakReference<>(bitmap);
    }
}
