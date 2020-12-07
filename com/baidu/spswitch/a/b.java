package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes6.dex */
public class b implements com.baidu.spswitch.a {
    private final View cyX;
    private boolean cyY = false;
    private boolean cyZ = false;

    public b(View view) {
        this.cyX = view;
    }

    public int[] ad(int i, int i2) {
        if (this.cyY) {
            this.cyX.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean hI(int i) {
        if (i == 0) {
            this.cyY = false;
        }
        if (i == this.cyX.getVisibility()) {
            return true;
        }
        return ahY() && i == 0;
    }

    public boolean ahY() {
        return this.cyZ;
    }

    @Override // com.baidu.spswitch.a
    public void ahQ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void ahR() {
        this.cyY = true;
    }
}
