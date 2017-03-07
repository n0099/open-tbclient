package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g IQ;
    private int Jc;
    private int Jd;
    private WeakReference<View> Ji;
    private int IO = 10;
    private boolean Je = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable Jj = new f(this);

    public e(int i, int i2, int i3) {
        this.Jc = 10;
        float abs = Math.abs(i - i2) / this.IO;
        this.Jd = i2;
        this.Jc = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.IQ = gVar;
    }

    public void r(View view) {
        this.Je = false;
        this.Ji = new WeakReference<>(view);
        this.handler.post(this.Jj);
    }
}
