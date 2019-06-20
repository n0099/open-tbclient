package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class c {
    private RelativeLayout.LayoutParams Vj;
    private int Vk;
    private View Vl;
    protected x Vm;

    public RelativeLayout.LayoutParams qg() {
        return this.Vj;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.Vj = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qe() {
    }

    public void b(x xVar) {
        this.Vm = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qh() {
    }

    public int qi() {
        return this.Vk;
    }

    public void bp(int i) {
        this.Vk = i;
    }

    public View getDecorView() {
        return this.Vl;
    }

    public void I(View view) {
        this.Vl = view;
    }
}
