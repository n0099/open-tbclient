package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes15.dex */
public class d {
    private RelativeLayout.LayoutParams afb;
    private View afc;
    protected aj afd;
    private int insertIndex;

    public RelativeLayout.LayoutParams ty() {
        return this.afb;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.afb = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tv() {
    }

    public void b(aj ajVar) {
        this.afd = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tz() {
    }

    public int tA() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View tB() {
        return this.afc;
    }

    public void H(View view) {
        this.afc = view;
    }
}
