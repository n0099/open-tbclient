package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private int xT;
    private int xU;
    private g xs;
    private int xq = 5;
    private boolean xV = false;

    public b(int i, int i2, int i3) {
        this.xT = 10;
        float abs = Math.abs(i - i2) / this.xq;
        this.xU = i2;
        this.xT = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.xs = gVar;
    }

    public void g(View view) {
        this.xV = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.xT);
    }
}
