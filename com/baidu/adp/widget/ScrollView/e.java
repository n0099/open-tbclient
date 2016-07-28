package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g Aa;
    private int An;
    private int Ao;
    private WeakReference<View> At;
    private int zY = 10;
    private boolean Ap = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable Au = new f(this);

    public e(int i, int i2, int i3) {
        this.An = 10;
        float abs = Math.abs(i - i2) / this.zY;
        this.Ao = i2;
        this.An = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Aa = gVar;
    }

    public void t(View view) {
        this.Ap = false;
        this.At = new WeakReference<>(view);
        this.handler.post(this.Au);
    }
}
