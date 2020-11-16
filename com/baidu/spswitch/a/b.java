package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes6.dex */
public class b implements com.baidu.spswitch.a {
    private final View csb;
    private boolean csc = false;
    private boolean csd = false;

    public b(View view) {
        this.csb = view;
    }

    public int[] ab(int i, int i2) {
        if (this.csc) {
            this.csb.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean hk(int i) {
        if (i == 0) {
            this.csc = false;
        }
        if (i == this.csb.getVisibility()) {
            return true;
        }
        return aeQ() && i == 0;
    }

    public boolean aeQ() {
        return this.csd;
    }

    @Override // com.baidu.spswitch.a
    public void aeI() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void aeJ() {
        this.csc = true;
    }
}
