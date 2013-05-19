package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class d {
    private int b;
    private int c;
    private j e;
    private int a = 5;
    private boolean d = false;

    public d(int i, int i2, int i3) {
        this.b = 10;
        float abs = Math.abs(i - i2) / this.a;
        this.c = i2;
        this.b = (int) (i3 / abs);
    }

    public void a(j jVar) {
        this.e = jVar;
    }

    public void a(View view) {
        this.d = false;
        Timer timer = new Timer();
        timer.schedule(new e(this, view, timer), 0L, this.b);
    }
}
