package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private int IE;
    private int IF;
    private g Is;
    private int Iq = 5;
    private boolean IG = false;

    public b(int i, int i2, int i3) {
        this.IE = 10;
        float abs = Math.abs(i - i2) / this.Iq;
        this.IF = i2;
        this.IE = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Is = gVar;
    }

    public void r(View view) {
        this.IG = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.IE);
    }
}
