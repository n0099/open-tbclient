package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g Ig;
    private int Is;
    private int It;
    private WeakReference<View> Iy;
    private int Ie = 10;
    private boolean Iu = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable Iz = new f(this);

    public e(int i, int i2, int i3) {
        this.Is = 10;
        float abs = Math.abs(i - i2) / this.Ie;
        this.It = i2;
        this.Is = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ig = gVar;
    }

    public void h(View view) {
        this.Iu = false;
        this.Iy = new WeakReference<>(view);
        this.handler.post(this.Iz);
    }
}
