package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g IQ;
    private int Jc;
    private int Jd;
    private int IO = 5;
    private boolean Je = false;

    public b(int i, int i2, int i3) {
        this.Jc = 10;
        float abs = Math.abs(i - i2) / this.IO;
        this.Jd = i2;
        this.Jc = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.IQ = gVar;
    }

    public void r(View view) {
        this.Je = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Jc);
    }
}
