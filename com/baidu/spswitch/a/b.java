package com.baidu.spswitch.a;

import android.view.View;
import com.baidu.spswitch.b.g;
/* loaded from: classes13.dex */
public class b implements com.baidu.spswitch.a {
    private final View aZU;
    private boolean aZW = false;
    private boolean aZX = false;

    public b(View view) {
        this.aZU = view;
    }

    public int[] S(int i, int i2) {
        if (this.aZW) {
            this.aZU.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean dN(int i) {
        if (i == 0) {
            this.aZW = false;
        }
        if (i == this.aZU.getVisibility()) {
            return true;
        }
        return Gn() && i == 0;
    }

    public void bP(boolean z) {
        this.aZX = z;
    }

    public void dO(int i) {
        g.f(this.aZU, i);
    }

    public boolean Gn() {
        return this.aZX;
    }

    @Override // com.baidu.spswitch.a
    public void Gf() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Gg() {
        this.aZW = true;
    }
}
