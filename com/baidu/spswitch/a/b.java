package com.baidu.spswitch.a;

import android.view.View;
import com.baidu.spswitch.b.g;
/* loaded from: classes13.dex */
public class b implements com.baidu.spswitch.a {
    private final View baj;
    private boolean bal = false;
    private boolean bam = false;

    public b(View view) {
        this.baj = view;
    }

    public int[] S(int i, int i2) {
        if (this.bal) {
            this.baj.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean dN(int i) {
        if (i == 0) {
            this.bal = false;
        }
        if (i == this.baj.getVisibility()) {
            return true;
        }
        return Gu() && i == 0;
    }

    public void bQ(boolean z) {
        this.bam = z;
    }

    public void dO(int i) {
        g.f(this.baj, i);
    }

    public boolean Gu() {
        return this.bam;
    }

    @Override // com.baidu.spswitch.a
    public void Gm() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Gn() {
        this.bal = true;
    }
}
