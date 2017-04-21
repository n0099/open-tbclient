package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private int IE;
    private int IF;
    private WeakReference<View> IK;
    private g Is;
    private int Iq = 10;
    private boolean IG = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable IL = new f(this);

    public e(int i, int i2, int i3) {
        this.IE = 10;
        float abs = Math.abs(i - i2) / this.Iq;
        this.IF = i2;
        this.IE = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Is = gVar;
    }

    public void r(View view) {
        this.IG = false;
        this.IK = new WeakReference<>(view);
        this.handler.post(this.IL);
    }
}
