package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class c {
    private RelativeLayout.LayoutParams ahE;
    private View ahF;
    protected ak ahG;
    private int insertIndex;

    public RelativeLayout.LayoutParams sQ() {
        return this.ahE;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.ahE = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sN() {
    }

    public void b(ak akVar) {
        this.ahG = akVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sR() {
    }

    public int sS() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View sT() {
        return this.ahF;
    }

    public void H(View view) {
        this.ahF = view;
    }
}
