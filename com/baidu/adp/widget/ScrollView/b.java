package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private int zL;
    private int zM;
    private g zz;
    private int zx = 5;
    private boolean zN = false;

    public b(int i, int i2, int i3) {
        this.zL = 10;
        float abs = Math.abs(i - i2) / this.zx;
        this.zM = i2;
        this.zL = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.zz = gVar;
    }

    public void t(View view) {
        this.zN = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.zL);
    }
}
