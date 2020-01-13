package com.baidu.spswitch.a;

import android.view.View;
import com.baidu.spswitch.b.g;
/* loaded from: classes12.dex */
public class b implements com.baidu.spswitch.a {
    private final View aVI;
    private boolean aVK = false;
    private boolean aVL = false;

    public b(View view) {
        this.aVI = view;
    }

    public int[] S(int i, int i2) {
        if (this.aVK) {
            this.aVI.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean dx(int i) {
        if (i == 0) {
            this.aVK = false;
        }
        if (i == this.aVI.getVisibility()) {
            return true;
        }
        return DY() && i == 0;
    }

    public void bH(boolean z) {
        this.aVL = z;
    }

    public void dy(int i) {
        g.f(this.aVI, i);
    }

    public boolean DY() {
        return this.aVL;
    }

    @Override // com.baidu.spswitch.a
    public void DQ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void DR() {
        this.aVK = true;
    }
}
