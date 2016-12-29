package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private int CC;
    private int CD;
    private g Cq;
    private int Co = 5;
    private boolean CE = false;

    public b(int i, int i2, int i3) {
        this.CC = 10;
        float abs = Math.abs(i - i2) / this.Co;
        this.CD = i2;
        this.CC = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Cq = gVar;
    }

    public void t(View view) {
        this.CE = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.CC);
    }
}
