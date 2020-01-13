package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes6.dex */
public class d {
    private RelativeLayout.LayoutParams JK;
    private View JL;
    protected ad JM;
    private int insertIndex;

    public RelativeLayout.LayoutParams mG() {
        return this.JK;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.JK = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mD() {
    }

    public void b(ad adVar) {
        this.JM = adVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mH() {
    }

    public int mI() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View mJ() {
        return this.JL;
    }

    public void F(View view) {
        this.JL = view;
    }
}
