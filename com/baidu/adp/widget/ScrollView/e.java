package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private WeakReference<View> IE;
    private g Im;
    private int Ix;
    private int Iy;
    private int Ik = 10;
    private boolean Iz = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable IF = new f(this);

    public e(int i, int i2, int i3) {
        this.Ix = 10;
        float abs = Math.abs(i - i2) / this.Ik;
        this.Iy = i2;
        this.Ix = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Im = gVar;
    }

    public void g(View view) {
        this.Iz = false;
        this.IE = new WeakReference<>(view);
        this.handler.post(this.IF);
    }
}
