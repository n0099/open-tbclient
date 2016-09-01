package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private int CB;
    private int CC;
    private WeakReference<View> CH;
    private g Cp;
    private int Cn = 10;
    private boolean CD = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable CI = new f(this);

    public e(int i, int i2, int i3) {
        this.CB = 10;
        float abs = Math.abs(i - i2) / this.Cn;
        this.CC = i2;
        this.CB = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Cp = gVar;
    }

    public void t(View view) {
        this.CD = false;
        this.CH = new WeakReference<>(view);
        this.handler.post(this.CI);
    }
}
