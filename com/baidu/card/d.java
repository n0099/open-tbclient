package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes8.dex */
public class d {
    private RelativeLayout.LayoutParams Kg;
    private View Kh;
    protected ad Ki;
    private int insertIndex;

    public RelativeLayout.LayoutParams mV() {
        return this.Kg;
    }

    public void a(RelativeLayout.LayoutParams layoutParams) {
        this.Kg = layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mS() {
    }

    public void b(ad adVar) {
        this.Ki = adVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mW() {
    }

    public int mX() {
        return this.insertIndex;
    }

    public void setInsertIndex(int i) {
        this.insertIndex = i;
    }

    public View mY() {
        return this.Kh;
    }

    public void F(View view) {
        this.Kh = view;
    }
}
