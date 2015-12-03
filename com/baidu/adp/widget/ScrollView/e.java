package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private int IK;
    private int IL;
    private WeakReference<View> IQ;
    private g Ix;
    private int Iv = 10;
    private boolean IM = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable IR = new f(this);

    public e(int i, int i2, int i3) {
        this.IK = 10;
        float abs = Math.abs(i - i2) / this.Iv;
        this.IL = i2;
        this.IK = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ix = gVar;
    }

    public void h(View view) {
        this.IM = false;
        this.IQ = new WeakReference<>(view);
        this.handler.post(this.IR);
    }
}
