package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class c {
    private RelativeLayout.LayoutParams Vk;
    private int Vl;
    private View Vm;
    protected x Vn;

    public RelativeLayout.LayoutParams qg() {
        return this.Vk;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.Vk = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qe() {
    }

    public void b(x xVar) {
        this.Vn = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qh() {
    }

    public int qi() {
        return this.Vl;
    }

    public void bp(int i) {
        this.Vl = i;
    }

    public View getDecorView() {
        return this.Vm;
    }

    public void I(View view) {
        this.Vm = view;
    }
}
