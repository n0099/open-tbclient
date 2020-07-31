package com.baidu.swan.apps.z;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d {
    boolean cwf;
    private WeakReference<Bitmap> cwi;
    boolean cwj;
    String id;
    Rect rect;
    long remainTime;
    String url;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    int cwh = 0;
    long startTime = System.currentTimeMillis();
    int cwg = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, String str2, long j, boolean z) {
        this.id = str;
        this.url = str2;
        this.remainTime = j;
        this.cwj = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long amD() {
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
    public void amE() {
        this.cwg = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void amF() {
        this.cwg = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChecked() {
        return this.cwg == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Bitmap bitmap) {
        this.cwi = new WeakReference<>(bitmap);
    }
}
