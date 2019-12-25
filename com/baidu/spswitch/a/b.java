package com.baidu.spswitch.a;

import android.view.View;
import com.baidu.spswitch.b.g;
/* loaded from: classes11.dex */
public class b implements com.baidu.spswitch.a {
    private final View aUQ;
    private boolean aUS = false;
    private boolean aUT = false;

    public b(View view) {
        this.aUQ = view;
    }

    public int[] O(int i, int i2) {
        if (this.aUS) {
            this.aUQ.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        return new int[]{i, i2};
    }

    public boolean dw(int i) {
        if (i == 0) {
            this.aUS = false;
        }
        if (i == this.aUQ.getVisibility()) {
            return true;
        }
        return DC() && i == 0;
    }

    public void bC(boolean z) {
        this.aUT = z;
    }

    public void dx(int i) {
        g.f(this.aUQ, i);
    }

    public boolean DC() {
        return this.aUT;
    }

    @Override // com.baidu.spswitch.a
    public void Du() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.baidu.spswitch.a
    public void Dv() {
        this.aUS = true;
    }
}
