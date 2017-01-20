package com.baidu.adp.widget.ScrollView;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private g BC;
    private int BN;
    private int BO;
    private WeakReference<View> BT;
    private int BA = 10;
    private boolean BP = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable BU = new f(this);

    public e(int i, int i2, int i3) {
        this.BN = 10;
        float abs = Math.abs(i - i2) / this.BA;
        this.BO = i2;
        this.BN = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.BC = gVar;
    }

    public void r(View view) {
        this.BP = false;
        this.BT = new WeakReference<>(view);
        this.handler.post(this.BU);
    }
}
