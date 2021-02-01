package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes3.dex */
public class b implements com.baidu.spswitch.a {
    private final View cBA;
    private boolean cBB = false;
    private boolean cBC = false;

    public b(View view) {
        this.cBA = view;
    }

    public int[] V(int i, int i2) {
        if (this.cBB) {
            this.cBA.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean fY(int i) {
        if (i == 0) {
            this.cBB = false;
        }
        if (i == this.cBA.getVisibility()) {
            return true;
        }
        return afN() && i == 0;
    }

    public boolean afN() {
        return this.cBC;
    }

    @Override // com.baidu.spswitch.a
    public void afF() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void afG() {
        this.cBB = true;
    }
}
