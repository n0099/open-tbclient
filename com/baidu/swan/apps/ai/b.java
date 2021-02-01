package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public final class b {
    private FrameLayout dKz = null;

    public void H(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dKz == null) {
                this.dKz = new FrameLayout(viewGroup.getContext());
                this.dKz.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dKz);
            viewGroup.addView(this.dKz, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void I(ViewGroup viewGroup) {
        if (viewGroup != null && this.dKz != null) {
            viewGroup.removeView(this.dKz);
            this.dKz = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dKz != null) {
            this.dKz.setVisibility(i);
        }
    }
}
