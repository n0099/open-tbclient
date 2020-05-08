package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class d {
    private RelativeLayout.LayoutParams adh;
    private View adi;
    protected ad adj;
    private int insertIndex;

    public RelativeLayout.LayoutParams rn() {
        return this.adh;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.adh = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rk() {
    }

    public void b(ad adVar) {
        this.adj = adVar;
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
        return this.adi;
    }

    public void F(View view) {
        this.adi = view;
    }
}
