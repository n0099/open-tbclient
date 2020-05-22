package com.baidu.spswitch.a;

import android.view.View;
/* loaded from: classes13.dex */
public class b implements com.baidu.spswitch.a {
    private final View bGs;
    private boolean bGt = false;
    private boolean bGu = false;

    public b(View view) {
        this.bGs = view;
    }

    public int[] X(int i, int i2) {
        if (this.bGt) {
            this.bGs.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean eb(int i) {
        if (i == 0) {
            this.bGt = false;
        }
        if (i == this.bGs.getVisibility()) {
            return true;
        }
        return Qt() && i == 0;
    }

    public boolean Qt() {
        return this.bGu;
    }

    @Override // com.baidu.spswitch.a
    public void Ql() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Qm() {
        this.bGt = true;
    }
}
