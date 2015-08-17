package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g Ie;
    private int Iq;
    private int Ir;
    private int Ic = 5;
    private boolean Is = false;

    public b(int i, int i2, int i3) {
        this.Iq = 10;
        float abs = Math.abs(i - i2) / this.Ic;
        this.Ir = i2;
        this.Iq = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ie = gVar;
    }

    public void h(View view) {
        this.Is = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Iq);
    }
}
