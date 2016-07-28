package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g Aa;
    private int An;
    private int Ao;
    private int zY = 5;
    private boolean Ap = false;

    public b(int i, int i2, int i3) {
        this.An = 10;
        float abs = Math.abs(i - i2) / this.zY;
        this.Ao = i2;
        this.An = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Aa = gVar;
    }

    public void t(View view) {
        this.Ap = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.An);
    }
}
