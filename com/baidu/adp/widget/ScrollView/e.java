package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private int IB;
    private int IC;
    private WeakReference<View> II;
    private g Iq;
    private int Io = 10;
    private boolean IE = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable IJ = new f(this);

    public e(int i, int i2, int i3) {
        this.IB = 10;
        float abs = Math.abs(i - i2) / this.Io;
        this.IC = i2;
        this.IB = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Iq = gVar;
    }

    public void r(View view) {
        this.IE = false;
        this.II = new WeakReference<>(view);
        this.handler.post(this.IJ);
    }
}
