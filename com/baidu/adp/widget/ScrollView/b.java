package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private int IK;
    private int IL;
    private g Ix;
    private int Iv = 5;
    private boolean IM = false;

    public b(int i, int i2, int i3) {
        this.IK = 10;
        float abs = Math.abs(i - i2) / this.Iv;
        this.IL = i2;
        this.IK = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.Ix = gVar;
    }

    public void h(View view) {
        this.IM = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.IK);
    }
}
