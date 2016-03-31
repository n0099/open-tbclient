package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private WeakReference<View> JC;
    private g Jk;
    private int Jw;
    private int Jx;
    private int Ji = 10;
    private boolean Jy = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable JD = new f(this);

    public e(int i, int i2, int i3) {
        this.Jw = 10;
        float abs = Math.abs(i - i2) / this.Ji;
        this.Jx = i2;
        this.Jw = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Jk = gVar;
    }

    public void t(View view) {
        this.Jy = false;
        this.JC = new WeakReference<>(view);
        this.handler.post(this.JD);
    }
}
