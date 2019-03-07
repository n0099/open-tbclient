package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class c {
    private RelativeLayout.LayoutParams Xr;
    private int Xs;
    private View Xt;
    protected x Xu;

    public RelativeLayout.LayoutParams rl() {
        return this.Xr;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.Xr = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rj() {
    }

    public void b(x xVar) {
        this.Xu = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rm() {
    }

    public int rn() {
        return this.Xs;
    }

    public void bx(int i) {
        this.Xs = i;
    }

    public View getDecorView() {
        return this.Xt;
    }

    public void I(View view) {
        this.Xt = view;
    }
}
