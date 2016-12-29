package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private int CC;
    private int CD;
    private WeakReference<View> CI;
    private g Cq;
    private int Co = 10;
    private boolean CE = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable CJ = new f(this);

    public e(int i, int i2, int i3) {
        this.CC = 10;
        float abs = Math.abs(i - i2) / this.Co;
        this.CD = i2;
        this.CC = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Cq = gVar;
    }

    public void t(View view) {
        this.CE = false;
        this.CI = new WeakReference<>(view);
        this.handler.post(this.CJ);
    }
}
