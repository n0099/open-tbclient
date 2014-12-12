package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private int xW;
    private int xX;
    private g xv;
    private WeakReference<View> yc;
    private int xt = 10;
    private boolean xY = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable yd = new f(this);

    public e(int i, int i2, int i3) {
        this.xW = 10;
        float abs = Math.abs(i - i2) / this.xt;
        this.xX = i2;
        this.xW = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.xv = gVar;
    }

    public void g(View view) {
        this.xY = false;
        this.yc = new WeakReference<>(view);
        this.handler.post(this.yd);
    }
}
