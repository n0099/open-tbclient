package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes20.dex */
public class d {
    private RelativeLayout.LayoutParams afQ;
    private View afR;
    protected ak afS;
    private int insertIndex;

    public RelativeLayout.LayoutParams tD() {
        return this.afQ;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.afQ = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tA() {
    }

    public void b(ak akVar) {
        this.afS = akVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tE() {
    }

    public int tF() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View tG() {
        return this.afR;
    }

    public void H(View view) {
        this.afR = view;
    }
}
