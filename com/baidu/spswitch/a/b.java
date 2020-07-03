package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes13.dex */
public class b implements com.baidu.spswitch.a {
    private final View bLg;
    private boolean bLh = false;
    private boolean bLi = false;

    public b(View view) {
        this.bLg = view;
    }

    public int[] Z(int i, int i2) {
        if (this.bLh) {
            this.bLg.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean eo(int i) {
        if (i == 0) {
            this.bLh = false;
        }
        if (i == this.bLg.getVisibility()) {
            return true;
        }
        return Rz() && i == 0;
    }

    public boolean Rz() {
        return this.bLi;
    }

    @Override // com.baidu.spswitch.a
    public void Rr() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Rs() {
        this.bLh = true;
    }
}
