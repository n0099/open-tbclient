package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private int xT;
    private int xU;
    private WeakReference<View> xZ;
    private g xs;
    private int xq = 10;
    private boolean xV = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable ya = new f(this);

    public e(int i, int i2, int i3) {
        this.xT = 10;
        float abs = Math.abs(i - i2) / this.xq;
        this.xU = i2;
        this.xT = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.xs = gVar;
    }

    public void g(View view) {
        this.xV = false;
        this.xZ = new WeakReference<>(view);
        this.handler.post(this.ya);
    }
}
