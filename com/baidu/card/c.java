package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class c {
    private RelativeLayout.LayoutParams Xt;
    private int Xu;
    private View Xv;
    protected x Xw;

    public RelativeLayout.LayoutParams rl() {
        return this.Xt;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.Xt = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rj() {
    }

    public void b(x xVar) {
        this.Xw = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rm() {
    }

    public int rn() {
        return this.Xu;
    }

    public void bw(int i) {
        this.Xu = i;
    }

    public View getDecorView() {
        return this.Xv;
    }

    public void I(View view) {
        this.Xv = view;
    }
}
