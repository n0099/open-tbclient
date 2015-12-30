package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g IO;
    private int Jb;
    private int Jc;
    private int IM = 5;
    private boolean Jd = false;

    public b(int i, int i2, int i3) {
        this.Jb = 10;
        float abs = Math.abs(i - i2) / this.IM;
        this.Jc = i2;
        this.Jb = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.IO = gVar;
    }

    public void h(View view) {
        this.Jd = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Jb);
    }
}
