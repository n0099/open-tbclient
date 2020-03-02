package com.baidu.spswitch.a;

import android.view.View;
import com.baidu.spswitch.b.g;
/* loaded from: classes13.dex */
public class b implements com.baidu.spswitch.a {
    private final View aZV;
    private boolean aZX = false;
    private boolean aZY = false;

    public b(View view) {
        this.aZV = view;
    }

    public int[] S(int i, int i2) {
        if (this.aZX) {
            this.aZV.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean dN(int i) {
        if (i == 0) {
            this.aZX = false;
        }
        if (i == this.aZV.getVisibility()) {
            return true;
        }
        return Gp() && i == 0;
    }

    public void bP(boolean z) {
        this.aZY = z;
    }

    public void dO(int i) {
        g.f(this.aZV, i);
    }

    public boolean Gp() {
        return this.aZY;
    }

    @Override // com.baidu.spswitch.a
    public void Gh() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Gi() {
        this.aZX = true;
    }
}
