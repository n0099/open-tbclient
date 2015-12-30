package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g IO;
    private int Jb;
    private int Jc;
    private WeakReference<View> Jh;
    private int IM = 10;
    private boolean Jd = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable Ji = new f(this);

    public e(int i, int i2, int i3) {
        this.Jb = 10;
        float abs = Math.abs(i - i2) / this.IM;
        this.Jc = i2;
        this.Jb = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.IO = gVar;
    }

    public void h(View view) {
        this.Jd = false;
        this.Jh = new WeakReference<>(view);
        this.handler.post(this.Ji);
    }
}
