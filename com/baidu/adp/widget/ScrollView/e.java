package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g If;
    private int Ir;
    private int Is;
    private WeakReference<View> Ix;
    private int Id = 10;
    private boolean It = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable Iy = new f(this);

    public e(int i, int i2, int i3) {
        this.Ir = 10;
        float abs = Math.abs(i - i2) / this.Id;
        this.Is = i2;
        this.Ir = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.If = gVar;
    }

    public void h(View view) {
        this.It = false;
        this.Ix = new WeakReference<>(view);
        this.handler.post(this.Iy);
    }
}
