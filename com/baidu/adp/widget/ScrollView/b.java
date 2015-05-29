package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g Ic;
    private int In;
    private int Io;
    private int Ia = 5;
    private boolean Ip = false;

    public b(int i, int i2, int i3) {
        this.In = 10;
        float abs = Math.abs(i - i2) / this.Ia;
        this.Io = i2;
        this.In = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ic = gVar;
    }

    public void g(View view) {
        this.Ip = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.In);
    }
}
