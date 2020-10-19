package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes19.dex */
public class b implements com.baidu.spswitch.a {
    private final View cfq;
    private boolean cfr = false;
    private boolean cfs = false;

    public b(View view) {
        this.cfq = view;
    }

    public int[] aa(int i, int i2) {
        if (this.cfr) {
            this.cfq.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean gT(int i) {
        if (i == 0) {
            this.cfr = false;
        }
        if (i == this.cfq.getVisibility()) {
            return true;
        }
        return abe() && i == 0;
    }

    public boolean abe() {
        return this.cfs;
    }

    @Override // com.baidu.spswitch.a
    public void aaW() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void aaX() {
        this.cfr = true;
    }
}
