package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
public class ah {
    int mDuration;
    View mView;
    private int xr;
    private com.baidu.adp.widget.ScrollView.g xs;
    private boolean xt;
    aj xu;
    private int xq = 1;
    Handler mHandler = new Handler();
    Runnable xv = new ai(this);

    public ah(Context context, int i, int i2, int i3) {
        this.xt = true;
        int abs = Math.abs(i - i2);
        this.xr = i2;
        if (abs < this.xq) {
            this.xt = false;
        }
        this.xu = new aj(this, context);
        this.mDuration = i3;
    }

    public void a(com.baidu.adp.widget.ScrollView.g gVar) {
        this.xs = gVar;
    }

    public void g(View view) {
        if (this.xt && this.xu != null) {
            this.mView = view;
            this.xu.i(Math.abs(this.xr), this.mDuration);
            this.mHandler.postDelayed(this.xv, this.mDuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean move(int i) {
        boolean z = true;
        int paddingTop = this.mView.getPaddingTop() - Math.abs(i);
        if (paddingTop <= this.xr) {
            paddingTop = this.xr;
            z = false;
        }
        this.mView.setPadding(this.mView.getPaddingLeft(), paddingTop, this.mView.getPaddingRight(), this.mView.getPaddingBottom());
        return z;
    }
}
