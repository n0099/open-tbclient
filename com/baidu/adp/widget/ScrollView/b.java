package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private int xW;
    private int xX;
    private g xv;
    private int xt = 5;
    private boolean xY = false;

    public b(int i, int i2, int i3) {
        this.xW = 10;
        float abs = Math.abs(i - i2) / this.xt;
        this.xX = i2;
        this.xW = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.xv = gVar;
    }

    public void g(View view) {
        this.xY = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.xW);
    }
}
