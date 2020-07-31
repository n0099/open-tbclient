package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes15.dex */
public class d {
    private RelativeLayout.LayoutParams adT;
    private View adU;
    protected ai adV;
    private int insertIndex;

    public RelativeLayout.LayoutParams rN() {
        return this.adT;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.adT = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rK() {
    }

    public void b(ai aiVar) {
        this.adV = aiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rO() {
    }

    public int rP() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View rQ() {
        return this.adU;
    }

    public void H(View view) {
        this.adU = view;
    }
}
