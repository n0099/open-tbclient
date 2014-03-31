package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
public final class y {
    aa a;
    int b;
    View c;
    private int g;
    private com.baidu.adp.widget.ScrollView.i h;
    private boolean i;
    private int f = 1;
    Handler d = new Handler();
    Runnable e = new z(this);

    public y(Context context, int i, int i2, int i3) {
        this.i = true;
        int abs = Math.abs(0 - i2);
        this.g = i2;
        if (abs < this.f) {
            this.i = false;
        }
        this.a = new aa(this, context);
        this.b = i3;
    }

    public final void a(com.baidu.adp.widget.ScrollView.i iVar) {
        this.h = iVar;
    }

    public final void a(View view) {
        if (this.i && this.a != null) {
            this.c = view;
            this.a.a(Math.abs(this.g), this.b);
            this.d.postDelayed(this.e, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(y yVar, int i) {
        boolean z = true;
        int paddingTop = yVar.c.getPaddingTop() - Math.abs(i);
        if (paddingTop <= yVar.g) {
            paddingTop = yVar.g;
            z = false;
        }
        yVar.c.setPadding(yVar.c.getPaddingLeft(), paddingTop, yVar.c.getPaddingRight(), yVar.c.getPaddingBottom());
        return z;
    }
}
