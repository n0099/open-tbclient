package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    x f578a;
    int b;
    View c;
    private int g;
    private com.baidu.adp.widget.ScrollView.i h;
    private boolean i;
    private int f = 1;
    Handler d = new Handler();
    Runnable e = new w(this);

    public v(Context context, int i, int i2, int i3) {
        this.i = true;
        int abs = Math.abs(i - i2);
        this.g = i2;
        if (abs < this.f) {
            this.i = false;
        }
        this.f578a = new x(this, context);
        this.b = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.i iVar) {
        this.h = iVar;
    }

    public void a(View view) {
        if (this.i && this.f578a != null) {
            this.c = view;
            this.f578a.a(Math.abs(this.g), this.b);
            this.d.postDelayed(this.e, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        boolean z = true;
        int paddingTop = this.c.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.g) {
            paddingTop = this.g;
            z = false;
        }
        this.c.setPadding(this.c.getPaddingLeft(), paddingTop, this.c.getPaddingRight(), this.c.getPaddingBottom());
        return z;
    }
}
