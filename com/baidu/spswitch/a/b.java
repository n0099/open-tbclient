package com.baidu.spswitch.a;

import android.view.View;
import com.baidu.spswitch.b.g;
/* loaded from: classes13.dex */
public class b implements com.baidu.spswitch.a {
    private final View aZW;
    private boolean aZY = false;
    private boolean aZZ = false;

    public b(View view) {
        this.aZW = view;
    }

    public int[] S(int i, int i2) {
        if (this.aZY) {
            this.aZW.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean dN(int i) {
        if (i == 0) {
            this.aZY = false;
        }
        if (i == this.aZW.getVisibility()) {
            return true;
        }
        return Gp() && i == 0;
    }

    public void bP(boolean z) {
        this.aZZ = z;
    }

    public void dO(int i) {
        g.f(this.aZW, i);
    }

    public boolean Gp() {
        return this.aZZ;
    }

    @Override // com.baidu.spswitch.a
    public void Gh() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Gi() {
        this.aZY = true;
    }
}
