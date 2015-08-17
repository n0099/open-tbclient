package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g Ie;
    private int Iq;
    private int Ir;
    private WeakReference<View> Iw;
    private int Ic = 10;
    private boolean Is = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable Ix = new f(this);

    public e(int i, int i2, int i3) {
        this.Iq = 10;
        float abs = Math.abs(i - i2) / this.Ic;
        this.Ir = i2;
        this.Iq = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ie = gVar;
    }

    public void h(View view) {
        this.Is = false;
        this.Iw = new WeakReference<>(view);
        this.handler.post(this.Ix);
    }
}
