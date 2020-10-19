package com.baidu.swan.apps.aj;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes10.dex */
public final class b {
    private FrameLayout dkR = null;

    public void D(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dkR == null) {
                this.dkR = new FrameLayout(viewGroup.getContext());
                this.dkR.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dkR);
            viewGroup.addView(this.dkR, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void E(ViewGroup viewGroup) {
        if (viewGroup != null && this.dkR != null) {
            viewGroup.removeView(this.dkR);
            this.dkR = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dkR != null) {
            this.dkR.setVisibility(i);
        }
    }
}
