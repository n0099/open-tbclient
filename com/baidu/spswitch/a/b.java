package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes19.dex */
public class b implements com.baidu.spswitch.a {
    private final View cnP;
    private boolean cnQ = false;
    private boolean cnR = false;

    public b(View view) {
        this.cnP = view;
    }

    public int[] ab(int i, int i2) {
        if (this.cnQ) {
            this.cnP.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean he(int i) {
        if (i == 0) {
            this.cnQ = false;
        }
        if (i == this.cnP.getVisibility()) {
            return true;
        }
        return acY() && i == 0;
    }

    public boolean acY() {
        return this.cnR;
    }

    @Override // com.baidu.spswitch.a
    public void acQ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void acR() {
        this.cnQ = true;
    }
}
