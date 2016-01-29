package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g Je;
    private int Jq;
    private int Jr;
    private WeakReference<View> Jw;
    private int Jc = 10;
    private boolean Js = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable Jx = new f(this);

    public e(int i, int i2, int i3) {
        this.Jq = 10;
        float abs = Math.abs(i - i2) / this.Jc;
        this.Jr = i2;
        this.Jq = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Je = gVar;
    }

    public void t(View view) {
        this.Js = false;
        this.Jw = new WeakReference<>(view);
        this.handler.post(this.Jx);
    }
}
