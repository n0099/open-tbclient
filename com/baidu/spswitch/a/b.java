package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes13.dex */
public class b implements com.baidu.spswitch.a {
    private final View byK;
    private boolean byL = false;
    private boolean byM = false;

    public b(View view) {
        this.byK = view;
    }

    public int[] U(int i, int i2) {
        if (this.byL) {
            this.byK.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean dV(int i) {
        if (i == 0) {
            this.byL = false;
        }
        if (i == this.byK.getVisibility()) {
            return true;
        }
        return Oh() && i == 0;
    }

    public boolean Oh() {
        return this.byM;
    }

    @Override // com.baidu.spswitch.a
    public void NZ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Oa() {
        this.byL = true;
    }
}
