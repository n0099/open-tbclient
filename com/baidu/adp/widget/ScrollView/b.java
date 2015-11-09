package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g Ig;
    private int Is;
    private int It;
    private int Ie = 5;
    private boolean Iu = false;

    public b(int i, int i2, int i3) {
        this.Is = 10;
        float abs = Math.abs(i - i2) / this.Ie;
        this.It = i2;
        this.Is = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ig = gVar;
    }

    public void h(View view) {
        this.Iu = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Is);
    }
}
