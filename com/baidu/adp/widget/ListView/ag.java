package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
public class ag {
    View mView;
    private int vq;
    private com.baidu.adp.widget.ScrollView.h vr;
    private boolean vs;
    ai vt;
    int vu;
    private int vp = 1;
    Handler mHandler = new Handler();
    Runnable vv = new ah(this);

    public ag(Context context, int i, int i2, int i3) {
        this.vs = true;
        int abs = Math.abs(i - i2);
        this.vq = i2;
        if (abs < this.vp) {
            this.vs = false;
        }
        this.vt = new ai(this, context);
        this.vu = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.h hVar) {
        this.vr = hVar;
    }

    public void g(View view) {
        if (this.vs && this.vt != null) {
            this.mView = view;
            this.vt.g(Math.abs(this.vq), this.vu);
            this.mHandler.postDelayed(this.vv, this.vu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.vq) {
            paddingTop = this.vq;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
