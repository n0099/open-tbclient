package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {
    private int vU;
    private int vV;
    private h vr;
    private WeakReference<View> wa;
    private int vp = 10;
    private boolean vW = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable wb = new g(this);

    public f(int i, int i2, int i3) {
        this.vU = 10;
        float abs = Math.abs(i - i2) / this.vp;
        this.vV = i2;
        this.vU = (int) (i3 / abs);
    }

    public void a(h hVar) {
        this.vr = hVar;
    }

    public void g(View view) {
        this.vW = false;
        this.wa = new WeakReference<>(view);
        this.handler.post(this.wb);
    }
}
