package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g Im;
    private int Ix;
    private int Iy;
    private int Ik = 5;
    private boolean Iz = false;

    public b(int i, int i2, int i3) {
        this.Ix = 10;
        float abs = Math.abs(i - i2) / this.Ik;
        this.Iy = i2;
        this.Ix = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Im = gVar;
    }

    public void g(View view) {
        this.Iz = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Ix);
    }
}
