package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class d {
    private RelativeLayout.LayoutParams JE;
    private View JF;
    protected ad JG;
    private int insertIndex;

    public RelativeLayout.LayoutParams mG() {
        return this.JE;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.JE = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mD() {
    }

    public void b(ad adVar) {
        this.JG = adVar;
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
        return this.JF;
    }

    public void F(View view) {
        this.JF = view;
    }
}
