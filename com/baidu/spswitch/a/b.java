package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes24.dex */
public class b implements com.baidu.spswitch.a {
    private final View bTc;
    private boolean bTd = false;
    private boolean bTe = false;

    public b(View view) {
        this.bTc = view;
    }

    public int[] ab(int i, int i2) {
        if (this.bTd) {
            this.bTc.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean gw(int i) {
        if (i == 0) {
            this.bTd = false;
        }
        if (i == this.bTc.getVisibility()) {
            return true;
        }
        return Ys() && i == 0;
    }

    public boolean Ys() {
        return this.bTe;
    }

    @Override // com.baidu.spswitch.a
    public void Yk() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Yl() {
        this.bTd = true;
    }
}
