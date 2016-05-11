package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g zA;
    private int zM;
    private int zN;
    private int zy = 5;
    private boolean zO = false;

    public b(int i, int i2, int i3) {
        this.zM = 10;
        float abs = Math.abs(i - i2) / this.zy;
        this.zN = i2;
        this.zM = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.zA = gVar;
    }

    public void t(View view) {
        this.zO = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.zM);
    }
}
