package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes3.dex */
public class b implements com.baidu.spswitch.a {
    private final View cDQ;
    private boolean cDR = false;
    private boolean cDS = false;

    public b(View view) {
        this.cDQ = view;
    }

    public int[] Y(int i, int i2) {
        if (this.cDR) {
            this.cDQ.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean hC(int i) {
        if (i == 0) {
            this.cDR = false;
        }
        if (i == this.cDQ.getVisibility()) {
            return true;
        }
        return ajh() && i == 0;
    }

    public boolean ajh() {
        return this.cDS;
    }

    @Override // com.baidu.spswitch.a
    public void aiZ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void aja() {
        this.cDR = true;
    }
}
