package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class b {
    private g BC;
    private int BN;
    private int BO;
    private int BA = 5;
    private boolean BP = false;

    public b(int i, int i2, int i3) {
        this.BN = 10;
        float abs = Math.abs(i - i2) / this.BA;
        this.BO = i2;
        this.BN = (int) (i3 / abs);
    }

    public void a(g gVar) {
        this.BC = gVar;
    }

    public void r(View view) {
        this.BP = false;
        Timer timer = new Timer();
        timer.schedule(new c(this, view, timer), 0L, this.BN);
    }
}
