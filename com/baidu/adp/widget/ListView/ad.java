package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
public class ad {
    private int Ij;
    private com.baidu.adp.widget.ScrollView.g Ik;
    private boolean Il;
    af Im;
    int mDuration;
    View mView;
    private int Ii = 1;
    Handler mHandler = new Handler();
    Runnable In = new ae(this);

    public ad(Context context, int i, int i2, int i3) {
        this.Il = true;
        int abs = Math.abs(i - i2);
        this.Ij = i2;
        if (abs < this.Ii) {
            this.Il = false;
        }
        this.Im = new af(this, context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.Ik = gVar;
    }

    public void g(View view) {
        if (this.Il && this.Im != null) {
            this.mView = view;
            this.Im.h(Math.abs(this.Ij), this.mDuration);
            this.mHandler.postDelayed(this.In, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.Ij) {
            paddingTop = this.Ij;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
