package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private WeakReference<View> IB;
    private g Ik;
    private int Iv;
    private int Iw;
    private int Ii = 10;
    private boolean Ix = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable IC = new f(this);

    public e(int i, int i2, int i3) {
        this.Iv = 10;
        float abs = Math.abs(i - i2) / this.Ii;
        this.Iw = i2;
        this.Iv = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ik = gVar;
    }

    public void g(View view) {
        this.Ix = false;
        this.IB = new WeakReference<>(view);
        this.handler.post(this.IC);
    }
}
