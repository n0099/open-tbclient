package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes21.dex */
public class d {
    private RelativeLayout.LayoutParams afL;
    private View afM;
    protected ak afN;
    private int insertIndex;

    public RelativeLayout.LayoutParams tD() {
        return this.afL;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.afL = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tA() {
    }

    public void b(ak akVar) {
        this.afN = akVar;
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
        return this.afM;
    }

    public void H(View view) {
        this.afM = view;
    }
}
