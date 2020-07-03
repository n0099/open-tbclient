package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class d {
    private RelativeLayout.LayoutParams aed;
    private View aee;
    protected ai aef;
    private int insertIndex;

    public RelativeLayout.LayoutParams rL() {
        return this.aed;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.aed = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rI() {
    }

    public void b(ai aiVar) {
        this.aef = aiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rM() {
    }

    public int rN() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View rO() {
        return this.aee;
    }

    public void F(View view) {
        this.aee = view;
    }
}
