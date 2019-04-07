package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class c {
    private RelativeLayout.LayoutParams Xs;
    private int Xt;
    private View Xu;
    protected x Xv;

    public RelativeLayout.LayoutParams rl() {
        return this.Xs;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.Xs = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rj() {
    }

    public void b(x xVar) {
        this.Xv = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rm() {
    }

    public int rn() {
        return this.Xt;
    }

    public void bw(int i) {
        this.Xt = i;
    }

    public View getDecorView() {
        return this.Xu;
    }

    public void I(View view) {
        this.Xu = view;
    }
}
