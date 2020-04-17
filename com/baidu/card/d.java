package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class d {
    private RelativeLayout.LayoutParams ade;
    private View adf;
    protected ad adg;
    private int insertIndex;

    public RelativeLayout.LayoutParams rn() {
        return this.ade;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.ade = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rk() {
    }

    public void b(ad adVar) {
        this.adg = adVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ro() {
    }

    public int rp() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View rq() {
        return this.adf;
    }

    public void F(View view) {
        this.adf = view;
    }
}
