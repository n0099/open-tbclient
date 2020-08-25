package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes15.dex */
public class d {
    private RelativeLayout.LayoutParams aeZ;
    private View afa;
    protected aj afb;
    private int insertIndex;

    public RelativeLayout.LayoutParams ty() {
        return this.aeZ;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.aeZ = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tv() {
    }

    public void b(aj ajVar) {
        this.afb = ajVar;
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
        return this.afa;
    }

    public void H(View view) {
        this.afa = view;
    }
}
