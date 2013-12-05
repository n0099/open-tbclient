package com.baidu.adp.widget.ScrollView;

import android.view.View;
import java.util.Timer;
/* loaded from: classes.dex */
public class c {
    private int b;
    private int c;
    private i e;

    /* renamed from: a  reason: collision with root package name */
    private int f590a = 5;
    private boolean d = false;

    public c(int i, int i2, int i3) {
        this.b = 10;
        float abs = Math.abs(i - i2) / this.f590a;
        this.c = i2;
        this.b = (int) (i3 / abs);
    }

    public void a(i iVar) {
        this.e = iVar;
    }

    public void a(View view) {
        this.d = false;
        Timer timer = new Timer();
        timer.schedule(new d(this, view, timer), 0L, this.b);
    }
}
