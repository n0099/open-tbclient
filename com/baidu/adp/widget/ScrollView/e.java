package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g zA;
    private int zM;
    private int zN;
    private WeakReference<View> zS;
    private int zy = 10;
    private boolean zO = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable zT = new f(this);

    public e(int i, int i2, int i3) {
        this.zM = 10;
        float abs = Math.abs(i - i2) / this.zy;
        this.zN = i2;
        this.zM = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.zA = gVar;
    }

    public void t(View view) {
        this.zO = false;
        this.zS = new WeakReference<>(view);
        this.handler.post(this.zT);
    }
}
