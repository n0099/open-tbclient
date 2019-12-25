package com.baidu.swan.apps.ac;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class d {
    boolean bAM;
    long bAO;
    private WeakReference<Bitmap> bAQ;
    String id;
    boolean isFirstPage;
    Rect rect;
    String url;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    int bAP = 0;
    long startTime = System.currentTimeMillis();
    int bAN = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.bAO = j;
        this.isFirstPage = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long VS() {
        if (this.bAO > 0) {
            this.bAO -= System.currentTimeMillis() - this.startTime;
        }
        return this.bAO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.bAO > 0) {
            this.bAO -= System.currentTimeMillis() - this.startTime;
            if (DEBUG) {
                Log.d(TAG, "pause, left " + this.bAO + "ms");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void VT() {
        this.bAN = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void VU() {
        this.bAN = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.bAN == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Bitmap bitmap) {
        this.bAQ = new WeakReference<>(bitmap);
    }
}
