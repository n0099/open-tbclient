package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g Jk;
    private int Jw;
    private int Jx;
    private int Ji = 5;
    private boolean Jy = false;

    public b(int i, int i2, int i3) {
        this.Jw = 10;
        float abs = Math.abs(i - i2) / this.Ji;
        this.Jx = i2;
        this.Jw = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Jk = gVar;
    }

    public void t(View view) {
        this.Jy = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Jw);
    }
}
