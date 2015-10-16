package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g If;
    private int Ir;
    private int Is;
    private int Id = 5;
    private boolean It = false;

    public b(int i, int i2, int i3) {
        this.Ir = 10;
        float abs = Math.abs(i - i2) / this.Id;
        this.Is = i2;
        this.Ir = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.If = gVar;
    }

    public void h(View view) {
        this.It = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Ir);
    }
}
