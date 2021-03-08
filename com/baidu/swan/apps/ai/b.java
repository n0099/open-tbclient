package com.baidu.swan.apps.ai;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public final class b {
    private FrameLayout dMa = null;

    public void H(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.dMa == null) {
                this.dMa = new FrameLayout(viewGroup.getContext());
                this.dMa.setBackgroundResource(a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.dMa);
            viewGroup.addView(this.dMa, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void I(ViewGroup viewGroup) {
        if (viewGroup != null && this.dMa != null) {
            viewGroup.removeView(this.dMa);
            this.dMa = null;
        }
    }

    public void setVisibility(int i) {
        if (this.dMa != null) {
            this.dMa.setVisibility(i);
        }
    }
}
