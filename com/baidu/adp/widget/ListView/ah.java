package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
public class ah {
    int mDuration;
    View mView;
    private int xu;
    private com.baidu.adp.widget.ScrollView.g xv;
    private boolean xw;
    aj xx;
    private int xt = 1;
    Handler mHandler = new Handler();
    Runnable xy = new ai(this);

    public ah(Context context, int i, int i2, int i3) {
        this.xw = true;
        int abs = Math.abs(i - i2);
        this.xu = i2;
        if (abs < this.xt) {
            this.xw = false;
        }
        this.xx = new aj(this, context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.xv = gVar;
    }

    public void g(View view) {
        if (this.xw && this.xx != null) {
            this.mView = view;
            this.xx.i(Math.abs(this.xu), this.mDuration);
            this.mHandler.postDelayed(this.xy, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.xu) {
            paddingTop = this.xu;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
