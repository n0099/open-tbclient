package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes3.dex */
public class b implements com.baidu.spswitch.a {
    private final View cDa;
    private boolean cDb = false;
    private boolean cDc = false;

    public b(View view) {
        this.cDa = view;
    }

    public int[] V(int i, int i2) {
        if (this.cDb) {
            this.cDa.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean fZ(int i) {
        if (i == 0) {
            this.cDb = false;
        }
        if (i == this.cDa.getVisibility()) {
            return true;
        }
        return afQ() && i == 0;
    }

    public boolean afQ() {
        return this.cDc;
    }

    @Override // com.baidu.spswitch.a
    public void afI() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void afJ() {
        this.cDb = true;
    }
}
