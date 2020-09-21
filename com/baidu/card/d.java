package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes20.dex */
public class d {
    private RelativeLayout.LayoutParams aft;
    private View afu;
    protected ak afv;
    private int insertIndex;

    public RelativeLayout.LayoutParams tD() {
        return this.aft;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.aft = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tA() {
    }

    public void b(ak akVar) {
        this.afv = akVar;
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
        return this.afu;
    }

    public void H(View view) {
        this.afu = view;
    }
}
