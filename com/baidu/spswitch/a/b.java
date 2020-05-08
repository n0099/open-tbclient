package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes13.dex */
public class b implements com.baidu.spswitch.a {
    private final View byP;
    private boolean byQ = false;
    private boolean byR = false;

    public b(View view) {
        this.byP = view;
    }

    public int[] U(int i, int i2) {
        if (this.byQ) {
            this.byP.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean dV(int i) {
        if (i == 0) {
            this.byQ = false;
        }
        if (i == this.byP.getVisibility()) {
            return true;
        }
        return Og() && i == 0;
    }

    public boolean Og() {
        return this.byR;
    }

    @Override // com.baidu.spswitch.a
    public void NY() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void NZ() {
        this.byQ = true;
    }
}
