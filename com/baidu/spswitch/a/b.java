package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes9.dex */
public class b implements com.baidu.spswitch.a {
    private final View bRc;
    private boolean bRd = false;
    private boolean bRe = false;

    public b(View view) {
        this.bRc = view;
    }

    public int[] ab(int i, int i2) {
        if (this.bRd) {
            this.bRc.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean gm(int i) {
        if (i == 0) {
            this.bRd = false;
        }
        if (i == this.bRc.getVisibility()) {
            return true;
        }
        return XJ() && i == 0;
    }

    public boolean XJ() {
        return this.bRe;
    }

    @Override // com.baidu.spswitch.a
    public void XB() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void XC() {
        this.bRd = true;
    }
}
