package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes19.dex */
public class b implements com.baidu.spswitch.a {
    private final View ctN;
    private boolean ctO = false;
    private boolean ctP = false;

    public b(View view) {
        this.ctN = view;
    }

    public int[] ab(int i, int i2) {
        if (this.ctO) {
            this.ctN.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean ho(int i) {
        if (i == 0) {
            this.ctO = false;
        }
        if (i == this.ctN.getVisibility()) {
            return true;
        }
        return afy() && i == 0;
    }

    public boolean afy() {
        return this.ctP;
    }

    @Override // com.baidu.spswitch.a
    public void afq() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void afr() {
        this.ctO = true;
    }
}
