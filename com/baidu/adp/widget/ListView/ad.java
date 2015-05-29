package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
public class ad {
    private int Ib;
    private com.baidu.adp.widget.ScrollView.g Ic;
    private boolean Id;
    af Ie;
    int mDuration;
    View mView;
    private int Ia = 1;
    Handler mHandler = new Handler();
    Runnable If = new ae(this);

    public ad(Context context, int i, int i2, int i3) {
        this.Id = true;
        int abs = Math.abs(i - i2);
        this.Ib = i2;
        if (abs < this.Ia) {
            this.Id = false;
        }
        this.Ie = new af(this, context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Ic = gVar;
    }

    public void g(View view) {
        if (this.Id && this.Ie != null) {
            this.mView = view;
            this.Ie.h(Math.abs(this.Ib), this.mDuration);
            this.mHandler.postDelayed(this.If, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Ib) {
            paddingTop = this.Ib;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
