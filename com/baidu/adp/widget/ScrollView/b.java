package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private int CB;
    private int CC;
    private g Cp;
    private int Cn = 5;
    private boolean CD = false;

    public b(int i, int i2, int i3) {
        this.CB = 10;
        float abs = Math.abs(i - i2) / this.Cn;
        this.CC = i2;
        this.CB = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Cp = gVar;
    }

    public void t(View view) {
        this.CD = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.CB);
    }
}
