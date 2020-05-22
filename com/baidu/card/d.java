package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class d {
    private View adA;
    protected ae adB;
    private RelativeLayout.LayoutParams adz;
    private int insertIndex;

    public RelativeLayout.LayoutParams ru() {
        return this.adz;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.adz = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rr() {
    }

    public void b(ae aeVar) {
        this.adB = aeVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rv() {
    }

    public int rw() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View rx() {
        return this.adA;
    }

    public void F(View view) {
        this.adA = view;
    }
}
