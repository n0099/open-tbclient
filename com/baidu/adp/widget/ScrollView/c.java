package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class c {
    private int vU;
    private int vV;
    private h vr;
    private int vp = 5;
    private boolean vW = false;

    public c(int i, int i2, int i3) {
        this.vU = 10;
        float abs = Math.abs(i - i2) / this.vp;
        this.vV = i2;
        this.vU = (int) (i3 / abs);
    }

    public void a(h hVar) {
        this.vr = hVar;
    }

    public void g(View view) {
        this.vW = false;
        Timer timer = new Timer();
        timer.schedule(new d(this, view, timer), 0L, this.vU);
    }
}
