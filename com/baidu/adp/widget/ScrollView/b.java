package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private int IB;
    private int IC;
    private g Iq;
    private int Io = 5;
    private boolean IE = false;

    public b(int i, int i2, int i3) {
        this.IB = 10;
        float abs = Math.abs(i - i2) / this.Io;
        this.IC = i2;
        this.IB = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Iq = gVar;
    }

    public void r(View view) {
        this.IE = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.IB);
    }
}
