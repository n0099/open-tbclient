package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private int zL;
    private int zM;
    private WeakReference<View> zR;
    private g zz;
    private int zx = 10;
    private boolean zN = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable zS = new f(this);

    public e(int i, int i2, int i3) {
        this.zL = 10;
        float abs = Math.abs(i - i2) / this.zx;
        this.zM = i2;
        this.zL = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.zz = gVar;
    }

    public void t(View view) {
        this.zN = false;
        this.zR = new WeakReference<>(view);
        this.handler.post(this.zS);
    }
}
