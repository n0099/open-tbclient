package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes3.dex */
public class b implements com.baidu.spswitch.a {
    private final View bLC;
    private boolean bLD = false;
    private boolean bLE = false;

    public b(View view) {
        this.bLC = view;
    }

    public int[] Z(int i, int i2) {
        if (this.bLD) {
            this.bLC.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean ep(int i) {
        if (i == 0) {
            this.bLD = false;
        }
        if (i == this.bLC.getVisibility()) {
            return true;
        }
        return RO() && i == 0;
    }

    public boolean RO() {
        return this.bLE;
    }

    @Override // com.baidu.spswitch.a
    public void RG() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void RH() {
        this.bLD = true;
    }
}
