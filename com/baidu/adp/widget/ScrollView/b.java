package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g Ik;
    private int Iv;
    private int Iw;
    private int Ii = 5;
    private boolean Ix = false;

    public b(int i, int i2, int i3) {
        this.Iv = 10;
        float abs = Math.abs(i - i2) / this.Ii;
        this.Iw = i2;
        this.Iv = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ik = gVar;
    }

    public void g(View view) {
        this.Ix = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Iv);
    }
}
