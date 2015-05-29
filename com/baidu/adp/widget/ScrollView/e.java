package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g Ic;
    private int In;
    private int Io;
    private WeakReference<View> It;
    private int Ia = 10;
    private boolean Ip = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable Iu = new f(this);

    public e(int i, int i2, int i3) {
        this.In = 10;
        float abs = Math.abs(i - i2) / this.Ia;
        this.Io = i2;
        this.In = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ic = gVar;
    }

    public void g(View view) {
        this.Ip = false;
        this.It = new WeakReference<>(view);
        this.handler.post(this.Iu);
    }
}
