package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class c {
    private RelativeLayout.LayoutParams agu;
    private View agv;
    protected ak agw;
    private int insertIndex;

    public RelativeLayout.LayoutParams sT() {
        return this.agu;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.agu = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sQ() {
    }

    public void b(ak akVar) {
        this.agw = akVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sU() {
    }

    public int sV() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View sW() {
        return this.agv;
    }

    public void H(View view) {
        this.agv = view;
    }
}
