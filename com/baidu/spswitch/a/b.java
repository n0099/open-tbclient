package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes9.dex */
public class b implements com.baidu.spswitch.a {
    private final View bQY;
    private boolean bQZ = false;
    private boolean bRa = false;

    public b(View view) {
        this.bQY = view;
    }

    public int[] ab(int i, int i2) {
        if (this.bQZ) {
            this.bQY.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean gm(int i) {
        if (i == 0) {
            this.bQZ = false;
        }
        if (i == this.bQY.getVisibility()) {
            return true;
        }
        return XJ() && i == 0;
    }

    public boolean XJ() {
        return this.bRa;
    }

    @Override // com.baidu.spswitch.a
    public void XB() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void XC() {
        this.bQZ = true;
    }
}
