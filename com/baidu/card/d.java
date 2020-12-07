package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes21.dex */
public class d {
    private RelativeLayout.LayoutParams agM;
    private View agN;
    protected ak agO;
    private int insertIndex;

    public RelativeLayout.LayoutParams tG() {
        return this.agM;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.agM = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tD() {
    }

    public void b(ak akVar) {
        this.agO = akVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tH() {
    }

    public int tI() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View tJ() {
        return this.agN;
    }

    public void H(View view) {
        this.agN = view;
    }
}
