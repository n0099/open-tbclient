package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g Je;
    private int Jq;
    private int Jr;
    private int Jc = 5;
    private boolean Js = false;

    public b(int i, int i2, int i3) {
        this.Jq = 10;
        float abs = Math.abs(i - i2) / this.Jc;
        this.Jr = i2;
        this.Jq = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Je = gVar;
    }

    public void t(View view) {
        this.Js = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.Jq);
    }
}
