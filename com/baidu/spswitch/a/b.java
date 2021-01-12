package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes3.dex */
public class b implements com.baidu.spswitch.a {
    private final View cze;
    private boolean czf = false;
    private boolean czg = false;

    public b(View view) {
        this.cze = view;
    }

    public int[] Y(int i, int i2) {
        if (this.czf) {
            this.cze.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean fV(int i) {
        if (i == 0) {
            this.czf = false;
        }
        if (i == this.cze.getVisibility()) {
            return true;
        }
        return afo() && i == 0;
    }

    public boolean afo() {
        return this.czg;
    }

    @Override // com.baidu.spswitch.a
    public void afg() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void afh() {
        this.czf = true;
    }
}
